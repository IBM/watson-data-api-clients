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

/**
 * API endpoints dealing with Catalogs.
 */
public class CatalogsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/catalogs";

    @Autowired
    public CatalogsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Activate OMRS services
     * Use this to activate the OMRS services for a catalog, using the stored
     * configuration information <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> activateOMRSServer(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling activateOMRSServer");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/instance", HttpMethod.POST,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Creating IGC-WKC default (aka sync) catalog
     * Use this to create the default catalog, configure and start the OMAG
     * server. <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param createDefaultCatalogRequest {   \&quot;catalog\&quot;: {
     *     \&quot;name\&quot;: \&quot;The Default Catalog\&quot;,
     *     \&quot;generator\&quot;: \&quot;Catalog-OMRS-Synced\&quot;,
     *     \&quot;description\&quot;: \&quot;The default (aka sync)
     *     catalog\&quot;,     \&quot;bss_account_id\&quot;: \&quot;999\&quot;,
     *     \&quot;is_governed\&quot;: \&quot;true\&quot;, \&quot;bucket\&quot;: {
     *     \&quot;bucket_type\&quot;: \&quot;assetfiles\&quot;     }   },
     *     \&quot;event_bus\&quot;: {     \&quot;producer\&quot;: {
     *     \&quot;bootstrap.servers\&quot;: \&quot;kafka:9093\&quot;,
     *     \&quot;acks\&quot;: \&quot;all\&quot;,       \&quot;retries\&quot;:
     *     \&quot;1\&quot;,       \&quot;batch.size\&quot;: \&quot;16384\&quot;,
     *     \&quot;linger.ms\&quot;: \&quot;1\&quot;, \&quot;buffer.memory\&quot;:
     *     \&quot;33554432\&quot;,       \&quot;max.request.size\&quot;:
     *     \&quot;10485760\&quot;,       \&quot;key.serializer\&quot;:
     *     \&quot;org.apache.kafka.common.serialization.StringSerializer\&quot;,
     *     \&quot;value.serializer\&quot;:
     *     \&quot;org.apache.kafka.common.serialization.StringSerializer\&quot; },
     *     \&quot;consumer\&quot;: {       \&quot;bootstrap.servers\&quot;:
     *     \&quot;kafka:9093\&quot;, \&quot;zookeeper.session.timeout.ms\&quot;:
     *     \&quot;300000\&quot;,       \&quot;zookeeper.sync.time.ms\&quot;:
     *     \&quot;2000\&quot;,       \&quot;fetch.message.max.bytes\&quot;:
     *     \&quot;10485760\&quot;,       \&quot;max.partition.fetch.bytes\&quot;:
     *     \&quot;10485760\&quot;,       \&quot;max.poll.interval.ms\&quot;:
     *     \&quot;2000000000\&quot;,       \&quot;key.deserializer\&quot;:
     *     \&quot;org.apache.kafka.common.serialization.StringDeserializer\&quot;,
     *     \&quot;value.deserializer\&quot;:
     *     \&quot;org.apache.kafka.common.serialization.StringDeserializer\&quot;
     *     }   } }
     * @param checkBucketExistence Whether an existence check should be performed
     *     on the catalog bucket
     * @param topicUrlRoot common root of the topics used by the open metadata
     *     server
     * @return Response
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Response> createCatalogOnOmrsOneCatalogCohort(CreateDefaultCatalogRequest createDefaultCatalogRequest,
                                                              Boolean checkBucketExistence,
                                                              String topicUrlRoot) throws RestClientException {

        // verify the required parameter 'createDefaultCatalogRequest' is set
        if (createDefaultCatalogRequest == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'createDefaultCatalogRequest' when calling createCatalogOnOmrsOneCatalogCohort");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "check_bucket_existence", checkBucketExistence));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "topic_url_root", topicUrlRoot));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Response> localVarReturnType = new ParameterizedTypeReference<Response>() {};
        return apiClient.invokeAPI(
                BASE_API + "/default", HttpMethod.POST, pathParams, queryParams,
                createDefaultCatalogRequest, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create a catalog
     * Use this API to create a catalog to organize your assets and collaborators.
     * You can use a catalog to easily to find and share data for your
     * organization, regardless of the location or format of the data.  You must
     * have the Admin role for Data Catalog in your organization&#39;s IBM Watson
     * Data Platform account on Bluemix.&lt;br/&gt; When you create a catalog, you
     * must supply credentials for IBM Cloud Object Storage (S3 API), which
     * provides encrypted storage for the assets that you copy to the catalog.
     * <p><b>200</b> - successful operation
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param catalogEntity {  \&quot;name\&quot;:\&quot;Test Catalog\&quot;,
     *     \&quot;generator\&quot;:\&quot;test@us.ibm.com\&quot;,
     *     \&quot;description\&quot;:\&quot;a new catalog\&quot; }
     * @param checkBucketExistence Whether an existence check should be performed
     *     on the catalog bucket
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> create(CatalogEntity catalogEntity, Boolean checkBucketExistence) throws RestClientException {

        // verify the required parameter 'catalogEntity' is set
        if (catalogEntity == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogEntity' when calling createCatalogV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "check_bucket_existence", checkBucketExistence));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Catalog> localVarReturnType = new ParameterizedTypeReference<Catalog>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.POST, pathParams, queryParams, catalogEntity,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Configure catalog to participate in an OMRS cohort
     * Use this to configure a catalog to participate in an OMRS cohort.  An OMRS
     * configuration document is created or updated with the specified cohort
     * information. <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden <p><b>500</b> - Internal Server
     * Error
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @param topicUrlRoot common root of the topics used by the open metadata
     *     server
     * @param requestBody name/value pairs used to configure the connection to the
     *     event bus connector
     * @return OMAGServerConfig
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMAGServerConfig> createOMRSServerConfig(String catalogId,
                                                         String cohortName,
                                                         String topicUrlRoot,
                                                         Map<String, Object> requestBody) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling createOMRSServerConfig");
        }
        // verify the required parameter 'cohortName' is set
        if (cohortName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'cohortName' when calling createOMRSServerConfig");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("cohort_name", cohortName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "topic_url_root", topicUrlRoot));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OMAGServerConfig> localVarReturnType = new ParameterizedTypeReference<OMAGServerConfig>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/cohorts/{cohort_name}",
                HttpMethod.POST, pathParams, queryParams, requestBody, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Permanently deactivate OMRS services and unregister from all cohorts
     * Use this to permanently deactivate OMRS services for a catalog, and
     * unregister the catalog from all OMRS cohorts. The OMRS config document and
     * corresponding registrystore documents for the catalog are deleted.
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deactivateOMRSServer(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling deactivateOMRSServer");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{catalog_id}/open-metadata",
                HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete a catalog by catalog ID
     * Use this API to delete a catalog if you have the Admin role.Deleting a
     * catalog removes all items that are associated with the catalog, such as
     * metadata for all assets in the catalog. <p><b>204</b> - No Content
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param catalogId Catalog GUID
     * @param deleteBucket delete_bucket
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(String catalogId, Boolean deleteBucket) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling deleteCatalogV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "delete_bucket", deleteBucket));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Unregister from an OMRS cohort
     * Unregister a catalog from an OMRS cohort. Once unregistered, the catalog
     * can no longer send or receive messages from the cohort. <p><b>204</b> - No
     * Content <p><b>400</b> - Bad Request <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> disableAccessToCohort(String catalogId, String cohortName) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling disableAccessToCohort");
        }
        // verify the required parameter 'cohortName' is set
        if (cohortName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'cohortName' when calling disableAccessToCohort");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("cohort_name", cohortName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType =
                new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/cohorts/{cohort_name}",
                HttpMethod.DELETE, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get OMRS assets that have not yet been propagated into WKC
     * Gets a list of OMRS asset that have not yet been propagated into WKC.
     * Either connections or data assets can be found. <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param type The type of the asset to find.  Must be either DATA_ASSET or
     *     CONNECTION.  Defaults to DATA_ASSET
     * @param limit Limit to use when finding pending assets.  Defaults to 25
     * @param bookmark Optional bookmark to use when finding pending assets.
     * @return OmrsProcessingStatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OmrsProcessingStatusResponse> findPendingAssets(String catalogId,
                                                                String type,
                                                                Integer limit,
                                                                String bookmark) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling findPendingAssets");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bookmark", bookmark));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OmrsProcessingStatusResponse> localVarReturnType = new ParameterizedTypeReference<OmrsProcessingStatusResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/pending_assets",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * List all properties of a catalog
     * Use this API to get all properties of catalog.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> getAllProperties(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getAllCatalogPropertiesV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        // TODO: This is not actually a Void response, but need a better example to see how the actual response
        //  should be modeled
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{catalog_id}/properties",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve the default catalog for OMRS sync processing
     * Use this to retrieve the default catalog for OMRS sync processing.  This
     * catalog is configured on the one_catalog OMRS cohort. <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> getCatalogOnOmrsOneCatalogCohort() throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Catalog> localVarReturnType = new ParameterizedTypeReference<Catalog>() {};
        return apiClient.invokeAPI(
                BASE_API + "/default", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get a single property in a catalog
     *  Use this API to get the property of catalog by given property key.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param propertyKey catalog property key
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> getProperty(String catalogId, String propertyKey) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getCatalogPropertyV2");
        }
        // verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'propertyKey' when calling getCatalogPropertyV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("property_key", propertyKey);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/properties/{property_key}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve OMRS audit logs
     * Use this to retrieve the OMRS audit logs for a catalog.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param startTimestamp timestamp value to start searching for new messages
     * @param messageIdPrefix Prefix value to filter message_id -- for example,
     *     &#39;OCF-KAFKA&#39; or &#39;OMRS-AUDIT&#39;.
     * @param severity Comma delimited values of severity --
     *     OMRSAuditLogRecordSeverity (Error, Exception, Action, Information,
     *     Decision, etc.)
     * @param since Number of minutes before current time to set start_timestamp;
     *     ignored if start_timestamp &gt; 0.
     * @return OMRSAuditLogMapResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMRSAuditLogMapResponse> getOMRSAuditLogs(String catalogId,
                                                          Long startTimestamp,
                                                          String messageIdPrefix,
                                                          String severity,
                                                          Integer since)
            throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOMRSAuditLogs");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_timestamp", startTimestamp));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "message_id_prefix", messageIdPrefix));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "severity", severity));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "since", since));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OMRSAuditLogMapResponse> localVarReturnType = new ParameterizedTypeReference<OMRSAuditLogMapResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/audit_logs", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the OMRS Kafka certificate
     * Use this to retrieve the OMRS Kafka certificate document for a catalog and
     * cohort. <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @return OMAGCertificateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMAGCertificateResponse> getOMRSCertificateDocument(String catalogId,
                                                                    String cohortName) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOMRSCertificateDocument");
        }
        // verify the required parameter 'cohortName' is set
        if (cohortName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'cohortName' when calling getOMRSCertificateDocument");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("cohort_name", cohortName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OMAGCertificateResponse> localVarReturnType = new ParameterizedTypeReference<OMAGCertificateResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/cohorts/{cohort_name}/certificate",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Retrieve the OMRS configuration document
     * Use this to retrieve the OMRS configuration document for a catalog. The
     * configuration document will contain details about all OMRS cohorts in which
     * the catalog participates. <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @return OMAGServerConfig
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMAGServerConfig> getOMRSConfigDocument(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOMRSConfigDocument");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OMAGServerConfig> localVarReturnType = new ParameterizedTypeReference<OMAGServerConfig>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/configuration", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the OMRS registry store
     * Use this to retrieve the OMRS registry store document for a specified
     * catalog and cohort. <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @return CohortMembership
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CohortMembership> getOMRSRegistryStore(String catalogId, String cohortName) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOMRSRegistryStore");
        }
        // verify the required parameter 'cohortName' is set
        if (cohortName == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'cohortName' when calling getOMRSRegistryStore");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);
        pathParams.put("cohort_name", cohortName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<CohortMembership> localVarReturnType = new ParameterizedTypeReference<CohortMembership>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/cohorts/{cohort_name}/registrystore",
                HttpMethod.GET, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Get OMRS entity info
     * Generates a report showing the known information about the sync status of
     * an OMRS entity <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b>
     * - Unauthorized <p><b>403</b> - Forbidden <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param guid OMRS entity guid to lookup
     * @param showAssets Whether to include the asset list in the output
     * @param showDeletedAssets Whether to include deleted assets in the output
     * @param showGraph Whether to include the reachability graph in the output
     * @param lookup Lookup options for getting the entity info.  Allowed values:
     *     SELF_AND_PARENTS, SELF_PARENTS_AND_CHILDREN, ALL&lt;br&gt;&lt;table
     *     border&#x3D;\&quot;1\&quot;&gt;&lt;thead&gt;&lt;tr&gt;&lt;th&gt;Option&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;&lt;/thead&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td&gt;&lt;code&gt;SELF_AND_PARENTS&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Includes
     *     the logical OMRS asset that the guid belongs to and its parents.  The
     *     graph traveral is restricted to a single WKC
     *     asset.&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;&lt;code&gt;SELF_PARENTS_AND_CHILDREN&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Includes
     *     the logical OMRS asset that the guid belongs to along with its parents
     *     and children.  The graph traversal is restricted to a single WKC
     *     asset.&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;&lt;code&gt;ALL&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Includes
     *     all logical OMRS assets that can be reached from the specified
     *     guid.&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;
     * @param assetFilter Filter for assets to show.  Allowed values: NONE,
     *     UNSYNCED_ONLY, FAILED_ONLY
     * @return EntityInfoResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<EntityInfoResponse> getOmrsEntityInfo(String catalogId,
                                                      String guid,
                                                      Boolean showAssets,
                                                      Boolean showDeletedAssets,
                                                      Boolean showGraph,
                                                      String lookup,
                                                      String assetFilter) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOmrsEntityInfo");
        }
        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling getOmrsEntityInfo");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "show_assets", showAssets));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "show_deleted_assets", showDeletedAssets));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "show_graph", showGraph));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "lookup", lookup));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "asset_filter", assetFilter));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<EntityInfoResponse> localVarReturnType = new ParameterizedTypeReference<EntityInfoResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/entity_info", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * OMRS instance health check
     * Use this to perform a health check on the OMRS instance for a catalog
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @return OMRSHealthCheckResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMRSHealthCheckResponse> getOmrsHealthCheck(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOmrsHealthCheck");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OMRSHealthCheckResponse> localVarReturnType = new ParameterizedTypeReference<OMRSHealthCheckResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/healthcheck", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Get OMRS sync status
     * Generates a report showing the current status of OMRS sync processing for a
     * catalog <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param startTimestamp timestamp value to start searching for OMRS activity
     * @param since Time before current time to set start_timestamp (eg 15m, 1h,
     *     3d); ignored if start_timestamp &gt; 0.
     * @return OmrsProcessingStatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OmrsProcessingStatusResponse> getOmrsProcessingStatus(String catalogId,
                                                                      Long startTimestamp,
                                                                      String since) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling getOmrsProcessingStatus");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_timestamp", startTimestamp));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "since", since));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<OmrsProcessingStatusResponse> localVarReturnType = new ParameterizedTypeReference<OmrsProcessingStatusResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/sync_status", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * List all catalogs for a specific account
     * Use this API to get a list of catalogs or projects or spaces, or to get the
     * total number of public catalogs, for a given account.&lt;br/&gt;  *
     * Standard Callers: to list all catalogs where caller is collaborator, omit
     * \&quot;bss_account_id\&quot; field and \&quot;include\&quot;
     * field.&lt;br/&gt;  * Accredited Services: to list all catalogs or projects
     * or spaces for a specific account, enter bss account value in
     * \&quot;bss_account_id\&quot; field and one of &#39;catalogs&#39;,
     * &#39;projects&#39;, or &#39;spaces&#39; in \&quot;include\&quot;
     * field.&lt;br/&gt;  * Accredited Services: to get the number of public
     * catalogs for a specific account, enter bss account value in
     * \&quot;bss_account_id\&quot; field and &#39;total_count&#39; in
     * \&quot;include\&quot; field. <p><b>200</b> - OK <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param limit limit
     * @param bookmark bookmark
     * @param skip skip
     * @param include Limited to use by accredited services (which must also
     *     supply &#39;bss_account_id&#39;). Currently, the only supported values
     *     are &#39;catalogs&#39;, &#39;projects&#39;, &#39;spaces&#39; or
     *     &#39;total_count&#39;. Not supplying any of these values results in
     *     public &#39;catalogs&#39;, &#39;projects&#39;, AND &#39;spaces&#39;
     *     being returned for a specific account.&lt;br/&gt;  * Use
     *     &#39;catalogs&#39; for including all public catalogs for a specific
     *     bss_account_id.&lt;br/&gt;  * Use &#39;projects&#39; for including all
     *     projects for a specific bss_account_id.&lt;br/&gt;  * Use
     *     &#39;spaces&#39; for including all spaces for a specific
     *     bss_account_id.&lt;br/&gt;  * Use &#39;total_count&#39; for including
     *     total number of public catalogs for a specific account.
     * @param bssAccountId Limited to use by accredited services. Must be supplied
     *     when caller is an accredited service. Used for listing catalogs,
     *     projects, or spaces for the account or for retrieving the number of
     *     public catalogs for the account.
     * @return Catalogs
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalogs> list(Integer limit,
                               String bookmark,
                               Integer skip,
                               String include,
                               String bssAccountId) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bookmark", bookmark));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include", include));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bss_account_id", bssAccountId));

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Catalogs> localVarReturnType = new ParameterizedTypeReference<Catalogs>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Update catalog properties
     * Use this API to patch catalog properties.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param body JSON array of patch operations as defined in RFC
     *     6902.&lt;br/&gt;[ { \&quot;op\&quot;: \&quot;add\&quot;,
     *     \&quot;path\&quot;: \&quot;/properties/new-property\&quot;,
     *     \&quot;value\&quot;: \&quot;new-value\&quot; } ]
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> updateProperties(String catalogId, Object body) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling patchCatalogPropertiesV2");
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling patchCatalogPropertiesV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{catalog_id}/properties",
                HttpMethod.PATCH, pathParams, queryParams,
                body, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update catalog connections
     * Use this API to patch catalog properties.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> reconfigure(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling patchCatalogReconfigureV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{catalog_id}/reconfigure",
                HttpMethod.PATCH, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update catalog
     * Use this API to update  the name or description of the catalog.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID
     * @param body JSON array of patch operations as defined in RFC
     *     6902.&lt;br/&gt;[ { \&quot;op\&quot;: \&quot;replace\&quot;,
     *     \&quot;path\&quot;: \&quot;/entity/name\&quot;, \&quot;value\&quot;:
     *     \&quot;new-name\&quot; },&lt;br/&gt;{ \&quot;op\&quot;:
     *     \&quot;replace\&quot;, \&quot;path\&quot;:
     *     \&quot;/entity/description\&quot;, \&quot;value\&quot;:
     *     \&quot;new-description\&quot; } ]
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> update(String catalogId, List<JSONResourcePatchModel> body) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling patchCatalogV2");
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'body' when calling patchCatalogV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json", "application/json-patch+json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Catalog> localVarReturnType = new ParameterizedTypeReference<Catalog>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}", HttpMethod.PATCH, pathParams, queryParams,
                body, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Reprocesses messsages from OMRS
     * Reprocesses messages from OMRS whose processing failed or is incomplete.
     * The set of messages checked is determined by performing a graph traversal
     * starting at the specified guid. <p><b>202</b> - Accepted <p><b>400</b> -
     * Bad Request <p><b>401</b> - Unauthorized <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @param guid OMRS entity guid to reprocess
     * @param force Forces reprocessing of messages for assets previously
     *     processed successfully
     * @param lookup Lookup options for doing the graph traversal.  Allowed
     *     values: SELF_AND_PARENTS, SELF_PARENTS_AND_CHILDREN, ALL
     * @return ReprocessMessagesResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<ReprocessMessagesResponse> reprocessMessage(String catalogId,
                                                            String guid,
                                                            Boolean force,
                                                            String lookup) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling reprocessMessage");
        }
        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling reprocessMessage");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "force", force));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "lookup", lookup));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<ReprocessMessagesResponse> localVarReturnType = new ParameterizedTypeReference<ReprocessMessagesResponse>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/reprocess_messages",
                HttpMethod.POST, pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept, localVarContentType,
                localVarReturnType);
    }

    /**
     * Get a catalog by catalog ID
     * Members of the catalog can use this API to retrieve information about a
     * catalog. <p><b>200</b> - OK <p><b>400</b> - Bad Request <p><b>401</b> -
     * Unauthorized <p><b>403</b> - Forbidden
     * @param catalogId Catalog GUID
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> get(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling retrieveCatalogV2");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Catalog> localVarReturnType = new ParameterizedTypeReference<Catalog>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}", HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Deactivate OMRS services
     * Use this to temporarily deactivate OMRS services for a catalog.  The
     * services can be reactivated using POST
     * /v2/{catalog_id}/open-metadata/instance <p><b>204</b> - No Content
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>500</b> - Internal Server Error
     * @param catalogId catalog GUID of the participating catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> stopOMRSServer(String catalogId) throws RestClientException {

        // verify the required parameter 'catalogId' is set
        if (catalogId == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'catalogId' when calling stopOMRSServer");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("catalog_id", catalogId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/open-metadata/instance", HttpMethod.DELETE,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

}
