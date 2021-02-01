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
        // Note: breaking from usual approach, here we will validate a far more complete asset to verify complex serde
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        assertNotNull(response.getMetadata().getRov());
        assertEquals(response.getMetadata().getRov().getMode(), Integer.valueOf(0));
        assertNotNull(response.getMetadata().getRov().getCollaboratorIds());
        assertTrue(response.getMetadata().getRov().getCollaboratorIds().isEmpty());
        assertNotNull(response.getMetadata().getUsage());
        assertNotNull(response.getMetadata().getUsage().getLastUpdatedAt());
        assertEquals(response.getMetadata().getUsage().getLastUpdaterId(), "1000330999");
        assertEquals(response.getMetadata().getUsage().getLastUpdateTime(), Long.valueOf(1611699307638L));
        assertNotNull(response.getMetadata().getUsage().getLastAccessedAt());
        assertEquals(response.getMetadata().getUsage().getLastAccessorId(), "1000330999");
        assertEquals(response.getMetadata().getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(response.getMetadata().getName(), "CUSTOMER");
        assertEquals(response.getMetadata().getDescription(), "");
        assertNotNull(response.getMetadata().getTags());
        assertEquals(response.getMetadata().getTags().size(), 2);
        assertTrue(response.getMetadata().getTags().contains("info_asset"));
        assertEquals(response.getMetadata().getAssetType(), "data_asset");
        assertEquals(response.getMetadata().getOriginCountry(), "us");
        assertEquals(response.getMetadata().getRating(), Double.valueOf(0.0));
        assertEquals(response.getMetadata().getTotalRatings(), Long.valueOf(0L));
        assertEquals(response.getMetadata().getCatalogId(), "92b84496-9961-47d8-ab1b-23212ab8a944");
        assertEquals(response.getMetadata().getCreated(), Long.valueOf(1607516804207L));
        assertNotNull(response.getMetadata().getCreatedAt());
        assertEquals(response.getMetadata().getOwnerId(), "1000331001");
        assertEquals(response.getMetadata().getSize(), Long.valueOf(159322L));
        assertEquals(response.getMetadata().getVersion(), Double.valueOf(2.0));
        assertEquals(response.getMetadata().getAssetState(), "available");
        assertNotNull(response.getMetadata().getAssetAttributes());
        assertEquals(response.getMetadata().getAssetAttributes().size(), 4);
        assertTrue(response.getMetadata().getAssetAttributes().contains("data_profile"));
        assertEquals(response.getMetadata().getAssetId(), "91636d5b-b322-4f86-a942-9ffb3b53ea3e");
        assertEquals(response.getMetadata().getAssetCategory(), AssetCategory.USER);
        assertNotNull(response.getMetadata().getSourceSystem());
        assertNotNull(response.getMetadata().getSourceSystem().getCreationTimestamp());
        assertEquals(response.getMetadata().getSourceSystem().getCreated(), Long.valueOf(1607516775000L));
        assertNotNull(response.getMetadata().getSourceSystem().getLastModificationTimestamp());
        assertEquals(response.getMetadata().getSourceSystem().getLastModified(), Long.valueOf(1607516775000L));
        assertEquals(response.getMetadata().getSourceSystem().getAssetIdentifier(), "b1c497ce.54bd3a08.0ij7chrnb.i99cd86.3orge8.meja7j15c2c5j4ujjpead");
        assertEquals(response.getMetadata().getSourceSystem().getSource(), "OMRS_COHORT_RelationalTable");
        assertEquals(response.getMetadata().getSourceSystem().getSourceSystemId(), "df5ab456-5d64-4e7f-9b93-ab7ad16c63ad");
        assertNotNull(response.getMetadata().getChildSourceSystems());
        assertEquals(response.getMetadata().getChildSourceSystems().size(), 2);
        assertNotNull(response.getMetadata().getChildSourceSystems().get(0).getCreationTimestamp());
        assertEquals(response.getMetadata().getChildSourceSystems().get(0).getCreated(), Long.valueOf(1607516775000L));
        assertNotNull(response.getMetadata().getChildSourceSystems().get(0).getLastModificationTimestamp());
        assertEquals(response.getMetadata().getChildSourceSystems().get(0).getLastModified(), Long.valueOf(1607516775000L));
        assertEquals(response.getMetadata().getChildSourceSystems().get(0).getAssetIdentifier(), "b1c497ce.c1fb060b.0ij7chrnb.i9pshth.kjabor.qcn33ukhth87rv8t554dc");
        assertEquals(response.getMetadata().getChildSourceSystems().get(0).getSource(), "OMRS_COHORT_DeployedDatabaseSchema");
        assertEquals(response.getMetadata().getChildSourceSystems().get(0).getSourceSystemId(), "df5ab456-5d64-4e7f-9b93-ab7ad16c63ad");
        assertNotNull(response.getMetadata().getChildSourceSystems().get(1).getCreationTimestamp());
        assertEquals(response.getMetadata().getChildSourceSystems().get(1).getCreated(), Long.valueOf(1607516775000L));
        assertNotNull(response.getMetadata().getChildSourceSystems().get(1).getLastModificationTimestamp());
        assertEquals(response.getMetadata().getChildSourceSystems().get(1).getLastModified(), Long.valueOf(1607516775000L));
        assertEquals(response.getMetadata().getChildSourceSystems().get(1).getAssetIdentifier(), "b1c497ce.c1fb060b.0ij7chrnb.i9pshth.kjabor.qcn33ukhth87rv8t554dc#RDST");
        assertEquals(response.getMetadata().getChildSourceSystems().get(1).getSource(), "OMRS_COHORT_RelationalDBSchemaType");
        assertEquals(response.getMetadata().getChildSourceSystems().get(1).getSourceSystemId(), "df5ab456-5d64-4e7f-9b93-ab7ad16c63ad");
        Map<String, AbstractAssetEntity> map = response.getEntity();
        assertNotNull(map);
        assertEquals(map.size(), 4);
        assertTrue(map.containsKey("data_asset"));
        AbstractAssetEntity dataAsset = map.get("data_asset");
        assertTrue(dataAsset instanceof DataAssetEntity);
        DataAssetEntity dae = (DataAssetEntity) dataAsset;
        assertEquals(dae.getMimeType(), "application/octet-stream");
        assertTrue(dae.getDataset());
        assertNotNull(dae.getColumns());
        assertEquals(dae.getColumns().size(), 16);
        assertEquals(dae.getColumns().get(15).getName(), "TELEPHON");
        assertEquals(dae.getColumns().get(15).getOmrsGuid(), "b1c497ce.60641b50.0ij7chrnb.i9pl06g.hg0qqr.qibh5q96t4clfits2blbv");
        assertEquals(dae.getColumns().get(15).getPosition(), Double.valueOf(16.0));
        assertNotNull(dae.getColumns().get(15).getType());
        assertEquals(dae.getColumns().get(15).getType().getType(), "VARCHAR");
        assertTrue(dae.getColumns().get(15).getType().getNullable());
        assertEquals(dae.getColumns().get(15).getType().getLength(), Double.valueOf(4.0));
        assertFalse(dae.getColumns().get(15).getType().getUnique());
        assertFalse(dae.getColumns().get(15).getType().getSigned());
        assertEquals(dae.getColumns().get(15).getType().getScale(), Double.valueOf(0.0));
        assertNotNull(dae.getProperties());
        assertEquals(dae.getProperties().size(), 2);
        assertEquals(dae.getProperties().get(0).getName(), "table_name");
        assertEquals(dae.getProperties().get(0).getValue(), "CUSTOMER");
        assertEquals(dae.getProperties().get(1).getName(), "schema_name");
        assertEquals(dae.getProperties().get(1).getValue(), "CP4DEMO");
        assertTrue(map.containsKey("column_info"));
        AbstractAssetEntity columnInfo = map.get("column_info");
        assertTrue(columnInfo instanceof ColumnInfoEntity);
        ColumnInfoEntity cie = (ColumnInfoEntity) columnInfo;
        Map<String, ColumnInfoDetails> cieMap = cie.getFields();
        assertNotNull(cieMap);
        assertEquals(cieMap.size(), 16);
        assertTrue(cieMap.containsKey("TELEPHON"));
        ColumnInfoDetails cid = cieMap.get("TELEPHON");
        assertNotNull(cid);
        assertEquals(cid.getOmrsGuid(), "b1c497ce.60641b50.0ij7chrnb.i9pl06g.hg0qqr.qibh5q96t4clfits2blbv");
        assertNotNull(cid.getColumnTerms());
        assertEquals(cid.getColumnTerms().size(), 1);
        assertEquals(cid.getColumnTerms().get(0).getTermDisplayName(), "Telephone");
        assertEquals(cid.getColumnTerms().get(0).getTermId(), "5d2d5419-0032-4c64-90e2-ce68c6997bb5_28728be6-25ab-440f-b782-04246357d045");
        assertEquals(cid.getColumnTerms().get(0).getSourceMetadataCollectionId(), REPOSITORY_ID);
        AbstractAssetEntity dataProfile = map.get("data_profile");
        assertTrue(dataProfile instanceof DataProfileEntity);
        DataProfileEntity dpe = (DataProfileEntity) dataProfile;
        Map<String, DataProfile> dpeMap = dpe.getProfiles();
        assertNotNull(dpeMap);
        assertEquals(dpeMap.size(), 1);
        assertTrue(dpeMap.containsKey("f4efc9d0-62f7-4600-9175-01bf983dd970"));
        DataProfile dp = dpeMap.get("f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertNotNull(dp);
        assertNotNull(dp.getMetadata());
        assertEquals(dp.getMetadata().getGuid(), "f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertEquals(dp.getMetadata().getAssetId(), "f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertEquals(dp.getMetadata().getDatasetId(), "91636d5b-b322-4f86-a942-9ffb3b53ea3e");
        assertEquals(dp.getMetadata().getUrl(), "https://internal-nginx-svc:12443/v2/data_profiles/f4efc9d0-62f7-4600-9175-01bf983dd970?catalog_id=92b84496-9961-47d8-ab1b-23212ab8a944&dataset_id=91636d5b-b322-4f86-a942-9ffb3b53ea3e");
        assertEquals(dp.getMetadata().getCatalogId(), "92b84496-9961-47d8-ab1b-23212ab8a944");
        assertNotNull(dp.getMetadata().getCreatedAt());
        assertNotNull(dp.getMetadata().getAccessedAt());
        assertEquals(dp.getMetadata().getOwner(), "icp4d-dev");
        assertEquals(dp.getMetadata().getOwnerId(), "icp4d-dev");
        assertEquals(dp.getMetadata().getLastUpdaterId(), "icp4d-dev");
        assertNotNull(dp.getEntity());
        assertNotNull(dp.getEntity().getDataProfile());
        assertNotNull(dp.getEntity().getDataProfile().getOptions());
        assertFalse(dp.getEntity().getDataProfile().getOptions().getDisableProfiling());
        assertEquals(dp.getEntity().getDataProfile().getOptions().getMaxRowCount(), Double.valueOf(5000.0));
        assertEquals(dp.getEntity().getDataProfile().getOptions().getMaxDistributionSize(), Double.valueOf(100.0));
        assertEquals(dp.getEntity().getDataProfile().getOptions().getMaxNumericStatsBins(), Double.valueOf(100.0));
        assertEquals(dp.getEntity().getDataProfile().getOptions().getMaxColumnsPerTask(), Double.valueOf(250.0));
        assertEquals(dp.getEntity().getDataProfile().getOptions().getMaxRowsPerBatch(), Double.valueOf(250.0));
        assertFalse(dp.getEntity().getDataProfile().getOptions().getEnableFastClassification());
        assertTrue(dp.getEntity().getDataProfile().getOptions().getEnableDqa());
        assertNotNull(dp.getEntity().getDataProfile().getOptions().getClassificationOptions());
        assertFalse(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getDisabled());
        assertTrue(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getUseAllIbmClasses());
        assertTrue(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getUseAllCustomClasses());
        assertNotNull(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getIbmClassCodes());
        assertTrue(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getIbmClassCodes().isEmpty());
        assertNotNull(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getCustomClassCodes());
        assertTrue(dp.getEntity().getDataProfile().getOptions().getClassificationOptions().getCustomClassCodes().isEmpty());
        assertNotNull(dp.getEntity().getDataProfile().getExecution());
        assertEquals(dp.getEntity().getDataProfile().getExecution().getStatus(), "finished");
        assertTrue(dp.getEntity().getDataProfile().getExecution().getSupported());
        assertEquals(dp.getEntity().getDataProfile().getExecution().getDataflowId(), "27dd7a81-d37e-4f98-8452-d43ab82e0b67");
        assertEquals(dp.getEntity().getDataProfile().getExecution().getDataflowRunId(), "42e5f476-f9ad-4c02-8544-23050012f014");
        assertNotNull(dp.getEntity().getDataProfile().getColumns());
        assertTrue(dp.getEntity().getDataProfile().getColumns().isEmpty());
        assertEquals(dp.getEntity().getDataProfile().getAttachmentId(), "704347ba-0184-4bdc-84f5-9072992e6c1c");
        assertEquals(dp.getHref(), "https://internal-nginx-svc:12443/v2/data_profiles/f4efc9d0-62f7-4600-9175-01bf983dd970?catalog_id=92b84496-9961-47d8-ab1b-23212ab8a944&dataset_id=91636d5b-b322-4f86-a942-9ffb3b53ea3e");
        assertNotNull(dpe.getAttributeClasses());
        assertEquals(dpe.getAttributeClasses().size(), 15);
        assertTrue(dpe.getAttributeClasses().contains("US Street Name"));
        assertNotNull(dpe.getAttributeClassificationManual());
        assertEquals(dpe.getAttributeClassificationManual().size(), 1);
        assertEquals(dpe.getAttributeClassificationManual().get(0).getName(), "HOUSING");
        assertNotNull(dpe.getAttributeClassificationManual().get(0).getOverwrittenClass());
        assertNotNull(dpe.getAttributeClassificationManual().get(0).getOverwrittenClass().getClassDetails());
        assertEquals(dpe.getAttributeClassificationManual().get(0).getOverwrittenClass().getClassDetails().getCode(), "5d2d5419-0032-4c64-90e2-ce68c6997bb5_3a8af035-6f30-4756-80e9-b418236a9880");
        assertEquals(dpe.getAttributeClassificationManual().get(0).getOverwrittenClass().getClassDetails().getName(), "Code");
        assertNotNull(dpe.getDataClassificationManual());
        assertEquals(dpe.getDataClassificationManual().size(), 1);
        assertEquals(dpe.getDataClassificationManual().get(0).getId(), "303a23e3-d861-4b4b-bd93-e093f84181d0");
        assertEquals(dpe.getDataClassificationManual().get(0).getName(), "Test");
        assertEquals(dpe.getDataClassificationManual().get(0).getGlobalId(), "5d2d5419-0032-4c64-90e2-ce68c6997bb5_303a23e3-d861-4b4b-bd93-e093f84181d0");
        AbstractAssetEntity assetTerms = map.get("asset_terms");
        assertTrue(assetTerms instanceof AssetTermsEntity);
        AssetTermsEntity at = (AssetTermsEntity) assetTerms;
        assertNotNull(at);
        assertNotNull(at.getList());
        assertEquals(at.getList().size(), 1);
        assertEquals(at.getList().get(0).getTermDisplayName(), "Customer");
        assertEquals(at.getList().get(0).getTermId(), "5d2d5419-0032-4c64-90e2-ce68c6997bb5_f2a436fb-dae4-40e8-9417-3c602234834f");
        assertEquals(at.getList().get(0).getSourceMetadataCollectionId(), REPOSITORY_ID);
        assertNotNull(response.getAttachments());
        assertEquals(response.getAttachments().size(), 2);
        Attachment one = response.getAttachments().get(0);
        assertNotNull(one);
        assertEquals(one.getId(), "18d97b03-0c74-4672-b6e1-159e48336b04");
        assertEquals(one.getVersion(), Double.valueOf(2.0));
        assertEquals(one.getAssetType(), "data_asset");
        assertEquals(one.getName(), "CUSTOMER");
        assertEquals(one.getDescription(), "");
        assertEquals(one.getMime(), "application/octet-stream");
        assertEquals(one.getConnectionId(), "68cc3069-6d14-401b-aa64-6f615e543558");
        assertEquals(one.getConnectionPath(), "/CP4DEMO/CUSTOMER");
        assertEquals(one.getDatasourceType(), "8c1a4480-1c29-4b33-9086-9cb799d7b157");
        assertEquals(one.getCreatorId(), "icp4d-dev");
        assertEquals(one.getCreateTime(), Long.valueOf(1607516804667L));
        assertEquals(one.getSize(), Long.valueOf(0));
        assertTrue(one.getRemote());
        assertFalse(one.getManaged());
        assertFalse(one.getReferenced());
        assertFalse(one.getObjectKeyReadOnly());
        assertTrue(one.getUserProvidedPathKey());
        assertTrue(one.getTransferComplete());
        assertFalse(one.getIsPartitioned());
        assertEquals(one.getCompleteTimeTicks(), Long.valueOf(1607516804667L));
        assertEquals(one.getTestDoc(), Long.valueOf(0L));
        assertNotNull(one.getUsage());
        assertEquals(one.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(one.getUsage().getLastAccessorId(), "icp4d-dev");
        assertEquals(one.getUsage().getLastAccessTime(), Long.valueOf(1607516804667L));
        one = response.getAttachments().get(1);
        assertNotNull(one);
        assertEquals(one.getId(), "704347ba-0184-4bdc-84f5-9072992e6c1c");
        assertEquals(one.getVersion(), Double.valueOf(2.0));
        assertEquals(one.getAssetType(), "data_profile");
        assertEquals(one.getName(), "data_profile_f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertEquals(one.getDatasourceType(), "81bafdbd-b7c6-45c5-a4fd-6ec135f66f4e");
        assertEquals(one.getObjectKey(), "data_profile_f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertEquals(one.getCreatorId(), "icp4d-dev");
        assertEquals(one.getCreateTime(), Long.valueOf(1607516917217L));
        assertEquals(one.getSize(), Long.valueOf(159322L));
        assertFalse(one.getRemote());
        assertFalse(one.getManaged());
        assertTrue(one.getReferenced());
        assertFalse(one.getObjectKeyReadOnly());
        assertTrue(one.getUserProvidedPathKey());
        assertTrue(one.getTransferComplete());
        assertFalse(one.getIsPartitioned());
        assertEquals(one.getCompleteTimeTicks(), Long.valueOf(1607516917217L));
        assertEquals(one.getTestDoc(), Long.valueOf(0L));
        assertNotNull(one.getHandle());
        // TODO: complete validating the attachment -- don't forget to add the new Attachment and AttachmentHeader classes to git
        assertNotNull(one.getUsage());
        assertEquals(one.getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(one.getUsage().getLastAccessorId(), "icp4d-dev");
        assertEquals(one.getUsage().getLastAccessTime(), Long.valueOf(1607516917217L));
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
        assertEquals(asset.getEntity().size(), 1);
        assertTrue(asset.getEntity().containsKey("test_type"));
        AbstractAssetEntity entity = asset.getEntity().get("test_type");
        assertTrue(entity instanceof CustomFieldAssetEntity);
        CustomFieldAssetEntity cfae = (CustomFieldAssetEntity) entity;
        assertNotNull(cfae);
        assertEquals(cfae.getFields().size(), 1);
        assertTrue(cfae.getFields().containsKey("test_field"));
        assertEquals(cfae.getFields().get("test_field"), "Sample value for the asset's custom field.");
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
