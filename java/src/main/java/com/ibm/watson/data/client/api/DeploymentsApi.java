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
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

/**
 * API endpoints dealing with Watson Machine Learning deployments.
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
     * Execute a synchronous deployment prediction
     * Execute a synchronous prediction for the deployment with the specified identifier. 
     * <p><b>200</b> - Scoring response.
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param deploymentId The deployment id.
     * @param syncScoringData The scoring data. 
     * @return SyncScoringDataResults
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SyncScoringDataResults> predict(LocalDate version,
                                                String deploymentId,
                                                SyncScoringData syncScoringData) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling deploymentsComputePredictions", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'deploymentId' when calling deploymentsComputePredictions", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'syncScoringData' is set
        if (syncScoringData == null) {
            throw new WebClientResponseException("Missing the required parameter 'syncScoringData' when calling deploymentsComputePredictions", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Create a new WML deployment
     * Create a new model, function or Python Script application deployment. 
     * <p><b>202</b> - Deployment created.
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param deploymentEntityRequest The deployment entity. 
     * @return DeploymentResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResource> create(LocalDate version,
                                           DeploymentEntityRequest deploymentEntityRequest) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling deploymentsCreate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'deploymentEntityRequest' is set
        if (deploymentEntityRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'deploymentEntityRequest' when calling deploymentsCreate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Delete the deployment
     * Delete the deployment with the specified identifier. 
     * <p><b>204</b> - Deployment deleted.
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param deploymentId The deployment id.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> delete(LocalDate version, String deploymentId, String spaceId) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling deploymentsDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'deploymentId' when calling deploymentsDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new WebClientResponseException("Missing the required parameter 'spaceId' when calling deploymentsDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Retrieve the deployment details
     * Retrieve the deployment details with the specified identifier. 
     * <p><b>200</b> - Deployment details.
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param deploymentId The deployment id.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @return DeploymentResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResource> get(LocalDate version, String deploymentId, String spaceId) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling deploymentsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'deploymentId' when calling deploymentsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new WebClientResponseException("Missing the required parameter 'spaceId' when calling deploymentsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Retrieve the deployments
     * Retrieve the list of deployments for the specified space. 
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @param tagValue Retrieves only the resources with the given tag value.
     * @param assetId Retrieves only the resources with the given asset_id, asset_id would be either model_id or function_id. 
     * @param name Retrieves only the resources with the given name.
     * @param type Retrieves the resources filtered with the given type. Allowed values are &#x60;model&#x60;, &#x60;function&#x60;, &#x60;py_script&#x60; and &#x60;do&#x60;. 
     * @param state Retrieves the resources filtered by state. Allowed values are &#x60;initializing&#x60;, &#x60;updating&#x60;, &#x60;ready&#x60; and &#x60;failed&#x60;.
     * @param stats Returns stats about deployments within a space or across spaces if it is set to true. This query parameter cannot be combined with any other except for &#39;space_id&#39;.
     * @return DeploymentResources
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResources> list(LocalDate version,
                                          String spaceId,
                                          String tagValue,
                                          String assetId,
                                          String name,
                                          String type,
                                          String state,
                                          Boolean stats) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling deploymentsList", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
     * Update the deployment metadata
     * Update the deployment metadata. The following parameters of deployment metadata are supported for the patch operation.  * tags * name * description * custom * virtual.parameters * hardware_spec * hybrid_pipeline_hardware_specs * asset  In case of online deployments, using PATCH operation of &#x60;/ml/v4/deployments&#x60;, users can update the number of copies of an online deployment. Users can specify the desired value of number of copies in &#x60;hardware_spec.num_nodes&#x60; parameter. As &#x60;hardware_spec.name&#x60; or &#x60;hardware_spec.id&#x60; is mandatory for &#x60;hardware_spec&#x60; schema, a valid value such as &#x60;XS&#x60;, &#x60;S&#x60; must be specified for &#x60;hardware_spec.name&#x60; parameter as part of PATCH request. Alternatively, users can also specify a valid ID of a hardware specification in &#x60;hardware_spec.id&#x60; parameter. However, changes related to &#x60;hardware_spec.name&#x60; or &#x60;hardware_spec.id&#x60; specified in PATCH operation will not be applied for online deployments. &lt;br /&gt; In case of batch deployments, using PATCH operation of &#x60;/ml/v4/deployments&#x60;, users can update the hardware specification so that subsequent batch deployment jobs can make use of the updated compute configurations. To update the compute configuration, users must specify a valid value for either &#x60;hardware_spec.name&#x60; or &#x60;hardware_spec.id&#x60; of the hardware specification that suits their requirement. In the batch deployment context, &#x60;hardware_spec.num_nodes&#x60; parameter is not currently supported. &lt;br /&gt; When &#39;asset&#39; is patched with id/rev,    - Deployment with the patched id/rev is started.    - If the deployment is asynchronous, 202 response code will be returned and one can poll the deployment status thereafter.    - If the deployment is synchronous, 200 response code will be returned with patched deployment response.    - If any failures, deployment will be reverted back to the previous id/rev and the failure message will be captured in &#39;failures&#39; field in the response. 
     * <p><b>200</b> - Deployment updated.
     * <p><b>202</b> - Deployment accepted
     * <p><b>400</b> - Bad request, the response body should contain the reason. 
     * <p><b>401</b> - Unauthorized. 
     * <p><b>403</b> - Forbidden, an authentication error including trying to access a forbidden space. 
     * <p><b>404</b> - The specified resource was not found. 
     * @param version The version date for the API of the form &#x60;YYYY-MM-DD&#x60;. 
     * @param deploymentId The deployment id.
     * @param spaceId Retrieves the deployments of assets that belong to this space.
     * @param jsonPatch The json patch. 
     * @return DeploymentResource
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DeploymentResource> update(LocalDate version,
                                           String deploymentId,
                                           String spaceId,
                                           List<JSONResourcePatchModel> jsonPatch) throws WebClientResponseException {

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new WebClientResponseException("Missing the required parameter 'version' when calling deploymentsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'deploymentId' when calling deploymentsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new WebClientResponseException("Missing the required parameter 'spaceId' when calling deploymentsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'jsonPatch' is set
        if (jsonPatch == null) {
            throw new WebClientResponseException("Missing the required parameter 'jsonPatch' when calling deploymentsUpdate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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
