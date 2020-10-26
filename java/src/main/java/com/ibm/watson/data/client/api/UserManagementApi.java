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
import com.ibm.watson.data.client.model.*;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Platform-level API for managing users.
 */
public class UserManagementApi {

    private ApiClient apiClient;
    public static final String BASE_API = "/icp4d-api/v1/users";

    @Autowired
    public UserManagementApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create user
     * Create a user account for the cluster.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @param createUserParamsBody The new user.
     * @return CreateUserSuccessResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateUserSuccessResponse> create(CreateUserParamsBody createUserParamsBody) throws RestClientException {

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

        ParameterizedTypeReference<CreateUserSuccessResponse> localVarReturnType = new ParameterizedTypeReference<CreateUserSuccessResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, createUserParamsBody,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete user
     * Delete a user from the cluster.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal error
     * @param userName The user name.
     * @return PlatformSuccessResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PlatformSuccessResponse> delete(String userName) throws RestClientException {

        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userName' when calling deleteUser");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("user_name", userName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json", "*/*"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PlatformSuccessResponse> localVarReturnType = new ParameterizedTypeReference<PlatformSuccessResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{user_name}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get all users
     * Returns all users in the cluster.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @return GetAllUsersResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GetAllUsersResponse> list() throws RestClientException {

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

        ParameterizedTypeReference<GetAllUsersResponse> localVarReturnType = new ParameterizedTypeReference<GetAllUsersResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get user information
     * Get details about one user.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal error
     * @param userName The user name.
     * @return GetUserResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GetUserResponse> get(String userName) throws RestClientException {

        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userName' when calling getUser");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("user_name", userName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json", "*/*"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GetUserResponse> localVarReturnType = new ParameterizedTypeReference<GetUserResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{user_name}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update user details
     * Update information about a user account.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found.
     * <p><b>500</b> - Internal error
     * @param userName The user name.
     * @param updateUserParamsBody The updated user information.
     * @return PlatformSuccessResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PlatformSuccessResponse> update(String userName, UpdateUserParamsBody updateUserParamsBody)
            throws RestClientException {

        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userName' when calling updateUser");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("user_name", userName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PlatformSuccessResponse> localVarReturnType = new ParameterizedTypeReference<PlatformSuccessResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{user_name}", HttpMethod.PUT, pathParams, queryParams,
                updateUserParamsBody, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
