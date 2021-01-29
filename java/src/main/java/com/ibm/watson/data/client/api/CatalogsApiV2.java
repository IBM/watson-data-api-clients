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
     * Activate the OMRS services for a catalog, using the stored
     * configuration information.
     * @param catalogId catalog GUID of the participating catalog
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> activateOMRSServer(@NonNull String catalogId) throws RestClientException {

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
     * Use this to create the default catalog, configure and start the OMAG
     * server.
     * <br><br>
     * Example request:
     * <code>{ "catalog": { "name": "The Default Catalog", "generator": "Catalog-OMRS-Synced", "description": "The default (aka sync) catalog", "bss_account_id": "999", "is_governed": "true", "bucket": { "bucket_type": "assetfiles"  } }, "event_bus": { "producer": { "bootstrap.servers": "kafka:9093", "acks": "all", "retries": "1", "batch.size": "16384", "linger.ms": "1", "buffer.memory": "33554432", "max.request.size": "10485760", "key.serializer": "org.apache.kafka.common.serialization.StringSerializer", "value.serializer": "org.apache.kafka.common.serialization.StringSerializer" }, "consumer": { "bootstrap.servers": "kafka:9093", "zookeeper.session.timeout.ms": "300000", "zookeeper.sync.time.ms": "2000", "fetch.message.max.bytes": "10485760", "max.partition.fetch.bytes": "10485760", "max.poll.interval.ms": "2000000000", "key.deserializer": "org.apache.kafka.common.serialization.StringDeserializer", "value.deserializer": "org.apache.kafka.common.serialization.StringDeserializer" } } }</code>
     * @param createDefaultCatalogRequest details for the default catalog configuration
     * @param checkBucketExistence Whether an existence check should be performed
     *     on the catalog bucket
     * @param topicUrlRoot common root of the topics used by the open metadata
     *     server
     * @return Response
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Response> createCatalogOnOmrsOneCatalogCohort(@NonNull CreateDefaultCatalogRequest createDefaultCatalogRequest,
                                                              Boolean checkBucketExistence,
                                                              String topicUrlRoot) throws RestClientException {

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
     * Create a catalog to organize your assets and collaborators.
     * You can use a catalog to easily to find and share data for your
     * organization, regardless of the location or format of the data.  You must
     * have the Admin role for Data Catalog. When you create a catalog, you
     * must supply credentials for IBM Cloud Object Storage (S3 API), which
     * provides encrypted storage for the assets that you copy to the catalog.
     * @param catalogEntity <code>{ "name":"Test Catalog", "generator":"test@us.ibm.com", "description":"a new catalog" }</code>
     * @param checkBucketExistence Whether an existence check should be performed
     *     on the catalog bucket
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> create(@NonNull CatalogEntity catalogEntity,
                                Boolean checkBucketExistence) throws RestClientException {

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
     * Configure a catalog to participate in an OMRS cohort.  An OMRS
     * configuration document is created or updated with the specified cohort
     * information.
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
    public Mono<OMAGServerConfig> createOMRSServerConfig(@NonNull String catalogId,
                                                         @NonNull String cohortName,
                                                         String topicUrlRoot,
                                                         Map<String, Object> requestBody) throws RestClientException {

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
     * Permanently deactivate OMRS services for a catalog, and
     * unregister the catalog from all OMRS cohorts. The OMRS config document and
     * corresponding registrystore documents for the catalog are deleted.
     * @param catalogId catalog GUID of the participating catalog
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deactivateOMRSServer(@NonNull String catalogId) throws RestClientException {

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
     * Delete a catalog if you have the Admin role. Deleting a
     * catalog removes all items that are associated with the catalog, such as
     * metadata for all assets in the catalog.
     * @param catalogId Catalog GUID
     * @param deleteBucket delete_bucket
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String catalogId,
                             Boolean deleteBucket) throws RestClientException {

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
     * Unregister a catalog from an OMRS cohort. Once unregistered, the catalog
     * can no longer send or receive messages from the cohort.
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> disableAccessToCohort(@NonNull String catalogId,
                                            @NonNull String cohortName) throws RestClientException {

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
     * Gets a list of OMRS asset that have not yet been propagated into WKC.
     * Either connections or data assets can be found.
     * @param catalogId catalog GUID of the participating catalog
     * @param type The type of the asset to find.  Must be either <code>data_asset</code> or
     *     <code>connection</code>.  Defaults to <code>data_asset</code>.
     * @param limit Limit to use when finding pending assets.  Defaults to 25
     * @param bookmark Optional bookmark to use when finding pending assets.
     * @return OmrsProcessingStatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OmrsProcessingStatusResponse> findPendingAssets(@NonNull String catalogId,
                                                                String type,
                                                                Integer limit,
                                                                String bookmark) throws RestClientException {

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
     * List all properties of a catalog.
     * @param catalogId catalog GUID
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> getAllProperties(@NonNull String catalogId) throws RestClientException {

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
     * Retrieve the default catalog for OMRS sync processing.
     * This catalog is configured on the <code>one_catalog</code> OMRS cohort.
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
     * Get a single property in a catalog by the given property key.
     * @param catalogId catalog GUID
     * @param propertyKey catalog property key
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> getProperty(@NonNull String catalogId,
                                  @NonNull String propertyKey) throws RestClientException {

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

        // TODO: this should not be a Void response, but need some examples to see how to model it

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{catalog_id}/properties/{property_key}", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Retrieve the OMRS audit logs for a catalog.
     * @param catalogId catalog GUID of the participating catalog
     * @param startTimestamp timestamp value to start searching for new messages
     * @param messageIdPrefix Prefix value to filter message_id -- for example,
     *     <code>OCF-KAFKA</code> or <code>OMRS-AUDIT</code>.
     * @param severity Comma delimited values of severity --
     *     OMRSAuditLogRecordSeverity (Error, Exception, Action, Information,
     *     Decision, etc.)
     * @param since Number of minutes before current time to set start_timestamp;
     *     ignored if start_timestamp &gt; 0.
     * @return OMRSAuditLogMapResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMRSAuditLogMapResponse> getOMRSAuditLogs(@NonNull String catalogId,
                                                          Long startTimestamp,
                                                          String messageIdPrefix,
                                                          String severity,
                                                          Integer since)
            throws RestClientException {

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
     * Retrieve the OMRS Kafka certificate document for a catalog and cohort.
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @return OMAGCertificateResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMAGCertificateResponse> getOMRSCertificateDocument(@NonNull String catalogId,
                                                                    @NonNull String cohortName) throws RestClientException {

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
     * Retrieve the OMRS configuration document for a catalog.
     * The configuration document will contain details about all OMRS cohorts in which
     * the catalog participates.
     * @param catalogId catalog GUID of the participating catalog
     * @return OMAGServerConfig
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMAGServerConfig> getOMRSConfigDocument(@NonNull String catalogId) throws RestClientException {

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
     * Retrieve the OMRS registry store document for a specified catalog and cohort.
     * @param catalogId catalog GUID of the participating catalog
     * @param cohortName name of the cohort
     * @return CohortMembership
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<CohortMembership> getOMRSRegistryStore(@NonNull String catalogId,
                                                       @NonNull String cohortName) throws RestClientException {

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
     * Generates a report showing the known information about the sync status of
     * an OMRS entity.
     * @param catalogId catalog GUID of the participating catalog
     * @param guid OMRS entity guid to lookup
     * @param showAssets Whether to include the asset list in the output
     * @param showDeletedAssets Whether to include deleted assets in the output
     * @param showGraph Whether to include the reachability graph in the output
     * @param lookup Lookup options for getting the entity info.  Allowed values:
     *     <ul>
     *               <li>SELF_AND_PARENTS: Includes the logical OMRS asset that the guid belongs to and its parents. The graph traversal is restricted to a single WKC asset.</li>
     *               <li>SELF_PARENTS_AND_CHILDREN: Includes the logical OMRS asset that the guid belongs to along with its parents and children. The graph traversal is restricted to a single WKC asset.</li>
     *               <li>ALL: Includes all logical OMRS assets that can be reached from the specified guid.</li>
     *     </ul>
     * @param assetFilter Filter for assets to show.  Allowed values: NONE,
     *     UNSYNCED_ONLY, FAILED_ONLY
     * @return EntityInfoResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<EntityInfoResponse> getOmrsEntityInfo(@NonNull String catalogId,
                                                      @NonNull String guid,
                                                      Boolean showAssets,
                                                      Boolean showDeletedAssets,
                                                      Boolean showGraph,
                                                      String lookup,
                                                      String assetFilter) throws RestClientException {

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
     * Perform a health check on the OMRS instance for a catalog.
     * @param catalogId catalog GUID of the participating catalog
     * @return OMRSHealthCheckResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OMRSHealthCheckResponse> getOmrsHealthCheck(@NonNull String catalogId) throws RestClientException {

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
     * Generates a report showing the current status of OMRS sync processing for a
     * catalog.
     * @param catalogId catalog GUID of the participating catalog
     * @param startTimestamp timestamp value to start searching for OMRS activity
     * @param since Time before current time to set start_timestamp (eg 15m, 1h,
     *     3d); ignored if start_timestamp &gt; 0.
     * @return OmrsProcessingStatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<OmrsProcessingStatusResponse> getOmrsProcessingStatus(@NonNull String catalogId,
                                                                      Long startTimestamp,
                                                                      String since) throws RestClientException {

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
     * List all catalogs for a specific account.
     * <ul>
     *     <li>Standard Callers: to list all catalogs where caller is collaborator, omit "bss_account_id" field and "include" field.</li>
     *     <li>Accredited Services: to list all catalogs or projects or spaces for a specific account, enter bss account value in "bss_account_id" field and one of <code>catalogs</code>, <code>projects</code>, or <code>spaces</code> in "include" field.</li>
     *     <li>Accredited Services: to get the number of public catalogs for a specific account, enter bss account value in "bss_account_id" field and <code>total_count</code> in "include" field.</li>
     * </ul>
     * @param limit limit
     * @param bookmark bookmark
     * @param skip skip
     * @param include Limited to use by accredited services (which must also
     *     supply <code>bss_account_id</code>). Currently, the only supported values
     *     are <code>catalogs</code>, <code>projects</code>, <code>spaces</code> or
     *     <code>total_count</code>. Not supplying any of these values results in
     *     public <code>catalogs</code>, <code>projects</code>, AND <code>spaces</code>
     *     being returned for a specific account. Use
     *     <code>catalogs</code> for including all public catalogs for a specific
     *     bss_account_id. Use <code>projects</code> for including all
     *     projects for a specific bss_account_id. Use
     *     <code>spaces</code> for including all spaces for a specific
     *     bss_account_id. Use <code>total_count</code> for including
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
     * Update catalog properties.
     * Example body:
     * <code>[ { "op": "add", "path": "/properties/new-property", "value": "new-value" } ]</code>
     * @param catalogId catalog GUID
     * @param body JSON array of patch operations as defined in RFC
     *     6902.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> updateProperties(@NonNull String catalogId,
                                       @NonNull List<JSONResourcePatchModel> body) throws RestClientException {

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
     * Update catalog connection properties.
     * @param catalogId catalog GUID
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> reconfigure(@NonNull String catalogId) throws RestClientException {

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
     * Update the name or description of the catalog.
     * Example body:
     * <code>[ { "op": "replace", "path": "/entity/name", "value": "new-name" } ]</code>
     * @param catalogId catalog GUID
     * @param body JSON array of patch operations as defined in RFC
     *     6902.
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> update(@NonNull String catalogId,
                                @NonNull List<JSONResourcePatchModel> body) throws RestClientException {

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
     * Reprocesses messsages from OMRS whose processing failed or is incomplete.
     * The set of messages checked is determined by performing a graph traversal
     * starting at the specified guid.
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
    public Mono<ReprocessMessagesResponse> reprocessMessage(@NonNull String catalogId,
                                                            @NonNull String guid,
                                                            Boolean force,
                                                            String lookup) throws RestClientException {

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
     * Get a catalog by catalog ID.
     * Members of the catalog can use this API to retrieve information about a
     * catalog.
     * @param catalogId Catalog GUID
     * @return Catalog
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Catalog> get(@NonNull String catalogId) throws RestClientException {

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
     * Temporarily deactivate OMRS services for a catalog.
     * The services can be reactivated using POST to
     * <code>/v2/{catalog_id}/open-metadata/instance</code>
     * @param catalogId catalog GUID of the participating catalog
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> stopOMRSServer(@NonNull String catalogId) throws RestClientException {

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
