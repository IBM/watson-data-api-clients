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
import com.ibm.watson.data.client.api.GovernanceArtifactTypesApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.ConditionValues;
import com.ibm.watson.data.client.model.enums.GovernancePermissionAction;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Workflows API endpoints.
 */
public class GovernanceArtifactTypesTest extends AbstractExpectations {

    private final GovernanceArtifactTypesApiV3 api = new GovernanceArtifactTypesApiV3(MockConstants.getApiClient());

    public GovernanceArtifactTypesTest() {
        super(GovernanceArtifactTypesApiV3.BASE_API, "governanceArtifactTypes");
    }

    private static final String versionId = "de8db9ee-4319-48c6-983f-8fd0b419a135";
    private static final String modId = "5252d5cf-9c7b-4dc5-b180-dd6228777277";
    private static final String commentId = "c2dfe1a5-0f9c-4f1c-ad07-386eed171377";

    private static final String artifactEndpoint = "/" + NEW_TERM_GUID + "/versions/" + versionId;
    private static final String commentEndpoint = artifactEndpoint + "/comments/" + commentId;
    private static final String customAttributeEndpoint = "/custom_attribute_definitions/" + CUSTOM_ATTR_ID;

    private final Map<String, List<String>> categoryParams = new HashMap<>();
    private void setupParams() {
        List<String> category = new ArrayList<>();
        category.add(UNCATEGORY_ID);
        categoryParams.put("category_id", category);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        injectIntoBaseUrl("{artifact_type}", "glossary_term");
        setupTest(client, "POST", "/custom_attribute_definitions", "createCustomAttributeDefinition", 201);
        setupTest(client, "DELETE", commentEndpoint, "deleteComment");
        setupTest(client, "POST", "/delete", "deleteArtifacts", 204);
        setupTest(client, "DELETE", customAttributeEndpoint, "deleteCustomAttributeDefinition");
        client
                .when(withRequest("GET", getBaseUrl() + "/export", getArea(), "exportCSV").withQueryStringParameters(categoryParams))
                .respond(withResponse(getResourceFileContents(getArea() + File.separator + "exportCSV" + File.separator + "response.csv")).withHeader("Content-Type", "text/csv"));
        setupTest(client, "GET", artifactEndpoint + "/aggregated_logs", "getAggregatedLog");
        setupTest(client, "GET", artifactEndpoint + "/logs", "getLog");
        setupTest(client, "GET", artifactEndpoint + "/aggregated_logs/" + modId, "getLogEntry");
        setupTest(client, "GET", customAttributeEndpoint, "getCustomAttributeDefinition");
        setupTest(client, "GET", "/custom_attribute_definitions", "listCustomAttributeDefinitions");
        setupTest(client, "GET", "", "getDraftArtifacts");
        setupTest(client, "GET", "/permissions", "getPermissions");
        // Note that for the import we will test any CSV rather than a specific one, as the
        // MockServer is not yet easily capable of handling multi-part form requests with files
        client
                .when(withRequest("POST", getBaseUrl() + "/import", getArea(), "importCSV"))
                .respond(withResponse(getArea(), "importCSV"));
        setupTest(client, "POST", artifactEndpoint + "/comments", "logComment", 201);
        setupTest(client, "PATCH", commentEndpoint, "updateComment");
        setupTest(client, "PATCH", customAttributeEndpoint, "updateCustomAttributeDefinition");
    }

    @Test
    public void testGetPermissions() {
        List<GovernancePermission> response = api.getPermissions("glossary_term", null).block();
        assertNotNull(response);
        assertEquals(response.size(), 1);
        GovernancePermission one = response.get(0);
        assertEquals(one.getPermissionId(), "UserManagementPermission");
        assertNotNull(one.getCondition());
        assertEquals(one.getCondition().getType(), "artifact_type");
        assertNotNull(one.getCondition().getValues());
        assertEquals(one.getCondition().getValues().get(0), ConditionValues.CATEGORY);
        assertNotNull(one.getActions());
        assertEquals(one.getActions().size(), 2);
        assertEquals(one.getActions().get(0), GovernancePermissionAction.AUTHOR);
    }

    @Test
    public void testExportCSV() {
        String response = api.exportCSV("glossary_term", UNCATEGORY_ID, null, null).block();
        assertNotNull(response);
        assertTrue(response.startsWith("Name,Artifact Type"));
        assertTrue(response.contains("Test Term"));
    }

    @Test
    public void testImportCSV() {
        File csv = getFileFromResources(getArea() + File.separator + "importCSV" + File.separator + "request.csv");
        GlossaryImportResult response = api.importCSV("glossary_term", csv, null, null).getBody();
        assertNotNull(response);
        assertEquals(response.getWorkflowId(), "dadb2663-e2d8-11ea-8c06-0a580a810041");
        assertNotNull(response.getMessages());
        assertEquals(response.getMessages().size(), 0);
        Map<String, Map<String, Long>> ops = response.getOperationsCount();
        assertNotNull(ops);
        assertTrue(ops.containsKey("glossary_term"));
        assertNotNull(ops.get("glossary_term"));
        assertTrue(ops.get("glossary_term").containsKey("IMPORT_MODIFY"));
        assertEquals(ops.get("glossary_term").get("IMPORT_MODIFY"), Long.valueOf(1L));
    }

    @Test
    public void testCreateCustomAttributeDefinition() {
        NewCustomAttributeDefinitionEntity body = readRequestFromFile("createCustomAttributeDefinition", new TypeReference<NewCustomAttributeDefinitionEntity>() {});
        GlossaryCreateResponse response = api.createCustomAttributeDefinition("glossary_term", body, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), CUSTOM_ATTR_ID);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + CUSTOM_ATTR_ID);
    }

    @Test
    public void testListCustomAttributeDefinitions() {
        List<CustomAttributeDefinition> response = api.listCustomAttributeDefinitions("glossary_term", null).block();
        assertNotNull(response);
        assertEquals(response.size(), 1);
        CustomAttributeDefinition one = response.get(0);
        assertNotNull(one);
        validateCustomAttributeMetadata(one.getMetadata());
        validateCustomAttributeEntity(one.getEntity());
    }

    @Test
    public void testGetCustomAttributeDefinition() {
        CustomAttributeDefinition response = api.getCustomAttributeDefinition("glossary_term", CUSTOM_ATTR_ID, null).block();
        assertNotNull(response);
        validateCustomAttributeMetadata(response.getMetadata());
        validateCustomAttributeEntity(response.getEntity());
    }

    @Test
    public void testUpdateCustomAttributeDefinition() {
        NewCustomAttributeDefinitionEntity body = readRequestFromFile("updateCustomAttributeDefinition", new TypeReference<NewCustomAttributeDefinitionEntity>() {});
        CustomAttributeDefinition response = api.updateCustomAttributeDefinition("glossary_term", CUSTOM_ATTR_ID, body, null).block();
        assertNotNull(response);
        validateCustomAttributeMetadata(response.getMetadata(), "1");
        assertNotNull(response.getMetadata());
        assertEquals(response.getMetadata().getShortDescription(), "A revised description for the custom attribute");
        validateCustomAttributeEntity(response.getEntity());
        assertNotNull(response.getEntity());
        assertEquals(response.getEntity().getDescription(), "A revised description for the custom attribute");
    }

    @Test
    public void testDeleteCustomAttributeDefinition() {
        GlossaryArchiveResponse response = api.deleteCustomAttributeDefinition("glossary_term", CUSTOM_ATTR_ID, null).block();
        assertNotNull(response);
        assertNotNull(response.getArchivedGuids());
        assertEquals(response.getArchivedGuids().size(), 0);
        assertNotNull(response.getUpdatedGuids());
        assertEquals(response.getUpdatedGuids().size(), 0);
        assertNotNull(response.getDeleteGuids());
        assertEquals(response.getDeleteGuids().size(), 1);
        assertEquals(response.getDeleteGuids().get(0), CUSTOM_ATTR_ID);
    }

    @Test
    public void testLogComment() {
        CommentByUser body = readRequestFromFile("logComment", new TypeReference<CommentByUser>() {});
        CommentByUser response = api.logComment("glossary_term", NEW_TERM_GUID, versionId, body, null).block();
        assertNotNull(response);
        assertTrue(response.getAllowEdits());
        assertEquals(response.getComment(), "This is a test comment.");
    }

    @Test
    public void testGetAggregatedLog() {
        PaginatedAssetAggregatedCommentsList response = api.getAggregatedLog("glossary_term", NEW_TERM_GUID, versionId, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 3);
        AssetAggregatedCommentsList aacl = response.getResources().get(0);
        assertNotNull(aacl);
        assertEquals(aacl.getLogStatus(), "COMMENTED");
        assertNotNull(aacl.getMetadata());
        assertEquals(aacl.getMetadata().getDayOfEvent(), "2020-09-02");
        assertNotNull(aacl.getEntities());
        assertEquals(aacl.getEntities().size(), 1);
        AssetComment aac = aacl.getEntities().get(0);
        assertNotNull(aac);
        assertNotNull(aac.getMetadata());
        assertEquals(aac.getMetadata().getId(), commentId);
        assertEquals(aac.getMetadata().getAssetVersionId(), versionId);
        assertEquals(aac.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(aac.getMetadata().getModifiedAt());
        assertNotNull(aac.getMetadata().getCreatedAt());
        assertNotNull(aac.getEntity());
        assertEquals(aac.getEntity().getComment(), "This is a test comment.");
        assertEquals(aac.getEntity().getLogStatus(), "COMMENTED");
        assertEquals(aac.getEntity().getAction(), "Commented");
        assertNotNull(aac.getEntity().getModificationDetails());
        assertEquals(aac.getEntity().getModificationDetails().size(), 0);
        aacl = response.getResources().get(1);
        assertNotNull(aacl);
        assertEquals(aacl.getLogStatus(), "MODIFIED");
        assertNotNull(aacl.getMetadata());
        assertEquals(aacl.getMetadata().getDayOfEvent(), "2020-09-02");
        assertNotNull(aacl.getEntities());
        assertEquals(aacl.getEntities().size(), 1);
        aac = aacl.getEntities().get(0);
        assertNotNull(aac);
        assertNotNull(aac.getMetadata());
        assertEquals(aac.getMetadata().getId(), "5252d5cf-9c7b-4dc5-b180-dd6228777277");
        assertEquals(aac.getMetadata().getAssetVersionId(), versionId);
        assertEquals(aac.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(aac.getMetadata().getModifiedAt());
        assertNotNull(aac.getMetadata().getCreatedAt());
        assertNotNull(aac.getEntity());
        assertEquals(aac.getEntity().getLogStatus(), "MODIFIED");
        assertNotNull(aac.getEntity().getModificationDetails());
        assertEquals(aac.getEntity().getModificationDetails().size(), 1);
        AssetCommentPropertyModification one = aac.getEntity().getModificationDetails().get(0);
        assertNotNull(one);
        assertEquals(one.getPropertyName(), "parent_category");
        assertEquals(one.getPropertyType(), "Relationship");
        assertEquals(one.getNumberOfElements(), Long.valueOf(1));
        assertEquals(one.getAdditionalInfo(), "category");
        assertEquals(one.getAction(), "Added");
        assertEquals(one.getModId(), "5252d5cf-9c7b-4dc5-b180-dd6228777277");
        assertNotNull(one.getInitialValues());
        assertEquals(one.getInitialValues().size(), 1);
        AssetCommentsModificationDetails details = one.getInitialValues().get(0);
        assertNotNull(details);
        assertNotNull(details.getMetadata());
        assertEquals(details.getMetadata().getId(), "5252d5cf-9c7b-4dc5-b180-dd6228777277");
        assertEquals(details.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(details.getMetadata().getModifiedAt());
        assertNotNull(details.getEntity());
        assertNotNull(details.getEntity().getModificationDetails());
        assertEquals(details.getEntity().getModificationDetails().getPropertyName(), "parent_category");
        assertEquals(details.getEntity().getModificationDetails().getNewValue(), "[uncategorized]");
        assertEquals(details.getEntity().getModificationDetails().getPropertyType(), "Relationship");
        assertEquals(details.getEntity().getModificationDetails().getAdditionalInfo(), "category");
        assertEquals(details.getEntity().getModificationDetails().getAction(), "Added");
        aacl = response.getResources().get(2);
        assertEquals(aacl.getLogStatus(), "CREATED");
        assertNotNull(aacl.getMetadata());
        assertEquals(aacl.getMetadata().getDayOfEvent(), "2020-09-02");
        assertNotNull(aacl.getEntities());
        assertEquals(aacl.getEntities().size(), 1);
        aac = aacl.getEntities().get(0);
        assertNotNull(aac);
        assertNotNull(aac.getMetadata());
        assertEquals(aac.getMetadata().getId(), "ba9ed1e2-fb8c-40a7-b5c3-f55354d3614d");
        assertEquals(aac.getMetadata().getAssetVersionId(), versionId);
        assertEquals(aac.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(aac.getMetadata().getModifiedAt());
        assertNotNull(aac.getMetadata().getCreatedAt());
        assertNotNull(aac.getEntity());
        assertEquals(aac.getEntity().getLogStatus(), "CREATED");
        assertNotNull(aac.getEntity().getModificationDetails());
        assertEquals(aac.getEntity().getModificationDetails().size(), 2);
        one = aac.getEntity().getModificationDetails().get(0);
        assertNotNull(one);
        assertEquals(one.getPropertyName(), "name");
        assertEquals(one.getNewValue(), "Test Term");
        assertEquals(one.getPropertyType(), "String");
        assertEquals(one.getAction(), "Added");
        one = aac.getEntity().getModificationDetails().get(1);
        assertNotNull(one);
        assertEquals(one.getPropertyName(), "longDescription");
        assertEquals(one.getNewValue(), "A term for testing APIs.");
        assertEquals(one.getPropertyType(), "String");
        assertEquals(one.getAction(), "Added");
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(3));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testGetLog() {
        PaginatedAssetCommentList response = api.getLog("glossary_term", NEW_TERM_GUID, versionId, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 3);
        AssetComment one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getId(), commentId);
        assertEquals(one.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(one.getMetadata().getModifiedAt());
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getComment(), "This is a test comment.");
        assertEquals(one.getEntity().getLogStatus(), "COMMENTED");
        assertEquals(one.getEntity().getAction(), "Commented");
        assertNotNull(one.getEntity().getModificationDetails());
        assertEquals(one.getEntity().getModificationDetails().size(), 0);
        one = response.getResources().get(1);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getId(), "5252d5cf-9c7b-4dc5-b180-dd6228777277");
        assertEquals(one.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(one.getMetadata().getModifiedAt());
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getLogStatus(), "MODIFIED");
        assertNotNull(one.getEntity().getModificationDetails());
        assertEquals(one.getEntity().getModificationDetails().size(), 1);
        AssetCommentPropertyModification details = one.getEntity().getModificationDetails().get(0);
        assertNotNull(details);
        assertEquals(details.getPropertyName(), "parent_category");
        assertEquals(details.getNewValue(), "[uncategorized]");
        assertEquals(details.getPropertyType(), "Relationship");
        assertEquals(details.getAdditionalInfo(), "category");
        assertEquals(details.getAction(), "Added");
        one = response.getResources().get(2);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getId(), "ba9ed1e2-fb8c-40a7-b5c3-f55354d3614d");
        assertEquals(one.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(one.getMetadata().getModifiedAt());
        assertNotNull(one.getEntity());
        assertEquals(one.getEntity().getLogStatus(), "CREATED");
        assertNotNull(one.getEntity().getModificationDetails());
        assertEquals(one.getEntity().getModificationDetails().size(), 2);
        details = one.getEntity().getModificationDetails().get(0);
        assertNotNull(details);
        assertEquals(details.getPropertyName(), "name");
        assertEquals(details.getNewValue(), "Test Term");
        assertEquals(details.getPropertyType(), "String");
        assertEquals(details.getAction(), "Added");
        details = one.getEntity().getModificationDetails().get(1);
        assertNotNull(details);
        assertEquals(details.getPropertyName(), "longDescription");
        assertEquals(details.getNewValue(), "A term for testing APIs.");
        assertEquals(details.getPropertyType(), "String");
        assertEquals(details.getAction(), "Added");
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(3));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testGetLogEntry() {
        PaginatedAssetCommentsModificationDetails response = api.getLogEntry("glossary_term", NEW_TERM_GUID, versionId, modId, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        AssetCommentsModificationDetails one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getMetadata());
        assertEquals(one.getMetadata().getId(), modId);
        assertEquals(one.getMetadata().getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(one.getMetadata().getModifiedAt());
        assertNotNull(one.getEntity());
        assertNotNull(one.getEntity().getModificationDetails());
        assertEquals(one.getEntity().getModificationDetails().getPropertyName(), "parent_category");
        assertEquals(one.getEntity().getModificationDetails().getNewValue(), "[uncategorized]");
        assertEquals(one.getEntity().getModificationDetails().getPropertyType(), "Relationship");
        assertEquals(one.getEntity().getModificationDetails().getAdditionalInfo(), "category");
        assertEquals(one.getEntity().getModificationDetails().getAction(), "Added");
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testUpdateComment() {
        CommentByUser body = readRequestFromFile("updateComment", new TypeReference<CommentByUser>() {});
        CommentByUser response = api.updateComment("glossary_term", NEW_TERM_GUID, versionId, commentId, body, null).block();
        assertNotNull(response);
        assertTrue(response.getAllowEdits());
        assertEquals(response.getComment(), "This is an updated comment.");
    }

    @Test
    public void testDeleteComment() {
        api.deleteComment("glossary_term", NEW_TERM_GUID, versionId, commentId, null).block();
    }

    @Test
    public void testGetDraftArtifacts() {
        PaginatedDraftArtifactsList response = api.getDraftArtifacts("glossary_term", null, null, null, null, null, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        DraftArtifact one = response.getResources().get(0);
        assertNotNull(one);
        assertEquals(one.getName(), "Test Term");
        assertEquals(one.getArtifactId(), NEW_TERM_GUID);
        assertEquals(one.getVersionId(), versionId);
        assertEquals(one.getWorkflowId(), WORKFLOW_GUID);
        assertEquals(one.getType(), "glossary_term");
        assertEquals(one.getLongDescription(), "A term for testing APIs.");
        assertNotNull(one.getCreatedAt());
        assertNotNull(one.getModifiedAt());
        assertEquals(one.getCreatedBy(), EXSTUSER_GUID);
        assertEquals(one.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(one.getParentCategory());
        assertEquals(one.getParentCategory().getArtifactId(), UNCATEGORY_ID);
        assertEquals(one.getParentCategory().getName(), "[uncategorized]");
        assertEquals(one.getWorkflowStatus(), "NOT STARTED");
        assertEquals(one.getDraftMode(), "CREATE");
        assertNotNull(one.getAbbreviations());
        assertEquals(one.getAbbreviations().size(), 0);
        assertFalse(one.getIsEnabled());
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testDeleteArtifacts() {
        GlossaryResourceList body = readRequestFromFile("deleteArtifacts", new TypeReference<GlossaryResourceList>() {});
        Response response = api.deleteArtifacts("glossary_term", body, null, null).block();
        assertNull(response);
    }

    private void validateCustomAttributeMetadata(GlossaryObjectMetadata metadata) {
        validateCustomAttributeMetadata(metadata, "0");
    }

    private void validateCustomAttributeMetadata(GlossaryObjectMetadata metadata, String revision) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "custom_attribute_definition");
        assertEquals(metadata.getArtifactId(), CUSTOM_ATTR_ID);
        assertEquals(metadata.getVersionId(), "06f409b2-082f-4e31-b248-d5eb12092ba8");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + CUSTOM_ATTR_ID);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getName(), "Test Custom Attribute");
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateCustomAttributeEntity(CustomAttributeDefinitionEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getName(), "Test Custom Attribute");
        assertEquals(entity.getType(), "NUMBER");
        assertNotNull(entity.getArtifactTypes());
        assertEquals(entity.getArtifactTypes().size(), 1);
        assertEquals(entity.getArtifactTypes().get(0), "glossary_term");
        assertNotNull(entity.getRelatedArtifactTypes());
        assertEquals(entity.getRelatedArtifactTypes().size(), 0);
        assertFalse(entity.getMultipleValues());
        assertFalse(entity.getDisplayInChildAssets());
        assertFalse(entity.getRequired());
        assertFalse(entity.getReadOnly());
        assertFalse(entity.getHidden());
        assertFalse(entity.getPlaceholder());
        assertNotNull(entity.getElementsList());
        assertEquals(entity.getElementsList().size(), 0);
    }

}