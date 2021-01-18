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
import com.ibm.watson.data.client.model.CommentByUser;
import com.ibm.watson.data.client.model.CustomAttributeDefinition;
import com.ibm.watson.data.client.model.GlossaryArchiveResponse;
import com.ibm.watson.data.client.model.GlossaryCreateResponse;
import com.ibm.watson.data.client.model.GlossaryImportResult;
import com.ibm.watson.data.client.model.GlossaryResourceList;
import com.ibm.watson.data.client.model.GovernancePermission;
import com.ibm.watson.data.client.model.NewCustomAttributeDefinitionEntity;
import com.ibm.watson.data.client.model.PaginatedAssetAggregatedCommentsList;
import com.ibm.watson.data.client.model.PaginatedAssetCommentList;
import com.ibm.watson.data.client.model.PaginatedAssetCommentsModificationDetails;
import com.ibm.watson.data.client.model.PaginatedDraftArtifactsList;
import com.ibm.watson.data.client.model.Response;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * API endpoints dealing with Governance Artifact Types.
 */
public class GovernanceArtifactTypesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/governance_artifact_types/{artifact_type}";

    @Autowired
    public GovernanceArtifactTypesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create custom attribute definition in the glossary.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param newCustomAttributeDefinitionEntity Custom attribute definition to be
     *     created.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> createCustomAttributeDefinition(@NonNull String artifactType,
                                                                        @NonNull NewCustomAttributeDefinitionEntity newCustomAttributeDefinitionEntity,
                                                                        String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

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

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/custom_attribute_definitions",
                HttpMethod.POST, pathParams, queryParams, newCustomAttributeDefinitionEntity,
                headerParams, cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete a comment on a draft artifact version.
     * @param artifactType The artifact type. Allowed values are glossary_term,
     *     classification, data_class, reference_data, policy, rule
     * @param artifactId The artifact id.
     * @param versionId The version id.
     * @param commentId The comment id.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deleteComment(@NonNull String artifactType,
                                    @NonNull String artifactId,
                                    @NonNull String versionId,
                                    @NonNull String commentId,
                                    String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("comment_id", commentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/comments/{comment_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete a list of draft or published versions of given artifact_type.
     * <ul>
     *     <li>If the artifact state is <code>DRAFT</code>, then the draft version is deleted.</li>
     *     <li>If the artifact state is <code>PUBLISHED</code>, a draft version with <code>marked_for_deletion</code> is created.</li>
     *     <li>If the artifact state is <code>PUBLISHED</code> and workflow is skipped, then the published version is deleted.</li>
     * </ul>
     * Administrator role is required.
     * @param artifactType The artifact type. Allowed values are category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param glossaryResourceList The list of artifacts to be deleted. All the
     *     artifacts must be either in published state or draft state, but mix of
     *     draft and published state is not allowed.
     * @param asyncMode If async_mode is true, then the method starts an
     *     asynchronous process to execute the given action and returns with
     *     ACCEPTED 202 status code.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Response
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Response> deleteArtifacts(@NonNull String artifactType,
                                          @NonNull GlossaryResourceList glossaryResourceList,
                                          Boolean asyncMode,
                                          String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "async_mode", asyncMode));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Response> localVarReturnType = new ParameterizedTypeReference<Response>() {};
        return apiClient.invokeAPI(
                BASE_API + "/delete", HttpMethod.POST,
                pathParams, queryParams, glossaryResourceList, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Delete the custom attribute definition with a given guid.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param customAttributeDefinitionId The guid of the custom attribute
     *     definition to be purged.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryArchiveResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryArchiveResponse> deleteCustomAttributeDefinition(@NonNull String artifactType,
                                                                         @NonNull String customAttributeDefinitionId,
                                                                         String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("custom_attribute_definition_id", customAttributeDefinitionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GlossaryArchiveResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryArchiveResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/custom_attribute_definitions/{custom_attribute_definition_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Export values of a specified type to a csv file.
     * @param artifactType The artifact type. Allowed values are category,
     *     glossary_term, data_class, policy, rule, classification
     * @param categoryId The artifactId of the parent category
     * @param includeSubcategories Whether to include assets from subcategories
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return String of CSV
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<String> exportCSV(@NonNull String artifactType,
                                  @NonNull String categoryId,
                                  Boolean includeSubcategories,
                                  String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "category_id", categoryId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_subcategories", includeSubcategories));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(
                BASE_API + "/export", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Get development logs and comments for a draft artifact version.
     * @param artifactType The artifact type. Allowed values are glossary_term,
     *     classification, data_class, reference_data, policy, rule
     * @param artifactId The artifact id.
     * @param versionId The version id.
     * @param timeZoneOffset Time zone offset based on which the day-wise grouping
     *     is to be performed. The offset will be of format [+/-]hh:mm where hh
     *     stands for hour digit and mm for minute digit. For example, +05:30
     *     indicates IST. The range of offsets is restricted to
     *     -17:59 to +17:59 inclusive.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return PaginatedAssetAggregatedCommentsList
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedAssetAggregatedCommentsList> getAggregatedLog(@NonNull String artifactType,
                                                                       @NonNull String artifactId,
                                                                       @NonNull String versionId,
                                                                       String timeZoneOffset,
                                                                       String runAsTenant,
                                                                       Integer limit,
                                                                       String offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "time_zone_offset", timeZoneOffset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedAssetAggregatedCommentsList> localVarReturnType = new ParameterizedTypeReference<PaginatedAssetAggregatedCommentsList>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/aggregated_logs",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get development logs and comments for a draft artifact version.
     * @param artifactType The artifact type. Allowed values are glossary_term,
     *     classification, data_class, reference_data, policy, rule
     * @param artifactId The artifact id.
     * @param versionId The version id.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return PaginatedAssetCommentList
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedAssetCommentList> getLog(@NonNull String artifactType,
                                                  @NonNull String artifactId,
                                                  @NonNull String versionId,
                                                  String runAsTenant,
                                                  Integer limit,
                                                  String offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedAssetCommentList> localVarReturnType = new ParameterizedTypeReference<PaginatedAssetCommentList>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/logs",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get development logs and comments for a draft artifact version with
     * the provided development log id.
     * @param artifactType The artifact type. Allowed values are glossary_term,
     *     classification, data_class, reference_data, policy, rule
     * @param artifactId The artifact id.
     * @param versionId The version id.
     * @param modId The development log id.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return PaginatedAssetCommentsModificationDetails
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedAssetCommentsModificationDetails> getLogEntry(@NonNull String artifactType,
                                                                       @NonNull String artifactId,
                                                                       @NonNull String versionId,
                                                                       @NonNull String modId,
                                                                       String runAsTenant,
                                                                       Integer limit,
                                                                       String offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("mod_id", modId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedAssetCommentsModificationDetails> localVarReturnType = new ParameterizedTypeReference<PaginatedAssetCommentsModificationDetails>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/aggregated_logs/{mod_id}",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve custom attribute definition with given guid.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param customAttributeDefinitionId The guid of the custom attribute
     *     definition to fetch.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CustomAttributeDefinition
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CustomAttributeDefinition> getCustomAttributeDefinition(@NonNull String artifactType,
                                                                        @NonNull String customAttributeDefinitionId,
                                                                        String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("custom_attribute_definition_id", customAttributeDefinitionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<CustomAttributeDefinition> localVarReturnType = new ParameterizedTypeReference<CustomAttributeDefinition>() {};
        return apiClient.invokeAPI(
                BASE_API + "/custom_attribute_definitions/{custom_attribute_definition_id}",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve custom attribute definitions with given artifact type.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CustomAttributeDefinition
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<List<CustomAttributeDefinition>> listCustomAttributeDefinitions(@NonNull String artifactType,
                                                                                String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<List<CustomAttributeDefinition>> localVarReturnType = new ParameterizedTypeReference<List<CustomAttributeDefinition>>() {};
        return apiClient.invokeAPI(
                BASE_API + "/custom_attribute_definitions",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get draft artifacts.
     * @param artifactType The artifact type. Allowed values are all,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param startsWith First character of artifact
     * @param subString Filter on substring
     * @param workflowStatus Filter by workflow status
     * @param createdBy Filter by creator of artifact
     * @param modifiedBy Filter by editor of artifact
     * @param enabled Filter Results based on enabled flag for dataclass,
     *     "yes" will give enabled dataclass, "no" will give
     *     disabled and "both" shall return all
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @param sort Value on which results need to be sort,Valid sort parameters
     *     are NAME, MODIFIED, CREATED, TYPE. Prefix hyphen (-) for descending
     *     order
     * @return PaginatedDraftArtifactsList
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedDraftArtifactsList> getDraftArtifacts(@NonNull String artifactType,
                                                               String startsWith,
                                                               String subString,
                                                               String workflowStatus,
                                                               String createdBy,
                                                               String modifiedBy,
                                                               String enabled,
                                                               String runAsTenant,
                                                               Integer limit,
                                                               String offset,
                                                               String sort) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "starts_with", startsWith));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sub_string", subString));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflow_status", workflowStatus));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "created_by", createdBy));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "modified_by", modifiedBy));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "enabled", enabled));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedDraftArtifactsList> localVarReturnType = new ParameterizedTypeReference<PaginatedDraftArtifactsList>() {};
        return apiClient.invokeAPI(BASE_API,
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get the permissions for the artifact for the authenticated user.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GovernancePermissionsForAuthenticatedUser
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<List<GovernancePermission>> getPermissions(@NonNull String artifactType,
                                                           String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<List<GovernancePermission>> localVarReturnType = new ParameterizedTypeReference<List<GovernancePermission>>() {};
        return apiClient.invokeAPI(
                BASE_API + "/permissions",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Import values from specified csv file.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, data_class policy, rule, classification
     * @param body The CSV contents to import
     * @param mergeOption Import merge option, valid values:
     *     <ul>
     *         <li>all - imported values will replace existing values in catalog</li>
     *         <li>specified - imported values that are not empty replace existing values in catalog</li>
     *         <li>empty (default) - imported values replace only empty values in catalog</li>
     *     </ul>
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryImportResult
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public ResponseEntity<GlossaryImportResult> importCSV(@NonNull String artifactType,
                                                          @NonNull File body,
                                                          String mergeOption,
                                                          String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "merge_option", mergeOption));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"multipart/form-data"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<GlossaryImportResult> localVarReturnType = new ParameterizedTypeReference<GlossaryImportResult>() {};
        return apiClient.invokeFileUploadAPI(
                BASE_API + "/import", HttpMethod.POST,
                pathParams, queryParams, body, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Add a comment for a draft artifact version.
     * @param artifactType The artifact type. Allowed values are glossary_term,
     *     classification, data_class, reference_data, policy, rule
     * @param artifactId The artifact id.
     * @param versionId The version id.
     * @param commentByUser The user comment.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CommentByUser
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CommentByUser> logComment(@NonNull String artifactType,
                                          @NonNull String artifactId,
                                          @NonNull String versionId,
                                          @NonNull CommentByUser commentByUser,
                                          String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
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

        ParameterizedTypeReference<CommentByUser> localVarReturnType = new ParameterizedTypeReference<CommentByUser>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/comments",
                HttpMethod.POST, pathParams, queryParams, commentByUser, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update a comment on a draft artifact version.
     * @param artifactType The artifact type. Allowed values are glossary_term,
     *     classification, data_class, reference_data, policy, rule
     * @param artifactId The artifact id.
     * @param versionId The version id.
     * @param commentId The comment id.
     * @param commentByUser The user comment.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CommentByUser
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CommentByUser> updateComment(@NonNull String artifactType,
                                             @NonNull String artifactId,
                                             @NonNull String versionId,
                                             @NonNull String commentId,
                                             @NonNull CommentByUser commentByUser,
                                             String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("comment_id", commentId);

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

        ParameterizedTypeReference<CommentByUser> localVarReturnType = new ParameterizedTypeReference<CommentByUser>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/comments/{comment_id}",
                HttpMethod.PATCH, pathParams, queryParams, commentByUser, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update custom attribute definition with given id.
     * @param artifactType The artifact type. Allowed values are all, category,
     *     glossary_term, classification, data_class, reference_data, policy, rule
     * @param customAttributeDefinitionId The guid of the custom attribute
     *     definition to be updated.
     * @param updatableCustomAttributeDefinitionEntity Custom attribute definition
     *     to be updated. Fields omitted will be unchanged, and fields
     *     set to null explicitly will be nulled out. For multi-valued
     *     attributes and relationships, the complete list will be replaced by
     *     the given list of values.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CustomAttributeDefinition
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CustomAttributeDefinition> updateCustomAttributeDefinition(@NonNull String artifactType,
                                                                           @NonNull String customAttributeDefinitionId,
                                                                           @NonNull NewCustomAttributeDefinitionEntity updatableCustomAttributeDefinitionEntity,
                                                                           String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_type", artifactType);
        pathParams.put("custom_attribute_definition_id", customAttributeDefinitionId);

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

        ParameterizedTypeReference<CustomAttributeDefinition> localVarReturnType = new ParameterizedTypeReference<CustomAttributeDefinition>() {};
        return apiClient.invokeAPI(
                BASE_API + "/custom_attribute_definitions/{custom_attribute_definition_id}",
                HttpMethod.PATCH, pathParams, queryParams, updatableCustomAttributeDefinitionEntity, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);
    }

}
