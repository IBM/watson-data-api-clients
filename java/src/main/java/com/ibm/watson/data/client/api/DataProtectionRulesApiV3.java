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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

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
     * create a rule
     * Creates a rule.  A rule has two key properties:  1)  a trigger defining
     * when the rule should be enforced, and  2)  an action describing what
     * operations to perform or outcome to enforce.    &lt;b&gt;Trigger&lt;/b&gt;
     * A trigger is a boolean expression represented using nested arrays.  The
     * following describes the syntax:             Expression:       [
     * -conditions- ]             Conditions:       -predicate- \&quot;NOT\&quot;,
     * -predicate-       -predicate-, \&quot;AND\&quot;|\&quot;OR\&quot;,
     * -conditions-       \&quot;NOT\&quot;, -predicate-,
     * \&quot;AND\&quot;|\&quot;OR\&quot;, -conditions-             Predicate: [
     * \&quot;$-term-\&quot;, \&quot;EXISTS\&quot; ]       [
     * \&quot;$-term-\&quot;,
     * \&quot;EQUALS\&quot;|\&quot;LESS_THAN\&quot;|\&quot;GREATER_THAN\&quot;|\&quot;CONTAINS\&quot;,
     * \&quot;#-literal-\&quot;|\&quot;$-term-\&quot; ]       -expression- where:
     * - -term- is a technical term defined in the term glossary.  - -literal- is
     * a literal.  For numerics a string representation of the number should be
     * specified.  For times, milliseconds are used (from Unix epoch).  For
     * boolean, #true and #false are used.  The definition of the operators in a
     * predicate:  - EXISTS -- means that the term has a value of some kind.   -
     * EQUALS -- evaluates to true if the left and right sides are equal.   -
     * LESS_THAN -- evaluates to true if the left is less in numeric value than
     * the right.  - GREATER_THAN -- evaluates to true if the left is greater in
     * numeric value than the right.  - CONTAINS -- is meant to test an array term
     * (such as Asset.Tags) with a single value.  It evaluates to true if the
     * value on the right side equals one of the values on the array on the left
     * side.   However it will also supports  a single value on the left, in which
     * case it behaves just like EQUALS -- regular expressions or wildcards are
     * not supported.   For all of the operators (except EXISTS), if the right
     * hand side evaluates to an array, each value of the array is compared to the
     * left side, according to the operator definition, and if any comparison is
     * true then the result of the evaluation is true.  Examples:
     * [[\&quot;$Asset.Type\&quot;, \&quot;EQUALS\&quot;, \&quot;#Project\&quot;]]
     * [\&quot;NOT\&quot;, [\&quot;$Asset.Tags\&quot;, \&quot;CONTAINS\&quot;,
     * \&quot;#sensitive\&quot;], \&quot;AND\&quot;, [\&quot;NOT\&quot;,
     * \&quot;$Asset.Tags\&quot;, \&quot;CONTAINS\&quot;,
     * \&quot;#confidential\&quot;]]       [[\&quot;$User.Name\&quot;,
     * \&quot;EQUALS\&quot;, \&quot;$Asset.Owner\&quot;]]
     * &lt;b&gt;Action&lt;/b&gt;   The action is an name with optional parameters
     * or subaction describing an operation to perform.  For simple actions like
     * Deny, only the action name will be provided.  For actions such as
     * Transform, a subaction with parameters describing the type of transform is
     * also provided.  The allowed actions depends on the governance type.
     * Examples:        {\&quot;name\&quot;: \&quot;Deny\&quot;}
     * {\&quot;name\&quot;: \&quot;Transform\&quot;, \&quot;subaction\&quot;:
     * {\&quot;name\&quot;: \&quot;anonymizeColumns\&quot;,
     * \&quot;parameters\&quot;: [{\&quot;name\&quot;: \&quot;column_name\&quot;,
     * \&quot;value\&quot;: \&quot;CCN\&quot;}]}}    The maximum length allowed
     * for &#39;name&#39; parameter is 80 characters, maximum length allowed for
     * &#39;description&#39; parameter: 1000 characters. Allowed characters for
     * the &#39;name&#39; parameter: letters from any language, numbers in any
     * script, space, dot, underscore, hyphen. Strings with characters other than
     * these are rejected (only for the name parameter). <p><b>200</b> -
     * successful operation <p><b>201</b> - Created <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param policyRuleRequest Rule json
     * @return PolicyRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleResponse> create(PolicyRuleEntity policyRuleRequest) throws RestClientException {

        // verify the required parameter 'policyRuleRequest' is set
        if (policyRuleRequest == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'policyRuleRequest' when calling createRule0");
        }
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
     * delete a rule
     * Deletes a rule.  A rule can only be deleted if it is not currently
     * associated with any policy (in any state). <p><b>204</b> - No Content (OK)
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param ruleId Rule ID
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String ruleId) throws RestClientException {

        // verify the required parameter 'ruleId' is set
        if (ruleId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'ruleId' when calling deleteRule0");
        }
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
     * export all rules
     * Export all defined rules as JSON.This includes all rules associated with
     * policies and rules not associated with any policy. <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param limit The maximum number of Rules to export. The default value is
     *     1000.
     * @param offset The index of the first matching Rule to include in the
     *     result. The default value is 0.
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
     * list all rules
     * Lists all defined rules.  This includes all rules associated with policies
     * and rules not associated with any policy.  When more than one filter
     * criteria is specified, the resulting collection satisfies all the criteria.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param name Specify name of the rule to search for or use filter of the
     *     form &#39;contains:xx&#39; to search for rules containing provided
     *     phrase as part of name or use filter of the form &#39;exact:xx&#39; to
     *     search for rules with exact name.
     * @param description Specify description of the rule to search for or use
     *     filter of the form &#39;contains:xx&#39; to search for rules containing
     *     provided phrase as part of description.
     * @param trigger If specified, only rules with a matching trigger expression
     *     will be returned.
     * @param action If specified, only rules with a matching action will be
     *     returned.
     * @param state If specified, only rules in the matching state will be
     *     returned.
     * @param governanceType If speficied, only rules with the matching governance
     *     type/types will be returned.
     * @param sort The order to sort the rules.  The following values are allowed:
     *     - name, -name -- ascending or descending order by the name -
     *     modified_date, -modified_date -- ascending or descending order by
     *     modified date
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
     * retrieve a rule
     * Retrieves detailed information on a rule given the rule&#39;s identifier.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param ruleId Rule ID
     * @return PolicyRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleResponse> get(String ruleId) throws RestClientException {

        // verify the required parameter 'ruleId' is set
        if (ruleId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'ruleId' when calling getRule0");
        }
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
     * retrieve terms used in a rule
     * Retrieves the names of all terms used in a rule.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param ruleId Rule ID
     * @return PolicyRuleTermListResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleTermListResponse> getTerms(String ruleId) throws RestClientException {

        // verify the required parameter 'ruleId' is set
        if (ruleId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'ruleId' when calling getRuleTerms0");
        }
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
     * import rules
     * Imports rules using content recieved as application/octet-stream media
     * type.  Assumes content to be in UTF-8 charset.  Expects \&quot;rules\&quot;
     * JSON array contained in a JSON objects. Ignores other fields.  Rule GUID is
     * prerserved.  Retruns JSON array containing GUIDs of newly imported rules.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>413</b> - Content cannot be more than 1MB
     * <p><b>500</b> - Internal Server Error
     * @param body The input file for reading imported rules
     * @return ImportRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ImportRuleResponse> load(DataProtectionRuleExportFile body) throws RestClientException {

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling importrules0");
        }
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
     * update a rule
     * Updates a rule.  Maximum length allowed for &#39;name&#39; parameter: 80
     * characters, maximum length allowed for &#39;description&#39; parameter:
     * 1000 characters. If the parameter &#39;name&#39; is modified, allowed
     * characters for the &#39;name&#39; parameter: letters from any language,
     * numbers in any script, space, dot, underscore, hyphen. Strings with
     * characters other than these are rejected (only for the name parameter). The
     * governance_type_id cannot be modified. <p><b>200</b> - OK <p><b>400</b> -
     * Bad Request <p><b>401</b> - Unauthorized <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param ruleId Rule ID
     * @param policyRuleRequest Rule json
     * @return PolicyRuleResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PolicyRuleResponse> update(String ruleId, PolicyRuleEntity policyRuleRequest) throws RestClientException {

        // verify the required parameter 'ruleId' is set
        if (ruleId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'ruleId' when calling ruleUpdate0");
        }
        // verify the required parameter 'policyRuleRequest' is set
        if (policyRuleRequest == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'policyRuleRequest' when calling ruleUpdate0");
        }
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
