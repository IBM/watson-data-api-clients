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
import com.ibm.watson.data.client.api.WorkflowsApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.ArtifactState;
import com.ibm.watson.data.client.model.enums.GlossaryObjectDraftMode;
import com.ibm.watson.data.client.model.enums.WorkflowState;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Workflows API endpoints.
 */
public class WorkflowsTest extends AbstractExpectations {

    private final WorkflowsApiV3 api = new WorkflowsApiV3(MockConstants.getApiClient());

    public WorkflowsTest() {
        super(WorkflowsApiV3.BASE_API, "workflows");
    }

    private static final String workflowEndpoint = "/" + WORKFLOW_GUID;

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "GET", workflowEndpoint + "/artifacts", "listArtifacts");
        setupTest(client, "GET", workflowEndpoint, "get");
        setupTest(client, "GET", "", "list");
        setupTest(client, "POST", "/all/query", "search");
    }

    @Test
    public void testList() {
        PaginatedResourceWorkflow response = api.list(null, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getTotalCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        Workflow one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getMetadata());
        validateWorkflowMetadata(one.getMetadata());
        assertNotNull(one.getEntity());
        validateWorkflowEntity(one.getEntity());
    }

    @Test
    public void testGet() {
        Workflow response = api.get(WORKFLOW_GUID, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        validateWorkflowMetadata(response.getMetadata());
        assertNotNull(response.getEntity());
        validateWorkflowEntity(response.getEntity());
    }

    @Test
    public void testListArtifacts() {
        PaginatedResourceArtifact response = api.listArtifacts(WORKFLOW_GUID, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getTotalCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        validateArtifact(response.getResources().get(0));
    }

    @Test
    public void testSearch() {
        WorkflowQuery body = readRequestFromFile("search", new TypeReference<WorkflowQuery>() {});
        PaginatedResourceWorkflow response = api.search(body, null, null, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        Workflow one = response.getResources().get(0);
        assertNotNull(one.getMetadata());
        validateWorkflowMetadata(one.getMetadata());
        assertNotNull(one.getEntity());
        validateWorkflowEntity(one.getEntity());
    }

    private void validateWorkflowMetadata(WorkflowMetadata metadata) {
        assertEquals(metadata.getArtifactType(), "workflow");
        assertEquals(metadata.getWorkflowId(), WORKFLOW_GUID);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getState(), WorkflowState.RUNNING);
    }

    private void validateWorkflowEntity(WorkflowEntity entity) {
        assertEquals(entity.getWorkflowTemplateId(), "autoPublish:1:808374b6-aa22-11ea-8c06-0a580a810041");
        assertEquals(entity.getWorkflowTemplateKey(), "autoPublish");
        assertEquals(entity.getWorkflowTemplateVersion(), Integer.valueOf(1));
        assertNotNull(entity.getArtifacts());
        assertEquals(entity.getArtifacts().size(), 1);
        validateArtifact(entity.getArtifacts().get(0));
        assertEquals(entity.getWorkflowState(), "Not started");
    }

    private void validateArtifact(Artifact artifact) {
        assertNotNull(artifact);
        assertNotNull(artifact.getMetadata());
        assertEquals(artifact.getMetadata().getArtifactType(), "glossary_term");
        assertEquals(artifact.getMetadata().getArtifactId(), NEW_TERM_GUID);
        assertEquals(artifact.getMetadata().getVersionId(), "e0c87bc9-93eb-4c84-a3e3-e5fd309d3c6b");
        assertEquals(artifact.getMetadata().getState(), ArtifactState.DRAFT);
        assertEquals(artifact.getMetadata().getName(), "Test Term");
        assertNotNull(artifact.getWorkflowData());
        assertEquals(artifact.getWorkflowData().getBaseUrl(), "https://internal-nginx-svc:12443/v3/glossary_terms");
        assertEquals(artifact.getWorkflowData().getDraftMode(), GlossaryObjectDraftMode.CREATED);
    }

}