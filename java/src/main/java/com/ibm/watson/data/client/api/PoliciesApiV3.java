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
 * API endpoints dealing with Policies.
 */
public class PoliciesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/policies";

    @Autowired
    public PoliciesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create a policy in the glossary.
     * @param newPolicyEntity Policy to be created.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     artifact will be created in the published state by skipping the
     *     workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> create(@NonNull NewPolicyEntity newPolicyEntity,
                                               Boolean skipWorkflowIfPossible,
                                               String runAsTenant) throws RestClientException {

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
                BASE_API, HttpMethod.POST, pathParams, queryParams, newPolicyEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Delete a draft or published version of an artifact.
     * <ul>
     *     <li>If the artifact state is <code>DRAFT</code>, then the draft version is deleted.</li>
     *     <li>If the artifact state is <code>PUBLISHED</code>, a draft version with <code>marked_for_deletion</code> is created.</li>
     *     <li>If the artifact state is <code>PUBLISHED</code> and workflow is skipped, then the published version is deleted.</li>
     * </ul>
     * Administrator role is required.
     * @param artifactId The artifact ID of the policy.
     * @param versionId The version id of the policy to delete or to create
     *     mark-for-delete draft copy.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be deleted by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponsePolicy> delete(@NonNull String artifactId,
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

        ParameterizedTypeReference<ResponsePolicy> localVarReturnType = new ParameterizedTypeReference<ResponsePolicy>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Delete a relationship from a draft policy.
     * @param artifactId The artifact ID of the policy to fetch.
     * @param versionId The version ID of the policy to fetch.
     * @param relationshipId The artifact ID of the relationships to delete.
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
     * Retrieve versions of a policy for the given artifact_id and status.
     * Retrieval of the versions of ACTIVE state is supported.
     * @param guid Artifact ID or global ID of the artifact
     * @param status Filter by policy status
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are
     *     <code>parent_policy,sub_policies,parent_category,categories,terms,classifications,rules,data_protection_rules,all</code>
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return PaginatedArtifactList
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedPolicyList> get(@NonNull String guid,
                                         String status,
                                         String includeRelationship,
                                         String limit,
                                         String offset,
                                         String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_relationship", includeRelationship));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedPolicyList> localVarReturnType = new ParameterizedTypeReference<PaginatedPolicyList>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}/versions", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the specified version of a policy.
     * @param artifactId The artifact ID of the policy to fetch.
     * @param versionId The version ID of the policy to fetch.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are
     *     <code>parent_policy,sub_policies,parent_category,categories,terms,classifications,rules,data_protection_rules,all</code>
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @return ResponsePolicy
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponsePolicy> getVersion(@NonNull String artifactId,
                                           @NonNull String versionId,
                                           String runAsTenant,
                                           String includeRelationship,
                                           String limit) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_relationship", includeRelationship));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ResponsePolicy> localVarReturnType = new ParameterizedTypeReference<ResponsePolicy>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * List the relationships for the specified policy.
     * If the result set is larger than the <code>limit</code>
     * parameter, it returns the first <code>limit</code> number of
     * associations. To retrieve the next set of associations, call the
     * method again by using the URI in
     * <code>PaginatedTagsList.next</code> returned by this method.
     * @param artifactId The guid of the Policy
     * @param versionId The versionID of the Policy
     * @param type Comma separated list of relationship types. Allowed values of
     *     association types are
     *     <code>parent_policy,sub_policies,parent_category,categories,terms,classifications,rules,data_protection_rules,all</code>
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return {@code Map<String, PaginatedAbstractRelationshipList>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, PaginatedAbstractRelationshipList>> listRelationships(@NonNull String artifactId,
                                                                                  @NonNull String versionId,
                                                                                  @NonNull String type,
                                                                                  Integer limit,
                                                                                  String offset)
            throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
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
     * Update policy with given artifact id and version id.
     * If the policy is in published state then first creates a draft and applies
     * the changes to the newly created draft.
     * @param artifactId The artifact id of the policy to be updated.
     * @param versionId The version id of the policy to be updated.
     * @param updatablePolicyEntity The policy to be updated. Fields
     *     omitted will be unchanged, and fields set to null explicitly will be
     *     nulled out. For multi-valued attributes and relationships,
     *     the complete list will be replaced by the given list of
     *     values.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponsePolicy
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponsePolicy> update(@NonNull String artifactId,
                                       @NonNull String versionId,
                                       @NonNull UpdatablePolicyEntity updatablePolicyEntity,
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

        ParameterizedTypeReference<ResponsePolicy> localVarReturnType = new ParameterizedTypeReference<ResponsePolicy>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}", HttpMethod.PATCH,
                pathParams, queryParams, updatablePolicyEntity, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Updates Data Protection Rule (DPR) relationships of a published policy using its artifact id
     * and version id.
     * @param artifactId The artifact id of the policy to be updated.
     * @param versionId The version id of the policy to be updated.
     * @param newRelationship Adds new DPR rule relationships and deletes any
     *     pre-existing but omitted ones.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponsePolicy
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponsePolicy> updateDataProtectionRuleRelationships(@NonNull String artifactId,
                                                                      @NonNull String versionId,
                                                                      @NonNull List<NewRelationship> newRelationship,
                                                                      String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ResponsePolicy> localVarReturnType = new ParameterizedTypeReference<ResponsePolicy>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/data_protection_rules",
                HttpMethod.PATCH, pathParams, queryParams, newRelationship, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
