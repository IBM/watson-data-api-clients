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
import com.ibm.watson.data.client.model.SettingsGroupAccessRestrictions;
import com.ibm.watson.data.client.model.SettingsGroupAuditEvents;
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
 * API endpoints dealing with Project settings.
 */
public class ProjectsSettingsApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/projects/{guid}/settings";

    @Autowired
    public ProjectsSettingsApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Get access restrictions settings
     * Get access restrictions settings.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param guid The project GUID.
     * @return SettingsGroupAccessRestrictions
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SettingsGroupAccessRestrictions> getAccessRestrictions(String guid) throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling getAccessRestrictionsSettings");
        }
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

        ParameterizedTypeReference<SettingsGroupAccessRestrictions>
                localVarReturnType = new ParameterizedTypeReference<SettingsGroupAccessRestrictions>() {};
        return apiClient.invokeAPI(
                BASE_API + "/access_restrictions", HttpMethod.GET,
                pathParams, queryParams, null, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Get audit events settings
     * Get audit events settings.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param guid The project GUID.
     * @return SettingsGroupAuditEvents
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SettingsGroupAuditEvents> getAuditEvents(String guid) throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling getAuditEventsSettings");
        }
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

        ParameterizedTypeReference<SettingsGroupAuditEvents> localVarReturnType =
                new ParameterizedTypeReference<SettingsGroupAuditEvents>() {};
        return apiClient.invokeAPI(BASE_API + "/audit_events",
                HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Update access restrictions settings
     * Update access restrictions settings.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param guid The project GUID.
     * @param settingsGroupAccessRestrictions The settingsGroupAccessRestrictions
     *     parameter
     * @return SettingsGroupAccessRestrictions
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SettingsGroupAccessRestrictions> updateAccessRestrictions(String guid,
                                                                          SettingsGroupAccessRestrictions settingsGroupAccessRestrictions)
            throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling updateAccessRestrictionsSettings");
        }
        // verify the required parameter 'settingsGroupAccessRestrictions' is set
        if (settingsGroupAccessRestrictions == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'settingsGroupAccessRestrictions' when calling updateAccessRestrictionsSettings");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<SettingsGroupAccessRestrictions>
                localVarReturnType = new ParameterizedTypeReference<SettingsGroupAccessRestrictions>() {};
        return apiClient.invokeAPI(
                BASE_API + "/access_restrictions", HttpMethod.PUT,
                pathParams, queryParams, settingsGroupAccessRestrictions, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Update audit events settings
     * Update audit events settings.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param guid The project GUID.
     * @param settingsGroupAuditEvents The settingsGroupAuditEvents parameter
     * @return SettingsGroupAuditEvents
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<SettingsGroupAuditEvents> updateAuditEvents(String guid,
                                                            SettingsGroupAuditEvents settingsGroupAuditEvents)
            throws RestClientException {

        // verify the required parameter 'guid' is set
        if (guid == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'guid' when calling updateAuditEventsSettings");
        }
        // verify the required parameter 'settingsGroupAuditEvents' is set
        if (settingsGroupAuditEvents == null) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'settingsGroupAuditEvents' when calling updateAuditEventsSettings");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("guid", guid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<SettingsGroupAuditEvents> localVarReturnType = new ParameterizedTypeReference<SettingsGroupAuditEvents>() {};
        return apiClient.invokeAPI(BASE_API + "/audit_events",
                HttpMethod.PUT, pathParams, queryParams,
                settingsGroupAuditEvents, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

}
