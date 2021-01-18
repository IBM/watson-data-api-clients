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

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.data.client.ApiClient;
import com.ibm.watson.data.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * API endpoints dealing with Watson Machine Learning models.
 */
public class ModelsApi {

    private ApiClient apiClient;
    public static final String BASE_API = "/ml/v4/models";

    @Autowired
    public ModelsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }
    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create a new model with the given payload.
     * A model represents a machine learning model asset. If a 202 status is returned then the model
     * will be ready when the "content_import_state" in the model status is "completed". If 
     * "content_import_state" is not used then a "201" status is returned. 
     * @param version The version date for the API. 
     * @param modelEntityRequest Payload for creating the model. Either "space_id" or "project_id" has to be provided and is mandatory. 
     * @return ModelResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> create(@NonNull LocalDate version,
                                      @NonNull ModelEntityRequest modelEntityRequest) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ModelResource> localVarReturnType = new ParameterizedTypeReference<ModelResource>() {};
        return apiClient.invokeAPI(BASE_API, HttpMethod.POST,
                pathParams, queryParams, modelEntityRequest, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Create a new model revision.
     * The current metadata and content for model_id will be taken and a new revision created. Either
     * "space_id" or "project_id" has to be provided and is mandatory.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param modelRevisionEntityRequest The modelRevisionEntityRequest parameter
     * @return ModelResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> createRevision(@NonNull String modelId,
                                              @NonNull LocalDate version,
                                              @NonNull ModelRevisionEntityRequest modelRevisionEntityRequest) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ModelResource> localVarReturnType = new ParameterizedTypeReference<ModelResource>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}/revisions", HttpMethod.POST,
                pathParams, queryParams, modelRevisionEntityRequest, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Delete the model with the specified identifier.
     * This will delete all revisions of this model as well. For each revision all attachments will
     * also be deleted.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given. 
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> delete(@NonNull String modelId,
                             @NonNull LocalDate version,
                             String spaceId,
                             String projectId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }
    /**
     * Delete the content for the specified model.
     * @param modelId Model identifier.
     * @param attachmentId Identifier for the attachment for resources that support separate content. 
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given. 
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteContent(@NonNull String modelId,
                                    @NonNull String attachmentId,
                                    @NonNull LocalDate version,
                                    String spaceId,
                                    String projectId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}/content/{attachment_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Download the model content.
     * @param modelId Model identifier.
     * @param attachmentId Identifier for the attachment for resources that support separate content. 
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given. 
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given. 
     * @param rev The revision number of the resource.
     * @return DataBuffer of bytes that can be streamed into a file
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @see #saveDownloadAsFile(String, Mono)
     */
    public Mono<DataBuffer> download(@NonNull String modelId,
                                     @NonNull String attachmentId,
                                     @NonNull LocalDate version,
                                     String spaceId,
                                     String projectId,
                                     String rev) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rev", rev));

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DataBuffer> localVarReturnType = new ParameterizedTypeReference<DataBuffer>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}/content/{attachment_id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Download the model content identified by the provided criteria.
     * If there are no filters then, if there is a single attachment, the attachment content will be returned.
     * Otherwise a "400" or "404" error will be returned as follows:
     * <ul>
     *     <li>If more than one attachment is found for the given filter then a "400" error is returned.</li>
     *     <li>If there are no attachments that match the filter then a "404" error is returned.</li>
     * </ul>
     * This method is just a shortcut for getting the attachment metadata and then downloading by
     * attachment id.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param rev The revision number of the resource.
     * @param pipelineNodeId Returns only resources that match this "pipeline_node_id", this is only relevant if "content_format" is "pipeline-node".
     * @param name Match an attachment with this name.
     * @param contentFormat This is the format of the content. Any value can be used for the format and is there to be able to easily find content by format.
     * @return DataBuffer of bytes that can be streamed into a file
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @see #saveDownloadAsFile(String, Mono)
     */
    public Mono<DataBuffer> download(@NonNull String modelId,
                                     @NonNull LocalDate version,
                                     String spaceId,
                                     String projectId,
                                     String rev,
                                     String pipelineNodeId,
                                     String name,
                                     String contentFormat) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rev", rev));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pipeline_node_id", pipelineNodeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "content_format", contentFormat));

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DataBuffer> localVarReturnType = new ParameterizedTypeReference<DataBuffer>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}/download", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Save a set of contents into a file using the path provided.
     * @param path of the file to write
     * @param contents that should be written to the file
     * @return Path that was written, or null if no file was written
     */
    public Path saveDownloadAsFile(String path, Mono<DataBuffer> contents) {
        final Path location = FileSystems.getDefault().getPath(path);
        DataBufferUtils.write(contents, location).block();
        return location;
    }

    /**
     * Retrieve the model with the specified identifier.
     * If "rev" query parameter is provided, "latest" will fetch the latest revision.
     * A call with "{revision_number}" will fetch the given revision_number record. Either
     * "space_id" or "project_id" has to be provided and is mandatory.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param rev The revision number of the resource.
     * @return ModelResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> get(@NonNull String modelId,
                                   @NonNull LocalDate version,
                                   String spaceId,
                                   String projectId,
                                   String rev) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rev", rev));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ModelResource> localVarReturnType = new ParameterizedTypeReference<ModelResource>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the models for the specified space or project.
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given. 
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given. 
     * @param start Token required for token-based pagination. This token cannot be determined by end user. It is generated by the service and it is set in the href available in the "next" field. 
     * @param limit How many resources should be returned. By default limit is 100. Max limit allowed is 200.
     * @param tagValue Return only the resources with the given tag value.
     * @param softwareSpec Returns only resources having a dependency on this "software_spec". The value is the "id" of the "software_spec". 
     * @return ModelResources
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResources> list(@NonNull LocalDate version,
                                     String spaceId,
                                     String projectId,
                                     String start,
                                     Integer limit,
                                     String tagValue,
                                     String softwareSpec) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag.value", tagValue));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "software_spec", softwareSpec));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ModelResources> localVarReturnType = new ParameterizedTypeReference<ModelResources>() {};
        return apiClient.invokeAPI(BASE_API, HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the content metadata list for the specified model attachments.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param rev The revision number of the resource.
     * @param name List only attachments with the given name.
     * @param contentFormat This is the format of the content. Any value can be used for the format and is there to be able to easily find content by format.
     * @return AllContentMetadata
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<AllContentMetadata> listAttachments(@NonNull String modelId,
                                                    @NonNull LocalDate version,
                                                    String spaceId,
                                                    String projectId,
                                                    String rev,
                                                    String name,
                                                    String contentFormat) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rev", rev));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "content_format", contentFormat));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AllContentMetadata> localVarReturnType = new ParameterizedTypeReference<AllContentMetadata>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}/content", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the model revisions.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param start Token required for token-based pagination. This token cannot be determined by end user. It is generated by the service and it is set in the href available in the "next" field.
     * @param limit How many resources should be returned. By default limit is 100. Max limit allowed is 200.
     * @return ModelResources
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResources> listRevisions(@NonNull String modelId,
                                              @NonNull LocalDate version,
                                              String spaceId,
                                              String projectId,
                                              String start,
                                              Integer limit) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ModelResources> localVarReturnType = new ParameterizedTypeReference<ModelResources>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}/revisions", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Update the model with the provided patch data.
     * The following fields can be patched:
     * <ul>
     *     <li>/tags</li>
     *     <li>/name</li>
     *     <li>/description</li>
     *     <li>/custom</li>
     * </ul>
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param jsonPatch Input For Patch. This is the patch body which corresponds to the JavaScript Object Notation (JSON) Patch standard (RFC 6902).
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @return ModelResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> update(@NonNull String modelId,
                                      @NonNull LocalDate version,
                                      @NonNull List<JSONResourcePatchModel> jsonPatch,
                                      String spaceId,
                                      String projectId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ModelResource> localVarReturnType = new ParameterizedTypeReference<ModelResource>() {};
        return apiClient.invokeAPI(BASE_API + "/{model_id}", HttpMethod.PATCH,
                pathParams, queryParams, jsonPatch, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Upload the content for the specified model.
     * @param modelId Model identifier.
     * @param version The version date for the API.
     * @param contentFormat This is the format of the content. Any value can be used for the format and is there to be able to easily find content by format.
     * @param uploadContent models file
     * @param spaceId The space that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param projectId The project that contains the resource. Either "space_id" or "project_id" query parameter has to be given.
     * @param pipelineNodeId Returns only resources that match this "pipeline_node_id", this is only relevant if "content_format" is "pipeline-node".
     * @param name Provide the name of the attachment.
     * @return ContentMetadata
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ContentMetadata> upload(@NonNull String modelId,
                                                  @NonNull LocalDate version,
                                                  @NonNull String contentFormat,
                                                  @NonNull File uploadContent,
                                                  String spaceId,
                                                  String projectId,
                                                  String pipelineNodeId,
                                                  String name) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "content_format", contentFormat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pipeline_node_id", pipelineNodeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/octet-stream"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ContentMetadata> localVarReturnType = new ParameterizedTypeReference<ContentMetadata>() {};

        ResponseEntity<ContentMetadata> response;
        try {
            response = apiClient.invokeBinaryFileUploadAPI(BASE_API + "/{model_id}/content", HttpMethod.PUT,
                    pathParams, queryParams, uploadContent, headerParams, cookieParams,
                    localVarAccept, localVarContentType, localVarReturnType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WebClientResponseException(404, "Unable to upload model: " + e.getMessage(), headerParams, null, null);
        }
        return response;

    }

}
