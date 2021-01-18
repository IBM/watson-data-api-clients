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
 * API endpoints dealing with (deployment) Space membership.
 */
public class SpacesMembersApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/spaces/{guid}/members";

    @Autowired
    public SpacesMembersApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Adds new space members with the provided roles.
     * A space must always have at least one admin.
     * @param guid The project GUID.
     * @param spaceMembers The spaceMembers parameter
     * @return SpaceMembers
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SpaceMembers> add(@NonNull String guid,
                                  @NonNull WriteableSpaceMembers spaceMembers) throws RestClientException {

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

        ParameterizedTypeReference<SpaceMembers> localVarReturnType = new ParameterizedTypeReference<SpaceMembers>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                spaceMembers, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete a member from a space.
     * @param guid The project GUID.
     * @param userId The username of the space member.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String guid,
                             @NonNull String userId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);
        pathParams.put("user_id", userId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{user_id}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve the space member with the specified userId, if any.
     * @param guid The space GUID.
     * @param userId The user ID of the space member.
     * @return SpaceMember
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SpaceMember> get(@NonNull String guid,
                                 @NonNull String userId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);
        pathParams.put("user_id", userId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<SpaceMember> localVarReturnType = new ParameterizedTypeReference<SpaceMember>() {};
        return apiClient.invokeAPI(BASE_API + "/{user_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve a list of space members.
     * @param guid The project GUID.
     * @return ProjectMembers
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SpaceMembers> list(@NonNull String guid) throws RestClientException {

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

        ParameterizedTypeReference<SpaceMembers> localVarReturnType = new ParameterizedTypeReference<SpaceMembers>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
