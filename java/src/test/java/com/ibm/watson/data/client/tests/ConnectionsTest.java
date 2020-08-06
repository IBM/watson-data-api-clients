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
import com.ibm.watson.data.client.api.ConnectionsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.AssetCategory;
import com.ibm.watson.data.client.model.enums.DatasourceTypePropertyType;
import org.mockserver.client.MockServerClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Tests and expectations for the Connections API endpoints.
 */
public class ConnectionsTest extends AbstractExpectations {

    private final ConnectionsApiV2 api = new ConnectionsApiV2(getApiClient());

    public ConnectionsTest() {
        super(ConnectionsApiV2.BASE_API, "connections");
    }

    private final Map<String, List<String>> discoverParams = new HashMap<>();
    private final Map<String, List<String>> discoverAnonParams = new HashMap<>();
    private final Map<String, List<String>> projectParams = new HashMap<>();
    private void setupParams() {
        List<String> project = new ArrayList<>();
        project.add(PROJECT_GUID);
        projectParams.put("project_id", project);
        List<String> path = new ArrayList<>();
        path.add("SCHEMA_NAME");
        discoverParams.put("path", path);
        discoverParams.put("project_id", project);
        discoverAnonParams.put("path", path);
    }

    private static final String connectionGuidEndpoint = "/" + CONNECTION_GUID;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "DELETE", connectionGuidEndpoint, "delete", 204);
        setupTest(client, "GET", connectionGuidEndpoint + "/assets", discoverParams, "discoverAssets");
        setupTest(client, "POST", "/assets", discoverAnonParams, "discoverAssetsAnonymously");
        setupTest(client, "GET", connectionGuidEndpoint, projectParams, "get");
        setupTest(client, "GET", connectionGuidEndpoint + "/actions", projectParams, "listActions");
        setupTest(client, "GET", "", projectParams, "list");
        setupTest(client, "PUT", connectionGuidEndpoint + "/actions/get_record_count", projectParams, "performAction");
        setupTest(client, "POST", "", projectParams, "create", 201);
        setupTest(client, "PATCH", connectionGuidEndpoint, projectParams, "update");
        setupTest(client, "POST", "/upgrade", projectParams, "upgrade", 403);
    }

    @Test
    public void testCreate() {
        ConnectionEntity body = readRequestFromFile("create", new TypeReference<ConnectionEntity>() {});
        ConnectionAsset response = api.create(body, null, PROJECT_GUID, null, null).block();
        validateConnection(response);
    }

    @Test
    public void testList() {
        ConnectionCollection response = api.list(null, PROJECT_GUID, null, null, null, null, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        validateConnection(response.getResources().get(0));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
        assertEquals(response.getTotalCount(), Integer.valueOf(1));
    }

    @Test
    public void testGet() {
        ConnectionAsset response = api.get(CONNECTION_GUID, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        validateConnection(response);
    }

    @Test
    public void testListActions() {
        ConnectionActions response = api.listActions(CONNECTION_GUID, null, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertNotNull(response.getActions());
        assertEquals(response.getActions().size(), 1);
        DatasourceTypeAction one = response.getActions().get(0);
        assertEquals(one.getName(), "get_record_count");
        assertEquals(one.getDescription(), "Get the number of rows in the specified table");
        assertNotNull(one.getProperties());
        assertNotNull(one.getProperties().getInput());
        assertEquals(one.getProperties().getInput().size(), 2);
        DatasourceTypeProperty other = one.getProperties().getInput().get(0);
        assertEquals(other.getName(), "schema_name");
        assertEquals(other.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(other.getLabel(), "Schema Name");
        assertEquals(other.getDescription(), "Name of the schema that contains the table");
        assertFalse(other.getRequired());
        assertFalse(other.getMasked());
        assertFalse(other.getHidden());
        assertFalse(other.getReadonly());
        assertFalse(other.getMultiline());
        assertNotNull(one.getProperties().getOutput());
        assertEquals(one.getProperties().getOutput().size(), 1);
        other = one.getProperties().getOutput().get(0);
        assertEquals(other.getName(), "record_count");
        assertEquals(other.getType(), DatasourceTypePropertyType.INTEGER);
        assertEquals(other.getLabel(), "Record Count");
        assertEquals(other.getDescription(), "Number of available rows");
        assertTrue(other.getRequired());
        assertFalse(other.getMasked());
        assertFalse(other.getHidden());
        assertFalse(other.getReadonly());
        assertFalse(other.getMultiline());
    }

    @Test
    public void testPerformAction() {
        Map<String, Object> body = readRequestFromFile("performAction", new TypeReference<Map<String, Object>>() {});
        Map<String, Object> response = api.performAction(CONNECTION_GUID, "get_record_count", body, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        assertEquals(response.get("record_count"), 5001.0);
    }

    @Test
    public void testDiscoverAssets() {
        DiscoveredAssetCollection response = api.discoverAssets(CONNECTION_GUID, "SCHEMA_NAME", null, PROJECT_GUID, null, null, null, null, null, null, null, null, null, null, null, null, null).block();
        validateDiscoveredAssets(response);
    }

    @Test
    public void testDiscoverAssetsAnonymously() {
        ConnectionEntity body = readRequestFromFile("discoverAssetsAnonymously", new TypeReference<ConnectionEntity>() {});
        DiscoveredAssetCollection response = api.discoverAssetsAnonymously("SCHEMA_NAME", body, null, null, null, null, null, null, null, null).block();
        validateDiscoveredAssets(response);
        assertNotNull(response);
        assertNotNull(response.getPrev());
        assertNotNull(response.getPrev().getHref());
        assertNotNull(response.getNext());
        assertNotNull(response.getNext().getHref());
    }

    @Test
    public void testUpdate() {
        List<JSONResourcePatchModel> body = readRequestFromFile("update", new TypeReference<List<JSONResourcePatchModel>>() {});
        ConnectionEntity response = api.update(CONNECTION_GUID, body, null, PROJECT_GUID, null, null).block();
        assertNotNull(response);
        validateConnectionEntity(response, "An updated test connection description.");
    }

    @Test
    public void testUpgrade() {
        // TODO: need to whitelist user ID to allow the upgrade API to be used
        assertThrows(WebClientResponseException.Forbidden.class, () -> api.upgrade(null, PROJECT_GUID, null, null, null).block());
    }

    @Test
    public void testDelete() {
        api.delete(CONNECTION_GUID, null, PROJECT_GUID, null).block();
    }

    private void validateDiscoveredAssets(DiscoveredAssetCollection response) {
        assertNotNull(response);
        assertEquals(response.getPath(), "SCHEMA_NAME");
        assertNotNull(response.getAssetTypes());
        assertEquals(response.getAssetTypes().size(), 1);
        assertNotNull(response.getAssetTypes().get(0));
        assertEquals(response.getAssetTypes().get(0).getType(), "table");
        assertTrue(response.getAssetTypes().get(0).getDataset());
        assertFalse(response.getAssetTypes().get(0).getDatasetContainer());
        assertNotNull(response.getAssets());
        assertEquals(response.getAssets().size(), 2);
        DiscoveredAsset one = response.getAssets().get(0);
        assertEquals(one.getId(), "BANKRELN");
        assertEquals(one.getType(), "table");
        assertEquals(one.getName(), "BANKRELN");
        assertEquals(one.getPath(), "/SCHEMA_NAME/BANKRELN");
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
        assertEquals(response.getTotalCount(), Integer.valueOf(2));
    }

    private void validateConnection(ConnectionAsset response) {
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        assertEquals(response.getMetadata().getAssetId(), CONNECTION_GUID);
        assertEquals(response.getMetadata().getAssetType(), "connection");
        assertEquals(response.getMetadata().getAssetCategory(), AssetCategory.USER);
        assertNotNull(response.getMetadata().getCreateTime());
        assertEquals(response.getMetadata().getProjectId(), PROJECT_GUID);
        assertNotNull(response.getMetadata().getTags());
        assertEquals(response.getMetadata().getTags().size(), 0);
        assertNotNull(response.getMetadata().getUsage());
        assertNotNull(response.getMetadata().getUsage().getLastAccessTime());
        assertEquals(response.getMetadata().getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(response.getMetadata().getUsage().getAccessCount(), Integer.valueOf(0));
        assertEquals(response.getMetadata().getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(response.getMetadata().getUsage().getAccessCount(), Integer.valueOf(0));
        validateConnectionEntity(response.getEntity(), "");
    }

    private void validateConnectionEntity(ConnectionEntity entity, String description) {
        assertNotNull(entity);
        assertEquals(entity.getDatasourceType(), "506039fb-802f-4ef2-a2bf-c1682e9c8aa2");
        assertEquals(entity.getDescription(), description);
        assertEquals(entity.getName(), "Test Connection");
        assertEquals(entity.getOriginCountry(), "gb");
        assertEquals(entity.getOwnerId(), EXSTUSER_GUID);
        assertNotNull(entity.getRov());
        assertEquals(entity.getRov().getMode(), Integer.valueOf(0));
        assertNotNull(entity.getProperties());
        assertEquals(entity.getProperties().get("database"), "db_name");
        assertEquals(entity.getProperties().get("password"), "password");
        assertEquals(entity.getProperties().get("host"), "example.com");
        assertEquals(entity.getProperties().get("username"), "username");
        assertNotNull(entity.getInteractionProperties());
        List<DatasourceTypeProperty> sourceProperties = entity.getInteractionProperties().getSource();
        assertNotNull(sourceProperties);
        assertEquals(sourceProperties.size(), 6);
        DatasourceTypeProperty one = sourceProperties.get(5);
        assertNotNull(one);
        assertEquals(one.getName(), "table_name");
        assertEquals(one.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(one.getLabel(), "Table Name");
        assertEquals(one.getDescription(), "The name of the table to read from");
        assertTrue(one.getRequired());
        assertFalse(one.getMasked());
        assertFalse(one.getHidden());
        assertFalse(one.getReadonly());
        assertFalse(one.getMultiline());
        List<DatasourceTypeProperty> targetProperties = entity.getInteractionProperties().getTarget();
        assertNotNull(targetProperties);
        assertEquals(targetProperties.size(), 7);
        one = targetProperties.get(1);
        assertEquals(one.getName(), "existing_table_action");
        assertEquals(one.getType(), DatasourceTypePropertyType.ENUM);
        assertEquals(one.getLabel(), "Table Action");
        assertEquals(one.getDescription(), "The action to take on the target table, if it already exists, to handle the existing and new data sets");
        assertFalse(one.getRequired());
        assertFalse(one.getMasked());
        assertTrue(one.getHidden());
        assertFalse(one.getReadonly());
        assertFalse(one.getMultiline());
        assertEquals(one.getDefaultValue(), "append");
        assertNotNull(one.getValues());
        assertEquals(one.getValues().size(), 5);
        assertEquals(one.getValues().get(0).getValue(), "append");
        assertEquals(one.getValues().get(0).getLabel(), "Append");
    }

}
