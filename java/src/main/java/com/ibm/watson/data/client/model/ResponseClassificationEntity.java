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
 * ResponseClassificationEntity
 */
public class ResponseClassificationEntity extends GlossaryObjectEntity {

    private String defaultLocaleId;
    private List<String> tags = null;
    private PaginatedParentRelationshipsList parentCategory;
    private PaginatedRelationshipsList categories;
    private PaginatedParentRelationshipsList isATypeOfClassification;
    private PaginatedRelationshipsList hasTypesClassifications;
    private PaginatedRelationshipsList terms;
    private PaginatedRelationshipsList dataClasses;
    private PaginatedRelationshipsList referenceData;
    private PaginatedRelationshipsList policies;
    private PaginatedRelationshipsList rules;

    public ResponseClassificationEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public ResponseClassificationEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ResponseClassificationEntity addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * The tags assigned to an artifact.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public ResponseClassificationEntity parentCategory(PaginatedParentRelationshipsList parentCategory) {
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

    public ResponseClassificationEntity categories(PaginatedRelationshipsList categories) {
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

    public ResponseClassificationEntity isATypeOfClassification(PaginatedParentRelationshipsList isATypeOfClassification) {
        this.isATypeOfClassification = isATypeOfClassification;
        return this;
    }

    /**
     * Get isATypeOfClassification
     * @return isATypeOfClassification
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_a_type_of_classification")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedParentRelationshipsList getIsATypeOfClassification() { return isATypeOfClassification; }
    public void setIsATypeOfClassification(PaginatedParentRelationshipsList isATypeOfClassification) { this.isATypeOfClassification = isATypeOfClassification; }

    public ResponseClassificationEntity hasTypesClassifications(PaginatedRelationshipsList hasTypesClassifications) {
        this.hasTypesClassifications = hasTypesClassifications;
        return this;
    }

    /**
     * Get hasTypesClassifications
     * @return hasTypesClassifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getHasTypesClassifications() { return hasTypesClassifications; }
    public void setHasTypesClassifications(PaginatedRelationshipsList hasTypesClassifications) { this.hasTypesClassifications = hasTypesClassifications; }

    public ResponseClassificationEntity terms(PaginatedRelationshipsList terms) {
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

    public ResponseClassificationEntity dataClasses(PaginatedRelationshipsList dataClasses) {
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

    public ResponseClassificationEntity referenceData(PaginatedRelationshipsList referenceData) {
        this.referenceData = referenceData;
        return this;
    }

    /**
     * Get referenceData
     * @return referenceData
     **/
    @javax.annotation.Nullable
    @JsonProperty("reference_data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getReferenceData() { return referenceData; }
    public void setReferenceData(PaginatedRelationshipsList referenceData) { this.referenceData = referenceData; }

    public ResponseClassificationEntity policies(PaginatedRelationshipsList policies) {
        this.policies = policies;
        return this;
    }

    /**
     * Get policies
     * @return policies
     **/
    @javax.annotation.Nullable
    @JsonProperty("policies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getPolicies() { return policies; }
    public void setPolicies(PaginatedRelationshipsList policies) { this.policies = policies; }

    public ResponseClassificationEntity rules(PaginatedRelationshipsList rules) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResponseClassificationEntity responseClassificationEntity = (ResponseClassificationEntity)o;
        return super.equals(o) &&
                Objects.equals(this.defaultLocaleId, responseClassificationEntity.defaultLocaleId) &&
                Objects.equals(this.tags, responseClassificationEntity.tags) &&
                Objects.equals(this.parentCategory, responseClassificationEntity.parentCategory) &&
                Objects.equals(this.categories, responseClassificationEntity.categories) &&
                Objects.equals(this.isATypeOfClassification, responseClassificationEntity.isATypeOfClassification) &&
                Objects.equals(this.hasTypesClassifications, responseClassificationEntity.hasTypesClassifications) &&
                Objects.equals(this.terms, responseClassificationEntity.terms) &&
                Objects.equals(this.dataClasses, responseClassificationEntity.dataClasses) &&
                Objects.equals(this.referenceData, responseClassificationEntity.referenceData) &&
                Objects.equals(this.policies, responseClassificationEntity.policies) &&
                Objects.equals(this.rules, responseClassificationEntity.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defaultLocaleId, tags,
                parentCategory, categories, isATypeOfClassification,
                hasTypesClassifications, terms, dataClasses,
                referenceData, policies, rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseClassificationEntity {\n");
        super.toString(sb);
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    isATypeOfClassification: ").append(toIndentedString(isATypeOfClassification)).append("\n");
        sb.append("    hasTypesClassifications: ").append(toIndentedString(hasTypesClassifications)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
