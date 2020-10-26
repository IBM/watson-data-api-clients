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
import com.ibm.watson.data.client.api.DataProtectionRulesApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.DataProtectionRuleState;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.util.List;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Data Protection Rules API endpoints.
 */
public class DataProtectionRulesTest extends AbstractExpectations {

    private final DataProtectionRulesApiV3 api = new DataProtectionRulesApiV3(MockConstants.getApiClient());

    public DataProtectionRulesTest() {
        super(DataProtectionRulesApiV3.BASE_API, "dataProtectionRules");
    }

    private static final String ruleEndpoint = "/" + NEW_DP_RULE_ID;

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "DELETE", ruleEndpoint, "delete", 204);
        setupTest(client, "GET", "/export", "export");
        setupTest(client, "GET", "", "list");
        setupTest(client, "GET", ruleEndpoint, "get");
        setupTest(client, "GET", ruleEndpoint + "/terms", "getTerms");
        // Note that for the import we will test any JSON rather than a specific one, as the
        // MockServer is not yet easily capable of handling multi-part form requests with files
        client
                .when(withRequest("POST", getBaseUrl() + "/import", getArea(), "load"))
                .respond(withResponse(getArea(), "load"));
        setupTest(client, "PUT", ruleEndpoint, "update");
    }

    @Test
    public void testCreate() {
        PolicyRuleEntity body = readRequestFromFile("create", new TypeReference<PolicyRuleEntity>() {});
        PolicyRuleResponse response = api.create(body).block();
        assertNotNull(response);
        validateEntity(response.getEntity());
        validateMetadata(response.getMetadata());
    }

    @Test
    public void testGet() {
        PolicyRuleResponse response = api.get(NEW_DP_RULE_ID).block();
        assertNotNull(response);
        validateEntity(response.getEntity());
        validateMetadata(response.getMetadata());
    }

    @Test
    public void testList() {
        PolicyRuleListResponse response = api.list(null, null, null, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        PolicyRuleResponse one = response.getResources().get(0);
        validateEntity(one.getEntity());
        validateMetadata(one.getMetadata());
        assertEquals(response.getLimit(), Integer.valueOf(50));
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertEquals(response.getCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
    }

    @Test
    public void testGetTerms() {
        PolicyRuleTermListResponse response = api.getTerms(NEW_DP_RULE_ID).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        List<PolicyRuleTermListResponseResource> triggerTerms = response.getResources().getTriggerTerms();
        assertNotNull(triggerTerms);
        assertEquals(triggerTerms.size(), 3);
        validateTerm(triggerTerms.get(0));
        List<PolicyRuleTermListResponseResource> actionTerms = response.getResources().getActionTerms();
        assertNotNull(actionTerms);
        assertEquals(actionTerms.size(), 2);
        validateTerm(actionTerms.get(1));
    }

    @Test
    public void testUpdate() {
        PolicyRuleEntity body = readRequestFromFile("update", new TypeReference<PolicyRuleEntity>() {});
        PolicyRuleResponse response = api.update(NEW_DP_RULE_ID, body).block();
        assertNotNull(response);
        validateEntity(response.getEntity(), "A sample rule for testing the Data Protection APIs, with an updated description.");
        validateMetadata(response.getMetadata());
    }

    @Test
    public void testExport() {
        DataProtectionRuleExportFile response = api.export(null, null).block();
        assertNotNull(response);
        assertEquals(response.getVersion(), "v3");
        assertEquals(response.getCreator(), EXSTUSER_NAME);
        assertEquals(response.getTenantId(), "999");
        assertNotNull(response.getDate());
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertEquals(response.getTotalCount(), Long.valueOf(1L));
        assertNotNull(response.getRules());
        assertEquals(response.getRules().size(), 1);
        ExportedDataProtectionRule one = response.getRules().get(0);
        assertNotNull(one);
        assertEquals(one.getGuid(), NEW_DP_RULE_ID);
        validateEntity(one, "A sample rule for testing the Data Protection APIs, with an updated description.");
    }

    @Test
    public void testLoad() {
        DataProtectionRuleExportFile body = readRequestFromFile("load", new TypeReference<DataProtectionRuleExportFile>() {});
        ImportRuleResponse response = api.load(body).block();
        assertNotNull(response);
        assertNotNull(response.getImportedList());
        assertEquals(response.getImportedList().size(), 1);
        ImportedRule one = response.getImportedList().get(0);
        assertEquals(one.getName(), "Test DP Rule");
        assertEquals(one.getIndex(), Integer.valueOf(1));
        assertEquals(one.getGuid(), NEW_DP_RULE_ID);
        assertEquals(one.getRuleGuidInRequest(), NEW_DP_RULE_ID);
    }

    @Test
    public void testDelete() {
        api.delete(NEW_DP_RULE_ID).block();
    }

    private void validateEntity(PolicyRuleEntity entity) {
        validateEntity(entity, "A sample rule for testing the Data Protection APIs.");
    }

    private void validateEntity(PolicyRuleEntity entity, String description) {
        assertNotNull(entity);
        assertEquals(entity.getName(), "Test DP Rule");
        assertEquals(entity.getDescription(), description);
        assertEquals(entity.getGovernanceTypeId(), "Access");
        assertNotNull(entity.getTrigger());
        PolicyRuleAction action = entity.getAction();
        assertNotNull(action);
        assertEquals(action.getName(), "Transform");
        PolicyRuleAction subaction = action.getSubaction();
        assertNotNull(subaction);
        assertEquals(subaction.getName(), "redactTerms");
        assertNotNull(subaction.getParameters());
        assertEquals(subaction.getParameters().size(), 1);
        PolicyRuleParameter one = subaction.getParameters().get(0);
        assertNotNull(one);
        assertEquals(one.getName(), "term_names");
        assertNotNull(one.getValue());
        assertEquals(one.getValue().size(), 2);
        assertEquals(entity.getState(), DataProtectionRuleState.ACTIVE);
    }

    private void validateMetadata(PolicyResourceMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getGuid(), NEW_DP_RULE_ID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getCreator(), EXSTUSER_GUID);
        assertNotNull(metadata.getUpdatedAt());
        assertEquals(metadata.getModifier(), EXSTUSER_GUID);
    }

    private void validateTerm(PolicyRuleTermListResponseResource term) {
        assertNotNull(term);
        assertNotNull(term.getEntity());
        assertEquals(term.getEntity().getName(), "LastName");
        assertEquals(term.getEntity().getDisplayName(), "Last Name of an individual.");
        assertNotNull(term.getMetadata());
        assertEquals(term.getMetadata().getArtifactId(), "388a668d-4541-4879-974c-ebd29f9324b9");
        assertEquals(term.getMetadata().getGlobalId(), "5d2d5419-0032-4c64-90e2-ce68c6997bb5_388a668d-4541-4879-974c-ebd29f9324b9");
        assertEquals(term.getMetadata().getArtifactType(), "data_class");
    }

}