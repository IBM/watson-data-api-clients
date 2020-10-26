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
import com.ibm.watson.data.client.api.RulesApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.GlossaryObjectDraftMode;
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;
import com.ibm.watson.data.client.model.enums.RuleType;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Rules API endpoints.
 */
public class RulesTest extends AbstractExpectations {

    private final RulesApiV3 api = new RulesApiV3(MockConstants.getApiClient());

    public RulesTest() {
        super(RulesApiV3.BASE_API, "rules");
    }

    private static final String ruleEndpoint = "/" + NEW_RULE_GUID;
    private static final String draftVersion = "e4c8a972-2016-4001-bc43-bfaac3553a99";
    private static final String draftEndpoint = ruleEndpoint + "/versions/" + draftVersion;
    private static final String relationshipId = "2f5e02bb-1e65-4de1-8ad7-5f697ce8d6a4";

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
        setupTest(client, "DELETE", draftEndpoint, "delete");
        setupTest(client, "DELETE", draftEndpoint + "/relationships/" + relationshipId, "deleteRelationship");
        setupTest(client, "GET", draftEndpoint, "get");
        setupTest(client, "GET", draftEndpoint + "/relationships", typeParams, "listRelationships");
        setupTest(client, "PATCH", draftEndpoint, "update");
    }

    @Test
    public void testCreate() {
        NewRuleEntity body = readRequestFromFile("create", new TypeReference<NewRuleEntity>() {});
        GlossaryCreateResponse response = api.create(body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_RULE_GUID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), "6c932425-1391-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_RULE_GUID);
        assertEquals(one.getEntityType(), "rule");
    }

    @Test
    public void testGet() {
        ResponseRule response = api.get(NEW_RULE_GUID, draftVersion, null, null, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), "0");
        validateEntity(response.getEntity());
    }

    @Test
    public void testUpdate() {
        UpdatableRuleEntity body = readRequestFromFile("update", new TypeReference<UpdatableRuleEntity>() {});
        ResponseRule response = api.update(NEW_RULE_GUID, draftVersion, body, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata());
        validateEntity(response.getEntity());
        assertNotNull(response.getEntity());
        assertEquals(response.getEntity().getLongDescription(), "Now with a long description.");
    }

    @Test
    public void testCreateRelationships() {
        RuleRelationshipsRequest body = readRequestFromFile("createRelationships", new TypeReference<RuleRelationshipsRequest>() {});
        GlossaryCreateResponse response = api.createRelationships(NEW_RULE_GUID, draftVersion, body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertEquals(one.getArtifactId(), relationshipId);
        assertEquals(one.getWorkflowId(), "6c932425-1391-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(one.getEntityType(), "relationship");
    }

    @Test
    public void testListRelationships() {
        Map<String, PaginatedAbstractRelationshipList> response = api.listRelationships(NEW_RULE_GUID, draftVersion, "all", null, null, null).block();
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
        assertTrue(response.containsKey("policies"));
        list = response.get("policies");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        one = list.getResources().get(0);
        validatePolicyMetadata(one.getMetadata());
        oneEntity = one.getEntity();
        assertTrue(oneEntity instanceof RelationshipEntity);
        validatePolicyEntity((RelationshipEntity)oneEntity);
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    @Test
    public void testDeleteRelationship() {
        GlossaryCreateResponse response = api.deleteRelationship(NEW_RULE_GUID, draftVersion, relationshipId, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_RULE_GUID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), "6c932425-1391-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_RULE_GUID);
        assertEquals(one.getEntityType(), "rule");
    }

    @Test
    public void testDelete() {
        api.delete(NEW_RULE_GUID, draftVersion, null, null).block();
    }

    private void validateMetadata(GlossaryObjectMetadata metadata) {
        validateMetadata(metadata, "1");
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String revision) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "rule");
        assertEquals(metadata.getArtifactId(), NEW_RULE_GUID);
        assertEquals(metadata.getVersionId(), draftVersion);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_RULE_GUID);
        assertEquals(metadata.getWorkflowId(), "6c932425-1391-11eb-8009-0a580a81055e");
        assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(metadata.getWorkflowState(), "Not started");
        assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getName(), "Test Rule");
        assertEquals(metadata.getShortDescription(), "A simple rule to test the APIs.");
        assertNotNull(metadata.getTags());
        assertTrue(metadata.getTags().isEmpty());
        assertNotNull(metadata.getStewardIds());
        assertTrue(metadata.getStewardIds().isEmpty());
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateEntity(ResponseRuleEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getRuleType(), RuleType.GOVERNANCE);
        assertEquals(entity.getState(), GlossaryObjectState.DRAFT);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertNotNull(entity.getCustomAttributes());
        assertTrue(entity.getCustomAttributes().isEmpty());
    }

    private void validateParentCategoryMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), "1f4d20b3-4547-44e6-970a-ef599525443d");
        assertEquals(metadata.getVersionId(), "8d6ed6a0-66eb-4564-aee7-f88a909481c1");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_1f4d20b3-4547-44e6-970a-ef599525443d");
        assertEquals(metadata.getWorkflowId(), "6c932425-1391-11eb-8009-0a580a81055e");
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
        assertEquals(entity.getChildId(), NEW_RULE_GUID);
        assertEquals(entity.getChildGlobalId(), REPOSITORY_ID + "_" + NEW_RULE_GUID);
        assertEquals(entity.getChildName(), "Test Rule");
        assertEquals(entity.getRelationshipType(), "parent_category");
        assertEquals(entity.getSourceType(), "rule");
        assertEquals(entity.getTargetType(), "category");
    }

    private void validatePolicyMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), relationshipId);
        assertEquals(metadata.getVersionId(), "069ca9ec-4b96-40d2-8da5-3417949d45bb");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(metadata.getWorkflowId(), "6c932425-1391-11eb-8009-0a580a81055e");
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

    private void validatePolicyEntity(RelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getTargetId(), NEW_POLICY_GUID);
        assertEquals(entity.getTargetGlobalId(), REPOSITORY_ID + "_" + NEW_POLICY_GUID);
        assertEquals(entity.getTargetName(), "Test Policy");
        assertEquals(entity.getRelationshipType(), "related");
        assertEquals(entity.getSourceType(), "rule");
        assertEquals(entity.getTargetType(), "policy");
        assertEquals(entity.getDescription(), "A new relationship via API");
    }

}
