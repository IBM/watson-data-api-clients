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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

/**
 * API endpoints for dealing with connections.
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
     * Delete connection
     * Deletes a connection definition. This call does not check whether the
     * connection is used by activities, data sets or other assets. The caller
     * must check this before deleting a connection. <p><b>204</b> - The
     * connection was deleted. <p><b>401</b> - You are not authorized to delete a
     * connection. <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>404</b> - The connection cannot be found.
     * <p><b>429</b> - The service is currently receiving more requests than it
     * can process in a timely fashion. Please retry submitting your request
     * later. <p><b>500</b> - An error occurred. The connection was not deleted.
     * @param connectionId The ID of the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String connectionId, String catalogId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'connectionId' is set
        if (connectionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionId' when calling deleteConnection");
        }
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
     * Discover assets
     * Discovers assets from the data source accessed via the connection.
     * <p><b>200</b> - The discovered assets.
     * <p><b>401</b> - You are not authorized to discover assets in the data
     * source accessed through the connection. <p><b>403</b> - You are not
     * permitted to perform this action. <p><b>404</b> - The connection cannot be
     * found. <p><b>429</b> - The service is currently receiving more requests
     * than it can process in a timely fashion. Please retry submitting your
     * request later. <p><b>500</b> - An error occurred. No assets were discovered
     * in the data source. <p><b>504</b> - A timeout occurred when processing your
     * request. Please retry later.
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
     * @param limit The limit of the number of items to return, for example
     *     limit&#x3D;50. If not specified a default of 100 will be  used.
     * @param offset The 0-based index of the first result to return, for example,
     *     offset&#x3D;200. If not specified, the default offset of 0 is used.
     * @param fetch Specify whether to return the asset&#39;s metadata, the
     *     asset&#39;s data, or interaction properties. If not specified, metadata
     *     is used by default. This parameter only applies when requesting details
     *     about a data set. To specify multiple fetch values, use a
     *     comma-separated string, such as fetch&#x3D;data,metadata,interaction.
     * @param detail Specify whether to return additional asset-specific details.
     *     If not specified, these details are not returned.
     * @param context Specify whether assets are discovered for the purpose of
     *     reading (source) or writing (target). If not specified, source is used
     *     by default.
     * @param accept Specify whether to return the asset&#39;s data in parsed form
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
    public Mono<DiscoveredAssetCollection> discoverAssets(String connectionId,
                                                          String path,
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

        // verify the required parameter 'connectionId' is set
        if (connectionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionId' when calling discoverAssets");
        }
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'path' when calling discoverAssets");
        }
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
     * Discover assets
     * Discovers assets from the data source accessed via a connection
     * description. <p><b>200</b> - The discovered assets. <p><b>401</b> - You are
     * not authorized to discover assets. <p><b>403</b> - You are not permitted to
     * perform this action. <p><b>429</b> - The service is currently receiving
     * more requests than it can process in a timely fashion. Please retry
     * submitting your request later. <p><b>500</b> - An error occurred. No assets
     * were found. <p><b>504</b> - A timeout occurred when processing your
     * request. Please retry later.
     * @param path Path of the asset.
     * @param connectionEntity The connection definition.
     * @param limit The limit of the number of items to return, for example
     *     limit&#x3D;50. If not specified a default of 100 will be  used.
     * @param offset The 0-based index of the first result to return, for example,
     *     offset&#x3D;200. If not specified, the default offset of 0 is used.
     * @param fetch Specify whether to return the asset&#39;s metadata, the
     *     asset&#39;s data, or interaction properties. If not specified, metadata
     *     is used by default. This parameter only applies when requesting details
     *     about a data set. To specify multiple fetch values, use a
     *     comma-separated string, such as fetch&#x3D;data,metadata,interaction.
     * @param detail Specify whether to return additional asset-specific details.
     *     If not specified, these details are not returned.
     * @param context Specify whether assets are discovered for the purpose of
     *     reading (source) or writing (target). If not specified, source is used
     *     by default.
     * @param accept Specify whether to return the asset&#39;s data in parsed form
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
    public Mono<DiscoveredAssetCollection> discoverAssetsAnonymously(String path,
                                                                     ConnectionEntity connectionEntity,
                                                                     Integer limit,
                                                                     Integer offset,
                                                                     String fetch,
                                                                     Boolean detail,
                                                                     String context,
                                                                     String accept,
                                                                     String properties,
                                                                     String filters) throws RestClientException {

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'path' when calling discoverAssetsAnonymously");
        }
        // verify the required parameter 'connectionEntity' is set
        if (connectionEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionEntity' when calling discoverAssetsAnonymously");
        }
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
     * Get connection
     * Gets details of a specific connection definition.
     * <p><b>200</b> - The connection object.
     * <p><b>401</b> - You are not authorized to get details about the connection.
     * <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>404</b> - The connection cannot be found.
     * <p><b>429</b> - The service is currently receiving more requests than it
     * can process in a timely fashion. Please retry submitting your request
     * later. <p><b>500</b> - An error occurred. The connection definition details
     * cannot be retrieved. <p><b>504</b> - A timeout occurred when processing
     * your request. Please retry later.
     * @param connectionId The ID of the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Connection
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionAsset> get(String connectionId, String catalogId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'connectionId' is set
        if (connectionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionId' when calling getConnection");
        }
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
     * List actions
     * Lists all supported actions for the connection.
     * <p><b>200</b> - The actions supported for the connection.
     * <p><b>401</b> - You are not authorized to list the actions for the
     * connection. <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>404</b> - The connection cannot be found.
     * <p><b>429</b> - The service is currently receiving more requests than it
     * can process in a timely fashion. Please retry submitting your request
     * later. <p><b>500</b> - An error occurred. The actions for the connection
     * cannot be listed. <p><b>504</b> - A timeout occurred when processing your
     * request. Please retry later.
     * @param connectionId The ID of the connection.
     * @param acceptLanguage The user&#39;s preferred locale identifier.
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
    public Mono<ConnectionActions> listActions(String connectionId,
                                               String acceptLanguage,
                                               String catalogId,
                                               String projectId,
                                               String spaceId) throws RestClientException {

        // verify the required parameter 'connectionId' is set
        if (connectionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionId' when calling listActions");
        }
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
     * List defined connections
     * Lists defined connections.  Use the following parameters to sort the
     * results:  | Field                     | Example | |
     * ------------------------- | ----------------------------------- | |
     * entity.name               | ?_sort&#x3D;+entity.name                 | |
     * metadata.create_time      | ?_sort&#x3D;-metadata.create_time        |  Use
     * the following parameters to filter the results:  | Field | Example |
     * |-------------------------- | ----------------------------------- | |
     * entity.name               | ?entity.name&#x3D;MyConnection           | |
     * entity.datasource_type    | ?entity.datasource_type&#x3D;&lt;asset_id&gt;
     * | | entity.context            | ?entity.context&#x3D;source              |
     * | entity.properties         |
     * ?entity.properties&#x3D;{\&quot;name\&quot;:\&quot;value\&quot;} | |
     * entity.flags              | ?entity.flags&#x3D;+restricted           | |
     * metadata.creator_id       | ?metadata.creator_id&#x3D;userid         |
     * Filtering is done by specifying the fields to filter on.   To filter on the
     * properties of a connection, the exact values to  compare must be provided
     * in the entities.properties field and all  values supplied must exactly
     * match a property of a connection.  The entity.flags field specifies the
     * flags a connection can have to be included in the list results. By default,
     * all connections with no flags are returned.   Adding the name of a flag to
     * entity.flags will add the connections  with that flag to the list results.
     * The name can be optionally  prefixed with a plus sign (+) to indicate that
     * it is being added.  Adding the name of a flag to entity.flags with a minus
     * sign (-) prefix will remove those connections with that flag from the list
     * results. All additions are done before the subtractions. <p><b>200</b> -
     * Connections with metadata. <p><b>401</b> - You are not authorized to list
     * the defined connections. <p><b>403</b> - You are not permitted to perform
     * this action. <p><b>429</b> - The service is currently receiving more
     * requests than it can process in a timely fashion. Please retry submitting
     * your request later. <p><b>500</b> - An error occurred. The defined
     * connections cannot be listed. <p><b>504</b> - A timeout occurred when
     * processing your request. Please retry later.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param sort The field to sort the results on, including whether to sort
     *     ascending (+) or descending (-), for example,
     *     sort&#x3D;-metadata.create_time
     * @param start The page token indicating where to start paging from.
     * @param limit The limit of the number of items to return, for example
     *     limit&#x3D;50. If not specified a default of 100 will be  used.
     * @param metadataCreator The creator of the connection.
     * @param entityName The name of the connection.
     * @param entityDatasourceType The data source type of the connection.
     * @param entityContext The context of the connection. Can be one of
     *     \&quot;source\&quot;, \&quot;target\&quot;, or
     *     \&quot;source,target\&quot;.
     * @param entityProperties The properties of the connection that must match
     *     for the connection to be included in the list.
     * @param entityFlags A comma separated list of flags that must be present for
     *     the connection to be included in the list. If not provided, only
     *     connections with no flags will be returned.
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
     * Perform action
     * Performs an action on the data source accessed using the connection.
     * <p><b>200</b> - Any output produced by the action.
     * <p><b>400</b> - The perform action request is invalid.
     * <p><b>401</b> - You are not authorized to perform an action on a data
     * source accessed through the connection. <p><b>403</b> - You are not
     * permitted to perform this action. <p><b>404</b> - The connection cannot be
     * found. <p><b>429</b> - The service is currently receiving more requests
     * than it can process in a timely fashion. Please retry submitting your
     * request later. <p><b>500</b> - An error occurred. No action was performed
     * on the data source. <p><b>504</b> - A timeout occurred when processing your
     * request. Please retry later.
     * @param connectionId The ID of the connection.
     * @param actionName The name of the action to be performed. This list is
     *     expanded over time. The current actions are:  | action                |
     *     description | | --------------------- |
     *     ------------------------------------------------------------------------
     *     | | get_oauth2_tokens     | to get refresh and authorization tokens for
     *     sources that support OAuth2. | | get_record_count      | to get the
     *     number of records available for the specified asset.          | |
     *     get_signed_url        | to get a signed URL for accessing a data
     *     source.                         | | test                  | to check if
     *     a connection can be established to the data source.          | |
     *     validate              | to validate the connection properties without
     *     establishing a connection. |
     * @param requestBody The perform action request configuration.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @return Map&lt;String, Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, Object>> performAction(String connectionId,
                                                   String actionName,
                                                   Map<String, Object> requestBody,
                                                   String catalogId,
                                                   String projectId,
                                                   String spaceId) throws RestClientException {

        // verify the required parameter 'connectionId' is set
        if (connectionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionId' when calling performAction");
        }
        // verify the required parameter 'actionName' is set
        if (actionName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'actionName' when calling performAction");
        }
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestBody' when calling performAction");
        }
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
     * Define connection
     * Defines a connection.
     * <p><b>201</b> - The connection was created.
     * <p><b>400</b> - The connection test failed. See the error message for
     * details. <p><b>401</b> - You are not authorized to define a connection.
     * <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>409</b> - A connection with the same name already exists. Specify
     * another name. <p><b>429</b> - The service is currently receiving more
     * requests than it can process in a timely fashion. Please retry submitting
     * your request later. <p><b>500</b> - An error occurred. A connection was not
     * created. <p><b>504</b> - A timeout occurred when processing your request.
     * Please retry later.
     * @param connectionEntity The definition of the connection.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param test Whether to test the connection before saving it. If a
     *     connection cannot be established, the connection is not saved.
     * @return Connection
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ConnectionAsset> create(ConnectionEntity connectionEntity,
                                        String catalogId,
                                        String projectId,
                                        String spaceId,
                                        Boolean test) throws RestClientException {

        // verify the required parameter 'connectionEntity' is set
        if (connectionEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionEntity' when calling saveConnection");
        }
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
     * Update connection
     * Updates the definition of a connection.
     * <p><b>200</b> - The updated connection definition object.
     * <p><b>400</b> - The connection test failed. See the error message for
     * details. <p><b>401</b> - You are not authorized to update the connection
     * definition. <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>404</b> - The connection cannot be found.
     * <p><b>429</b> - The service is currently receiving more requests than it
     * can process in a timely fashion. Please retry submitting your request
     * later. <p><b>500</b> - An error occurred. The connection definition was not
     * updated. <p><b>504</b> - A timeout occurred when processing your request.
     * Please retry later.
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
    public Mono<ConnectionEntity> update(String connectionId,
                                         List<JSONResourcePatchModel> jsONResourcePatchModel,
                                         String catalogId,
                                         String projectId,
                                         String spaceId,
                                         Boolean test) throws RestClientException {

        // verify the required parameter 'connectionId' is set
        if (connectionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'connectionId' when calling updateConnection");
        }
        // verify the required parameter 'jsONResourcePatchModel' is set
        if (jsONResourcePatchModel == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'jsONResourcePatchModel' when calling updateConnection");
        }
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
     * Upgrade connections
     * Upgrades connection.
     * <p><b>201</b> - The connections were upgraded.
     * <p><b>400</b> - Bad request. See the error message for details.
     * <p><b>401</b> - You are not authorized to define a connection.
     * <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>500</b> - An error occurred. Connections were not updated.
     * <p><b>504</b> - A timeout occurred when processing your request. Please
     * retry later.
     * @param catalogId The ID of the catalog to use. catalog_id, project_id, or
     *     space_id is required.
     * @param projectId The ID of the project to use. project_id or space_id is
     *     required.
     * @param spaceId The ID of the space to use. catalog_id, project_id, or
     *     space_id is required.
     * @param start The page token indicating where to start paging from.
     * @param limit The limit of the number of items to return, for example
     *     limit&#x3D;50. If not specified a default of 100 will be  used.
     * @return Map&lt;String, Object&gt;
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
