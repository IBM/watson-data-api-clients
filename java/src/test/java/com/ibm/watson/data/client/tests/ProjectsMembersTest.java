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
import com.ibm.watson.data.client.api.ProjectsMembersApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.MemberState;
import com.ibm.watson.data.client.model.enums.MemberType;
import org.mockserver.client.MockServerClient;
import org.testng.annotations.Test;

import java.util.List;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Project Members API endpoints.
 */
public class ProjectsMembersTest extends AbstractExpectations {

    private final ProjectsMembersApiV2 api = new ProjectsMembersApiV2(MockConstants.getApiClient());

    public ProjectsMembersTest() {
        super(ProjectsMembersApiV2.BASE_API, "projectMembers");
    }

    @Override
    public void init(MockServerClient client) {
        injectIntoBaseUrl("{guid}", PROJECT_GUID);
        setupTest(client, "POST", "", "add");
        setupTest(client, "DELETE", "/" + NEW_USER_NAME, "delete", 204);
        setupTest(client, "GET", "/" + EXSTUSER_NAME, "get");
        setupTest(client, "GET", "", "list");
        setupTest(client, "PATCH", "", "update");
    }

    @Test
    public void testAdd() {
        ProjectMembers body = readRequestFromFile("add", new TypeReference<ProjectMembers>() {});
        ProjectMembers response = api.add(MockConstants.PROJECT_GUID, body).block();
        assertNotNull(response);
        assertNotNull(response.getMembers());
        ProjectMember one = response.getMembers().get(0);
        assertNotNull(one);
        assertEquals(one.getRole(), "admin");
        assertEquals(one.getUserName(), MockConstants.NEW_USER_NAME);
        assertEquals(one.getState(), MemberState.ACTIVE);
        assertEquals(one.getType(), MemberType.USER);
        assertEquals(one.getId(), MockConstants.NEW_USER_GUID);
    }

    private void validateExistingUser(ProjectMember member) {
        assertNotNull(member);
        assertEquals(member.getRole(), "admin");
        assertEquals(member.getUserName(), MockConstants.EXSTUSER_NAME);
        assertEquals(member.getState(), MemberState.ACTIVE);
        assertEquals(member.getType(), MemberType.USER);
        assertEquals(member.getId(), MockConstants.EXSTUSER_GUID);
    }

    @Test
    public void testGet() {
        ProjectMember response = api.get(MockConstants.PROJECT_GUID, MockConstants.EXSTUSER_NAME).block();
        validateExistingUser(response);
    }

    @Test
    public void testList() {
        ProjectMembers response = api.list(MockConstants.PROJECT_GUID, null, null).block();
        assertNotNull(response);
        List<ProjectMember> projectMembers = response.getMembers();
        assertNotNull(projectMembers);
        assertEquals(projectMembers.size(), 1);
        validateExistingUser(projectMembers.get(0));
    }

    @Test
    public void testUpdate() {
        UpdateMembersBody body = readRequestFromFile("update", new TypeReference<UpdateMembersBody>() {});
        ProjectMembers response = api.update(MockConstants.PROJECT_GUID, body).block();
        assertNotNull(response);
        List<ProjectMember> projectMembers = response.getMembers();
        assertNotNull(projectMembers);
        assertEquals(projectMembers.size(), 1);
        ProjectMember one = projectMembers.get(0);
        assertNotNull(one);
        assertEquals(one.getId(), MockConstants.NEW_USER_GUID);
        assertEquals(one.getUserName(), MockConstants.NEW_USER_NAME);
        assertEquals(one.getRole(), "viewer");
        assertEquals(one.getType(), MemberType.USER);
        assertEquals(one.getState(), MemberState.ACTIVE);
    }

    @Test
    public void testDelete() {
        api.delete(MockConstants.PROJECT_GUID, MockConstants.NEW_USER_NAME).block();
    }

}
