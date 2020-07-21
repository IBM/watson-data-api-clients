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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ibm.watson.data.client.api.AuthorizationApi;
import com.ibm.watson.data.client.auth.Authentication;
import com.ibm.watson.data.client.auth.HttpBearerAuth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.*;
import java.util.Map.Entry;

import com.ibm.watson.data.client.model.LoginCredentials;
import com.ibm.watson.data.client.model.LoginResponse;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

/**
 * Base client for invoking API endpoints.
 */
public class ApiClient {

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
    private final MultiValueMap<String, String> defaultCookies =
            new LinkedMultiValueMap<>();

    private String basePath = "http://localhost";

    private final WebClient webClient;
    private final DateFormat dateFormat;

    private String username;
    private String password;
    private String apiKey;

    private Authentication authentication;

    public ApiClient(boolean disableSSLVerification) {
        this.dateFormat = createDefaultDateFormat();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNullableModule jnm = new JsonNullableModule();
        mapper.registerModule(jnm);

        this.webClient = buildWebClient(mapper, disableSSLVerification);
        this.init();
    }

    public ApiClient(ObjectMapper mapper, DateFormat format, boolean disableSSLVerification) {
        this(buildWebClient(mapper.copy(), disableSSLVerification), format);
    }

    public ApiClient(WebClient webClient, ObjectMapper mapper,
                     DateFormat format, boolean disableSSLVerification) {
        this(Optional.ofNullable(webClient).orElseGet(
                () -> buildWebClient(mapper.copy(), disableSSLVerification)),
                format);
    }

    private ApiClient(WebClient webClient, DateFormat format) {
        this.webClient = webClient;
        this.dateFormat = format;
        this.init();
    }

    public DateFormat createDefaultDateFormat() {
        DateFormat dateFormat = new RFC3339DateFormat();
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    }

    protected void init() {
        // Nothing to do, at this point...
    }

    /**
     * Build the RestTemplate used to make HTTP requests.
     * @param mapper object mapper
     * @param disableSSLVerification set to true to disable SSL verification
     * @return RestTemplate
     */
    public static WebClient buildWebClient(ObjectMapper mapper, boolean disableSSLVerification) {
        ExchangeStrategies strategies =
                ExchangeStrategies.builder()
                        .codecs(clientDefaultCodecsConfigurer -> {
                            clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonEncoder(
                                    new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON));
                            clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonDecoder(
                                    new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON));
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
        return webClient.build();
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
     */
    public String formatDate(Date date) { return dateFormat.format(date); }

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
            return obj != null ? BodyInserters.fromObject(obj) : null;
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
        final WebClient.RequestBodySpec requestBuilder = prepareRequest(
                path, method, pathParams, queryParams, body, headerParams, cookieParams,
                formParams, accept, contentType);
        return requestBuilder.retrieve().bodyToMono(returnType);
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
        updateParamsForAuth(queryParams, headerParams, cookieParams);

        final UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(basePath).path(path);
        if (queryParams != null) {
            builder.queryParams(queryParams);
        }

        final WebClient.RequestBodySpec requestBuilder =
                webClient.method(method).uri(builder.build(false).toUriString(),
                        pathParams);
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

    private class ApiClientHttpRequestInterceptor
            implements ClientHttpRequestInterceptor {
        private final Log log =
                LogFactory.getLog(ApiClientHttpRequestInterceptor.class);

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                            ClientHttpRequestExecution execution)
                throws IOException {
            logRequest(request, body);
            ClientHttpResponse response = execution.execute(request, body);
            logResponse(response);
            return response;
        }

        private void logRequest(HttpRequest request, byte[] body) {
            log.info("URI: " + request.getURI());
            log.info("HTTP Method: " + request.getMethod());
            log.info("HTTP Headers: " + headersToString(request.getHeaders()));
            log.info("Request Body: " + new String(body, StandardCharsets.UTF_8));
        }

        private void logResponse(ClientHttpResponse response) throws IOException {
            log.info("HTTP Status Code: " + response.getRawStatusCode());
            log.info("Status Text: " + response.getStatusText());
            log.info("HTTP Headers: " + headersToString(response.getHeaders()));
            log.info("Response Body: " + bodyToString(response.getBody()));
        }

        private String headersToString(HttpHeaders headers) {
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

        private String bodyToString(InputStream body) throws IOException {
            StringBuilder builder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(body, StandardCharsets.UTF_8));
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            return builder.toString();
        }
    }

}
