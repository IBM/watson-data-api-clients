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

public class RulesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/rules";

    @Autowired
    public RulesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Creates a rule in the glossary.
     * This method is used to create a new rule.
     * <p><b>201</b> - The rule has been created successfully.
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>409</b> - UniqueConstraintViolation - rule with given name already
     * exists. <p><b>500</b> - Internal Server Error
     * @param newRuleEntity Rule to be created.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     artifact will be created in the published state by skipping the
     *     workflow.
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> create(NewRuleEntity newRuleEntity,
                                               String runAsTenant,
                                               Boolean skipWorkflowIfPossible) throws RestClientException {

        // verify the required parameter 'newRuleEntity' is set
        if (newRuleEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'newRuleEntity' when calling createRule");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip_workflow_if_possible", skipWorkflowIfPossible));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, newRuleEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create relationships for an artifact in the glossary.
     * If it is a published version, it creates a draft from the published version
     * and adds the relationship to the draft version. And, it returns the details
     * of the draft version. <p><b>201</b> - The relationship(s) have been created
     * successfully. <p><b>400</b> - Bad Request <p><b>401</b> - Unauthorized
     * <p><b>409</b> - UniqueConstraintViolation - This Relationships is already
     * exist <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact ID of the rule to fetch.
     * @param versionId The version ID of the rule to fetch.
     * @param ruleRelationshipsRequest Relationships to be created.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> createRelationships(String artifactId,
                                                            String versionId,
                                                            RuleRelationshipsRequest ruleRelationshipsRequest,
                                                            Boolean skipWorkflowIfPossible,
                                                            String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling createRuleRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling createRuleRelationships");
        }
        // verify the required parameter 'ruleRelationshipsRequest' is set
        if (ruleRelationshipsRequest == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'ruleRelationshipsRequest' when calling createRuleRelationships");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip_workflow_if_possible", skipWorkflowIfPossible));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/relationships",
                HttpMethod.POST, pathParams, queryParams, ruleRelationshipsRequest, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Deletes a draft or published version of an artifact.
     * If the artifact state is &lt;code&gt;DRAFT&lt;/code&gt;, then the draft
     * version is deleted.&lt;br/&gt;&lt;br/&gt; If the artifact state is
     * &lt;code&gt; PUBLISHED&lt;/code&gt;, a draft version with
     * &lt;code&gt;marked_for_deletion&lt;/code&gt; is created
     * .&lt;br/&gt;&lt;br/&gt; If the artifact state is &lt;code&gt;
     * PUBLISHED&lt;/code&gt; and workflow is skipped, then the published version
     * is deleted.&lt;br/&gt;&lt;br/&gt; Administrator role is required.
     * <p><b>200</b> - The artifact has been deleted successfully.
     * <p><b>201</b> - A draft version has been successfully created for deleting
     * the published artifact. <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>404</b> - Draft version for the given version ID does
     * not exist in the glossary. <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the rule to delete.
     * @param versionId The version id of the rule to delete.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be deleted by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return {@code Mono<Void>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String artifactId,
                             String versionId,
                             Boolean skipWorkflowIfPossible,
                             String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling deleteRule");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling deleteRule");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip_workflow_if_possible", skipWorkflowIfPossible));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Deletes a relationship of a rule artifact.
     * This method can be used for deleting a relationship of a rule artifact.
     * <p><b>200</b> - The relationship of the rule artifact was successfully
     * deleted. <p><b>400</b> - Bad Request <p><b>401</b> - Unauthorized
     * <p><b>404</b> - The relationship for the given GUID does not exist in the
     * glossary. <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact ID of the rule to fetch.
     * @param versionId The version ID of the rule to fetch.
     * @param relationshipId The guid of the relationship to delete.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be deleted by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> deleteRelationship(String artifactId,
                                                           String versionId,
                                                           String relationshipId,
                                                           Boolean skipWorkflowIfPossible,
                                                           String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling deleteRuleRelationship");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling deleteRuleRelationship");
        }
        // verify the required parameter 'relationshipId' is set
        if (relationshipId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'relationshipId' when calling deleteRuleRelationship");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("relationship_id", relationshipId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip_workflow_if_possible", skipWorkflowIfPossible));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/relationships/{relationship_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieves rule with given guid.
     * This method can be used for retrieving details of an PUBLISHED or DRAFT
     * rule. <p><b>200</b> - The rule has been retrieved successfully.
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - The rule with given {guid} does not exist in the glossary.
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact ID of the rule to fetch.
     * @param versionId The version ID of the rule to fetch.
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are &lt;code&gt;parent_category,
     *     categories, terms, rules, reference_data, policies, classifications,
     *     governs_assets, implemented_by, data_classes, all&lt;/code&gt;
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseRule
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseRule> get(String artifactId,
                                  String versionId,
                                  String includeRelationship,
                                  Boolean allParents,
                                  String limit,
                                  String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling getRuleByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling getRuleByVersionId");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_relationship", includeRelationship));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_parents", allParents));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ResponseRule> localVarReturnType = new ParameterizedTypeReference<ResponseRule>() {};
        return apiClient.invokeAPI(BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List the relationships of the given type for the specified rule.
     * If the result set is larger than the &lt;code&gt;limit&lt;/code&gt;
     * parameter, it returns the first &lt;code&gt;limit&lt;/code&gt; number of
     * associations. &lt;br/&gt;To retrieve the next set of relationships, call
     * the method again by using the URI in
     * &lt;code&gt;PaginatedTagsList.next&lt;/code&gt; returned by this
     * method.&lt;br/&gt;&lt;br/&gt;relationships of a child term, like
     * &lt;code&gt;SSN&lt;/code&gt;, includes the reof its parent terms, like
     * &lt;code&gt;Government Identities&lt;/code&gt;. <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact ID of the rule to fetch.
     * @param versionId The version ID of the rule to fetch.
     * @param type Comma separated list of relationship types. Allowed values of
     *     association types are &lt;code&gt;parent_category, categories, terms,
     *     rules, reference_data, policies, classifications, governs_assets,
     *     implemented_by, data_classes, all&lt;/code&gt;
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return Response
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, PaginatedAbstractRelationshipList>> listRelationships(String artifactId,
                                                                                  String versionId,
                                                                                  String type,
                                                                                  Boolean allParents,
                                                                                  Integer limit,
                                                                                  String offset) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling listRuleRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling listRuleRelationships");
        }
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'type' when calling listRuleRelationships");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_parents", allParents));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Map<String, PaginatedAbstractRelationshipList>> localVarReturnType = new ParameterizedTypeReference<Map<String, PaginatedAbstractRelationshipList>>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/relationships",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Updates rule with given id.
     * This method is used to update rule with given id.
     * <p><b>200</b> - The rule has been updated successfully.
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The rule with given {guid} does not exist in the glossary.
     * <p><b>409</b> - The rule was modified by another user.
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the rule to be updated.
     * @param versionId The version id of the rule to be updated.
     * @param updatableRuleEntity The rule to be updated.&lt;br&gt;Fields omitted
     *     will be unchanged, and fields set to null explicitly will be nulled
     *     out.&lt;br&gt;For multi-valued attributes &amp; relationships, the
     *     complete list will be replaced by the given list of
     *     values.&lt;br&gt;Additional
     *     Example:&lt;br&gt;&lt;pre&gt;{&amp;quot;description&amp;quot; :
     *     &amp;quot;description updated&amp;quot;}&lt;/pre&gt;
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseRule
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseRule> update(String artifactId,
                                     String versionId,
                                     UpdatableRuleEntity updatableRuleEntity,
                                     Boolean skipWorkflowIfPossible,
                                     String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling updateRuleByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling updateRuleByVersionId");
        }
        // verify the required parameter 'updatableRuleEntity' is set
        if (updatableRuleEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updatableRuleEntity' when calling updateRuleByVersionId");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip_workflow_if_possible", skipWorkflowIfPossible));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ResponseRule> localVarReturnType = new ParameterizedTypeReference<ResponseRule>() {};
        return apiClient.invokeAPI(BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.PATCH, pathParams, queryParams,
                updatableRuleEntity, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
