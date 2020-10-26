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
import com.ibm.watson.data.client.api.ReferenceDataSetsApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.GlossaryObjectDraftMode;
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.io.File;
import java.util.*;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Reference Data Sets API endpoints.
 */
public class ReferenceDataSetsTest extends AbstractExpectations {

    private final ReferenceDataSetsApiV3 api = new ReferenceDataSetsApiV3(MockConstants.getApiClient());

    public ReferenceDataSetsTest() {
        super(ReferenceDataSetsApiV3.BASE_API, "referenceDataSets");
    }

    private static final String draftVersion = "1fb40e50-44f6-4227-803b-85635550ebf4";
    private static final String workflowId = "8f1fff25-1785-11eb-8009-0a580a81055e";
    private static final String draftEndpoint = "/" + NEW_REF_DATA_GUID + "/versions/" + draftVersion;
    private static final String code = "A";
    private static final String draftCodeEndpoint = draftEndpoint + "/values/" + code;
    private static final String importId = "1ddd8711-fc29-4a02-8cc0-e79c152fa96e";
    private static final String importEndpoint = draftEndpoint + "/values/import/" + importId;
    private static final String publishedVersion = "43ca6687-8902-4b52-a7bc-26870129599b_0";
    private static final String publishedEndpoint = "/" + NEW_REF_DATA_GUID + "/versions/" + publishedVersion;
    private static final String relationshipId = "44a8608a-8d99-4f1d-a3d1-bc828070cd7b";
    private static final String valueRelationshipId = "592600a9-5a58-4fd1-afed-883ea1f524e0";

    private final Map<String, List<String>> importParams = new HashMap<>();
    private final Map<String, List<String>> typeParams = new HashMap<>();
    private void setupParams() {
        importParams.put("code", Collections.singletonList("CODE"));
        importParams.put("value", Collections.singletonList("VALUE"));
        importParams.put("description", Collections.singletonList("DESCRIPTION"));
        importParams.put("is_first_row_header", Collections.singletonList("true"));
        typeParams.put("type", Collections.singletonList("all"));
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "DELETE", draftEndpoint + "/values", "deleteValues");
        setupTest(client, "POST", draftEndpoint + "/relationships", "createRelationships", 201);
        setupTest(client, "POST", draftCodeEndpoint + "/relationships", "relateTermsToValue");
        setupTest(client, "DELETE", importEndpoint, "cancelImport", 202);
        setupTest(client, "POST", "", "create", 201);
        setupTest(client, "PUT", draftEndpoint + "/values", "createValues", 201);
        setupTest(client, "DELETE", publishedEndpoint, "delete", 201);
        setupTest(client, "GET", importEndpoint, "getImport");
        setupTest(client, "GET", "/" + NEW_REF_DATA_GUID + "/versions", "list");
        setupTest(client, "GET", draftEndpoint, "get");
        client
                .when(withRequest("GET", getBaseUrl() + draftEndpoint + "/values", getArea(), "exportValues"))
                .respond(withResponse(getResourceFileContents(getArea() + File.separator + "exportValues" + File.separator + "response.csv")).withHeader("Content-Type", "text/csv"));
        //setupTest(client, "POST", importEndpoint, "importValues", 201);
        // Note that for the import we will test any CSV rather than a specific one, as the
        // MockServer is not yet easily capable of handling multi-part form requests with files
        client
                .when(withRequest("PUT", getBaseUrl() + draftEndpoint + "/values/import", getArea(), "importValuesCSV").withQueryStringParameters(importParams))
                .respond(withResponse(getArea(), "importValuesCSV").withStatusCode(202));
        setupTest(client, "GET", draftEndpoint + "/relationships", typeParams, "listRelationships");
        setupTest(client, "GET", draftCodeEndpoint + "/relationships", "listValueRelationships");
        setupTest(client, "DELETE", draftEndpoint + "/relationships/" + relationshipId, "deleteRelationship");
        setupTest(client, "DELETE", draftCodeEndpoint + "/relationships/" + valueRelationshipId, "deleteValueRelationship");
        setupTest(client, "PATCH", draftEndpoint, "update");
        setupTest(client, "PATCH", draftEndpoint + "/values", "updateValues", 202);
    }

    @Test
    public void testCreate() {
        NewReferenceDataSetEntity body = readRequestFromFile("create", new TypeReference<NewReferenceDataSetEntity>() {});
        GlossaryCreateResponse response = api.create(body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_REF_DATA_GUID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), workflowId);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        assertEquals(one.getEntityType(), "reference_data");
    }

    @Test
    public void testGet() {
        ResponseReferenceDataSet response = api.get(NEW_REF_DATA_GUID, draftVersion, null, null, null, null, null, null, null, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), draftVersion);
        validateEntity(response.getEntity());
    }

    @Test
    public void testCreateValues() {
        ReferenceDataValuesList body = readRequestFromFile("createValues", new TypeReference<ReferenceDataValuesList>() {});
        CreateRDVResponse response = api.createValues(NEW_REF_DATA_GUID, draftVersion, body, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        RDVGlossaryResource resource = response.getResources().get(0);
        assertNotNull(resource);
        validateGlossaryResource(resource);
        assertNotNull(resource.getRdsValues());
        assertEquals(resource.getRdsValues().size(), 1);
        ResponseReferenceDataValueEntity one = resource.getRdsValues().get(0);
        assertNotNull(one);
        assertEquals(one.getCode(), "D");
        assertEquals(one.getValue(), "Delete");
        assertEquals(one.getDescription(), "the fourth letter of the alphabet");
        assertEquals(one.getRevision(), "0");
    }

    @Test
    public void testExportValues() {
        String response = api.exportValues(NEW_REF_DATA_GUID, draftVersion, null, null, null).block();
        assertNotNull(response);
        assertTrue(response.startsWith("\"code\",\"value\",\"description\",\"parent\""));
    }

    @Test
    public void testImportValuesCSV() {
        File csv = getFileFromResources(getArea() + File.separator + "importValuesCSV" + File.separator + "request.csv");
        CreateRDSResponse response = api.importValuesCSV(NEW_REF_DATA_GUID, draftVersion, "CODE", "VALUE", csv, true, "DESCRIPTION", null, null, null, null, null).getBody();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        RDSResource one = response.getResources().get(0);
        assertNotNull(one);
        assertNotNull(one.getLog());
        assertNotNull(one.getLog().getHref());
        assertEquals(one.getLog().getImportId(), importId);
        assertEquals(one.getLog().getImportState(), "IN_PROGRESS");
        assertEquals(one.getLog().getImportMessage(), "Import in progress");
        assertEquals(one.getLog().getValuesCount(), Long.valueOf(1L));
        assertEquals(one.getLog().getValuesProcessed(), Long.valueOf(0L));
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_REF_DATA_GUID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), workflowId);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        assertEquals(one.getEntityType(), "reference_data");
    }

    /*@Test
    public void testImportValues() {
        GlossaryCreateResponse response = api.importValues(NEW_REF_DATA_GUID, draftVersion, importId, null).block();
        assertNotNull(response);
        // TODO: it is not clear what this is actually supposed to do or how it is different from importValuesCSV?
    }*/

    @Test
    public void testGetImport() {
        RDVImportInfoResponse response = api.getImport(NEW_REF_DATA_GUID, draftVersion, importId, null).block();
        assertNotNull(response);
        assertNotNull(response.getImportInfo());
        assertNotNull(response.getImportInfo().getHref());
        assertEquals(response.getImportInfo().getImportId(), importId);
        assertEquals(response.getImportInfo().getImportState(), "IN_PROGRESS");
        assertEquals(response.getImportInfo().getImportMessage(), "Import in progress");
        assertEquals(response.getImportInfo().getValuesCount(), Long.valueOf(1L));
        assertEquals(response.getImportInfo().getValuesProcessed(), Long.valueOf(0L));
        assertEquals(response.getImportInfo().getValuesSkipped(), Long.valueOf(0L));
        assertEquals(response.getImportInfo().getValuesInserted(), Long.valueOf(0L));
    }

    @Test
    public void testCancelImport() {
        RDVImportInfoResponse response = api.cancelImport(NEW_REF_DATA_GUID, draftVersion, importId, null).block();
        assertNotNull(response);
        assertNotNull(response.getImportInfo());
        assertNotNull(response.getImportInfo().getHref());
        assertEquals(response.getImportInfo().getImportId(), importId);
        assertEquals(response.getImportInfo().getImportState(), "CANCEL_REQUESTED");
        assertEquals(response.getImportInfo().getImportMessage(), "Import in progress");
        assertEquals(response.getImportInfo().getValuesCount(), Long.valueOf(1L));
        assertEquals(response.getImportInfo().getValuesProcessed(), Long.valueOf(0L));
        assertEquals(response.getImportInfo().getValuesSkipped(), Long.valueOf(0L));
        assertEquals(response.getImportInfo().getValuesInserted(), Long.valueOf(0L));
    }

    @Test
    public void testUpdateValues() {
        UpdatableReferenceDataValuesList body = readRequestFromFile("updateValues", new TypeReference<UpdatableReferenceDataValuesList>() {});
        CreateRDVResponse response = api.updateValues(NEW_REF_DATA_GUID, draftVersion, body, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        RDVGlossaryResource resource = response.getResources().get(0);
        assertNotNull(resource);
        validateGlossaryResource(resource);
        assertNotNull(resource.getRdsValues());
        assertEquals(resource.getRdsValues().size(), 1);
        ResponseReferenceDataValueEntity one = resource.getRdsValues().get(0);
        assertNotNull(one);
        assertEquals(one.getCode(), "D");
        assertEquals(one.getValue(), "Delete");
        assertEquals(one.getDescription(), "now with a modified description");
        assertEquals(one.getRevision(), "1");
    }

    @Test
    public void testRelateTermsToValue() {
        List<NewRelationship> body = readRequestFromFile("relateTermsToValue", new TypeReference<List<NewRelationship>>() {});
        CreateValueRelationshipResponse response = api.relateTermsToValue(NEW_REF_DATA_GUID, draftVersion, code, body, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        CreateValueRelationshipResponseResource resource = response.getResources().get(0);
        assertNotNull(resource);
        validateGlossaryResource(resource);
        assertNotNull(resource.getRdsValues());
        assertEquals(resource.getRdsValues().size(), 1);
        ResponseRDVCreateRelationshipEntity one = resource.getRdsValues().get(0);
        assertNotNull(one);
        assertEquals(one.getCode(), "D");
        assertNotNull(one.getTerms());
        assertEquals(one.getTerms().size(), 1);
        RelationshipCreateResponseIds other = one.getTerms().get(0);
        assertNotNull(other);
        assertEquals(other.getRelationshipId(), "592600a9-5a58-4fd1-afed-883ea1f524e0");
        assertEquals(other.getTargetId(), "13d98203-6aad-4003-87a0-87c662c95cd1");
        assertNotNull(one.getChild());
        assertEquals(one.getChild().size(), 0);
    }

    @Test
    public void testListValueRelationships() {
        Map<String, PaginatedAbstractRelationshipList> response = api.listValueRelationships(NEW_REF_DATA_GUID, draftVersion, code, null, null).block();
        assertNotNull(response);
        assertTrue(response.containsKey("terms"));
        PaginatedAbstractRelationshipList terms = response.get("terms");
        assertNotNull(terms);
        assertEquals(terms.getOffset(), Integer.valueOf(0));
        assertNotNull(terms.getLast());
        assertNotNull(terms.getLast().getHref());
        assertNotNull(terms.getResources());
        assertEquals(terms.getResources().size(), 1);
        AbstractRelationship one = terms.getResources().get(0);
        assertNotNull(one);
        GlossaryObjectMetadata metadata = one.getMetadata();
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), valueRelationshipId);
        assertEquals(metadata.getVersionId(), "80c9d121-207d-4879-925c-1ea46e3ea3da");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + valueRelationshipId);
        assertEquals(metadata.getWorkflowId(), workflowId);
        assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getShortDescription(), "Testing value-to-term relationship via API");
        assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
        assertTrue(one.getEntity() instanceof RelationshipEntity);
        RelationshipEntity entity = (RelationshipEntity) one.getEntity();
        assertEquals(entity.getTargetId(), "13d98203-6aad-4003-87a0-87c662c95cd1");
        assertEquals(entity.getTargetGlobalId(), REPOSITORY_ID + "_13d98203-6aad-4003-87a0-87c662c95cd1");
        assertEquals(entity.getTargetName(), "Test Term");
        assertEquals(entity.getRelationshipType(), "value_to_term");
        assertEquals(entity.getSourceType(), "reference_data_value");
        assertEquals(entity.getTargetType(), "glossary_term");
        assertEquals(entity.getDescription(), "Testing value-to-term relationship via API");
        assertEquals(terms.getLimit(), Integer.valueOf(10));
        assertEquals(terms.getCount(), Long.valueOf(1L));
        assertNotNull(terms.getFirst());
        assertNotNull(terms.getFirst().getHref());
    }

    @Test
    public void testDeleteValueRelationship() {
        GlossaryCreateResponse response = api.deleteValueRelationship(NEW_REF_DATA_GUID, draftVersion, code, valueRelationshipId, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_REF_DATA_GUID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), workflowId);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        assertEquals(one.getEntityType(), "reference_data");
    }

    @Test
    public void testDeleteValues() {
        List<String> body = readRequestFromFile("deleteValues", new TypeReference<List<String>>() {});
        GlossaryCreateResponse response = api.deleteValues(NEW_REF_DATA_GUID, draftVersion, null, body).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        GlossaryResource one = response.getResources().get(0);
        assertNotNull(one.getHref());
        assertEquals(one.getArtifactId(), NEW_REF_DATA_GUID);
        assertEquals(one.getVersionId(), draftVersion);
        assertEquals(one.getWorkflowId(), workflowId);
        assertEquals(one.getGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        assertEquals(one.getEntityType(), "reference_data");
    }

    @Test
    public void testCreateRelationships() {
        ReferenceDataSetRelationships body = readRequestFromFile("createRelationships", new TypeReference<ReferenceDataSetRelationships>() {});
        CreateRelationshipResponse response = api.createRelationships(NEW_REF_DATA_GUID, draftVersion, body, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        CreateRelationshipResponseResource resource = response.getResources().get(0);
        assertNotNull(resource);
        validateGlossaryResource(resource);
        assertNotNull(resource.getTerms());
        assertEquals(resource.getTerms().size(), 1);
        RelationshipCreateResponseIds one = resource.getTerms().get(0);
        assertNotNull(one);
        assertEquals(one.getRelationshipId(), relationshipId);
        assertEquals(one.getTargetId(), "13d98203-6aad-4003-87a0-87c662c95cd1");
        assertNotNull(resource.getClassifications());
        assertEquals(resource.getClassifications().size(), 0);
        assertNotNull(resource.getCategories());
        assertEquals(resource.getCategories().size(), 0);
        assertNotNull(resource.getChild());
        assertEquals(resource.getChild().size(), 0);
        assertNotNull(resource.getParent());
        assertEquals(resource.getParent().size(), 0);
    }

    @Test
    public void testListRelationships() {
        Map<String, PaginatedAbstractRelationshipList> response = api.listRelationships(NEW_REF_DATA_GUID, draftVersion, "all", null, null).block();
        assertNotNull(response);
        assertTrue(response.containsKey("terms"));
        PaginatedAbstractRelationshipList list = response.get("terms");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        AbstractRelationship one = list.getResources().get(0);
        validateTermMetadata(one.getMetadata());
        AbstractRelationshipEntity oneEntity = one.getEntity();
        assertTrue(oneEntity instanceof RelationshipEntity);
        validateTermEntity((RelationshipEntity)oneEntity);
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
        assertTrue(response.containsKey("parent_category"));
        list = response.get("parent_category");
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertEquals(list.getResources().size(), 1);
        one = list.getResources().get(0);
        validateParentCategoryMetadata(one.getMetadata());
        oneEntity = one.getEntity();
        assertTrue(oneEntity instanceof ParentRelationshipEntity);
        validateParentCategoryEntity((ParentRelationshipEntity)oneEntity);
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertEquals(list.getCount(), Long.valueOf(1L));
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
    }

    @Test
    public void testDeleteRelationship() {
        GlossaryCreateResponse response = api.deleteRelationship(NEW_REF_DATA_GUID, draftVersion, relationshipId, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        validateGlossaryResource(response.getResources().get(0));
    }

    @Test
    public void testUpdate() {
        UpdatableReferenceDataSetEntity body = readRequestFromFile("update", new TypeReference<UpdatableReferenceDataSetEntity>() {});
        ResponseReferenceDataSet response = api.update(NEW_REF_DATA_GUID, draftVersion, body, null).block();
        assertNotNull(response);
        validateMetadata(response.getMetadata(), draftVersion, "1");
        ResponseReferenceDataSetEntity entity = response.getEntity();
        assertNotNull(entity);
        validateEntity(response.getEntity(), "now with a long description");
    }

    @Test
    public void testList() {
        PaginatedReferenceDataSetList response = api.list(NEW_REF_DATA_GUID, null, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getOffset(), Integer.valueOf(0));
        assertNotNull(response.getLast());
        assertNotNull(response.getLast().getHref());
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        ResponseReferenceDataSet one = response.getResources().get(0);
        assertNotNull(one);
        validateMetadata(one.getMetadata(), publishedVersion, "0");
        ResponseReferenceDataSetEntity entity = one.getEntity();
        assertNotNull(entity);
        // Unlike other retrievals, the list does not retrieve the RDS values
        assertEquals(entity.getType(), "TEXT");
        assertEquals(entity.getLongDescription(), "now with a long description");
        assertEquals(entity.getState(), GlossaryObjectState.PUBLISHED);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertTrue(entity.getCustomAttributes() == null || entity.getCustomAttributes().isEmpty());
        assertEquals(response.getLimit(), Integer.valueOf(10));
        assertEquals(response.getCount(), Long.valueOf(1L));
        assertNotNull(response.getFirst());
        assertNotNull(response.getFirst().getHref());
    }

    @Test
    public void testDelete() {
        api.delete(NEW_REF_DATA_GUID, publishedVersion, null, null).block();
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String version) {
        validateMetadata(metadata, version, "0");
    }

    private void validateMetadata(GlossaryObjectMetadata metadata, String version, String revision) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "reference_data");
        assertEquals(metadata.getArtifactId(), NEW_REF_DATA_GUID);
        assertEquals(metadata.getVersionId(), version);
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        if (version.equals(draftVersion)) {
            assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
            assertEquals(metadata.getWorkflowId(), workflowId);
            assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
            assertEquals(metadata.getWorkflowState(), "Not started");
        } else if (version.equals(publishedVersion)) {
            assertEquals(metadata.getState(), GlossaryObjectState.PUBLISHED);
            assertEquals(metadata.getDraftAncestorId(), draftVersion);
        }
        assertEquals(metadata.getRevision(), revision);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getName(), "Test RDS");
        assertNotNull(metadata.getTags());
        assertEquals(metadata.getTags().size(), 0);
        assertNotNull(metadata.getStewardIds());
        assertEquals(metadata.getStewardIds().size(), 0);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateEntity(ResponseReferenceDataSetEntity entity) {
        validateEntity(entity, "A simple reference data set to test the APIs.");
    }

    private void validateEntity(ResponseReferenceDataSetEntity entity, String description) {
        assertNotNull(entity);
        PaginatedReferenceDataValueEntityList list = entity.getRdsValues();
        assertNotNull(list);
        assertEquals(list.getOffset(), Integer.valueOf(0));
        assertNotNull(list.getLast());
        assertNotNull(list.getLast().getHref());
        assertNotNull(list.getResources());
        assertTrue(list.getResources().size() >= 3);
        ResponseReferenceDataValueEntity one = list.getResources().get(0);
        assertNotNull(one);
        assertEquals(one.getCode(), "A");
        assertEquals(one.getValue(), "Apple");
        assertEquals(one.getDescription(), "the first letter of the alphabet");
        assertEquals(one.getRevision(), "0");
        assertEquals(list.getLimit(), Integer.valueOf(10));
        assertTrue(list.getCount() >= 3L);
        assertNotNull(list.getFirst());
        assertNotNull(list.getFirst().getHref());
        assertEquals(entity.getType(), "TEXT");
        assertTrue(entity.getRdsValuesTotalCounts() == null || entity.getRdsValuesTotalCounts() >= 3L);
        assertEquals(entity.getLongDescription(), description);
        assertEquals(entity.getState(), GlossaryObjectState.DRAFT);
        assertEquals(entity.getDefaultLocaleId(), "en-US");
        assertTrue(entity.getCustomAttributes() == null || entity.getCustomAttributes().isEmpty());
    }

    private void validateGlossaryResource(GlossaryResource resource) {
        assertNotNull(resource.getHref());
        assertEquals(resource.getArtifactId(), NEW_REF_DATA_GUID);
        assertEquals(resource.getVersionId(), draftVersion);
        assertEquals(resource.getWorkflowId(), workflowId);
        assertEquals(resource.getGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        assertEquals(resource.getEntityType(), "reference_data");
    }

    private void validateParentCategoryMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), "c37e4cf1-2c99-4cad-9ce7-519ba69bdc3a");
        assertEquals(metadata.getVersionId(), "7ea95884-d1ee-4bb8-8145-8a01aa1f5481");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_c37e4cf1-2c99-4cad-9ce7-519ba69bdc3a");
        assertEquals(metadata.getWorkflowId(), workflowId);
        assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateParentCategoryEntity(ParentRelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getParentId(), UNCATEGORY_ID);
        assertEquals(entity.getParentGlobalId(), REPOSITORY_ID + "_" + UNCATEGORY_ID);
        assertEquals(entity.getParentName(), "[uncategorized]");
        assertTrue(entity.getParentEnabled());
        assertEquals(entity.getChildId(), NEW_REF_DATA_GUID);
        assertEquals(entity.getChildGlobalId(), REPOSITORY_ID + "_" + NEW_REF_DATA_GUID);
        assertEquals(entity.getChildName(), "Test RDS");
        assertEquals(entity.getRelationshipType(), "parent_category");
        assertEquals(entity.getSourceType(), "reference_data");
        assertEquals(entity.getTargetType(), "category");
    }

    private void validateTermMetadata(GlossaryObjectMetadata metadata) {
        assertNotNull(metadata);
        assertEquals(metadata.getArtifactType(), "relationship");
        assertEquals(metadata.getArtifactId(), relationshipId);
        assertEquals(metadata.getVersionId(), "9a48d0e9-f117-4826-83a8-04a757eb9d92");
        assertEquals(metadata.getSourceRepositoryId(), REPOSITORY_ID);
        assertEquals(metadata.getGlobalId(), REPOSITORY_ID + "_" + relationshipId);
        assertEquals(metadata.getWorkflowId(), workflowId);
        assertEquals(metadata.getDraftMode(), GlossaryObjectDraftMode.CREATED);
        assertEquals(metadata.getCreatedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getRevision(), "0");
        assertEquals(metadata.getShortDescription(), "Testing new relationship via API");
        assertEquals(metadata.getState(), GlossaryObjectState.DRAFT);
        assertFalse(metadata.getReadOnly());
        assertFalse(metadata.getRemoveStartDate());
        assertFalse(metadata.getRemoveEndDate());
    }

    private void validateTermEntity(RelationshipEntity entity) {
        assertNotNull(entity);
        assertEquals(entity.getTargetId(), "13d98203-6aad-4003-87a0-87c662c95cd1");
        assertEquals(entity.getTargetGlobalId(), REPOSITORY_ID + "_13d98203-6aad-4003-87a0-87c662c95cd1");
        assertEquals(entity.getTargetName(), "Test Term");
        assertEquals(entity.getRelationshipType(), "related");
        assertEquals(entity.getSourceType(), "reference_data");
        assertEquals(entity.getTargetType(), "glossary_term");
        assertEquals(entity.getDescription(), "Testing new relationship via API");
    }

}
