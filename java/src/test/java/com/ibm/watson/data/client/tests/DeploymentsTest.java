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
import com.ibm.watson.data.client.api.DeploymentsApi;
import com.ibm.watson.data.client.api.SpacesApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Deployments API endpoints.
 */
public class DeploymentsTest extends AbstractExpectations {

    private final DeploymentsApi api = new DeploymentsApi(MockConstants.getApiClient());

    public DeploymentsTest() {
        super(DeploymentsApi.BASE_API, "deployment");
    }

    private final LocalDate version = LocalDate.now();
    private final Map<String, List<String>> createParams = new HashMap<>();
    private final Map<String, List<String>> queryParams = new HashMap<>();
    private void setupParams() {
        List<String> v = new ArrayList<>();
        v.add(version.toString());
        queryParams.put("version", v);
        createParams.put("version", v);
        List<String> s = new ArrayList<>();
        s.add(SPACE_GUID);
        queryParams.put("space_id", s);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", createParams, "create", 202);
        setupTest(client, "GET", "/" + DEPLOYMENT_GUID, queryParams, "get");
        setupTest(client, "GET", "", queryParams, "list");
        setupTest(client, "PATCH", "/" + DEPLOYMENT_GUID, queryParams, "update");
        setupTest(client, "POST", "/" + DEPLOYMENT_GUID + "/predictions", createParams, "predict");
        setupTest(client, "DELETE", "/" + DEPLOYMENT_GUID, queryParams, "delete", 204);
    }

    @Test
    public void testCreate() {
        DeploymentEntityRequest body = readRequestFromFile("create", new TypeReference<DeploymentEntityRequest>() {});
        DeploymentResource created = api.create(version, body).block();
        validateDeployment(created, DeploymentState.INITIALIZING, "A deployment to test the API works as expected.");
    }

    @Test
    public void testGet() {
        DeploymentResource deployment = api.get(version, DEPLOYMENT_GUID, SPACE_GUID).block();
        validateDeployment(deployment, DeploymentState.READY, "A deployment to test the API works as expected.");
        assertNotNull(deployment);
        assertNotNull(deployment.getEntity());
        assertNotNull(deployment.getEntity().getHardwareSpec());
        assertEquals(deployment.getEntity().getHardwareSpec().getId(), "Not_Applicable");
        assertEquals(deployment.getEntity().getHardwareSpec().getName(), "S");
        assertEquals(deployment.getEntity().getHardwareSpec().getNumNodes(), Integer.valueOf(1));
    }

    @Test
    public void testList() {
        DeploymentResources response = api.list(version, SPACE_GUID, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        validateDeployment(response.getResources().get(0), DeploymentState.READY, "A deployment to test the API works as expected.");
    }

    @Test
    public void testUpdate() {
        List<JSONResourcePatchModel> body = readRequestFromFile("update", new TypeReference<List<JSONResourcePatchModel>>() {});
        DeploymentResource updated = api.update(version, DEPLOYMENT_GUID, SPACE_GUID, body).block();
        validateDeployment(updated, DeploymentState.READY, "Now with an updated description.");
    }

    @Test
    public void testPredict() {
        SyncScoringData body = readRequestFromFile("predict", new TypeReference<SyncScoringData>() {});
        SyncScoringDataResults results = api.predict(version, DEPLOYMENT_GUID, body).block();
        assertNotNull(results);
        assertNotNull(results.getPredictions());
        assertEquals(results.getPredictions().size(), 1);
        ScoringPayload one = results.getPredictions().get(0);
        assertNotNull(one);
        assertNotNull(one.getFields());
        assertEquals(one.getFields().size(), 2);
        assertEquals(one.getFields().get(0), "prediction");
        assertEquals(one.getFields().get(1), "probability");
        assertNotNull(one.getValues());
        assertEquals(one.getValues().size(), 1);
        List<Object> value = one.getValues().get(0);
        assertNotNull(value);
        assertEquals(value.size(), 2);
        assertEquals(value.get(0), "Risk");
        assertTrue(value.get(1) instanceof List);
        List<?> numbers = (List<?>) value.get(1);
        assertNotNull(numbers);
        assertEquals(numbers.size(), 2);
        assertTrue(numbers.get(0) instanceof Double);
        assertEquals(numbers.get(0), 0.49456965923309326);
        assertTrue(numbers.get(1) instanceof Double);
        assertEquals(numbers.get(1), 0.5054303407669067);
    }

    @Test
    public void testDelete() {
        api.delete(version, DEPLOYMENT_GUID, SPACE_GUID).block();
    }

    private void validateDeployment(DeploymentResource deployment, DeploymentState state, String description) {
        assertNotNull(deployment);
        validateDeploymentEntity(deployment.getEntity(), state, description);
        validateDeploymentMetadata(deployment.getMetadata(), description);
    }

    private void validateDeploymentEntity(DeploymentEntity entity, DeploymentState state, String description) {
        assertNotNull(entity);
        assertNotNull(entity.getAsset());
        assertEquals(entity.getAsset().getId(), MODEL_GUID);
        assertNotNull(entity.getCustom());
        assertTrue(entity.getCustom().isEmpty());
        assertEquals(entity.getDeployedAssetType(), DeployedAssetType.MODEL);
        assertEquals(entity.getDescription(), description);
        assertEquals(entity.getName(), "Test Deployment");
        assertNotNull(entity.getOnline());
        assertNotNull(entity.getOnline().getParameters());
        assertTrue(entity.getOnline().getParameters().isEmpty());
        assertNull(entity.getBatch());
        assertNull(entity.getVirtual());
        assertEquals(entity.getSpaceId(), SPACE_GUID);
        assertNotNull(entity.getStatus());
        assertNotNull(entity.getStatus().getOnlineUrl());
        assertNotNull(entity.getStatus().getOnlineUrl().getUrl());
        assertNull(entity.getStatus().getVirtualDeploymentDownloads());
        assertEquals(entity.getStatus().getState(), state);
    }

    private void validateDeploymentMetadata(ResourceMeta metadata, String description) {
        assertNotNull(metadata);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getDescription(), description);
        assertEquals(metadata.getId(), DEPLOYMENT_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getName(), "Test Deployment");
        assertEquals(metadata.getOwner(), EXSTUSER_GUID);
        assertEquals(metadata.getSpaceId(), SPACE_GUID);
    }

}
