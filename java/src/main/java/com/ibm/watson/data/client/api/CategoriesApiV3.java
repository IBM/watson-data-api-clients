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
import com.ibm.watson.data.client.model.Category;
import com.ibm.watson.data.client.model.CategoryHierarchyResponse;
import com.ibm.watson.data.client.model.CreateCategoryResponse;
import com.ibm.watson.data.client.model.GlossaryArchiveResponse;
import com.ibm.watson.data.client.model.NewCategoryAssignment;
import com.ibm.watson.data.client.model.NewCategoryEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
     * secondary category. <p><b>200</b> - An existing category assignment updated
     * (e.g. changed from secondary to primary). <p><b>201</b> - A new category
     * assignment created. <p><b>401</b> - Unauthorized <p><b>404</b> - The
     * category with the given {category_id} or the artifact with the given
     * {artifact_id} does not exist in the glossary. <p><b>500</b> - Internal
     * Server Error
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
    public Mono<NewCategoryAssignment> addArtifact(String categoryId,
                                                   String artifactId,
                                                   NewCategoryAssignment newCategoryAssignment,
                                                   String runAsTenant) throws RestClientException {

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'categoryId' when calling addArtifactToCategory");
        }
        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling addArtifactToCategory");
        }
        // verify the required parameter 'newCategoryAssignment' is set
        if (newCategoryAssignment == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'newCategoryAssignment' when calling addArtifactToCategory");
        }
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
     * <p><b>201</b> - The category has been created successfully.
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>409</b> - UniqueConstraintViolation - category with given name and
     * parent already exists. <p><b>500</b> - Internal Server Error
     * @param newCategoryEntity Category to be created.
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return CreateCategoryResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateCategoryResponse> create(NewCategoryEntity newCategoryEntity, String runAsTenant) throws RestClientException {

        // verify the required parameter 'newCategoryEntity' is set
        if (newCategoryEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'newCategoryEntity' when calling createCategory");
        }
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

        ParameterizedTypeReference<CreateCategoryResponse> localVarReturnType = new ParameterizedTypeReference<CreateCategoryResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, newCategoryEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Removes an artifact from its secondary category.
     * It can be used to remove a secondary category assignment for an artifact.
     * It does not allow to remove an artifact from a primary category as a
     * primary category assignment is obligatory. <p><b>204</b> - A secondary
     * category assignment removed. <p><b>400</b> - Attempt to remove an artifact
     * from its primary category failed, because a primary category assignment is
     * mandatory. <p><b>401</b> - Unauthorized <p><b>404</b> - The category with
     * the given {category_id} does not exist in the glossary. <p><b>500</b> -
     * Internal Server Error
     * @param categoryId The artifact ID or the global ID of a category
     * @param artifactId The artifact ID or the global ID of an artifact to be
     *     removed from a (secondary) category
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> removeArtifact(String categoryId, String artifactId, String runAsTenant) throws RestClientException {

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'categoryId' when calling deleteArtifactFromCategory");
        }
        // verify the required parameter 'artifactId' is set
        if (artifactId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'artifactId' when calling deleteArtifactFromCategory");
        }
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
     * This method can be used to delete a category.&lt;br&gt;Note! The category
     * must be empty. It can contain neither child categories nor artifacts.
     * <p><b>200</b> - The category has been deleted successfully.
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - The category with given {guid} does not exist in the
     * glossary. <p><b>500</b> - Internal Server Error
     * @param guid Artifact ID or global ID of the artifact
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return GlossaryArchiveResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<GlossaryArchiveResponse> delete(String guid, String runAsTenant) throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling deleteCategoryById");
        }
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
     * <p><b>200</b> - The category has been retrieved successfully.
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - The category with given {guid} does not exist in the
     * glossary. <p><b>500</b> - Internal Server Error
     * @param guid Artifact ID or global ID of the artifact
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Category> get(String guid, String runAsTenant) throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling getCategoryById");
        }
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
     * Retrieves category hierarchy paths for given artifact ids of categories
     * This method can be used for retrieving hierarchy paths of categories
     * <p><b>200</b> - The hierarchy paths of categories have been retrieved
     * successfully <p><b>401</b> - Unauthorized <p><b>404</b> - The category with
     * given {guid} does not exist in the glossary. <p><b>500</b> - Internal
     * Server Error
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
     * [uncategorized] category, which is a default one for all artifacts.
     * <p><b>200</b> - The category has been retrieved successfully.
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Internal Server Error
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
     * This method can be used to update a category with given id.&lt;br&gt;It may
     * be an update of its name, description, or parent category. <p><b>200</b> -
     * The category has been updated successfully. <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - The category with given {guid} does not exist in the
     * glossary. <p><b>409</b> - The category was modified by another user.
     * <p><b>500</b> - Internal Server Error
     * @param guid Artifact ID or global ID of the artifact
     * @param updatableCategoryEntity Category to be updated.&lt;br&gt;Fields
     *     omitted will be unchanged, and fields set to null explicitly will be
     *     nulled out.&lt;br&gt;For multi-valued attributes &amp; relationships,
     *     the complete list will be replaced by the given list of
     *     values.&lt;br&gt;Additional
     *     Example:&lt;br&gt;&lt;pre&gt;{&amp;quot;description&amp;quot; :
     *     &amp;quot;short desc updated&amp;quot;}&lt;/pre&gt;
     * @param runAsTenant Runs the operation as a different tenant.  Requires the
     *     FunctionalUser role.  Format: accountId[:userId]
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Category> update(String guid, NewCategoryEntity updatableCategoryEntity, String runAsTenant)
            throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling updateCategory");
        }
        // verify the required parameter 'updatableCategoryEntity' is set
        if (updatableCategoryEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updatableCategoryEntity' when calling updateCategory");
        }
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
