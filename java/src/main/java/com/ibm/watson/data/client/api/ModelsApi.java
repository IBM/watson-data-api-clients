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
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

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
     * Create a new model
     * Create a new model with the given payload. A model represents a machine learning model asset. If a &#x60;202&#x60; status is returned then the model will be ready when the &#x60;content_import_state&#x60; in the model status (/ml/v4/models/{model_id}) is &#x60;completed&#x60;. If &#x60;content_import_state&#x60; is not used then a &#x60;201&#x60; status is returned. 
     * <p><b>201</b> - Model created
     * <p><b>202</b> - Model accepted, this is returned in the case that &#x60;content_location&#x60; was provided in the request entity and so the model was created but the attachments are still being uploaded. In this case the model will not be ready until the &#x60;content_import_state&#x60; in the model status (/ml/v4/models/{model_id}) is &#x60;completed&#x60;. 
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param modelEntityRequest Payload for creating the model. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be provided and is mandatory. 
     * @return ModelResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> create(LocalDate version,
                                      ModelEntityRequest modelEntityRequest) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsCreate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'modelEntityRequest' is set
        if (modelEntityRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelEntityRequest' when calling modelsCreate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Create a new model revision
     * Create a new model revision. The current metadata and content for model_id will be taken and a new revision created. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be provided and is mandatory. 
     * <p><b>201</b> - Model revision created
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param modelRevisionEntityRequest The modelRevisionEntityRequest parameter
     * @return ModelResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> createRevision(String modelId,
                                              LocalDate version,
                                              ModelRevisionEntityRequest modelRevisionEntityRequest) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsCreateRevision", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsCreateRevision", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'modelRevisionEntityRequest' is set
        if (modelRevisionEntityRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelRevisionEntityRequest' when calling modelsCreateRevision", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Delete the model
     * Delete the model with the specified identifier. This will delete all revisions of this model as well. For each revision all attachments will also be deleted. 
     * <p><b>204</b> - Model deleted
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> delete(String modelId,
                             LocalDate version,
                             String spaceId,
                             String projectId) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Delete the model content
     * Delete the content for the specified model. 
     * <p><b>204</b> - Model content deleted
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param attachmentId Identifier for the attachment for resources that support separate content. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteContent(String modelId,
                                    String attachmentId,
                                    LocalDate version,
                                    String spaceId,
                                    String projectId) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsDeleteContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'attachmentId' when calling modelsDeleteContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsDeleteContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Download the model content
     * Download the model content. 
     * <p><b>200</b> - Downloaded
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param attachmentId Identifier for the attachment for resources that support separate content. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param rev The revision number of the resource. 
     * @return DataBuffer of bytes that can be streamed into a file
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     * @see #saveDownloadAsFile(String, Mono)
     */
    public Mono<DataBuffer> download(String modelId,
                                     String attachmentId,
                                     LocalDate version,
                                     String spaceId,
                                     String projectId,
                                     String rev) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsDownloadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'attachmentId' when calling modelsDownloadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsDownloadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Download the model content that matches a certain criteria
     * Download the model content identified by the provided criteria. If more than one attachment is found for the
     * given filter then a &#x60;400&#x60; error is returned. If there are no attachments that match the filter then
     * a &#x60;404&#x60; error is returned. If there are no filters then, if there is a single attachment, the
     * attachment content will be returned otherwise a &#x60;400&#x60; or &#x60;404&#x60; error will be returned as
     * described above. This method is just a shortcut for getting the attachment metadata and then downloading by
     * attachment id.
     * <p><b>200</b> - Downloaded
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param rev The revision number of the resource. 
     * @param pipelineNodeId Returns only resources that match this &#x60;pipeline_node_id&#x60;, this is only relevant if &#x60;content_format&#x60; is &#x60;pipeline-node&#x60;. 
     * @param name Match an attachment with this name. 
     * @param contentFormat This is the format of the content. Any value can be used for the format and is there to be able to easily find content by format. 
     * @return DataBuffer of bytes that can be streamed into a file
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     * @see #saveDownloadAsFile(String, Mono)
     */
    public Mono<DataBuffer> download(String modelId,
                                     LocalDate version,
                                     String spaceId,
                                     String projectId,
                                     String rev,
                                     String pipelineNodeId,
                                     String name,
                                     String contentFormat) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsFilteredDownload", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsFilteredDownload", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Retrieve the model
     * Retrieve the model with the specified identifier. If &#x60;rev&#x60; query parameter is provided, &#x60;rev&#x3D;latest&#x60; will fetch the latest revision. A call with &#x60;rev&#x3D;{revision_number}&#x60; will fetch the given revision_number record. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be provided and is mandatory. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param rev The revision number of the resource. 
     * @return ModelResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> get(String modelId,
                                   LocalDate version,
                                   String spaceId,
                                   String projectId,
                                   String rev) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Retrieve the models
     * Retrieve the models for the specified space or project. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param start Token required for token-based pagination. This token cannot be determined by end user. It is generated by the service and it is set in the href available in the &#x60;next&#x60; field. 
     * @param limit How many resources should be returned. By default limit is 100. Max limit allowed is 200.
     * @param tagValue Return only the resources with the given tag value.
     * @param softwareSpec Returns only resources having a dependency on this &#x60;software_spec&#x60;. The value is the &#x60;id&#x60; of the &#x60;software_spec&#x60;. 
     * @return ModelResources
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResources> list(LocalDate version,
                                     String spaceId,
                                     String projectId,
                                     String start,
                                     Integer limit,
                                     String tagValue,
                                     String softwareSpec) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsList", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Retrieve the model content metadata list
     * Retrieve the content metadata list for the specified model attachments. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param rev The revision number of the resource. 
     * @param name List only attachments with the given name. 
     * @param contentFormat This is the format of the content. Any value can be used for the format and is there to be able to easily find content by format. 
     * @return AllContentMetadata
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AllContentMetadata> listAttachments(String modelId,
                                                    LocalDate version,
                                                    String spaceId,
                                                    String projectId,
                                                    String rev,
                                                    String name,
                                                    String contentFormat) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsListAttachments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsListAttachments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Retrieve the model revisions
     * Retrieve the model revisions. 
     * <p><b>200</b> - Model revisions
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param start Token required for token-based pagination. This token cannot be determined by end user. It is generated by the service and it is set in the href available in the &#x60;next&#x60; field. 
     * @param limit How many resources should be returned. By default limit is 100. Max limit allowed is 200.
     * @return ModelResources
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResources> listRevisions(String modelId,
                                              LocalDate version,
                                              String spaceId,
                                              String projectId,
                                              String start,
                                              Integer limit) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsListRevisions", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsListRevisions", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Update the model
     * Update the model with the provided patch data. The following fields can be patched: - &#x60;/tags&#x60; - &#x60;/name&#x60; - &#x60;/description&#x60; - &#x60;/custom&#x60; 
     * <p><b>200</b> - Model has been patched successfully
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param jsonPatch Input For Patch. This is the patch body which corresponds to the JavaScript Object Notation (JSON) Patch standard (RFC 6902). 
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @return ModelResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ModelResource> update(String modelId,
                                      LocalDate version,
                                      List<JSONResourcePatchModel> jsonPatch,
                                      String spaceId,
                                      String projectId) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'jsonPatch' is set
        if (jsonPatch == null) {
            throw new WebClientResponseException("Missing the required parameter 'jsonPatch' when calling modelsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Upload the model content
     * Upload the content for the specified model. 
     * <p><b>201</b> - Model content uploaded
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param modelId Model identifier. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param contentFormat This is the format of the content. Any value can be used for the format and is there to be able to easily find content by format. 
     * @param uploadContent models file
     * @param spaceId The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param projectId The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; query parameter has to be given. 
     * @param pipelineNodeId Returns only resources that match this &#x60;pipeline_node_id&#x60;, this is only relevant if &#x60;content_format&#x60; is &#x60;pipeline-node&#x60;. 
     * @param name Provide the name of the attachment. 
     * @return ContentMetadata
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ContentMetadata> upload(String modelId,
                                                  LocalDate version,
                                                  String contentFormat,
                                                  File uploadContent,
                                                  String spaceId,
                                                  String projectId,
                                                  String pipelineNodeId,
                                                  String name) throws WebClientResponseException {

        // verify the required parameter 'modelId' is set
        if (modelId == null) {
            throw new WebClientResponseException("Missing the required parameter 'modelId' when calling modelsUploadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling modelsUploadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'contentFormat' is set
        if (contentFormat == null) {
            throw new WebClientResponseException("Missing the required parameter 'contentFormat' when calling modelsUploadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'uploadContent' is set
        if (uploadContent == null) {
            throw new WebClientResponseException("Missing the required parameter 'uploadContent' when calling modelsUploadContent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("model_id", modelId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "content_format", contentFormat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pipeline_node_id", pipelineNodeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"multipart/form-data"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ContentMetadata> localVarReturnType = new ParameterizedTypeReference<ContentMetadata>() {};

        return apiClient.invokeFileUploadAPI(BASE_API + "/{model_id}/content", HttpMethod.PUT,
                pathParams, queryParams, uploadContent, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

}
