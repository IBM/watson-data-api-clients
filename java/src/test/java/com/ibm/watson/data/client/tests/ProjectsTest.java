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
import com.ibm.watson.data.client.api.ProjectsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.List;

import static com.ibm.watson.data.client.mocks.MockConstants.PROJECT_GUID;
import static org.testng.Assert.*;

/**
 * Test the Project API endpoints.
 */
public class ProjectsTest extends AbstractExpectations {

    private final ProjectsApiV2 api = new ProjectsApiV2(MockConstants.getApiClient());

    public ProjectsTest() {
        super(ProjectsApiV2.BASE_API, "project");
    }

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "GET", "/" + PROJECT_GUID, "get");
        setupTest(client, "GET", "", "list");
        setupTest(client, "PATCH", "/" + PROJECT_GUID, "update");
    }

    private static final String createdName = "Test Project";
    private static final String createdDesc = "A test project to validate the API client works as expected.";
    private static final String updatedDesc = "Now with an updated description.";

    @Test
    public void testGet() {
        Project project = api.get(MockConstants.PROJECT_GUID, null).block();
        assertNotNull(project);
        assertNotNull(project.getMetadata());
        assertEquals(project.getMetadata().getGuid(), MockConstants.PROJECT_GUID);
        assertNotNull(project.getEntity());
        assertEquals(project.getEntity().getName(), createdName);
        assertEquals(project.getEntity().getDescription(), createdDesc);
    }

    @Test
    public void testList() {
        Projects projects = api.list(null, null, null, null, null, null, null, null).block();
        assertNotNull(projects);
        assertEquals(projects.getTotalResults(), Integer.valueOf(1));
        List<Project> projectList = projects.getResources();
        assertNotNull(projectList);
        assertEquals(projectList.size(), 1);
        Project one = projectList.get(0);
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getName(), createdName);
    }

    @Test
    public void testUpdate() {
        UpdateProjectBody body = readRequestFromFile("update", new TypeReference<UpdateProjectBody>() {});
        Project updated = api.update(MockConstants.PROJECT_GUID, body).block();
        assertNotNull(updated);
        assertNotNull(updated.getEntity());
        assertEquals(updated.getEntity().getDescription(), updatedDesc);
    }

}
