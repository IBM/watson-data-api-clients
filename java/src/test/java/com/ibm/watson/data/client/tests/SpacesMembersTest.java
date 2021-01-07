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
import com.ibm.watson.data.client.api.SpacesMembersApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.MemberStateLower;
import com.ibm.watson.data.client.model.enums.MemberType;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.List;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Space Members API endpoints.
 */
public class SpacesMembersTest extends AbstractExpectations {

    private final SpacesMembersApiV2 api = new SpacesMembersApiV2(MockConstants.getApiClient());

    public SpacesMembersTest() {
        super(SpacesMembersApiV2.BASE_API, "spaceMembers");
    }

    @Override
    public void init(MockServerClient client) {
        injectIntoBaseUrl("{guid}", SPACE_GUID);
        setupTest(client, "POST", "", "add");
        setupTest(client, "DELETE", "/" + NEW_USER_GUID, "delete", 204);
        setupTest(client, "GET", "/" + EXSTUSER_GUID, "get");
        setupTest(client, "GET", "", "list");
    }

    @Test
    public void testAdd() {
        WriteableSpaceMembers body = readRequestFromFile("add", new TypeReference<WriteableSpaceMembers>() {});
        SpaceMembers response = api.add(SPACE_GUID, body).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        validateNewUser(response.getResources().get(0));
    }

    private void validateExistingUser(SpaceMember member) {
        assertNotNull(member);
        assertEquals(member.getRole(), "admin");
        assertEquals(member.getState(), MemberStateLower.ACTIVE);
        assertEquals(member.getType(), MemberType.USER);
        assertEquals(member.getId(), EXSTUSER_GUID);
    }

    private void validateNewUser(SpaceMember member) {
        assertNotNull(member);
        assertEquals(member.getRole(), "admin");
        assertEquals(member.getState(), MemberStateLower.ACTIVE);
        assertEquals(member.getType(), MemberType.USER);
        assertEquals(member.getId(), NEW_USER_GUID);
    }

    @Test
    public void testGet() {
        SpaceMember response = api.get(SPACE_GUID, EXSTUSER_GUID).block();
        validateExistingUser(response);
    }

    @Test
    public void testList() {
        SpaceMembers response = api.list(SPACE_GUID).block();
        assertNotNull(response);
        List<SpaceMember> spaceMembers = response.getResources();
        assertNotNull(spaceMembers);
        assertEquals(spaceMembers.size(), 2);
        validateExistingUser(spaceMembers.get(0));
        validateNewUser(spaceMembers.get(1));
    }

    @Test
    public void testDelete() {
        api.delete(SPACE_GUID, NEW_USER_GUID).block();
    }

}
