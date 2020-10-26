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
 * API endpoints dealing with Asset Types.
 */
public class AssetTypesApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/asset_types";

    @Autowired
    public AssetTypesApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * List all asset types defined for a catalog
     *  Get all asset types in a catalog
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return TypesResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<TypesResponse> list(String catalogId, String projectId, String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<TypesResponse> localVarReturnType = new ParameterizedTypeReference<TypesResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieves an asset type of a given name
     *  Retrieves an asset type of a given name
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param typeName Asset Type name (eg: data_asset)
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Type
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Type> get(String typeName, String catalogId, String projectId, String spaceId) throws RestClientException {

        // verify the required parameter 'typeName' is set
        if (typeName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'typeName' when calling getCatalogType");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("type_name", typeName);

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

        ParameterizedTypeReference<Type> localVarReturnType = new ParameterizedTypeReference<Type>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{type_name}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Replace an asset type
     * Replace asset attributes for the given asset type or create a new asset
     * type if the given asset type does not exist.  Enter
     * url_parameters_from_asset_attributes : [\&quot;id\&quot;,
     * \&quot;name.short_name\&quot;] <p><b>200</b> - OK <p><b>400</b> - Bad
     * Request <p><b>401</b> - Unauthorized <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param typeName Asset Type name (eg: data_asset)
     * @param updateType Asset Type request body
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @return Type
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Type> replace(String typeName, UpdateType updateType, String catalogId, String projectId, String spaceId)
            throws RestClientException {

        // verify the required parameter 'typeName' is set
        if (typeName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'typeName' when calling replaceAssetType");
        }
        // verify the required parameter 'updateType' is set
        if (updateType == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updateType' when calling replaceAssetType");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("type_name", typeName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Type> localVarReturnType = new ParameterizedTypeReference<Type>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{type_name}", HttpMethod.PUT, pathParams, queryParams,
                updateType, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Search for asset metadata within assets of the specified type
     * Use this api to Search for assets for generic asset type (asset) or any
     * specific asset type in given Catalog&lt;br/&gt;&lt;b&gt; Examples of Search
     * query&lt;br/&gt; Search With Pagination &lt;/b&gt;&lt;br/&gt;User can
     * request specific number of Search results with  adding limit param to
     * request as shown below.By default it will return upto 200  Search results
     * &lt;br/&gt;Request Body&lt;br/&gt;{&lt;br/&gt;    \&quot;query\&quot; :
     * \&quot;asset.name:Asset*,\&quot; &lt;br/&gt;    \&quot;limit\&quot; :
     * 2&lt;br/&gt;}&lt;br/&gt;&lt;br/&gt;Response
     * :&lt;br/&gt;{&lt;br/&gt;\&quot;next\&quot;:
     * {&lt;br/&gt;\&quot;bookmark\&quot;: \&quot;g1AAAXXXXXXXX\&quot;,&lt;br/&gt;
     * \&quot;query\&quot; : \&quot;asset.name:Asset*,\&quot; &lt;br/&gt;
     * \&quot;limit\&quot; : 2&lt;br/&gt;},&lt;br/&gt;\&quot;results\&quot;:
     * [&lt;br/&gt; {  ..asset 1... }, {  ..asset 2...
     * }],&lt;br/&gt;\&quot;total_rows\&quot;: 3&lt;br/&gt;}&lt;br/&gt;When more
     * search results available then  response will contain \&quot;next\&quot;
     * json object.\&quot;next\&quot; contains \&quot;bookmark\&quot; along with
     * original query which needs to be returned to retrieve next sets of
     * result.&lt;br/&gt; Please resend the request with whatever is returned in
     * \&quot;next\&quot; object. &lt;br/&gt;The Last page will not have
     * \&quot;next\&quot; object <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param typeName Asset Type name (eg: data_asset)
     * @param catalogSearch Search Criteria
     * @param catalogId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param projectId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @param spaceId You must provide either a catalog id, a project id, or a
     *     space id, but not more than one
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<FindAssetsResponse> findAssetsByType(String typeName,
                                                     CatalogSearch catalogSearch,
                                                     String catalogId,
                                                     String projectId,
                                                     String spaceId) throws RestClientException {

        // verify the required parameter 'typeName' is set
        if (typeName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'typeName' when calling searchNewAssetV2");
        }
        // verify the required parameter 'catalogSearch' is set
        if (catalogSearch == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogSearch' when calling searchNewAssetV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("type_name", typeName);

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

        ParameterizedTypeReference<FindAssetsResponse> localVarReturnType = new ParameterizedTypeReference<FindAssetsResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{type_name}/search",
                HttpMethod.POST, pathParams, queryParams,
                catalogSearch, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
