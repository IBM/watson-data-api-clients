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

import com.ibm.watson.data.client.api.CatalogMembersApiV2;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Test the Catalog Members API endpoints.
 */
public class CatalogMembersTest {

    private CatalogMembersApiV2 api;

    /**
     * Setup the API for testing.
     */
    @BeforeTest
    public void setupApi() {
        api = new CatalogMembersApiV2(MockConstants.getApiClient());
    }

    /**
     * Test addition of a member to a catalog.
     */
    @Test
    public void testAdd() {
        MemberSet body = new MemberSet();
        Member member = new Member();
        member.setUserIamId(MockConstants.NEW_USER_GUID);
        member.setRole("admin");
        body.addMembersItem(member);
        MemberSetPartialResult response = api.add(MockConstants.CATALOG_GUID, body).block();
        assertNotNull(response);
        assertNotNull(response.getMembers());
        Member one = response.getMembers().get(0);
        assertNotNull(one);
        assertEquals(one.getRole(), "admin");
        assertEquals(one.getUserIamId(), MockConstants.NEW_USER_GUID);
        assertNotNull(response.getFailures());
        assertEquals(response.getFailures().size(), 0);
    }

    /**
     * Test retrieval of membership details for a given user on a given catalog.
     */
    @Test
    public void testGet() {
        MemberSet response = api.get(MockConstants.CATALOG_GUID, MockConstants.NEW_USER_GUID).block();
        assertNotNull(response);
        assertNotNull(response.getMembers());
        Member one = response.getMembers().get(0);
        assertNotNull(one);
        assertEquals(one.getUserIamId(), MockConstants.NEW_USER_GUID);
        assertEquals(one.getRole(), "admin");
    }

    /**
     * Test retrieval of all membership details on a catalog.
     */
    @Test
    public void testList() {
        MemberSearchResult response = api.list(MockConstants.CATALOG_GUID, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalResults(), Long.valueOf(1));
        List<Member> memberList = response.getMembers();
        assertNotNull(memberList);
        assertEquals(memberList.size(), 1);
        Member one = memberList.get(0);
        assertEquals(one.getUserIamId(), MockConstants.EXSTUSER_GUID);
        assertEquals(one.getCreateTime(), "2020-07-22T11:27:03Z");
        assertEquals(one.getRole(), "admin");
    }

    /**
     * Test update of the role of a member on a catalog.
     */
    @Test
    public void testUpdateRole() {
        MemberRole role = new MemberRole();
        role.setRole("viewer");
        Member member = api.updateRole(MockConstants.CATALOG_GUID, MockConstants.NEW_USER_GUID, role).block();
        assertNotNull(member);
        assertEquals(member.getRole(), "viewer");
        assertEquals(member.getUserIamId(), MockConstants.NEW_USER_GUID);
    }

    /**
     * Test removal of a member from a catalog.
     */
    @Test
    public void testDelete() {
        api.delete(MockConstants.CATALOG_GUID, MockConstants.NEW_USER_GUID).block();
    }

}
