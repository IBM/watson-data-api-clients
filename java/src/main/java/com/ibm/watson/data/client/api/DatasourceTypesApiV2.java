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
import com.ibm.watson.data.client.model.DatasourceType;
import com.ibm.watson.data.client.model.DatasourceTypeCollection;
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

/**
 * API endpoints dealing with Datasource Types.
 */
public class DatasourceTypesApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/datasource_types";

    @Autowired
    public DatasourceTypesApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Get details for type of data source
     * Get details for type of data source.
     * <p><b>200</b> - A data source type definition.
     * <p><b>401</b> - You are not authorized to retrieve the type details of the
     * data source. <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>404</b> - The data source type details cannot be found.
     * <p><b>429</b> - The service is currently receiving more requests than it
     * can process in a timely fashion. Please retry submitting your request
     * later. <p><b>500</b> - An error occurred. No data source type details were
     * retrieved. <p><b>504</b> - A timeout occurred when processing your request.
     * Please retry later.
     * @param datasourceType The data source type.
     * @param acceptLanguage The user&#39;s preferred locale identifier.
     * @param connectionProperties Whether to return information about connection
     *     properties.
     * @param interactionProperties Whether to return information about source and
     *     target interaction properties.
     * @param discovery Whether to return information about discovery
     *     capabilities.
     * @param actions Whether to return information about supported actions.
     * @return DatasourceType
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<DatasourceType> get(String datasourceType,
                                    String acceptLanguage,
                                    Boolean connectionProperties,
                                    Boolean interactionProperties,
                                    Boolean discovery,
                                    Boolean actions) throws RestClientException {

        // verify the required parameter 'datasourceType' is set
        if (datasourceType == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceType' when calling getDatasourceType");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("datasource_type", datasourceType);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "connection_properties", connectionProperties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "interaction_properties", interactionProperties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "discovery", discovery));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "actions", actions));

        if (acceptLanguage != null)
            headerParams.add("Accept-Language", apiClient.parameterToString(acceptLanguage));
        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DatasourceType> localVarReturnType = new ParameterizedTypeReference<DatasourceType>() {};
        return apiClient.invokeAPI(BASE_API + "/{datasource_type}",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List defined types of data sources
     * Gets all defined types of data sources.  The following fields are available
     * for use with the sort parameter:  | field name   | description | |
     * ------------ | ---------------------------------------------------- | |
     * entity.label | The name of the data source type in a readable form. | |
     * entity.type  | The major type of the data source type.              |
     * <p><b>200</b> - Collection of data source types.
     * <p><b>401</b> - You are not authorized to list the defined types of data
     * sources. <p><b>403</b> - You are not permitted to perform this action.
     * <p><b>429</b> - The service is currently receiving more requests than it
     * can process in a timely fashion. Please retry submitting your request
     * later. <p><b>500</b> - An error occurred. No data source types were
     * retrieved. <p><b>504</b> - A timeout occurred when processing your request.
     * Please retry later.
     * @param acceptLanguage The user&#39;s preferred locale identifier.
     * @param sort The field to sort the results on, including whether to sort
     *     ascending (+) or descending (-), for example,
     *     sort&#x3D;-metadata.create_time
     * @param offset The 0-based index of the first result to return, for example,
     *     offset&#x3D;200. If not specified, the default offset of 0 is used.
     * @param limit The limit of the number of items to return, for example
     *     limit&#x3D;50. If not specified a default of 100 will be  used.
     * @param connectionProperties Whether to return information about the
     *     connection properties.
     * @param interactionProperties Whether to return information about the source
     *     and target interaction properties.
     * @param discovery Whether to return information about discovery
     *     capabilities.
     * @param actions Whether to return information about supported actions.
     * @param entityEnvironment Specify the environment the data source types must
     *     support to be included in the returned list. The available environments
     *     are &#39;cloud&#39;, &#39;streams&#39; and &#39;local&#39;. If no
     *     entity.environment is specified, the default for service&#39;s deploy
     *     environment is used. To specify multiple environments, use a
     *     comma-separated string, such as entity.environment&#x3D;cloud,streams.
     * @param entityProduct Specify the product the data source types must support
     *     to be included in the returned list. The available products are
     *     &#39;catalog&#39;, &#39;cpd&#39;, &#39;ml&#39; and &#39;studio&#39;. If
     *     no entity.product is specified, the default for service&#39;s deploy
     *     product is used. To specify multiple products, use a comma-separated
     *     string, such as entity.product&#x3D;catalog,studio.
     * @return DatasourceTypeCollection
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<DatasourceTypeCollection> list(String acceptLanguage,
                                               String sort,
                                               Integer offset,
                                               Integer limit,
                                               Boolean connectionProperties,
                                               Boolean interactionProperties,
                                               Boolean discovery,
                                               Boolean actions,
                                               String entityEnvironment,
                                               String entityProduct) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "connection_properties", connectionProperties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "interaction_properties", interactionProperties));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "discovery", discovery));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "actions", actions));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.environment", entityEnvironment));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entity.product", entityProduct));

        if (acceptLanguage != null)
            headerParams.add("Accept-Language", apiClient.parameterToString(acceptLanguage));
        final String[] localVarAccepts = {"application/json;charset=utf-8", "application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<DatasourceTypeCollection> localVarReturnType = new ParameterizedTypeReference<DatasourceTypeCollection>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
