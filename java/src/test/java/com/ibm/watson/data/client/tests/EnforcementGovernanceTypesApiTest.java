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

import com.ibm.watson.data.client.api.EnforcementGovernanceTypesApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.V3PolicyGovernanceTypeListResponse;
import com.ibm.watson.data.client.model.V3PolicyGovernanceTypeResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

/**
 * Test the Enforced Governance Types API endpoints.
 */
@Ignore
public class EnforcementGovernanceTypesApiTest extends AbstractExpectations {

    private final EnforcementGovernanceTypesApiV3 api = new EnforcementGovernanceTypesApiV3(MockConstants.getApiClient());

    public EnforcementGovernanceTypesApiTest() {
        super(EnforcementGovernanceTypesApiV3.BASE_API, "enforcementGovernanceTypes");
    }

    private static final String governanceTypeName = "TBD";

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "GET", "", "list");
        setupTest(client, "GET", "/" + governanceTypeName, "get");
    }
    
    @Test
    public void testList()  {

        V3PolicyGovernanceTypeListResponse response = api.list().block();
        // TODO: test validations

    }
    
    @Test
    public void testGet()  {

        V3PolicyGovernanceTypeResponse response = api.get(governanceTypeName).block();
        // TODO: test validations

    }
    
}
