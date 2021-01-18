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
package com.ibm.watson.data.client.api;

import com.ibm.watson.data.client.ApiClient;
import com.ibm.watson.data.client.auth.HttpBearerAuth;
import com.ibm.watson.data.client.model.CreateTokenBody;
import com.ibm.watson.data.client.model.ProjectToken;
import com.ibm.watson.data.client.model.ProjectTokens;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * API endpoints dealing with Project tokens.
 */
public class ProjectsTokensApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/projects";

    @Autowired
    public ProjectsTokensApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Issues (creates) a new tenant access token for the project (tenant).
     * @param guid The project GUID.
     * @param createTokenBody The createTokenBody parameter
     * @return ProjectToken
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectToken> create(@NonNull String guid,
                                     @NonNull CreateTokenBody createTokenBody) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ProjectToken> localVarReturnType = new ParameterizedTypeReference<ProjectToken>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}/tokens", HttpMethod.POST, pathParams, queryParams,
                createTokenBody, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Revokes (deletes) a single tenant access token previously issued (created)
     * for the project (tenant).
     * @param guid The project GUID.
     * @param tguid The token GUID.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String guid,
                             @NonNull String tguid) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);
        pathParams.put("tguid", tguid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{guid}/tokens/{tguid}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Revokes (deletes) all tenant access tokens previously issued (created) for
     * the project (tenant).
     * @param guid The project GUID.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deleteAll(@NonNull String guid) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{guid}/tokens", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Validates a tenant access token specified via the Authorization HTTP
     * header.
     * @param token to validate
     * @return ProjectToken
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectToken> validate(String token) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        HttpBearerAuth auth = new HttpBearerAuth("Bearer");
        auth.setBearerToken(token);
        auth.applyToParams(queryParams, headerParams, cookieParams);

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ProjectToken> localVarReturnType = new ParameterizedTypeReference<ProjectToken>() {};
        return apiClient.invokeAPI(BASE_API + "/tokens/introspect", HttpMethod.GET,
                pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * List tenant access tokens issued (created) for the project (tenant).
     * @param guid The project GUID.
     * @return ProjectTokens
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectTokens> list(@NonNull String guid) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ProjectTokens> localVarReturnType = new ParameterizedTypeReference<ProjectTokens>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}/tokens", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
