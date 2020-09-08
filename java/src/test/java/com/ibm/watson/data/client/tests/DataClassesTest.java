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
import com.ibm.watson.data.client.api.DataClassesApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.GlossaryObjectDraftMode;
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Data Classes API endpoints.
 */
public class DataClassesTest extends AbstractExpectations {

    private final DataClassesApiV3 api = new DataClassesApiV3(MockConstants.getApiClient());

    public DataClassesTest() {
        super(DataClassesApiV3.BASE_API, "dataClasses");
    }

    private final Map<String, List<String>> typeParams = new HashMap<>();
    private void setupParams() {
        List<String> types = new ArrayList<>();
        types.add("all");
        typeParams.put("type", types);
    }

    private static final String relationshipId = "8ca37291-f1b9-4122-8f2b-2aae230a306b";
    private static final String versionId = "ebd1af9b-8d03-414d-99e9-79dd8016900c";
    private static final String dataclassEndpoint = "/" + NEW_DATACLASS_ID;
    private static final String versionEndpoint = dataclassEndpoint + "/versions/" + versionId;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "POST", versionEndpoint + "/relationships", "createRelationships", 201);
        setupTest(client, "DELETE", versionEndpoint, "delete");
        setupTest(client, "DELETE", versionEndpoint + "/relationships/" + relationshipId, "deleteRelationship");
        setupTest(client, "GET", dataclassEndpoint + "/versions", "getByStatus");
        setupTest(client, "GET", versionEndpoint, "getByVersion");
        setupTest(client, "GET", "", "list");
        setupTest(client, "GET", versionEndpoint + "/relationships", typeParams, "listRelationships");
        setupTest(client, "PATCH", versionEndpoint, "update");
    }

    @Test
    public void testCreate() {
        NewDataClassEntity body = readRequestFromFile("create", new TypeReference<NewDataClassEntity>() {});
        GlossaryCreateResponse response = api.create(body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_DATACLASS_ID);
        assertEquals(one.getVersionId(), versionId);
        assertEquals(one.getWorkflowId(), "5d5ff9ae-f1ca-11ea-995d-0a580a830010");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_DATACLASS_ID);
        assertEquals(one.getEntityType(), "data_class");
    }

    @Test
    public void testGetByVersion() {
        ResponseDataClass response = api.getByVersion(NEW_DATACLASS_ID, versionId, null, null, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata());
        validateEntity(response.getEntity());
    }

    @Test
    public void testCreateRelationships() {
        DataClassRelationshipsRequest body = readRequestFromFile("createRelationships", new TypeReference<DataClassRelationshipsRequest>() {});
        GlossaryCreateResponse response = api.createRelationships(NEW_DATACLASS_ID, versionId, body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertEquals(one.getArtifactId(), relationshipId);
        assertEquals(one.getWorkflowId(), "5d5ff9ae-f1ca-11ea-995d-0a580a830010");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(one.getEntityType(), "relationship");
    }

    @Test
    public void testListRelationships() {
        PaginatedDataClassRelationships response = api.listRelationships(NEW_DATACLASS_ID, versionId, "all", null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getParentCategory());
        assertEquals(response.getParentCategory().getOffset(), Integer.valueOf(0));
        assertNotNull(response.getParentCategory().getLast());
        assertNotNull(response.getParentCategory().getLast().getHref());
        assertNotNull(response.getParentCategory().getResources());
        assertEquals(response.getParentCategory().getResources().size(), 1);
        RelationshipParentRelationshipEntity one = response.getParentCategory().getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getArtifactType(), "relationship");
        assertEquals(one.getMetadata().getArtifactId(), relationshipId);
        assertEquals(one.getMetadata().getVersionId(), "b302cef9-4c69-414e-9d7c-b798e4132b5a");
        assertEquals(one.getMetadata().getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(one.getMetadata().getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(one.getMetadata().getWorkflowId(), "5d5ff9ae-f1ca-11ea-995d-0a580a830010");
        assertEquals(one.getMetadata().getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(one.getMetadata().getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(one.getMetadata().getCreatedAt());
        assertEquals(one.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(one.getMetadata().getModifiedAt());
        assertEquals(one.getMetadata().getRevision(), "0");
        assertEquals(one.getMetadata().getState(), GlossaryObjectState.DRAFT);
        assertFalse(one.getMetadata().getReadOnly());
        assertFalse(one.getMetadata().getRemoveStartDate());
        assertFalse(one.getMetadata().getRemoveEndDate());
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getParentId(), NEW_CATEGORY_ID);
        assertEquals(one.getEntity().getParentGlobalId(), REPOSITORY_ID + "_" + NEW_CATEGORY_ID);
        assertEquals(one.getEntity().getParentName(), "Test Category");
        assertTrue(one.getEntity().getParentEnabled());
        assertEquals(one.getEntity().getChildId(), NEW_DATACLASS_ID);
        assertEquals(one.getEntity().getChildGlobalId(), REPOSITORY_ID + "_" + NEW_DATACLASS_ID);
        assertEquals(one.getEntity().getChildName(), "Test DataClass");
        assertEquals(one.getEntity().getRelationshipType(), "parent_category");
        assertEquals(one.getEntity().getSourceType(), "data_class");
        assertEquals(one.getEntity().getTargetType(), "category");
        assertEquals(response.getParentCategory().getLimit(), Integer.valueOf(10));
        assertEquals(response.getParentCategory().getCount(), Long.valueOf(1));
        assertNotNull(response.getParentCategory().getFirst());
        assertNotNull(response.getParentCategory().getFirst().getHref());
    }

    @Test
    public void testDeleteRelationship() {
        GlossaryCreateResponse response = api.deleteRelationship(NEW_DATACLASS_ID, versionId, relationshipId, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_DATACLASS_ID);
        assertEquals(one.getVersionId(), versionId);
        assertEquals(one.getWorkflowId(), "5d5ff9ae-f1ca-11ea-995d-0a580a830010");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_DATACLASS_ID);
        assertEquals(one.getEntityType(), "data_class");
    }

    @Test
    public void testGetByStatus() {
        PaginatedDataClassList response = api.getByStatus(NEW_DATACLASS_ID, null, null, null, null, null, null).block();
        validatePaginatedResponse(response);
    }

    @Test
    public void testList() {
        PaginatedDataClassList response = api.list(null, null, null, null, null, null, null, null, null).block();
        validatePaginatedResponse(response);
    }

    private void validatePaginatedResponse(PaginatedDataClassList response) {
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        ResponseDataClass one = response.getResources().get(0);
        validateMetadata(one.getMetadata(), "eeecf7ae-055b-4d85-84af-be523c2225fa_0");
        validateEntity(one.getEntity());
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testUpdate() {
        UpdatableDataClassEntity body = readRequestFromFile("update", new TypeReference<UpdatableDataClassEntity>() {});
        ResponseDataClass response = api.update(NEW_DATACLASS_ID, versionId, body, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        assertEquals(response.getMetadata().getArtifactType(), "data_class");
        assertEquals(response.getMetadata().getArtifactId(), NEW_DATACLASS_ID);
        assertEquals(response.getMetadata().getVersionId(), "1af37b11-c122-4d4a-8b2b-438a69f2fe25");
        assertEquals(response.getMetadata().getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(response.getMetadata().getGlobalId(), REPOSITORY_ID + "_" + NEW_DATACLASS_ID);
        assertEquals(response.getMetadata().getWorkflowId(), "69b67d49-f1ea-11ea-995d-0a580a830010");
        assertEquals(response.getMetadata().getDraftMode(), GlossaryObjectDraftMode.MODIFIED);
        assertEquals(response.getMetadata().getPublishedAncestorId(), "eeecf7ae-055b-4d85-84af-be523c2225fa_0");
        assertNotNull(response.getMetadata().getEffectiveStartDate());
        assertEquals(response.getMetadata().getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(response.getMetadata().getCreatedAt());
        assertEquals(response.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(response.getMetadata().getModifiedAt());
        assertEquals(response.getMetadata().getRevision(), "1");
        assertEquals(response.getMetadata().getName(), "Test DataClass");
        assertEquals(response.getMetadata().getShortDescription(), "This is an updated description.");
        assertEquals(response.getMetadata().getState(), GlossaryObjectState.DRAFT);
        assertNotNull(response.getMetadata().getTags());
        assertEquals(response.getMetadata().getTags().size(), 0);
        assertNotNull(response.getMetadata().getStewardIds());
        assertEquals(response.getMetadata().getStewardIds().size(), 0);
        assertEquals(response.getMetadata().getWorkflowState(), "Not started");
        assertFalse(response.getMetadata().getReadOnly());
        assertFalse(response.getMetadata().getRemoveStartDate());
        assertFalse(response.getMetadata().getRemoveEndDate());
        validateEntity(response.getEntity());
    }

    @Test
    public void testDelete() {
        api.delete(NEW_DATACLASS_ID, versionId, null, null).block();
    }

    private void validateMetadata(GlossaryObjectMetadata metadata) {
        validateMetadata(metadata, versionId);
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String version) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "data_class");
        assertEquals(metadata.getArtifactId(), NEW_DATACLASS_ID);
        assertEquals(metadata.getVersionId(), version);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_DATACLASS_ID);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getName(), "Test DataClass");
        assertEquals(metadata.getShortDescription(), "A data class to test APIs.");
        if (version.equals(versionId)) {
            assertEquals(metadata.getWorkflowId(), "5d5ff9ae-f1ca-11ea-995d-0a580a830010");
            assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
            assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
            assertEquals(metadata.getWorkflowState(), "Not started");
        } else {
            assertEquals(metadata.getDraftAncestorId(), versionId);
            assertNotNull(metadata.getEffectiveStartDate());
            assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
        }
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertTrue(metadata.getStewardIds() == null || metadata.getStewardIds().size() == 0);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateEntity(ResponseDataClassEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getClassCode(), "TestDataClassf1c8cd84-ce0d-435f-8613-970f6970c452");
        assertEquals(entity.getProviderType(), "CUSTOM");
        assertEquals(entity.getDataClassType(), "Regex");
        assertNotNull(entity.getDefinition());
        assertFalse(entity.getEnabled());
        assertTrue(entity.getParentEnabled());
        assertNotNull(entity.getDataType());
        assertEquals(entity.getDataType().size(), 1);
        assertEquals(entity.getDataType().get(0), "string");
        assertFalse(entity.getCaseSensitive());
        assertFalse(entity.getAllowSubstringMatch());
        assertFalse(entity.getSqueezeConsecutiveWhiteSpaces());
        assertEquals(entity.getRegularExpression(), "^test$");
        assertEquals(entity.getApplicableFor(), "structured_data_only");
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertNotNull(entity.getCustomAttributes());
        assertEquals(entity.getCustomAttributes().size(), 0);
    }

}