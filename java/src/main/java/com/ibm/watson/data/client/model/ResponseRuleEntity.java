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
import com.ibm.watson.data.client.model.enums.RuleType;
import java.util.Objects;

/**
 * ResponseRuleEntity
 */
public class ResponseRuleEntity extends GlossaryObjectEntity {

    private RuleType ruleType;
    private String defaultLocaleId;
    private PaginatedParentRelationshipsList parentCategory;
    private PaginatedRelationshipsList categories;
    private PaginatedRelationshipsList implementedBy;
    private PaginatedRelationshipsList governsAssets;
    private PaginatedRelationshipsList policies;
    private PaginatedRelationshipsList rules;
    private PaginatedRelationshipsList terms;
    private PaginatedRelationshipsList classifications;
    private PaginatedRelationshipsList referenceData;
    private PaginatedRelationshipsList dataClasses;

    public ResponseRuleEntity ruleType(RuleType ruleType) {
        this.ruleType = ruleType;
        return this;
    }

    /**
     * Currently supported: Governance.
     * @return ruleType
     **/
    @javax.annotation.Nullable
    @JsonProperty("rule_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public RuleType getRuleType() { return ruleType; }
    public void setRuleType(RuleType ruleType) { this.ruleType = ruleType; }

    public ResponseRuleEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public ResponseRuleEntity parentCategory(PaginatedParentRelationshipsList parentCategory) {
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

    public ResponseRuleEntity categories(PaginatedRelationshipsList categories) {
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

    public ResponseRuleEntity implementedBy(PaginatedRelationshipsList implementedBy) {
        this.implementedBy = implementedBy;
        return this;
    }

    /**
     * Get implementedBy
     * @return implementedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("implemented_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getImplementedBy() { return implementedBy; }
    public void setImplementedBy(PaginatedRelationshipsList implementedBy) { this.implementedBy = implementedBy; }

    public ResponseRuleEntity governsAssets(PaginatedRelationshipsList governsAssets) {
        this.governsAssets = governsAssets;
        return this;
    }

    /**
     * Get governsAssets
     * @return governsAssets
     **/
    @javax.annotation.Nullable
    @JsonProperty("governs_assets")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getGovernsAssets() { return governsAssets; }
    public void setGovernsAssets(PaginatedRelationshipsList governsAssets) { this.governsAssets = governsAssets; }

    public ResponseRuleEntity policies(PaginatedRelationshipsList policies) {
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

    public ResponseRuleEntity rules(PaginatedRelationshipsList rules) {
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

    public ResponseRuleEntity terms(PaginatedRelationshipsList terms) {
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

    public ResponseRuleEntity classifications(PaginatedRelationshipsList classifications) {
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

    public ResponseRuleEntity referenceData(PaginatedRelationshipsList referenceData) {
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

    public ResponseRuleEntity dataClasses(PaginatedRelationshipsList dataClasses) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResponseRuleEntity responseRuleEntity = (ResponseRuleEntity)o;
        return super.equals(o) &&
                Objects.equals(this.ruleType, responseRuleEntity.ruleType) &&
                Objects.equals(this.defaultLocaleId, responseRuleEntity.defaultLocaleId) &&
                Objects.equals(this.parentCategory, responseRuleEntity.parentCategory) &&
                Objects.equals(this.categories, responseRuleEntity.categories) &&
                Objects.equals(this.implementedBy, responseRuleEntity.implementedBy) &&
                Objects.equals(this.governsAssets, responseRuleEntity.governsAssets) &&
                Objects.equals(this.policies, responseRuleEntity.policies) &&
                Objects.equals(this.rules, responseRuleEntity.rules) &&
                Objects.equals(this.terms, responseRuleEntity.terms) &&
                Objects.equals(this.classifications, responseRuleEntity.classifications) &&
                Objects.equals(this.referenceData, responseRuleEntity.referenceData) &&
                Objects.equals(this.dataClasses, responseRuleEntity.dataClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ruleType, defaultLocaleId,
                parentCategory, categories, implementedBy,
                governsAssets, policies, rules, terms, classifications,
                referenceData, dataClasses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseRuleEntity {\n");
        super.toString(sb);
        sb.append("    ruleType: ").append(toIndentedString(ruleType)).append("\n");
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    implementedBy: ").append(toIndentedString(implementedBy)).append("\n");
        sb.append("    governsAssets: ").append(toIndentedString(governsAssets)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
