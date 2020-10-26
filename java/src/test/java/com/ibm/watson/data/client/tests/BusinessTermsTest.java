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
import com.ibm.watson.data.client.api.BusinessTermsApiV3;
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
 * Test the Business Terms API endpoints.
 */
public class BusinessTermsTest extends AbstractExpectations {

    private final BusinessTermsApiV3 api = new BusinessTermsApiV3(MockConstants.getApiClient());

    public BusinessTermsTest() {
        super(BusinessTermsApiV3.BASE_API, "terms");
    }

    private final Map<String, List<String>> draftParams = new HashMap<>();
    private final Map<String, List<String>> typeParams = new HashMap<>();
    private void setupParams() {
        List<String> draft = new ArrayList<>();
        draft.add("DRAFT");
        draftParams.put("status", draft);
        List<String> types = new ArrayList<>();
        types.add("classifications");
        typeParams.put("type", types);
    }

    private static final String versionId = "e0c87bc9-93eb-4c84-a3e3-e5fd309d3c6b";
    private static final String relationshipId = "34b4ace9-f337-4ec3-8689-5bf14dd71375";
    private static final String relationshipVersionId = "d58daba2-e1f3-48d8-96f0-8fc9c7a4a269";
    private static final String publishedVersionId = "acaeaa44-524e-4e94-b1f4-30eed7702686_0";

    private static final String termEndpoint = "/" + NEW_TERM_GUID;
    private static final String versionEndpoint = termEndpoint + "/versions/" + versionId;
    private static final String publishedVersionEndpoint = termEndpoint + "/versions/" + publishedVersionId;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "POST", versionEndpoint + "/relationships", "createRelationships", 201);
        setupTest(client, "DELETE", publishedVersionEndpoint, "delete", 201);
        setupTest(client, "DELETE", versionEndpoint, "deleteDraft", 200);
        setupTest(client, "DELETE", versionEndpoint + "/relationships/" + relationshipId, "deleteRelationships");
        setupTest(client, "GET", termEndpoint + "/versions", draftParams, "get");
        setupTest(client, "GET", versionEndpoint, "getVersion");
        setupTest(client, "GET", "", "list");
        setupTest(client, "GET", versionEndpoint + "/relationships", typeParams, "listRelationships");
        setupTest(client, "PATCH", versionEndpoint, "update");
    }

    @Test
    public void testCreate() {
        List<NewTermEntity> body = readRequestFromFile("create", new TypeReference<List<NewTermEntity>>() {});
        GlossaryCreateResponse response = api.create(body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_TERM_GUID);
        assertEquals(one.getVersionId(), versionId);
        assertEquals(one.getWorkflowId(), WORKFLOW_GUID);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_TERM_GUID);
        assertEquals(one.getEntityType(), "glossary_term");
    }

    @Test
    public void testGetVersion() {
        ResponseGlossaryTerm response = api.getVersion(NEW_TERM_GUID, versionId, null, null, null, null).block();
        assertNotNull(response);
        validateTermMetadata(response.getMetadata(), "0");
        validateTermEntity(response.getEntity(), "This is a new term created purely to test the API.");
    }

    @Test
    public void testGet() {
        PaginatedTermList response = api.get(NEW_TERM_GUID, "DRAFT", null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        Term one = response.getResources().get(0);
        validateTermMetadata(one.getMetadata(), "0");
        validateTermEntity(one.getEntity(), "This is a new term created purely to test the API.");
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testCreateRelationships() {
        TermRelationshipsRequest body = readRequestFromFile("createRelationships", new TypeReference<TermRelationshipsRequest>() {});
        GlossaryCreateResponse response = api.createRelationships(NEW_TERM_GUID, versionId, body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertEquals(one.getArtifactId(), relationshipId);
        assertEquals(one.getWorkflowId(), WORKFLOW_GUID);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(one.getEntityType(), "relationship");
    }

    @Test
    public void testListRelationships() {
        Map<String, PaginatedAbstractRelationshipList> response = api.listRelationships(NEW_TERM_GUID, versionId, "classifications", null, null, null).block();
        assertNotNull(response);
        PaginatedAbstractRelationshipList one = response.get("classifications");
        assertNotNull(one);
        assertEquals(one.getOffset(), Integer.valueOf(0));
        assertNotNull(one.getLast());
        assertNotNull(one.getLast().getHref());
        assertNotNull(one.getResources());
        assertEquals(one.getResources().size(), 1);
        AbstractRelationship two = one.getResources().get(0);
        assertNotNull(two.getMetadata());
        assertEquals(two.getMetadata().getArtifactType(), "relationship");
        assertEquals(two.getMetadata().getArtifactId(), relationshipId);
        assertEquals(two.getMetadata().getVersionId(), relationshipVersionId);
        assertEquals(two.getMetadata().getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(two.getMetadata().getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(two.getMetadata().getWorkflowId(), WORKFLOW_GUID);
        assertEquals(two.getMetadata().getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(two.getMetadata().getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(two.getMetadata().getCreatedAt());
        assertEquals(two.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(two.getMetadata().getModifiedAt());
        assertEquals(two.getMetadata().getRevision(), "0");
        assertEquals(two.getMetadata().getState(), GlossaryObjectState.DRAFT);
        assertFalse(two.getMetadata().getReadOnly());
        assertFalse(two.getMetadata().getRemoveStartDate());
        assertFalse(two.getMetadata().getRemoveEndDate());
        assertNotNull(two.getEntity());
        RelationshipEntity entity = (RelationshipEntity) two.getEntity();
        assertNotNull(entity);
        assertEquals(entity.getTargetId(), "d5678989-476e-4c1c-ba94-4396e5c95567");
        assertEquals(entity.getTargetGlobalId(), REPOSITORY_ID + "_d5678989-476e-4c1c-ba94-4396e5c95567");
        assertEquals(entity.getTargetName(), "Confidential");
        assertEquals(entity.getRelationshipType(), "related");
        assertEquals(entity.getSourceType(), "glossary_term");
        assertEquals(entity.getTargetType(), "classification");
        assertEquals(one.getLimit(), Integer.valueOf(10));
        assertEquals(one.getCount(), Long.valueOf(1L));
        assertNotNull(one.getFirst());
        assertNotNull(one.getFirst().getHref());
    }

    @Test
    public void testDeleteRelationships() {
        GlossaryCreateResponse response = api.deleteRelationships(NEW_TERM_GUID, versionId, relationshipId, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_TERM_GUID);
        assertEquals(one.getVersionId(), versionId);
        assertEquals(one.getWorkflowId(), WORKFLOW_GUID);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_TERM_GUID);
        assertEquals(one.getEntityType(), "glossary_term");
    }

    @Test
    public void testUpdate() {
        UpdatableTermEntity body = readRequestFromFile("update", new TypeReference<UpdatableTermEntity>() {});
        ResponseGlossaryTerm response = api.update(NEW_TERM_GUID, versionId, body, null, null, null).block();
        assertNotNull(response);
        validateTermMetadata(response.getMetadata(), "1");
        validateTermEntity(response.getEntity(), "This is an updated term description.");
    }

    @Test
    public void testList() {
        PaginatedTermList response = api.list(null, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        Term one = response.getResources().get(0);
        assertNotNull(one);
        validateTermMetadata(one.getMetadata(), "0", publishedVersionId, GlossaryObjectState.PUBLISHED);
        validateTermEntity(one.getEntity(), "This is an updated term description.", GlossaryObjectState.PUBLISHED);
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testDeletePublished() {
        GlossaryCreateResponse response = api.delete(NEW_TERM_GUID, publishedVersionId, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_TERM_GUID);
        assertEquals(one.getVersionId(), "07bb1caa-cfc4-4a14-ae45-0629b13b74fb");
        assertEquals(one.getWorkflowId(), "66ae48f2-e15c-11ea-8c06-0a580a810041");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_TERM_GUID);
        assertEquals(one.getEntityType(), "glossary_term");
    }

    @Test
    public void testDeleteDraft() {
        GlossaryCreateResponse response = api.delete(NEW_TERM_GUID, versionId, null, null).block();
        assertNull(response);
    }

    private void validateTermMetadata(GlossaryObjectMetadata metadata, String revision) {
        validateTermMetadata(metadata, revision, versionId, GlossaryObjectState.DRAFT);
    }

    private void validateTermMetadata(GlossaryObjectMetadata metadata, String revision, String version, GlossaryObjectState state) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "glossary_term");
        assertEquals(metadata.getArtifactId(), NEW_TERM_GUID);
        assertEquals(metadata.getVersionId(), version);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_TERM_GUID);
        String ancestor = metadata.getDraftAncestorId();
        if (ancestor == null) {
            assertEquals(metadata.getWorkflowId(), WORKFLOW_GUID);
            assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
            assertNotNull(metadata.getStewardIds());
            assertEquals(metadata.getStewardIds().size(), 0);
            assertEquals(metadata.getWorkflowState(), "Not started");
        } else {
            assertEquals(ancestor, versionId);
        }
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getName(), "Test Term");
        assertEquals(metadata.getShortDescription(), "A new term to test the API.");
        assertEquals(metadata.getState(), state);
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateTermEntity(ResponseTermEntity entity, String description) {
        validateTermEntity(entity, description, GlossaryObjectState.DRAFT);
    }

    private void validateTermEntity(ResponseTermEntity entity, String description, GlossaryObjectState state) {
        assertNotNull(entity);
        assertEquals(entity.getAbbreviation(), "TT");
        assertNotNull(entity.getAbbreviations());
        assertEquals(entity.getAbbreviations().size(), 1);
        assertEquals(entity.getAbbreviations().get(0), "TT");
        assertEquals(entity.getLongDescription(), description);
        assertEquals(entity.getState(), state);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertNotNull(entity.getCustomAttributes());
        assertEquals(entity.getCustomAttributes().size(), 1);
        CustomAttribute one = entity.getCustomAttributes().get(0);
        assertNotNull(one);
        assertEquals(one.getCustomAttributeDefinitionId(), "8a0b793d-5f40-4c4e-8a2e-ae05f23cf4f4");
        assertEquals(one.getName(), "My Custom Attribute 1");
        assertNotNull(one.getValues());
        assertEquals(one.getValues().size(), 0);
    }

}