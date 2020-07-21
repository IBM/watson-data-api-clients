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

import com.ibm.watson.data.client.ApiClient;
import com.ibm.watson.data.client.api.ProjectsApiV2;
import com.ibm.watson.data.client.api.TransactionalProjectsApiV2;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Test the Project API endpoints.
 */
public class ProjectTest {

    private ProjectsApiV2 api;
    private TransactionalProjectsApiV2 txnApi;

    private static final String storageGuid = "177766d9-9633-36b3-803f-96593343d4f9";
    public static final String CREATED_GUID = "f0bd7b72-f690-4b65-9edb-7a430fa658d9";
    private static final String createdName = "Test Project";
    private static final String createdDesc = "A test project to validate the API client works as expected.";
    private static final String updatedDesc = "Now with an updated description.";
    private static final String createdGen  = "API-Test-Suite";

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        ApiClient client = MockConstants.getApiClient();
        api = new ProjectsApiV2(client);
        txnApi = new TransactionalProjectsApiV2(client);
    }

    /**
     * Test creation of a project.
     */
    @Test
    public void testCreate() {
        TransactionalProjectCreate body = new TransactionalProjectCreate();
        body.setName(createdName);
        body.setGenerator(createdGen);
        body.setDescription(createdDesc);
        body.setPublic(true);
        TransactionalProjectStorageObject storage = new TransactionalProjectStorageObject();
        storage.setType(TransactionalProjectStorageObject.TypeEnum.ASSETFILES);
        storage.setGuid(storageGuid);
        body.setStorage(storage);
        CreateTransactionProjectResponse created = txnApi.create(body).block();
        assertNotNull(created);
        assertNotNull(created.getLocation());
        assertEquals(created.getLocation(), "/v2/projects/" + CREATED_GUID);
    }

    /**
     * Test retrieval of a project.
     */
    @Test
    public void testGet() {
        Project project = api.get(CREATED_GUID, null).block();
        assertNotNull(project);
        assertNotNull(project.getMetadata());
        assertEquals(project.getMetadata().getGuid(), CREATED_GUID);
        assertNotNull(project.getEntity());
        assertEquals(project.getEntity().getName(), createdName);
        assertEquals(project.getEntity().getDescription(), createdDesc);
    }

    /**
     * Test listing of all projects.
     */
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

    /**
     * Test update of a project.
     */
    @Test
    public void testUpdate() {
        UpdateProjectBody body = new UpdateProjectBody();
        body.setDescription(updatedDesc);
        Project updated = api.update(CREATED_GUID, body).block();
        assertNotNull(updated);
        assertNotNull(updated.getEntity());
        assertEquals(updated.getEntity().getDescription(), updatedDesc);
    }

    /**
     * Test deletion of a project.
     */
    @Test
    public void testDelete() {
        txnApi.delete(CREATED_GUID).block();
    }

}
