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

import com.ibm.watson.data.client.api.MonitorApi;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import org.mockserver.client.MockServerClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test the Monitor API endpoints.
 */
public class MonitorTest extends AbstractExpectations {

    private final MonitorApi api = new MonitorApi(MockConstants.getApiClient());

    public MonitorTest() {
        super("/icp4d-api/v1/monitor", "monitor");
    }

    @Override
    public void init(MockServerClient client) {
        // TODO: endpoint currently broken (results in 404)
        setupTest(client, "GET", "", "get", 404);
    }

    @Test
    public void testGet() {
        // TODO: currently the API throws a 404 not found error
        assertThrows(WebClientResponseException.NotFound.class, () -> api.getMonitor().block());
        /*PlatformSuccessResponse response = api.getMonitor().block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");*/
    }

}
