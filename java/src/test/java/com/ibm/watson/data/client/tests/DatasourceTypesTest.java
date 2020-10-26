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

import com.ibm.watson.data.client.api.DatasourceTypesApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

/**
 * Test the Datasource Types API endpoints.
 */
public class DatasourceTypesTest extends AbstractExpectations {

    private final DatasourceTypesApiV2 api = new DatasourceTypesApiV2(MockConstants.getApiClient());

    public DatasourceTypesTest() {
        super(DatasourceTypesApiV2.BASE_API, "datasourceTypes");
    }

    private final Map<String, List<String>> details = new HashMap<>();
    private final Map<String, List<String>> headers = new HashMap<>();

    private void setupParams() {
        List<String> include = new ArrayList<>();
        List<String> exclude = new ArrayList<>();
        include.add("true");
        exclude.add("false");
        details.put("connection_properties", include);
        headers.put("connection_properties", exclude);
        details.put("interaction_properties", include);
        headers.put("interaction_properties", exclude);
        details.put("discovery", include);
        headers.put("discovery", exclude);
        details.put("actions", include);
        headers.put("actions", exclude);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "GET", "", headers, "list");
        setupTest(client, "GET", "/bluemixcloudobjectstorage", details, "get");
    }

    @Test
    public void testList() {
        DatasourceTypeCollection response = api.list(null, null, null, null, false, false, false, false, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalCount(), Integer.valueOf(50));
        List<DatasourceType> datasourceTypes = response.getResources();
        assertNotNull(datasourceTypes);
        assertEquals(datasourceTypes.size(), 50);
        for (DatasourceType type : datasourceTypes) {
            assertNotNull(type.getMetadata());
            assertEquals(type.getMetadata().getAssetType(), "datasource_type");
            assertEquals(type.getMetadata().getCreatorId(), "IBM");
            assertNotNull(type.getMetadata().getAssetId());
            assertNotNull(type.getEntity());
            assertNotNull(type.getEntity().getName());
        }
    }

    @Test
    public void testGet() {
        DatasourceType response = api.get("bluemixcloudobjectstorage", null, true, true, true, true).block();
        assertNotNull(response);
        assertNotNull(response.getMetadata());
        assertEquals(response.getMetadata().getAssetId(), "193a97c1-4475-4a19-b90c-295c4fdc6517");
        assertEquals(response.getMetadata().getAssetType(), "datasource_type");
        assertEquals(response.getMetadata().getCreatorId(), "IBM");
        DatasourceTypeEntity entity = response.getEntity();
        assertNotNull(entity);
        assertEquals(entity.getName(), "bluemixcloudobjectstorage");
        assertEquals(entity.getLabel(), "Cloud Object Storage");
        assertEquals(entity.getDescription(), "Cloud Object Storage service on IBM Cloud. Offers S3 API and application binding with regional and cross regional ");
        assertEquals(entity.getType(), DatasourceTypeEnum.FILE);
        assertTrue(entity.getAllowedAsSource());
        assertTrue(entity.getAllowedAsTarget());
        assertEquals(entity.getDataShape(), DataShape.RECTANGULAR);
        assertTrue(entity.getAutoDiscovery());
        assertNotNull(entity.getDiscovery());
        assertNotNull(entity.getDiscovery().getTopLevelFilters());
        assertEquals(entity.getDiscovery().getTopLevelFilters().size(), 2);
        assertTrue(entity.getDiscovery().getTopLevelFilters().contains("include_files"));
        assertNotNull(entity.getDiscovery().getAssetTypes());
        assertEquals(entity.getDiscovery().getAssetTypes().size(), 4);
        DiscoveryAssetType oneDAT = entity.getDiscovery().getAssetTypes().get(0);
        assertNotNull(oneDAT);
        assertEquals(oneDAT.getName(), "excel");
        assertEquals(oneDAT.getLabel(), "Excel File");
        assertNotNull(oneDAT.getNextLevelFilters());
        assertTrue(oneDAT.getNextLevelFilters().contains("depth"));
        assertEquals(entity.getSecureGateway(), SecureGateway.NOT_APPLICABLE);
        DatasourceTypeProperties properties = entity.getProperties();
        assertNotNull(properties);
        assertNotNull(properties.getConnection());
        assertEquals(properties.getConnection().size(), 10);
        DatasourceTypeProperty connection = properties.getConnection().get(0);
        assertEquals(connection.getName(), "access_key");
        assertEquals(connection.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(connection.getLabel(), "Access Key");
        assertEquals(connection.getDescription(), "Connecting to the IBM COS service with the S3 API requires credentials and an endpoint. Credentials consist of an Access Key and a Secret Key. Find the Access Key by going to https://console.ng.bluemix.net/dashboard/services, clicking the Cloud Object Storage service, clicking Service credentials in the left pane, and then clicking View credentials in the Actions column of the Service Credentials table. Copy the value of access_key, not including quotation marks");
        assertFalse(connection.getRequired());
        assertFalse(connection.getMasked());
        assertFalse(connection.getHidden());
        assertFalse(connection.getReadonly());
        assertFalse(connection.getMultiline());
        assertNotNull(connection.getTags());
        assertEquals(connection.getTags().size(), 1);
        assertTrue(connection.getTags().contains("username"));
        assertEquals(connection.getGroup(), "credentials");
        assertNotNull(properties.getSource());
        assertEquals(properties.getSource().size(), 40);
        DatasourceTypeProperty source = properties.getSource().get(0);
        assertEquals(source.getName(), "bucket");
        assertEquals(source.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(source.getLabel(), "Bucket");
        assertEquals(source.getDescription(), "The name of the bucket that contains the files to read");
        assertFalse(source.getRequired());
        assertFalse(source.getMasked());
        assertFalse(source.getHidden());
        assertFalse(source.getReadonly());
        assertFalse(source.getMultiline());
        assertNotNull(source.getTags());
        assertEquals(source.getTags().size(), 1);
        assertTrue(source.getTags().contains("container"));
        assertNotNull(properties.getTarget());
        assertEquals(properties.getTarget().size(), 28);
        DatasourceTypeProperty target = properties.getTarget().get(0);
        assertEquals(target.getName(), "bucket");
        assertEquals(target.getName(), "bucket");
        assertEquals(target.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(target.getLabel(), "Bucket");
        assertEquals(target.getDescription(), "The name of the bucket that contains the files to write");
        assertFalse(target.getRequired());
        assertFalse(target.getMasked());
        assertFalse(target.getHidden());
        assertFalse(target.getReadonly());
        assertFalse(target.getMultiline());
        assertNotNull(target.getTags());
        assertEquals(target.getTags().size(), 1);
        assertTrue(target.getTags().contains("container"));
        assertNotNull(properties.getFilter());
        assertEquals(properties.getFilter().size(), 3);
        DatasourceTypeProperty filter = properties.getFilter().get(0);
        assertEquals(filter.getName(), "depth");
        assertEquals(filter.getType(), DatasourceTypePropertyType.INTEGER);
        assertEquals(filter.getLabel(), "Folder Depth");
        assertEquals(filter.getDescription(), "Number of folder levels to traverse");
        assertFalse(filter.getRequired());
        assertFalse(filter.getMasked());
        assertTrue(filter.getHidden());
        assertFalse(filter.getReadonly());
        assertFalse(filter.getMultiline());
        assertEquals(filter.getDefaultValue(), "1");
        assertNotNull(properties.getConditions());
        List<DatasourceTypePropertyCondition> connectionConditions = properties.getConditions().getConnection();
        assertNotNull(connectionConditions);
        assertEquals(connectionConditions.size(), 4);
        DatasourceTypePropertyCondition connectionCondition = connectionConditions.get(0);
        assertEquals(connectionCondition.getPropertyName(), "resource_instance_id");
        assertNotNull(connectionCondition.getConditions());
        assertNotNull(connectionCondition.getConditions().get(0));
        assertEquals(connectionCondition.getConditions().get(0).getPropertyName(), "defer_credentials");
        assertEquals(connectionCondition.getConditions().get(0).getCondition(), DatasourceTypeConditionEnum.NOT_EQUALS);
        assertTrue(connectionCondition.getConditions().get(0).getValues().contains("yes"));
        List<DatasourceTypePropertyCondition> sourceConditions = properties.getConditions().getSource();
        assertNotNull(sourceConditions);
        assertEquals(sourceConditions.size(), 30);
        DatasourceTypePropertyCondition sourceCondition = sourceConditions.get(0);
        assertEquals(sourceCondition.getPropertyName(), "file_format");
        assertNotNull(sourceCondition.getConditions());
        assertNotNull(sourceCondition.getConditions().get(0));
        assertEquals(sourceCondition.getConditions().get(0).getPropertyName(), "read_mode");
        assertEquals(sourceCondition.getConditions().get(0).getCondition(), DatasourceTypeConditionEnum.NOT_EQUALS);
        assertTrue(sourceCondition.getConditions().get(0).getValues().contains("read_raw"));
        assertFalse(sourceCondition.getAllConditionsRequired());
        List<DatasourceTypePropertyCondition> targetConditions = properties.getConditions().getTarget();
        assertNotNull(targetConditions);
        assertEquals(targetConditions.size(), 23);
        DatasourceTypePropertyCondition targetCondition = targetConditions.get(0);
        assertEquals(targetCondition.getPropertyName(), "codec_avro");
        assertNotNull(targetCondition.getConditions());
        assertNotNull(targetCondition.getConditions().get(0));
        assertEquals(targetCondition.getConditions().get(0).getPropertyName(), "file_format");
        assertEquals(targetCondition.getConditions().get(0).getCondition(), DatasourceTypeConditionEnum.EQUALS);
        assertTrue(targetCondition.getConditions().get(0).getValues().contains("avro"));
        assertFalse(targetCondition.getAllConditionsRequired());
        assertNotNull(entity.getTags());
        assertEquals(entity.getTags().size(), 1);
        assertTrue(entity.getTags().contains("IBM"));
        List<DatasourceTypeAction> actions = entity.getActions();
        assertNotNull(actions);
        assertEquals(actions.size(), 1);
        DatasourceTypeAction action = actions.get(0);
        assertEquals(action.getName(), "get_signed_url");
        assertEquals(action.getDescription(), "Get a signed URL for accessing a file");
        assertNotNull(action.getProperties());
        DatasourceTypeActionProperties actionProperties = action.getProperties();
        assertNotNull(actionProperties);
        assertNotNull(actionProperties.getInput());
        assertEquals(actionProperties.getInput().size(), 4);
        DatasourceTypeProperty actionInput = actionProperties.getInput().get(0);
        assertEquals(actionInput.getName(), "bucket");
        assertEquals(actionInput.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(actionInput.getLabel(), "Bucket");
        assertEquals(actionInput.getDescription(), "Name of the bucket");
        assertTrue(actionInput.getRequired());
        assertFalse(actionInput.getMasked());
        assertFalse(actionInput.getHidden());
        assertFalse(actionInput.getReadonly());
        assertFalse(actionInput.getMultiline());
        assertNotNull(actionInput.getTags());
        assertEquals(actionInput.getTags().size(), 1);
        assertTrue(actionInput.getTags().contains("container"));
        assertNotNull(actionProperties.getOutput());
        assertEquals(actionProperties.getOutput().size(), 1);
        DatasourceTypeProperty actionOutput = actionProperties.getOutput().get(0);
        assertEquals(actionOutput.getName(), "signed_url");
        assertEquals(actionOutput.getType(), DatasourceTypePropertyType.STRING);
        assertEquals(actionOutput.getLabel(), "Signed URL");
        assertEquals(actionOutput.getDescription(), "Signed URL for accessing a file");
        assertTrue(actionOutput.getRequired());
        assertFalse(actionOutput.getMasked());
        assertFalse(actionOutput.getHidden());
        assertFalse(actionOutput.getReadonly());
        assertFalse(actionOutput.getMultiline());
        assertNotNull(entity.getSupportedEnvironments());
        assertEquals(entity.getSupportedEnvironments().size(), 6);
        assertTrue(entity.getSupportedEnvironments().contains("cloud"));
        assertEquals(entity.getStatus(), DatasourceTypeStatus.ACTIVE);
        assertNotNull(entity.getSupportedPlans());
        assertEquals(entity.getSupportedPlans().size(), 4);
        assertTrue(entity.getSupportedPlans().contains("enterprise"));
        assertNotNull(entity.getSupportedProducts());
        assertEquals(entity.getSupportedProducts().size(), 4);
        assertTrue(entity.getSupportedProducts().contains("catalog"));
    }

}