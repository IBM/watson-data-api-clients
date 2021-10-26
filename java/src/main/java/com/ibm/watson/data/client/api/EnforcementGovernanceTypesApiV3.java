/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.data.client.model.V3PolicyGovernanceTypeListResponse;
import com.ibm.watson.data.client.model.V3PolicyGovernanceTypeResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * API for managing governance types against which enforcement is applied.
 */
public class EnforcementGovernanceTypesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/enforcement/governance_types";

    @Autowired
    public EnforcementGovernanceTypesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List all governance types.
     * Lists all governance types.  A governance type groups like operations together.  For example, the Access governance type groups operations related to access of assets.
     * @return V3PolicyGovernanceTypeListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3PolicyGovernanceTypeListResponse> list() throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3PolicyGovernanceTypeListResponse> localVarReturnType = new ParameterizedTypeReference<V3PolicyGovernanceTypeListResponse>() {};
        return apiClient.invokeAPI(BASE_API,
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve a governanceType
     * Retrieves detailed information on a governance type.  This includes all of the operations defined for the governance type and the allowed and default outcomes of each operation.
     * @param governanceTypeName the name of the governance type
     * @return V3PolicyGovernanceTypeResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3PolicyGovernanceTypeResponse> get(@NonNull String governanceTypeName) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("governance_type_name", governanceTypeName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3PolicyGovernanceTypeResponse> localVarReturnType = new ParameterizedTypeReference<V3PolicyGovernanceTypeResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{governance_type_name}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
