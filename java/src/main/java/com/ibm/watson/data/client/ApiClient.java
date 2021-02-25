/*
 * Copyright 2020 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.data.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.data.client.api.AuthorizationApi;
import com.ibm.watson.data.client.auth.Authentication;
import com.ibm.watson.data.client.auth.HttpBearerAuth;

import java.io.*;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.*;
import java.util.Map.Entry;

import com.ibm.watson.data.client.model.LoginCredentials;
import com.ibm.watson.data.client.model.LoginResponse;
import com.ibm.watson.data.client.serde.DateTimeDeserializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.*;

/**
 * Base client for invoking API endpoints.
 */
public class ApiClient {

    private static final Log log = LogFactory.getLog(ApiClient.class);

    public static final DateFormat DEFAULT_DATE_FORMAT = DateTimeDeserializer.DATE_FORMAT_MILLI;

    public enum CollectionFormat {
        CSV(","),
        TSV("\t"),
        SSV(" "),
        PIPES("|"),
        MULTI(null);

        private final String separator;
        CollectionFormat(String separator) { this.separator = separator; }

        private String collectionToString(Collection<?> collection) {
            return StringUtils.collectionToDelimitedString(collection, separator);
        }
    }

    private final HttpHeaders defaultHeaders = new HttpHeaders();
    private final MultiValueMap<String, String> defaultCookies = new LinkedMultiValueMap<>();

    private String basePath = "http://localhost";

    // We need RestTemplate for uploading files, just far too complicated with WebClient
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    private String username;
    private String password;
    private String apiKey;

    private Authentication authentication;

    private final ObjectMapper mapper;

    /**
     * Constructs a base ApiClient
     * @param disableSSLVerification will disable SSL verification if set to true
     */
    public ApiClient(boolean disableSSLVerification) {
        this(disableSSLVerification, 1);
    }

    /**
     * Constructs a base ApiClient
     * @param disableSSLVerification will disable SSL verification if set to true
     * @param bufferSizeInMb maximum size of buffer to allow for WebClient
     */
    public ApiClient(boolean disableSSLVerification, int bufferSizeInMb) {
        mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNullableModule jnm = new JsonNullableModule();
        mapper.registerModule(jnm);

        this.webClient = buildWebClient(mapper, bufferSizeInMb, disableSSLVerification);
        this.restTemplate = buildRestTemplate(mapper, disableSSLVerification);
        this.init();
    }

    protected void init() {
        // Nothing to do, at this point...
    }

    /**
     * Build the WebClient used to make HTTP requests.
     * @param mapper object mapper
     * @param bufferSizeInMb maximum size of buffer to allow for WebClient
     * @param disableSSLVerification set to true to disable SSL verification
     * @return WebClient
     */
    public static WebClient buildWebClient(ObjectMapper mapper, int bufferSizeInMb, boolean disableSSLVerification) {
        ExchangeStrategies strategies =
                ExchangeStrategies.builder()
                        .codecs(clientDefaultCodecsConfigurer -> {
                            clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonEncoder(
                                    new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON));
                            clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonDecoder(
                                    new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON));
                            clientDefaultCodecsConfigurer.defaultCodecs().maxInMemorySize(bufferSizeInMb * 1024 * 1024);
                        })
                        .build();
        WebClient.Builder webClient;
        if (disableSSLVerification) {
            try {
                SslContext sslContext = SslContextBuilder
                        .forClient()
                        .trustManager(InsecureTrustManagerFactory.INSTANCE)
                        .build();
                HttpClient httpClient = HttpClient.create().secure(opt -> opt.sslContext(sslContext));
                ClientHttpConnector httpConnector = new ReactorClientHttpConnector(httpClient);
                webClient = WebClient.builder().clientConnector(httpConnector);
            } catch (SSLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            webClient = WebClient.builder();
        }
        webClient.exchangeStrategies(strategies);
        return webClient
                //.filter(logRequest())
                //.filter(logResponse())
                .build();
    }

    /**
     * Build the RestTemplate used to make multi-part (file-inclusive) HTTP requests.
     * @param mapper object mapper
     * @param disableSSLVerification set to true to disable SSL verification
     * @return RestTemplate
     */
    public static RestTemplate buildRestTemplate(ObjectMapper mapper, boolean disableSSLVerification) {
        if (disableSSLVerification) {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) { }
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) { }
                    }
            };
            // Install the all-trusting trust manager
            try {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier ((hostname, session) -> true);
            } catch (GeneralSecurityException e) {
                System.err.println("Something went wrong trying to disable SSL.");
                e.printStackTrace();
            }
        }
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(0, converter);
        return template;
    }

    /**
     * Get the current base path
     * @return String the base path
     */
    public String getBasePath() { return basePath; }

    /**
     * Set the base path, which should include the host
     * @param basePath the base path
     * @return ApiClient this client
     */
    public ApiClient setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    /**
     * Set the base credentials: username and password
     * This should only be done AFTER first setting the base path of the client
     *
     * @param username of the user
     * @param password of the user
     * @return ApiClient this client
     */
    public ApiClient setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
        setBearerFromUsernameAndPassword();
        return this;
    }

    /**
     * Save the contents of a DataBuffer into a file using the path provided.
     * @param path of the file to write
     * @param contents that should be written to the file
     * @return Path that was written, or null if no file was written
     */
    public static Path saveBufferAsFile(String path, Mono<DataBuffer> contents) {
        final Path location = FileSystems.getDefault().getPath(path);
        DataBufferUtils.write(contents, location).block();
        return location;
    }

    /**
     * Retrieve the contents of a DataBuffer as an object of the specified type.
     * Note: there is the potential for this to consume a very large amount of memory, depending on the size
     * of the data buffer (object) being translated.
     * @param contents that should be transformed into an object
     * @param type of object into which to transform
     * @param <T> of object into which to transform
     * @return an object of the requested type
     * @throws IOException if there is any problem during the transformation
     */
    public <T> T getBufferAsObject(Mono<DataBuffer> contents, TypeReference<T> type) throws IOException {
        DataBuffer buffer = contents.block();
        if (buffer != null) {
            return mapper.readValue(buffer.asInputStream(true), type);
        }
        return null;
    }

    private void setBearerFromUsernameAndPassword() {
        AuthorizationApi auth = new AuthorizationApi(this);
        LoginCredentials cred = new LoginCredentials();
        cred.setUsername(username);
        cred.setPassword(password);
        setBearerToken(getTokenFromLogin(auth.getAuthorizationToken(cred)));
    }

    /**
     * Set the base credentials: api key
     * @param apiKey for connectivity
     * @return ApiClient this client
     */
    public ApiClient setCredentials(String apiKey) {
        this.apiKey = apiKey;
        setBearerFromApiKey();
        return this;
    }

    private void setBearerFromApiKey() {
        AuthorizationApi auth = new AuthorizationApi(this);
        setBearerToken(getTokenFromLogin(auth.getAuthorizationToken(apiKey)));
    }

    private String getTokenFromLogin(Mono<LoginResponse> login) {
        LoginResponse response = login.block();
        if (response != null) {
            return response.getToken();
        }
        return null;
    }

    // TODO: implement automated retry logic for timeouts (expired tokens)
    /*
     * RETRY LOGIC: when timed out, a 401 response code may be given by the API endpoints, and a response body like
     * the following:
     *
     * {
     *     "trace": "jr423reu2dnxgd256w5o6y4z",
     *     "errors": [
     *         {
     *             "code": "not_authenticated",
     *             "message": "CATSV5079E: The access token has expired."
     *         }
     *     ]
     * }
     *
     * or a 400 response code, and a response body like the following (so it may depend on the API endpoint?):
     *
     * {
     *     "code": 400,
     *     "error": "Bad Request",
     *     "reason": "Missing or Invalid Data",
     *     "message": "jwt expired"
     * }
     */

    /**
     * Helper method to set access token for the first Bearer authentication.
     * @param bearerToken Bearer token
     */
    private void setBearerToken(String bearerToken) {
        HttpBearerAuth bearerAuth = new HttpBearerAuth("Bearer");
        bearerAuth.setBearerToken(bearerToken);
        authentication = bearerAuth;
    }

    /**
     * Format the given Date object into string.
     * @param date to format
     * @return String formatted date
     */
    public String formatDate(Date date) { return DEFAULT_DATE_FORMAT.format(date); }

    /**
     * Format the given parameter object into string.
     * @param param the object to convert
     * @return String the parameter represented as a String
     */
    public String parameterToString(Object param) {
        if (param == null) {
            return "";
        } else if (param instanceof Date) {
            return formatDate((Date)param);
        } else if (param instanceof Collection) {
            StringBuilder b = new StringBuilder();
            for (Object o : (Collection<?>)param) {
                if (b.length() > 0) {
                    b.append(",");
                }
                b.append(String.valueOf(o));
            }
            return b.toString();
        } else {
            return String.valueOf(param);
        }
    }

    /**
     * Converts a parameter to a {@link MultiValueMap} for use in REST requests
     * @param collectionFormat The format to convert to
     * @param name The name of the parameter
     * @param value The parameter's value
     * @return a Map containing the String value(s) of the input parameter
     */
    public MultiValueMap<String, String> parameterToMultiValueMap(CollectionFormat collectionFormat, String name, Object value) {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        if (name == null || name.isEmpty() || value == null) {
            return params;
        }

        if (collectionFormat == null) {
            collectionFormat = CollectionFormat.CSV;
        }

        Collection<?> valueCollection;
        if (value instanceof Collection) {
            valueCollection = (Collection<?>)value;
        } else {
            params.add(name, parameterToString(value));
            return params;
        }

        if (valueCollection.isEmpty()) {
            return params;
        }

        if (collectionFormat.equals(CollectionFormat.MULTI)) {
            for (Object item : valueCollection) {
                params.add(name, parameterToString(item));
            }
            return params;
        }

        List<String> values = new ArrayList<>();
        for (Object o : valueCollection) {
            values.add(parameterToString(o));
        }
        params.add(name, collectionFormat.collectionToString(values));

        return params;
    }

    /**
     * Check if the given MIME is a JSON MIME.
     * JSON MIME examples:
     *     application/json
     *     application/json; charset=UTF8
     *     APPLICATION/JSON
     * @param mediaType the input MediaType
     * @return boolean true if the MediaType represents JSON, false otherwise
     */
    public boolean isJsonMime(MediaType mediaType) {
        return mediaType != null &&
                (MediaType.APPLICATION_JSON.isCompatibleWith(mediaType) ||
                        mediaType.getSubtype().matches("^.*\\+json[;]?\\s*$"));
    }

    /**
     * Select the Accept header's value from the given accepts array:
     *     if JSON exists in the given array, use it;
     *     otherwise use all of them (joining into a string)
     *
     * @param accepts The accepts array to select from
     * @return List The list of MediaTypes to use for the Accept header
     */
    public List<MediaType> selectHeaderAccept(String[] accepts) {
        if (accepts.length == 0) {
            return null;
        }
        for (String accept : accepts) {
            MediaType mediaType = MediaType.parseMediaType(accept);
            if (isJsonMime(mediaType)) {
                return Collections.singletonList(mediaType);
            }
        }
        return MediaType.parseMediaTypes(
                StringUtils.arrayToCommaDelimitedString(accepts));
    }

    /**
     * Select the Content-Type header's value from the given array:
     *     if JSON exists in the given array, use it;
     *     otherwise use the first one of the array.
     *
     * @param contentTypes The Content-Type array to select from
     * @return MediaType The Content-Type header to use. If the given array is
     *     empty, JSON will be used.
     */
    public MediaType selectHeaderContentType(String[] contentTypes) {
        if (contentTypes.length == 0) {
            return MediaType.APPLICATION_JSON;
        }
        for (String contentType : contentTypes) {
            MediaType mediaType = MediaType.parseMediaType(contentType);
            if (isJsonMime(mediaType)) {
                return mediaType;
            }
        }
        return MediaType.parseMediaType(contentTypes[0]);
    }

    /**
     * Select the body to use for the request
     * @param obj the body object
     * @param formParams the form parameters
     * @param contentType the content type of the request
     * @return Object the selected body
     */
    protected BodyInserter<?, ? super ClientHttpRequest> selectBody(Object obj, MultiValueMap<String, Object> formParams, MediaType contentType) {
        if (MediaType.APPLICATION_FORM_URLENCODED.equals(contentType)) {
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            formParams.toSingleValueMap().forEach((key, value) -> map.add(key, String.valueOf(value)));
            return BodyInserters.fromFormData(map);
        } else if (MediaType.MULTIPART_FORM_DATA.equals(contentType)) {
            return BodyInserters.fromMultipartData(formParams);
        } else {
            return obj != null ? BodyInserters.fromValue(obj) : null;
        }
    }

    /**
     * Invoke API by sending HTTP request with the given options.
     *
     * @param <T> the return type to use
     * @param path The sub-path of the HTTP URL
     * @param method The request method
     * @param pathParams The path parameters
     * @param queryParams The query parameters
     * @param body The request body object
     * @param headerParams The header parameters
     * @param cookieParams The cookie parameters
     * @param formParams The form parameters
     * @param accept The request's Accept header
     * @param contentType The request's Content-Type header
     * @param returnType The return type into which to deserialize the response
     * @return The response body in chosen type
     */
    public <T> Mono<T> invokeAPI(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, Object body,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType, ParameterizedTypeReference<T> returnType) throws RestClientException {
        return invokeAPI(path, method, pathParams, queryParams, body,
                headerParams, cookieParams, formParams, accept, contentType,
                returnType, false);
    }

    /**
     * Invoke API by sending HTTP request with the given options.
     *
     * @param <T> the return type to use
     * @param path The sub-path of the HTTP URL
     * @param method The request method
     * @param pathParams The path parameters
     * @param queryParams The query parameters
     * @param body The request body object
     * @param headerParams The header parameters
     * @param cookieParams The cookie parameters
     * @param formParams The form parameters
     * @param accept The request's Accept header
     * @param contentType The request's Content-Type header
     * @param returnType The return type into which to deserialize the response
     * @param encoded true if the parameters are already URL-encoded, false (default) otherwise
     * @return The response body in chosen type
     */
    public <T> Mono<T> invokeAPI(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, Object body,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType, ParameterizedTypeReference<T> returnType,
            boolean encoded) throws RestClientException {
        final WebClient.RequestBodySpec requestBuilder = prepareRequest(
                path, method, pathParams, queryParams, body, headerParams, cookieParams,
                formParams, accept, contentType, encoded);
        return requestBuilder.retrieve().bodyToMono(returnType);
    }

    /**
     * Invoke API by sending HTTP request with the given options, where no response is expected (but other details
     * like headers are of relevance).
     *
     * @param path The sub-path of the HTTP URL
     * @param method The request method
     * @param pathParams The path parameters
     * @param queryParams The query parameters
     * @param body The request body object
     * @param headerParams The header parameters
     * @param cookieParams The cookie parameters
     * @param formParams The form parameters
     * @param accept The request's Accept header
     * @param contentType The request's Content-Type header
     * @return The response body in chosen type
     */
    public Mono<ResponseEntity<Void>> invokeAPI(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, Object body,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType) throws RestClientException {
        final WebClient.RequestBodySpec requestBuilder = prepareRequest(
                path, method, pathParams, queryParams, body, headerParams, cookieParams,
                formParams, accept, contentType);
        return requestBuilder.retrieve().toBodilessEntity();
    }

    /**
     * Invoke API by sending HTTP request with the given options, when a file needs to be uploaded as part of
     * the request.
     *
     * @param path the sub-path of the HTTP URL
     * @param method the request method
     * @param pathParams the path parameters
     * @param queryParams the query parameters
     * @param file the file to be uploaded
     * @param headerParams the header parameters
     * @param cookieParams the cookies
     * @param formParams the form parameters
     * @param accept the request's Accept header
     * @param contentType the request's Content-Type header
     * @param returnType the return type into which to deserialize the response
     * @param <T> the type of the response
     * @return The response body in chosen type
     */
    public <T> ResponseEntity<T> invokeFileUploadAPI(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, File file,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType, ParameterizedTypeReference<T> returnType) {

        updateParamsForAuth(queryParams, headerParams, cookieParams);

        headerParams.setContentType(contentType);
        headerParams.setAccept(accept);
        // TODO: not sure if this is how cookies should really be added?
        headerParams.addAll(cookieParams);

        // Add the file to the multi-part form request
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(file));

        // TODO: not sure if this is how form parameters should really be added?
        for (Entry<String, List<Object>> entry : formParams.entrySet()) {
            String key = entry.getKey();
            List<Object> values = entry.getValue();
            body.add(key, values);
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headerParams);
        String url = expandPathForRestTemplate(path, pathParams, queryParams);
        return restTemplate.exchange(url, method, requestEntity, returnType);

    }

    /**
     * Invoke API by sending HTTP request with the given options, when a binary file needs to be uploaded as part of
     * the request.
     *
     * @param path the sub-path of the HTTP URL
     * @param method the request method
     * @param pathParams the path parameters
     * @param queryParams the query parameters
     * @param file the file to be uploaded
     * @param headerParams the header parameters
     * @param cookieParams the cookies
     * @param accept the request's Accept header
     * @param contentType the request's Content-Type header
     * @param returnType the return type into which to deserialize the response
     * @param <T> the type of the response
     * @return The response body in chosen type
     * @throws IOException if unable to read the provided file
     */
    public <T> ResponseEntity<T> invokeBinaryFileUploadAPI(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, File file,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            List<MediaType> accept, MediaType contentType,
            ParameterizedTypeReference<T> returnType) throws IOException {

        updateParamsForAuth(queryParams, headerParams, cookieParams);

        headerParams.setContentType(contentType);
        headerParams.setAccept(accept);
        // TODO: not sure if this is how cookies should really be added?
        headerParams.addAll(cookieParams);

        byte[] body = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        HttpEntity<byte[]> requestEntity = new HttpEntity<>(body, headerParams);
        String url = expandPathForRestTemplate(path, pathParams, queryParams);
        return restTemplate.exchange(url, method, requestEntity, returnType);

    }

    /**
     * Invoke API by sending HTTP request with the given options.
     *
     * @param <T> the return type to use
     * @param path The sub-path of the HTTP URL
     * @param method The request method
     * @param pathParams The path parameters
     * @param queryParams The query parameters
     * @param body The request body object
     * @param headerParams The header parameters
     * @param cookieParams The cookie parameters
     * @param formParams The form parameters
     * @param accept The request's Accept header
     * @param contentType The request's Content-Type header
     * @param returnType The return type into which to deserialize the response
     * @return The response body in chosen type
     */
    public <T> Flux<T> invokeFluxAPI(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, Object body,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType, ParameterizedTypeReference<T> returnType) throws RestClientException {
        final WebClient.RequestBodySpec requestBuilder = prepareRequest(
                path, method, pathParams, queryParams, body, headerParams, cookieParams,
                formParams, accept, contentType);
        return requestBuilder.retrieve().bodyToFlux(returnType);
    }

    private WebClient.RequestBodySpec prepareRequest(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, Object body,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType) {
        return prepareRequest(path, method, pathParams, queryParams, body,
                headerParams, cookieParams, formParams, accept, contentType, false);
    }

    private WebClient.RequestBodySpec prepareRequest(
            String path, HttpMethod method, Map<String, Object> pathParams,
            MultiValueMap<String, String> queryParams, Object body,
            HttpHeaders headerParams, MultiValueMap<String, String> cookieParams,
            MultiValueMap<String, Object> formParams, List<MediaType> accept,
            MediaType contentType, boolean encoded) {
        updateParamsForAuth(queryParams, headerParams, cookieParams);

        final UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(basePath).path(path);
        if (queryParams != null) {
            builder.queryParams(queryParams);
        }

        // Spring / URL encoding handling is an absolute nightmare -- just expecting anyone that passes through
        // already-encoded query parameters to have already done their own replacement of any path parameters, as
        // mixing the two basically appears to be impossible without writing your own string parsing logic.
        WebClient.RequestBodySpec requestBuilder;
        if (encoded) {
            URI uri = builder.build(true).toUri();
            requestBuilder = webClient.method(method).uri(uri);
        } else {
            String uri = builder.build(false).toUriString();
            requestBuilder = webClient.method(method).uri(uri, pathParams);
        }

        if (accept != null) {
            requestBuilder.accept(accept.toArray(new MediaType[accept.size()]));
        }
        if (contentType != null) {
            requestBuilder.contentType(contentType);
        }

        addHeadersToRequest(headerParams, requestBuilder);
        addHeadersToRequest(defaultHeaders, requestBuilder);
        addCookiesToRequest(cookieParams, requestBuilder);
        addCookiesToRequest(defaultCookies, requestBuilder);

        requestBuilder.body(selectBody(body, formParams, contentType));
        return requestBuilder;
    }

    /**
     * Add headers to the request that is being built
     * @param headers The headers to add
     * @param requestBuilder The current request
     */
    protected void addHeadersToRequest(HttpHeaders headers,
                                       WebClient.RequestBodySpec requestBuilder) {
        for (Entry<String, List<String>> entry : headers.entrySet()) {
            List<String> values = entry.getValue();
            for (String value : values) {
                if (value != null) {
                    requestBuilder.header(entry.getKey(), value);
                }
            }
        }
    }

    /**
     * Add cookies to the request that is being built
     * @param cookies The cookies to add
     * @param requestBuilder The current request
     */
    protected void addCookiesToRequest(MultiValueMap<String, String> cookies,
                                       WebClient.RequestBodySpec requestBuilder) {
        for (Entry<String, List<String>> entry : cookies.entrySet()) {
            List<String> values = entry.getValue();
            for (String value : values) {
                if (value != null) {
                    requestBuilder.cookie(entry.getKey(), value);
                }
            }
        }
    }

    /**
     * Update query and header parameters based on authentication settings.
     *
     * @param queryParams The query parameters
     * @param headerParams The header parameters
     * @param cookieParams the cookie parameters
     */
    private void updateParamsForAuth(MultiValueMap<String, String> queryParams,
                                     HttpHeaders headerParams,
                                     MultiValueMap<String, String> cookieParams) {
        if (authentication != null) {
            authentication.applyToParams(queryParams, headerParams, cookieParams);
        }
    }

    /**
     * Expand path template with variables
     * @param pathTemplate path template with placeholders
     * @param variables variables to replace
     * @param queryParams any query parameters to include in the URL
     * @return path with placeholders replaced by variables
     */
    private String expandPathForRestTemplate(String pathTemplate,
                                             Map<String, Object> variables,
                                             MultiValueMap<String, String> queryParams) {
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(basePath).path(pathTemplate);
        if (queryParams != null) {
            builder.queryParams(queryParams);
        }
        return restTemplate.getUriTemplateHandler().expand(builder.build(false).toUriString(), variables).toString();
    }

    private static ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.info("Request - URI: " + clientRequest.url());
            log.info("Request - method:" + clientRequest.method());
            log.info("Request - headers: " + headersToString(clientRequest.headers()));
            log.info("Request - body: " + clientRequest.body());
            return next.exchange(clientRequest);
        };
    }

    private static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("Response - status: " + clientResponse.statusCode());
            log.info("Response - headers: " + headersToString(clientResponse.headers().asHttpHeaders()));
            return Mono.just(clientResponse);
        });
    }

    private static String headersToString(HttpHeaders headers) {
        StringBuilder builder = new StringBuilder();
        for (Entry<String, List<String>> entry : headers.entrySet()) {
            builder.append(entry.getKey()).append("=[");
            for (String value : entry.getValue()) {
                builder.append(value).append(",");
            }
            builder.setLength(builder.length() - 1); // Get rid of trailing comma
            builder.append("],");
        }
        builder.setLength(builder.length() - 1); // Get rid of trailing comma
        return builder.toString();
    }

}
