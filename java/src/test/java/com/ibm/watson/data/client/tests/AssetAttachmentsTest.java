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
import com.ibm.watson.data.client.api.AssetAttachmentsApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.AssetCategory;
import org.mockserver.client.MockServerClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Project Integration API endpoints.
 */
public class AssetAttachmentsTest extends AbstractExpectations {

    private final AssetAttachmentsApiV2 api = new AssetAttachmentsApiV2(MockConstants.getApiClient());

    public AssetAttachmentsTest() {
        super(AssetAttachmentsApiV2.BASE_API, "assetAttachments");
    }

    private final Map<String, List<String>> params = new HashMap<>();
    private void setupParams() {
        List<String> project = new ArrayList<>();
        project.add(PROJECT_GUID);
        params.put("project_id", project);
    }

    private static final String attachmentGuid = "704347ba-0184-4bdc-84f5-9072992e6c1c";
    private static final String attachmentGuidEndpoint = "/" + attachmentGuid;

    @Override
    public void init(MockServerClient client) {
        setupParams();
        injectIntoBaseUrl("{asset_id}", DATAASSET_GUID);
        setupTest(client, "POST", "", params, "create", 201);
        // TODO: current tests are for a remote asset, so transfer complete is not applicable
        setupTest(client, "POST", attachmentGuidEndpoint + "/complete", params, "markTransferComplete", 400);
        setupTest(client, "GET", attachmentGuidEndpoint, params, "get");
        setupTest(client, "GET", attachmentGuidEndpoint + "/resources", params, "getResources");
        setupTest(client, "PUT", attachmentGuidEndpoint + "/resources", params, "increaseResources");
        setupTest(client, "PATCH", attachmentGuidEndpoint, params, "update");
        setupTest(client, "PATCH", attachmentGuidEndpoint + "/datasource_type", params, "updateDataSourceType");
        setupTest(client, "DELETE", attachmentGuidEndpoint, params, "delete", 204);
    }

    /*
    @Test
    public void testCreate() {
        AttachmentRequest body = readRequestFromFile("create", new TypeReference<AttachmentRequest>() {});
        Attachment response = api.create(DATAASSET_GUID, body, null, PROJECT_GUID, null).block();
        assertNotNull(response);
        validateAttachment(response);
        assertEquals(response.getAttachmentType(), "remote");
        assertEquals(response.getAssetCategory(), AssetCategory.USER);
    }

    @Test
    public void testMarkTransferComplete() {
        // TODO: current tests are for a remote asset, so transfer complete is not applicable
        assertThrows(WebClientResponseException.BadRequest.class, () -> api.markTransferComplete(DATAASSET_GUID, attachmentGuid, null, PROJECT_GUID, null).block());
    }
    */

    @Test
    public void testGet() {
        AttachmentDetail response = api.get(DATAASSET_GUID, attachmentGuid, null, null, PROJECT_GUID, null, null, null, null).block();
        assertNotNull(response);
        validateAttachment(response);
    }

    /*
    @Test
    public void testGetResources() {
        // TODO: implement after the asset files APIs (so we have local rather than remote attachments)
    }

    @Test
    public void testIncreaseResources() {
        // TODO: implement after the asset files APIs (so we have local rather than remote attachments)
    }

    @Test
    public void testUpdate() {
        // TODO: implement after the asset files APIs (so we have local rather than remote attachments)
    }

    @Test
    public void testUpdateDataSourceType() {
        // TODO: implement after the asset files APIs (so we have local rather than remote attachments)
    }

    @Test
    public void testDelete() {
        // TODO: implement after the asset files APIs (so we have local rather than remote attachments)
    }
    */

    private void validateAttachment(AttachmentDetail attachment) {
        assertEquals(attachment.getAttachmentId(), attachmentGuid);
        assertEquals(attachment.getAssetType(), "data_profile");
        assertFalse(attachment.getIsPartitioned());
        assertEquals(attachment.getName(), "data_profile_f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertNotNull(attachment.getCreatedAt());
        assertEquals(attachment.getObjectKey(), "data_profile_f4efc9d0-62f7-4600-9175-01bf983dd970");
        assertFalse(attachment.getObjectKeyIsReadOnly());
        assertEquals(attachment.getDatasourceType(), "81bafdbd-b7c6-45c5-a4fd-6ec135f66f4e");
        assertNotNull(attachment.getUrl());
        assertTrue(attachment.getTransferComplete());
        assertEquals(attachment.getSize(), Long.valueOf(159322L));
        assertNotNull(attachment.getUserData());
        assertEquals(attachment.getCreatorId(), "icp4d-dev");
        assertNotNull(attachment.getUsage());
        assertEquals(attachment.getUsage().getAccessCount(), Integer.valueOf(1));
        assertEquals(attachment.getUsage().getLastAccessorId(), EXSTUSER_GUID);
        assertEquals(attachment.getUsage().getLastAccessTime(), Long.valueOf(1614185157962L));
        assertNotNull(attachment.getHref());
    }

}
