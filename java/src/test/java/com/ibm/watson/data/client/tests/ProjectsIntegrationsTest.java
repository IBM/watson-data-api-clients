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
import com.ibm.watson.data.client.api.ProjectsIntegrationsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Project Integration API endpoints.
 */
public class ProjectsIntegrationsTest extends AbstractExpectations {

    private final ProjectsIntegrationsApiV2 api = new ProjectsIntegrationsApiV2(MockConstants.getApiClient());

    public ProjectsIntegrationsTest() {
        super(ProjectsIntegrationsApiV2.BASE_API, "projectIntegrations");
    }

    @Override
    public void init(MockServerClient client) {
        injectIntoBaseUrl("{guid}", PROJECT_GUID);
        setupTest(client, "GET", "", "getJupyterlabIntegration");
        setupTest(client, "PUT", "", "updateJupyterlabIntegration");
        setupTest(client, "DELETE", "", "deleteJupyterlabIntegration", 204);
    }

    @Test
    public void testUpdateJupyterlabIntegration() {
        IntegrationJupyterLab body = readRequestFromFile("updateJupyterlabIntegration", new TypeReference<IntegrationJupyterLab>() {});
        IntegrationJupyterLab response = api.updateJupyterlabIntegration(PROJECT_GUID, body).block();
        assertNotNull(response);
        assertEquals(response.getGuid(), PROJECT_GUID);
    }

    @Test
    public void testGetJupyterlabIntegration() {
        IntegrationJupyterLab response = api.getJupyterlabIntegration(PROJECT_GUID).block();
        assertNotNull(response);
        assertEquals(response.getGuid(), PROJECT_GUID);
    }

    @Test
    public void testDeleteJupyterlabIntegration() {
        api.deleteJupyterlabIntegration(PROJECT_GUID).block();
    }

}
