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

import com.ibm.watson.data.client.api.RoleManagementApi;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Test the Role Management API endpoints.
 */
public class RoleManagementTest {

    private RoleManagementApi api;

    public static final String CREATED_NAME = "Test Role";
    private static final String createdDesc = "A test role to validate the API client works as expected.";
    private static final String updatedDesc = "Now with an updated description.";

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new RoleManagementApi(MockConstants.getApiClient());
    }

    /**
     * Test creation of a role.
     */
    @Test
    public void testCreate() {
        CreateRoleParamsBody body = new CreateRoleParamsBody();
        body.setRoleName(CREATED_NAME);
        body.setDescription(createdDesc);
        body.addPermissionsItem("administrator");
        PlatformSuccessResponse response = api.create(body).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "Role created successfully.");
    }

    /**
     * Test retrieval of a role.
     */
    @Test
    public void testGet() {
        GetRoleResponse role = api.get(CREATED_NAME).block();
        assertNotNull(role);
        assertEquals(role.getMessageCode(), "200");
        assertEquals(role.getMessage(), "Role details fetched successfully.");
        assertNotNull(role.getRoleInfo());
        assertEquals(role.getRoleInfo().getID(), CREATED_NAME);
        assertEquals(role.getRoleInfo().getRoleName(), CREATED_NAME);
        assertEquals(role.getRoleInfo().getDescription(), createdDesc);
        assertNotNull(role.getRoleInfo().getPermissions());
        assertTrue(role.getRoleInfo().getPermissions().contains("administrator"));
    }

    /**
     * Test retrieval of all permissions available for roles.
     */
    @Test
    public void testListPermissions() {
        // TODO: currently the API throws a 404 not found error
        assertThrows(WebClientResponseException.NotFound.class, () -> api.listPermissions().block());
        /*GetPermissionsResponse response = api.listPermissions().block();
        assertNotNull(response);*/
    }

    /**
     * Test retrieval of all roles.
     */
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

    /**
     * Test update of a role.
     */
    @Test
    public void testUpdate() {
        UpdateRoleParamsBody body = new UpdateRoleParamsBody();
        body.setDescription(updatedDesc);
        body.addPermissionsItem("manage_catalog");
        // TODO: currently the API throws a 500 internal server error
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.update(CREATED_NAME, body).block());
        /*PlatformSuccessResponse response = api.update(createdName, body).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "???");*/
    }

    /**
     * Test deletion of a role.
     */
    @Test
    public void testDelete() {
        // TODO: currently the API throws a 500 internal server error
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.delete(CREATED_NAME).block());
        /*PlatformSuccessResponse response = api.delete(CREATED_NAME).block();
        assertNotNull(response);*/
    }

}
