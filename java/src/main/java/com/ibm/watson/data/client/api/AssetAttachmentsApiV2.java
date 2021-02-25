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
 * API endpoints for dealing with asset attachments.
 */
public class AssetAttachmentsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/assets/{asset_id}/attachments";

    @Autowired
    public AssetAttachmentsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Delete an attachment.
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String assetId,
                             @NonNull String attachmentId,
                             String catalogId,
                             String projectId,
                             String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Mark an attachment as transfer complete.
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> markTransferComplete(@NonNull String assetId,
                                           @NonNull String attachmentId,
                                           String catalogId,
                                           String projectId,
                                           String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}/complete",
                HttpMethod.POST, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Create an attachment.
     * @param assetId Asset GUID
     * @param attachment Attachment meta-data.     The \&quot;asset_type\&quot; is
     *     required.      If not supplied, or if the value given is less than 1,
     *     data_partitions defaults to 1 (for non-remote and non-referenced
     *     attachments).      For remote attachments, both connection_id and
     *     connection_path are required.     For referenced attachments, both
     *     object_key and object_key_is_read_only are required.
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Attachment
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Attachment> create(@NonNull String assetId,
                                   @NonNull AttachmentRequest attachment,
                                   String catalogId,
                                   String projectId,
                                   String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<Attachment>() {};
        return apiClient.invokeAPI(BASE_API,
                HttpMethod.POST, pathParams, queryParams,
                attachment, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get resources info for an attachment.
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> getResources(@NonNull String assetId,
                                   @NonNull String attachmentId,
                                   String revisionId,
                                   String catalogId,
                                   String projectId,
                                   String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}/resources",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Increase resources for an attachment.
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param attachmentIncRes attachment resource to increase, e.g.
     *     {\&quot;data_partitions\&quot;:5, \&quot;private_url\&quot;:false}
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> increaseResources(@NonNull String assetId,
                                        @NonNull String attachmentId,
                                        @NonNull AttachmentIncRes attachmentIncRes,
                                        String catalogId,
                                        String projectId,
                                        String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}/resources",
                HttpMethod.PUT, pathParams, queryParams, attachmentIncRes, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve an attachment.
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param privateUrl private_url
     * @param responseContentDisposition response-content-disposition
     * @param responseContentType response-content-type
     * @return {@code Mono<Attachment>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AttachmentDetail> get(@NonNull String assetId,
                                      @NonNull String attachmentId,
                                      String revisionId,
                                      String catalogId,
                                      String projectId,
                                      String spaceId,
                                      Boolean privateUrl,
                                      String responseContentDisposition,
                                      String responseContentType) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "private_url", privateUrl));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "response-content-disposition", responseContentDisposition));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "response-content-type", responseContentType));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AttachmentDetail> localVarReturnType = new ParameterizedTypeReference<AttachmentDetail>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Auto update attachment's datasource_type from connection asset.
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Attachment
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Attachment> updateDataSourceType(@NonNull String assetId,
                                                 @NonNull String attachmentId,
                                                 String catalogId,
                                                 String projectId,
                                                 String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<Attachment>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}/datasource_type",
                HttpMethod.PATCH, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update attachment metadata. Example JSON patch:
     * <code>
     * [
     *   {"op": "add", "path": "/name", "value": "my_attachment"},
     *   {"op": "replace", "path": "/mime", "value": "text/csv},
     *   {"op": "remove", "path": "/description"}
     * ]
     * </code>
     * @param assetId Asset GUID
     * @param attachmentId Attachment GUID
     * @param body JSON array of patch operations as defined in RFC 6902. See
     *     http://jsonpatch.com/ for more info.
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Attachment
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Attachment> update(@NonNull String assetId,
                                   @NonNull String attachmentId,
                                   @NonNull List<JSONResourcePatchModel> body,
                                   String catalogId,
                                   String projectId,
                                   String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json", "application/merge-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<Attachment>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{attachment_id}", HttpMethod.PATCH,
                pathParams, queryParams, body, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

}
