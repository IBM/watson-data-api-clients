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
public class V3DiscreteRuleColumnMetadataEntity {

    private String columnName;
    private List<String> businessTerms = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private List<String> dataClasses = new ArrayList<>();
    private List<String> classifications;

    /**
     * column name that was targeted by the discrete rule
     * @return columnName
     **/
    @javax.annotation.Nonnull
    @JsonProperty("column_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public V3DiscreteRuleColumnMetadataEntity businessTerms(List<String> businessTerms) {
        this.businessTerms = businessTerms;
        return this;
    }

    public V3DiscreteRuleColumnMetadataEntity addBusinessTermsItem(String businessTermsItem) {
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

    public V3DiscreteRuleColumnMetadataEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public V3DiscreteRuleColumnMetadataEntity addTagsItem(String tagsItem) {
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

    public V3DiscreteRuleColumnMetadataEntity dataClasses(List<String> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public V3DiscreteRuleColumnMetadataEntity addDataClassesItem(String dataClassesItem) {
        this.dataClasses.add(dataClassesItem);
        return this;
    }

    /**
     * data classes metadata
     * @return dataClasses
     **/
    @javax.annotation.Nonnull
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getDataClasses() {
        return dataClasses;
    }
    public void setDataClasses(List<String> dataClasses) {
        this.dataClasses = dataClasses;
    }

    public V3DiscreteRuleColumnMetadataEntity classifications(List<String> classifications) {
        this.classifications = classifications;
        return this;
    }

    public V3DiscreteRuleColumnMetadataEntity addClassificationsItem(String classificationsItem) {
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * classifications metadata
     * @return classifications
     **/
    @javax.annotation.Nonnull
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getClassifications() {
        return classifications;
    }
    public void setClassifications(List<String> classifications) {
        this.classifications = classifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3DiscreteRuleColumnMetadataEntity v3DiscreteRuleColumnMetadataEntity = (V3DiscreteRuleColumnMetadataEntity) o;
        return Objects.equals(this.columnName, v3DiscreteRuleColumnMetadataEntity.columnName) &&
                Objects.equals(this.businessTerms, v3DiscreteRuleColumnMetadataEntity.businessTerms) &&
                Objects.equals(this.tags, v3DiscreteRuleColumnMetadataEntity.tags) &&
                Objects.equals(this.dataClasses, v3DiscreteRuleColumnMetadataEntity.dataClasses) &&
                Objects.equals(this.classifications, v3DiscreteRuleColumnMetadataEntity.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnName, businessTerms, tags, dataClasses, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3DiscreteRuleColumnMetadataEntity {\n");
        sb.append("    columnName: ").append(toIndentedString(columnName)).append("\n");
        sb.append("    businessTerms: ").append(toIndentedString(businessTerms)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
        sb.append("    classification: ").append(toIndentedString(classifications)).append("\n");
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
