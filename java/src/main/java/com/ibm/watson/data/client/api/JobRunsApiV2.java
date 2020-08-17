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
import com.ibm.watson.data.client.model.JobRun;
import com.ibm.watson.data.client.model.JobRunPostBody;
import com.ibm.watson.data.client.model.ListJobRunResponse;
import com.ibm.watson.data.client.model.LogsResponse;
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

/**
 * API endpoints dealing with Job Runs.
 */
public class JobRunsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/jobs/{job_id}/runs";

    @Autowired
    public JobRunsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Get list of runs of a job.
     * Lists the job runs for a specific job in the specified project or space
     * (either project_id or space_id must be set). Only the metadata and certain
     * elements of the entity component of each run are returned. <p><b>200</b> -
     * Success. <p><b>401</b> - You are not authorized to access the service. See
     * response for more information. <p><b>403</b> - You are not permitted to
     * perform this action. See response for more information. <p><b>0</b> - An
     * error occurred. See response for more information.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return ListJobRunResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ListJobRunResponse> list(String jobId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobId' when calling v2JobsJobIdRunsGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("job_id", jobId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ListJobRunResponse> localVarReturnType = new ParameterizedTypeReference<ListJobRunResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Start a run for a job.
     * Starts the specified job contained in a project or space (either project_id
     * or space_id must be set). <p><b>201</b> - The requested operation completed
     * successfully. <p><b>401</b> - You are not authorized to access the service.
     * See response for more information. <p><b>403</b> - You are not permitted to
     * perform this action. See response for more information. <p><b>0</b> - An
     * error occurred. See response for more information.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param jobRunPostBody The configuration of the job run to use. If not
     *     provided, use the configuration of the associated job.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return JobRun
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<JobRun> start(String jobId, JobRunPostBody jobRunPostBody, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobId' when calling v2JobsJobIdRunsPost");
        }
        // verify the required parameter 'jobRunPostBody' is set
        if (jobRunPostBody == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobRunPostBody' when calling v2JobsJobIdRunsPost");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("job_id", jobId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<JobRun> localVarReturnType = new ParameterizedTypeReference<JobRun>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                jobRunPostBody, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Cancel a run.
     * Cancels a job run that is in the running state.
     * <p><b>204</b> - The requested operation completed successfully.
     * <p><b>401</b> - You are not authorized to access the service. See response
     * for more information. <p><b>403</b> - You are not permitted to perform this
     * action. See response for more information. <p><b>0</b> - An error occurred.
     * See response for more information.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param runId The ID of the job run.
     * @param body An empty body.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> cancel(String jobId, String runId, Object body, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobId' when calling v2JobsJobIdRunsRunIdCancelPost");
        }
        // verify the required parameter 'runId' is set
        if (runId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'runId' when calling v2JobsJobIdRunsRunIdCancelPost");
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling v2JobsJobIdRunsRunIdCancelPost");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("job_id", jobId);
        pathParams.put("run_id", runId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{run_id}/cancel",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete a run.
     * Delete the specified job run in a project or space (either project_id or
     * space_id must be set). <p><b>202</b> - The requested operation is in
     * progress. <p><b>204</b> - The requested operation completed successfully.
     * <p><b>401</b> - You are not authorized to access the service. See response
     * for more information. <p><b>403</b> - You are not permitted to perform this
     * action. See response for more information. <p><b>404</b> - The resources
     * you specified cannot be found. <p><b>0</b> - An error occurred. See
     * response for more information.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param runId The ID of the job run.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String jobId, String runId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobId' when calling v2JobsJobIdRunsRunIdDelete");
        }
        // verify the required parameter 'runId' is set
        if (runId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'runId' when calling v2JobsJobIdRunsRunIdDelete");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("job_id", jobId);
        pathParams.put("run_id", runId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{run_id}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get a specific run of a job.
     * Gets the info for a single job run from the specified project or space
     * (either project_id or space_id must be set). <p><b>200</b> - Success.
     * <p><b>401</b> - You are not authorized to access the service. See response
     * for more information. <p><b>403</b> - You are not permitted to perform this
     * action. See response for more information. <p><b>0</b> - An error occurred.
     * See response for more information.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param runId The ID of the job run.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return JobRun
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<JobRun> get(String jobId, String runId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobId' when calling v2JobsJobIdRunsRunIdGet");
        }
        // verify the required parameter 'runId' is set
        if (runId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'runId' when calling v2JobsJobIdRunsRunIdGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("job_id", jobId);
        pathParams.put("run_id", runId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<JobRun> localVarReturnType = new ParameterizedTypeReference<JobRun>() {};
        return apiClient.invokeAPI(BASE_API + "/{run_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve runtime log of a run.
     * Gets the logs for a job run in the specified project or space (either
     * project_id or space_id must be set) <p><b>200</b> - Success. <p><b>401</b>
     * - You are not authorized to access the service. See response for more
     * information. <p><b>403</b> - You are not permitted to perform this action.
     * See response for more information. <p><b>0</b> - An error occurred. See
     * response for more information.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param runId The ID of the job run.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param limit The limit of the number of lines to return, for example
     *     limit&#x3D;50. If not specified, all log will be returned.
     * @return LogsResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<LogsResponse> getRuntimeLog(String jobId, String runId, String projectId, String spaceId, Long limit) throws RestClientException {

        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jobId' when calling v2JobsJobIdRunsRunIdLogsGet");
        }
        // verify the required parameter 'runId' is set
        if (runId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'runId' when calling v2JobsJobIdRunsRunIdLogsGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("job_id", jobId);
        pathParams.put("run_id", runId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<LogsResponse> localVarReturnType = new ParameterizedTypeReference<LogsResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{run_id}/logs",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
