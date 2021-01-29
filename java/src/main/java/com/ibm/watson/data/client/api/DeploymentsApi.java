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

import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.data.client.ApiClient;
import com.ibm.watson.data.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClientException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * API endpoints dealing with Watson Machine Learning Deployments.
 */
public class DeploymentsApi {

    private ApiClient apiClient;
    public static final String BASE_API = "/ml/v4/deployments";

    @Autowired
    public DeploymentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Execute a synchronous prediction for the deployment with the specified identifier.
     * @param version The version date for the API.
     * @param deploymentId The deployment id.
     * @param syncScoringData The scoring data. 
     * @return SyncScoringDataResults
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<SyncScoringDataResults> predict(@NonNull LocalDate version,
                                                @NonNull String deploymentId,
                                                @NonNull SyncScoringData syncScoringData) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("deployment_id", deploymentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<SyncScoringDataResults> localVarReturnType = new ParameterizedTypeReference<SyncScoringDataResults>() {};
        return apiClient.invokeAPI(BASE_API + "/{deployment_id}/predictions", HttpMethod.POST,
                pathParams, queryParams, syncScoringData, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Create a new model, function or Python Script application deployment.
     * @param version The version date for the API.
     * @param deploymentEntityRequest The deployment entity. 
     * @return DeploymentResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResource> create(@NonNull LocalDate version,
                                           @NonNull DeploymentEntityRequest deploymentEntityRequest) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DeploymentResource> localVarReturnType = new ParameterizedTypeReference<DeploymentResource>() {};
        return apiClient.invokeAPI(BASE_API, HttpMethod.POST,
                pathParams, queryParams, deploymentEntityRequest, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Delete the deployment with the specified identifier.
     * @param version The version date for the API.
     * @param deploymentId The deployment id.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> delete(@NonNull LocalDate version,
                             @NonNull String deploymentId,
                             @NonNull String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("deployment_id", deploymentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{deployment_id}", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the deployment details with the specified identifier.
     * @param version The version date for the API.
     * @param deploymentId The deployment id.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @return DeploymentResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResource> get(@NonNull LocalDate version,
                                        @NonNull String deploymentId,
                                        @NonNull String spaceId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("deployment_id", deploymentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DeploymentResource> localVarReturnType = new ParameterizedTypeReference<DeploymentResource>() {};
        return apiClient.invokeAPI(BASE_API + "/{deployment_id}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the list of deployments for the specified space.
     * @param version The version date for the API.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @param tagValue Retrieves only the resources with the given tag value.
     * @param assetId Retrieves only the resources with the given asset_id, asset_id would be either model_id or function_id. 
     * @param name Retrieves only the resources with the given name.
     * @param type Retrieves the resources filtered with the given type. Allowed values are "model", "function", "py_script" and "do".
     * @param state Retrieves the resources filtered by state. Allowed values are "initializing", "updating", "ready" and "failed".
     * @param stats Returns stats about deployments within a space or across spaces if it is set to true. This query parameter cannot be combined with any other except for &#39;space_id&#39;.
     * @return DeploymentResources
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResources> list(@NonNull LocalDate version,
                                          String spaceId,
                                          String tagValue,
                                          String assetId,
                                          String name,
                                          String type,
                                          String state,
                                          Boolean stats) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag.value", tagValue));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "asset_id", assetId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "stats", stats));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DeploymentResources> localVarReturnType = new ParameterizedTypeReference<DeploymentResources>() {};
        return apiClient.invokeAPI(BASE_API, HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Update the deployment metadata.
     * The following parameters of deployment metadata are supported for the patch operation:
     * <ul>
     *     <li>tags</li>
     *     <li>name</li>
     *     <li>description</li>
     *     <li>custom</li>
     *     <li>virtual.parameters</li>
     *     <li>hardware_spec</li>
     *     <li>hybrid_pipeline_hardware_specs</li>
     *     <li>asset</li>
     * </ul>
     * In case of online deployments,
     * users can update the number of copies of an online deployment. Users can specify the desired
     * value of number of copies in "hardware_spec.num_nodes" parameter. As "hardware_spec.name" or
     * "hardware_spec.id" is mandatory for "hardware_spec" schema, a valid value such as "XS",
     * "S" must be specified for "hardware_spec.name" parameter. Alternatively,
     * users can also specify a valid ID of a hardware specification in "hardware_spec.id" parameter.
     * However, changes related to "hardware_spec.name" or "hardware_spec.id" will not be applied for online deployments.<br><br>
     * In case of batch deployments, users can update the hardware specification so that subsequent
     * batch deployment jobs can make use of the updated compute configurations. To update the compute
     * configuration, users must specify a valid value for either "hardware_spec.name" or
     * "hardware_spec.id" of the hardware specification that suits their requirement. In the batch
     * deployment context, "hardware_spec.num_nodes" parameter is not currently supported.<br><br>
     * When "asset" is patched with id/rev:
     * <ul>
     *     <li>Deployment with the patched id/rev is started.</li>
     *     <li>If the deployment is asynchronous, 202 response code will be returned and one can poll the deployment status thereafter.</li>
     *     <li>If the deployment is synchronous, 200 response code will be returned with patched deployment response.</li>
     *     <li>If any failures, deployment will be reverted back to the previous id/rev and the failure message will be captured in "failures" field in the response.</li>
     * </ul>
     * @param version The version date for the API.
     * @param deploymentId The deployment id.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @param jsonPatch The json patch. 
     * @return DeploymentResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResource> update(@NonNull LocalDate version,
                                           @NonNull String deploymentId,
                                           @NonNull String spaceId,
                                           @NonNull List<JSONResourcePatchModel> jsonPatch) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("deployment_id", deploymentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DeploymentResource> localVarReturnType = new ParameterizedTypeReference<DeploymentResource>() {};
        return apiClient.invokeAPI(BASE_API + "/{deployment_id}", HttpMethod.PATCH,
                pathParams, queryParams, jsonPatch, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType, localVarReturnType);

    }

}
