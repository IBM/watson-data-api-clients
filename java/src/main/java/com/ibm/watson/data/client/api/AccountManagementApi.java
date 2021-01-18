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
import com.ibm.watson.data.client.model.GetMeResponse;
import com.ibm.watson.data.client.model.BaseResponse;
import com.ibm.watson.data.client.model.UpdateMeParamsBody;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Platform-level API for managing account-related characteristics.
 */
public class AccountManagementApi {

    private ApiClient apiClient;
    public static final String API_BASE = "/icp4d-api/v1";

    @Autowired
    public AccountManagementApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Change the logged in user's password.
     * @param currentPassword Current password.
     * @param newPassword New password.
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<BaseResponse> changePassword(@NonNull String currentPassword,
                                             @NonNull String newPassword) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        formParams.add("current_password", currentPassword);
        formParams.add("new_password", newPassword);

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"multipart/form-data"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<BaseResponse> localVarReturnType = new ParameterizedTypeReference<BaseResponse>() {};
        return apiClient.invokeAPI(
                API_BASE + "/changepassword", HttpMethod.POST, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get details about the logged in user.
     * @return GetMeResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GetMeResponse> getMe() throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json", "*/*"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GetMeResponse> localVarReturnType = new ParameterizedTypeReference<GetMeResponse>() {};
        return apiClient.invokeAPI(
                API_BASE + "/me", HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update the display name or email address for the logged in user.
     * @param updateMeParamsBody The updated user information.
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<BaseResponse> updateMe(UpdateMeParamsBody updateMeParamsBody) throws RestClientException {

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

        ParameterizedTypeReference<BaseResponse> localVarReturnType = new ParameterizedTypeReference<BaseResponse>() {};
        return apiClient.invokeAPI(
                API_BASE + "/me", HttpMethod.PUT, pathParams, queryParams, updateMeParamsBody,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
