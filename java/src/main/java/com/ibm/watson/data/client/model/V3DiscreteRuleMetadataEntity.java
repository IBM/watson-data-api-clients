/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * entity object within the response for the /v3/enforcement/governed_items/discrete/{governanceTypeName}/{itemId} API
 */
public class V3DiscreteRuleMetadataEntity {

    private List<String> businessTerms = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private List<String> classifications = new ArrayList<>();
    private List<V3DiscreteRuleColumnMetadataEntity> columns = new ArrayList<>();

    public V3DiscreteRuleMetadataEntity businessTerms(List<String> businessTerms) {
        this.businessTerms = businessTerms;
        return this;
    }

    public V3DiscreteRuleMetadataEntity addBusinessTermsItem(String businessTermsItem) {
        this.businessTerms.add(businessTermsItem);
        return this;
    }

    /**
     * business terms metadata
     * @return businessTerms
     **/
    @javax.annotation.Nonnull
    @JsonProperty("business_terms")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getBusinessTerms() {
        return businessTerms;
    }
    public void setBusinessTerms(List<String> businessTerms) {
        this.businessTerms = businessTerms;
    }

    public V3DiscreteRuleMetadataEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public V3DiscreteRuleMetadataEntity addTagsItem(String tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * tags metadata
     * @return tags
     **/
    @javax.annotation.Nonnull
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public V3DiscreteRuleMetadataEntity classifications(List<String> classifications) {
        this.classifications = classifications;
        return this;
    }

    public V3DiscreteRuleMetadataEntity addClassificationsItem(String classificationsItem) {
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * classifications metadata
     * @return classifications
     **/
    @javax.annotation.Nonnull
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getClassifications() {
        return classifications;
    }
    public void setClassifications(List<String> classifications) {
        this.classifications = classifications;
    }

    public V3DiscreteRuleMetadataEntity columns(List<V3DiscreteRuleColumnMetadataEntity> columns) {
        this.columns = columns;
        return this;
    }

    public V3DiscreteRuleMetadataEntity addColumnsItem(V3DiscreteRuleColumnMetadataEntity columnsItem) {
        this.columns.add(columnsItem);
        return this;
    }

    /**
     * columns metadata
     * @return columns
     **/
    @javax.annotation.Nonnull
    @JsonProperty("columns")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<V3DiscreteRuleColumnMetadataEntity> getColumns() {
        return columns;
    }
    public void setColumns(List<V3DiscreteRuleColumnMetadataEntity> columns) {
        this.columns = columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3DiscreteRuleMetadataEntity v3DiscreteRuleMetadataEntity = (V3DiscreteRuleMetadataEntity) o;
        return Objects.equals(this.businessTerms, v3DiscreteRuleMetadataEntity.businessTerms) &&
                Objects.equals(this.tags, v3DiscreteRuleMetadataEntity.tags) &&
                Objects.equals(this.classifications, v3DiscreteRuleMetadataEntity.classifications) &&
                Objects.equals(this.columns, v3DiscreteRuleMetadataEntity.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessTerms, tags, classifications, columns);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3DiscreteRuleMetadataEntity {\n");
        sb.append("    businessTerms: ").append(toIndentedString(businessTerms)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    columns: ").append(toIndentedString(columns)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
