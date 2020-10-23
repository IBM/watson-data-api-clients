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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

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
     * Get a user task by task id
     *
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Task not found
     * <p><b>500</b> - Server Error
     * @param taskId the task id
     * @return UserTask
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<UserTask> get(String taskId) throws RestClientException {

        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'taskId' when calling getUserTaskUsingGET1");
        }
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
     * Get all active or completed user tasks where current user is involved
     *
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Server Error
     * @param artifactId only return tasks relate to artifact of the given
     *     artifact_id
     * @param completed indicate if only return active tasks or completed tasks.
     *     default is false meaning active tasks.
     * @param hideAuthoringTasks hide authoring tasks
     * @param limit limit
     * @param offset offset
     * @param sort specify the ordering of returning resources. it can contain any
     *     one of the valid sort fields or a combination of these fields. prepend
     *     a field with a &#39;+&#39; or &#39;-&#39; character to indicate
     *     ascending or descending, if neither of &#39;+&#39; or &#39;-&#39; are
     *     provided, ascending is used. e.g. &#39;field1&#39;, &#39;-field1&#39;,
     *     or &#39;+field1,-field2&#39;.&lt;p&gt;valid fields are created_at,
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
     * Update a task
     *
     * <p><b>204</b> - action was successful
     * <p><b>400</b> - bad request, expected variables are missing
     * <p><b>403</b> - forbidden; user is not a candidate user or claimed by
     * someone else <p><b>404</b> - not found, user task does not exist or has
     * been completed
     * @param taskId the task id
     * @param userTaskActionPayload payload for submitting a user task action.
     *     &lt;p&gt;supported actions are claim and complete. &lt;p&gt;assignee is
     *     optional, only for action claim, if empty or null then task will be
     *     unclaimed. &lt;p&gt;form_properties are optional, only for action
     *     complete. each form property has an id and a value of either type
     *     string, long, date, or enum. only one of the value fields can be
     *     provided for each variable. for enum type of value, supply the id of
     *     the enum value in &#39;value&#39; attribute.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> update(String taskId, UserTaskActionPayload userTaskActionPayload) throws RestClientException {

        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'taskId' when calling updateUserTaskUsingPOST1");
        }
        // verify the required parameter 'userTaskActionPayload' is set
        if (userTaskActionPayload == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userTaskActionPayload' when calling updateUserTaskUsingPOST1");
        }
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
