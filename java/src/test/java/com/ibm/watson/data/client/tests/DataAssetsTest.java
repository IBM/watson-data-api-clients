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
import com.ibm.watson.data.client.api.DataAssetsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.AssetCategory;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Project Integration API endpoints.
 */
public class DataAssetsTest extends AbstractExpectations {

    private final DataAssetsApiV2 api = new DataAssetsApiV2(MockConstants.getApiClient());

    public DataAssetsTest() {
        super(DataAssetsApiV2.BASE_API, "dataAssets");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> project = new ArrayList<>();
        project.add(PROJECT_GUID);
        params.put("project_id", project);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", params, "create", 201);
        setupTest(client, "GET", "/" + DATAASSET_GUID, params, "get");
    }

    @Test
    public void testCreate() {
        Asset body = readRequestFromFile("create", new TypeReference<Asset>() {});
        AssetCreateResponse response = api.create(body, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertNotNull(response.getEntity());
        assertEquals(response.getAssetId(), DATAASSET_GUID);
        assertNotNull(response.getHref());
        validateDataAsset(response.getMetadata());
    }

    @Test
    public void testGet() {
        Asset response = api.get(DATAASSET_GUID, null, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertNotNull(response.getEntity());
        assertNull(response.getAttachments());
        validateDataAsset(response.getMetadata());
    }

    private void validateDataAsset(MetadataAsset asset) {
        assertNotNull(asset);
        assertNotNull(asset.getRov());
        assertEquals(asset.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(asset.getRov().getCollaboratorIds());
        assertEquals(asset.getProjectId(), PROJECT_GUID);
        assertEquals(asset.getSandboxId(), PROJECT_GUID);
        assertNotNull(asset.getUsage());
        assertEquals(asset.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getLastUpdateTime(), Long.valueOf(1596025156353L));
        assertNotNull(asset.getUsage().getLastAccessedAt());
        assertEquals(asset.getUsage().getLastAccessTime(), Long.valueOf(1596025156353L));
        assertEquals(asset.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(asset.getName(), "test_file.csv");
        assertEquals(asset.getDescription(), "");
        assertNotNull(asset.getTags());
        assertEquals(asset.getTags().size(), 0);
        assertEquals(asset.getAssetType(), "data_asset");
        assertEquals(asset.getOriginCountry(), "gb");
        assertEquals(asset.getRating(), Double.valueOf(0.0));
        assertEquals(asset.getTotalRatings(), Long.valueOf(0));
        assertEquals(asset.getCatalogId(), "2ea819ce-95b5-4e11-8d46-dd1ba8865f14");
        assertEquals(asset.getCreated(), Long.valueOf(1596025156353L));
        assertNotNull(asset.getCreatedAt());
        assertEquals(asset.getOwnerId(), EXSTUSER_GUID);
        assertEquals(asset.getSize(), Long.valueOf(0));
        assertEquals(asset.getVersion(), Double.valueOf(2.0));
        assertEquals(asset.getAssetState(), "available");
        assertNotNull(asset.getAssetAttributes());
        assertEquals(asset.getAssetAttributes().size(), 1);
        assertTrue(asset.getAssetAttributes().contains("data_asset"));
        assertEquals(asset.getAssetId(), DATAASSET_GUID);
        assertEquals(asset.getAssetCategory(), AssetCategory.USER);
    }

}
