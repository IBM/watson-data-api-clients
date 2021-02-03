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
package com.ibm.watson.data.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * SearchResultRow
 */
public class SearchResultRow {

    private String providerTypeId;
    private String tenantId;
    private Long lastUpdatedAt;
    private String artifactId;
    private Double score;
    private SearchResultCategories categories;
    private List<CustomAttribute> customAttributes = null;
    private SearchResultMetadata metadata;
    private Map<String, AbstractSearchResultEntity> entity;

    public SearchResultRow providerTypeId(String providerTypeId) {
        this.providerTypeId = providerTypeId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("provider_type_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProviderTypeId() { return providerTypeId; }
    public void setProviderTypeId(String providerTypeId) { this.providerTypeId = providerTypeId; }

    public SearchResultRow tenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("tenant_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }

    public SearchResultRow lastUpdatedAt(Long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("last_updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Long lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }

    public SearchResultRow artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public SearchResultRow score(Double score) {
        this.score = score;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("_score")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public SearchResultRow categories(SearchResultCategories categories) {
        this.categories = categories;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("categories")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SearchResultCategories getCategories() { return categories; }
    public void setCategories(SearchResultCategories categories) { this.categories = categories; }

    public SearchResultRow customAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public SearchResultRow addCustomAttributesItem(CustomAttribute customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new ArrayList<>();
        }
        this.customAttributes.add(customAttributesItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("custom_attributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttribute> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(List<CustomAttribute> customAttributes) { this.customAttributes = customAttributes; }

    public SearchResultRow metadata(SearchResultMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SearchResultMetadata getMetadata() { return metadata; }
    public void setMetadata(SearchResultMetadata metadata) { this.metadata = metadata; }

    public SearchResultRow entity(Map<String, AbstractSearchResultEntity> entity) {
        this.entity = entity;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, AbstractSearchResultEntity> getEntity() { return entity; }
    public void setEntity(Map<String, AbstractSearchResultEntity> entity) { this.entity = entity; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SearchResultRow that = (SearchResultRow)o;
        return Objects.equals(this.providerTypeId, that.providerTypeId) &&
                Objects.equals(this.tenantId, that.tenantId) &&
                Objects.equals(this.lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(this.artifactId, that.artifactId) &&
                Objects.equals(this.score, that.score) &&
                Objects.equals(this.categories, that.categories) &&
                Objects.equals(this.customAttributes, that.customAttributes) &&
                Objects.equals(this.metadata, that.metadata) &&
                Objects.equals(this.entity, that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerTypeId, tenantId, lastUpdatedAt, artifactId,
                score, categories, customAttributes, metadata, entity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchResultRow {\n");
        sb.append("    providerTypeId: ").append(toIndentedString(providerTypeId)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    lastUpdatedAt: ").append(toIndentedString(lastUpdatedAt)).append("\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    score: ").append(toIndentedString(score)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
