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
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

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
     * Add members to a catalog. A catalog member can be a user or an access
     * group.
     * @param catalogId catalog GUID
     * @param memberSet Members with roles
     * @return MemberSetPartialResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MemberSetPartialResult> add(@NonNull String catalogId,
                                            @NonNull MemberSet memberSet) throws RestClientException {

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
     * Delete a member from a catalog.
     * @param catalogId catalog GUID
     * @param memberId Member GUID
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String catalogId,
                             @NonNull String memberId) throws RestClientException {

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
     * Returns any memberships this user has on the catalog, including direct
     * membership and any access group memberships.
     * @param catalogId catalog GUID
     * @param memberId member ID
     * @return MemberSet
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MemberSet> get(@NonNull String catalogId,
                               @NonNull String memberId) throws RestClientException {

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
     * List all members of the catalog.
     * @param catalogId catalog GUID
     * @param limit limit
     * @param bookmark bookmark
     * @param memberType member_type
     * @return MemberSearchResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<MemberSearchResult> list(@NonNull String catalogId,
                                         Integer limit,
                                         String bookmark,
                                         String memberType) throws RestClientException {

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
     * Update a member of a catalog.
     * @param catalogId catalog GUID
     * @param memberId Member GUID
     * @param memberRole Member updates
     * @return Member
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Member> updateRole(@NonNull String catalogId,
                                   @NonNull String memberId,
                                   @NonNull MemberRole memberRole) throws RestClientException {

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
