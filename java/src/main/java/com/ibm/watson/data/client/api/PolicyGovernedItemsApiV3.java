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

import com.ibm.watson.data.client.model.PolicyEnforcementContext;
import com.ibm.watson.data.client.model.PolicyEvaluation;
import com.ibm.watson.data.client.model.V3DiscreteRulesResponse;
import com.ibm.watson.data.client.model.V3ItemRulesEvaluationRequest;
import com.ibm.watson.data.client.model.V3ItemsEvaluationRequest;
import com.ibm.watson.data.client.model.V3PolicyItemListResponse;
import com.ibm.watson.data.client.model.V3PolicyItemRequest;
import com.ibm.watson.data.client.model.V3PolicyItemResponse;
import com.ibm.watson.data.client.model.V3PolicyTermValueListResponse;

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
 * API for managing policy-governed items.
 */
public class PolicyGovernedItemsApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/enforcement/governed_items";

    @Autowired
    public PolicyGovernedItemsApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create or update an item.
     * An item is associated with each asset being governed.  This API updates governance information for an item given the item's identifier.
     * @param itemId identifier of the item.  For asset this is the asset's GUID
     * @param body item json
     * @return V3PolicyItemResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3PolicyItemResponse> createOrUpdateItem(@NonNull String itemId,
                                                         @NonNull V3PolicyItemRequest body) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("itemId", itemId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3PolicyItemResponse> localVarReturnType = new ParameterizedTypeReference<V3PolicyItemResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{itemId}",
                HttpMethod.PUT, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete an item.
     * An item is associated with each asset being governed.   This API deletes governance information about the item given the item's identifier.  Note that the item may be added again automatically when its associate asset is modified.
     * @param itemId identifier of the item.  For asset this is the asset's GUID
     * @return Void
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteItem(@NonNull String itemId) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("itemId", itemId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{itemId}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List recently added items.
     * An item is associated with each asset being governed.  This API returns governance information about the ten most recently created items.
     * @param resourcePrefix Common resource prefix.  If specified, only return items with this resource path prefix.
     * @param since Timestamp.  If specified return only items changed since this time.
     * @return V3PolicyItemListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3PolicyItemListResponse> listItems(String resourcePrefix,
                                                    Long since) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "resourcePrefix", resourcePrefix));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "since", since));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3PolicyItemListResponse> localVarReturnType = new ParameterizedTypeReference<V3PolicyItemListResponse>() {};
        return apiClient.invokeAPI(BASE_API,
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Return discrete rules by providing a container id and an item id
     * Returns an array of discrete rules for a given item in a container created from all abstract rules from that item.  A discrete rule is one that specifies a singular asset (or column) rather than firing for multiple items (or columns).  If an abstract rule targets more than one column, a new discrete rule will be made for each column that is targeted.  The trigger of each discrete rule will start with the predicate $Asset.CatalogId &#x3D; CATALOG_ID AND $Asset.Id &#x3D; ASSET_ID.  If the action of a discrete rule is Transform, column_name will be non-null, there will be another predicate stating $Asset.ColumnName &#x3D; COLUMN_NAME, and the subaction parameter will always be column_names &#x3D; COLUMN_NAME.  Metadata is only included if WITH_METADATA is specified in the options. It contains information about the item and the columns.
     * @param governanceTypeName the name of the governance type
     * @param itemId item ID
     * @param containerId container ID
     * @param withoutDiscretePredicates whether to include non-contextual predicates (false) or exclude them (true)
     * @param withMetadata whether to include metadata about the rule (true) or not (false)
     * @return V3DiscreteRulesResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3DiscreteRulesResponse> getDiscreteRules(@NonNull String governanceTypeName,
                                                          @NonNull String itemId,
                                                          @NonNull String containerId,
                                                          @NonNull boolean withoutDiscretePredicates,
                                                          @NonNull boolean withMetadata) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("governanceTypeName", governanceTypeName);
        pathParams.put("itemId", itemId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "containerId", containerId));
        if (withoutDiscretePredicates)
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "without_discrete_predicates", "true"));
        if (withMetadata)
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "with_metadata", "true"));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3DiscreteRulesResponse> localVarReturnType = new ParameterizedTypeReference<V3DiscreteRulesResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/discrete/{governanceTypeName}/{itemId}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Return discrete rules by providing a resource key.
     * Returns an array of discrete rules for a given resource created from all abstract rules from that resource.  A discrete rule is one that specifies a singular asset (or column) rather than firing for multiple items (or columns).  If an abstract rule targets more than one column, a new discrete rule will be made for each column that is targeted.  The trigger of each discrete rule will start with the predicate $Asset.CatalogId &#x3D; CATALOG_ID AND $Asset.Id &#x3D; ASSET_ID.  If the action of a discrete rule is Transform, column_name will be non-null, there will be another predicate stating $Asset.ColumnName &#x3D; COLUMN_NAME, and the subaction parameter will always be column_names &#x3D; COLUMN_NAME.  Metadata is only included if WITH_METADATA is specified in the options. It contains information about the item and the columns.
     * @param governanceTypeName the name of the governance type
     * @param resourceKey resource key
     * @param options options
     * @return V3DiscreteRulesResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3DiscreteRulesResponse> getDiscreteRulesResource(@NonNull String governanceTypeName,
                                                                  @NonNull String resourceKey,
                                                                  @NonNull String options) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("governanceTypeName", governanceTypeName);
        pathParams.put("resource_key", resourceKey);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "options", options));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3DiscreteRulesResponse> localVarReturnType = new ParameterizedTypeReference<V3DiscreteRulesResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/discrete/{governanceTypeName}/resource/{resource_key}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve an item.
     * An item is associated with each asset being governed.   This API returns governance information for an item given the item's identifier.
     * @param itemId identifier of the item.  For asset this is the asset's GUID
     * @param fields Desired fields
     * @return V3PolicyItemResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3PolicyItemResponse> getItem(@NonNull String itemId,
                                              String fields) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("itemId", itemId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fields", fields));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3PolicyItemResponse> localVarReturnType = new ParameterizedTypeReference<V3PolicyItemResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{itemId}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Evaluate a term for a given item and context.
     * An item is associated with each asset being governed.  This API will determine a term's value for a given item and context information.
     * @param itemId item ID
     * @param termName term name
     * @param body context
     * @return V3PolicyTermValueListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V3PolicyTermValueListResponse> getItemTermValue(@NonNull String itemId,
                                                                @NonNull String termName,
                                                                @NonNull PolicyEnforcementContext body) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("itemId", itemId);
        pathParams.put("termName", termName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<V3PolicyTermValueListResponse> localVarReturnType = new ParameterizedTypeReference<V3PolicyTermValueListResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{itemId}/terms/{termName}",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Evaluate policies of a particular governance type on an item and context.
     * An item is associated with each asset being governed.  This API will determine the proper action to take for a particular item, given the item's identifier, the governance type and context information.
     * @param itemId identifier of the item.  For asset this is the asset's GUID
     * @param governanceTypeName the name of the governance type
     * @param body context
     * @param launchTransform (true/value) value indicates whether DPS will trigger transformation action.  true  - DPS will trigger transformation action.  false (default) - Caller needs to enforce the transform action by calling transformion service based on the returned transform_spec.  
     * @return PolicyEvaluation
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PolicyEvaluation> itemEvaluate(@NonNull String itemId,
                                               @NonNull String governanceTypeName,
                                               @NonNull PolicyEnforcementContext body,
                                               Boolean launchTransform) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("itemId", itemId);
        pathParams.put("governanceTypeName", governanceTypeName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "launch_transform", launchTransform));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyEvaluation> localVarReturnType = new ParameterizedTypeReference<PolicyEvaluation>() {};
        return apiClient.invokeAPI(BASE_API + "/{itemId}/evaluate/{governanceTypeName}",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Evaluate an operation for a given item and context.
     * An item is associated with each asset being governed.  This API will determine the proper action to take for a particular operation on an item, given the item's identifier and context information.
     * @param itemId identifier of the item.  For asset this is the asset's GUID
     * @param operationName the name of the operation in the form {governance_type_name}.{operation_name}.  For example, Access.read
     * @param body context
     * @return PolicyEvaluation
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PolicyEvaluation> itemEvaluateOperation(@NonNull String itemId,
                                                        @NonNull String operationName,
                                                        @NonNull PolicyEnforcementContext body) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("itemId", itemId);
        pathParams.put("operationName", operationName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyEvaluation> localVarReturnType = new ParameterizedTypeReference<PolicyEvaluation>() {};
        return apiClient.invokeAPI(BASE_API + "/{itemId}/operations/{operationName}",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Evaluate add rules request of a particular governance type on a list of items and context.
     * An item is associated with each asset being governed.  This API will determine the proper action to take for a particular operation on an item, given the item's identifier and context information.
     * @param governanceTypeName the name of the governance type
     * @param body the add rules evaluation items request object
     * @return PolicyEvaluation
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PolicyEvaluation> itemsAddRulesEvaluate(@NonNull String governanceTypeName,
                                                        @NonNull V3ItemRulesEvaluationRequest body) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("governanceTypeName", governanceTypeName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyEvaluation> localVarReturnType = new ParameterizedTypeReference<PolicyEvaluation>() {};
        return apiClient.invokeAPI(BASE_API + "/evaluate/rules/add/{governanceTypeName}",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Evaluate an operation for a list of items and a single context.
     * An item is associated with each asset being governed.  This API will determine the proper action to take for a particular operation on an item, given the item's identifier and context information.
     * @param governanceTypeName the name of the governance type
     * @param body the items evaluation request object
     * @param launchTransform (true/value) value indicates whether DPS will trigger transformation action.  true  - DPS will trigger transformation action.  false (default) - Caller needs to enforce the transform action by calling transformion service based on the returned transform_spec.  
     * @return PolicyEvaluation
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PolicyEvaluation> itemsEvaluate(@NonNull String governanceTypeName,
                                                @NonNull V3ItemsEvaluationRequest body,
                                                Boolean launchTransform) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("governanceTypeName", governanceTypeName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "launch_transform", launchTransform));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyEvaluation> localVarReturnType = new ParameterizedTypeReference<PolicyEvaluation>() {};
        return apiClient.invokeAPI(BASE_API + "/evaluate/{governanceTypeName}",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Evaluate and return items determining whether context user has access to.
     * An item is associated with each category being governed.  This API will determine list of item for a particular governance type, given context information.
     * @param governanceTypeName the name of the governance type
     * @param body context
     * @param limit The maximum number of evaluate items to return - must be at least 1 and cannot exceed 500. The default value is 200.
     * @param offset Depreciated and Replaced by start param. The page index of the first evaluate item to include in the result. The offset value can be 0 (zero) or a multiple of limit value.
     * @param start The index of the first evaluate item to include in the result. The value can be start from 0 (zero)
     * @param operation The index of the first operation will be used for evaluation if requesting multiple operation for evaluation
     * @return PolicyEvaluation
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PolicyEvaluation> userItemsEvaluate(@NonNull String governanceTypeName,
                                                    @NonNull PolicyEnforcementContext body,
                                                    Integer limit,
                                                    Integer offset,
                                                    Integer start,
                                                    String operation) throws WebClientResponseException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("governanceTypeName", governanceTypeName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "operation", operation));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyEvaluation> localVarReturnType = new ParameterizedTypeReference<PolicyEvaluation>() {};
        return apiClient.invokeAPI(BASE_API + "/evaluate/user/{governanceTypeName}",
                HttpMethod.POST, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
