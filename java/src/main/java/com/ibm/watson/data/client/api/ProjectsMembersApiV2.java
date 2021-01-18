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
import com.ibm.watson.data.client.model.ProjectMember;
import com.ibm.watson.data.client.model.ProjectMembers;
import com.ibm.watson.data.client.model.UpdateMembersBody;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
 * API endpoints dealing with Project membership.
 */
public class ProjectsMembersApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/projects/{guid}/members";

    @Autowired
    public ProjectsMembersApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Adds new project members with the provided roles.
     * A project must always have at least one admin.
     * @param guid The project GUID.
     * @param projectMembers The projectMembers parameter
     * @return ProjectMembers
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectMembers> add(@NonNull String guid,
                                    @NonNull ProjectMembers projectMembers) throws RestClientException {

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

        ParameterizedTypeReference<ProjectMembers> localVarReturnType = new ParameterizedTypeReference<ProjectMembers>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                projectMembers, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Deletes a member from a project.
     * @param guid The project GUID.
     * @param userName The username of the project member.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String guid,
                             @NonNull String userName) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);
        pathParams.put("user_name", userName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{user_name}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Deletes members from a project.
     * @param guid The project GUID.
     * @param userNames A list of comma-separated usernames corresponding to
     *     project members to remove from the project.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String guid,
                             @NonNull List<String> userNames) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "user_names", userNames));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API, HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieves the project member with the specified username, if any.
     * @param guid The project GUID.
     * @param userName The username of the project member.
     * @return ProjectMember
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectMember> get(@NonNull String guid,
                                   @NonNull String userName) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);
        pathParams.put("user_name", userName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ProjectMember> localVarReturnType = new ParameterizedTypeReference<ProjectMember>() {};
        return apiClient.invokeAPI(BASE_API + "/{user_name}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve a list of project members.
     * @param guid The project GUID.
     * @param roles A list of comma-separated project roles to use to filter the
     *     query results.
     * @param userNames A list of comma-separated usernames corresponding to
     *     project members that are used to filter the query results.
     * @return ProjectMembers
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectMembers> list(@NonNull String guid,
                                     List<String> roles,
                                     List<String> userNames) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "roles", roles));
        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "user_names", userNames));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ProjectMembers> localVarReturnType = new ParameterizedTypeReference<ProjectMembers>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Change project member roles in a batch.
     * @param guid The project GUID.
     * @param updateMembersBody The updateMembersBody parameter
     * @return ProjectMembers
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ProjectMembers> update(@NonNull String guid,
                                       @NonNull UpdateMembersBody updateMembersBody) throws RestClientException {

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

        ParameterizedTypeReference<ProjectMembers> localVarReturnType = new ParameterizedTypeReference<ProjectMembers>() {};
        return apiClient.invokeAPI(BASE_API, HttpMethod.PATCH,
                pathParams, queryParams, updateMembersBody, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
