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
 * API endpoints dealing with Assets.
 */
public class AssetsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/assets";

    @Autowired
    public AssetsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Add/Update asset collaborators
     * Use this API to add or remove collaborators on an asset. You must have
     * Editor or Admin permissions on the catalog and be an asset collaborator to
     * add an asset collaborator.These abilities apply to the public
     * setting:&lt;br/&gt;All members of the catalog can find the asset and see
     * its properties. &lt;br/&gt;All members of the catalog who have the Editor,
     * Auditor, or Admin roles can use the asset. &lt;br/&gt;These abilities apply
     * to the private setting:&lt;br/&gt;All asset collaborators can find the
     * asset and see its properties. Asset collaborators with the Editor, Auditor,
     * or Admin role can use the asset. <p><b>200</b> - OK <p><b>400</b> - Bad
     * Request <p><b>401</b> - Unauthorized <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>412</b> - Precondition Failed
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>500</b> - Internal Server Error
     * @param assetId Asset GUID
     * @param body JSON array of patch operations as defined in RFC 6902. See
     *     http://jsonpatch.com/ for more info. &lt;br/&gt;[     {
     *     \&quot;op\&quot;: \&quot;add\&quot;, \&quot;path\&quot;:
     *     \&quot;/metadata/rov/collaborator_ids/test-iam-id\&quot;,
     *     \&quot;value\&quot;:
     *     {\&quot;user_id\&quot;:\&quot;test@us.ibm.com\&quot;,
     *     \&quot;user_iam_id\&quot;:\&quot;test-iam-id\&quot;},     {
     *     \&quot;op\&quot;: \&quot;replace\&quot;, \&quot;path\&quot;:
     *     \&quot;/metadata/rov/collaborator_ids/test-iam-id\&quot;,
     *     \&quot;value\&quot;:
     *     {\&quot;user_id\&quot;:\&quot;test2-iam-id\&quot;},
     *     \&quot;user_iam_id\&quot;:\&quot;test-iam-id\&quot;    {
     *     \&quot;op\&quot;: \&quot;remove\&quot;, \&quot;path\&quot;:
     *     \&quot;/metadata/rov/collaborator_ids/test2-iam-id\&quot;}]
     *     (DEPRECATED) [     { \&quot;op\&quot;: \&quot;add\&quot;,
     *     \&quot;path\&quot;:
     *     \&quot;/metadata/rov/collaborators/test@us.ibm.com\&quot;,
     *     \&quot;value\&quot;:
     *     {\&quot;user_id\&quot;:\&quot;test@us.ibm.com\&quot;},     {
     *     \&quot;op\&quot;: \&quot;replace\&quot;, \&quot;path\&quot;:
     *     \&quot;/metadata/rov/collaborators/test@us.ibm.com\&quot;,
     *     \&quot;value\&quot;:
     *     {\&quot;user_id\&quot;:\&quot;test2@us.ibm.com\&quot;},     {
     *     \&quot;op\&quot;: \&quot;remove\&quot;, \&quot;path\&quot;:
     *     \&quot;/metadata/rov/collaborators/test2@us.ibm.com\&quot;} ]
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Asset
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Asset> addAndUpdateCollaborators(String assetId,
                                                 List<JSONResourcePatchModel> body,
                                                 String catalogId,
                                                 String projectId,
                                                 String spaceId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling addAndUpdateNewAssetCollaboratorsV2");
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling addAndUpdateNewAssetCollaboratorsV2");
        }
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

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json", "application/merge-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Asset> localVarReturnType = new ParameterizedTypeReference<Asset>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/collaborators",
                HttpMethod.PATCH, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Clone an asset
     * Use this API to clone catalog asset to project. This will create new copy
     * of asset metadata, including asset attachments. <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog_id must be provided
     * @param assetId asset_id
     * @param assetCopyTo copy asset to
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> clone(String catalogId, String assetId, AssetCopyTo assetCopyTo) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling cloneAssetV2");
        }
        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling cloneAssetV2");
        }
        // verify the required parameter 'assetCopyTo' is set
        if (assetCopyTo == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetCopyTo' when calling cloneAssetV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetCreateResponse> localVarReturnType = new ParameterizedTypeReference<AssetCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/clone", HttpMethod.POST, pathParams, queryParams,
                assetCopyTo, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Commit a revision of an asset
     * Use this API to commit a revision of an asset in project or space.
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param projectId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param spaceId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param assetCommitOptions Commit options
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> commitRevision(String assetId,
                                                    String projectId,
                                                    String spaceId,
                                                    AssetCommitOptions assetCommitOptions) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling commitRevision");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetCreateResponse> localVarReturnType = new ParameterizedTypeReference<AssetCreateResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/revisions",
                HttpMethod.POST, pathParams, queryParams,
                assetCommitOptions, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Create an asset
     * Use this API to create an asset in catalog or project. Assets contain
     * information about the contents of your data and how to access the data. You
     * store asset metadata in a catalog and add collaborators from your
     * organization to analyze data. Your data can reside in a variety of sources.
     * For example, you can keep your data in your existing on-premises data
     * sources, cloud data services, or streaming data feeds. By adding connection
     * information to these remote sources in the catalog, you can allow other
     * catalog users to access the data with the stored credentials.
     * Alternatively, you can copy a snapshot of the remote data into the
     * catalog&#39;s encrypted cloud storage.&lt;br/&gt;All asset types have a
     * common set of properties. Some asset types have additional
     * properties.&lt;br/&gt;When you add an asset to a catalog, you specify these
     * common properties:  * The asset name and an optional description. The name
     * can only contain letters, numbers, underscore, dash, space, and period. The
     * name can&#39;t be only blank spaces.  * Privacy. You can choose to restrict
     * access to the asset with the privacy level and asset membership.    *
     * Public &#x3D; Default. No restrictions on finding or using the asset.   *
     * Private &#x3D; Only asset members can find or use the asset.  * Members.
     * The catalog collaborators can be added as members of the asset. Members are
     * important if you restrict access to the asset. When you create an asset,
     * you are the owner (and a member) of it.  * Tags. Metadata that makes
     * searching for the asset easier. Tags can contain only letters, numbers,
     * underscores, dashes, and the symbols # and @. <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param asset Asset metadata
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> create(Asset asset, String catalogId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'asset' is set
        if (asset == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'asset' when calling createNewAssetV2");
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
                BASE_API, HttpMethod.POST, pathParams, queryParams, asset,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Publish an asset from a project which is only referenced in that project
     * Use this API to publish an asset whose only metadata are only in project as
     * reference to a target catalog. Assets contain information about the
     * contents of your data and how to access the data. You store asset metadata
     * in a catalog and add collaborators from your organization to analyze data.
     * Your data can reside in a variety of sources. For example, you can keep
     * your data in your existing on-premises data sources, cloud data services,
     * or streaming data feeds. By adding connection information to these remote
     * sources in the catalog, you can allow other catalog users to access the
     * data with the stored credentials. Alternatively, you can copy a snapshot of
     * the remote data into the catalog&#39;s encrypted cloud
     * storage.&lt;br/&gt;All asset types have a common set of properties. Some
     * asset types have additional properties.&lt;br/&gt;When you add an asset to
     * a catalog, you specify these common properties:  * The asset name and an
     * optional description. The name can only contain letters, numbers,
     * underscore, dash, space, and period. The name can&#39;t be only blank
     * spaces.  * Privacy. You can choose to restrict access to the asset with the
     * privacy level and asset membership.    * Public &#x3D; Default. No
     * restrictions on finding or using the asset.   * Private &#x3D; Only asset
     * members can find or use the asset.  * Members. The catalog collaborators
     * can be added as members of the asset. Members are important if you restrict
     * access to the asset. When you create an asset, you are the owner (and a
     * member) of it.  * Tags. Metadata that makes searching for the asset easier.
     * Tags can contain only letters, numbers, underscores, dashes, and the
     * symbols # and @. <p><b>201</b> - Created <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param publishAssetOnlyAssetMetada Asset metadata
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> publishMetadata(PublishAssetOnlyAssetMetada publishAssetOnlyAssetMetada) throws RestClientException {

        // verify the required parameter 'publishAssetOnlyAssetMetada' is set
        if (publishAssetOnlyAssetMetada == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'publishAssetOnlyAssetMetada' when calling createVirtualAssetV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetCreateResponse> localVarReturnType = new ParameterizedTypeReference<AssetCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/publish", HttpMethod.POST, pathParams, queryParams,
                publishAssetOnlyAssetMetada, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Marks an existing asset for delete
     * Use this API to delete an existing asset properties. You can delete an
     * asset if you are the owner of the asset or a member of the asset with Admin
     * or Editor permissions on the catalog or project. <p><b>204</b> - No Content
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param purgeOnDelete If true, asset is also deleted from the trash.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String assetId, String catalogId, String projectId, String spaceId, Boolean purgeOnDelete)
            throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling deleteNewAssetV2");
        }
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "purge_on_delete", purgeOnDelete));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete an asset rating
     * Use this API to delete an asset rating.
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param assetRatingId asset_rating_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deleteRating(String assetId,
                                   String assetRatingId,
                                   String catalogId,
                                   String projectId,
                                   String spaceId,
                                   String revisionId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling deleteRating");
        }
        // verify the required parameter 'assetRatingId' is set
        if (assetRatingId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetRatingId' when calling deleteRating");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("asset_rating_id", assetRatingId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/ratings/{asset_rating_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Get ratings of an asset
     * Get ratings for the specified asset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @param limit The maximum number of asset ratings to return.&lt;br/&gt;The
     *     default value is 25.
     * @param start Bookmark that gives the start of the page.
     * @param sort Sorting order.&lt;BR/&gt; Valid values:
     *     &lt;code&gt;updated_at&lt;/code&gt;,
     *     &lt;code&gt;rating&lt;/code&gt;&lt;BR/&gt; Use hyphen prefix (-) for
     *     descending order
     * @param userFilter Filter results by user.&lt;BR/&gt; Valid values:
     *     &lt;code&gt;all&lt;/code&gt;, &lt;code&gt;user&lt;/code&gt;,
     *     &lt;code&gt;other&lt;/code&gt;&lt;br/&gt; The default value is
     *     &lt;code&gt;all&lt;/code&gt;
     * @return TokenPaginatedAssetRatingList
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<TokenPaginatedAssetRatingList> getRatings(String assetId,
                                                          String catalogId,
                                                          String projectId,
                                                          String spaceId,
                                                          String revisionId,
                                                          Integer limit,
                                                          String start,
                                                          String sort,
                                                          String userFilter) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling getRatings");
        }
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "user_filter", userFilter));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<TokenPaginatedAssetRatingList> localVarReturnType = new ParameterizedTypeReference<TokenPaginatedAssetRatingList>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/ratings", HttpMethod.GET,
                pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get the count of each rating value for the specified asset
     * Get the counts of each rating value for the specified asset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @return AssetRatingStatsResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetRatingStatsResponse> getRatingsStats(String assetId,
                                                          String catalogId,
                                                          String projectId,
                                                          String spaceId,
                                                          String revisionId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling getRatingsStats");
        }
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetRatingStatsResponse> localVarReturnType = new ParameterizedTypeReference<AssetRatingStatsResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/ratings/stats",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Promote an asset
     * Use this API to promote project assets to space. You must have Admin or
     * Editor permissions on both the project and the space. <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param projectId project_id must be provided
     * @param assetId asset_id
     * @param body Asset permission and metadata.  Example: { \&quot;mode\&quot;:
     *     0, \&quot;space_id\&quot;:\&quot;string\&quot;,
     *     \&quot;metadata\&quot;:{\&quot;name\&quot;:\&quot;string\&quot;,
     *     \&quot;description\&quot;:\&quot;string\&quot;,
     *     \&quot;tags\&quot;:[\&quot;string\&quot;,\&quot;string\&quot;]} }
     *     Values for mode is 0 (public), 8 (private), 16 (hidden).     If not
     *     supplied, the currently existing mode applies.     space_id is the
     *     target space id.    Metadata may contain attributes to overwrite the
     *     values in original asset; currently only name, description and tags may
     *     be overwritten.
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> promote(String projectId, String assetId, String body, String revisionId) throws RestClientException {

        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'projectId' when calling promoteAssetV2");
        }
        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling promoteAssetV2");
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling promoteAssetV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/promote", HttpMethod.POST,
                pathParams, queryParams, body, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Publish an asset
     * Use this API to publish project assets to catalog. You can publish data
     * assets from a project into a catalog. You must have Admin or Editor
     * permissions on both the project and the catalog. <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param projectId project_id must be provided
     * @param assetId asset_id
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @param body Asset permission and metadata.  Example: { \&quot;mode\&quot;:
     *     0, \&quot;catalog_id\&quot;:\&quot;string\&quot;,
     *     \&quot;metadata\&quot;:{\&quot;name\&quot;:\&quot;string\&quot;,
     *     \&quot;description\&quot;:\&quot;string\&quot;,
     *     \&quot;tags\&quot;:[\&quot;string\&quot;,\&quot;string\&quot;]} }
     *     Values for mode is 0 (public), 8 (private), 16 (hidden).     If not
     *     supplied, the currently existing mode applies.     catalog_id is the
     *     target catalog id. To support backwards compatibility when it is not
     *     supplied, the asset is published to the catalog associated with the
     *     project.    Metadata may contain attributes to overwrite the values in
     *     original asset; currently only name, description and tags may be
     *     overwritten.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> publishData(String projectId, String assetId, String revisionId, PublishAssetRequest body) throws RestClientException {

        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'projectId' when calling publishNewAssetV2");
        }
        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling publishNewAssetV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetCreateResponse> localVarReturnType = new ParameterizedTypeReference<AssetCreateResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/publish", HttpMethod.POST,
                pathParams, queryParams, body, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Rate an asset
     * Use this API to rate an asset.
     * <p><b>200</b> - successful operation
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param assetRatingEntity Asset rating to be created
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @return AssetRating
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetRating> rateAsset(String assetId,
                                       AssetRatingEntity assetRatingEntity,
                                       String catalogId,
                                       String projectId,
                                       String spaceId,
                                       String revisionId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling rateAsset");
        }
        // verify the required parameter 'assetRatingEntity' is set
        if (assetRatingEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetRatingEntity' when calling rateAsset");
        }
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetRating> localVarReturnType = new ParameterizedTypeReference<AssetRating>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/ratings", HttpMethod.POST,
                pathParams, queryParams, assetRatingEntity, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get an asset
     * Use this API to retrieve an asset located in catalog or project. Access to
     * an asset is controlled by a combination of the privacy level and the
     * members of the asset. For a governed catalog, data assets are protected
     * from unauthorized access by the governance policies that are defined in
     * Data Catalog. Data assets in ungoverned catalogs are not subject to
     * governance policies. <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> get(String assetId,
                                          String catalogId,
                                          String projectId,
                                          String spaceId,
                                          String revisionId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling retrieveNewAssetV2");
        }
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<MetadataEntityResult> localVarReturnType = new ParameterizedTypeReference<MetadataEntityResult>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get a list of revisions for an asset
     * Use this API to retrieve an ordered list of revisions for an asset, most to
     * least recent. <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b>
     * - Unauthorized <p><b>403</b> - Forbidden <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param projectId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param spaceId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param limit The maximum number of revisions to return. The default is 25.
     *     Maximum is 200
     * @param start The revision number to start from, or &#39;latest&#39;. Latest
     *     revision is the default.
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<FindAssetsResponse> getRevisions(String assetId, String projectId, String spaceId, Integer limit, String start) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling retrieveRevisions");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<FindAssetsResponse> localVarReturnType = new ParameterizedTypeReference<FindAssetsResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{asset_id}/revisions",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update the owner of an asset
     * Use this API to assign new owner of an asset. You must be the current owner
     * of the asset or a collaborator of the asset with Admin permissions to
     * change the owner. <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param assetOwner Asset Owner
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> updateOwner(String assetId,
                                                  AssetOwner assetOwner,
                                                  String catalogId,
                                                  String projectId,
                                                  String spaceId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling updateNewAssetOwnerV2");
        }
        // verify the required parameter 'assetOwner' is set
        if (assetOwner == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetOwner' when calling updateNewAssetOwnerV2");
        }
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

        ParameterizedTypeReference<MetadataEntityResult> localVarReturnType = new ParameterizedTypeReference<MetadataEntityResult>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/owner", HttpMethod.PUT, pathParams, queryParams,
                assetOwner, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update privacy settings of an asset
     * Use this API to change privacy settings on an asset.&lt;br/&gt;  * The
     * owner of the asset or asset collaborators with the Admin role can change
     * the owner of the asset or delete the asset.  * Asset collaborators with the
     * Editor, Auditor, or Admin role can change the asset members or the privacy
     * setting. <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param assetRovMembers Asset ROV
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> updateRov(String assetId,
                                                AssetRovMembers assetRovMembers,
                                                String catalogId,
                                                String projectId,
                                                String spaceId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling updateNewAssetRovV2");
        }
        // verify the required parameter 'assetRovMembers' is set
        if (assetRovMembers == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetRovMembers' when calling updateNewAssetRovV2");
        }
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

        ParameterizedTypeReference<MetadataEntityResult> localVarReturnType = new ParameterizedTypeReference<MetadataEntityResult>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/perms", HttpMethod.PUT, pathParams, queryParams,
                assetRovMembers, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update an asset
     * Use this API to edit  an existing asset properties, if you have proper
     * permissions. Who can edit asset properties depends on the privacy setting
     * of the asset:&lt;br/&gt;If the asset privacy setting is public, you must
     * have Editor or Admin permissions on the catalog to edit asset properties.
     * If the asset privacy setting is private, you must have Editor or Admin
     * permissions on the catalog and be an asset member to edit asset properties.
     * You can edit these asset properties:  * Name   * Description   * Tags   *
     * Classification   * Resource key   *
     * source_system.last_modification_timestamp, Expected Format:
     * \&quot;yyyy-MM-ddTHH:mm:ssX\&quot; <p><b>200</b> - OK <p><b>204</b> - No
     * Content <p><b>400</b> - Bad Request <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param body JSON array of patch operations as defined in RFC
     *     6902.&lt;br/&gt;
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Asset
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> update(String assetId,
                                             List<JSONResourcePatchModel> body,
                                             String catalogId,
                                             String projectId,
                                             String spaceId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling updateNewAssetV2");
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling updateNewAssetV2");
        }
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

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<MetadataEntityResult> localVarReturnType = new ParameterizedTypeReference<MetadataEntityResult>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}", HttpMethod.PATCH, pathParams, queryParams,
                body, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update an asset rating
     * Use this API to update an asset rating.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param assetId asset_id
     * @param assetRatingId asset_rating_id
     * @param assetRatingEntity Asset rating to be updated
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use &#39;latest&#39; for the most recent
     *     revision.
     * @return AssetRating
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetRating> updateRating(String assetId,
                                          String assetRatingId,
                                          AssetRatingEntity assetRatingEntity,
                                          String catalogId,
                                          String projectId,
                                          String spaceId,
                                          String revisionId) throws RestClientException {

        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetId' when calling updateRating");
        }
        // verify the required parameter 'assetRatingId' is set
        if (assetRatingId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetRatingId' when calling updateRating");
        }
        // verify the required parameter 'assetRatingEntity' is set
        if (assetRatingEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'assetRatingEntity' when calling updateRating");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("asset_id", assetId);
        pathParams.put("asset_rating_id", assetRatingId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "revision_id", revisionId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<AssetRating> localVarReturnType = new ParameterizedTypeReference<AssetRating>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/ratings/{asset_rating_id}", HttpMethod.PATCH,
                pathParams, queryParams, assetRatingEntity, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

}
