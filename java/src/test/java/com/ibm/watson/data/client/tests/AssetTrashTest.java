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

import com.ibm.watson.data.client.api.AssetTrashApiV2;
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
 * Test the Asset Trash API endpoints.
 */
public class AssetTrashTest extends AbstractExpectations {

    private final AssetTrashApiV2 api = new AssetTrashApiV2(MockConstants.getApiClient());

    public AssetTrashTest() {
        super(AssetTrashApiV2.BASE_API, "assetTrash");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> catalog = new ArrayList<>();
        catalog.add(CATALOG_GUID);
        params.put("catalog_id", catalog);
    }

    private static final String assetEndpoint = "/" + NEW_ASSET_GUID;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "GET", "", params, "list");
        setupTest(client, "GET", assetEndpoint, params, "get");
        setupTest(client, "POST", assetEndpoint + "/restore", params, "restore");
        setupTest(client, "DELETE", assetEndpoint, params, "purge", 204);
    }

    @Test
    public void testList() {
        ListTrashResponse response = api.list(CATALOG_GUID, null, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getBookmark());
        assertNotNull(response.getTotalRows());
        assertEquals(response.getTotalRows(), Integer.valueOf(1));
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        validateAsset(response.getResources().get(0), 1595852391728L, true);
    }

    @Test
    public void testGet() {
        MetadataEntityResult response = api.get(NEW_ASSET_GUID, CATALOG_GUID, null, null).block();
        assertNotNull(response);
        validateAsset(response, 1595852391728L, true);
        assertNotNull(response.getEntity());
    }

    @Test
    public void testRestore() {
        MetadataEntityResult response = api.restore(NEW_ASSET_GUID, CATALOG_GUID, null, null).block();
        assertNotNull(response);
        validateAsset(response, 1595859738059L, false);
        assertNotNull(response.getEntity());
    }

    @Test
    public void testPurge() {
        api.purge(NEW_ASSET_GUID, CATALOG_GUID, null, null).block();
    }

    private void validateAsset(MetadataAssetResult result, Long timestamp, boolean deleted) {
        assertNotNull(result.getHref());
        MetadataAsset asset = result.getMetadata();
        assertNotNull(asset);
        assertNotNull(asset.getRov());
        assertEquals(asset.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(asset.getRov().getCollaboratorIds());
        assertNotNull(asset.getUsage());
        assertNotNull(asset.getUsage().getLastUpdatedAt());
        assertEquals(asset.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertNotNull(asset.getUsage().getLastAccessedAt());
        assertEquals(asset.getUsage().getLastUpdateTime(), timestamp);
        assertEquals(asset.getUsage().getLastAccessTime(), timestamp);
        assertEquals(asset.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(asset.getName(), NEW_ASSET_NAME);
        assertEquals(asset.getDescription(), "An updated test asset description.");
        assertNotNull(asset.getTags());
        assertEquals(asset.getTags().size(), 0);
        assertEquals(asset.getAssetType(), NEW_TYPE_NAME);
        assertEquals(asset.getOriginCountry(), "gb");
        if (deleted) {
            assertEquals(asset.getDeleteProcessingState(), "complete");
            assertEquals(asset.getDeleteReason(), "Delete explicitly requested by user.  ");
        }
        assertEquals(asset.getRating(), Double.valueOf(0.0));
        assertEquals(asset.getTotalRatings(), Long.valueOf(0));
        assertEquals(asset.getCatalogId(), CATALOG_GUID);
        assertEquals(asset.getCreated(), Long.valueOf(1595849636334L));
        assertNotNull(asset.getCreatedAt());
        assertEquals(asset.getOwnerId(), EXSTUSER_GUID);
        assertEquals(asset.getSize(), Long.valueOf(0));
        assertEquals(asset.getVersion(), Double.valueOf(2.0));
        if (deleted) {
            assertEquals(asset.getAssetState(), "deleted");
        } else {
            assertEquals(asset.getAssetState(), "available");
        }
        assertNotNull(asset.getAssetAttributes());
        assertTrue(asset.getAssetAttributes().contains("test_type"));
        assertEquals(asset.getAssetId(), NEW_ASSET_GUID);
        assertEquals(asset.getAssetCategory(), AssetCategory.USER);
    }

}