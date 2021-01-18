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
 * API endpoints dealing with Rules.
 */
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
    public Mono<GlossaryCreateResponse> create(@NonNull NewRuleEntity newRuleEntity,
                                               String runAsTenant,
                                               Boolean skipWorkflowIfPossible) throws RestClientException {

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
     * Create relationships for a rule in the glossary.
     * If it is a published version, it creates a draft from the published version
     * and adds the relationship to the draft version. And, it returns the details
     * of the draft version.
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
    public Mono<GlossaryCreateResponse> createRelationships(@NonNull String artifactId,
                                                            @NonNull String versionId,
                                                            @NonNull RuleRelationshipsRequest ruleRelationshipsRequest,
                                                            Boolean skipWorkflowIfPossible,
                                                            String runAsTenant) throws RestClientException {

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
     * Delete a draft or published version of an artifact.
     * <ul>
     *     <li>If the artifact state is <code>DRAFT</code>, then the draft version is deleted.</li>
     *     <li>If the artifact state is <code>PUBLISHED</code>, a draft version with <code>marked_for_deletion</code> is created.</li>
     *     <li>If the artifact state is <code>PUBLISHED</code> and workflow is skipped, then the published version is deleted.</li>
     * </ul>
     * Administrator role is required.
     * @param artifactId The artifact id of the rule to delete.
     * @param versionId The version id of the rule to delete.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be deleted by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String artifactId,
                             @NonNull String versionId,
                             Boolean skipWorkflowIfPossible,
                             String runAsTenant) throws RestClientException {

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
     * Delete a relationship to a rule artifact.
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
    public Mono<GlossaryCreateResponse> deleteRelationship(@NonNull String artifactId,
                                                           @NonNull String versionId,
                                                           @NonNull String relationshipId,
                                                           Boolean skipWorkflowIfPossible,
                                                           String runAsTenant) throws RestClientException {

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
     * Retrieve a rule with given guid.
     * This method can be used for retrieving details of an PUBLISHED or DRAFT
     * rule.
     * @param artifactId The artifact ID of the rule to fetch.
     * @param versionId The version ID of the rule to fetch.
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are <code>parent_category,
     *     categories, terms, rules, reference_data, policies, classifications,
     *     governs_assets, implemented_by, data_classes, all</code>
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
    public Mono<ResponseRule> get(@NonNull String artifactId,
                                  @NonNull String versionId,
                                  String includeRelationship,
                                  Boolean allParents,
                                  String limit,
                                  String runAsTenant) throws RestClientException {

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
     * If the result set is larger than the <code>limit</code>
     * parameter, it returns the first <code>limit</code> number of
     * associations. To retrieve the next set of relationships, call
     * the method again by using the URI in
     * <code>PaginatedTagsList.next</code> returned by this
     * method. Relationships of a child term, like
     * <code>SSN</code>, includes the rest of its parent terms, like
     * <code>Government Identities</code>.
     * @param artifactId The artifact ID of the rule to fetch.
     * @param versionId The version ID of the rule to fetch.
     * @param type Comma separated list of relationship types. Allowed values of
     *     association types are <code>parent_category, categories, terms,
     *     rules, reference_data, policies, classifications, governs_assets,
     *     implemented_by, data_classes, all</code>
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
    public Mono<Map<String, PaginatedAbstractRelationshipList>> listRelationships(@NonNull String artifactId,
                                                                                  @NonNull String versionId,
                                                                                  @NonNull String type,
                                                                                  Boolean allParents,
                                                                                  Integer limit,
                                                                                  String offset) throws RestClientException {

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
     * Update rule with given id.
     * @param artifactId The artifact id of the rule to be updated.
     * @param versionId The version id of the rule to be updated.
     * @param updatableRuleEntity The rule to be updated. Fields omitted
     *     will be unchanged, and fields set to null explicitly will be nulled
     *     out. For multi-valued attributes and relationships, the
     *     complete list will be replaced by the given list of
     *     values.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseRule
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseRule> update(@NonNull String artifactId,
                                     @NonNull String versionId,
                                     @NonNull UpdatableRuleEntity updatableRuleEntity,
                                     Boolean skipWorkflowIfPossible,
                                     String runAsTenant) throws RestClientException {

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
