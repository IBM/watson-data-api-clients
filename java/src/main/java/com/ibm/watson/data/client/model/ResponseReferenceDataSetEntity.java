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
import java.util.Objects;

/**
 * ResponseReferenceDataSetEntity
 */
public class ResponseReferenceDataSetEntity extends GlossaryObjectEntity {

    private String defaultLocaleId;
    private List<String> stewardIds = null;
    private Long rdsValuesTotalCounts;
    private String type;
    private PaginatedRelationshipsList terms;
    private PaginatedRelationshipsList classifications;
    private PaginatedParentRelationshipsList parentCategory;
    private PaginatedRelationshipsList categories;
    private PaginatedRelationshipsList dataClasses;
    private PaginatedRelationshipsList rules;
    private PaginatedReferenceDataValueEntityList rdsValues;
    private RDVImportInfo importInfo;

    public ResponseReferenceDataSetEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public ResponseReferenceDataSetEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public ResponseReferenceDataSetEntity addStewardIdsItem(String stewardIdsItem) {
        if (this.stewardIds == null) {
            this.stewardIds = new ArrayList<>();
        }
        this.stewardIds.add(stewardIdsItem);
        return this;
    }

    /**
     * Get stewardIds
     * @return stewardIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("steward_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getStewardIds() { return stewardIds; }
    public void setStewardIds(List<String> stewardIds) { this.stewardIds = stewardIds; }

    public ResponseReferenceDataSetEntity rdsValuesTotalCounts(Long rdsValuesTotalCounts) {
        this.rdsValuesTotalCounts = rdsValuesTotalCounts;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("rds_values_total_counts")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRdsValuesTotalCounts() { return rdsValuesTotalCounts; }
    public void setRdsValuesTotalCounts(Long rdsValuesTotalCounts) { this.rdsValuesTotalCounts = rdsValuesTotalCounts; }

    public ResponseReferenceDataSetEntity type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public ResponseReferenceDataSetEntity terms(PaginatedRelationshipsList terms) {
        this.terms = terms;
        return this;
    }

    /**
     * Get terms
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getTerms() { return terms; }
    public void setTerms(PaginatedRelationshipsList terms) { this.terms = terms; }

    public ResponseReferenceDataSetEntity classifications(PaginatedRelationshipsList classifications) {
        this.classifications = classifications;
        return this;
    }

    /**
     * Get classifications
     * @return classifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getClassifications() { return classifications; }
    public void setClassifications(PaginatedRelationshipsList classifications) { this.classifications = classifications; }

    public ResponseReferenceDataSetEntity parentCategory(PaginatedParentRelationshipsList parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    /**
     * Get parentCategory
     * @return parentCategory
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedParentRelationshipsList getParentCategory() { return parentCategory; }
    public void setParentCategory(PaginatedParentRelationshipsList parentCategory) { this.parentCategory = parentCategory; }

    public ResponseReferenceDataSetEntity categories(PaginatedRelationshipsList categories) {
        this.categories = categories;
        return this;
    }

    /**
     * Get categories
     * @return categories
     **/
    @javax.annotation.Nullable
    @JsonProperty("categories")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getCategories() { return categories; }
    public void setCategories(PaginatedRelationshipsList categories) { this.categories = categories; }

    public ResponseReferenceDataSetEntity dataClasses(PaginatedRelationshipsList dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    /**
     * Get dataClasses
     * @return dataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getDataClasses() { return dataClasses; }
    public void setDataClasses(PaginatedRelationshipsList dataClasses) { this.dataClasses = dataClasses; }

    public ResponseReferenceDataSetEntity rules(PaginatedRelationshipsList rules) {
        this.rules = rules;
        return this;
    }

    /**
     * Get rules
     * @return rules
     **/
    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getRules() { return rules; }
    public void setRules(PaginatedRelationshipsList rules) { this.rules = rules; }

    public ResponseReferenceDataSetEntity rdsValues(PaginatedReferenceDataValueEntityList rdsValues) {
        this.rdsValues = rdsValues;
        return this;
    }

    /**
     * Get rdsValues
     * @return rdsValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("rds_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedReferenceDataValueEntityList getRdsValues() { return rdsValues; }
    public void setRdsValues(PaginatedReferenceDataValueEntityList rdsValues) { this.rdsValues = rdsValues; }

    public ResponseReferenceDataSetEntity importInfo(RDVImportInfo importInfo) {
        this.importInfo = importInfo;
        return this;
    }

    /**
     * Get importInfo
     * @return importInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public RDVImportInfo getImportInfo() { return importInfo; }
    public void setImportInfo(RDVImportInfo importInfo) { this.importInfo = importInfo; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResponseReferenceDataSetEntity responseReferenceDataSetEntity = (ResponseReferenceDataSetEntity)o;
        return super.equals(o) &&
                Objects.equals(this.defaultLocaleId, responseReferenceDataSetEntity.defaultLocaleId) &&
                Objects.equals(this.stewardIds, responseReferenceDataSetEntity.stewardIds) &&
                Objects.equals(this.rdsValuesTotalCounts, responseReferenceDataSetEntity.rdsValuesTotalCounts) &&
                Objects.equals(this.type, responseReferenceDataSetEntity.type) &&
                Objects.equals(this.terms, responseReferenceDataSetEntity.terms) &&
                Objects.equals(this.classifications, responseReferenceDataSetEntity.classifications) &&
                Objects.equals(this.parentCategory, responseReferenceDataSetEntity.parentCategory) &&
                Objects.equals(this.categories, responseReferenceDataSetEntity.categories) &&
                Objects.equals(this.dataClasses, responseReferenceDataSetEntity.dataClasses) &&
                Objects.equals(this.rules, responseReferenceDataSetEntity.rules) &&
                Objects.equals(this.rdsValues, responseReferenceDataSetEntity.rdsValues) &&
                Objects.equals(this.importInfo, responseReferenceDataSetEntity.importInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defaultLocaleId, stewardIds,
                rdsValuesTotalCounts, type, terms,
                classifications, parentCategory, categories,
                dataClasses, rules, rdsValues, importInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseReferenceDataSetEntity {\n");
        super.toString(sb);
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    rdsValuesTotalCounts: ").append(toIndentedString(rdsValuesTotalCounts)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    rdsValues: ").append(toIndentedString(rdsValues)).append("\n");
        sb.append("    importInfo: ").append(toIndentedString(importInfo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
