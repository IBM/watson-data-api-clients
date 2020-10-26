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
import com.ibm.watson.data.client.model.LoginCredentials;
import com.ibm.watson.data.client.model.LoginResponse;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

/**
 * Platform-level API for managing authentication.
 */
public class AuthorizationApi {

    private ApiClient apiClient;

    @Autowired
    public AuthorizationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Get authorization token
     * Generate a bearer token from your Cloud Pak for Data credentials.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @param loginCredentials The loginCredentials parameter
     * @return LoginResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<LoginResponse> getAuthorizationToken(LoginCredentials loginCredentials) throws RestClientException {

        // verify the required parameter 'loginCredentials' is set
        if (loginCredentials == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'loginCredentials' when calling getAuthorizationToken");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<LoginResponse> localVarReturnType = new ParameterizedTypeReference<LoginResponse>() {};
        return apiClient.invokeAPI(
                "/icp4d-api/v1/authorize", HttpMethod.POST, pathParams, queryParams, loginCredentials,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get authorization token
     * Generate a bearer token from your IBM Cloud public API key.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @param apiKey The apiKey parameter
     * @return LoginResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<LoginResponse> getAuthorizationToken(String apiKey) throws RestClientException {

        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'apiKey' when calling getAuthorizationToken");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        formParams.put("apikey", Collections.singletonList(apiKey));
        formParams.put("grant_type", Collections.singletonList("urn:ibm:params:oauth:grant-type:apikey"));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/x-www-form-urlencoded"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<LoginResponse> localVarReturnType = new ParameterizedTypeReference<LoginResponse>() {};

        // Capture the existing base path URL for the client
        String existingBaseUrl = apiClient.getBasePath();
        // Temporarily set the base URL to the public cloud IAM URI
        String publicAuthUri = "https://iam.ng.bluemix.net";
        apiClient.setBasePath(publicAuthUri);
        Mono<LoginResponse> response = apiClient.invokeAPI(
                "/identity/token", HttpMethod.POST, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
        // Set the client back to the original path
        apiClient.setBasePath(existingBaseUrl);
        return response;

    }

}
