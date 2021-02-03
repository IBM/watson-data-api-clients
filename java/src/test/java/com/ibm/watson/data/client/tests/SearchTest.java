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

import com.ibm.watson.data.client.api.SearchApiV3;
import com.ibm.watson.data.client.mocks.AbstractExpectations;
import com.ibm.watson.data.client.mocks.MockConstants;
import com.ibm.watson.data.client.model.*;
import org.junit.Test;
import org.mockserver.client.MockServerClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ibm.watson.data.client.mocks.MockConstants.*;
import static org.testng.Assert.*;

/**
 * Test the Search API endpoints.
 */
public class SearchTest extends AbstractExpectations {

    private final SearchApiV3 api = new SearchApiV3(MockConstants.getApiClient());

    public SearchTest() {
        super(SearchApiV3.BASE_API, "search");
    }

    private static final String queryString = "metadata.artifact_type:policy";

    private final Map<String, List<String>> queryParams = new HashMap<>();
    private void setupParams() {
        List<String> query = new ArrayList<>();
        query.add(queryString);
        queryParams.put("query", query);
    }

    @Override
    public void init(MockServerClient client) {
        setupParams();
        setupTest(client, "POST", "", "search");
        setupTest(client, "GET", "", queryParams, "simpleSearch");
    }

    @Test
    public void testSimpleSearch() {
        SearchResults response = api.simpleSearch(queryString, null, null).block();
        validateSearchResults(response);
    }

    @Test
    public void testSearch() {
        InputStream json = getInputStreamFromResources(getArea() + File.separator + "search" + File.separator + "request.json");
        assertNotNull(json);
        String body = new BufferedReader(new InputStreamReader(json, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
        SearchResults response = api.search(body).block();
        validateSearchResults(response);
    }

    private void validateSearchResults(SearchResults results) {
        assertNotNull(results);
        assertEquals(results.getSize(), Long.valueOf(1L));
        assertNotNull(results.getRows());
        assertEquals(results.getRows().size(), 1);
        SearchResultRow one = results.getRows().get(0);
        assertNotNull(one);
        assertEquals(one.getProviderTypeId(), "glossary");
        assertEquals(one.getTenantId(), "999");
        assertEquals(one.getLastUpdatedAt(), Long.valueOf(1603205776108L));
        assertNotNull(one.getCategories());
        SearchResultCategories cats = one.getCategories();
        assertNotNull(cats.getSecondaryCategoryIds());
        assertEquals(cats.getSecondaryCategoryIds().size(), 0);
        assertEquals(cats.getLastUpdatedAt(), Long.valueOf(1603205776100L));
        assertNotNull(cats.getSecondaryCategoryGlobalIds());
        assertEquals(cats.getSecondaryCategoryGlobalIds().size(), 0);
        assertEquals(cats.getPrimaryCategoryGlobalId(), REPOSITORY_ID + "_" + UNCATEGORY_ID);
        assertEquals(cats.getPrimaryCategoryId(), UNCATEGORY_ID);
        assertEquals(cats.getPrimaryCategoryName(), "[uncategorized]");
        assertNotNull(cats.getSecondaryCategoryNames());
        assertEquals(cats.getSecondaryCategoryNames().size(), 0);
        assertEquals(one.getArtifactId(), NEW_POLICY_GUID);
        assertNotNull(one.getCustomAttributes());
        assertEquals(one.getCustomAttributes().size(), 0);
        assertEquals(one.getScore(), Double.valueOf(7.5404444));
        validateSearchResultMetadata(one.getMetadata());
        Map<String, AbstractSearchResultEntity> entityMap = one.getEntity();
        assertNotNull(entityMap);
        assertEquals(entityMap.size(), 1);
        assertTrue(entityMap.containsKey("artifacts"));
        validateSearchResultEntity(entityMap.get("artifacts"));
        assertNotNull(results.getAggregations());
    }

    private void validateSearchResultMetadata(SearchResultMetadata metadata) {
        assertNotNull(metadata);
        assertNotNull(metadata.getModifiedOn());
        assertEquals(metadata.getArtifactType(), "policy");
        assertEquals(metadata.getName(), "Test Policy");
        assertEquals(metadata.getModifiedBy(), EXSTUSER_GUID);
        assertEquals(metadata.getDescription(), "Now with a long description.");
        assertEquals(metadata.getState(), "PUBLISHED");
        assertNotNull(metadata.getStewardIds());
        assertTrue(metadata.getStewardIds().isEmpty());
        assertNotNull(metadata.getTags());
        assertTrue(metadata.getTags().isEmpty());
    }

    private void validateSearchResultEntity(AbstractSearchResultEntity entity) {
        assertNotNull(entity);
        assertTrue(entity instanceof ArtifactSearchResultEntity);
        ArtifactSearchResultEntity asre = (ArtifactSearchResultEntity) entity;
        assertEquals(asre.getGlobalId(), REPOSITORY_ID + "_" + NEW_POLICY_GUID);
        assertNotNull(asre.getEffectiveStartDate());
        assertEquals(asre.getVersionId(), "3d297087-3e85-4fb9-bc54-2677a9313884_0");
        assertEquals(asre.getArtifactId(), NEW_POLICY_GUID);
    }

}
