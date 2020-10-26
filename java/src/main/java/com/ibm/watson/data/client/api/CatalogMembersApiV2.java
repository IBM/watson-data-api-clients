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
import com.ibm.watson.data.client.model.Member;
import com.ibm.watson.data.client.model.MemberRole;
import com.ibm.watson.data.client.model.MemberSearchResult;
import com.ibm.watson.data.client.model.MemberSet;
import com.ibm.watson.data.client.model.MemberSetPartialResult;
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
 * API endpoints dealing with Catalog membership.
 */
public class CatalogMembersApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/catalogs/{catalog_id}/members";

    @Autowired
    public CatalogMembersApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Add members to a catalog
     *  Adds members to a catalog. A catalog member can be a user or an access
     * group. <p><b>200</b> - OK <p><b>201</b> - Created <p><b>400</b> - Bad
     * Request <p><b>401</b> - Unauthorized <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param memberSet Members with roles
     * @return MemberSetPartialResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MemberSetPartialResult> add(String catalogId, MemberSet memberSet) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling addNewMembersV2");
        }
        // verify the required parameter 'memberSet' is set
        if (memberSet == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'memberSet' when calling addNewMembersV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<MemberSetPartialResult> localVarReturnType = new ParameterizedTypeReference<MemberSetPartialResult>() {};
        return apiClient.invokeAPI(BASE_API,
                HttpMethod.POST, pathParams, queryParams,
                memberSet, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete a member from a catalog
     *  Delete a member from a catalog.
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param memberId Member GUID
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String catalogId, String memberId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling deleteMemberV2");
        }
        // verify the required parameter 'memberId' is set
        if (memberId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'memberId' when calling deleteMemberV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("member_id", memberId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{member_id}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get catalog membership for a specific user
     *  Returns any memberships this user has on the catalog, including direct
     * membership and any access group memberships. <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param memberId member ID
     * @return MemberSet
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MemberSet> get(String catalogId, String memberId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getMemberV2");
        }
        // verify the required parameter 'memberId' is set
        if (memberId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'memberId' when calling getMemberV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("member_id", memberId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<MemberSet> localVarReturnType = new ParameterizedTypeReference<MemberSet>() {};
        return apiClient.invokeAPI(BASE_API + "/{member_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List all members of the catalog
     *  Get members for the catalog.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param limit limit
     * @param bookmark bookmark
     * @param memberType member_type
     * @return MemberSearchResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MemberSearchResult> list(String catalogId, Integer limit, String bookmark, String memberType) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getMembersV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bookmark", bookmark));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "member_type", memberType));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<MemberSearchResult> localVarReturnType = new ParameterizedTypeReference<MemberSearchResult>() {};
        return apiClient.invokeAPI(BASE_API,
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update members in a catalog
     *  Update a member of a catalog.
     * <p><b>200</b> - Updated
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param memberId Member GUID
     * @param memberRole Member updates
     * @return Member
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Member> updateRole(String catalogId, String memberId, MemberRole memberRole) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling updateMemberRoleV2");
        }
        // verify the required parameter 'memberId' is set
        if (memberId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'memberId' when calling updateMemberRoleV2");
        }
        // verify the required parameter 'memberRole' is set
        if (memberRole == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'memberRole' when calling updateMemberRoleV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("member_id", memberId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Member> localVarReturnType = new ParameterizedTypeReference<Member>() {};
        return apiClient.invokeAPI(BASE_API + "/{member_id}",
                HttpMethod.PATCH, pathParams, queryParams,
                memberRole, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
