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
 * API endpoints dealing with Assets.
 *
 * Assets contain information about the contents of your data and how to access the data. You
 * store asset metadata in a catalog and add collaborators from your
 * organization to analyze data. Your data can reside in a variety of sources.
 * For example, you can keep your data in your existing on-premises data
 * sources, cloud data services, or streaming data feeds. By adding connection
 * information to these remote sources in the catalog, you can allow other
 * catalog users to access the data with the stored credentials.
 * Alternatively, you can copy a snapshot of the remote data into the
 * catalog's encrypted cloud storage.<br><br>
 * All asset types have a common set of properties. Some asset types have additional
 * properties. When you add an asset to a catalog, you specify these
 * common properties:
 * <ul>
 *     <li>The asset name and an optional description. The name can only contain letters, numbers, underscore, dash, space, and period. The name can't be only blank spaces.</li>
 *     <li>Privacy. You can choose to restrict access to the asset with the privacy level and asset membership.
 *     <ul>
 *         <li>Public (default): No restrictions on finding or using the asset.</li>
 *         <li>Private: Only asset members can find or use the asset.</li>
 *     </ul>
 *     </li>
 *     <li>Members. The catalog collaborators can be added as members of the asset. Members are important if you restrict access to the asset. When you create an asset, you are the owner (and a member) of it.</li>
 *     <li>Tags. Metadata that makes searching for the asset easier. Tags can contain only letters, numbers, underscores, dashes, and the symbols # and @.</li>
 * </ul>
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
     * Add or remove collaborators on an asset. You must have
     * Editor or Admin permissions on the catalog and be an asset collaborator to
     * add an asset collaborator.These abilities apply to the public
     * setting:
     * <ul>
     *     <li>All members of the catalog can find the asset and see its properties.</li>
     *     <li>All members of the catalog who have the Editor, Auditor, or Admin roles can use the asset.</li>
     * </ul>
     * These abilities apply to the private setting:
     * <ul>
     *     <li>All asset collaborators can find the asset and see its properties.</li>
     *     <li>Asset collaborators with the Editor, Auditor, or Admin role can use the asset.</li>
     * </ul>
     * Example body:
     * <code>[{ "op": "add", "path": "/metadata/rov/collaborator_ids/1000331015", "value": { "user_iam_id": "1000331015" }}]</code>
     * @param assetId Asset GUID
     * @param body JSON array of patch operations as defined in RFC 6902. See
     *     http://jsonpatch.com/ for more info.
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
    public Mono<Asset> addAndUpdateCollaborators(@NonNull String assetId,
                                                 @NonNull List<JSONResourcePatchModel> body,
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
     * Clone catalog asset to project. This will create new copy
     * of asset metadata, including asset attachments.
     * @param catalogId catalog_id must be provided
     * @param assetId asset_id
     * @param assetCopyTo copy asset to
     * @return AssetCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> clone(@NonNull String catalogId,
                                           @NonNull String assetId,
                                           @NonNull AssetCopyTo assetCopyTo) throws RestClientException {

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
     * Commit a revision of an asset in project or space.
     * @param assetId asset_id
     * @param projectId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param spaceId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param assetCommitOptions Commit options
     * @return AssetCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> commitRevision(@NonNull String assetId,
                                                    String projectId,
                                                    String spaceId,
                                                    AssetCommitOptions assetCommitOptions) throws RestClientException {

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
     * Create an asset in catalog or project.
     * @param asset Asset metadata
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
    public Mono<AssetCreateResponse> create(@NonNull Asset asset,
                                            String catalogId,
                                            String projectId,
                                            String spaceId) throws RestClientException {

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
     * Publish an asset whose only metadata are only in project as
     * reference to a target catalog.
     * @param publishAssetOnlyAssetMetadata Asset metadata
     * @return AssetCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> publishMetadata(@NonNull PublishAssetOnlyAssetMetada publishAssetOnlyAssetMetadata) throws RestClientException {

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
                publishAssetOnlyAssetMetadata, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete an existing asset. You can delete an
     * asset if you are the owner of the asset or a member of the asset with Admin
     * or Editor permissions on the catalog or project.
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param purgeOnDelete If true, asset is also deleted from the trash.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String assetId,
                             String catalogId,
                             String projectId,
                             String spaceId,
                             Boolean purgeOnDelete)
            throws RestClientException {

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
     * Delete an asset rating.
     * @param assetId asset_id
     * @param assetRatingId asset_rating_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use "latest" for the most recent
     *     revision.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deleteRating(@NonNull String assetId,
                                   @NonNull String assetRatingId,
                                   String catalogId,
                                   String projectId,
                                   String spaceId,
                                   String revisionId) throws RestClientException {

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
     * Get ratings for the specified asset.
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @param limit The maximum number of asset ratings to return. The
     *     default value is 25.
     * @param start Bookmark that gives the start of the page.
     * @param sort Sorting order. Valid values: <code>updated_at</code>, <code>rating</code>.
     *     Use hyphen prefix (-) for descending order
     * @param userFilter Filter results by user. Valid values:
     *     <code>all</code>, <code>user</code>,<code>other</code>. The default value is
     *     <code>all</code>.
     * @return TokenPaginatedAssetRatingList
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<TokenPaginatedAssetRatingList> getRatings(@NonNull String assetId,
                                                          String catalogId,
                                                          String projectId,
                                                          String spaceId,
                                                          String revisionId,
                                                          Integer limit,
                                                          String start,
                                                          String sort,
                                                          String userFilter) throws RestClientException {

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
     * Get the counts of each rating value for the specified asset.
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @return AssetRatingStatsResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetRatingStatsResponse> getRatingsStats(@NonNull String assetId,
                                                          String catalogId,
                                                          String projectId,
                                                          String spaceId,
                                                          String revisionId) throws RestClientException {

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
     * Promote project assets to space. You must have Admin or
     * Editor permissions on both the project and the space.
     * <br><br>
     * Example body:
     * <code>{ "mode": 0, "space_id": "string", "metadata": { "name": "string", "description": "string", "tags": [ "string", "string" ] }}</code>
     * @param projectId project_id must be provided
     * @param assetId asset_id
     * @param body Asset permission and metadata.
     *     Values for mode are 0 (public), 8 (private), 16 (hidden).     If not
     *     supplied, the currently existing mode applies.     space_id is the
     *     target space id.    Metadata may contain attributes to overwrite the
     *     values in original asset; currently only name, description and tags may
     *     be overwritten.
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> promote(@NonNull String projectId,
                              @NonNull String assetId,
                              @NonNull String body,
                              String revisionId) throws RestClientException {

        // TODO: replace 'body' parameter with an actual bean defining the structure (and 'mode' with an enumeration)
        //  (see below for PublishAssetRequest that has similar structure)

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
     * Publish project assets to catalog. You can publish data
     * assets from a project into a catalog. You must have Admin or Editor
     * permissions on both the project and the catalog.
     * <br><br>
     * Example body:
     * <code>{ "mode": 0, "catalog_id": "string", "metadata": { "name": "string", "description": "string", "tags": [ "string", "string" ] }}</code>
     * @param projectId project_id must be provided
     * @param assetId asset_id
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @param body Asset permission and metadata.
     *     Values for mode is 0 (public), 8 (private), 16 (hidden).     If not
     *     supplied, the currently existing mode applies.     catalog_id is the
     *     target catalog id. To support backwards compatibility when it is not
     *     supplied, the asset is published to the catalog associated with the
     *     project.    Metadata may contain attributes to overwrite the values in
     *     original asset; currently only name, description and tags may be
     *     overwritten.
     * @return AssetCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetCreateResponse> publishData(@NonNull String projectId,
                                                 @NonNull String assetId,
                                                 String revisionId,
                                                 PublishAssetRequest body) throws RestClientException {

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
     * Use this API to rate an asset.
     * @param assetId asset_id
     * @param assetRatingEntity Asset rating to be created
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @return AssetRating
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetRating> rateAsset(@NonNull String assetId,
                                       @NonNull AssetRatingEntity assetRatingEntity,
                                       String catalogId,
                                       String projectId,
                                       String spaceId,
                                       String revisionId) throws RestClientException {

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
     * Retrieve an asset located in catalog or project. Access to
     * an asset is controlled by a combination of the privacy level and the
     * members of the asset. For a governed catalog, data assets are protected
     * from unauthorized access by the governance policies that are defined in
     * Data Catalog. Data assets in ungoverned catalogs are not subject to
     * governance policies.
     * @param assetId asset_id
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param revisionId Revision id (1, 2, 3, ...), or leave empty for the
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @return MetadataEntityResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> get(@NonNull String assetId,
                                          String catalogId,
                                          String projectId,
                                          String spaceId,
                                          String revisionId) throws RestClientException {

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
     * Retrieve an ordered list of revisions for an asset, most to
     * least recent.
     * @param assetId asset_id
     * @param projectId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param spaceId You must provide either a a project id, or a space id, but
     *     not more than one
     * @param limit The maximum number of revisions to return. The default is 25.
     *     Maximum is 200
     * @param start The revision number to start from, or <code>latest</code>. Latest
     *     revision is the default.
     * @return FindAssetsResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<FindAssetsResponse> getRevisions(@NonNull String assetId,
                                                 String projectId,
                                                 String spaceId,
                                                 Integer limit,
                                                 String start) throws RestClientException {

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
     * Assign new owner of an asset. You must be the current owner
     * of the asset or a collaborator of the asset with Admin permissions to
     * change the owner.
     * @param assetId asset_id
     * @param assetOwner Asset Owner
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return MetadataEntityResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> updateOwner(@NonNull String assetId,
                                                  @NonNull AssetOwner assetOwner,
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

        ParameterizedTypeReference<MetadataEntityResult> localVarReturnType = new ParameterizedTypeReference<MetadataEntityResult>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/owner", HttpMethod.PUT, pathParams, queryParams,
                assetOwner, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Change privacy settings on an asset.
     * <ul>
     *     <li>The owner of the asset or asset collaborators with the Admin role can change the owner of the asset or delete the asset.</li>
     *     <li>Asset collaborators with the Editor, Auditor, or Admin role can change the asset members or the privacy setting.</li>
     * </ul>
     * @param assetId asset_id
     * @param assetRovMembers Asset ROV
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return MetadataEntityResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> updateRov(@NonNull String assetId,
                                                @NonNull BaseRov assetRovMembers,
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

        ParameterizedTypeReference<MetadataEntityResult> localVarReturnType = new ParameterizedTypeReference<MetadataEntityResult>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{asset_id}/perms", HttpMethod.PUT, pathParams, queryParams,
                assetRovMembers, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Edit an existing asset's properties, if you have proper
     * permissions. Who can edit asset properties depends on the privacy setting
     * of the asset:
     * <ul>
     *     <li>If the asset privacy setting is public, you must have Editor or Admin permissions on the catalog to edit asset properties.</li>
     *     <li>If the asset privacy setting is private, you must have Editor or Admin permissions on the catalog and be an asset member to edit asset properties.</li>
     * </ul>
     * You can edit these asset properties:
     * <ul>
     *     <li>Name</li>
     *     <li>Description</li>
     *     <li>Tags</li>
     *     <li>Classification</li>
     *     <li>Resource key <code>source_system.last_modification_timestamp</code> (with format: <code>yyyy-MM-ddTHH:mm:ssX</code>)</li>
     * </ul>
     * @param assetId asset_id
     * @param body JSON array of patch operations as defined in RFC
     *     6902.
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return MetadataEntityResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MetadataEntityResult> update(@NonNull String assetId,
                                             @NonNull List<JSONResourcePatchModel> body,
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
     * Update an asset rating.
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
     *     current asset version. Use <code>latest</code> for the most recent
     *     revision.
     * @return AssetRating
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<AssetRating> updateRating(@NonNull String assetId,
                                          @NonNull String assetRatingId,
                                          @NonNull AssetRatingEntity assetRatingEntity,
                                          String catalogId,
                                          String projectId,
                                          String spaceId,
                                          String revisionId) throws RestClientException {

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
