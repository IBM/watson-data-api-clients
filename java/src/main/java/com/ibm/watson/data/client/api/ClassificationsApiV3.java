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

public class ClassificationsApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/classifications";

    @Autowired
    public ClassificationsApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Creates a classification in the glossary.
     * This method is used to create a classification in the glossary.
     * <p><b>201</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>409</b> - Unique constraint violated because of optimistic locking or
     * some other constraint. <p><b>500</b> - Internal Server Error
     * @param newClassificationEntity Classification to be created.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     artifact will be created in the published state by skipping the
     *     workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> create(NewClassificationEntity newClassificationEntity,
                                               Boolean skipWorkflowIfPossible,
                                               String runAsTenant) throws RestClientException {

        // verify the required parameter 'newClassificationEntity' is set
        if (newClassificationEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'newClassificationEntity' when calling createClassification");
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
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                newClassificationEntity, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create relationships for an artifact in the glossary.
     * If it is a published version, it creates a draft from the published version
     * and adds the relationship to the draft version. And, it returns the details
     * of the draft version. <p><b>201</b> - Success <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the classification to fetch.
     * @param versionId The version id of the classification to fetch.
     * @param classificationRelationshipsRequest Relationships to be created.
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
                                                            ClassificationRelationshipsRequest classificationRelationshipsRequest,
                                                            Boolean skipWorkflowIfPossible,
                                                            String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling createClassificationRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling createClassificationRelationships");
        }
        // verify the required parameter 'classificationRelationshipsRequest' is set
        if (classificationRelationshipsRequest == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'classificationRelationshipsRequest' when calling createClassificationRelationships");
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
                HttpMethod.POST, pathParams, queryParams, classificationRelationshipsRequest, headerParams,
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
     * Unauthorized <p><b>404</b> - Not found <p><b>500</b> - Internal Server
     * Error
     * @param artifactId The guid of the classification to fetch.
     * @param versionId The version id of the classification to delete.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be deleted by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> delete(String artifactId,
                                               String versionId,
                                               Boolean skipWorkflowIfPossible,
                                               String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling deleteClassification");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling deleteClassification");
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

        ParameterizedTypeReference<GlossaryCreateResponse> localVarReturnType = new ParameterizedTypeReference<GlossaryCreateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Deletes relationships for an artifact in the glossary.
     * If it is a published version, it creates a draft from the published version
     * and deletes the relationship from the draft version. And, it returns the
     * details of the draft version. <p><b>200</b> - Success <p><b>400</b> - Bad
     * Request <p><b>401</b> - Unauthorized <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the classification to fetch.
     * @param versionId The version id of the classification to fetch.
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
                    "Missing the required parameter 'artifactId' when calling deleteReltionship");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling deleteReltionship");
        }
        // verify the required parameter 'relationshipId' is set
        if (relationshipId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'relationshipId' when calling deleteReltionship");
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
     * Retrieves classification with given guid and status.
     * This method can be used for retrieving details of an ACTIVE classification.
     * Only ACTIVE is supported <p><b>200</b> - Success <p><b>400</b> - Bad
     * Request <p><b>401</b> - Unauthorized <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param guid Artifact ID or global ID of the artifact
     * @param status Filter by classification status
     * @param includeRelationship Comma separated list of relationship
     *     types.Allowed values of relationship types are
     *     &lt;code&gt;is_a_type_of_classification,has_types_classifications,categoriesparent_category,,terms,data_classes,policies,rules,reference_data,all&lt;/code&gt;
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
    public Mono<PaginatedClassificationList> get(String guid,
                                                 String status,
                                                 String includeRelationship,
                                                 Boolean allParents,
                                                 String limit,
                                                 String offset,
                                                 String runAsTenant) throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling getClassificationByArtifactId");
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_parents", allParents));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedClassificationList> localVarReturnType = new ParameterizedTypeReference<PaginatedClassificationList>() {};
        return apiClient.invokeAPI(BASE_API + "/{guid}/versions",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieves classification with given guid.
     * This method can be used for retrieving details of an ACTIVE or DRAFT
     * classification. <p><b>200</b> - Success <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the classification to fetch.
     * @param versionId The version id of the classification to fetch.
     * @param includeRelationship Comma separated list of relationship
     *     types.Allowed values of relationship types are
     *     &lt;code&gt;is_a_type_of_classification,has_types_classifications,categoriesparent_category,,terms,data_classes,policies,rules,reference_data,all&lt;/code&gt;
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseClassification
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseClassification> getVersion(String artifactId,
                                                   String versionId,
                                                   String includeRelationship,
                                                   Boolean allParents,
                                                   String limit,
                                                   String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling getClassificationByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling getClassificationByVersionId");
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

        ParameterizedTypeReference<ResponseClassification> localVarReturnType = new ParameterizedTypeReference<ResponseClassification>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieves all classifications.
     * This method can be used for retrieving details of all classifications.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param status Filter by term status
     * @param includeRelationship Comma separated list of relationship
     *     types.Allowed values of relationship types are
     *     &lt;code&gt;is_a_type_of_classification,has_types_classifications,categoriesparent_category,,terms,data_classes,policies,rules,reference_data,all&lt;/code&gt;
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param limit The maximum number of terms to return - must be at least 1 and
     *     cannot exceed 200. The default value is 10.
     * @param offset The index of the first matching classification to include in
     *     the result. At present, the offset value can be 0 (zero) or a multiple
     *     of limit value.
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedClassificationList> list(String status,
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

        ParameterizedTypeReference<PaginatedClassificationList> localVarReturnType = new ParameterizedTypeReference<PaginatedClassificationList>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * List the associations of the given type for the specified classification.
     * If the result set is larger than the &lt;code&gt;limit&lt;/code&gt;
     * parameter, it returns the first &lt;code&gt;limit&lt;/code&gt; number of
     * associations. &lt;br/&gt;To retrieve the next set of associations, call the
     * method again by using the URI in
     * &lt;code&gt;PaginatedTagsList.next&lt;/code&gt; returned by this
     * method.&lt;br/&gt;&lt;br/&gt;Associations of a child term, like
     * &lt;code&gt;SSN&lt;/code&gt;, includes the associations of its parent
     * terms, like &lt;code&gt;Government Identities&lt;/code&gt;. <p><b>200</b> -
     * Success <p><b>400</b> - Bad Request <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal Server Error
     * @param artifactId The artifactId of the classification
     * @param versionId The versionId of the classification
     * @param type Comma separated list of relationship types.Allowed values of
     *     relationship types are
     *     &lt;code&gt;is_a_type_of_classification,has_types_classifications,categoriesparent_category,,terms,data_classes,policies,rules,reference_data,all&lt;/code&gt;
     * @param allParents If this parameter is set, then all ancestors in the
     *     hierarchy are returned. You can use this parameter to build complete
     *     ancestor path.
     * @param limit The maximum number of associations to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param offset Index of the beginning of the page. At present, the offset
     *     value can be 0 (zero) or a multiple of limit value.
     * @return {@code Map<String, PaginatedAbstractRelationshipList>}
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
                    "Missing the required parameter 'artifactId' when calling listClassificationRelationships");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling listClassificationRelationships");
        }
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'type' when calling listClassificationRelationships");
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
     * Updates a draft or published artifact. If a published version is updated, a
     * draft version is created from the published version and the draft version
     * is updated with the requested changes and returned. If any relationships of
     * the artifact are updated, then the updated relationships are returned as a
     * paginated list limited by the give limit parameter. The relationships that
     * are not updated are not returned. <p><b>200</b> - Success <p><b>400</b> -
     * Bad Request <p><b>401</b> - Unauthorized <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>409</b> - Unique constraint violated because of optimistic locking or
     * some other constraint. <p><b>500</b> - Internal Server Error
     * @param artifactId The artifact id of the classification to be updated.
     * @param versionId The version id of the classification to be updated.
     * @param updatableClassificationEntity The classification to be
     *     updated.&lt;br&gt;Fields omitted will be unchanged, and fields set to
     *     null explicitly will be nulled out.&lt;br&gt;For multi-valued
     *     attributes &amp; relationships, the complete list will be replaced by
     *     the given list of values.&lt;br&gt;Additional
     *     Example:&lt;br&gt;&lt;pre&gt;{&amp;quot;description&amp;quot; :
     *     &amp;quot;description updated&amp;quot;}&lt;/pre&gt;
     * @param limit The maximum number of relationship to return - must be at
     *     least 1 and cannot exceed 200. The default value is 10.
     * @param skipWorkflowIfPossible If Workflow template is configured, the
     *     published artifact will be updated by skipping the workflow.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return ResponseClassification
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ResponseClassification> update(String artifactId,
                                               String versionId,
                                               UpdatableClassificationEntity updatableClassificationEntity,
                                               String limit,
                                               Boolean skipWorkflowIfPossible,
                                               String runAsTenant) throws RestClientException {

        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling updateClassificationByVersionId");
        }
        // verify the required parameter 'versionId' is set
        if (versionId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'versionId' when calling updateClassificationByVersionId");
        }
        // verify the required parameter 'updatableClassificationEntity' is set
        if (updatableClassificationEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updatableClassificationEntity' when calling updateClassificationByVersionId");
        }
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

        ParameterizedTypeReference<ResponseClassification> localVarReturnType = new ParameterizedTypeReference<ResponseClassification>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{artifact_id}/versions/{version_id}",
                HttpMethod.PATCH, pathParams, queryParams, updatableClassificationEntity, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
