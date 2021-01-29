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
import com.ibm.watson.data.client.model.CreateTransactionProjectResponse;
import com.ibm.watson.data.client.model.TransactionStatusItem;
import com.ibm.watson.data.client.model.TransactionalProjectCreate;
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
 * API endpoints for dealing with projects through cascading transactional actions. Always use these endpoints over
 * those in ProjectsApiV2, where possible.
 */
public class TransactionalProjectsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/transactional/v2/projects";

    @Autowired
    public TransactionalProjectsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Delete project as a transaction.
     * Deletes a project with a given GUID, deletes COS bucket and all the files
     * in it, all credentials and asset container in the reverse order from the
     * project creation transaction.
     * @param guid The GUID for the project to be deleted.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String guid) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{guid}",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get status of transaction created using create project.
     * @param guid The GUID for the project on which transaction was created.
     * @param id The transaction ID provided by create project as a transaction
     *     endpoint.
     * @return TransactionStatusItem
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<TransactionStatusItem> status(@NonNull String guid,
                                              @NonNull String id) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);
        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<TransactionStatusItem> localVarReturnType = new ParameterizedTypeReference<TransactionStatusItem>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{guid}/transactions/{id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Create project as a transaction.
     * Creates a new project with the provided parameters, including all the
     * storage and credentials in a single transaction. This endpoint will create
     * a new COS bucket using generated unique name, all credentials, asset
     * container and call all the required atomic APIs to fully configure a new
     * project. Attempts to use the duplicate project names will result in an
     * error.<br><br>
     * This endpoint can also be used to create
     * a project from an exported Watson Studio .zip file. In this case, a new
     * transaction is initiated to create assets under the project. A Transaction
     * ID along with a URL is returned as a response of this API. As this
     * transaction can take time, you can view the current status of the
     * transaction using the returned URL. (This
     * feature is only available in the private cloud.)
     * @param newBodyName The newBodyName parameter
     * @return CreateTransactionProjectResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CreateTransactionProjectResponse> create(@NonNull TransactionalProjectCreate newBodyName) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "multipart/form-data"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<CreateTransactionProjectResponse>
                localVarReturnType = new ParameterizedTypeReference<CreateTransactionProjectResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams,
                newBodyName, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
