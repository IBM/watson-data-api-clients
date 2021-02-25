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

import com.ibm.watson.data.client.api.AssetFilesApiV2;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.Header;
import org.mockserver.model.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.mockserver.model.HttpResponse.response;
import static org.testng.Assert.*;

/**
 * Test the Project Integration API endpoints.
 */
public class AssetFilesTest extends AbstractExpectations {

    private final AssetFilesApiV2 api = new AssetFilesApiV2(MockConstants.getApiClient());

    public AssetFilesTest() {
        super(AssetFilesApiV2.BASE_API, "assetFiles");
    }

    private final Map<String, List<String>> projectParams = new HashMap<>();
    private final Map<String, List<String>> listParams = new HashMap<>();
    private void setupParams() {
        List<String> project = new ArrayList<>();
        List<String> enabled = new ArrayList<>();
        project.add(PROJECT_GUID);
        enabled.add("true");
        projectParams.put("project_id", project);
        listParams.put("project_id", project);
        listParams.put("flat", enabled);
    }

    private final List<Header> headers = new ArrayList<>();
    private void setupHeaders() {
        headers.add(Header.header("Content-Type", "text/csv"));
        headers.add(Header.header("Content-Length", "93"));
        headers.add(Header.header("ETag", "W/\"5d-1739ee10a26\""));
        headers.add(Header.header("Accept-Ranges", "bytes"));
        headers.add(Header.header("X-Asset-Files-Type", "file"));
        headers.add(Header.header("X-Asset-Files-Size", "93"));
        headers.add(Header.header("Vary", "Accept-Encoding"));
    }

    private static final String path = "data_asset/names.csv";
    private static final String pathEndpoint = "/" + path.replace("/", "%2F");

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupHeaders();
        setupTest(client, "PUT", "", projectParams, "createFolder", 409);
        setupTest(client, "PUT", pathEndpoint, projectParams, "upload", 201);

        setupTest(client, "GET", "", listParams, "list");
        client
                .when(withRequest("HEAD", getBaseUrl() + pathEndpoint, getArea(), "getHeaders").withQueryStringParameters(projectParams))
                .respond(withResponse(getArea(), "getHeaders")
                        .withStatusCode(200)
                        .withHeaders(headers));
        client
                .when(withRequest("GET", getBaseUrl() + pathEndpoint, getArea(), "get").withQueryStringParameters(projectParams))
                .respond(response()
                        .withBody(getResourceFileContents(getArea() + File.separator + "get" + File.separator + "response.csv"))
                        .withStatusCode(200)
                        .withHeaders(headers));
    }

    /*
    @Test
    public void testCreateFolder() {
        // TODO: A project seems to always have a root folder already, so will simply provide a conflict response
        assertThrows(WebClientResponseException.Conflict.class, () -> api.createFolder(null, null, PROJECT_GUID, null, null).block());
    }

    @Test
    public void testUpload() {
        File file = getFileFromResources(getArea() + File.separator + "upload" + File.separator + "names.csv");
        StatusResponse response = api.upload(path, null, null, PROJECT_GUID, null, null, null, null, null, null, file).getBody();
        assertNotNull(response);
        assertEquals(response.getStatus(), "Asset created: The asset was successfully uploaded.");
    }

    @Test
    public void testCopy() {

    }

    @Test
    public void testList() {
        PaginatedAssetFileListResponse response = api.list(null, null, PROJECT_GUID, null, null, null, true, null).block();
        assertNotNull(response);
        assertNotNull(response.getResources());
        assertEquals(response.getResources().size(), 1);
        AssetFileMetadata one = response.getResources().get(0);
        assertEquals(one.getPath(), path);
        assertEquals(one.getEtag(), "W/\"5d-1739ee10a26\"");
        assertEquals(one.getSize(), Integer.valueOf(93));
        assertNotNull(one.getLastModifed());
        assertEquals(one.getType(), "file");
        assertEquals(one.getMimeType(), "text/csv");
    }

    @Test
    public void testGetHeaders() {
        ResponseEntity<Void> response = api.getHeaders(path, null, null, PROJECT_GUID, null, null).block();
        assertNotNull(response);
        HttpHeaders headers = response.getHeaders();
        assertEquals(headers.get("Content-Type").get(0), "text/csv");
        assertEquals(headers.get("Content-Length").get(0), "93");
        assertEquals(headers.get("ETag").get(0), "W/\"5d-1739ee10a26\"");
    }

    @Test
    public void testGetSignedURL() {
        // TODO: unclear how the signing is meant to work, only ever returns a '403' even when an admin, will need to revisit the API
        //String signature = api.getSignedURL(path, 10, null, null, PROJECT_GUID, null, "text/csv", null, true, false, "GET").block();
    }

    @Test
    public void testGet() {
        // TODO: unclear how the retrieval should work, as the following only ever blocks indefinitely
        //String response = api.get(path, null, null, PROJECT_GUID, null, null, null, null, null, null, null, null).block();
        //assertNotNull(response);
        //System.out.println("Response: " + response);
    }

    @Test
    public void testDeflate() {

    }

    @Test
    public void testDeleteSingle() {

    }

    @Test
    public void testDeleteBatch() {

    }

     */

}
