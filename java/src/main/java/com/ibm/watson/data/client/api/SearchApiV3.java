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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.data.client.model.SearchResults;
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

public class SearchApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/search";

    @Autowired
    public SearchApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Execute a query and pass in a structured query conforming to the
     * Elasticsearch Domain Specific Language.
     *
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal error.  Try again later.
     * @param body A string representing a query.  The query must conform to
     *     Elasticsearch Domain Specific Language.
     * @return {@code Mono<SearchResults>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SearchResults> search(String body) throws RestClientException {

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling search");
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

        ParameterizedTypeReference<SearchResults> localVarReturnType = new ParameterizedTypeReference<SearchResults>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, body,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Execute a query based on the Lucene Syntax
     * Execute a query and pass in a selection of words to search for or pass in a
     * Lucene query.  Your Lucene query can be as simple or as sophisticated as
     * you like.  Beware, however.  If you plan on passing in a query directly
     * from user input, make sure to set the &#39;isSimple&#39; parameter to
     * &#39;true&#39; (the default is &#39;false&#39;). Otherwise, Global Search
     * will enforce a strict Lucene query syntax, and your query may return an
     * exception if the user input includes reserved Lucene tokens or symbols that
     * are used incorrectly.  When the &#39;isSimple&#39; parameter is set to
     * true, Global Search will use a modified Lucene syntax as
     * follows:&lt;br&gt;&lt;br&gt;&amp;nbsp;+ &#x3D; AND
     * operation&lt;br&gt;&amp;nbsp;| &#x3D; OR operation&lt;br&gt;&amp;nbsp;-
     * &#x3D; NOT &lt;br&gt;&amp;nbsp;\&quot; wraps a phrase&lt;br&gt;&amp;nbsp;*
     * is a wildcard (you can&#39;t use it at the beginning of a word but you can
     * use it alone to signify match all)&lt;br&gt;&amp;nbsp;( and ) evaluates
     * tokens inside brackets with higher precedence&lt;br&gt;&lt;br&gt;To use one
     * of these characters literally, escape it with a preceding backslash.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal error.  Try again later.
     * @param query The Search Query.  Add a list of words being sought or use a
     *     Lucene query. Your Lucene query can be as simple oras sophisticated as
     *     you like.
     * @param limit The maximum number of items to return
     * @param isSimple Use simple query string syntax
     * @return {@code Mono<SearchResults>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SearchResults> simpleSearch(String query, Integer limit, Boolean isSimple) throws RestClientException {

        // verify the required parameter 'query' is set
        if (query == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'query' when calling simpleSearch");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "query", query));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isSimple", isSimple));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<SearchResults> localVarReturnType = new ParameterizedTypeReference<SearchResults>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
