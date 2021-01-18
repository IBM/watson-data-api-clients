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
package com.ibm.watson.data.client.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ibm.watson.data.client.api.RoleManagementApi;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.Test;

import java.util.List;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Role Management API endpoints.
 */
public class RoleManagementTest extends AbstractExpectations {

    private final RoleManagementApi api = new RoleManagementApi(MockConstants.getApiClient());

    public RoleManagementTest() {
        super(RoleManagementApi.BASE_API, "roleManagement");
    }

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", "", "create");
        // TODO: endpoint currently broken (results in 500)
        setupTest(client, "DELETE", "/" + NEW_ROLE_NAME, "delete", 500);
        setupTest(client, "GET", "/" + NEW_ROLE_NAME, "get");
        setupTest(client, "GET", "", "listRoles");
        // TODO: endpoint currently broken (results in 404)
        setupTest(client, "GET", "/permissions", "listPermissions", 404);
        // TODO: endpoint currently broken (results in 500)
        setupTest(client, "PUT", "/" + NEW_ROLE_NAME, "update", 500);
    }

    private static final String createdDesc = "A test role to validate the API client works as expected.";
    private static final String updatedDesc = "Now with an updated description.";

    @Test
    public void testCreate() {
        CreateRoleParamsBody body = readRequestFromFile("create", new TypeReference<CreateRoleParamsBody>() {});
        BaseResponse response = api.create(body).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "Role created successfully.");
    }

    @Test
    public void testGet() {
        GetRoleResponse role = api.get(MockConstants.NEW_ROLE_NAME).block();
        assertNotNull(role);
        assertEquals(role.getMessageCode(), "200");
        assertEquals(role.getMessage(), "Role details fetched successfully.");
        assertNotNull(role.getRoleInfo());
        assertEquals(role.getRoleInfo().getID(), MockConstants.NEW_ROLE_NAME);
        assertEquals(role.getRoleInfo().getRoleName(), MockConstants.NEW_ROLE_NAME);
        assertEquals(role.getRoleInfo().getDescription(), createdDesc);
        assertNotNull(role.getRoleInfo().getPermissions());
        assertTrue(role.getRoleInfo().getPermissions().contains("administrator"));
    }

    @Test
    public void testListPermissions() {
        // TODO: currently the API throws a 404 not found error
        assertThrows(WebClientResponseException.NotFound.class, () -> api.listPermissions().block());
        /*GetPermissionsResponse response = api.listPermissions().block();
        assertNotNull(response);*/
    }

    @Test
    public void testListRoles() {
        GetAllRolesResponse response = api.listRoles().block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "All Roles retrieved successfully.");
        List<Role> roles = response.getRoles();
        assertNotNull(roles);
        assertEquals(roles.size(), 9);
        Role one = roles.get(1);
        assertEquals(one.getID(), "Administrator");
        assertEquals(one.getRoleName(), "Administrator");
        assertEquals(one.getDescription(), "Administrator role");
        assertNotNull(one.getPermissions());
        assertEquals(one.getPermissions().get(0), "administrator");
    }

    @Test
    public void testUpdate() {
        UpdateRoleParamsBody body = readRequestFromFile("update", new TypeReference<UpdateRoleParamsBody>() {});
        // TODO: currently the API throws a 500 internal server error
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.update(MockConstants.NEW_ROLE_NAME, body).block());
        /*BaseResponse response = api.update(MockConstants.NEW_ROLE_NAME, body).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "???");*/
    }

    @Test
    public void testDelete() {
        // TODO: currently the API throws a 500 internal server error
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.delete(MockConstants.NEW_ROLE_NAME).block());
        /*BaseResponse response = api.delete(MockConstants.NEW_ROLE_NAME).block();
        assertNotNull(response);*/
    }

}
