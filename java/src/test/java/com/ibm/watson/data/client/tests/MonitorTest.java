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
import com.ibm.watson.data.client.mocks.MockConstants;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test the Monitor API endpoints.
 */
public class MonitorTest {

    private MonitorApi api;

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new MonitorApi(MockConstants.getApiClient());
    }

    /**
     * Test retrieval of my own details.
     */
    @Test
    public void testGet() {
        // TODO: currently the API throws a 404 not found error
        assertThrows(WebClientResponseException.NotFound.class, () -> api.getMonitor().block());
        /*PlatformSuccessResponse response = api.getMonitor().block();
        assertNotNull(response);
        assertEquals(response.getMessageCode(), "200");*/
    }

}
