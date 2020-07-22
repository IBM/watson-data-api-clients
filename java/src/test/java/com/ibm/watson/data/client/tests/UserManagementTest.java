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

import com.ibm.watson.data.client.api.UserManagementApi;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Test the User Management API endpoints.
 */
public class UserManagementTest {

    private UserManagementApi api;

    public static final String CREATED_NAME = "jsmith";
    private static final String createdName = "Jon Smith";
    private static final String userEmail   = "jsmith@example.com";

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new UserManagementApi(MockConstants.getApiClient());
    }

    /**
     * Test creation of a user.
     */
    @Test
    public void testCreate() {
        CreateUserParamsBody body = new CreateUserParamsBody();
        body.setUserName(CREATED_NAME);
        body.setDisplayName(createdName);
        body.setEmail(userEmail);
        body.addUserRolesItem("Data Engineer");
        CreateUserSuccessResponse response = api.create(body).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "User created successfully.");
        assertNotNull(response.getUser());
        assertEquals(response.getUser().getID(), CREATED_NAME);
    }

    /**
     * Test retrieval of a user.
     */
    @Test
    public void testGet() {
        GetUserResponse user = api.get(CREATED_NAME).block();
        assertNotNull(user);
        assertEquals(user.getMessageCode(), "200");
        assertEquals(user.getMessage(), "User details fetched successfully.");
        validateUser(user.getUserInfo());
    }

    private void validateUser(UserInfo userInfo) {
        assertNotNull(userInfo);
        assertEquals(userInfo.getApprovalStatus(), "approved");
        assertEquals(userInfo.getAuthenticator(), "default");
        assertEquals(userInfo.getCreatedTimestamp(), "2020-07-22 10:20:22.464 +0000 UTC");
        assertEquals(userInfo.getCurrentAccountStatus(), "enabled");
        assertEquals(userInfo.getDisplayName(), createdName);
        assertEquals(userInfo.getEmail(), userEmail);
        assertEquals(userInfo.getLastModifiedTimestamp(), "2020-07-22 10:20:22.464 +0000 UTC");
        assertNotNull(userInfo.getPermissions());
        assertTrue(userInfo.getPermissions().contains("access_catalog"));
        assertEquals(userInfo.getRole(), "User");
        assertEquals(userInfo.getUid(), "1000331015");
        assertNotNull(userInfo.getUserRoles());
        assertTrue(userInfo.getUserRoles().contains("Data Engineer"));
        assertEquals(userInfo.getUsername(), CREATED_NAME);
    }

    /**
     * Test retrieval of all users.
     */
    @Test
    public void testList() {
        GetAllUsersResponse response = api.list().block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "All users fetched successfully.");
        List<UserInfo> users = response.getUsersInfo();
        assertNotNull(users);
        assertEquals(users.size(), 2);
        validateUser(users.get(1));
    }

    /**
     * Test update of a user.
     */
    @Test
    public void testUpdate() {
        UpdateUserParamsBody body = new UpdateUserParamsBody();
        body.setEmail("newmail@example.com");
        // TODO: currently the API throws a 500 internal server error
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.update(CREATED_NAME, body).block());
        /*PlatformSuccessResponse response = api.update(CREATED_NAME, body).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "???");*/
    }

    /**
     * Test deletion of a user.
     */
    @Test
    public void testDelete() {
        PlatformSuccessResponse response = api.delete(CREATED_NAME).block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "User deleted successfully.");
    }

}
