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
import com.ibm.watson.data.client.api.CategoriesApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.BootstrapState;
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;
import com.ibm.watson.data.client.model.enums.UserType;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Categories API endpoints.
 */
public class CategoriesTest extends AbstractExpectations {

    private final CategoriesApiV3 api = new CategoriesApiV3(MockConstants.getApiClient());

    public CategoriesTest() {
        super(CategoriesApiV3.BASE_API, "categories");
    }

    private final Map<String, List<String>> categoryParams = new HashMap<>();
    private final Map<String, List<String>> relationshipParams = new HashMap<>();
    private void setupParams() {
        List<String> categories = new ArrayList<>();
        categories.add(NEW_CATEGORY_ID);
        categoryParams.put("category_id", categories);
        List<String> relationships = new ArrayList<>();
        relationships.add("parent_category");
        relationshipParams.put("type", relationships);
    }

    private static final String categoryEndpoint = "/" + NEW_CATEGORY_ID;
    private static final String artifactEndpoint = categoryEndpoint + "/artifacts/" + NEW_TERM_GUID;

    private static final String collaboratorId = "6b86df2d-b611-41c2-9cc6-c6f1e72c94bd";

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "PUT", artifactEndpoint, "addArtifact", 201);
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "DELETE", artifactEndpoint, "removeArtifact", 204);
        setupTest(client, "DELETE", categoryEndpoint, "delete");
        setupTest(client, "GET", categoryEndpoint, "get");
        setupTest(client, "GET", "/hierarchy", "getHierarchyPaths");
        setupTest(client, "GET", "/uncategorized", "getUncategorizedCategory");
        setupTest(client, "PATCH", categoryEndpoint, "update");
        // v3.5 additions
        setupTest(client, "POST", "/collaborators/bootstrap", "startBootstrap", 202);
        setupTest(client, "GET", categoryEndpoint + "/collaborators", "getCollaborators");
        setupTest(client, "GET", "/collaborators/bootstrap/status", "getBootstrapStatus");
        setupTest(client, "POST", "/relationships/search", relationshipParams, "findRelationships");
        setupTest(client, "POST", categoryEndpoint + "/collaborators", "createCollaborator", 201);
        setupTest(client, "DELETE", categoryEndpoint + "/collaborators/" + collaboratorId, "deleteCollaborator", 204);
    }

    @Test
    public void testDeleteCollaborator() {
        api.deleteCollaborator(NEW_CATEGORY_ID, collaboratorId, null).block();
    }

    @Test
    public void testCreateCollaborator() {
        NewRoleAssignment body = readRequestFromFile("createCollaborator", new TypeReference<NewRoleAssignment>() {});
        RoleAssignment response = api.createCollaborator(NEW_CATEGORY_ID, body, null).block();
        assertNotNull(response);
        assertEquals(response.getCategoryArtifactId(), NEW_CATEGORY_ID);
        assertEquals(response.getCategoryName(), "Test Category");
        assertEquals(response.getRole(), "viewer");
        assertEquals(response.getPrincipalId(), "1000331002");
        assertEquals(response.getId(), collaboratorId);
        assertEquals(response.getDpsRuleId(), "d8dca78e-435b-477d-b7f4-637890324b2d_0011");
        assertEquals(response.getUserType(), UserType.USER);
        assertNotNull(response.getCreateTime());
    }

    @Test
    public void testFindRelationships() {
        GlossaryResourceList body = readRequestFromFile("findRelationships", new TypeReference<GlossaryResourceList>() {});
        ArtifactRelationshipsResponse response = api.findRelationships("parent_category", body, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getArtifacts());
        assertEquals(response.getArtifacts().size(), 1);
        ArtifactRelationships ar = response.getArtifacts().get(0);
        assertEquals(ar.getArtifactId(), "77270aa6-a1c3-4cba-b190-9f5daa9edf43");
        assertNotNull(ar.getRelationships());
        assertEquals(ar.getRelationships().size(), 1);
        assertTrue(ar.getRelationships().containsKey("parent_category"));
        PaginatedAbstractRelationshipList list = ar.getRelationships().get("parent_category");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        AbstractRelationship one = list.getResources().get(0);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getArtifactType(), "relationship");
        assertEquals(one.getMetadata().getArtifactId(), "0b9123ed-2b22-4f30-a382-47d1e62803b0");
        assertEquals(one.getMetadata().getVersionId(), "0e762683-c717-4362-953e-aa6b235cc401_0");
        assertEquals(one.getMetadata().getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(one.getMetadata().getGlobalId(), REPOSITORY_ID + "_0b9123ed-2b22-4f30-a382-47d1e62803b0");
        assertEquals(one.getMetadata().getCreatedBy(), "1000331001");
        assertNotNull(one.getMetadata().getCreatedAt());
        assertEquals(one.getMetadata().getModifiedBy(), "1000331001");
        assertNotNull(one.getMetadata().getModifiedAt());
        assertEquals(one.getMetadata().getRevision(), "0");
        assertEquals(one.getMetadata().getState(), GlossaryObjectState.PUBLISHED);
        assertFalse(one.getMetadata().getReadOnly());
        assertFalse(one.getMetadata().getRemoveStartDate());
        assertFalse(one.getMetadata().getRemoveEndDate());
        assertTrue(one.getMetadata().getUserAccess());
        AbstractRelationshipEntity entity = one.getEntity();
        assertTrue(entity instanceof ParentRelationshipEntity);
        ParentRelationshipEntity pre = (ParentRelationshipEntity) entity;
        assertEquals(pre.getParentId(), "7a75da89-be07-44fc-9a3d-103ac6e1cd18");
        assertEquals(pre.getParentName(), "Samples");
        assertTrue(pre.getParentEnabled());
        assertEquals(pre.getChildId(), "77270aa6-a1c3-4cba-b190-9f5daa9edf43");
        assertEquals(pre.getChildCategoryId(), "7a75da89-be07-44fc-9a3d-103ac6e1cd18");
        assertEquals(pre.getChildName(), "Banking");
        assertEquals(pre.getRelationshipType(), "parent_category");
        assertEquals(pre.getSourceType(), "category");
        assertEquals(pre.getTargetType(), "category");
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    @Test
    public void testGetBootstrapStatus() {
        BootstrapStatus response = api.getBootstrapStatus(null).block();
        assertNotNull(response);
        assertEquals(response.getStatus(), BootstrapState.SUCCEEDED);
        assertEquals(response.getCompletionMessage(), "Bootstrap process completed");
        assertEquals(response.getCompletedRecords(), Integer.valueOf(3));
        assertEquals(response.getTotalRecords(), Integer.valueOf(3));
    }

    @Test
    public void testGetCollaborators() {
        RoleAssignmentResponse response = api.getCollaborators(NEW_CATEGORY_ID, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalResults(), Integer.valueOf(2));
        assertNotNull(response.getCollaborators());
        assertEquals(response.getCollaborators().size(), 2);
        RoleAssignment one = response.getCollaborators().get(0);
        assertEquals(one.getCategoryArtifactId(), NEW_CATEGORY_ID);
        assertEquals(one.getCategoryName(), "Test Category");
        assertEquals(one.getRole(), "owner");
        assertEquals(one.getPrincipalId(), "1000331001");
        assertEquals(one.getId(), "2c1a5978-4b74-4d44-b0f7-d8a6f369247c");
        assertEquals(one.getDpsRuleId(), "4d550e27-7eb1-4170-89e9-cc8e318f3f7d_0001");
        assertEquals(one.getUserType(), UserType.USER);
        assertNotNull(one.getCreateTime());
        one = response.getCollaborators().get(1);
        assertEquals(one.getCategoryArtifactId(), NEW_CATEGORY_ID);
        assertEquals(one.getCategoryName(), "Test Category");
        assertEquals(one.getRole(), "viewer");
        assertEquals(one.getPrincipalId(), EXSTUSER_GUID);
        assertEquals(one.getId(), "7626efde-f531-4f34-b854-364e7c7a1af0");
        assertEquals(one.getDpsRuleId(), "5c1a3b88-842d-485e-ad9a-d26e03da0cd9_0011");
        assertEquals(one.getUserType(), UserType.USER);
        assertNotNull(one.getCreateTime());
    }

    @Test
    public void testStartBootstrap() {
        api.startBoostrap(null).block();
    }

    @Test
    public void testGetUncategorizedCategory() {
        Category response = api.getUncategorizedCategory(null).block();
        assertNotNull(response);
        GlossaryObjectMetadata metadata = response.getMetadata();
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "category");
        assertEquals(metadata.getArtifactId(), UNCATEGORY_ID);
        assertEquals(metadata.getVersionId(), "cb043e08-2123-43eb-ac3c-a39d76baad62_0");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + UNCATEGORY_ID);
        assertEquals(metadata.getCreatedBy(), "storage-admin");
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), "storage-admin");
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getName(), "[uncategorized]");
        assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
        CategoryEntity entity = response.getEntity();
        assertNotNull(entity);
        assertEquals(entity.getLongDescription(), "This is the system default if a standard category is not assigned.");
        assertEquals(entity.getState(), GlossaryObjectState.PUBLISHED);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertNotNull(entity.getCustomAttributes());
        assertEquals(entity.getCustomAttributes().size(), 0);
    }

    @Test
    public void testCreate() {
        NewCategoryEntity body = readRequestFromFile("create", new TypeReference<NewCategoryEntity>() {});
        GlossaryCreateResponse response = api.create(body, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_CATEGORY_ID);
        assertEquals(one.getVersionId(), "25e2e3ea-593e-4dbd-966e-342e4014e7d7");
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_CATEGORY_ID);
        assertEquals(one.getEntityType(), "category");
    }

    @Test
    public void testGet() {
        Category response = api.get(NEW_CATEGORY_ID, null).block();
        assertNotNull(response);
        GlossaryObjectMetadata metadata = response.getMetadata();
        validateCategoryMetadata(metadata, "0", "This is a basic category for testing APIs.");
        assertNotNull(metadata);
        assertNotNull(metadata.getStewardIds());
        assertEquals(metadata.getStewardIds().size(), 0);
        CategoryEntity entity = response.getEntity();
        validateCategoryEntity(entity);
        assertNotNull(entity);
        assertNotNull(entity.getHasTypesCategoryRels());
        assertEquals(entity.getHasTypesCategoryRels().size(), 0);
        assertNotNull(entity.getGroupedAssetsRels());
        assertEquals(entity.getGroupedAssetsRels().size(), 0);
        assertNotNull(entity.getParentCategoryFor());
        assertEquals(entity.getParentCategoryFor().size(), 0);
    }

    @Test
    public void testGetHierarchyPaths() {
        List<String> body = new ArrayList<>();
        body.add(NEW_CATEGORY_ID);
        CategoryHierarchyResponse response = api.getHierarchyPaths(body, null).block();
        assertNotNull(response);
        assertNotNull(response.getCategoryHierarchyPaths());
        assertEquals(response.getCategoryHierarchyPaths().size(), 1);
        CategoryHierarchyPath one = response.getCategoryHierarchyPaths().get(0);
        assertNotNull(one);
        assertEquals(one.getCategoryId(), NEW_CATEGORY_ID);
        assertNotNull(one.getCategoryHierarchyPath());
        assertEquals(one.getCategoryHierarchyPath().size(), 0);
    }

    @Test
    public void testAddArtifact() {
        NewCategoryAssignment body = readRequestFromFile("addArtifact", new TypeReference<NewCategoryAssignment>() {});
        NewCategoryAssignment response = api.addArtifact(NEW_CATEGORY_ID, NEW_TERM_GUID, body, null).block();
        assertNotNull(response);
        assertTrue(response.getIsPrimaryCategory());
        assertEquals(response.getArtifactType(), "glossary_term");
    }

    @Test
    public void testRemoveArtifact() {
        api.removeArtifact(NEW_CATEGORY_ID, NEW_TERM_GUID, null).block();
    }

    @Test
    public void testUpdate() {
        NewCategoryEntity body = readRequestFromFile("update", new TypeReference<NewCategoryEntity>() {});
        Category response = api.update(NEW_CATEGORY_ID, body, null).block();
        assertNotNull(response);
        validateCategoryMetadata(response.getMetadata(), "1", "This is an updated description.");
        validateCategoryEntity(response.getEntity());
    }

    @Test
    public void testDelete() {
        GlossaryArchiveResponse response = api.delete(NEW_CATEGORY_ID, null).block();
        assertNotNull(response);
        assertNotNull(response.getArchivedGuids());
        assertEquals(response.getArchivedGuids().size(), 0);
        assertNotNull(response.getUpdatedGuids());
        assertEquals(response.getUpdatedGuids().size(), 0);
        assertNotNull(response.getDeleteGuids());
        assertEquals(response.getDeleteGuids().size(), 1);
        assertEquals(response.getDeleteGuids().get(0), NEW_CATEGORY_ID);
    }

    private void validateCategoryMetadata(GlossaryObjectMetadata metadata, String revision, String description) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "category");
        assertEquals(metadata.getArtifactId(), NEW_CATEGORY_ID);
        assertEquals(metadata.getVersionId(), "25e2e3ea-593e-4dbd-966e-342e4014e7d7_" + revision);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_CATEGORY_ID);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getName(), "Test Category");
        assertEquals(metadata.getShortDescription(), description);
        assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateCategoryEntity(CategoryEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getState(), GlossaryObjectState.PUBLISHED);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertNotNull(entity.getCustomAttributes());
        assertEquals(entity.getCustomAttributes().size(), 0);
    }

}