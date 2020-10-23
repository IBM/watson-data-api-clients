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
import com.ibm.watson.data.client.api.WorkflowUserTasksApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.FormPropertyType;
import com.ibm.watson.data.client.model.enums.UserTaskState;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import static org.testng.Assert.*;

/**
 * Test the Workflow User Tasks API endpoints.
 * Note: the response files have been manually modified to remove any special characters that
 * were otherwise throwing of Jackson's parsing -- hopefully in a real API scenario these issues
 * are avoided by not needing to persist the response to a filesystem for test purposes.
 */
public class WorkflowUserTasksTest extends AbstractExpectations {

    private final WorkflowUserTasksApiV3 api = new WorkflowUserTasksApiV3(MockConstants.getApiClient());

    public WorkflowUserTasksTest() {
        super(WorkflowUserTasksApiV3.BASE_API, "workflowUserTasks");
    }

    private static final String taskId = "d1388125-1520-11eb-8009-0a580a81055e";

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "GET", "/" + taskId, "get");
        setupTest(client, "GET", "", "list");
        setupTest(client, "POST", "/" + taskId + "/actions", "update", 204);
    }

    @Test
    public void testList() {
        PaginatedResourceUserTask response = api.list(null, null, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertEquals(response.getLimit(), Integer.valueOf(50));
        assertEquals(response.getTotalCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        UserTask one = response.getResources().get(0);
        assertNotNull(one);
        validateMetadata(one.getMetadata());
        validateEntity(one.getEntity());
    }

    @Test
    public void testGet() {
        UserTask response = api.get(taskId).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata());
        validateEntity(response.getEntity());
    }

    @Test
    public void testUpdate() {
        UserTaskActionPayload body = readRequestFromFile("update", new TypeReference<UserTaskActionPayload>() {});
        api.update(taskId, body).block();
    }

    private void validateMetadata(UserTaskMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "user_task");
        assertEquals(metadata.getTaskId(), taskId);
        assertEquals(metadata.getName(), "Authoring");
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getWorkflowId(), "d0df3d5c-1520-11eb-8009-0a580a81055e");
        assertEquals(metadata.getState(), UserTaskState.CREATED);
    }

    private void validateEntity(UserTaskEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getTaskTitle(), "{\"id\":\"wkc-governance-workflows.autoPublish.authoring.taskTitle.CREATE.one\", \"defaultMessage\":\"Publish {artifactType} {artifactName}\", \"artifactType\":\"wkc-governance-workflows.default.artifactType.rule\", \"artifactTypePlural\":\"wkc-governance-workflows.default.artifactType.rule.plural\", \"artifactName\":\"Test Workflow using Rule\"} ");
        assertEquals(entity.getTaskInstruction(), " {\"id\":\"wkc-governance-workflows.autoPublish.authoring.taskInstructions.CREATE.one\", \"defaultMessage\":\"A {artifactType} was created by <USERID:{userId}>. Review this {artifactType} and then publish or delete it.\", \"artifactType\":\"wkc-governance-workflows.default.artifactType.rule\", \"artifactTypePlural\":\"wkc-governance-workflows.default.artifactType.rule.plural\", \"artifactName\":\"Test Workflow using Rule\", \"userId\":\":1000331004\"} ");
        assertEquals(entity.getPriority(), Integer.valueOf(50));
        assertEquals(entity.getTaskDefinitionKey(), "authoring");
        assertEquals(entity.getWorkflowTemplateId(), "autoPublish:1:99677726-e70c-11ea-8da9-0a580a83004b");
        assertNotNull(entity.getVariables());
        assertEquals(entity.getVariables().size(), 3);
        Variable var = entity.getVariables().get(0);
        assertNotNull(var);
        assertEquals(var.getName(), "is_hidden");
        assertTrue(var.getValue() instanceof String);
        assertEquals(var.getValue(), "false");
        assertNotNull(entity.getFormProperties());
        assertEquals(entity.getFormProperties().size(), 2);
        FormProperty one = entity.getFormProperties().get(0);
        assertNotNull(one);
        assertEquals(one.getId(), "action");
        assertEquals(one.getType(), FormPropertyType.ENUM);
        assertFalse(one.getReadable());
        assertTrue(one.getWritable());
        assertTrue(one.getRequired());
        assertNotNull(one.getEnumValues());
        assertEquals(one.getEnumValues().size(), 2);
        assertEquals(one.getEnumValues().get(0).getId(), "#publish");
        assertEquals(one.getEnumValues().get(0).getName(), "{\"id\":\"wkc-governance-workflows.autoPublish.authoring.actionButton.publish\", \"defaultMessage\":\"Publish\"}");
        assertNotNull(entity.getCandidateUsers());
        assertEquals(entity.getCandidateUsers().size(), 1);
        assertEquals(entity.getCandidateUsers().get(0), "1000330999");
        assertNotNull(entity.getCandidateGroups());
        assertEquals(entity.getCandidateGroups().size(), 1);
        assertEquals(entity.getCandidateGroups().get(0), "author_governance_artifacts_authority_group");
    }

}
