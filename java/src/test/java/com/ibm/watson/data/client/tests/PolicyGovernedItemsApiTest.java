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
import com.ibm.watson.data.client.model.enums.GovernanceType;
import org.junit.Ignore;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Policy-Governed Items API endpoints.
 */
public class PolicyGovernedItemsApiTest extends AbstractExpectations {

    private final PolicyGovernedItemsApiV3 api = new PolicyGovernedItemsApiV3(MockConstants.getApiClient());

    public PolicyGovernedItemsApiTest() {
        super(PolicyGovernedItemsApiV3.BASE_API, "policyGovernedItems");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> container = new ArrayList<>();
        container.add(CONTAINER_GUID);
        params.put("containerId", container);
        List<String> options = new ArrayList<>();
        options.add("test");
        params.put("options", options);
    }

    private static final String governanceType = GovernanceType.ACCESS.getValue();
    private static final String discreteEndpoint = "/discrete/" + governanceType + "/" + GOVN_ITEM_GUID;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "GET", discreteEndpoint, params, "getDiscreteRules");
        // TODO...
    }

    @Ignore
    public void createOrUpdateItemTest()  {

        V3PolicyItemRequest body = readRequestFromFile("createOrUpdateItem", new TypeReference<V3PolicyItemRequest>() {});
        V3PolicyItemResponse response = api.createOrUpdateItem(GOVN_ITEM_GUID, body).block();
        // TODO: test validations

    }
    
    @Ignore
    public void deleteItemTest()  {

        api.deleteItem(GOVN_ITEM_GUID).block();
        // TODO: test validations

    }
    
    @Ignore
    public void getAllItemsTest()  {

        String resourcePrefix = null;
        Long since = null;
        V3PolicyItemListResponse response = api.listItems(resourcePrefix, since).block();
        // TODO: test validations

    }
    
    @Test
    public void getDiscreteRulesTest()  {

        String options = "test";
        V3DiscreteRulesResponse response = api.getDiscreteRules(governanceType, GOVN_ITEM_GUID, CONTAINER_GUID, options).block();

        assertNotNull(response);
        List<V3DiscreteRulesResponseResource> rules = response.getResources();
        assertNotNull(rules);
        assertEquals(rules.size(), 2);

        V3DiscreteRulesResponseResource one = rules.get(0);
        assertNotNull(one);
        assertEquals(one.getContainerId(), CONTAINER_GUID);
        assertEquals(one.getItemId(), GOVN_ITEM_GUID);
        assertEquals(one.getColumnName(), "Test4");
        V3DiscreteRuleEntity rule = one.getRule();
        assertNotNull(rule);
        assertEquals(rule.getGovernanceType(), "Access");
        assertEquals(rule.getRuleId(), "46651415-6436-4f56-9f01-d7144f951b74");
        Action action = rule.getAction();
        assertNotNull(action);
        assertEquals(action.getName(), "Transform");
        Action subaction = action.getSubaction();
        assertNotNull(subaction);
        assertEquals(subaction.getName(), "redactColumns");
        assertNotNull(subaction.getParameters());
        assertEquals(subaction.getParameters().size(), 1);
        assertEquals(subaction.getParameters().get(0).getName(), "column_names");
        assertEquals(subaction.getParameters().get(0).getValue(), "Test4");
        List<Object> triggers = rule.getTrigger();
        assertNotNull(triggers);
        assertEquals(triggers.size(), 3);

        one = rules.get(1);
        assertNotNull(one);
        assertEquals(one.getContainerId(), CONTAINER_GUID);
        assertEquals(one.getItemId(), GOVN_ITEM_GUID);
        assertEquals(one.getColumnName(), "Test3");
        rule = one.getRule();
        assertNotNull(rule);
        assertEquals(rule.getGovernanceType(), "Access");
        assertEquals(rule.getRuleId(), "46651415-6436-4f56-9f01-d7144f951b74");
        action = rule.getAction();
        assertNotNull(action);
        assertEquals(action.getName(), "Transform");
        subaction = action.getSubaction();
        assertNotNull(subaction);
        assertEquals(subaction.getName(), "redactColumns");
        assertNotNull(subaction.getParameters());
        assertEquals(subaction.getParameters().size(), 1);
        assertEquals(subaction.getParameters().get(0).getName(), "column_names");
        assertEquals(subaction.getParameters().get(0).getValue(), "Test3");
        triggers = rule.getTrigger();
        assertNotNull(triggers);
        assertEquals(triggers.size(), 3);

    }
    
    @Ignore
    public void getDiscreteRulesResourceTest()  {

        String resourceKey = null;
        String options = null;
        V3DiscreteRulesResponse response = api.getDiscreteRulesResource(governanceType, resourceKey, options).block();
        // TODO: test validations

    }
    
    @Ignore
    public void getItemTest()  {

        String fields = null;
        V3PolicyItemResponse response = api.getItem(GOVN_ITEM_GUID, fields).block();
        // TODO: test validations

    }
    
    @Ignore
    public void getItemTermValueTest()  {

        String termName = null;
        PolicyEnforcementContext body = readRequestFromFile("getItemTermValue", new TypeReference<PolicyEnforcementContext>() {});
        V3PolicyTermValueListResponse response = api.getItemTermValue(GOVN_ITEM_GUID, termName, body).block();
        // TODO: test validations

    }
    
    @Ignore
    public void itemEvaluateTest()  {

        PolicyEnforcementContext body = readRequestFromFile("itemEvaluate", new TypeReference<PolicyEnforcementContext>() {});
        Boolean launchTransform = null;
        PolicyEvaluation response = api.itemEvaluate(GOVN_ITEM_GUID, governanceType, body, launchTransform).block();
        // TODO: test validations

    }
    
    @Ignore
    public void itemEvaluateOperationTest()  {

        String operationName = null;
        PolicyEnforcementContext body = readRequestFromFile("itemEvaluateOperation", new TypeReference<PolicyEnforcementContext>() {});
        PolicyEvaluation response = api.itemEvaluateOperation(GOVN_ITEM_GUID, operationName, body).block();
        // TODO: test validations

    }
    
    @Ignore
    public void itemsAddRulesEvaluateTest()  {

        V3ItemRulesEvaluationRequest body = readRequestFromFile("itemsAddRulesEvaluate", new TypeReference<V3ItemRulesEvaluationRequest>() {});
        PolicyEvaluation response = api.itemsAddRulesEvaluate(governanceType, body).block();
        // TODO: test validations

    }
    
    @Ignore
    public void itemsEvaluateTest()  {

        V3ItemsEvaluationRequest body = readRequestFromFile("itemsEvaluate", new TypeReference<V3ItemsEvaluationRequest>() {});
        Boolean launchTransform = null;
        PolicyEvaluation response = api.itemsEvaluate(governanceType, body, launchTransform).block();
        // TODO: test validations

    }
    
    @Ignore
    public void userItemsEvaluateTest()  {

        PolicyEnforcementContext body = readRequestFromFile("userItemsEvaluate", new TypeReference<PolicyEnforcementContext>() {});
        Integer limit = null;
        Integer offset = null;
        Integer start = null;
        String operation = null;
        PolicyEvaluation response = api.userItemsEvaluate(governanceType, body, limit, offset, start, operation).block();
        // TODO: test validations

    }
    
}
