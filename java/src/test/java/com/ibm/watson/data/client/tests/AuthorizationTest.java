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
import com.ibm.watson.data.client.api.AuthorizationApi;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test the Authorization API endpoints.
 */
public class AuthorizationTest extends AbstractExpectations {

    private final AuthorizationApi api = new AuthorizationApi(MockConstants.getApiClient());

    public AuthorizationTest() {
        super("/icp4d-api/v1/authorize", "authorization");
    }

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", "", "getTokenCP4D");
    }

    private static final String sampleToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNncm90ZSIsInJvbGUiOiJBZG1pbiIsInBlcm1pc3Npb25zIjpbImFkbWluaXN0cmF0b3IiLCJjYW5fcHJvdmlzaW9uIiwibWFuYWdlX2NhdGFsb2ciLCJtYW5hZ2VfcXVhbGl0eSIsIm1hbmFnZV9pbmZvcm1hdGlvbl9hc3NldHMiLCJtYW5hZ2VfZGlzY292ZXJ5IiwibWFuYWdlX21ldGFkYXRhX2ltcG9ydCIsIm1hbmFnZV9nb3Zlcm5hbmNlX3dvcmtmbG93IiwibWFuYWdlX2NhdGVnb3JpZXMiLCJhdXRob3JfZ292ZXJuYW5jZV9hcnRpZmFjdHMiLCJ2aXJ0dWFsaXplX3RyYW5zZm9ybSIsImFjY2Vzc19hZHZhbmNlZF9nb3Zlcm5hbmNlX2NhcGFiaWxpdGllcyIsInNpZ25faW5fb25seSIsImFjY2Vzc19jYXRhbG9nIiwiYWNjZXNzX2luZm9ybWF0aW9uX2Fzc2V0cyIsInZpZXdfcXVhbGl0eSIsInZpZXdfZ292ZXJuYW5jZV9hcnRpZmFjdHMiXSwic3ViIjoiY2dyb3RlIiwiaXNzIjoiS05PWFNTTyIsImF1ZCI6IkRTWCIsInVpZCI6IjEwMDAzMzEwMDQiLCJhdXRoZW50aWNhdG9yIjoiZGVmYXVsdCIsImlhdCI6MTU5NTMyNjkxNSwiZXhwIjoxNTk1MzcwMDc5fQ.PZHY5nSzBpfqCo0kdQTQXY7u8eAIVkC-v2uoa6eTbMRu6wEkGtV0GeJRRWFMyZzCWhFrvsem0iXSWVQfsK-0gYkMLxPMSHao2GS-YPWPBLcKVRWTzgq36XIUw6bJCjyINIK2e0YHZiIOTSS9p58gzfnj3gGQ9-An0STrDN1rqe0_eXHhkwwkdquxFqiMimWD0kIJfbFppLvvO3PddU9-P4hOhx4nUIz16aum0aAYx_di-wKcB58CNxJolkdspn4YqNbfSBzB7kMoISiQJcmA1WqNv3R02rb-Jw7kLgx71NVHd68V01Sh2N3Q7jXVobeIY4YcNFuV2c25BW1DUZMNYg";

    @Test
    public void testGetTokenCP4D() {
        LoginCredentials cred = readRequestFromFile("getTokenCP4D", new TypeReference<LoginCredentials>() {});
        LoginResponse response = api.getAuthorizationToken(cred).block();
        assertNotNull(response);
        assertEquals(response.getToken(), sampleToken);
    }

}
