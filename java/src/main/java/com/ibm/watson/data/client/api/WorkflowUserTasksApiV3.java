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
import com.ibm.watson.data.client.model.PaginatedResourceUserTask;
import com.ibm.watson.data.client.model.UserTask;
import com.ibm.watson.data.client.model.UserTaskActionPayload;
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
 * API endpoints dealing with User Tasks in Workflows.
 */
public class WorkflowUserTasksApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/workflow_user_tasks";

    @Autowired
    public WorkflowUserTasksApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Retrieve the details of a user task.
     * @param taskId the task id
     * @return UserTask
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<UserTask> get(@NonNull String taskId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<UserTask> localVarReturnType = new ParameterizedTypeReference<UserTask>() {};
        return apiClient.invokeAPI(BASE_API + "/{task_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve a list of all active or completed user tasks where the current user is involved.
     * @param artifactId only return tasks relate to artifact of the given
     *     artifact_id
     * @param completed indicate if only return active tasks or completed tasks.
     *     default is false meaning active tasks.
     * @param hideAuthoringTasks hide authoring tasks
     * @param limit limit
     * @param offset offset
     * @param sort specify the ordering of returning resources. Can contain any
     *     one of the valid sort fields or a combination of these fields. Prepend
     *     a field with a "+" or "-" character to indicate
     *     ascending or descending order. Valid fields are created_at,
     *     due_date, and completed_at.
     * @param status only return tasks with the given status. status only applies
     *     when complete is set to false.
     * @param versionId only return tasks relate to artifact of the given
     *     version_id
     * @return PaginatedResourceUserTask
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedResourceUserTask> list(String artifactId,
                                                Boolean completed,
                                                String hideAuthoringTasks,
                                                String limit,
                                                String offset,
                                                String sort,
                                                String status,
                                                String versionId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "artifact_id", artifactId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "completed", completed));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "hideAuthoringTasks", hideAuthoringTasks));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version_id", versionId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedResourceUserTask> localVarReturnType = new ParameterizedTypeReference<PaginatedResourceUserTask>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update a task.
     * @param taskId the task id
     * @param userTaskActionPayload payload for submitting a user task action.
     *     Supported actions are "claim" and "complete". Assignee is
     *     optional, only for action "claim", if empty or null then task will be
     *     unclaimed. <code>form_properties</code> are optional, only for action
     *     "complete". Each form property has an id and a value of either type
     *     string, long, date, or enum. Only one of the value fields can be
     *     provided for each variable. For enum type of value, supply the id of
     *     the enum value in "value" attribute.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> update(@NonNull String taskId,
                             @NonNull UserTaskActionPayload userTaskActionPayload) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{task_id}/actions",
                HttpMethod.POST, pathParams, queryParams,
                userTaskActionPayload, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
