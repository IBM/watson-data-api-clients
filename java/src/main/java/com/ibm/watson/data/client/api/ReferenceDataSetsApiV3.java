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

import java.io.File;
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
 * API endpoints dealing with Reference Data Sets.
 */
public class ReferenceDataSetsApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/reference_data";

    @Autowired
    public ReferenceDataSetsApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Delete the reference data value identified by code in the Reference Data
     * Set.
     * If the reference data set is published then a
     * workflow will be started with a draft created from which the value will be
     * deleted. If the artifact is a draft copy then the value from the draft copy
     * will be removed.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param requestBody The list of codes of the reference data values to be
     *     removed
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> deleteValues(@NonNull String artifactId,
                                                     @NonNull String versionId,
                                                     String runAsTenant,
                                                     List<String> requestBody) throws RestClientException {

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

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values",
                HttpMethod.DELETE, pathParams, queryParams, requestBody, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Associate Reference data set with other governance artifacts.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param referenceDataSetRelationships list of relationships that need to
     *     created for reference data set
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CreateRelationshipResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateRelationshipResponse> createRelationships(@NonNull String artifactId,
                                                                @NonNull String versionId,
                                                                @NonNull ReferenceDataSetRelationships referenceDataSetRelationships,
                                                                Boolean skipWorkflowIfPossible,
                                                                String runAsTenant)
            throws RestClientException {

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

        ParameterizedTypeReference<CreateRelationshipResponse> localVarReturnType = new ParameterizedTypeReference<CreateRelationshipResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/relationships",
                HttpMethod.POST, pathParams, queryParams, referenceDataSetRelationships, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Create term relationships for reference data values.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param code Code of reference data value for which terms are to be assigned
     * @param newRelationship Terms list to be added to reference data value for
     *     the given code and reference data set id
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CreateValueRelationshipResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateValueRelationshipResponse> relateTermsToValue(@NonNull String artifactId,
                                                                    @NonNull String versionId,
                                                                    @NonNull String code,
                                                                    @NonNull List<NewRelationship> newRelationship,
                                                                    String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("code", code);

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

        ParameterizedTypeReference<CreateValueRelationshipResponse> localVarReturnType = new ParameterizedTypeReference<CreateValueRelationshipResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/{code}/relationships",
                HttpMethod.POST, pathParams, queryParams, newRelationship, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Request cancellation of an ongoing reference data values import process.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param importId The import id for the reference data values import process.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return RDVImportInfoResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<RDVImportInfoResponse> cancelImport(@NonNull String artifactId,
                                                    @NonNull String versionId,
                                                    @NonNull String importId,
                                                    String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("import_id", importId);

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

        ParameterizedTypeReference<RDVImportInfoResponse> localVarReturnType = new ParameterizedTypeReference<RDVImportInfoResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/import/{import_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Create a reference data set.
     * Note: For Reference Data values,
     * precision will be lost if long value has more than 15-16 digits as JSON
     * parser will map to double type regardless of whether it is used for
     * integer, long or floating-point numbers. To Preserve all digits pass the
     * value as a string.
     * @param newReferenceDataSetEntity Reference data set to be
     *     created.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     artifact will be created in the published state by skipping the
     *     workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> create(@NonNull NewReferenceDataSetEntity newReferenceDataSetEntity,
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
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                newReferenceDataSetEntity, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Add reference data values to the specified reference data set.
     * Note: For Reference Data values,
     * precision will be lost if long value has more than 15-16 digits as JSON
     * parser will map to double type regardless of whether it is used for
     * integer, long or floating-point numbers. To Preserve all digits pass the
     * value as a string.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param referenceDataValuesList Reference data values to be
     *     created.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CreateRDVResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateRDVResponse> createValues(@NonNull String artifactId,
                                                @NonNull String versionId,
                                                @NonNull ReferenceDataValuesList referenceDataValuesList,
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

        ParameterizedTypeReference<CreateRDVResponse> localVarReturnType = new ParameterizedTypeReference<CreateRDVResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values",
                HttpMethod.PUT, pathParams, queryParams, referenceDataValuesList, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete the reference data set.
     * If the artifact is published then a workflow will be started with a draft
     * created with label marked for deletion which on approval will result in a
     * actual delete. If the artifact is a draft copy then the draft copy will be
     * deleted from the system.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
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
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get current state of reference data values import.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param importId The import id for the reference data values import process.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return RDVImportInfoResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<RDVImportInfoResponse> getImport(@NonNull String artifactId,
                                                 @NonNull String versionId,
                                                 @NonNull String importId,
                                                 String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("import_id", importId);

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

        ParameterizedTypeReference<RDVImportInfoResponse> localVarReturnType = new ParameterizedTypeReference<RDVImportInfoResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/import/{import_id}",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve list of reference data sets.
     * This method can be used for retrieving details of an ACTIVE, PUBLISHED or
     * DRAFT reference data set.
     * @param guid Artifact ID or global ID of the artifact
     * @param status Reference data set status to filter by. Allowed values
     *     PUBLISHED (default), ACTIVE, DRAFT.
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are terms,
     *     classifications,data_classes,rules,all
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
    public Mono<PaginatedReferenceDataSetList> list(@NonNull String guid,
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

        ParameterizedTypeReference<PaginatedReferenceDataSetList> localVarReturnType = new ParameterizedTypeReference<PaginatedReferenceDataSetList>() {};
        return apiClient.invokeAPI(BASE_API + "/{guid}/versions",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve details of the specified reference data set.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set or specify
     *     CURRENT to fetch from published active version
     * @param filterCodeOrValue String to filter the values by code or text value
     * @param sortCode sort direction for code
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are terms,
     *     classifications,data_classes,rules,all
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of relationships to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset The index of the first matching relationship to include in
     *     the result.
     * @param valuesLimit The maximum number of reference data values to return -
     *     must be at least 1 and cannot exceed 200. The default value is 10.
     * @param valuesOffset The index of the first matching value to include in the
     *     result.
     * @return ResponseReferenceDataSet
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseReferenceDataSet> get(@NonNull String artifactId,
                                              @NonNull String versionId,
                                              String filterCodeOrValue,
                                              String sortCode,
                                              String includeRelationship,
                                              String runAsTenant,
                                              Integer limit,
                                              Integer offset,
                                              Integer valuesLimit,
                                              Integer valuesOffset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter[code_or_value]", filterCodeOrValue));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort[code]", sortCode));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_relationship", includeRelationship));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "values_limit", valuesLimit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "values_offset", valuesOffset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ResponseReferenceDataSet> localVarReturnType = new ParameterizedTypeReference<ResponseReferenceDataSet>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Export values of a specified reference data set to a csv file.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set or specify
     *     CURRENT to fetch from published active version
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param codeonly Specify if only RDS code needs to be exported.
     * @param includeAssociatedTerms Include associated terms to a reference data
     *     value.
     * @return String of CSV
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<String> exportValues(@NonNull String artifactId,
                                     @NonNull String versionId,
                                     String runAsTenant,
                                     Boolean codeonly,
                                     Boolean includeAssociatedTerms) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codeonly", codeonly));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_associated_terms", includeAssociatedTerms));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/octet-stream", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Import values for given import Id.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param importId Import id to for the specific import action
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> importValues(@NonNull String artifactId,
                                                     @NonNull String versionId,
                                                     @NonNull String importId,
                                                     String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("import_id", importId);

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

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/import/{import_id}",
                HttpMethod.POST, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Import reference data values from csv file.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param code Column name(number if is_first_row_header is false) of the code
     *     field in CSV file.
     * @param value Column name(number if is_first_row_header is false) of the
     *     value field in CSV file.
     * @param body The body parameter
     * @param isFirstRowHeader Does the csv file have header as first record
     * @param description Column name(number if is_first_row_header is false) of
     *     the description field in CSV file.
     * @param includeAssociatedTerms Associate terms to a reference data value.
     * @param relatedTerms Column name(number if is_first_row_header is false) of
     *     the related terms field in CSV file. If column name not
     *     provided, default column name "related terms" or
     *     "related_terms" either case will pick from the CSV
     *     file
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param valueConflicts IGNORE/OVERWRITE/REJECT if a value already exists.
     *     default is OVERWRITE
     * @param trimWhiteSpaces Specify if to trim leading and trailing spaces for
     *     code, value &amp; description.
     * @return CreateRDSResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public ResponseEntity<CreateRDSResponse> importValuesCSV(@NonNull String artifactId,
                                                             @NonNull String versionId,
                                                             @NonNull String code,
                                                             @NonNull String value,
                                                             @NonNull File body,
                                                             Boolean isFirstRowHeader,
                                                             String description,
                                                             Boolean includeAssociatedTerms,
                                                             String relatedTerms,
                                                             String runAsTenant,
                                                             String valueConflicts,
                                                             Boolean trimWhiteSpaces) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "is_first_row_header", isFirstRowHeader));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "code", code));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "value", value));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "description", description));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_associated_terms", includeAssociatedTerms));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "related_terms", relatedTerms));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "value_conflicts", valueConflicts));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "trim_white_spaces", trimWhiteSpaces));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"multipart/form-data"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<CreateRDSResponse> localVarReturnType = new ParameterizedTypeReference<CreateRDSResponse>() {};
        return apiClient.invokeFileUploadAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/import",
                HttpMethod.PUT, pathParams, queryParams, body, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List the relationships of the given type for the specified reference data
     * set. If the result set is larger than the <code>limit</code>
     * parameter, it returns the first <code>limit</code> number of
     * associations. &lt;br/&gt;To retrieve the next set of relationships, call
     * the method again by using the offset set to index of last member in current
     * set <p><b>200</b> - Success <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param type Comma separated list of relationship types. Allowed values of
     *     association types are terms, classifications,data_classes,rules,all
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return Map&lt;String,
     *     AbstractOffsetPaginatedListRelationshipAbstractRelationshipEntity&gt;
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
     * List the term relationship of the reference data value.
     * If the result set is larger than the <code>limit</code>
     * parameter, it returns the first <code>limit</code> number of
     * associations. To retrieve the next set of relationships, call
     * the method again by using the offset set to index of last member in current
     * set.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param code Code of reference data value whose term relationship is to be
     *     retrieved
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return {@code Map<String, PaginatedAbstractRelationshipList>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Map<String, PaginatedAbstractRelationshipList>> listValueRelationships(@NonNull String artifactId,
                                                                                       @NonNull String versionId,
                                                                                       @NonNull String code,
                                                                                       Integer limit,
                                                                                       String offset)
            throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("code", code);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Map<String, PaginatedAbstractRelationshipList>> localVarReturnType = new ParameterizedTypeReference<Map<String, PaginatedAbstractRelationshipList>>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/{code}/relationships",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete the association to a reference data set.
     * @param artifactId The guid of the reference data set from which
     *     relationship is to be deleted.
     * @param versionId The guid of the reference data set from which relationship
     *     is to be deleted.
     * @param relationshipId The guid of the relationship to be deleted.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> deleteRelationship(@NonNull String artifactId,
                                                           @NonNull String versionId,
                                                           @NonNull String relationshipId,
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
     * Delete the term relationship associated to reference data value identified
     * by code.
     * @param artifactId The artifact_id of the reference data set from which
     *     relationship is to be deleted.
     * @param versionId The version_id of the reference data set from which
     *     relationship is to be deleted.
     * @param code The code of data value from which to delete relationship.
     * @param relationshipId The guid of the relationship to be deleted.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> deleteValueRelationship(@NonNull String artifactId,
                                                                @NonNull String versionId,
                                                                @NonNull String code,
                                                                @NonNull String relationshipId,
                                                                String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("artifact_id", artifactId);
        pathParams.put("version_id", versionId);
        pathParams.put("code", code);
        pathParams.put("relationship_id", relationshipId);

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

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values/{code}/relationships/{relationship_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update a reference data set.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param updatableReferenceDataSetEntity The reference data set to be
     *     updated.&lt;br&gt;Fields omitted will be unchanged. For multi-valued
     *     attributes, like values and relationships, use the respective
     *     endpoints.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseReferenceDataSet
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseReferenceDataSet> update(@NonNull String artifactId,
                                                 @NonNull String versionId,
                                                 @NonNull UpdatableReferenceDataSetEntity updatableReferenceDataSetEntity,
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

        ParameterizedTypeReference<ResponseReferenceDataSet> localVarReturnType = new ParameterizedTypeReference<ResponseReferenceDataSet>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.PATCH, pathParams, queryParams, updatableReferenceDataSetEntity, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update the reference data values identified by code.
     * Note: Precision will be lost if long value has more
     * than 15-16 digits as JSON parser will map to double type regardless of
     * whether it is used for integer, long or floating-point numbers. To
     * Preserve all digits pass the value as a string.
     * @param artifactId The artifact id of the reference data set.
     * @param versionId The version id of the reference data set.
     * @param updatableReferenceDataValuesList Reference data values to be
     *     updated.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CreateRDVResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateRDVResponse> updateValues(@NonNull String artifactId,
                                                @NonNull String versionId,
                                                @NonNull UpdatableReferenceDataValuesList updatableReferenceDataValuesList,
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

        ParameterizedTypeReference<CreateRDVResponse> localVarReturnType = new ParameterizedTypeReference<CreateRDVResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/values",
                HttpMethod.PATCH, pathParams, queryParams, updatableReferenceDataValuesList, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
