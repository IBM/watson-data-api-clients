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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

/**
 * API endpoints for dealing with data assets.
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
     * Create a data asset
     * You can use this API to add data assets to a catalog. Data assets could be
     * data from a connection to a data source (ex. tables) or files from your
     * local system uploaded into cloud object storage associated with Projects or
     * Catalog.All asset types have a common set of properties, such as name,
     * description, asset type, visibility, tags, classifications. Data Asset have
     * additional attributes such as mime type, columns with types, and
     * properties. Use v2/attachments API to indicate location of data (ex. table
     * path) from a connection to a data source. <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param dataAsset Data Asset Metadata
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return {@code Mono<AssetCreateResponse>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> create(Asset dataAsset, String catalogId, String projectId, String spaceId)
            throws RestClientException {

        // verify the required parameter 'dataAsset' is set
        if (dataAsset == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataAsset' when calling createDataAssetV2");
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
     * Get a data asset
     * Use this API to retrieve _metadata_ about a data asset. The response
     * document will contain three top-level fields:&lt;br/&gt;  *
     * **&#39;metadata&#39;:** contains metadata common to all types of assets  *
     * **&#39;entity&#39;:** contains metadata specific to the asset_type - in
     * this case &#39;data_asset&#39;  * **&#39;attachments&#39;:** an array
     * containing one item of metadata per attached
     * resource&lt;br/&gt;&lt;br/&gt;The data described by the above metadata is
     * stored in attached resources.  Examples of attached resources are database
     * tables, csv files, word documents, extended metadata documents, etc.
     * Because an item in the &#39;attachments&#39; array only contains metadata
     * about an attached resource, accessing the actual attached resource requires
     * additional server calls.  Exactly which additional server calls are needed
     * depends on the kind of attached resource.  Follow the steps below to access
     * an attached resource.&lt;br/&gt;&lt;br/&gt;     **Step 1**: find the index
     * i of the item in the above &#39;attachments&#39; array whose
     * &#39;asset_type&#39; value matches the type of the attached resource you
     * want to access.  For a &#39;data_asset&#39; attached resource look for the
     * item i where &#39;attachments[i].asset_type&#39; is
     * &#39;data_asset&#39;.&lt;br/&gt;&lt;br/&gt;There are two important pairs of
     * fields (among many others) which may appear in &#39;attachments[i]&#39;.
     * Only one of those pairs will actually appear.  Which pair appears
     * influences which steps to perform next.&lt;br/&gt;  *  **Pair 1:**
     * **&#39;connection_id&#39;** and **&#39;connection_path&#39;**:   * The
     * above two fields will appear in &#39;attachments[i]&#39; if the value of
     * &#39;attachments[i].is_remote&#39; is true.   *
     * &#39;attachments[i].is_remote&#39; WILL be true if the attached resource is
     * a database table.  In this case, &#39;attachments[i].connection_path&#39;
     * will contain a schema name and table name.   *
     * &#39;attachments[i].is_remote&#39; MAY be true if the attached resource is,
     * for example, a csv file.  In this case,
     * &#39;attachments[i].connection_path&#39; will contain a folder path and
     * file name.&lt;br/&gt;&lt;br/&gt;If the above pair of fields are present in
     * &#39;attachments[i]&#39; then:&lt;br/&gt;     **Step 2**: use the value of
     * the &#39;attachments[i].connection_id&#39; field to make a call to the
     * **GET /v2/connections/{connection_id}** API.  You&#39;ll need appropriate
     * credentials.&lt;br/&gt;     **Step 3**: use the values in the
     * &#39;entity.properties&#39; field of the result from Step 2 to either
     * create a connection to the database containing the table or to retrieve the
     * file.&lt;br/&gt;&lt;br/&gt;Note: even if &#39;attachments[i].is_remote&#39;
     * is true and the above pair of fields are present in
     * &#39;attachments[i]&#39;, if the attached resource is located in the
     * catalog/project bucket then you may optionally perform the two steps
     * discussed for Pair 2 (&#39;object_key&#39; and &#39;handle&#39;)
     * below.&lt;br/&gt;  * **Pair 2:** **&#39;object_key&#39;** and
     * **&#39;handle&#39;**:   * The above two fields will appear in
     * &#39;attachments[i]&#39; if the value of &#39;attachments[i].is_remote&#39;
     * is false.  In this case, &#39;attachments[i].handle&#39; will contain
     * information about the attached resource.&lt;br/&gt;     **Step 2**: use the
     * value of the &#39;attachments[i].id&#39; field as the value for
     * &#39;attachment_id&#39; in a call to the **GET
     * /v2/assets/{asset_id}/attachments/{attachment_id}** API.  The value to use
     * for &#39;asset_id&#39; in the call to the attachments API is the same as
     * the value that was used for &#39;data_asset_id&#39; in the original call to
     * the GET /v2/data_assets/{data_asset_id} API.&lt;br/&gt;     **Step 3**: use
     * the value in the &#39;url&#39; field of the result from Step 2 to download
     * (for example, with a browser) a copy of the file. <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param dataAssetId data_asset_id
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @param catalogId catalog_id
     * @param projectId project_id (only catalog_id is supported at this time)
     * @param spaceId space_id (only catalog_id is supported at this time)
     * @return {@code Mono<Asset>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Asset> get(String dataAssetId, String revisionId, String catalogId, String projectId, String spaceId)
            throws RestClientException {

        // verify the required parameter 'dataAssetId' is set
        if (dataAssetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataAssetId' when calling getDataAssetV2");
        }
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
