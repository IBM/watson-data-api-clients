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

import com.ibm.watson.data.client.ApiClient;
import org.mockserver.matchers.MatchType;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.JsonBody;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;

/**
 * A set of constants that can be re-used across various modules' tests.
 */
public class MockConstants {

    // Set some constants that we can re-use throughout
    public static final String PROJECT_GUID  = "f0bd7b72-f690-4b65-9edb-7a430fa658d9";
    public static final String CATALOG_GUID  = "0f85f071-7528-4ff9-9db8-ab7c7b0244bf";
    public static final String NEW_ROLE_NAME = "Test Role";
    public static final String EXSTUSER_GUID = "1000331004";
    public static final String EXSTUSER_NAME = "cgrote";
    public static final String NEW_USER_GUID = "1000331015";
    public static final String NEW_USER_NAME = "jsmith";

    public static ApiClient getApiClient() {
        ApiClient apiClient = new ApiClient(false);
        apiClient.setBasePath("http://localhost:1080");
        return apiClient;
    }

    /**
     * Create a mock CP4D request without any body.
     * @param method of the HTTP request
     * @param path of the API endpoint
     * @return HttpRequest
     */
    public static HttpRequest withRequest(String method, String path) {
        return request()
                .withMethod(method)
                .withPath(path);
    }

    /**
     * Create a mock CP4D request using the provided details.
     * @param method of the HTTP request
     * @param path of the API endpoint
     * @param body of the request (JSON-match style)
     * @return HttpRequest
     */
    public static HttpRequest withRequest(String method, String path, JsonBody body) {
        return request()
                .withMethod(method)
                .withPath(path)
                .withBody(body);
    }

    /**
     * Create a mock CP4D request using the provided details.
     * @param method of the HTTP request
     * @param path of the API endpoint
     * @param area name of the testing area
     * @param test name of the test case
     * @return HttpRequest
     */
    public static HttpRequest withRequest(String method, String path, String area, String test) {
        String contents = getResourceFileContents(area + File.separator + test + File.separator + "request.json");
        if (contents == null) {
            return withRequest(method, path);
        } else {
            return withRequest(method, path, json(contents, MatchType.ONLY_MATCHING_FIELDS));
        }
    }

    /**
     * Create a mock CP4D response using the provided body.
     * @param body to respond with
     * @return HttpResponse
     */
    public static HttpResponse withResponse(String body) {
        return response()
                .withBody(body)
                .withHeader("Content-Type", "application/json");
    }

    /**
     * Create a mock CP4D response using the provided filename's contents as the body.
     * @param area the name of the testing area
     * @param test the name of the test case
     * @return HttpResponse
     */
    public static HttpResponse withResponse(String area, String test) {
        String contents = getResourceFileContents(area + File.separator + test + File.separator + "response.json");
        if (contents != null) {
            return withResponse(contents);
        } else {
            return response();
        }
    }

    /**
     * Retrieve the contents of a test resource file.
     * @return String
     */
    public static String getResourceFileContents(String filename) {

        ClassPathResource resource = new ClassPathResource(filename);
        if (resource.exists()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.err.println("Unable to read resource file: " + filename);
                e.printStackTrace();
            }
            if (reader != null) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
        return null;

    }

}
