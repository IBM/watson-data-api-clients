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

import com.ibm.watson.data.client.api.AssetTypesApiV2;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Test the Asset Types API endpoints.
 */
public class AssetTypesTest {

    private AssetTypesApiV2 api;

    private static final String createDesc = "A new asset type to test API works as expected.";
    private static final String fieldKey = "test_field";


    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new AssetTypesApiV2(MockConstants.getApiClient());
    }

    /**
     * Test retrieval of all of the asset types in a catalog.
     */
    @Test
    public void testList() {
        TypesResponse response = api.list(MockConstants.CATALOG_GUID, null, null).block();
        assertNotNull(response);
        List<Type> typeList = response.getResources();
        assertNotNull(typeList);
        assertEquals(typeList.size(), 24);
        Type type = typeList.get(0);
        assertNotNull(type);
        assertEquals(type.getName(), "environment");
        assertEquals(type.getVersion(), Double.valueOf(1.0));
        assertEquals(type.getDescription(), "Environment specification, which envelops software and hardware specifications.");
        List<AssetTypeField> fields = type.getFields();
        assertNotNull(fields);
        assertEquals(fields.size(), 2);
        AssetTypeField one = fields.get(0);
        assertNotNull(one);
        assertEquals(one.getKey(), "software_specification_guid");
        assertEquals(one.getType(), "string");
        assertFalse(one.getFacet());
        assertFalse(one.getIsArray());
        assertEquals(one.getSearchPath(), "asset.software_specification.guid");
        assertTrue(one.getIsSearchableAcrossTypes());
        assertNotNull(type.getRelationships());
        assertEquals(type.getRelationships().size(), 0);
    }

    /**
     * Test creation of a new asset type in a catalog.
     */
    @Test
    public void testReplace() {
        UpdateType body = new UpdateType();
        body.setDescription(createDesc);
        AssetTypeField field = new AssetTypeField();
        field.setKey(fieldKey);
        field.setIsSearchableAcrossTypes(true);
        field.setType("string");
        body.addFieldsItem(field);
        Type type = api.replace(MockConstants.NEW_TYPE_NAME, body, MockConstants.CATALOG_GUID, null, null).block();
        validateType(type);
    }

    private void validateType(Type type) {
        assertNotNull(type);
        assertEquals(type.getName(), MockConstants.NEW_TYPE_NAME);
        assertEquals(type.getDescription(), createDesc);
        assertNotNull(type.getFields());
        assertEquals(type.getFields().size(), 1);
        assertEquals(type.getFields().get(0).getType(), "string");
        assertEquals(type.getFields().get(0).getKey(), fieldKey);
        assertTrue(type.getFields().get(0).getIsSearchableAcrossTypes());
        assertEquals(type.getVersion(), Double.valueOf(1.0));
    }

    /**
     * Test retrieval of a single asset type from a catalog.
     */
    @Test
    public void testGet() {
        Type type = api.get(MockConstants.NEW_TYPE_NAME, MockConstants.CATALOG_GUID, null, null).block();
        validateType(type);
    }

    /**
     * Test search by asset type.
     */
    @Test
    public void testFindByAssetType() {
        CatalogSearch body = new CatalogSearch();
        body.setLimit(10);
        // TODO: determine a logical query to run against the new type, and change beans to actually have results
        //  to validate...
        /*body.setQuery("");
        api.findAssetsByType(MockConstants.NEW_TYPE_NAME, body, MockConstants.CATALOG_GUID, null, null).block();*/
        
    }

}