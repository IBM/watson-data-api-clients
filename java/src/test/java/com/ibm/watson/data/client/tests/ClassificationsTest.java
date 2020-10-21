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
import com.ibm.watson.data.client.api.ClassificationsApiV3;
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
 * Test the Classifications API endpoints.
 */
public class ClassificationsTest extends AbstractExpectations {

    private final ClassificationsApiV3 api = new ClassificationsApiV3(MockConstants.getApiClient());

    public ClassificationsTest() {
        super(ClassificationsApiV3.BASE_API, "classifications");
    }

    private static final String draftVersion = "299e6712-8e39-4a5b-ac04-bac866707f71";
    private static final String publishedVersion = "9ff094c0-72e9-4b51-ad11-0ca2744206bf_0";
    private static final String relationshipId = "9b80330a-b056-4f88-bb3a-8cbea4c9e9cf";
    private static final String draftEndpoint = "/" + NEW_CLASSIFICATION_ID + "/versions/" + draftVersion;
    private static final String publishedEndpoint = "/" + NEW_CLASSIFICATION_ID + "/versions/" + publishedVersion;

    private final Map<String, List<String>> typeParams = new HashMap<>();
    private void setupParams() {
        List<String> types = new ArrayList<>();
        types.add("all");
        typeParams.put("type", types);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "POST", draftEndpoint + "/relationships", "createRelationships", 201);
        setupTest(client, "DELETE", publishedEndpoint, "delete", 201);
        setupTest(client, "DELETE", draftEndpoint + "/relationships/" + relationshipId, "deleteRelationship");
        setupTest(client, "GET", "/" + NEW_CLASSIFICATION_ID + "/versions", "get");
        setupTest(client, "GET", draftEndpoint, "getVersion");
        setupTest(client, "GET", "", "list");
        setupTest(client, "GET", draftEndpoint + "/relationships", typeParams, "listRelationships");
        setupTest(client, "PATCH", draftEndpoint, "update");
    }

    @Test
    public void testCreate() {
        NewClassificationEntity body = readRequestFromFile("create", new TypeReference<NewClassificationEntity>() {});
        GlossaryCreateResponse response = api.create(body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_CLASSIFICATION_ID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), "23836914-13a8-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_CLASSIFICATION_ID);
        assertEquals(one.getEntityType(), "classification");
    }

    @Test
    public void testGetVersion() {
        ResponseClassification response = api.getVersion(NEW_CLASSIFICATION_ID, draftVersion, null, null, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), "0", draftVersion);
        validateEntity(response.getEntity(), GlossaryObjectState.DRAFT);
    }

    @Test
    public void testUpdate() {
        UpdatableClassificationEntity body = readRequestFromFile("update", new TypeReference<UpdatableClassificationEntity>() {});
        ResponseClassification response = api.update(NEW_CLASSIFICATION_ID, draftVersion, body, null, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), "1", draftVersion);
        validateEntity(response.getEntity(), GlossaryObjectState.DRAFT);
        assertNotNull(response.getEntity());
        assertEquals(response.getEntity().getLongDescription(), "Now with a long description.");
    }

    @Test
    public void testCreateRelationships() {
        ClassificationRelationshipsRequest body = readRequestFromFile("createRelationships", new TypeReference<ClassificationRelationshipsRequest>() {});
        GlossaryCreateResponse response = api.createRelationships(NEW_CLASSIFICATION_ID, draftVersion, body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertEquals(one.getArtifactId(), relationshipId);
        assertEquals(one.getWorkflowId(), "23836914-13a8-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(one.getEntityType(), "relationship");
    }

    @Test
    public void testListRelationships() {
        Map<String, PaginatedAbstractRelationshipList> response = api.listRelationships(NEW_CLASSIFICATION_ID, draftVersion, "all", null, null, null).block();
        assertNotNull(response);
        assertTrue(response.containsKey("parent_category"));
        PaginatedAbstractRelationshipList list = response.get("parent_category");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        AbstractRelationship one = list.getResources().get(0);
        validateParentCategoryMetadata(one.getMetadata());
        AbstractRelationshipEntity oneEntity = one.getEntity();
        assertTrue(oneEntity instanceof ParentRelationshipEntity);
        validateParentCategoryEntity((ParentRelationshipEntity)oneEntity);
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
        assertTrue(response.containsKey("terms"));
        list = response.get("terms");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        one = list.getResources().get(0);
        validateTermMetadata(one.getMetadata());
        oneEntity = one.getEntity();
        assertTrue(oneEntity instanceof RelationshipEntity);
        validateTermEntity((RelationshipEntity)oneEntity);
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    @Test
    public void testDeleteRelationship() {
        GlossaryCreateResponse response = api.deleteRelationship(NEW_CLASSIFICATION_ID, draftVersion, relationshipId, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_CLASSIFICATION_ID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), "23836914-13a8-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_CLASSIFICATION_ID);
        assertEquals(one.getEntityType(), "classification");
    }

    @Test
    public void testGet() {
        PaginatedClassificationList response = api.get(NEW_CLASSIFICATION_ID, null, null, null, null, null, null).block();
        validatePaginatedList(response);
    }

    @Test
    public void testList() {
        PaginatedClassificationList response = api.list(null, null, null, null, null, null).block();
        validatePaginatedList(response);
    }

    @Test
    public void testDelete() {
        GlossaryCreateResponse response = api.delete(NEW_CLASSIFICATION_ID, publishedVersion, null, null).block();
        assertNotNull(response);
        // Note: we will have a non-null response when a workflow "marked for deletion" object is created,
        // while if this was a deletion of a workflow draft we will instead have a 200 response code and a
        // null response.
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_CLASSIFICATION_ID);
        assertEquals(one.getVersionId(), "e3e12e90-0157-4fac-977c-47bc80458447");
        assertEquals(one.getWorkflowId(), "0fec093b-13b4-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_CLASSIFICATION_ID);
        assertEquals(one.getEntityType(), "classification");
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String revision, String version) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "classification");
        assertEquals(metadata.getArtifactId(), NEW_CLASSIFICATION_ID);
        assertEquals(metadata.getVersionId(), version);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_CLASSIFICATION_ID);
        if (version.equals(draftVersion)) {
            assertEquals(metadata.getWorkflowId(), "23836914-13a8-11eb-8009-0a580a81055e");
            assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
            assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
            assertEquals(metadata.getWorkflowState(), "Not started");
        } else if (version.equals(publishedVersion)) {
            assertEquals(metadata.getDraftAncestorId(), draftVersion);
            assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
            assertNotNull(metadata.getEffectiveStartDate());
        }
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getName(), "Test Classification");
        assertEquals(metadata.getShortDescription(), "A simple classification to test the APIs.");
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertTrue(metadata.getStewardIds() == null || metadata.getStewardIds().isEmpty());
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateEntity(ResponseClassificationEntity entity, GlossaryObjectState state) {
        assertNotNull(entity);
        assertEquals(entity.getState(), state);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
    }

    private void validateParentCategoryMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), "2c3b5704-d12a-4839-af09-1b0c11e88841");
        assertEquals(metadata.getVersionId(), "96740f4a-5e51-4abb-92a2-31cc6eb48083");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_2c3b5704-d12a-4839-af09-1b0c11e88841");
        assertEquals(metadata.getWorkflowId(), "23836914-13a8-11eb-8009-0a580a81055e");
        assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateParentCategoryEntity(ParentRelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getParentId(), UNCATEGORY_ID);
        assertEquals(entity.getParentGlobalId(), REPOSITORY_ID + "_" + UNCATEGORY_ID);
        assertEquals(entity.getParentName(), "[uncategorized]");
        assertTrue(entity.getParentEnabled());
        assertEquals(entity.getChildId(), NEW_CLASSIFICATION_ID);
        assertEquals(entity.getChildGlobalId(), REPOSITORY_ID + "_" + NEW_CLASSIFICATION_ID);
        assertEquals(entity.getChildName(), "Test Classification");
        assertEquals(entity.getRelationshipType(), "parent_category");
        assertEquals(entity.getSourceType(), "classification");
        assertEquals(entity.getTargetType(), "category");
    }

    private void validateTermMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), relationshipId);
        assertEquals(metadata.getVersionId(), "2d5e33cb-4602-40b1-978d-359c62d17bcf");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(metadata.getWorkflowId(), "23836914-13a8-11eb-8009-0a580a81055e");
        assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getShortDescription(), "A new relationship via API");
        assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateTermEntity(RelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getTargetId(), "13d98203-6aad-4003-87a0-87c662c95cd1");
        assertEquals(entity.getTargetGlobalId(), REPOSITORY_ID + "_13d98203-6aad-4003-87a0-87c662c95cd1");
        assertEquals(entity.getTargetName(), "Test Term");
        assertEquals(entity.getRelationshipType(), "related");
        assertEquals(entity.getSourceType(), "classification");
        assertEquals(entity.getTargetType(), "glossary_term");
        assertEquals(entity.getDescription(), "A new relationship via API");
    }

    private void validatePaginatedList(PaginatedClassificationList response) {
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        ResponseClassification one = response.getResources().get(0);
        assertNotNull(one);
        validateMetadata(one.getMetadata(), "0", publishedVersion);
        validateEntity(one.getEntity(), GlossaryObjectState.PUBLISHED);
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getLongDescription(), "Now with a long description.");
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

}
