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
import com.ibm.watson.data.client.api.JobsApiV2;
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
 * Test the Jobs API endpoints.
 */
public class JobsTest extends AbstractExpectations {

    private final JobsApiV2 api = new JobsApiV2(MockConstants.getApiClient());

    public JobsTest() {
        super(JobsApiV2.BASE_API, "jobs");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> project = new ArrayList<>();
        project.add(PROJECT_GUID);
        params.put("project_id", project);
    }

    private static final String jobEndpoint = "/" + NEW_JOB_GUID;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "DELETE", jobEndpoint, params, "delete", 204);
        setupTest(client, "GET", "", params, "list");
        setupTest(client, "GET", jobEndpoint, params, "get");
        setupTest(client, "PATCH", jobEndpoint, params, "update");
        setupTest(client, "POST", "", params, "create", 201);
    }

    @Test
    public void testCreate() {
        JobPostBody body = readRequestFromFile("create", new TypeReference<JobPostBody>() {});
        Job response = api.create(body, PROJECT_GUID, null).block();
        assertNotNull(response);
        validateJobMetadata(response.getMetadata(), "", 1597240856908L);
        validateJobEntity(response.getEntity());
        assertNotNull(response.getHref());
        assertEquals(response.getAssetId(), NEW_JOB_GUID);
    }

    @Test
    public void testList() {
        ListJobResponse response = api.list(PROJECT_GUID, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalRows(), Long.valueOf(1L));
        assertNotNull(response.getResults());
        assertEquals(response.getResults().size(), 1);
        Job one = response.getResults().get(0);
        assertNotNull(one.getMetadata());
        // TODO: unclear why the version is always 0 in the list response, where it is 2 elsewhere
        validateJobMetadataHeader(one.getMetadata(), 0);
        validateJobEntity(one.getEntity());
    }

    @Test
    public void testGet() {
        Job response = api.get(NEW_JOB_GUID, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        validateJobMetadataHeader(response.getMetadata(), 2);
        validateJobEntity(response.getEntity());
    }

    @Test
    public void testUpdate() {
        List<JSONResourcePatchModel> body = readRequestFromFile("update", new TypeReference<List<JSONResourcePatchModel>>() {});
        Job response = api.update(NEW_JOB_GUID, body, PROJECT_GUID, null).block();
        assertNotNull(response);
        validateJobMetadata(response.getMetadata(), "New description of the job.", 1597263564418L);
        validateJobEntity(response.getEntity());
        assertNotNull(response.getHref());
    }

    @Test
    public void testDelete() {
        api.delete(NEW_JOB_GUID, PROJECT_GUID, null).block();
    }

    private void validateJobMetadataHeader(MetadataAsset metadata, int version) {
        validateJobMetadataHeader(metadata, "", version);
    }

    private void validateJobMetadataHeader(MetadataAsset metadata, String description, int version) {
        assertEquals(metadata.getName(), "Test Job");
        assertEquals(metadata.getDescription(), description);
        assertEquals(metadata.getAssetId(), NEW_JOB_GUID);
        assertEquals(metadata.getOwnerId(), EXSTUSER_GUID);
        assertEquals(metadata.getVersion(), Double.valueOf(version));
    }

    private void validateJobMetadata(MetadataAsset metadata, String description, Long lastUpdate) {
        assertNotNull(metadata);
        validateJobMetadataHeader(metadata, description, 2);
        assertNotNull(metadata.getRov());
        assertEquals(metadata.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(metadata.getRov().getCollaboratorIds());
        assertEquals(metadata.getProjectId(), PROJECT_GUID);
        assertNotNull(metadata.getUsage());
        assertNotNull(metadata.getUsage().getLastUpdatedAt());
        assertEquals(metadata.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertEquals(metadata.getUsage().getLastUpdateTime(), lastUpdate);
        assertNotNull(metadata.getUsage().getLastAccessedAt());
        assertEquals(metadata.getUsage().getLastAccessTime(), lastUpdate);
        assertEquals(metadata.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(metadata.getUsage().getAccessCount(), Integer.valueOf(0));
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertEquals(metadata.getAssetType(), "job");
        assertEquals(metadata.getOriginCountry(), "us");
        assertEquals(metadata.getRating(), Double.valueOf(0));
        assertEquals(metadata.getTotalRatings(), Long.valueOf(0));
        assertEquals(metadata.getCatalogId(), "2ea819ce-95b5-4e11-8d46-dd1ba8865f14");
        assertEquals(metadata.getCreated(), Long.valueOf(1597240856908L));
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getSize(), Long.valueOf(0));
        assertEquals(metadata.getAssetState(), "available");
        assertNotNull(metadata.getAssetAttributes());
        assertEquals(metadata.getAssetAttributes().size(), 1);
        assertTrue(metadata.getAssetAttributes().contains("job"));
        assertEquals(metadata.getAssetCategory(), AssetCategory.USER);
    }

    private void validateJobEntity(JobEntity entity) {
        assertNotNull(entity);
        JobEntityJob job = entity.getJob();
        assertNotNull(job);
        assertEquals(job.getAssetRef(), "046a6b3c-fc32-4905-a287-fac2486c6b20");
        assertEquals(job.getAssetRefType(), "data_flow");
        assertNotNull(job.getConfiguration());
        assertEquals(job.getConfiguration().getEnvId(), "shaper_rruntime");
        assertEquals(job.getConfiguration().getEnvType(), "shaper_rruntime");
        assertNotNull(job.getConfiguration().getEnvVariables());
        assertEquals(job.getConfiguration().getEnvVariables().size(), 0);
        assertEquals(job.getLastRunInitiator(), "None");
        assertNull(job.getLastRunTime());
        assertEquals(job.getLastRunStatus(), "None");
        assertEquals(job.getLastRunStatusTimestamp(), Integer.valueOf(0));
    }

}