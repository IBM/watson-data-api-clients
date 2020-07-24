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
import com.ibm.watson.data.client.api.AssetTypesApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.CATALOG_GUID;
import static com.ibm.watson.data.client.mocks.MockConstants.NEW_TYPE_NAME;
import static org.testng.Assert.*;

/**
 * Test the Asset Types API endpoints.
 */
public class AssetTypesTest extends AbstractExpectations {

    private final AssetTypesApiV2 api = new AssetTypesApiV2(MockConstants.getApiClient());

    public AssetTypesTest() {
        super(AssetTypesApiV2.BASE_API, "assetTypes");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> catalog = new ArrayList<>();
        catalog.add(CATALOG_GUID);
        params.put("catalog_id", catalog);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "/" + NEW_TYPE_NAME + "/search", params, "findAssetsByType");
        setupTest(client, "GET", "/" + NEW_TYPE_NAME, params, "get");
        setupTest(client, "GET", "", params, "list");
        setupTest(client, "PUT", "/" + NEW_TYPE_NAME, params, "replace");
    }

    private static final String createDesc = "A new asset type to test API works as expected.";

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

    @Test
    public void testReplace() {
        UpdateType body = readRequestFromFile("replace", new TypeReference<UpdateType>() {});
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
        assertEquals(type.getFields().get(0).getKey(), MockConstants.NEW_PROP_NAME);
        assertTrue(type.getFields().get(0).getIsSearchableAcrossTypes());
        assertEquals(type.getVersion(), Double.valueOf(1.0));
    }

    @Test
    public void testGet() {
        Type type = api.get(MockConstants.NEW_TYPE_NAME, MockConstants.CATALOG_GUID, null, null).block();
        validateType(type);
    }

    @Test
    public void testFindAssetsByType() {
        CatalogSearch body = readRequestFromFile("findAssetsByType", new TypeReference<CatalogSearch>() {});
        FindAssetsResponse response = api.findAssetsByType(MockConstants.NEW_TYPE_NAME, body, MockConstants.CATALOG_GUID, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalRows(), Integer.valueOf(1));
        List<MetadataAssetResult> results = response.getResults();
        assertNotNull(results);
        assertEquals(results.size(), 1);
        assertNotNull(results.get(0));
        AssetsTest.validateMetadataAsset(results.get(0).getMetadata());
    }

}