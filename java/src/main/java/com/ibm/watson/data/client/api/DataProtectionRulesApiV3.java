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
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * API endpoints for dealing with Data Protection Rules.
 * <br><br>
 * A rule has two key properties:
 * <ul>
 *     <li>a trigger defining when the rule should be enforced</li>
 *     <li>an action describing what operations to perform or outcome to enforce</li>
 * </ul>
 * <em>Trigger</em><br>
 * A trigger is a boolean expression represented using nested arrays. The
 * following describes the syntax:
 * <code>
 * Expression: [ -conditions- ]
 * 
 * Conditions:
 * -predicate-
 * "NOT", -predicate-
 * -predicate-, "AND"|"OR", -conditions-
 * "NOT", -predicate-, "AND"|"OR", -conditions-
 *
 * Predicate:
 * [ "$-term-", "EXISTS" ]
 * [ "$-term-", "EQUALS"|"LESS_THAN"|"GREATER_THAN"|"CONTAINS", "#-literal-"|"$-term-" ]
 * -expression-
 * </code>
 * where:
 * <ul>
 *     <li><code>-term-</code>is a technical term defined in the term glossary.</li>
 *     <li><code>-literal-</code>is a literal. For numerics a string representation of the number should be specified. For times, milliseconds are used (from Unix epoch). For boolean, <code>#true</code> and <code>#false</code> are used.</li>
 * </ul>
 * The definition of the operators in a predicate:
 * <ul>
 *     <li>EXISTS -- means that the term has a value of some kind.</li>
 *     <li>EQUALS -- evaluates to true if the left and right sides are equal.</li>
 *     <li>LESS_THAN -- evaluates to true if the left is less in numeric value than the right.</li>
 *     <li>GREATER_THAN -- evaluates to true if the left is greater in numeric value than the right.</li>
 *     <li>CONTAINS -- is meant to test an array term (such as Asset.Tags) with a single value. It evaluates to true if the value on the right side equals one of the values on the array on the left side. However it will also supports  a single value on the left, in which case it behaves just like EQUALS -- regular expressions or wildcards are not supported.</li>
 * </ul>
 * For all of the operators (except EXISTS), if the right hand side evaluates to an array,
 * each value of the array is compared to the left side, according to the operator definition,
 * and if any comparison is true then the result of the evaluation is true.  Examples:
 * <code>
 * [["$Asset.Type", "EQUALS", "#Project"]]
 * ["NOT", ["$Asset.Tags", "CONTAINS", "#sensitive"], "AND", ["NOT", "$Asset.Tags", "CONTAINS", "#confidential"]]
 * [["$User.Name", "EQUALS", "$Asset.Owner"]]
 * </code>
 * <em>Action</em>
 * The action is a name with optional parameters or sub-action describing an operation to perform.
 * For simple actions like Deny, only the action name will be provided.  For actions such as
 * Transform, a sub-action with parameters describing the type of transform is
 * also provided. The allowed actions depends on the governance type.
 * Examples:
 * <code>
 * {"name": "Deny"}
 * {"name": "Transform", "subaction": {"name": "anonymizeColumns", "parameters": [{"name": "column_name", "value": "CCN"}]}}
 * </code>
 * The maximum length allowed
 * for "name" parameter is 80 characters, maximum length allowed for
 * "description" parameter: 1000 characters. Allowed characters for
 * the "name" parameter: letters from any language, numbers in any
 * script, space, dot, underscore, hyphen. Strings with characters other than
 * these are rejected (only for the name parameter).
 */
public class DataProtectionRulesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/enforcement/rules";

    @Autowired
    public DataProtectionRulesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create a rule.
     * @param policyRuleRequest Rule json
     * @return PolicyRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleResponse> create(@NonNull PolicyRuleEntity policyRuleRequest) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyRuleResponse> localVarReturnType = new ParameterizedTypeReference<PolicyRuleResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                policyRuleRequest, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete a rule.  A rule can only be deleted if it is not currently
     * associated with any policy (in any state).
     * @param ruleId Rule ID
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String ruleId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("rule_id", ruleId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{rule_id}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Export all defined rules as JSON. This includes all rules associated with
     * policies and rules not associated with any policy.
     * @param limit The maximum number of Rules to export. The default value is
     *     1000.
     * @param offset The index of the first matching Rule to include in the
     *     result. The default value is 0.
     * @return DataProtectionRuleExportFile
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<DataProtectionRuleExportFile> export(Integer limit, Integer offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DataProtectionRuleExportFile> localVarReturnType = new ParameterizedTypeReference<DataProtectionRuleExportFile>() {};
        return apiClient.invokeAPI(
                BASE_API + "/export", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * List all defined rules.  This includes all rules associated with policies
     * and rules not associated with any policy.  When more than one filter
     * criteria is specified, the resulting collection satisfies all the criteria.
     * @param name Specify name of the rule to search for, or use filter of the
     *     form "contains:xx" to search for rules containing provided
     *     phrase as part of name, or use filter of the form "exact:xx" to
     *     search for rules with exact name.
     * @param description Specify description of the rule to search for, or use
     *     filter of the form "contains:xx" to search for rules containing
     *     provided phrase as part of description.
     * @param trigger If specified, only rules with a matching trigger expression
     *     will be returned.
     * @param action If specified, only rules with a matching action will be
     *     returned.
     * @param state If specified, only rules in the matching state will be
     *     returned.
     * @param governanceType If specified, only rules with the matching governance
     *     type/types will be returned.
     * @param sort The order to sort the rules.  The following values are allowed:
     *     <code>name</code>, <code>modified_date</code>. Prefix the value with a
     *     hyphen (-) to sort the results in descending order.
     * @param limit The maximum number of Rules to return. The default value
     *     is 50.
     * @param offset The index of the first matching Rule to include in the
     *     result. The default value is 0.
     * @return PolicyRuleListResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleListResponse> list(String name,
                                             String description,
                                             String trigger,
                                             String action,
                                             String state,
                                             String governanceType,
                                             String sort,
                                             Integer limit,
                                             Integer offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "description", description));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "trigger", trigger));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "action", action));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "governance_type", governanceType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyRuleListResponse> localVarReturnType = new ParameterizedTypeReference<PolicyRuleListResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve detailed information on a rule given the rule's identifier.
     * @param ruleId Rule ID
     * @return PolicyRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleResponse> get(@NonNull String ruleId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("rule_id", ruleId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyRuleResponse> localVarReturnType = new ParameterizedTypeReference<PolicyRuleResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{rule_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve the names of all terms used in a rule.
     * @param ruleId Rule ID
     * @return PolicyRuleTermListResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleTermListResponse> getTerms(@NonNull String ruleId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("rule_id", ruleId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyRuleTermListResponse> localVarReturnType = new ParameterizedTypeReference<PolicyRuleTermListResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{rule_id}/terms",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Import rules using specified content. Assumes content to be in UTF-8 charset.
     * Expects "rules" JSON array contained in a JSON object. Ignores other fields. Rule GUID is
     * preserved. Returns JSON array containing GUIDs of newly imported rules.
     * @param body The input file for reading imported rules
     * @return ImportRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ImportRuleResponse> load(@NonNull DataProtectionRuleExportFile body) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/octet-stream", "application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ImportRuleResponse> localVarReturnType = new ParameterizedTypeReference<ImportRuleResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/import", HttpMethod.POST,
                pathParams, queryParams, body, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Update a rule.  Maximum length allowed for "name" parameter: 80
     * characters, maximum length allowed for "description" parameter:
     * 1000 characters. If the parameter "name" is modified, allowed
     * characters for the "name" parameter: letters from any language,
     * numbers in any script, space, dot, underscore, hyphen. Strings with
     * characters other than these are rejected (only for the name parameter). The
     * governance_type_id cannot be modified.
     * @param ruleId Rule ID
     * @param policyRuleRequest Rule json
     * @return PolicyRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleResponse> update(@NonNull String ruleId,
                                           @NonNull PolicyRuleEntity policyRuleRequest) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("rule_id", ruleId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PolicyRuleResponse> localVarReturnType = new ParameterizedTypeReference<PolicyRuleResponse>() {};
        return apiClient.invokeAPI(BASE_API + "/{rule_id}",
                HttpMethod.PUT, pathParams, queryParams,
                policyRuleRequest, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
