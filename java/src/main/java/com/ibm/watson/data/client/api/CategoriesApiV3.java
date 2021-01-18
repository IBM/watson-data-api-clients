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

        ParameterizedTypeReference<Category> localVarReturnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}", HttpMethod.GET, pathParams, queryParams,
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
