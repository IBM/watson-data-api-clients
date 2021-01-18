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
 * API endpoints dealing with Projects.
 */
public class ProjectsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/projects";

    @Autowired
    public ProjectsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Creates a new project with the provided parameters.
     * @param createProjectBody The createProjectBody parameter
     * @return Project
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     * @deprecated in favour of transactional equivalent
     * @see TransactionalProjectsApiV2#create(TransactionalProjectCreate)
     */
    @Deprecated
    public Mono<Project> create(@NonNull CreateProjectBody createProjectBody) throws RestClientException {

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

        ParameterizedTypeReference<Project> localVarReturnType = new ParameterizedTypeReference<Project>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, createProjectBody,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
    }

    /**
     * Deletes a project with a given GUID.
     * @param guid The project GUID.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     * @deprecated in favour of transactional equivalent
     * @see TransactionalProjectsApiV2#delete(String)
     */
    @Deprecated
    public Mono<Void> delete(@NonNull String guid) throws RestClientException {

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
        return apiClient.invokeAPI(
                BASE_API + "/{guid}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
    }

    /**
     * Retrieve data for a single project.
     * @param guid The project GUID.
     * @param include A list of comma-separated project metadata sections to
     *     include in the query results.
     * @return Project
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Project> get(@NonNull String guid,
                             List<String> include) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "include", include));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Project> localVarReturnType = new ParameterizedTypeReference<Project>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
    }

    /**
     * Retrieve a list of all projects that meet the provided query parameters.
     * By default, the list returns projects that the authenticated user is a
     * member of.
     * @param name A project name to use to filter the query results by name
     *     (exact match).
     * @param member A project member to use to filter the query results by
     *     membership.
     * @param roles A list of comma-separated project roles to use to filter the
     *     query results. Must be used in conjunction with the &#39;member&#39;
     *     query parameter.
     * @param tags A list of comma-separated, user-defined tags to use to filter
     *     the query results.
     * @param guids A list of comma-separated project GUIDs to use to filter the
     *     query results.
     * @param include A list of comma-separated project metadata sections to
     *     include in the query results.
     * @param limit The limit to use to restrict the number of projects returned
     *     in the query results. Used for pagination in conjunction with the
     *     "skip" query parameter.
     * @param skip The offset to use to define the starting index of projects to
     *     return in the query results. Used for pagination in conjunction with
     *     the "limit" query parameter.
     * @return Projects
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Projects> list(String name,
                               String member,
                               List<String> roles,
                               List<String> tags,
                               List<String> guids,
                               List<String> include,
                               Integer limit,
                               Integer skip) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "member", member));
        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "roles", roles));
        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "tags", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "guids", guids));
        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "include", include));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Projects> localVarReturnType = new ParameterizedTypeReference<Projects>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
    }

    /**
     * Partially updates the project with only a subset of properties.
     * @param guid The project GUID.
     * @param updateProjectBody The updateProjectBody parameter
     * @return Project
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Project> update(@NonNull String guid,
                                @NonNull UpdateProjectBody updateProjectBody) throws RestClientException {

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

        ParameterizedTypeReference<Project> localVarReturnType = new ParameterizedTypeReference<Project>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}", HttpMethod.PATCH, pathParams, queryParams,
                updateProjectBody, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
    }

}
