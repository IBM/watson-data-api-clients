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

import com.ibm.watson.data.client.api.AuthorizationApi;
import com.ibm.watson.data.client.api.CatalogsApiV2;
import com.ibm.watson.data.client.api.ProjectsApiV2;
import com.ibm.watson.data.client.api.TransactionalProjectsApiV2;
import com.ibm.watson.data.client.tests.CatalogTest;
import com.ibm.watson.data.client.tests.ProjectTest;
import org.mockserver.client.MockServerClient;
import org.mockserver.client.initialize.PluginExpectationInitializer;

import static com.ibm.watson.data.client.mocks.MockConstants.*;

/**
 * Setup a mock server to act as a Cloud Pak for Data endpoint against which we can do some thorough testing.
 */
public class MockServerExpectations implements PluginExpectationInitializer {

    /**
     * Setup the expectations we will need to respond to various tests.
     * @param mockServerClient the client against which to set the expectations
     */
    @Override
    public void initializeExpectations(MockServerClient mockServerClient) {

        setAuthorizations(mockServerClient);
        setCatalogs(mockServerClient);
        setProjects(mockServerClient);

    }

    private void setAuthorizations(MockServerClient mockServerClient) {

        String baseUrl = "/icp4d-api/v1/authorize";
        String area = "authorization";

        setupTest(mockServerClient, "POST", baseUrl, area, "getTokenCP4D");

    }

    private void setCatalogs(MockServerClient mockServerClient) {

        String baseUrl = CatalogsApiV2.BASE_API;
        String area = "catalog";

        setupTest(mockServerClient, "POST", baseUrl, area, "create", 201);
        setupTest(mockServerClient, "DELETE", baseUrl + "/" + CatalogTest.CREATED_GUID, area, "delete", 204);
        setupTest(mockServerClient, "GET", baseUrl + "/" + CatalogTest.CREATED_GUID, area, "get");
        setupTest(mockServerClient, "GET", baseUrl + "/default", area, "getDefault");
        setupTest(mockServerClient, "GET", baseUrl, area, "list");
        setupTest(mockServerClient, "PATCH", baseUrl + "/" + CatalogTest.CREATED_GUID, area, "update", 500);

    }

    private void setProjects(MockServerClient mockServerClient) {

        String baseUrl = ProjectsApiV2.BASE_API;
        String baseUrlTxn = TransactionalProjectsApiV2.BASE_API;
        String area = "project";

        setupTest(mockServerClient, "POST", baseUrlTxn, area, "create", 201);
        setupTest(mockServerClient, "DELETE", baseUrlTxn + "/" + ProjectTest.CREATED_GUID, area, "delete", 204);
        setupTest(mockServerClient, "GET", baseUrl + "/" + ProjectTest.CREATED_GUID, area, "get");
        setupTest(mockServerClient, "GET", baseUrl, area, "list");
        setupTest(mockServerClient, "PATCH", baseUrl + "/" + ProjectTest.CREATED_GUID, area, "update");

    }

    private void setupTest(MockServerClient mockServerClient, String method, String endpoint, String area, String test) {
        setupTest(mockServerClient, method, endpoint, area, test, 200);
    }

    private void setupTest(MockServerClient mockServerClient, String method, String endpoint, String area, String test, int code) {
        mockServerClient
                .when(withRequest(method, endpoint, area, test))
                .respond(withResponse(area, test).withStatusCode(code));
    }

}