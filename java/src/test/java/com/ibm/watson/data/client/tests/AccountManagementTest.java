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

import com.ibm.watson.data.client.api.AccountManagementApi;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test the Account Management API endpoints.
 */
public class AccountManagementTest extends AbstractExpectations {

    private final AccountManagementApi api = new AccountManagementApi(MockConstants.getApiClient());

    public AccountManagementTest() {
        super(AccountManagementApi.API_BASE, "accountManagement");
    }

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", "/changepassword", "password");
        setupTest(client, "GET", "/me", "get");
        // TODO: endpoint currently broken (results in 500)
        setupTest(client, "PUT", "/me", "update", 500);
    }

    @Test
    public void testGetMe() {
        GetMeResponse me = api.getMe().block();
        assertNotNull(me);
        assertNotNull(me.getUserInfo());
        assertEquals(me.getUserInfo().getDisplayName(), "Some User");
        assertEquals(me.getUserInfo().getEmail(), "someone@example.com");
        assertEquals(me.getUserInfo().getUsername(), "someone");
        assertEquals(me.getMessageCode(), "200");
    }

    @Test
    public void testChangePassword() {
        BaseResponse response = api.changePassword("abc123", "def456").block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");
        assertEquals(response.getMessage(), "Password changed successfully.");
    }

    @Test
    public void testUpdateMe() {
        UpdateMeParamsBody body = new UpdateMeParamsBody();
        body.setDisplayName("New Name");
        body.setEmail("newmail@example.com");
        // TODO: currently the API throws a 500 internal server error
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.updateMe(body).block());
        //assertNotNull(response);
        //assertEquals(response.getMessageCode(), "200");
    }

}
