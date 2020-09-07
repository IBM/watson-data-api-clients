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
 * Test the Categories API endpoints.
 */
public class CategoriesTest extends AbstractExpectations {

    private final CategoriesApiV3 api = new CategoriesApiV3(MockConstants.getApiClient());

    public CategoriesTest() {
        super(CategoriesApiV3.BASE_API, "categories");
    }

    private final Map<String, List<String>> categoryParams = new HashMap<>();
    private void setupParams() {
        List<String> categories = new ArrayList<>();
        categories.add(NEW_CATEGORY_ID);
        categoryParams.put("category_id", categories);
    }

    private static final String categoryEndpoint = "/" + NEW_CATEGORY_ID;
    private static final String artifactEndpoint = categoryEndpoint + "/artifacts/" + NEW_TERM_GUID;

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
        CreateCategoryResponse response = api.create(body, null).block();
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