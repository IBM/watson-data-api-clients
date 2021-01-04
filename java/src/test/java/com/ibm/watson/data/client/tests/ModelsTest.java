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
import com.ibm.watson.data.client.api.ModelsApi;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import com.ibm.watson.data.client.model.enums.*;
import org.mockserver.client.MockServerClient;
import org.springframework.core.io.buffer.DataBuffer;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Space API endpoints.
 */
public class ModelsTest extends AbstractExpectations {

    private final ModelsApi api = new ModelsApi(MockConstants.getApiClient());

    public ModelsTest() {
        super(ModelsApi.BASE_API, "model");
    }

    private final String attachmentId = "4d898eb8-ac1f-4486-b535-b531d358672e";
    private final String modelEndpoint = "/" + MODEL_GUID;

    private final LocalDate version = LocalDate.of(2020, Month.DECEMBER, 22);
    private final Map<String, List<String>> listParams = new HashMap<>();
    private final Map<String, List<String>> downloadParams1 = new HashMap<>();
    private final Map<String, List<String>> downloadParams2 = new HashMap<>();
    private final Map<String, List<String>> createParams = new HashMap<>();
    private final Map<String, List<String>> uploadParams = new HashMap<>();
    private void setupParams() {
        List<String> v = new ArrayList<>();
        v.add(version.toString());
        listParams.put("version", v);
        downloadParams1.put("version", v);
        downloadParams2.put("version", v);
        createParams.put("version", v);
        uploadParams.put("version", v);
        List<String> s = new ArrayList<>();
        s.add(SPACE_GUID);
        listParams.put("space_id", s);
        downloadParams1.put("space_id", s);
        List<String> c = new ArrayList<>();
        c.add("native");
        uploadParams.put("content_format", c);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "GET", "", listParams, "list");
        setupTest(client, "GET", modelEndpoint, listParams, "get");
        setupTest(client, "GET", modelEndpoint + "/content", listParams, "listAttachments");
        setupTest(client, "POST", "", createParams, "create", 201);
        setupTest(client, "POST", modelEndpoint + "/revisions", createParams, "createRevision", 201);
        setupTest(client, "GET", modelEndpoint + "/revisions", listParams, "listRevisions");
        setupTest(client, "PATCH", modelEndpoint, createParams, "update");
        client
                .when(withRequest("GET", getBaseUrl() + modelEndpoint + "/content/" + attachmentId, getArea(), "download1").withQueryStringParameters(downloadParams1))
                .respond(withResponse(getResourceFileContents(getArea() + File.separator + "download1" + File.separator + attachmentId + ".tgz")).withHeader("Content-Type", "application/octet-stream"));
        client
                .when(withRequest("GET", getBaseUrl() + modelEndpoint + "/download", getArea(), "download2").withQueryStringParameters(downloadParams2))
                .respond(withResponse(getResourceFileContents(getArea() + File.separator + "download2" + File.separator + MODEL_GUID + ".tgz")).withHeader("Content-Type", "application/octet-stream"));
        // Note that for the upload we will test any TAR rather than a specific one, as the
        // MockServer is not yet easily capable of handling multi-part form requests with files
        client
                .when(withRequest("PUT", getBaseUrl() + modelEndpoint + "/content", getArea(), "upload").withQueryStringParameters(uploadParams))
                .respond(withResponse(getArea(), "upload").withStatusCode(201));
        setupTest(client, "DELETE", modelEndpoint + "/content/" + attachmentId, createParams, "deleteContent", 204);
        setupTest(client, "DELETE", modelEndpoint, createParams, "delete", 204);
    }

    @Test
    public void testCreate() {
        ModelEntityRequest body = readRequestFromFile("create", new TypeReference<ModelEntityRequest>() {});
        ModelResource model = api.create(version, body).block();
        validateSimpleModel(model, "This is a model to test the APIs work as expected.");
    }

    @Test
    public void testList() {
        ModelResources models = api.list(version, SPACE_GUID, null, null, null, null, null).block();
        assertNotNull(models);
        assertNotNull(models.getFirst());
        assertEquals(models.getTotalCount(), Long.valueOf(1));
        assertNotNull(models.getResources());
        assertEquals(models.getResources().size(), 1);
        validateComplexModel(models.getResources().get(0));
    }

    @Test
    public void testGet() {
        ModelResource model = api.get(MODEL_GUID, version, SPACE_GUID, null, null).block();
        validateComplexModel(model);
    }

    @Test
    public void testListAttachments() {
        AllContentMetadata response = api.listAttachments(MODEL_GUID, version, SPACE_GUID, null, null, null, null).block();
        assertNotNull(response);
        assertEquals(response.getTotalCount(), Integer.valueOf(1));
        assertNotNull(response.getAttachments());
        assertEquals(response.getAttachments().size(), 1);
        ContentMetadata one = response.getAttachments().get(0);
        assertNotNull(one);
        assertEquals(one.getAttachmentId(), attachmentId);
        assertEquals(one.getContentFormat(), "native");
        assertTrue(one.getPersisted());
    }

    @Test
    public void testCreateRevision() {
        ModelRevisionEntityRequest body = readRequestFromFile("createRevision", new TypeReference<ModelRevisionEntityRequest>() {});
        ModelResource model = api.createRevision(MODEL_GUID, version, body).block();
        validateSimpleModel(model, "This is a model to test the APIs work as expected.");
        assertNotNull(model);
        assertNotNull(model.getMetadata());
        validateSimpleModelRevision(model.getMetadata());
    }

    @Test
    public void testListRevisions() {
        ModelResources response = api.listRevisions(MODEL_GUID, version, SPACE_GUID, null, null, null).block();
        assertNotNull(response);
        assertNotNull(response.getFirst());
        assertEquals(response.getLimit(), Integer.valueOf(100));
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        ModelResource one = response.getResources().get(0);
        assertNull(one.getEntity());
        assertNull(one.getSystem());
        validateSimpleModelMetadata(one.getMetadata(), "This is a model to test the APIs work as expected.");
        validateSimpleModelRevision(one.getMetadata());
    }

    @Test
    public void testUpdate() {
        List<JSONResourcePatchModel> body = readRequestFromFile("update", new TypeReference<List<JSONResourcePatchModel>>() {});
        ModelResource model = api.update(MODEL_GUID, version, body, SPACE_GUID, null).block();
        validateSimpleModel(model, "Now with an updated description.");
    }

    @Test
    public void testDownload1() {
        Mono<DataBuffer> stream = api.download(MODEL_GUID, attachmentId, version, SPACE_GUID, null, null);
        validateDownload(stream);
    }

    @Test
    public void testDownload2() {
        Mono<DataBuffer> stream = api.download(MODEL_GUID, version, SPACE_GUID, null, null, null, null, null);
        validateDownload(stream);
    }

    @Test
    public void testUpload() {
        File tar = getFileFromResources(getArea() + File.separator + "upload" + File.separator + "request.tgz");
        ContentMetadata response = api.upload(MODEL_GUID, version, "native", tar, SPACE_GUID, null, null, null).getBody();
        assertNotNull(response);
        assertEquals(response.getAttachmentId(), attachmentId);
        assertEquals(response.getContentFormat(), "native");
        assertTrue(response.getPersisted());
    }

    @Test
    public void testDeleteContent() {
        api.deleteContent(MODEL_GUID, attachmentId, version, SPACE_GUID, null).block();
    }

    @Test
    public void testDelete() {
        api.delete(MODEL_GUID, version, SPACE_GUID, null).block();
    }

    private void validateSimpleModel(ModelResource model, String description) {
        assertNotNull(model);
        validateSimpleModelEntity(model.getEntity());
        validateSimpleModelMetadata(model.getMetadata(), description);
        validateModelSystem(model.getSystem());
    }

    private void validateSimpleModelEntity(ModelEntity entity) {
        assertNotNull(entity);
        assertNull(entity.getCustom());
        assertNull(entity.getLabelColumn());
        assertNull(entity.getSchemas());
        validateSoftwareSpec(entity.getSoftwareSpec());
        assertNull(entity.getTrainingDataReferences());
        assertEquals(entity.getType(), "scikit-learn_0.23");
    }

    private void validateSimpleModelMetadata(ResourceMeta metadata, String description) {
        assertNotNull(metadata);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getDescription(), description);
        assertEquals(metadata.getId(), MODEL_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getName(), "Test Model");
        assertEquals(metadata.getOwner(), EXSTUSER_GUID);
        assertEquals(metadata.getSpaceId(), SPACE_GUID);
    }

    private void validateSimpleModelRevision(ResourceMeta metadata) {
        assertEquals(metadata.getRev(), "1");
        assertNotNull(metadata.getCommitInfo());
        assertNotNull(metadata.getCommitInfo().getCommittedAt());
        assertEquals(metadata.getCommitInfo().getCommitMessage(), "Testing the creation of a revision via API.");
    }

    private void validateComplexModel(ModelResource model) {
        assertNotNull(model);
        validateModelEntity(model.getEntity());
        validateModelMetadata(model.getMetadata());
        validateModelSystem(model.getSystem());
    }

    private void validateModelEntity(ModelEntity entity) {
        assertNotNull(entity);
        validateCustom(entity.getCustom());
        assertEquals(entity.getLabelColumn(), "RISK");
        validateSchemas(entity.getSchemas());
        validateSoftwareSpec(entity.getSoftwareSpec());
        validateTrainingDataRefs(entity.getTrainingDataReferences());
        assertEquals(entity.getType(), "scikit-learn_0.23");
    }

    private void validateModelMetadata(ResourceMeta metadata) {
        assertNotNull(metadata);
        assertNotNull(metadata.getCreatedAt());
        assertEquals(metadata.getDescription(), "Consumer Credit Risk - XGB");
        assertEquals(metadata.getId(), MODEL_GUID);
        assertNotNull(metadata.getModifiedAt());
        assertEquals(metadata.getName(), "Consumer Credit Risk - XGB");
        assertEquals(metadata.getOwner(), EXSTUSER_GUID);
        assertEquals(metadata.getSpaceId(), SPACE_GUID);
    }

    private void validateModelSystem(SystemDetails system) {
        assertNotNull(system);
        assertNotNull(system.getWarnings());
        assertTrue(system.getWarnings().isEmpty());
    }

    private void validateCustom(Map<String, Object> custom) {
        assertNotNull(custom);
        assertEquals(custom.size(), 3);
        assertEquals(custom.get("feedback"), "credit_risk_feedback.csv");
        assertEquals(custom.get("input_data"), "structured");
        assertEquals(custom.get("problem_type"), "binary");
    }

    private void validateSchemas(FunctionEntitySchemas schemas) {
        assertNotNull(schemas);
        assertNotNull(schemas.getInput());
        assertEquals(schemas.getInput().size(), 1);
        validateSchema(schemas.getInput().get(0));
        assertNotNull(schemas.getOutput());
        assertTrue(schemas.getOutput().isEmpty());
    }

    private void validateSoftwareSpec(SoftwareSpecRel spec) {
        assertNotNull(spec);
        assertEquals(spec.getId(), "e4429883-c883-42b6-87a8-f419d64088cd");
        assertEquals(spec.getName(), "default_py3.7");
    }

    private void validateTrainingDataRefs(List<DataConnectionReference> refs) {
        assertNotNull(refs);
        assertEquals(refs.size(), 1);
        DataConnectionReference one = refs.get(0);
        assertNotNull(one);
        Map<String, Object> connection = one.getConnection();
        assertNotNull(connection);
        assertEquals(connection.size(), 4);
        assertEquals(connection.get("api_key"), "1234567890");
        assertEquals(connection.get("iam_url"), "https://iam.cloud.ibm.com/identity/token");
        assertEquals(connection.get("resource_instance_id"), "crn:v1:bluemix:public:cloud-object-storage:global:a/b11ef9462fd5cd198951947913b3ccff:4e23fcd9-8d9b-4b80-86c7-196e7de4efe8::");
        assertEquals(connection.get("url"), "https://s3.private.us-south.cloud-object-storage.appdomain.cloud");
        assertEquals(one.getId(), "credit_risk_training.csv");
        Map<String, Object> location = one.getLocation();
        assertNotNull(location);
        assertEquals(location.size(), 4);
        assertEquals(location.get("bucket"), "cp4d-samples-output");
        assertEquals(location.get("file_format"), "csv");
        assertEquals(location.get("file_name"), "credit_risk_training.csv");
        assertEquals(location.get("firstlineheader"), "true");
        DataSchema schema = one.getSchema();
        assertNotNull(schema);
        List<DataSchemaField> fields = schema.getFields();
        assertNotNull(fields);
        assertEquals(fields.size(), 20);
        assertEquals(fields.get(0).getName(), "EMPLDUR");
        assertEquals(fields.get(0).getType(), DataSchemaFieldType.OBJECT);
        assertEquals(schema.getId(), "1");
        assertEquals(schema.getType(), "DataFrame");
        assertEquals(one.getType(), DataConnectionType.FS);
    }

    private void validateSchema(DataSchema schema) {
        assertNotNull(schema);
        assertEquals(schema.getId(), "1");
        assertEquals(schema.getType(), "struct");
        List<DataSchemaField> fields = schema.getFields();
        assertNotNull(fields);
        assertEquals(fields.size(), 20);
        validateStringField(fields.get(0), "EMPLDUR", 5, "less_1");
        validateStringField(fields.get(1), "SEX", 2, "female");
        validateNumericField(fields.get(2), "RESIDUR", 1.0, 6.0);
        validateStringField(fields.get(3), "OWNSPROP", 4, "car_other");
        validateNumericField(fields.get(4), "AGE", 18.0, 65.0);
    }

    private void validateStringField(DataSchemaField field, String name, int totalValues, String sampleValue) {
        assertEquals(field.getType(), DataSchemaFieldType.STRING);
        assertEquals(field.getName(), name);
        assertNotNull(field.getMetadata());
        assertEquals(field.getMetadata().getModelingRole(), DataSchemaFieldModelingRole.INPUT);
        if (totalValues > 0) {
            assertNotNull(field.getMetadata().getValues());
            assertEquals(field.getMetadata().getValues().size(), totalValues);
            assertTrue(field.getMetadata().getValues().contains(sampleValue));
        }
    }

    private void validateNumericField(DataSchemaField field, String name, Double min, Double max) {
        assertEquals(field.getType(), DataSchemaFieldType.DOUBLE);
        assertEquals(field.getName(), name);
        assertNotNull(field.getMetadata());
        assertEquals(field.getMetadata().getModelingRole(), DataSchemaFieldModelingRole.INPUT);
        if (min != null && max != null) {
            assertNotNull(field.getMetadata().getRange());
            assertEquals(field.getMetadata().getRange().getMax(), max);
            assertEquals(field.getMetadata().getRange().getMin(), min);
        }
    }

    private void validateDownload(Mono<DataBuffer> stream) {
        assertNotNull(stream);
        Path output = api.saveDownloadAsFile("download.tgz", stream);
        assertNotNull(output);
        File file = output.toFile();
        assertNotNull(file);
        assertTrue(file.exists());
        assertTrue(file.length() > 10000);
        assertTrue(file.delete());
    }

}
