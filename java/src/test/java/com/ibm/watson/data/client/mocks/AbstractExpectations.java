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
package com.ibm.watson.data.client.mocks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.data.client.ApiClient;
import org.mockserver.client.MockServerClient;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.withRequest;
import static com.ibm.watson.data.client.mocks.MockConstants.withResponse;

/**
 * Define a set of generic methods to simplify defining expectations.
 */
public abstract class AbstractExpectations {

    private static final ObjectMapper mapper = new ObjectMapper();
    private String baseUrl;
    private final String area;

    /**
     * Setup a set of expectations
     * @param baseUrl the base URL of the endpoint
     * @param area the resources directory where the test case files reside
     */
    public AbstractExpectations(String baseUrl, String area) {
        this.baseUrl = baseUrl;
        this.area = area;
    }

    /**
     * This method must be overridden to actually setup the expectations.
     * @param client the mock server client on which to setup the expectations
     */
    public abstract void init(MockServerClient client);

    /**
     * Retrieve the base URL of the expectations.
     * @return baseUrl
     */
    public String getBaseUrl() { return baseUrl; }

    /**
     * Retrieve the area of the expectations
     * @return area
     */
    public String getArea() { return area; }

    /**
     * Inject the provided parameter name into the base URL by replacing it with the replacement string.
     * @param name of the parameter
     * @param replacement for the parameter
     */
    protected void injectIntoBaseUrl(String name, String replacement) {
        this.baseUrl = baseUrl.replace(name, replacement);
    }

    protected void setupTest(MockServerClient mockServerClient, String method, String endpoint, String test) {
        setupTest(mockServerClient, method, endpoint, test, 200);
    }

    protected void setupTest(MockServerClient mockServerClient, String method, String endpoint, String test, int code) {
        mockServerClient
                .when(withRequest(method, getEncodedURI(baseUrl + endpoint), area, test))
                .respond(withResponse(area, test).withStatusCode(code));
    }

    protected void setupTest(MockServerClient mockServerClient,
                             String method,
                             String endpoint,
                             Map<String, List<String>> params,
                             String test) {
        setupTest(mockServerClient, method, endpoint, params, test, 200);
    }

    protected void setupTest(MockServerClient mockServerClient,
                             String method,
                             String endpoint,
                             Map<String, List<String>> params,
                             String test,
                             int code) {
        mockServerClient
                .when(withRequest(method, getEncodedURI(baseUrl + endpoint), area, test).withQueryStringParameters(params))
                .respond(withResponse(area, test).withStatusCode(code));
    }

    protected <T> T readRequestFromFile(String test, TypeReference<T> type) {

        String location = area + File.separator + test + File.separator + "request.json";
        String contents = MockConstants.getResourceFileContents(location);
        if (contents != null) {
            try {
                return mapper.readValue(contents, type);
            } catch (JsonProcessingException e) {
                System.err.println("Unable to process the JSON from the 'request.json' file!");
                e.printStackTrace();
            }
        }
        return null;

    }

    protected String getEncodedURI(String endpoint) {
        String encoded = null;
        try {
            URI roleEndpoint = new URI(null, null, endpoint, null);
            encoded = roleEndpoint.toString();
        } catch (URISyntaxException e) {
            System.err.println("Unable to encode the URI of the endpoint!");
            e.printStackTrace();
        }
        return encoded;
    }

}
