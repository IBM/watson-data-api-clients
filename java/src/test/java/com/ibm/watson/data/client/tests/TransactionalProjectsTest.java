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
import com.ibm.watson.data.client.api.TransactionalProjectsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import static com.ibm.watson.data.client.mocks.MockConstants.PROJECT_GUID;
import static org.testng.Assert.*;

/**
 * Test the Project API endpoints.
 */
public class TransactionalProjectsTest extends AbstractExpectations {

    private final TransactionalProjectsApiV2 api = new TransactionalProjectsApiV2(MockConstants.getApiClient());

    public TransactionalProjectsTest() {
        super(TransactionalProjectsApiV2.BASE_API, "project");
    }

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "DELETE", "/" + PROJECT_GUID, "delete", 204);
    }

    @Test
    public void testCreate() {
        TransactionalProjectCreate body = readRequestFromFile("create", new TypeReference<TransactionalProjectCreate>() {});
        CreateTransactionProjectResponse created = api.create(body).block();
        assertNotNull(created);
        assertNotNull(created.getLocation());
        assertEquals(created.getLocation(), "/v2/projects/" + MockConstants.PROJECT_GUID);
    }

    @Test
    public void testDelete() {
        api.delete(MockConstants.PROJECT_GUID).block();
    }

}
