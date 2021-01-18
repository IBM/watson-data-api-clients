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
 * API endpoints for dealing with Connections.
 */
public class ConnectionsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/connections";

    @Autowired
    public ConnectionsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Delete a connection.
     * This call does not check whether the
     * connection is used by activities, data sets or other assets. The caller
     * must check this before deleting a connection.
     * @param connectionId The ID of the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String connectionId,
                             String catalogId,
                             String projectId,
                             String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("connection_id", connectionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{connection_id}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Discover assets from the data source accessed via the connection.
     * @param connectionId The ID of the connection.
     * @param path Path of the asset.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param dataAssetId The ID of the data asset.
     * @param dataAssetCatalogId The ID of the catalog that contains the data
     *     asset.
     * @param dataAssetProjectId The ID of the project that contains the data
     *     asset.
     * @param dataAssetSpaceId The ID of the space that contains the data asset.
     * @param limit The limit of the number of items to return. If not specified a default of 100 will be used.
     * @param offset The 0-based index of the first result to return. If not specified, the default offset of 0 is used.
     * @param fetch Specify whether to return the asset's metadata, the
     *     asset's data, or interaction properties. If not specified, metadata
     *     is used by default. This parameter only applies when requesting details
     *     about a data set. To specify multiple fetch values, use a
     *     comma-separated string, such as <code>data,metadata,interaction</code>.
     * @param detail Specify whether to return additional asset-specific details.
     *     If not specified, these details are not returned.
     * @param context Specify whether assets are discovered for the purpose of
     *     reading (source) or writing (target). If not specified, source is used
     *     by default.
     * @param accept Specify whether to return the asset's data in parsed form
     *     (application/json) or as raw bytes. This only applies to sources that
     *     produce data as a file, document or stream of bytes. To return bytes
     *     specify application/octet-stream.
     * @param properties A JSON object containing a set of properties to configure
     *     aspects of the asset browsing.
     * @param filters A JSON object containing a set of properties to define
     *     filtering of the assets to be returned.
     * @return DiscoveredAssetCollection
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<DiscoveredAssetCollection> discoverAssets(@NonNull String connectionId,
                                                          @NonNull String path,
                                                          String catalogId,
                                                          String projectId,
                                                          String spaceId,
                                                          String dataAssetId,
                                                          String dataAssetCatalogId,
                                                          String dataAssetProjectId,
                                                          String dataAssetSpaceId,
                                                          Integer limit,
                                                          Integer offset,
                                                          String fetch,
                                                          Boolean detail,
                                                          String context,
                                                          String accept,
                                                          String properties,
                                                          String filters) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("connection_id", connectionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "data_asset_id", dataAssetId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "data_asset_catalog_id", dataAssetCatalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "data_asset_project_id", dataAssetProjectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "data_asset_space_id", dataAssetSpaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fetch", fetch));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "detail", detail));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "context", context));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "properties", properties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filters", filters));

        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DiscoveredAssetCollection> localVarReturnType = new ParameterizedTypeReference<DiscoveredAssetCollection>() {};
        return apiClient.invokeAPI(BASE_API + "/{connection_id}/assets",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Discover assets from the data source accessed via a connection
     * description.
     * @param path Path of the asset.
     * @param connectionEntity The connection definition.
     * @param limit The limit of the number of items to return. If not specified a default of 100 will be used.
     * @param offset The 0-based index of the first result to return. If not specified, the default offset of 0 is used.
     * @param fetch Specify whether to return the asset's metadata, the
     *     asset's data, or interaction properties. If not specified, metadata
     *     is used by default. This parameter only applies when requesting details
     *     about a data set. To specify multiple fetch values, use a
     *     comma-separated string, such as <code>data,metadata,interaction</code>.
     * @param detail Specify whether to return additional asset-specific details.
     *     If not specified, these details are not returned.
     * @param context Specify whether assets are discovered for the purpose of
     *     reading (source) or writing (target). If not specified, source is used
     *     by default.
     * @param accept Specify whether to return the asset's data in parsed form
     *     (application/json) or as raw bytes. This only applies to sources that
     *     produce data as a file, document or stream of bytes. To return bytes
     *     specify application/octet-stream.
     * @param properties A JSON object containing a set of properties to configure
     *     aspects of the asset browsing.
     * @param filters A JSON object containing a set of properties to define
     *     filtering of the assets to be returned.
     * @return DiscoveredAssetCollection
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<DiscoveredAssetCollection> discoverAssetsAnonymously(@NonNull String path,
                                                                     @NonNull ConnectionEntity connectionEntity,
                                                                     Integer limit,
                                                                     Integer offset,
                                                                     String fetch,
                                                                     Boolean detail,
                                                                     String context,
                                                                     String accept,
                                                                     String properties,
                                                                     String filters) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fetch", fetch));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "detail", detail));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "context", context));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "properties", properties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filters", filters));

        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json;charset=utf-8", "application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DiscoveredAssetCollection> localVarReturnType = new ParameterizedTypeReference<DiscoveredAssetCollection>() {};
        return apiClient.invokeAPI(
                BASE_API + "/assets", HttpMethod.POST, pathParams, queryParams,
                connectionEntity, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve details of a specific connection definition.
     * @param connectionId The ID of the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return ConnectionAsset
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionAsset> get(@NonNull String connectionId,
                                     String catalogId,
                                     String projectId,
                                     String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("connection_id", connectionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ConnectionAsset> localVarReturnType = new ParameterizedTypeReference<ConnectionAsset>() {};
        return apiClient.invokeAPI(BASE_API + "/{connection_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List all supported actions for the connection.
     * @param connectionId The ID of the connection.
     * @param acceptLanguage The user's preferred locale identifier.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return ConnectionActions
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionActions> listActions(@NonNull String connectionId,
                                               String acceptLanguage,
                                               String catalogId,
                                               String projectId,
                                               String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("connection_id", connectionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        if (acceptLanguage != null)
            headerParams.add("Accept-Language", apiClient.parameterToString(acceptLanguage));
        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ConnectionActions> localVarReturnType = new ParameterizedTypeReference<ConnectionActions>() {};
        return apiClient.invokeAPI(BASE_API + "/{connection_id}/actions",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List defined connections.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param sort The field to sort the results on, including whether to sort
     *     ascending (+) or descending (-), for example,
     *     <code>-metadata.create_time</code>
     * @param start The page token indicating where to start paging from.
     * @param limit The limit of the number of items to return. If not specified a default of 100 will be used.
     * @param metadataCreator The creator of the connection.
     * @param entityName The name of the connection.
     * @param entityDatasourceType The data source type of the connection.
     * @param entityContext The context of the connection. Can be one of
     *     "source", "target", or "source,target".
     * @param entityProperties The properties of the connection that must match
     *     for the connection to be included in the list. All values supplied must exactly
     *     match a property of a connection.
     * @param entityFlags A comma separated list of flags that must be present for
     *     the connection to be included in the list. If not provided, only
     *     connections with no flags will be returned. By default,
     *     all connections with no flags are returned.  Adding the name of a flag to
     *     the list will add the connections with that flag to the list results.
     *     The name can be optionally prefixed with a plus sign (+) to indicate that
     *     it is being added. Adding the name of a flag with a minus
     *     sign (-) prefix will remove those connections with that flag from the list
     *     results. All additions are done before the subtractions.
     * @return ConnectionCollection
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionCollection> list(String catalogId,
                                           String projectId,
                                           String spaceId,
                                           String sort,
                                           String start,
                                           Integer limit,
                                           String metadataCreator,
                                           String entityName,
                                           String entityDatasourceType,
                                           String entityContext,
                                           String entityProperties,
                                           String entityFlags) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "metadata.creator", metadataCreator));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.name", entityName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.datasource_type", entityDatasourceType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.context", entityContext));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.properties", entityProperties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.flags", entityFlags));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ConnectionCollection> localVarReturnType = new ParameterizedTypeReference<ConnectionCollection>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Performs an action on the data source accessed using the connection.
     * @param connectionId The ID of the connection.
     * @param actionName The name of the action to be performed. This list is
     *     expanded over time. The current actions are:
     *     <ul>
     *         <li>get_oauth2_tokens: to get refresh and authorization tokens for sources that support OAuth2.</li>
     *         <li>get_record_count: to get the number of records available for the specified asset.</li>
     *         <li>get_signed_url: to get a signed URL for accessing a data source.</li>
     *         <li>test: to check if a connection can be established to the data source.</li>
     *         <li>validate: to validate the connection properties without establishing a connection.</li>
     *     </ul>
     * @param requestBody The perform action request configuration.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return {@code Map<String, Object>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, Object>> performAction(@NonNull String connectionId,
                                                   @NonNull String actionName,
                                                   @NonNull Map<String, Object> requestBody,
                                                   String catalogId,
                                                   String projectId,
                                                   String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("connection_id", connectionId);
        pathParams.put("action_name", actionName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json;charset=utf-8", "application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Map<String, Object>> localVarReturnType = new ParameterizedTypeReference<Map<String, Object>>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{connection_id}/actions/{action_name}", HttpMethod.PUT,
                pathParams, queryParams, requestBody, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Define a connection.
     * @param connectionEntity The definition of the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param test Whether to test the connection before saving it. If a
     *     connection cannot be established, the connection is not saved.
     * @return ConnectionAsset
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionAsset> create(@NonNull ConnectionEntity connectionEntity,
                                        String catalogId,
                                        String projectId,
                                        String spaceId,
                                        Boolean test) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "test", test));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json;charset=utf-8", "application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ConnectionAsset> localVarReturnType = new ParameterizedTypeReference<ConnectionAsset>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, connectionEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update the definition of a connection.
     * @param connectionId The ID of the connection.
     * @param jsONResourcePatchModel Fields to update within the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param test Whether to test the connection before saving it. By default an
     *     attempt to establish a connection will be made, and the connection will
     *     not be saved if the connection cannot be established.
     * @return ConnectionEntity
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionEntity> update(@NonNull String connectionId,
                                         @NonNull List<JSONResourcePatchModel> jsONResourcePatchModel,
                                         String catalogId,
                                         String projectId,
                                         String spaceId,
                                         Boolean test) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("connection_id", connectionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "test", test));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        // TODO: this API seems to only work with json-patch, not plain json -- so the below ordering may be
        //  problematic, however Spring does not seem to know how to translate a List to json-patch...
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json;charset=utf-8"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ConnectionEntity> localVarReturnType = new ParameterizedTypeReference<ConnectionEntity>() {};
        return apiClient.invokeAPI(BASE_API + "/{connection_id}",
                HttpMethod.PATCH, pathParams, queryParams,
                jsONResourcePatchModel, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Upgrade a connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param start The page token indicating where to start paging from.
     * @param limit The limit of the number of items to return. If not specified a default of 100 will be used.
     * @return {@code Map<String, Object>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, Object>> upgrade(String catalogId,
                                             String projectId,
                                             String spaceId,
                                             String start,
                                             Integer limit) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Map<String, Object>> localVarReturnType = new ParameterizedTypeReference<Map<String, Object>>() {};
        return apiClient.invokeAPI(
                BASE_API + "/upgrade", HttpMethod.POST, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
