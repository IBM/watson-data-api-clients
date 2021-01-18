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
 * API endpoints for dealing with Data Classes.
 */
public class DataClassesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/data_classes";

    @Autowired
    public DataClassesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Create a draft data class in the glossary.
     * If the effective start date of selected reference data set is a future date, then
     * effective start date of data class will be same as that of selected
     * reference data set effective start date.
     * @param newDataClassEntity Data class to be created.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     artifact will be created in the published state by skipping the
     *     workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> create(@NonNull NewDataClassEntity newDataClassEntity,
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
                BASE_API, HttpMethod.POST, pathParams, queryParams, newDataClassEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create relationships for an artifact in the glossary.
     * If it is a published version, it creates a draft from the published version
     * and adds the relationship to the draft version. And, it returns the details
     * of the draft version.
     * @param artifactId The artifact ID of the data class to fetch.
     * @param versionId The version ID of the data class to fetch.
     * @param dataClassRelationshipsRequest Relationships to be created.
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
                                                            @NonNull DataClassRelationshipsRequest dataClassRelationshipsRequest,
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
                HttpMethod.POST, pathParams, queryParams, dataClassRelationshipsRequest, headerParams,
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
     * @param artifactId The artifact id of the dataclass to delete.
     * @param versionId The version id of the dataclass to delete.
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
     * Delete relationships for an artifact in the glossary.
     * If it is a published version, it creates a draft from the published version
     * and deletes the relationship from the draft version. And, it returns the
     * details of the draft version.
     * @param artifactId The artifact ID of the data class to fetch.
     * @param versionId The version ID of the data class to fetch.
     * @param relationshipId The guid of the relationship to delete.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be deleted by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryArchiveResponse
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
     * Retrieve data class with given guid and status.
     * This method can be used for retrieving details of an ACTIVE or DRAFT data
     * class. Only ACTIVE is allowed as status right now.
     * @param guid Artifact ID or global ID of the artifact
     * @param status Filter by dataclass status
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are
     *     <code>is_a_type_of_data_class,has_types_data_classes,parent_category,categories,terms,classifications,policies,rules,reference_data,all</code>
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
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
    public Mono<PaginatedDataClassList> getByStatus(@NonNull String guid,
                                                    String status,
                                                    String includeRelationship,
                                                    Boolean allParents,
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_parents", allParents));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedDataClassList> localVarReturnType = new ParameterizedTypeReference<PaginatedDataClassList>() {};
        return apiClient.invokeAPI(BASE_API + "/{guid}/versions",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve data class with given guid.
     * This method can be used for retrieving details of an ACTIVE or DRAFT data
     * class.
     * @param artifactId The artifact ID of the data class to fetch.
     * @param versionId The version ID of the data class to fetch.
     * @param includeRelationship Comma separated list of relationship types.
     *     Allowed values of association types are
     *     <code>is_a_type_of_data_class,has_types_data_classes,parent_category,categories,terms,classifications,policies,rules,reference_data,all</code>
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseDataClass
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseDataClass> getByVersion(@NonNull String artifactId,
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

        ParameterizedTypeReference<ResponseDataClass> localVarReturnType = new ParameterizedTypeReference<ResponseDataClass>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the data classes in the given format.
     * This method is used to retrieve the data classes in the given format. It
     * supports both json and xml formats for returning data classes.
     * @param status Filter by dataclass status
     * @param format The format of the data classes to be returned. It supports
     *     both json and xml formats for returning data classes. The data classes
     *     in XML format is mainly intended for WKC Profiling service consumption.
     * @param enabled To filter data classes based on enabled property. The
     *     enabled query parameter accepts (Yes, No, Both) where Yes is the
     *     default value. This filter is not implemented due to lack of backend
     *     support. This option is not applicable for format=xml.
     * @param enabledForProfiling To filter data classes based on enabled for
     *     profiling. The enabled for profiling query parameter accepts (Yes, No,
     *     Both) where Yes is the default value. This option is not applicable for
     *     format=json.
     * @param includeRelationship Comma separated list of relationship types. This
     *     parameter is applicable only when format=json. Allowed values of
     *     association types are
     *     <code>is_a_type_of_data_class,has_types_data_classes,parent_category,categories,terms,classifications,policies,rules,reference_data,all</code>
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of data_classes to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset The index of the first matching data_class to include in the
     *     result.
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedDataClassList> list(String status,
                                             String format,
                                             String enabled,
                                             String enabledForProfiling,
                                             String includeRelationship,
                                             Boolean allParents,
                                             String runAsTenant,
                                             Integer limit,
                                             Integer offset) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "format", format));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "enabled", enabled));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "enabled_for_profiling", enabledForProfiling));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_relationship", includeRelationship));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_parents", allParents));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json", "application/xml"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedDataClassList> localVarReturnType = new ParameterizedTypeReference<PaginatedDataClassList>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * List the relationships of the given type for the specified data class.
     * If the result set is larger than the <code>limit</code>
     * parameter, it returns the first <code>limit</code> number of
     * associations. To retrieve the next set of relationships, call
     * the method again by using the URI in
     * <code>PaginatedTagsList.next</code> returned by this
     * method. Relationships of a child term, like
     * <code>SSN</code>, includes the rest of its parent terms, like
     * <code>Government Identities</code>.
     * @param artifactId The artifact ID of the data class to fetch.
     * @param versionId The version ID of the data class to fetch.
     * @param type Comma separated list of relationship types. Allowed values of
     *     association types are
     *     <code>is_a_type_of_data_class,has_types_data_classes,parent_category,categories,terms,classifications,policies,rules,reference_data,all</code>
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return PaginatedDataClassRelationships
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedDataClassRelationships> listRelationships(@NonNull String artifactId,
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

        ParameterizedTypeReference<PaginatedDataClassRelationships> localVarReturnType = new ParameterizedTypeReference<PaginatedDataClassRelationships>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}/relationships",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update a draft or published artifact. If a published version is updated, a
     * draft version is created from the published version and the draft version
     * is updated with the requested changes and returned. If any relationships of
     * the artifact are updated, then the updated relationships are returned as a
     * paginated list limited by the given limit parameter. The relationships that
     * are not updated are not returned.
     * @param artifactId The artifact id of the data class to be updated.
     * @param versionId The version id of the data class to be updated.
     * @param updatableDataClassEntity The data class to be
     *     updated. Fields omitted will be unchanged, and fields set to
     *     null explicitly will be nulled out. For multi-valued
     *     attributes and relationships, the complete list will be replaced by
     *     the given list of values. If the effective
     *     start date of selected reference data set is a future date, then
     *     effective start date of data class will be same as that of selected
     *     reference data set effective start date.
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseDataClass
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseDataClass> update(@NonNull String artifactId,
                                          @NonNull String versionId,
                                          @NonNull UpdatableDataClassEntity updatableDataClassEntity,
                                          String limit,
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

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip_workflow_if_possible", skipWorkflowIfPossible));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ResponseDataClass> localVarReturnType = new ParameterizedTypeReference<ResponseDataClass>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.PATCH, pathParams, queryParams, updatableDataClassEntity, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
