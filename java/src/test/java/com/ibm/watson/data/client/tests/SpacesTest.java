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
import com.ibm.watson.data.client.api.SpacesApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.ComputeType;
import com.ibm.watson.data.client.model.enums.MemberStateLower;
import com.ibm.watson.data.client.model.enums.MemberType;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.List;

import static com.ibm.watson.data.client.mocks.MockConstants.EXSTUSER_GUID;
import static com.ibm.watson.data.client.mocks.MockConstants.SPACE_GUID;
import static org.testng.Assert.*;

/**
 * Test the Space API endpoints.
 */
public class SpacesTest extends AbstractExpectations {

    private final SpacesApiV2 api = new SpacesApiV2(MockConstants.getApiClient());

    public SpacesTest() {
        super(SpacesApiV2.BASE_API, "space");
    }

    @Override
    public void init(MockServerClient client) {
        setupTest(client, "POST", "", "create", 202);
        setupTest(client, "GET", "/" + SPACE_GUID, "get");
        setupTest(client, "GET", "", "list");
        setupTest(client, "DELETE", "/" + SPACE_GUID, "delete", 202);
        setupTest(client, "PATCH", "/" + SPACE_GUID, "update");
    }

    private static final String createdName = "Test Space";
    private static final String createdDesc = "A test space to validate the API client works as expected.";
    private static final String updatedDesc = "Now with an updated description.";

    @Test
    public void testCreate() {
        WriteableSpace body = readRequestFromFile("create", new TypeReference<WriteableSpace>() {});
        Space created = api.create(body).block();
        validateSpace(created, true);
    }

    @Test
    public void testGet() {
        Space space = api.get(SPACE_GUID, null).block();
        validateSpace(space, false);
    }

    @Test
    public void testList() {
        Spaces spaces = api.list(null, null, null, null, null, null, null, null).block();
        assertNotNull(spaces);
        assertEquals(spaces.getLimit(), Integer.valueOf(100));
        assertNotNull(spaces.getFirst());
        assertNotNull(spaces.getResources());
        assertEquals(spaces.getResources().size(), 1);
        validateSpace(spaces.getResources().get(0), false);
    }

    @Test
    public void testUpdate() {
        List<JSONResourcePatchModel> body = readRequestFromFile("update", new TypeReference<List<JSONResourcePatchModel>>() {});
        Space updated = api.update(SPACE_GUID, body).block();
        assertNotNull(updated);
        validateSpaceMetadata(updated.getMetadata());
        validateSpaceEntity(updated.getEntity(), true, updatedDesc);
    }

    @Test
    public void testDelete() {
        api.delete(SPACE_GUID).block();
    }

    private void validateSpace(Space space, boolean includesMembers) {
        assertNotNull(space);
        SpaceEntity entity = space.getEntity();
        validateSpaceEntity(entity, includesMembers);
        SpaceMetadata metadata = space.getMetadata();
        validateSpaceMetadata(metadata);
    }

    private void validateSpaceEntity(SpaceEntity entity, boolean includesMembers) {
        validateSpaceEntity(entity, includesMembers, createdDesc);
    }

    private void validateSpaceEntity(SpaceEntity entity, boolean includesMembers, String description) {
        assertNotNull(entity);
        assertNotNull(entity.getCompute());
        assertEquals(entity.getCompute().size(), 1);
        assertEquals(entity.getCompute().get(0).getCrn(), "crn:v1:cpd:private:pm-20:private:a/cpduser:99999999-9999-9999-9999-999999999999::");
        assertEquals(entity.getCompute().get(0).getGuid(), "99999999-9999-9999-9999-999999999999");
        assertEquals(entity.getCompute().get(0).getName(), "Watson Machine Learning");
        assertEquals(entity.getCompute().get(0).getType(), ComputeType.MACHINE_LEARNING);
        assertEquals(entity.getDescription(), description);
        if (includesMembers) {
            assertNotNull(entity.getMembers());
            assertEquals(entity.getMembers().size(), 1);
            assertEquals(entity.getMembers().get(0).getId(), EXSTUSER_GUID);
            assertEquals(entity.getMembers().get(0).getRole(), "admin");
            assertEquals(entity.getMembers().get(0).getState(), MemberStateLower.ACTIVE);
            assertEquals(entity.getMembers().get(0).getType(), MemberType.USER);
        } else {
            assertNull(entity.getMembers());
        }
        assertNotNull(entity.getStatus());
        if (includesMembers && description.equals(createdDesc)) {
            assertEquals(entity.getStatus().getState(), "preparing");
        } else {
            assertEquals(entity.getStatus().getState(), "active");
        }
        assertEquals(entity.getName(), createdName);
        assertNotNull(entity.getScope());
        assertEquals(entity.getScope().getBssAccountId(), "cpdaccount");
    }

    private void validateSpaceMetadata(SpaceMetadata metadata) {
        assertNotNull(metadata);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getCreatorId(), EXSTUSER_GUID);
        assertEquals(metadata.getId(), SPACE_GUID);
        assertNotNull(metadata.getUrl());
    }

}
