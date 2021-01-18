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
import com.ibm.watson.data.client.model.PaginatedResourceArtifact;
import com.ibm.watson.data.client.model.PaginatedResourceWorkflow;
import com.ibm.watson.data.client.model.Workflow;
import com.ibm.watson.data.client.model.WorkflowQuery;
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
 * API endpoints dealing with Workflows.
 */
public class WorkflowsApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/workflows";

    @Autowired
    public WorkflowsApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Get artifacts managed by the workflow.
     * The artifacts are sorted by internal order.
     * @param workflowId the workflow id
     * @param limit limit
     * @param offset offset
     * @return PaginatedResourceArtifact
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedResourceArtifact> listArtifacts(@NonNull String workflowId,
                                                         String limit,
                                                         String offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("workflow_id", workflowId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = {"application/json", "application/hal+json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedResourceArtifact> localVarReturnType = new ParameterizedTypeReference<PaginatedResourceArtifact>() {};
        return apiClient.invokeAPI(BASE_API + "/{workflow_id}/artifacts",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve details for a workflow.
     * @param workflowId the workflow id
     * @param includeArtifacts max number of artifacts to include in result
     * @param includeUserTasks if include user tasks in result
     * @param includeVariables if include variables in result
     * @return Workflow
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Workflow> get(@NonNull String workflowId,
                              String includeArtifacts,
                              Boolean includeUserTasks,
                              Boolean includeVariables) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("workflow_id", workflowId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeArtifacts", includeArtifacts));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeUserTasks", includeUserTasks));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeVariables", includeVariables));

        final String[] localVarAccepts = {"application/json", "application/hal+json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Workflow> localVarReturnType = new ParameterizedTypeReference<Workflow>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{workflow_id}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve a list of all available workflows.
     * The workflows are sorted by internal order.
     * @param artifactId only return workflows relate to artifact of the given
     *     artifact_id
     * @param includeArtifacts max number of artifacts to include in result
     * @param includeUserTasks if include user tasks in result
     * @param includeVariables if include variables in result
     * @param limit limit
     * @param offset offset
     * @param versionId only return workflows relate to artifact of the given
     *     version_id
     * @return PaginatedResourceWorkflow
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedResourceWorkflow> list(String artifactId,
                                                String includeArtifacts,
                                                Boolean includeUserTasks, Boolean includeVariables,
                                                String limit,
                                                String offset,
                                                String versionId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "artifact_id", artifactId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeArtifacts", includeArtifacts));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeUserTasks", includeUserTasks));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeVariables", includeVariables));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version_id", versionId));

        final String[] localVarAccepts = {"application/json", "application/hal+json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedResourceWorkflow> localVarReturnType = new ParameterizedTypeReference<PaginatedResourceWorkflow>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Query available workflows.
     * The workflows are sorted by internal order.
     * @param workflowQuery query criteria
     * @param includeArtifacts max number of artifacts to include in result
     * @param includeUserTasks if include user tasks in result
     * @param includeVariables if include variables in result
     * @param limit limit, all result workflows are returned unless offset and /
     *     or limit are supplied
     * @param offset offset, all result workflows are returned unless offset and /
     *     or limit are supplied
     * @return PaginatedResourceWorkflow
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedResourceWorkflow> search(@NonNull WorkflowQuery workflowQuery,
                                                  String includeArtifacts,
                                                  Boolean includeUserTasks,
                                                  Boolean includeVariables,
                                                  String limit,
                                                  String offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeArtifacts", includeArtifacts));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeUserTasks", includeUserTasks));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeVariables", includeVariables));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = {"application/json", "application/hal+json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedResourceWorkflow> localVarReturnType = new ParameterizedTypeReference<PaginatedResourceWorkflow>() {};
        return apiClient.invokeAPI(
                BASE_API + "/all/query", HttpMethod.POST, pathParams, queryParams,
                workflowQuery, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
