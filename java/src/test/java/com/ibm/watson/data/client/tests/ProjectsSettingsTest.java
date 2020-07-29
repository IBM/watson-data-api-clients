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
import com.ibm.watson.data.client.api.ProjectsSettingsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Project Settings API endpoints.
 */
public class ProjectsSettingsTest extends AbstractExpectations {

    private final ProjectsSettingsApiV2 api = new ProjectsSettingsApiV2(MockConstants.getApiClient());

    public ProjectsSettingsTest() {
        super(ProjectsSettingsApiV2.BASE_API, "projectSettings");
    }

    @Override
    public void init(MockServerClient client) {
        injectIntoBaseUrl("{guid}", PROJECT_GUID);
        setupTest(client, "GET", "/access_restrictions", "getAccessRestrictions");
        setupTest(client, "GET", "/audit_events", "getAuditEvents");
        setupTest(client, "PUT", "/access_restrictions", "updateAccessRestrictions");
        setupTest(client, "PUT", "/audit_events", "updateAuditEvents");
    }

    @Test
    public void testGetAccessRestrictions() {
        SettingsGroupAccessRestrictions settings = api.getAccessRestrictions(MockConstants.PROJECT_GUID).block();
        assertNotNull(settings);
        assertFalse(settings.getData());
    }

    @Test
    public void testGetAuditEvents() {
        SettingsGroupAuditEvents settings = api.getAuditEvents(MockConstants.PROJECT_GUID).block();
        assertNotNull(settings);
        assertFalse(settings.getEnabled());
    }

    @Test
    public void testUpdateAccessRestrictions() {
        SettingsGroupAccessRestrictions settings = readRequestFromFile("updateAccessRestrictions", new TypeReference<SettingsGroupAccessRestrictions>() {});
        SettingsGroupAccessRestrictions response = api.updateAccessRestrictions(MockConstants.PROJECT_GUID, settings).block();
        assertNotNull(response);
        assertTrue(response.getData());
    }

    @Test
    public void testUpdateAuditEvents() {
        SettingsGroupAuditEvents settings = readRequestFromFile("updateAuditEvents", new TypeReference<SettingsGroupAuditEvents>() {});
        SettingsGroupAuditEvents response = api.updateAuditEvents(MockConstants.PROJECT_GUID, settings).block();
        assertNotNull(response);
        assertTrue(response.getEnabled());
    }

}
