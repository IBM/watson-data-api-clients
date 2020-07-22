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

import com.ibm.watson.data.client.api.CatalogsApiV2;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.Catalog;
import com.ibm.watson.data.client.model.CatalogEntity;
import com.ibm.watson.data.client.model.Catalogs;
import com.ibm.watson.data.client.model.JSONResourcePatchModel;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Test the Catalog API endpoints.
 */
public class CatalogTest {

    private CatalogsApiV2 api;

    private static final String createdName = "Test Catalog";
    private static final String createdDesc = "A test catalog to validate the API client works as expected.";
    private static final String createdGen  = "API-Test-Suite";

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new CatalogsApiV2(MockConstants.getApiClient());
    }

    /**
     * Test retrieval of the default (OMRS-synced) catalog.
     */
    @Test
    public void testGetDefault() {
        Catalog omrsCatalog = api.getCatalogOnOmrsOneCatalogCohort().block();
        assertNotNull(omrsCatalog);
        assertNotNull(omrsCatalog.getEntity());
        assertEquals(omrsCatalog.getEntity().getName(), "Default Catalog");
    }

    /**
     * Test creation of a catalog.
     */
    @Test
    public void testCreate() {
        CatalogEntity body = new CatalogEntity();
        body.setName(createdName);
        body.setDescription(createdDesc);
        body.setGenerator(createdGen);
        body.setIsGoverned(true);
        Catalog created = api.create(body, false).block();
        assertNotNull(created);
        assertNotNull(created.getMetadata());
        assertEquals(created.getMetadata().getGuid(), MockConstants.CATALOG_GUID);
        assertNotNull(created.getEntity());
        assertEquals(created.getEntity().getName(), createdName);
        assertEquals(created.getEntity().getDescription(), createdDesc);
    }

    /**
     * Test retrieval of a catalog.
     */
    @Test
    public void testGet() {
        Catalog catalog = api.get(MockConstants.CATALOG_GUID).block();
        assertNotNull(catalog);
        assertNotNull(catalog.getMetadata());
        assertEquals(catalog.getMetadata().getGuid(), MockConstants.CATALOG_GUID);
        assertNotNull(catalog.getEntity());
        assertEquals(catalog.getEntity().getName(), createdName);
        assertEquals(catalog.getEntity().getDescription(), createdDesc);
    }

    /**
     * Test listing of catalogs.
     */
    @Test
    public void testList() {
        Catalogs catalogs = api.list(null, null, null, null, null).block();
        assertNotNull(catalogs);
        assertNotNull(catalogs.getCatalogs());
        Catalog one = catalogs.getCatalogs().get(0);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getGuid(), MockConstants.CATALOG_GUID);
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getName(), createdName);
        assertEquals(one.getEntity().getDescription(), createdDesc);
    }

    /**
     * Test update of a catalog.
     */
    @Test
    public void testUpdate() {
        String updatedName = "New Name";
        String updatedDesc = "New description.";
        List<JSONResourcePatchModel> jsonPatch = new ArrayList<>();
        JSONResourcePatchModel nameChange = new JSONResourcePatchModel();
        nameChange.setPath("/entity/name");
        nameChange.setOp(JSONResourcePatchModel.OpEnum.REPLACE);
        nameChange.setValue(updatedName);
        jsonPatch.add(nameChange);
        JSONResourcePatchModel descChange = new JSONResourcePatchModel();
        descChange.setPath("/entity/description");
        descChange.setOp(JSONResourcePatchModel.OpEnum.REPLACE);
        descChange.setValue(updatedDesc);
        jsonPatch.add(descChange);
        // TODO: currently the API throws a 500 internal server error, despite actually applying the update
        assertThrows(WebClientResponseException.InternalServerError.class, () -> api.update(MockConstants.CATALOG_GUID, jsonPatch).block());
        /*Catalog updated = api.update(MockConstants.CATALOG_GUID, jsonPatch).block();
        assertNotNull(updated);
        assertNotNull(updated.getMetadata());
        assertEquals(updated.getMetadata().getGuid(), MockConstants.CATALOG_GUID);
        assertNotNull(updated.getEntity());
        assertEquals(updated.getEntity().getName(), updatedName);
        assertEquals(updated.getEntity().getDescription(), updatedDesc);*/
    }

    /**
     * Test deletion of a catalog.
     */
    @Test
    public void testDelete() {
        api.delete(MockConstants.CATALOG_GUID, null).block();
    }

}
