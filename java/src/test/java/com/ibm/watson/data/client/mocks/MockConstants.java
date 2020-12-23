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

import java.io.*;
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
    public static final String SPACE_GUID     = "ad4f6950-79e4-4fac-a656-cb07b53c4c71";
    public static final String PROJECT_GUID   = "f0bd7b72-f690-4b65-9edb-7a430fa658d9";
    public static final String CATALOG_GUID   = "0f85f071-7528-4ff9-9db8-ab7c7b0244bf";
    public static final String NEW_ROLE_NAME  = "Test Role";
    public static final String EXSTUSER_GUID  = "1000331004";
    public static final String EXSTUSER_NAME  = "cgrote";
    public static final String NEW_USER_GUID  = "1000331015";
    public static final String NEW_USER_NAME  = "jsmith";
    public static final String NEW_TYPE_NAME  = "test_type";
    public static final String NEW_PROP_NAME  = "test_field";
    public static final String NEW_ASSET_NAME = "Test Asset";
    public static final String NEW_ASSET_GUID = "fdbf3f03-545b-497b-a2ea-3353aaed7dd1";
    public static final String ASSET_RATING_G = MockConstants.NEW_ASSET_GUID + "_" + MockConstants.EXSTUSER_GUID;
    public static final String CLONED_ASTGUID = "6482aa36-d979-48d0-a036-d7da6fbc4eff";
    public static final String DATAASSET_GUID = "ec9f4f72-5af0-476e-a69c-3124a06fb6eb";
    public static final String CONNECTION_GUID = "99845973-050b-482b-b900-a13a75865258";
    public static final String NEW_JOB_GUID   = "3bb8f0ac-5eea-4c4a-b94b-a53a6fffdec9";
    public static final String JOB_RUN_GUID   = "d1198807-fd02-4725-b571-7059c604cba4";
    public static final String NEW_TERM_GUID  = "57904012-45da-4995-9dfb-84daa372ce7a";
    public static final String WORKFLOW_GUID  = "937c841f-e083-11ea-8c06-0a580a810041";
    public static final String REPOSITORY_ID  = "5d2d5419-0032-4c64-90e2-ce68c6997bb5";
    public static final String UNCATEGORY_ID  = "e39ada11-8338-3704-90e3-681a71e7c839";
    public static final String CUSTOM_ATTR_ID = "15c217fd-d8bf-4f88-a80c-92645d3613f4";
    public static final String NEW_CATEGORY_ID = "a06c6237-32a4-468b-bdfe-9a09ab9bf06b";
    public static final String NEW_DATACLASS_ID = "f1c8cd84-ce0d-435f-8613-970f6970c452";
    public static final String NEW_DP_RULE_ID = "faee7d99-74b0-4c08-ab8e-ccc50bb9440a";
    public static final String NEW_POLICY_GUID = "c13f20b3-13c5-4898-bf3e-8bd3e769e0e9";
    public static final String NEW_RULE_GUID  = "aafe5366-1d32-49c7-aa3c-4d8a899425b7";
    public static final String NEW_CLASSIFICATION_ID = "cbb8b86f-d91c-49a1-a541-aad046edf978";
    public static final String NEW_REF_DATA_GUID = "6c2e568e-5bbe-40cf-a12e-b99691f8a78b";
    public static final String MODEL_GUID     = "a40e2d17-6f33-4434-9944-4d6fa19ec397";
    public static final String DEPLOYMENT_GUID = "63e1b529-dbbc-4e8f-849a-ce57ef9b534e";

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
     * @param filename of the resource file
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

    /**
     * Retrieve a test resource file.
     * @param filename of the resource file
     * @return File
     */
    public static File getFileFromResources(String filename) {
        ClassPathResource resource = new ClassPathResource(filename);
        if (resource.exists()) {
            try {
                return resource.getFile();
            } catch (IOException e) {
                System.err.println("Unable to convert resource file into a File object: " + filename);
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Retrieve a test resource as an input stream.
     * @param filename of the resource
     * @return InputStream
     */
    public static InputStream getInputStreamFromResources(String filename) {
        ClassPathResource resource = new ClassPathResource(filename);
        if (resource.exists()) {
            try {
                return resource.getInputStream();
            } catch (IOException e) {
                System.err.println("Unable to convert resource file into an InputStream object: " + filename);
                e.printStackTrace();
            }
        }
        return null;
    }

}
