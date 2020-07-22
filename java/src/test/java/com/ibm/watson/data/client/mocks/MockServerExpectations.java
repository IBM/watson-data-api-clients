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

import com.ibm.watson.data.client.api.*;
import org.mockserver.client.MockServerClient;
import org.mockserver.client.initialize.PluginExpectationInitializer;

import java.net.*;

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
        setAccountManagement(mockServerClient);
        setCatalogs(mockServerClient);
        setCatalogMembers(mockServerClient);
        setMonitors(mockServerClient);
        setProjects(mockServerClient);
        setProjectsMembers(mockServerClient);
        setProjectsSettings(mockServerClient);
        setRoleManagement(mockServerClient);
        setUserManagement(mockServerClient);

    }

    private void setAuthorizations(MockServerClient mockServerClient) {

        String baseUrl = "/icp4d-api/v1/authorize";
        String area = "authorization";

        setupTest(mockServerClient, "POST", baseUrl, area, "getTokenCP4D");

    }

    private void setAccountManagement(MockServerClient mockServerClient) {

        String baseUrl = AccountManagementApi.API_BASE;
        String area = "accountManagement";

        setupTest(mockServerClient, "POST", baseUrl + "/changepassword", area, "password");
        setupTest(mockServerClient, "GET", baseUrl + "/me", area, "get");
        // TODO: endpoint currently broken (results in 500)
        setupTest(mockServerClient, "PUT", baseUrl + "/me", area, "update", 500);

    }

    private void setCatalogs(MockServerClient mockServerClient) {

        String baseUrl = CatalogsApiV2.BASE_API;
        String area = "catalog";

        setupTest(mockServerClient, "POST", baseUrl, area, "create", 201);
        setupTest(mockServerClient, "DELETE", baseUrl + "/" + CATALOG_GUID, area, "delete", 204);
        setupTest(mockServerClient, "GET", baseUrl + "/" + CATALOG_GUID, area, "get");
        setupTest(mockServerClient, "GET", baseUrl + "/default", area, "getDefault");
        setupTest(mockServerClient, "GET", baseUrl, area, "list");
        // TODO: endpoint currently broken (results in 500)
        setupTest(mockServerClient, "PATCH", baseUrl + "/" + CATALOG_GUID, area, "update", 500);

    }

    private void setCatalogMembers(MockServerClient mockServerClient) {

        String baseUrl = CatalogMembersApiV2.BASE_API;
        String area = "catalogMembers";

        String endpoint = baseUrl.replace("{catalog_id}", CATALOG_GUID);

        setupTest(mockServerClient, "POST", endpoint, area, "add", 201);
        setupTest(mockServerClient, "DELETE", endpoint + "/" + NEW_USER_GUID, area, "delete", 204);
        setupTest(mockServerClient, "GET", endpoint + "/" + NEW_USER_GUID, area, "get");
        setupTest(mockServerClient, "GET", endpoint, area, "list");
        setupTest(mockServerClient, "PATCH", endpoint + "/" + NEW_USER_GUID, area, "updateRole");

    }

    private void setMonitors(MockServerClient mockServerClient) {

        String baseUrl = "/icp4d-api/v1/monitor";
        String area = "monitor";

        // TODO: endpoint currently broken (results in 404)
        setupTest(mockServerClient, "GET", baseUrl, area, "get", 404);

    }

    private void setProjects(MockServerClient mockServerClient) {

        String baseUrl = ProjectsApiV2.BASE_API;
        String baseUrlTxn = TransactionalProjectsApiV2.BASE_API;
        String area = "project";

        setupTest(mockServerClient, "POST", baseUrlTxn, area, "create", 201);
        setupTest(mockServerClient, "DELETE", baseUrlTxn + "/" + PROJECT_GUID, area, "delete", 204);
        setupTest(mockServerClient, "GET", baseUrl + "/" + PROJECT_GUID, area, "get");
        setupTest(mockServerClient, "GET", baseUrl, area, "list");
        setupTest(mockServerClient, "PATCH", baseUrl + "/" + PROJECT_GUID, area, "update");

    }

    private void setProjectsMembers(MockServerClient mockServerClient) {

        String baseUrl = ProjectsMembersApiV2.BASE_API;
        String area = "projectMembers";

        String endpoint = baseUrl.replace("{guid}", PROJECT_GUID);

        setupTest(mockServerClient, "POST", endpoint, area, "add");
        setupTest(mockServerClient, "DELETE", endpoint + "/" + NEW_USER_NAME, area, "delete", 204);
        setupTest(mockServerClient, "GET", endpoint + "/" + EXSTUSER_NAME, area, "get");
        setupTest(mockServerClient, "GET", endpoint, area, "list");
        setupTest(mockServerClient, "PATCH", endpoint, area, "update");

    }

    private void setProjectsSettings(MockServerClient mockServerClient) {

        String baseUrl = ProjectsSettingsApiV2.BASE_API;
        String area = "projectSettings";

        String endpoint = baseUrl.replace("{guid}", PROJECT_GUID);

        setupTest(mockServerClient, "GET", endpoint + "/access_restrictions", area, "getAccessRestrictions");
        setupTest(mockServerClient, "GET", endpoint + "/audit_events", area, "getAuditEvents");
        setupTest(mockServerClient, "PUT", endpoint + "/access_restrictions", area, "updateAccessRestrictions");
        setupTest(mockServerClient, "PUT", endpoint + "/audit_events", area, "updateAuditEvents");

    }

    private void setRoleManagement(MockServerClient mockServerClient) {

        String baseUrl = RoleManagementApi.BASE_API;
        String area = "roleManagement";

        String encodedEndpoint = baseUrl + "/" + NEW_ROLE_NAME;
        try {
            URI roleEndpoint = new URI(null, null, encodedEndpoint, null);
            encodedEndpoint = roleEndpoint.toString();
        } catch (URISyntaxException e) {
            System.err.println("Unable to encode role name as part of endpoint!");
            e.printStackTrace();
        }

        setupTest(mockServerClient, "POST", baseUrl, area, "create");
        // TODO: endpoint currently broken (results in 500)
        setupTest(mockServerClient, "DELETE", encodedEndpoint, area, "delete", 500);
        setupTest(mockServerClient, "GET", encodedEndpoint, area, "get");
        setupTest(mockServerClient, "GET", baseUrl, area, "listRoles");
        // TODO: endpoint currently broken (results in 404)
        setupTest(mockServerClient, "GET", baseUrl + "/permissions", area, "listPermissions", 404);
        // TODO: endpoint currently broken (results in 500)
        setupTest(mockServerClient, "PUT", encodedEndpoint, area, "update", 500);

    }

    private void setUserManagement(MockServerClient mockServerClient) {

        String baseUrl = UserManagementApi.BASE_API;
        String area = "userManagement";

        String encodedEndpoint = baseUrl + "/" + NEW_USER_NAME;
        try {
            URI roleEndpoint = new URI(null, null, encodedEndpoint, null);
            encodedEndpoint = roleEndpoint.toString();
        } catch (URISyntaxException e) {
            System.err.println("Unable to encode user name as part of endpoint!");
            e.printStackTrace();
        }

        setupTest(mockServerClient, "POST", baseUrl, area, "create");
        setupTest(mockServerClient, "DELETE", encodedEndpoint, area, "delete");
        setupTest(mockServerClient, "GET", encodedEndpoint, area, "get");
        setupTest(mockServerClient, "GET", baseUrl, area, "list");
        // TODO: endpoint currently broken (results in 500)
        setupTest(mockServerClient, "PUT", encodedEndpoint, area, "update", 500);

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