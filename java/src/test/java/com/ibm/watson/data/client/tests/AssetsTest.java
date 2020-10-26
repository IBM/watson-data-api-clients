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
import com.ibm.watson.data.client.api.AssetsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
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
import static org.testng.Assert.assertEquals;

/**
 * Tests and expectations for the Assets API endpoints.
 */
public class AssetsTest extends AbstractExpectations {

    private final AssetsApiV2 api = new AssetsApiV2(getApiClient());

    public AssetsTest() {
        super(AssetsApiV2.BASE_API, "assets");
    }

    private final Map<String, List<String>> catalogParams = new HashMap<>();
    private final Map<String, List<String>> projectParams = new HashMap<>();
    private void setupParams() {
        List<String> catalog = new ArrayList<>();
        catalog.add(CATALOG_GUID);
        catalogParams.put("catalog_id", catalog);
        List<String> project = new ArrayList<>();
        project.add(PROJECT_GUID);
        projectParams.put("project_id", project);
    }

    private static final String assetGuidEndpoint = "/" + NEW_ASSET_GUID;
    private static final String cloneGuidEndpoint = "/" + CLONED_ASTGUID;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", catalogParams, "create", 201);
        setupTest(client, "GET", assetGuidEndpoint, catalogParams, "get");
        setupTest(client, "GET", assetGuidEndpoint + "/revisions", catalogParams, "getRevisions", 400);
        setupTest(client, "POST", assetGuidEndpoint + "/ratings", catalogParams, "rateAsset", 201);
        setupTest(client, "GET", assetGuidEndpoint + "/ratings", catalogParams, "getRatings");
        setupTest(client, "GET", assetGuidEndpoint + "/ratings/stats", catalogParams, "getRatingsStats");
        setupTest(client, "PATCH", assetGuidEndpoint + "/ratings/" + ASSET_RATING_G, catalogParams, "updateRating");
        setupTest(client, "DELETE", assetGuidEndpoint + "/ratings/" + ASSET_RATING_G, catalogParams, "deleteRating", 204);
        setupTest(client, "PATCH", assetGuidEndpoint, catalogParams, "update");
        setupTest(client, "PUT", assetGuidEndpoint + "/perms", catalogParams, "updateRov");
        setupTest(client, "POST", assetGuidEndpoint + "/clone", catalogParams, "clone", 201);
        setupTest(client, "POST", cloneGuidEndpoint + "/revisions", projectParams, "commitRevision", 201);
        setupTest(client, "GET", cloneGuidEndpoint + "/revisions", projectParams, "getRevisions");
        setupTest(client, "POST", "/publish", "publishMetadata", 201);
        setupTest(client, "POST", cloneGuidEndpoint + "/publish", projectParams, "publishData");
        setupTest(client, "PUT", cloneGuidEndpoint + "/owner", projectParams, "updateOwner");
        setupTest(client, "PATCH", assetGuidEndpoint + "/collaborators", catalogParams, "addAndUpdateCollaborators");
        setupTest(client, "DELETE", assetGuidEndpoint, catalogParams, "delete", 204);
    }

    @Test
    public void testCreate() {
        Asset asset = readRequestFromFile("create", new TypeReference<Asset>() {});
        AssetCreateResponse response = api.create(asset, CATALOG_GUID, null, null).block();
        validateAsset(response);
        assertNotNull(response);
        assertEquals(response.getAssetId(), NEW_ASSET_GUID);
    }

    @Test
    public void testGet() {
        MetadataEntityResult response = api.get(NEW_ASSET_GUID, CATALOG_GUID, null, null, null).block();
        validateAsset(response);
    }

    @Test
    public void testRateAsset() {
        AssetRatingEntity rating = readRequestFromFile("rateAsset", new TypeReference<AssetRatingEntity>() {});
        AssetRating response = api.rateAsset(NEW_ASSET_GUID, rating, CATALOG_GUID, null, null, null).block();
        validateRating(response, 5);
    }

    @Test
    public void testGetRatings() {
        TokenPaginatedAssetRatingList response = api.getRatings(NEW_ASSET_GUID, CATALOG_GUID, null, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getCount(), Long.valueOf(1));
        assertEquals(response.getLimit(), Integer.valueOf(25));
        assertNotNull(response.getFirst());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        validateRating(response.getResources().get(0), 5);
    }

    @Test
    public void testGetRatingsStats() {
        AssetRatingStatsResponse response = api.getRatingsStats(NEW_ASSET_GUID, CATALOG_GUID, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getAssetId(), NEW_ASSET_GUID);
        assertNotNull(response.getStats());
        assertEquals(response.getStats().size(), 1);
        assertEquals(response.getStats().get(0).getCount(), Long.valueOf(1));
        assertEquals(response.getStats().get(0).getRating(), Integer.valueOf(5));
    }

    @Test
    public void testUpdateRating() {
        AssetRatingEntity rating = readRequestFromFile("updateRating", new TypeReference<AssetRatingEntity>() {});
        AssetRating response = api.updateRating(NEW_ASSET_GUID, ASSET_RATING_G, rating, CATALOG_GUID, null, null, null).block();
        validateRating(response, 4);
    }

    @Test
    public void testDeleteRating() {
        api.deleteRating(NEW_ASSET_GUID, ASSET_RATING_G, CATALOG_GUID, null, null, null).block();
    }

    @Test
    public void testUpdate() {
        List<JSONResourcePatchModel> jsonPatch = readRequestFromFile("update", new TypeReference<List<JSONResourcePatchModel>>(){});
        MetadataEntityResult response = api.update(NEW_ASSET_GUID, jsonPatch, CATALOG_GUID, null, null).block();
        validateAsset(response, 1595596385055L);
    }

    @Test
    public void testUpdateRov() {
        BaseRov members = readRequestFromFile("updateRov", new TypeReference<BaseRov>() {});
        MetadataEntityResult response = api.updateRov(NEW_ASSET_GUID, members, CATALOG_GUID, null, null).block();
        validateAsset(response, 1595596385055L);
    }

    @Test
    public void testClone() {
        AssetCopyTo body = readRequestFromFile("clone", new TypeReference<AssetCopyTo>() {});
        AssetCreateResponse response = api.clone(CATALOG_GUID, NEW_ASSET_GUID, body).block();
        assertNotNull(response);
        validateClone(response);
        assertNotNull(response.getMetadata());
        assertNull(response.getMetadata().getCommitInfo());
        assertNull(response.getMetadata().getRevisionId());
    }

    @Test
    public void testCommitRevision() {
        AssetCommitOptions body = readRequestFromFile("commitRevision", new TypeReference<AssetCommitOptions>() {});
        AssetCreateResponse response = api.commitRevision(CLONED_ASTGUID, PROJECT_GUID, null, body).block();
        assertNotNull(response);
        validateClone(response);
        assertNotNull(response.getMetadata());
        assertEquals(response.getMetadata().getRevisionId(), Long.valueOf(1));
        assertNotNull(response.getMetadata().getCommitInfo());
        assertNotNull(response.getMetadata().getCommitInfo().getCommittedAt());
        assertEquals(response.getMetadata().getCommitInfo().getCommitMessage(), "This is a test commit.");
    }

    @Test
    public void testGetRevisions() {
        FindAssetsResponse response = api.getRevisions(CLONED_ASTGUID, PROJECT_GUID, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResults());
        assertEquals(response.getResults().size(), 1);
        validateCloneMetadata(response.getResults().get(0).getMetadata());
    }

    @Test
    public void testPublishMetadata() {
        PublishAssetOnlyAssetMetada body = readRequestFromFile("publishMetadata", new TypeReference<PublishAssetOnlyAssetMetada>() {});
        AssetCreateResponse response = api.publishMetadata(body).block();
        assertNotNull(response);
        MetadataAsset asset = validatePublished(response, "6f1faa4b-3ee1-49b7-9f50-caef4abe927a", 1595845570751L);
        assertNotNull(asset.getSourceAsset());
        assertEquals(asset.getSourceAsset().getAction(), "publish");
        assertEquals(asset.getSourceAsset().getProjectId(), PROJECT_GUID);
        assertEquals(asset.getSourceAsset().getBssAccountId(), "999");
    }

    @Test
    public void testPublishData() {
        PublishAssetRequest body = readRequestFromFile("publishData", new TypeReference<PublishAssetRequest>() {});
        AssetCreateResponse response = api.publishData(PROJECT_GUID, CLONED_ASTGUID, null, body).block();
        assertNotNull(response);
        MetadataAsset asset = validatePublished(response, "30d3a9cd-9eb9-4aa1-ae44-655a587de5bd", 1595849636334L);
        assertNotNull(asset.getSourceAsset());
        assertEquals(asset.getSourceAsset().getAction(), "publish");
        assertEquals(asset.getSourceAsset().getCatalogId(), "2ea819ce-95b5-4e11-8d46-dd1ba8865f14");
        assertEquals(asset.getSourceAsset().getProjectId(), PROJECT_GUID);
        assertEquals(asset.getSourceAsset().getAssetId(), CLONED_ASTGUID);
        assertEquals(asset.getSourceAsset().getBssAccountId(), "999");
        assertEquals(asset.getSourceAsset().getAssetName(), NEW_ASSET_NAME);
        assertNotNull(asset.getCommitInfo());
        assertEquals(asset.getCommitInfo().getPreviousRevision(), Long.valueOf(1));
    }

    @Test
    public void testUpdateOwner() {
        AssetOwner body = readRequestFromFile("updateOwner", new TypeReference<AssetOwner>() {});
        MetadataEntityResult response = api.updateOwner(CLONED_ASTGUID, body, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        validateCloneMetadata(response.getMetadata(), NEW_USER_GUID, 1595851553156L);
        assertNotNull(response.getEntity());
    }

    @Test
    public void testAddAndUpdateCollaborators() {
        List<JSONResourcePatchModel> body = readRequestFromFile("addAndUpdateCollaborators", new TypeReference<List<JSONResourcePatchModel>>() {});
        Asset response = api.addAndUpdateCollaborators(NEW_ASSET_GUID, body, CATALOG_GUID, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        validateMetadataAsset(response.getMetadata());
    }

    // TODO: implement a test for this once there is an API for spaces
    /*@Test
    public void testPromote() {

    }*/

    @Test
    public void testDelete() {
        api.delete(NEW_ASSET_GUID, CATALOG_GUID, null, null, false).block();
    }

    private void validateAsset(MetadataEntityResult asset) {
        validateAsset(asset, 1595493646713L);
    }

    private void validateAsset(MetadataEntityResult asset, long lastUpdate) {
        assertNotNull(asset);
        validateMetadataAsset(asset.getMetadata(), lastUpdate);
        assertNotNull(asset.getHref());
        assertNotEquals(asset.getHref(), "");
        assertNotNull(asset.getEntity());
    }

    private void validateRating(AssetRating rating, Integer stars) {
        assertNotNull(rating);
        assertNotNull(rating.getEntity());
        assertEquals(rating.getEntity().getRating(), stars);
        assertEquals(rating.getEntity().getReview(), "This is a test review.");
        assertNotNull(rating.getMetadata());
        assertEquals(rating.getMetadata().getAssetId(), NEW_ASSET_GUID);
        assertEquals(rating.getMetadata().getAssetRatingId(), ASSET_RATING_G);
    }

    public static void validateMetadataAsset(MetadataAsset asset) {
        validateMetadataAsset(asset, 1595493646713L);
    }

    public static void validateMetadataAsset(MetadataAsset asset, long lastUpdate) {
        assertNotNull(asset);
        assertNotNull(asset.getRov());
        assertEquals(asset.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(asset.getUsage());
        assertEquals(asset.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getLastUpdateTime(), Long.valueOf(lastUpdate));
        assertEquals(asset.getUsage().getLastAccessTime(), Long.valueOf(lastUpdate));
        assertEquals(asset.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(asset.getName(), NEW_ASSET_NAME);
        assertNotEquals(asset.getDescription(), "");
        assertNotNull(asset.getTags());
        assertEquals(asset.getTags().size(), 0);
        assertEquals(asset.getAssetType(), NEW_TYPE_NAME);
        assertEquals(asset.getOriginCountry(), "gb");
        assertEquals(asset.getRating(), Double.valueOf(0.0));
        assertEquals(asset.getTotalRatings(), Long.valueOf(0));
        assertEquals(asset.getCatalogId(), CATALOG_GUID);
        assertEquals(asset.getCreated(), Long.valueOf(1595493646713L));
        assertEquals(asset.getOwnerId(), EXSTUSER_GUID);
        assertEquals(asset.getSize(), Long.valueOf(0L));
        assertEquals(asset.getVersion(), Double.valueOf(2.0));
        assertEquals(asset.getAssetState(), "available");
        assertNotNull(asset.getAssetAttributes());
        assertEquals(asset.getAssetAttributes().size(), 1);
        assertEquals(asset.getAssetAttributes().get(0), NEW_TYPE_NAME);
        assertEquals(asset.getAssetId(), NEW_ASSET_GUID);
        assertEquals(asset.getAssetCategory(), AssetCategory.USER);
    }

    private void validateClone(AssetCreateResponse response) {
        assertNotNull(response.getEntity());
        assertEquals(response.getAssetId(), CLONED_ASTGUID);
        assertNotNull(response.getMetadata());
        validateCloneMetadata(response.getMetadata());
    }

    private void validateCloneMetadata(MetadataAsset asset) {
        validateCloneMetadata(asset, EXSTUSER_GUID, 1595598595969L);
    }

    private void validateCloneMetadata(MetadataAsset asset, String ownerId, Long timestamp) {
        assertNotNull(asset);
        assertNotNull(asset.getRov());
        assertEquals(asset.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(asset.getUsage());
        assertEquals(asset.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getLastUpdateTime(), timestamp);
        assertEquals(asset.getUsage().getLastAccessTime(), timestamp);
        assertEquals(asset.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(asset.getName(), NEW_ASSET_NAME);
        assertNotEquals(asset.getDescription(), "");
        assertNotNull(asset.getTags());
        assertEquals(asset.getTags().size(), 0);
        assertEquals(asset.getAssetType(), NEW_TYPE_NAME);
        assertEquals(asset.getOriginCountry(), "gb");
        assertEquals(asset.getRating(), Double.valueOf(0.0));
        assertEquals(asset.getTotalRatings(), Long.valueOf(0));
        assertEquals(asset.getCatalogId(), "2ea819ce-95b5-4e11-8d46-dd1ba8865f14");
        assertEquals(asset.getCreated(), Long.valueOf(1595598595969L));
        assertEquals(asset.getOwnerId(), ownerId);
        assertEquals(asset.getSize(), Long.valueOf(0L));
        assertEquals(asset.getVersion(), Double.valueOf(2.0));
        assertEquals(asset.getAssetState(), "available");
        assertNotNull(asset.getAssetAttributes());
        assertEquals(asset.getAssetAttributes().size(), 1);
        assertEquals(asset.getAssetAttributes().get(0), NEW_TYPE_NAME);
        assertEquals(asset.getAssetId(), CLONED_ASTGUID);
        assertEquals(asset.getAssetCategory(), AssetCategory.USER);
        assertEquals(asset.getProjectId(), PROJECT_GUID);
        assertEquals(asset.getSandboxId(), PROJECT_GUID);
        assertNotNull(asset.getSourceAsset());
        assertEquals(asset.getSourceAsset().getAction(), "clone");
        assertEquals(asset.getSourceAsset().getCatalogId(), CATALOG_GUID);
        assertEquals(asset.getSourceAsset().getAssetId(), NEW_ASSET_GUID);
        assertEquals(asset.getSourceAsset().getBssAccountId(), "999");
        assertEquals(asset.getSourceAsset().getAssetName(), NEW_ASSET_NAME);
    }

    private MetadataAsset validatePublished(AssetCreateResponse response, String assetGuid, Long timestamp) {
        assertNotNull(response.getEntity());
        assertEquals(response.getAssetId(), assetGuid);
        assertNotNull(response.getMetadata());
        MetadataAsset asset = response.getMetadata();
        assertNotNull(asset);
        assertNotNull(asset.getRov());
        assertEquals(asset.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(asset.getUsage());
        assertEquals(asset.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getLastUpdateTime(), timestamp);
        assertEquals(asset.getUsage().getLastAccessTime(), timestamp);
        assertEquals(asset.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(asset.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(asset.getName(), NEW_ASSET_NAME);
        assertEquals(asset.getDescription(), ""); // Description is as-set on POSTed publication body?
        assertNotNull(asset.getTags());
        assertEquals(asset.getTags().size(), 0);
        assertEquals(asset.getAssetType(), NEW_TYPE_NAME);
        assertEquals(asset.getOriginCountry(), "gb");
        assertEquals(asset.getRating(), Double.valueOf(0.0));
        assertEquals(asset.getTotalRatings(), Long.valueOf(0));
        assertEquals(asset.getCatalogId(), CATALOG_GUID);
        assertEquals(asset.getCreated(), timestamp);
        assertEquals(asset.getOwnerId(), EXSTUSER_GUID);
        assertEquals(asset.getSize(), Long.valueOf(0L));
        assertEquals(asset.getVersion(), Double.valueOf(2.0));
        assertEquals(asset.getAssetState(), "available");
        assertNotNull(asset.getAssetAttributes());
        assertEquals(asset.getAssetAttributes().size(), 1);
        assertEquals(asset.getAssetAttributes().get(0), NEW_TYPE_NAME);
        assertEquals(asset.getAssetId(), assetGuid);
        assertEquals(asset.getAssetCategory(), AssetCategory.USER);
        return asset;
    }

}
