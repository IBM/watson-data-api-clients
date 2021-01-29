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
import com.ibm.watson.data.client.model.Asset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.data.client.model.AssetCreateResponse;
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
 * API endpoints for dealing with Data Assets.
 * <br><br>
 * Data assets could be
 * data from a connection to a data source (ex. tables) or files from your
 * local system uploaded into cloud object storage associated with Projects or
 * Catalogs. All asset types have a common set of properties, such as name,
 * description, asset type, visibility, tags, classifications. Data Assets have
 * additional attributes such as mime-type, columns with types, and
 * properties.
 * <br><br>
 * These endpoints deal with the <em>metadata</em> of data assets, rather than
 * their actual data. Accessing the actual attached resource requires
 * additional server calls. Exactly which additional server calls are needed
 * depends on the kind of attached resource. Follow the steps below to access
 * an attached resource:
 * <ul>
 *     <li>Begin by finding the index i of the item in the <code>attachments</code> array whose <code>asset_type</code> value matches the type of the attached resource you
 *      want to access. For a <code>data_asset</code> attached resource look for the
 *      item i where <code>attachments[i].asset_type</code> is
 *      <code>data_asset</code>.<br><br>There are two important pairs of
 *      fields (among many others) which may appear in <code>attachments[i]</code>.
 *      Only one of those pairs will actually appear. Which pair appears
 *      influences which steps to perform next:
 *      <ul>
 *          <li><code>connection_id</code> and <code>connection_path</code>: These
 *              fields will appear in <code>attachments[i]</code> if the value of
 *              <code>attachments[i].is_remote</code> is true. <code>attachments[i].is_remote</code>
 *              WILL be true if the attached resource is a database table. In this case, <code>attachments[i].connection_path</code>
 *              will contain a schema name and table name. <code>attachments[i].is_remote</code> MAY be true if the attached resource is,
 *              for example, a csv file.  In this case, <code>attachments[i].connection_path</code> will contain a folder path and
 *              file name. If this pair of fields is present in <code>attachments[i]</code> then the next steps are to:
 *              <ol>
 *                  <li>use the value of the <code>attachments[i].connection_id</code> field to make a call to the <code>GET /v2/connections/{connection_id}</code> API. You'll need appropriate credentials.</li>
 *                  <li>use the values in the <code>entity.properties</code> field of the result from the step above to either create a connection to the database containing the table or to retrieve the file. Note: even if <code>attachments[i].is_remote</code> is true and the above pair of fields are present in <code>attachments[i]</code>, if the attached resource is located in the catalog/project bucket then you may optionally perform the two steps discussed for Pair 2 (<code>object_key</code> and <code>handle</code>) below.</li>
 *              </ol>
 *          </li>
 *          <li><code>object_key</code> and <code>handle</code>: these fields will appear in
 *              <code>attachments[i]</code> if the value of <code>attachments[i].is_remote</code>
 *              is false.  In this case, <code>attachments[i].handle</code> will contain
 *              information about the attached resource.
 *              <ol>
 *                  <li>use the value of the <code>attachments[i].id</code> field as the value for <code>attachment_id</code> in a call to the <code>GET /v2/assets/{asset_id}/attachments/{attachment_id}</code> API. The value to use for <code>asset_id</code> in the call to the attachments API is the same as the value that was used for <code>data_asset_id</code> in the original call to the <code>GET /v2/data_assets/{data_asset_id}</code> API.</li>
 *                  <li>use the value in the <code>url</code> field of the result from the step above to download (for example, with a browser) a copy of the file.</li>
 *              </ol>
 *          </li>
 *      </ul>
 *    </li>
 * </ul>
 * @see #get(String, String, String, String, String)
 */
public class DataAssetsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/data_assets";

    @Autowired
    public DataAssetsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create a data asset.
     * You can use this API to add data assets to a catalog.
     * @param dataAsset Data Asset Metadata
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return AssetCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> create(@NonNull Asset dataAsset,
                                            String catalogId,
                                            String projectId,
                                            String spaceId)
            throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<AssetCreateResponse> localVarReturnType = new ParameterizedTypeReference<AssetCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, dataAsset,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve <em>metadata</em> about a data asset. The response
     * document will contain three top-level fields:
     * <ul>
     *     <li>metadata: contains metadata common to all types of assets</li>
     *     <li>entity: contains metadata specific to the data_asset</li>
     *     <li>attachments: an array containing one item of metadata per attached resource</li>
     * </ul>
     * The data described by the above metadata is
     * stored in attached resources. Examples of attached resources are database
     * tables, csv files, word documents, extended metadata documents, etc.
     * Because an item in the <code>attachments</code> array only contains metadata
     * about an attached resource, accessing the actual attached resource requires
     * additional server calls.
     * @param dataAssetId data_asset_id
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @param catalogId catalog_id
     * @param projectId project_id (only catalog_id is supported at this time)
     * @param spaceId space_id (only catalog_id is supported at this time)
     * @return {@code Mono<Asset>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Asset> get(@NonNull String dataAssetId,
                           String revisionId,
                           String catalogId,
                           String projectId,
                           String spaceId)
            throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("data_asset_id", dataAssetId);

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

        ParameterizedTypeReference<Asset> localVarReturnType = new ParameterizedTypeReference<Asset>() {};
        return apiClient.invokeAPI(BASE_API + "/{data_asset_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
