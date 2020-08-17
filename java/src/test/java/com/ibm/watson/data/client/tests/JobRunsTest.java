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
import com.ibm.watson.data.client.api.JobRunsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.AssetCategory;
import com.ibm.watson.data.client.model.enums.JobRunState;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Job Runs API endpoints.
 */
public class JobRunsTest extends AbstractExpectations {

    private final JobRunsApiV2 api = new JobRunsApiV2(MockConstants.getApiClient());

    public JobRunsTest() {
        super(JobRunsApiV2.BASE_API, "jobRuns");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> project = new ArrayList<>();
        project.add(PROJECT_GUID);
        params.put("project_id", project);
    }

    private static final String runEndpoint = "/" + JOB_RUN_GUID;

    @Override
    public void init(MockServerClient client) {
        injectIntoBaseUrl("{job_id}", NEW_JOB_GUID);
        setupParams();
        setupTest(client, "GET", "", params, "list");
        setupTest(client, "POST", "", params, "start", 201);
        setupTest(client, "POST", runEndpoint + "/cancel", params, "cancel", 204);
        setupTest(client, "DELETE", runEndpoint, params, "delete", 204);
        setupTest(client, "GET", runEndpoint, params, "get");
        setupTest(client, "GET", runEndpoint + "/logs", params, "getRuntimeLog");
    }

    @Test
    public void testStart() {
        JobRunPostBody body = readRequestFromFile("start", new TypeReference<JobRunPostBody>() {});
        JobRun response = api.start(NEW_JOB_GUID, body, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        validateJobRunMetadata(response.getMetadata());
        assertNotNull(response.getEntity());
        validateJobRunEntity(response.getEntity(), JobRunState.STARTING);
        assertNotNull(response.getHref());
    }

    @Test
    public void testList() {
        ListJobRunResponse response = api.list(NEW_JOB_GUID, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalRows(), Long.valueOf(1L));
        assertNotNull(response.getResults());
        assertEquals(response.getResults().size(), 1);
        JobRun one = response.getResults().get(0);
        assertNotNull(one.getMetadata());
        validateJobRunMetadataHeader(one.getMetadata(), 0L);
        assertNotNull(one.getEntity());
        validateCompletedJobRunEntity(one.getEntity());
    }

    @Test
    public void testGet() {
        JobRun response = api.get(NEW_JOB_GUID, JOB_RUN_GUID, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        validateJobRunMetadataHeader(response.getMetadata(), 1597652845983L);
        assertNotNull(response.getEntity());
        validateCompletedJobRunEntity(response.getEntity());
    }

    @Test
    public void testGetRuntimeLog() {
        LogsResponse response = api.getRuntimeLog(NEW_JOB_GUID, JOB_RUN_GUID, PROJECT_GUID, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalCount(), Integer.valueOf(105));
        assertNotNull(response.getResults());
        assertEquals(response.getResults().size(), 105);
        assertEquals(response.getResults().get(0), "Setting up certificate");
    }

    @Test
    public void testCancel() {
        Object body = readRequestFromFile("cancel", new TypeReference<Object>() {});
        api.cancel(NEW_JOB_GUID, JOB_RUN_GUID, body, PROJECT_GUID, null).block();
    }

    @Test
    public void testDelete() {
        api.delete(NEW_JOB_GUID, JOB_RUN_GUID, PROJECT_GUID, null).block();
    }

    private void validateJobRunMetadataHeader(MetadataAsset metadata, Long created) {
        assertEquals(metadata.getName(), "job run");
        assertEquals(metadata.getDescription(), "");
        assertEquals(metadata.getAssetId(), JOB_RUN_GUID);
        assertEquals(metadata.getOwnerId(), EXSTUSER_GUID);
        assertEquals(metadata.getCreated(), created);
        assertNotNull(metadata.getCreatedAt());
    }

    private void validateJobRunMetadata(MetadataAsset metadata) {
        validateJobRunMetadataHeader(metadata, 1597652845983L);
        assertNotNull(metadata.getRov());
        assertEquals(metadata.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(metadata.getRov().getCollaboratorIds());
        assertEquals(metadata.getProjectId(), PROJECT_GUID);
        assertEquals(metadata.getSandboxId(), PROJECT_GUID);
        assertNotNull(metadata.getUsage());
        assertNotNull(metadata.getUsage().getLastUpdatedAt());
        assertEquals(metadata.getUsage().getLastUpdaterId(), EXSTUSER_GUID);
        assertEquals(metadata.getUsage().getLastUpdateTime(), Long.valueOf(1597652845983L));
        assertNotNull(metadata.getUsage().getLastAccessedAt());
        assertEquals(metadata.getUsage().getLastAccessTime(), Long.valueOf(1597652845983L));
        assertEquals(metadata.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(metadata.getUsage().getAccessCount(), Integer.valueOf(0));
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertEquals(metadata.getAssetType(), "job_run");
        assertEquals(metadata.getOriginCountry(), "us");
        assertEquals(metadata.getRating(), Double.valueOf(0));
        assertEquals(metadata.getTotalRatings(), Long.valueOf(0));
        assertEquals(metadata.getCatalogId(), "2ea819ce-95b5-4e11-8d46-dd1ba8865f14");
        assertEquals(metadata.getSize(), Long.valueOf(0));
        assertEquals(metadata.getVersion(), Double.valueOf(2));
        assertEquals(metadata.getAssetState(), "available");
        assertNotNull(metadata.getAssetAttributes());
        assertEquals(metadata.getAssetAttributes().size(), 1);
        assertTrue(metadata.getAssetAttributes().contains("job_run"));
        assertEquals(metadata.getAssetCategory(), AssetCategory.USER);
        assertNotNull(metadata);
        assertNotNull(metadata.getRov());
    }

    private void validateJobRunEntity(JobRunEntity entity, JobRunState state) {
        assertNotNull(entity);
        JobRunEntityJobRun job = entity.getJobRun();
        assertNotNull(job);
        assertEquals(job.getJobRef(), NEW_JOB_GUID);
        assertEquals(job.getState(), state);
        assertFalse(job.getIsScheduledRun());
        assertNotNull(job.getConfiguration());
        assertEquals(job.getConfiguration().getEnvId(), "shaper_rruntime");
        assertEquals(job.getConfiguration().getEnvType(), "shaper_rruntime");
        assertNotNull(job.getConfiguration().getEnvVariables());
        assertEquals(job.getConfiguration().getEnvVariables().size(), 0);
    }

    private void validateCompletedJobRunEntity(JobRunEntity entity) {
        validateJobRunEntity(entity, JobRunState.COMPLETED);
        JobRunEntityJobRun job = entity.getJobRun();
        assertNotNull(job);
        assertEquals(job.getRuntimeJobId(), "1597652847-1000331004:7c807ec9e1a6f0ab");
        assertEquals(job.getDuration(), Long.valueOf(59L));
        assertNotNull(job.getDataFlowJobOutput());
        assertEquals(job.getDataFlowJobOutput().getTotalRowsRead(), Long.valueOf(5001L));
        assertEquals(job.getDataFlowJobOutput().getTotalBytesRead(), Long.valueOf(672792L));
        assertEquals(job.getDataFlowJobOutput().getTotalBytesWritten(), Long.valueOf(1088254L));
        assertEquals(job.getDataFlowJobOutput().getTotalRowsWritten(), Long.valueOf(5003L));
        assertEquals(job.getDataFlowJobOutput().getEngineElapsedSecs(), Long.valueOf(59L));
    }

}