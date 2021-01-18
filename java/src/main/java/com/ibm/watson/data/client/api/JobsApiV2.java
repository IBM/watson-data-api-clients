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
import com.ibm.watson.data.client.model.JSONResourcePatchModel;
import com.ibm.watson.data.client.model.Job;
import com.ibm.watson.data.client.model.JobPostBody;
import com.ibm.watson.data.client.model.ListJobResponse;
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
 * API endpoints dealing with Jobs.
 */
public class JobsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/jobs";

    @Autowired
    public JobsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Delete a specific job.
     * Deletes a specific job in a project or space (either project_id or space_id
     * must be set). If the deletion of the job and its runs will take some time
     * to finish, then a 202 response will be returned and the deletion will
     * continue asynchronously. All the jobs runs associated with the job will
     * also be deleted. If the job is still running, it will not be deleted.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String jobId,
                             String projectId,
                             String spaceId) throws RestClientException {

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

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{job_id}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get list of jobs under a project or a space.
     * Lists the jobs in the specified project or space (either project_id or
     * space_id must be set).
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param assetRef Optionally get all jobs associated with a particular asset.
     * @param assetRefType Optionally get all jobs associated with the particular
     *     asset ref type.
     * @param runId The ID of the job run. Can be used to search parent job of a
     *     job run
     * @param limit The limit of the number of items to return. If not specified a default of 100 will be used.
     * @return ListJobResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ListJobResponse> list(String projectId,
                                      String spaceId,
                                      String assetRef,
                                      String assetRefType,
                                      String runId,
                                      Integer limit) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "asset_ref", assetRef));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "asset_ref_type", assetRefType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "run_id", runId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ListJobResponse> localVarReturnType = new ParameterizedTypeReference<ListJobResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get the detailed job information identified for the provided ID.
     * Gets the info for a single job from the specified project or
     * space (either project_id or space_id must be set).
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Job
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Job> get(@NonNull String jobId,
                         String projectId,
                         String spaceId) throws RestClientException {

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

        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{job_id}", HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update a job.
     * Updates specific attributes of a job in the specified project or space
     * (either project_id or space_id must be set). You must specify the updates
     * by using the JSON patch format, described in RFC 6902. Use
     * "last_run_initiator" for the initiator of the last job run, use
     * "last_run_status" for the status of the last job run.
     * @param jobId The ID of the job to use. Each job has a unique ID.
     * @param requestBody Updates to make to the job run.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Job
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Job> update(@NonNull String jobId,
                            @NonNull List<JSONResourcePatchModel> requestBody,
                            String projectId,
                            String spaceId) throws RestClientException {

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

        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{job_id}", HttpMethod.PATCH, pathParams, queryParams,
                requestBody, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create a new job.
     * Creates a new job in the specified project or space (either project_id or
     * space_id must be set).
     * @param jobPostBody The job to be created.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Job
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Job> create(@NonNull JobPostBody jobPostBody,
                            String projectId,
                            String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, jobPostBody,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
