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
     * Creates a policy in the glossary.
     * Creates a policy in the glossary.
     * <p><b>201</b> - The policy has been created successfully.
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>409</b> - UniqueConstraintViolation - policy with given name already
     * exists. <p><b>500</b> - Internal Server Error
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
    public Mono<GlossaryCreateResponse> create(NewPolicyEntity newPolicyEntity,
                                               Boolean skipWorkflowIfPossible,
                                               String runAsTenant) throws RestClientException {

        // verify the required parameter 'newPolicyEntity' is set
        if (newPolicyEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'newPolicyEntity' when calling createPolicy");
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
                BASE_API, HttpMethod.POST, pathParams, queryParams, newPolicyEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

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
     * Unauthorized <p><b>403</b> - Policy with sub-policies cannot be deleted.
     * Try again after re-parenting sub-policies. <p><b>404</b> - Policy with
     * given artifact and version ids does not exist in the glossary.
     * <p><b>500</b> - Internal Server Error
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
    public Mono<ResponsePolicy> delete(String artifactId,
                                       String versionId,
                                       Boolean skipWorkflowIfPossible,
                                       String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling deleteDraftByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling deleteDraftByVersionId");
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

        ParameterizedTypeReference<ResponsePolicy> localVarReturnType = new ParameterizedTypeReference<ResponsePolicy>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Deletes a relationship from a draft policy.
     * Deletes a relationship from a draft policy.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
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
    public Mono<GlossaryCreateResponse> deleteRelationship(String artifactId,
                                                           String versionId,
                                                           String relationshipId,
                                                           Boolean skipWorkflowIfPossible,
                                                           String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling deleteRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling deleteRelationships");
        }
        // verify the required parameter 'relationshipId' is set
        if (relationshipId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'relationshipId' when calling deleteRelationships");
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
     * Retrieves versions of a policy for the given artifact_id and status.
     * Retrieval of the versions of ACTIVE state is supported.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param guid Artifact ID or global ID of the artifact
     * @param status Filter by policy status
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are
     *     &lt;code&gt;parent_policy,sub_policies,parent_category,categories,terms,classifications,rules,data_protection_rules,all&lt;/code&gt;
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
    public Mono<PaginatedPolicyList> get(String guid,
                                         String status,
                                         String includeRelationship,
                                         String limit,
                                         String offset,
                                         String runAsTenant) throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling getPolicyByArtifactId");
        }
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
     * Retrieves versions of a policy for the given artifact_id and status.
     * Retrieval of the versions of ACTIVE state is supported.
     * <p><b>200</b> - The policy has been retrieved successfully.
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - The policy with given {guid} does not exist in the
     * glossary. <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact ID of the policy to fetch.
     * @param versionId The version ID of the policy to fetch.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are
     *     &lt;code&gt;parent_policy,sub_policies,parent_category,categories,terms,classifications,rules,data_protection_rules,all&lt;/code&gt;
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @return ResponsePolicy
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponsePolicy> getVersion(String artifactId,
                                           String versionId,
                                           String runAsTenant,
                                           String includeRelationship,
                                           String limit) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling getPolicyByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling getPolicyByVersionId");
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
     * If the result set is larger than the &lt;code&gt;limit&lt;/code&gt;
     * parameter, it returns the first &lt;code&gt;limit&lt;/code&gt; number of
     * associations. &lt;br/&gt;To retrieve the next set of associations, call the
     * method again by using the URI in
     * &lt;code&gt;PaginatedTagsList.next&lt;/code&gt; returned by this method.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The guid of the Policy
     * @param versionId The versionID of the Policy
     * @param type Comma separated list of relationship types. Allowed values of
     *     association types are
     *     &lt;code&gt;parent_policy,sub_policies,parent_category,categories,terms,classifications,rules,data_protection_rules,all&lt;/code&gt;
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return Map&lt;String,
     *     AbstractOffsetPaginatedListRelationshipAbstractRelationshipEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, PaginatedAbstractRelationshipList>> listRelationships(String artifactId,
                                                                                  String versionId,
                                                                                  String type,
                                                                                  Integer limit,
                                                                                  String offset)
            throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling listRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling listRelationships");
        }
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'type' when calling listRelationships");
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
     * Updates policy with given artifact id and version id. If the policy is in
     * published state then first creates a draft and applies the changes to the
     * newly created draft. Updates policy with given artifact id and version id.
     * If the policy is in published state then first creates a draft and applies
     * the changes to the newly created draft. <p><b>200</b> - The policy has been
     * updated successfully. <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden <p><b>404</b> - The policy with
     * given {guid} does not exist in the glossary. <p><b>409</b> - The policy was
     * modified by another user. <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the policy to be updated.
     * @param versionId The version id of the policy to be updated.
     * @param updatablePolicyEntity The policy to be updated.&lt;br&gt;Fields
     *     omitted will be unchanged, and fields set to null explicitly will be
     *     nulled out.&lt;br&gt;For multi-valued attributes &amp; relationships,
     *     the complete list will be replaced by the given list of
     *     values.&lt;br&gt;Additional
     *     Example:&lt;br&gt;&lt;pre&gt;{&amp;quot;description&amp;quot; :
     *     &amp;quot;description updated&amp;quot;}&lt;/pre&gt;
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponsePolicy
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponsePolicy> update(String artifactId,
                                       String versionId,
                                       UpdatablePolicyEntity updatablePolicyEntity,
                                       Boolean skipWorkflowIfPossible,
                                       String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling updatePolicyByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling updatePolicyByVersionId");
        }
        // verify the required parameter 'updatablePolicyEntity' is set
        if (updatablePolicyEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updatablePolicyEntity' when calling updatePolicyByVersionId");
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

        ParameterizedTypeReference<ResponsePolicy> localVarReturnType = new ParameterizedTypeReference<ResponsePolicy>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}", HttpMethod.PATCH,
                pathParams, queryParams, updatablePolicyEntity, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Updates DPR rule relationships of a published policy using its artifact id
     * and version id. Updates DPR rule relationships of a published policy using
     * its artifact id and version id. <p><b>200</b> - The policy has been updated
     * successfully. <p><b>400</b> - Bad Request <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The policy with given {guid} does not exist in the
     * glossary. <p><b>409</b> - The policy was modified by another user.
     * <p><b>500</b> - Internal Server Error
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
    public Mono<ResponsePolicy> updateDataProtectionRuleRelationships(String artifactId,
                                                                      String versionId,
                                                                      List<NewRelationship> newRelationship,
                                                                      String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling updatePolicyDprRuleRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling updatePolicyDprRuleRelationships");
        }
        // verify the required parameter 'newRelationship' is set
        if (newRelationship == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'newRelationship' when calling updatePolicyDprRuleRelationships");
        }
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
