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
import java.util.Locale;
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
 * API endpoints dealing with Categories.
 */
public class CategoriesApiV3 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v3/categories";

    @Autowired
    public CategoriesApiV3(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Adds an artifact to a category.
     * It can be used to set a primary category for an artifact (replacing an old
     * primary category assignment if existed) as well as to add an artifact to a
     * secondary category.
     * @param categoryId The artifact ID or the global ID of a category
     * @param artifactId The artifact ID or the global ID of an artifact to be
     *     added to the category
     * @param newCategoryAssignment Assignment of an artifact to a category
     *     (primary of secondary)
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return NewCategoryAssignment
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<NewCategoryAssignment> addArtifact(@NonNull String categoryId,
                                                   @NonNull String artifactId,
                                                   @NonNull NewCategoryAssignment newCategoryAssignment,
                                                   String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("category_id", categoryId);
        pathParams.put("artifact_id", artifactId);

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

        ParameterizedTypeReference<NewCategoryAssignment> localVarReturnType = new ParameterizedTypeReference<NewCategoryAssignment>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{category_id}/artifacts/{artifact_id}", HttpMethod.PUT,
                pathParams, queryParams, newCategoryAssignment, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Creates a category in the glossary.
     * This method can be used to create a new category in the glossary.
     * @param newCategoryEntity Category to be created.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryCreateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryCreateResponse> create(@NonNull NewCategoryEntity newCategoryEntity,
                                               String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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
                BASE_API, HttpMethod.POST, pathParams, queryParams, newCategoryEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Creates single collaborator for given category.
     * To create collaborator one needs to provide id of the collaborating user and the name
     * of the role she will be permitted. Collaborator is effective for given category and whole
     * tree of its subcategories.
     * @param categoryId The artifact ID or the global ID of a category
     * @param newRoleAssignment Collaborator's data: user id and assigned role.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the FunctionalUser role.  Format: accountId[:userId]
     * @return RoleAssignment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<RoleAssignment> createCollaborator(@NonNull String categoryId,
                                                   @NonNull NewRoleAssignment newRoleAssignment,
                                                   String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("category_id", categoryId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = { "application/json" };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { "application/json" };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<RoleAssignment> localVarReturnType = new ParameterizedTypeReference<RoleAssignment>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{category_id}/collaborators", HttpMethod.POST, pathParams, queryParams,
                newRoleAssignment, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Removes an artifact from its secondary category.
     * It can be used to remove a secondary category assignment for an artifact.
     * It does not allow to remove an artifact from a primary category as a
     * primary category assignment is obligatory.
     * @param categoryId The artifact ID or the global ID of a category
     * @param artifactId The artifact ID or the global ID of an artifact to be
     *     removed from a (secondary) category
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> removeArtifact(@NonNull String categoryId,
                                     @NonNull String artifactId,
                                     String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("category_id", categoryId);
        pathParams.put("artifact_id", artifactId);

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
                BASE_API + "/{category_id}/artifacts/{artifact_id}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Deletes the category with a given guid.
     * Note: The category must be empty. It can contain neither child categories nor artifacts.
     * @param guid Artifact ID or global ID of the artifact
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryArchiveResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryArchiveResponse> delete(@NonNull String guid,
                                                String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

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
                BASE_API + "/{guid}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Deletes single collaborator.
     * Collaborator represents single user together with single role that gives her certain
     * privileges in context of given category.
     * @param categoryId The artifact ID or the global ID of a category
     * @param collaboratorId The id of the collaborator.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the FunctionalUser role.  Format: accountId[:userId]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteCollaborator(@NonNull String categoryId,
                                         @NonNull String collaboratorId,
                                         String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("category_id", categoryId);
        pathParams.put("collaborator_id", collaboratorId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = { "application/json" };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{category_id}/collaborators/{collaborator_id}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the relationships for the specified artifacts.
     * If the result set is larger than the <code>limit</code> parameter, it returns the first
     * <code>limit</code> number of relationships. To retrieve the next set of relationships,
     * call the method again by using the URI in <code>PaginatedRelationshipsList.next</code> returned
     * by this method.
     * @param type Comma separated list of relationship types. Allowed values of relationship types are <code>parent_category</code>
     * @param glossaryResourceList The list of artifact IDs.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the FunctionalUser role.  Format: accountId[:userId]
     * @param allParents If this parameter is set, then all ancestors in the hierarchy are returned. You can use this parameter to build complete ancestor path.
     * @param limit The maximum number of relationship to return - must be at least 1 and cannot exceed 200. The default value is 10.
     * @return ArtifactRelationshipsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ArtifactRelationshipsResponse> findRelationships(@NonNull String type,
                                                                 @NonNull GlossaryResourceList glossaryResourceList,
                                                                 String runAsTenant,
                                                                 Boolean allParents,
                                                                 String limit) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_parents", allParents));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = { "application/json" };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { "application/json" };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ArtifactRelationshipsResponse> localVarReturnType = new ParameterizedTypeReference<ArtifactRelationshipsResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/relationships/search", HttpMethod.POST, pathParams, queryParams,
                glossaryResourceList, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);
    }

    /**
     * Get status of category bootstrap process.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the FunctionalUser role.  Format: accountId[:userId]
     * @return BootstrapStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<BootstrapStatus> getBootstrapStatus(String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = { "application/json" };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<BootstrapStatus> localVarReturnType = new ParameterizedTypeReference<BootstrapStatus>() {};
        return apiClient.invokeAPI(
                BASE_API + "/collaborators/bootstrap/status", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieves category with given guid.
     * This method can be used for retrieving details of a category.
     * @param guid Artifact ID or global ID of the artifact
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Category> get(@NonNull String guid,
                              String runAsTenant) throws RestClientException {
        return get(guid, runAsTenant, false);
    }

    /**
     * Retrieves category with given guid.
     * This method can be used for retrieving details of a category.
     * @param guid Artifact ID or global ID of the artifact
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @param includeRelationships When set to true fetch all category relationships user has access to
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Category> get(@NonNull String guid,
                              String runAsTenant,
                              Boolean includeRelationships) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (includeRelationships != null) {
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_relationships", includeRelationships));
        }

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Category> localVarReturnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieves collaborators for given artifact id of a category.
     * Single collaborator is an users with assigned roles in context of given category.
     * A role comes with rights to access the category, its sub-categories and artifacts and potential responsibilities.
     * @param categoryId The artifact ID or the global ID of a category
     * @param runAsTenant Runs the operation as a different tenant.  Requires the FunctionalUser role.  Format: accountId[:userId]
     * @param includeInherited If this parameter is true, the returned list contains collaborators not only for given category, but also for all parent categories, up to root category.
     * @param role If set then the returned list will be reduced to collaborators with given role only.
     * @return RoleAssignmentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<RoleAssignmentResponse> getCollaborators(@NonNull String categoryId,
                                                         String runAsTenant,
                                                         Boolean includeInherited,
                                                         String role) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("category_id", categoryId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_inherited", includeInherited));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role", role));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = { "application/json" };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<RoleAssignmentResponse> localVarReturnType = new ParameterizedTypeReference<RoleAssignmentResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{category_id}/collaborators", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieves category hierarchy paths for given category GUIDs.
     * @param categoryId The id of the category whose path is fetched
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CategoryHierarchyResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CategoryHierarchyResponse> getHierarchyPaths(List<String> categoryId,
                                                             String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(
                ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)),
                "category_id", categoryId));

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<CategoryHierarchyResponse> localVarReturnType = new ParameterizedTypeReference<CategoryHierarchyResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/hierarchy", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Retrieves the special [uncategorized] category.
     * This method can be used for retrieving details of the special
     * [uncategorized] category, which is the default category for all artifacts.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Category> getUncategorizedCategory(String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<Category> localVarReturnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(
                BASE_API + "/uncategorized", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Start category boostrap process.
     * Assigns default owners and view permissions for root categories without any role assignments set.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the FunctionalUser role.  Format: accountId[:userId]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> startBoostrap(String runAsTenant) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        if (runAsTenant != null)
            headerParams.add("Run-As-Tenant", apiClient.parameterToString(runAsTenant));
        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/collaborators/bootstrap", HttpMethod.POST, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Updates category with given id.
     * It may be an update of its name, description, or parent category.
     * @param guid Artifact ID or global ID of the artifact
     * @param updatableCategoryEntity Category to be updated. Fields
     *     omitted will be unchanged, and fields set to null explicitly will be
     *     nulled out. For multi-valued attributes and relationships,
     *     the complete list will be replaced by the given list of
     *     values.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Category> update(@NonNull String guid,
                                 @NonNull NewCategoryEntity updatableCategoryEntity,
                                 String runAsTenant)
            throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

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

        ParameterizedTypeReference<Category> localVarReturnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}", HttpMethod.PATCH, pathParams, queryParams,
                updatableCategoryEntity, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
