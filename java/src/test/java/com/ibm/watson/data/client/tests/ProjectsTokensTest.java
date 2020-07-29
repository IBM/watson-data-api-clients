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
import com.ibm.watson.data.client.api.ProjectsTokensApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.TokenAudience;
import com.ibm.watson.data.client.model.enums.TokenRole;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Project Integration API endpoints.
 */
public class ProjectsTokensTest extends AbstractExpectations {

    private final ProjectsTokensApiV2 api = new ProjectsTokensApiV2(MockConstants.getApiClient());

    public ProjectsTokensTest() {
        super(ProjectsTokensApiV2.BASE_API, "projectTokens");
    }

    private static final String projectTokensEndpoint = "/" + PROJECT_GUID + "/tokens";
    private static final String tokenGuid = "d1126bf1-6617-41f8-984b-750ea6e96c2f";
    private static final String tokenItself = "p-f366bec7608543540078247a3cdfb2775bc10cc6";
    private static final String tokenName = "Test Token";

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", projectTokensEndpoint, "create", 201);
        setupTest(client, "GET", projectTokensEndpoint, "list");
        setupTest(client, "GET", "/tokens/introspect", "validate");
        setupTest(client, "DELETE", projectTokensEndpoint + "/" + tokenGuid, "delete", 204);
        setupTest(client, "DELETE", projectTokensEndpoint, "deleteAll", 204);
    }

    @Test
    public void testCreate() {
        CreateTokenBody body = readRequestFromFile("create", new TypeReference<CreateTokenBody>() {});
        ProjectToken response = api.create(PROJECT_GUID, body).block();
        validateToken(response);
    }

    @Test
    public void testList() {
        ProjectTokens response = api.list(PROJECT_GUID).block();
        assertNotNull(response);
        assertNotNull(response.getTokens());
        assertEquals(response.getTokens().size(), 1);
        validateToken(response.getTokens().get(0));
    }

    @Test
    public void testValidate() {
        ProjectToken response = api.validate(tokenItself).block();
        validateToken(response);
    }

    @Test
    public void testDelete() {
        api.delete(PROJECT_GUID, tokenGuid).block();
    }

    @Test
    public void testDeleteAll() {
        api.deleteAll(PROJECT_GUID).block();
    }

    private void validateToken(ProjectToken token) {
        assertNotNull(token);
        assertEquals(token.getToken(), tokenItself);
        assertEquals(token.getGuid(), tokenGuid);
        assertEquals(token.getName(), tokenName);
        assertNotNull(token.getScopes());
        assertEquals(token.getScopes().size(), 1);
        TokenScope one = token.getScopes().get(0);
        assertEquals(one.getAudience(), TokenAudience.PROJECT);
        assertEquals(one.getGuid(), PROJECT_GUID);
        assertEquals(one.getRole(), TokenRole.VIEWER);
        assertNotNull(token.getCreatedAt());
        assertNotNull(token.getLastUsedAt());
    }

}
