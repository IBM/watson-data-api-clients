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
import com.ibm.watson.data.client.api.PoliciesApiV3;
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
 * Test the Policies API endpoints.
 */
public class PoliciesTest extends AbstractExpectations {

    private final PoliciesApiV3 api = new PoliciesApiV3(MockConstants.getApiClient());

    public PoliciesTest() {
        super(PoliciesApiV3.BASE_API, "policies");
    }

    private static final String policyEndpoint = "/" + NEW_POLICY_GUID;
    private static final String versionId = "7125313f-8694-4494-a9b4-ef5970d0bec3";
    private static final String publishedVersion = "3d297087-3e85-4fb9-bc54-2677a9313884_0";
    private static final String policyVersionEndpoint = policyEndpoint + "/versions/" + versionId;
    private static final String publishedVersionEndpoint = policyEndpoint + "/versions/" + publishedVersion;
    private static final String relationshipId = "66c89cd6-5fa1-4172-a2c3-dd1956e0ee84";

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
        setupTest(client, "DELETE", publishedVersionEndpoint, "delete", 201);
        setupTest(client, "DELETE", publishedVersionEndpoint + "/relationships/" + relationshipId, "deleteRelationship");
        setupTest(client, "GET", policyEndpoint + "/versions", "get");
        setupTest(client, "GET", policyVersionEndpoint, "getVersion");
        setupTest(client, "GET", publishedVersionEndpoint + "/relationships", typeParams, "listRelationships");
        setupTest(client, "PATCH", policyVersionEndpoint, "update");
        setupTest(client, "PATCH", publishedVersionEndpoint + "/data_protection_rules", "updateDataProtectionRuleRelationships");
    }

    @Test
    public void testCreate() {
        NewPolicyEntity body = readRequestFromFile("create", new TypeReference<NewPolicyEntity>() {});
        GlossaryCreateResponse response = api.create(body, true, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_POLICY_GUID);
        assertEquals(one.getVersionId(), versionId);
        assertEquals(one.getWorkflowId(), "8e0c5fa6-12dd-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_POLICY_GUID);
        assertEquals(one.getEntityType(), "policy");
    }

    @Test
    public void testGetVersion() {
        ResponsePolicy response = api.getVersion(NEW_POLICY_GUID, versionId, null, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata());
        validateEntity(response.getEntity(), GlossaryObjectState.DRAFT);
    }

    @Test
    public void testUpdate() {
        UpdatablePolicyEntity body = readRequestFromFile("update", new TypeReference<UpdatablePolicyEntity>() {});
        ResponsePolicy response = api.update(NEW_POLICY_GUID, versionId, body, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), "1");
        validateEntity(response.getEntity(), GlossaryObjectState.DRAFT);
        assertNotNull(response.getEntity());
        assertEquals(response.getEntity().getLongDescription(), "Now with a long description.");
    }

    @Test
    public void testGet() {
        PaginatedPolicyList response = api.get(NEW_POLICY_GUID, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        ResponsePolicy one = response.getResources().get(0);
        assertNotNull(one);
        validateMetadata(one.getMetadata(), "0", publishedVersion);
        validateEntity(one.getEntity(), GlossaryObjectState.PUBLISHED);
        assertNotNull(one.getEntity());
        validateParentCategory(one.getEntity().getParentCategory());
        validateRetParentCategory(one.getEntity().getRetParentCategoryRelationship());
        assertEquals(one.getEntity().getLongDescription(), "Now with a long description.");
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testUpdateDataProtectionRuleRelationships() {
        List<NewRelationship> body = readRequestFromFile("updateDataProtectionRuleRelationships", new TypeReference<List<NewRelationship>>() {});
        ResponsePolicy response = api.updateDataProtectionRuleRelationships(NEW_POLICY_GUID, publishedVersion, body, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), "0", publishedVersion);
        assertNotNull(response.getMetadata());
        assertEquals(response.getMetadata().getDraftAncestorId(), versionId);
        validateEntity(response.getEntity(), GlossaryObjectState.PUBLISHED);
        assertNotNull(response.getEntity());
        assertEquals(response.getEntity().getLongDescription(), "Now with a long description.");
        validateParentCategory(response.getEntity().getParentCategory());
        validateRetParentCategory(response.getEntity().getRetParentCategoryRelationship());
        validateDataProtectionRules(response.getEntity().getDataProtectionRules());
    }

    @Test
    public void testListRelationships() {
        Map<String, PaginatedAbstractRelationshipList> response = api.listRelationships(NEW_POLICY_GUID, publishedVersion, "all", null, null).block();
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
        assertTrue(response.containsKey("data_protection_rules"));
        list = response.get("data_protection_rules");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        one = list.getResources().get(0);
        validateDataProtectionRuleMetadata(one.getMetadata());
        oneEntity = one.getEntity();
        assertTrue(oneEntity instanceof RelationshipEntity);
        validateDataProtectionRuleEntity((RelationshipEntity)oneEntity);
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    @Test
    public void testDeleteRelationship() {
        GlossaryCreateResponse response = api.deleteRelationship(NEW_POLICY_GUID, "3d297087-3e85-4fb9-bc54-2677a9313884_0", relationshipId, null, null).block();
        assertNotNull(response);
        // Note: it seems that data protection rule relationships cannot be deleted (gives 500 response),
        // so this is just some other rule relationship we tested deleting
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_POLICY_GUID);
        assertEquals(one.getVersionId(), "bc321d0f-1ae4-45d7-a1dc-f12f59db5b44");
        assertEquals(one.getWorkflowId(), "404c6c02-139f-11eb-8009-0a580a81055e");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_POLICY_GUID);
        assertEquals(one.getEntityType(), "policy");
    }

    @Test
    public void testDelete() {
        ResponsePolicy response = api.delete(NEW_POLICY_GUID, publishedVersion, null, null).block();
        assertNotNull(response);
        // Note: we will have a non-null response when a workflow "marked for deletion" object is created,
        // while if this was a deletion of a workflow draft we will instead have a 200 response code and a
        // null response.
        validateMetadata(response.getMetadata(), "0", "9e8a14d9-8709-48b5-9167-6536a5905c81");
        validateEntity(response.getEntity(), GlossaryObjectState.DRAFT);
    }

    private void validateMetadata(GlossaryObjectMetadata metadata) {
        validateMetadata(metadata, "0");
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String revision) {
        validateMetadata(metadata, revision, versionId);
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String revision, String version) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "policy");
        assertEquals(metadata.getArtifactId(), NEW_POLICY_GUID);
        assertEquals(metadata.getVersionId(), version);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_POLICY_GUID);
        if (version.equals(versionId)) {
            assertEquals(metadata.getWorkflowId(), "8e0c5fa6-12dd-11eb-8009-0a580a81055e");
            assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
            assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
            assertEquals(metadata.getWorkflowState(), "Not started");
        } else if (version.equals(publishedVersion)) {
            assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
        } else {
            assertEquals(metadata.getWorkflowId(), "678c3963-13a0-11eb-8009-0a580a81055e");
            assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.MARKED_FOR_DELETION);
            assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
            assertEquals(metadata.getWorkflowState(), "Marked for deletion");
        }
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getName(), "Test Policy");
        assertEquals(metadata.getShortDescription(), "A simple policy to test the APIs.");
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertNotNull(metadata.getStewardIds());
        assertEquals(metadata.getStewardIds().size(), 0);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateEntity(ResponsePolicyEntity entity, GlossaryObjectState state) {
        assertNotNull(entity);
        assertEquals(entity.getState(), state);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertTrue(entity.getStewardIds() == null || (entity.getStewardIds() != null && entity.getStewardIds().isEmpty()));
        assertNotNull(entity.getCustomAttributes());
        assertEquals(entity.getCustomAttributes().size(), 0);
    }

    private void validateParentCategory(RelationshipParentRelationshipEntity parent) {
        assertNotNull(parent);
        validateParentCategoryMetadata(parent.getMetadata());
        validateParentCategoryEntity(parent.getEntity());
    }

    private void validateParentCategoryMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), "b515de37-e20a-4aba-b75e-5638c7f93e6f");
        assertEquals(metadata.getVersionId(), "c27e0a5f-7574-4891-a663-8bd9454cb10e_0");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + "b515de37-e20a-4aba-b75e-5638c7f93e6f");
        assertNotNull(metadata.getEffectiveStartDate());
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateParentCategoryEntity(ParentRelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getParentId(), UNCATEGORY_ID);
        assertEquals(entity.getParentGlobalId(), REPOSITORY_ID + "_" + UNCATEGORY_ID);
        assertEquals(entity.getParentName(), "[uncategorized]");
        //assertNotNull(entity.getParentHref());
        assertTrue(entity.getParentEnabled());
        assertEquals(entity.getChildId(), NEW_POLICY_GUID);
        assertEquals(entity.getChildGlobalId(), REPOSITORY_ID + "_" + NEW_POLICY_GUID);
        assertEquals(entity.getChildName(), "Test Policy");
        //assertNotNull(entity.getChildHref());
        assertEquals(entity.getRelationshipType(), "parent_category");
        assertEquals(entity.getSourceType(), "policy");
        assertEquals(entity.getTargetType(), "category");
    }

    private void validateRetParentCategory(PaginatedParentRelationshipsList list) {
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        validateParentCategory(list.getResources().get(0));
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    private void validateDataProtectionRules(PaginatedRelationshipsList list) {
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        RelationshipRelationshipEntity one = list.getResources().get(0);
        assertNotNull(one);
        validateDataProtectionRuleMetadata(one.getMetadata());
        validateDataProtectionRuleEntity(one.getEntity());
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    private void validateDataProtectionRuleMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), "580199f4-7cf9-47bf-a46f-2e514111e12d");
        assertEquals(metadata.getVersionId(), "cab1c91a-fbaf-4dd7-8539-b6668499b55d_0");
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateDataProtectionRuleEntity(RelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getTargetGlobalId(), NEW_DP_RULE_ID);
        assertEquals(entity.getRelationshipType(), "related_assets");
        assertEquals(entity.getSourceType(), "policy");
        assertEquals(entity.getTargetType(), "all");
    }

}
