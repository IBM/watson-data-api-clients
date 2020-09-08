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

import java.util.Objects;

/**
 * ResponseDataClassEntity
 */
public class ResponseDataClassEntity extends DataClassEntity {

    private String providerType;
    private String definition;
    private Boolean parentEnabled;
    private String defaultLocaleId;
    private PaginatedParentRelationshipsList isATypeOfDataClass;
    private PaginatedParentRelationshipsList parentCategory;
    private PaginatedRelationshipsList hasTypesDataClasses;
    private PaginatedRelationshipsList categories;
    private PaginatedRelationshipsList terms;
    private PaginatedRelationshipsList classifications;
    private PaginatedRelationshipsList referenceData;
    private PaginatedRelationshipsList policies;
    private PaginatedRelationshipsList rules;

    public ResponseDataClassEntity providerType(String providerType) {
        this.providerType = providerType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("provider_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProviderType() { return providerType; }
    public void setProviderType(String providerType) { this.providerType = providerType; }

    public ResponseDataClassEntity definition(String definition) {
        this.definition = definition;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("definition")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }

    public ResponseDataClassEntity parentEnabled(Boolean parentEnabled) {
        this.parentEnabled = parentEnabled;
        return this;
    }

    /**
     * This is derived flag; if any of the parent in the data class hierarchy is
     * disabled, it is &#39;false&#39;. Otherwise, it is &#39;true&#39;
     * @return parentEnabled
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_enabled")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getParentEnabled() { return parentEnabled; }
    public void setParentEnabled(Boolean parentEnabled) { this.parentEnabled = parentEnabled; }

    public ResponseDataClassEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public ResponseDataClassEntity isATypeOfDataClass(PaginatedParentRelationshipsList isATypeOfDataClass) {
        this.isATypeOfDataClass = isATypeOfDataClass;
        return this;
    }

    /**
     * Get isATypeOfDataClass
     * @return isATypeOfDataClass
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_a_type_of_data_class")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedParentRelationshipsList getIsATypeOfDataClass() { return isATypeOfDataClass; }
    public void setIsATypeOfDataClass(PaginatedParentRelationshipsList isATypeOfDataClass) { this.isATypeOfDataClass = isATypeOfDataClass; }

    public ResponseDataClassEntity parentCategory(PaginatedParentRelationshipsList parentCategory) {
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

    public ResponseDataClassEntity hasTypesDataClasses(PaginatedRelationshipsList hasTypesDataClasses) {
        this.hasTypesDataClasses = hasTypesDataClasses;
        return this;
    }

    /**
     * Get hasTypesDataClasses
     * @return hasTypesDataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getHasTypesDataClasses() { return hasTypesDataClasses; }
    public void setHasTypesDataClasses(PaginatedRelationshipsList hasTypesDataClasses) { this.hasTypesDataClasses = hasTypesDataClasses; }

    public ResponseDataClassEntity categories(PaginatedRelationshipsList categories) {
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

    public ResponseDataClassEntity terms(PaginatedRelationshipsList terms) {
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

    public ResponseDataClassEntity classifications(PaginatedRelationshipsList classifications) {
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

    public ResponseDataClassEntity referenceData(PaginatedRelationshipsList referenceData) {
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

    public ResponseDataClassEntity policies(PaginatedRelationshipsList policies) {
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

    public ResponseDataClassEntity rules(PaginatedRelationshipsList rules) {
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
        ResponseDataClassEntity responseDataClassEntity = (ResponseDataClassEntity)o;
        return super.equals(o) &&
                Objects.equals(this.providerType, responseDataClassEntity.providerType) &&
                Objects.equals(this.definition, responseDataClassEntity.definition) &&
                Objects.equals(this.parentEnabled, responseDataClassEntity.parentEnabled) &&
                Objects.equals(this.defaultLocaleId, responseDataClassEntity.defaultLocaleId) &&
                Objects.equals(this.isATypeOfDataClass, responseDataClassEntity.isATypeOfDataClass) &&
                Objects.equals(this.parentCategory, responseDataClassEntity.parentCategory) &&
                Objects.equals(this.hasTypesDataClasses, responseDataClassEntity.hasTypesDataClasses) &&
                Objects.equals(this.categories, responseDataClassEntity.categories) &&
                Objects.equals(this.terms, responseDataClassEntity.terms) &&
                Objects.equals(this.classifications, responseDataClassEntity.classifications) &&
                Objects.equals(this.referenceData, responseDataClassEntity.referenceData) &&
                Objects.equals(this.policies, responseDataClassEntity.policies) &&
                Objects.equals(this.rules, responseDataClassEntity.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                providerType, definition, parentEnabled, defaultLocaleId, isATypeOfDataClass,
                parentCategory, hasTypesDataClasses, categories, terms, classifications,
                referenceData, policies, rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseDataClassEntity {\n");
        super.toString(sb);
        sb.append("    providerType: ").append(toIndentedString(providerType)).append("\n");
        sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
        sb.append("    parentEnabled: ").append(toIndentedString(parentEnabled)).append("\n");
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    isATypeOfDataClass: ").append(toIndentedString(isATypeOfDataClass)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    hasTypesDataClasses: ").append(toIndentedString(hasTypesDataClasses)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
