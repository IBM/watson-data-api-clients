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
 * Platform-level API for managing roles.
 */
public class RoleManagementApi {

    private ApiClient apiClient;
    public static final String BASE_API = "/icp4d-api/v1/roles";

    @Autowired
    public RoleManagementApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create role
     * If the provided roles do not meet your needs, you can create other roles.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @param createRoleParamsBody Information for creating a role
     * @return PlatformSuccessResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PlatformSuccessResponse> create(CreateRoleParamsBody createRoleParamsBody) throws RestClientException {

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

        ParameterizedTypeReference<PlatformSuccessResponse> localVarReturnType = new ParameterizedTypeReference<PlatformSuccessResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, createRoleParamsBody,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete role
     * Delete a role from the cluster.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal error
     * @param roleName The name of the role.
     * @return PlatformSuccessResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PlatformSuccessResponse> delete(String roleName) throws RestClientException {

        // verify the required parameter 'roleName' is set
        if (roleName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'roleName' when calling deleteRole");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("role_name", roleName);

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
                BASE_API + "/{role_name}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * List all permissions
     * Returns all permissions in the cluster.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @return GetPermissionsResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GetPermissionsResponse> listPermissions() throws RestClientException {

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

        ParameterizedTypeReference<GetPermissionsResponse> localVarReturnType = new ParameterizedTypeReference<GetPermissionsResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/permissions", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * List all roles
     * Returns the user roles in the cluster.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal error
     * @return GetAllRolesResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GetAllRolesResponse> listRoles() throws RestClientException {

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

        ParameterizedTypeReference<GetAllRolesResponse> localVarReturnType = new ParameterizedTypeReference<GetAllRolesResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get role information
     * Get details about one role.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal error
     * @param roleName The name of the role.
     * @return GetRoleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GetRoleResponse> get(String roleName) throws RestClientException {

        // verify the required parameter 'roleName' is set
        if (roleName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'roleName' when calling getRole");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("role_name", roleName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json", "*/*"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GetRoleResponse> localVarReturnType = new ParameterizedTypeReference<GetRoleResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{role_name}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update role
     * Update the name, description, and permissions associated with a role.
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal error
     * @param roleName The name of the role.
     * @param updateRoleParamsBody The updated role information.
     * @return PlatformSuccessResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PlatformSuccessResponse> update(String roleName, UpdateRoleParamsBody updateRoleParamsBody) throws RestClientException {

        // verify the required parameter 'roleName' is set
        if (roleName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'roleName' when calling updateRole");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("role_name", roleName);

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
                BASE_API + "/{role_name}", HttpMethod.PUT, pathParams, queryParams,
                updateRoleParamsBody, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
