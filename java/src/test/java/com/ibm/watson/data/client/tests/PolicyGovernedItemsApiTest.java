/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.data.client.api.PolicyGovernedItemsApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.junit.Ignore;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import static com.ibm.watson.data.client.mocks.MockConstants.*;

/**
 * Test the Policy-Governed Items API endpoints.
 */
@Ignore
public class PolicyGovernedItemsApiTest extends AbstractExpectations {

    private final PolicyGovernedItemsApiV3 api = new PolicyGovernedItemsApiV3(MockConstants.getApiClient());

    public PolicyGovernedItemsApiTest() {
        super(PolicyGovernedItemsApiV3.BASE_API, "policyGovernedItems");
    }

    @Override
    public void init(MockServerClient client) {
        // TODO...
        /*setupTest(client, "GET", workflowEndpoint + "/artifacts", "listArtifacts");
        setupTest(client, "GET", workflowEndpoint, "get");
        setupTest(client, "GET", "", "list");
        setupTest(client, "POST", "/all/query", "search");*/
    }

    @Test
    public void createOrUpdateItemTest()  {

        V3PolicyItemRequest body = readRequestFromFile("createOrUpdateItem", new TypeReference<V3PolicyItemRequest>() {});
        V3PolicyItemResponse response = api.createOrUpdateItem(GOVN_ITEM_GUID, body).block();
        // TODO: test validations

    }
    
    @Test
    public void deleteItemTest()  {

        api.deleteItem(GOVN_ITEM_GUID).block();
        // TODO: test validations

    }
    
    @Test
    public void getAllItemsTest()  {

        String resourcePrefix = null;
        Long since = null;
        V3PolicyItemListResponse response = api.getAllItems(resourcePrefix, since).block();
        // TODO: test validations

    }
    
    @Test
    public void getDiscreteRulesTest()  {

        String governanceTypeName = null;
        String containerId = null;
        String options = null;
        V3DiscreteRulesResponse response = api.getDiscreteRules(governanceTypeName, GOVN_ITEM_GUID, containerId, options).block();
        // TODO: test validations

    }
    
    @Test
    public void getDiscreteRulesResourceTest()  {

        String governanceTypeName = null;
        String resourceKey = null;
        String options = null;
        V3DiscreteRulesResponse response = api.getDiscreteRulesResource(governanceTypeName, resourceKey, options).block();
        // TODO: test validations

    }
    
    @Test
    public void getItemTest()  {

        String fields = null;
        V3PolicyItemResponse response = api.getItem(GOVN_ITEM_GUID, fields).block();
        // TODO: test validations

    }
    
    @Test
    public void getItemTermValueTest()  {

        String termName = null;
        PolicyEnforcementContext body = readRequestFromFile("getItemTermValue", new TypeReference<PolicyEnforcementContext>() {});
        V3PolicyTermValueListResponse response = api.getItemTermValue(GOVN_ITEM_GUID, termName, body).block();
        // TODO: test validations

    }
    
    @Test
    public void itemEvaluateTest()  {

        String governanceTypeName = null;
        PolicyEnforcementContext body = readRequestFromFile("itemEvaluate", new TypeReference<PolicyEnforcementContext>() {});
        Boolean launchTransform = null;
        PolicyEvaluation response = api.itemEvaluate(GOVN_ITEM_GUID, governanceTypeName, body, launchTransform).block();
        // TODO: test validations

    }
    
    @Test
    public void itemEvaluateOperationTest()  {

        String operationName = null;
        PolicyEnforcementContext body = readRequestFromFile("itemEvaluateOperation", new TypeReference<PolicyEnforcementContext>() {});
        PolicyEvaluation response = api.itemEvaluateOperation(GOVN_ITEM_GUID, operationName, body).block();
        // TODO: test validations

    }
    
    @Test
    public void itemsAddRulesEvaluateTest()  {

        String governanceTypeName = null;
        V3ItemRulesEvaluationRequest body = readRequestFromFile("itemsAddRulesEvaluate", new TypeReference<V3ItemRulesEvaluationRequest>() {});
        PolicyEvaluation response = api.itemsAddRulesEvaluate(governanceTypeName, body).block();
        // TODO: test validations

    }
    
    @Test
    public void itemsEvaluateTest()  {

        String governanceTypeName = null;
        V3ItemsEvaluationRequest body = readRequestFromFile("itemsEvaluate", new TypeReference<V3ItemsEvaluationRequest>() {});
        Boolean launchTransform = null;
        PolicyEvaluation response = api.itemsEvaluate(governanceTypeName, body, launchTransform).block();
        // TODO: test validations

    }
    
    @Test
    public void userItemsEvaluateTest()  {

        String governanceTypeName = null;
        PolicyEnforcementContext body = readRequestFromFile("userItemsEvaluate", new TypeReference<PolicyEnforcementContext>() {});
        Integer limit = null;
        Integer offset = null;
        Integer start = null;
        String operation = null;
        PolicyEvaluation response = api.userItemsEvaluate(governanceTypeName, body, limit, offset, start, operation).block();
        // TODO: test validations

    }
    
}
