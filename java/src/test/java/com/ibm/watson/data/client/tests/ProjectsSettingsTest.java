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

import com.ibm.watson.data.client.api.ProjectsSettingsApiV2;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test the Project Settings API endpoints.
 */
public class ProjectsSettingsTest {

    private ProjectsSettingsApiV2 api;

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new ProjectsSettingsApiV2(MockConstants.getApiClient());
    }

    /**
     * Test retrieval of access restriction settings.
     */
    @Test
    public void testGetAccessRestrictions() {
        SettingsGroupAccessRestrictions settings = api.getAccessRestrictions(MockConstants.PROJECT_GUID).block();
        assertNotNull(settings);
        assertFalse(settings.getData());
    }

    /**
     * Test retrieval of audit event settings.
     */
    @Test
    public void testGetAuditEvents() {
        SettingsGroupAuditEvents settings = api.getAuditEvents(MockConstants.PROJECT_GUID).block();
        assertNotNull(settings);
        assertFalse(settings.getEnabled());
    }

    /**
     * Test update of access restriction settings.
     */
    @Test
    public void updateAccessRestrictions() {
        SettingsGroupAccessRestrictions settings = new SettingsGroupAccessRestrictions();
        settings.setData(true);
        SettingsGroupAccessRestrictions response = api.updateAccessRestrictions(MockConstants.PROJECT_GUID, settings).block();
        assertNotNull(response);
        assertTrue(response.getData());
    }

    /**
     * Test update of audit event settings.
     */
    @Test
    public void testUpdateAuditEvents() {
        SettingsGroupAuditEvents settings = new SettingsGroupAuditEvents();
        settings.setEnabled(true);
        SettingsGroupAuditEvents response = api.updateAuditEvents(MockConstants.PROJECT_GUID, settings).block();
        assertNotNull(response);
        assertTrue(response.getEnabled());
    }

}
