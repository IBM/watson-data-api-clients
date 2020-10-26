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
 * ResponsePolicyEntity
 */
public class ResponsePolicyEntity extends GlossaryObjectEntity {

    private String defaultLocaleId;
    private List<String> stewardIds = null;
    private RelationshipParentRelationshipEntity parentPolicy;
    private PaginatedRelationshipsList subPolicies;
    private PaginatedRelationshipsList categories;
    private PaginatedRelationshipsList terms;
    private PaginatedRelationshipsList classifications;
    private PaginatedRelationshipsList rules;
    private RelationshipParentRelationshipEntity parentCategory;
    private PaginatedParentRelationshipsList retParentCategoryRelationship;
    private PaginatedRelationshipsList dataProtectionRules;

    public ResponsePolicyEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public ResponsePolicyEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public ResponsePolicyEntity addStewardIdsItem(String stewardIdsItem) {
        if (this.stewardIds == null) {
            this.stewardIds = new ArrayList<>();
        }
        this.stewardIds.add(stewardIdsItem);
        return this;
    }

    /**
     * The stewards assigned to an artifact.
     * @return stewardIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("steward_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getStewardIds() { return stewardIds; }
    public void setStewardIds(List<String> stewardIds) { this.stewardIds = stewardIds; }

    public ResponsePolicyEntity parentPolicy(RelationshipParentRelationshipEntity parentPolicy) {
        this.parentPolicy = parentPolicy;
        return this;
    }

    /**
     * Get parentPolicy
     * @return parentPolicy
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_policy")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public RelationshipParentRelationshipEntity getParentPolicy() { return parentPolicy; }
    public void setParentPolicy(RelationshipParentRelationshipEntity parentPolicy) { this.parentPolicy = parentPolicy; }

    public ResponsePolicyEntity subPolicies(PaginatedRelationshipsList subPolicies) {
        this.subPolicies = subPolicies;
        return this;
    }

    /**
     * Get subPolicies
     * @return subPolicies
     **/
    @javax.annotation.Nullable
    @JsonProperty("sub_policies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getSubPolicies() { return subPolicies; }
    public void setSubPolicies(PaginatedRelationshipsList subPolicies) { this.subPolicies = subPolicies; }

    public ResponsePolicyEntity categories(PaginatedRelationshipsList categories) {
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

    public ResponsePolicyEntity terms(PaginatedRelationshipsList terms) {
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

    public ResponsePolicyEntity classifications(PaginatedRelationshipsList classifications) {
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

    public ResponsePolicyEntity rules(PaginatedRelationshipsList rules) {
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

    public ResponsePolicyEntity parentCategory(RelationshipParentRelationshipEntity parentCategory) {
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
    public RelationshipParentRelationshipEntity getParentCategory() { return parentCategory; }
    public void setParentCategory(RelationshipParentRelationshipEntity parentCategory) { this.parentCategory = parentCategory; }

    public ResponsePolicyEntity retParentCategoryRelationship(PaginatedParentRelationshipsList retParentCategoryRelationship) {
        this.retParentCategoryRelationship = retParentCategoryRelationship;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("ret_parent_category_relationship")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedParentRelationshipsList getRetParentCategoryRelationship() { return retParentCategoryRelationship; }
    public void setRetParentCategoryRelationship(PaginatedParentRelationshipsList retParentCategoryRelationship) { this.retParentCategoryRelationship = retParentCategoryRelationship; }

    public ResponsePolicyEntity dataProtectionRules(PaginatedRelationshipsList dataProtectionRules) {
        this.dataProtectionRules = dataProtectionRules;
        return this;
    }

    /**
     * Get dataProtectionRules
     * @return dataProtectionRules
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_protection_rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getDataProtectionRules() { return dataProtectionRules; }
    public void setDataProtectionRules(PaginatedRelationshipsList dataProtectionRules) { this.dataProtectionRules = dataProtectionRules; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResponsePolicyEntity responsePolicyEntity = (ResponsePolicyEntity)o;
        return super.equals(o) &&
                Objects.equals(this.defaultLocaleId, responsePolicyEntity.defaultLocaleId) &&
                Objects.equals(this.stewardIds, responsePolicyEntity.stewardIds) &&
                Objects.equals(this.parentPolicy, responsePolicyEntity.parentPolicy) &&
                Objects.equals(this.subPolicies, responsePolicyEntity.subPolicies) &&
                Objects.equals(this.categories, responsePolicyEntity.categories) &&
                Objects.equals(this.terms, responsePolicyEntity.terms) &&
                Objects.equals(this.classifications, responsePolicyEntity.classifications) &&
                Objects.equals(this.rules, responsePolicyEntity.rules) &&
                Objects.equals(this.parentCategory, responsePolicyEntity.parentCategory) &&
                Objects.equals(this.retParentCategoryRelationship, responsePolicyEntity.retParentCategoryRelationship) &&
                Objects.equals(this.dataProtectionRules, responsePolicyEntity.dataProtectionRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defaultLocaleId, stewardIds,
                parentPolicy, subPolicies, categories, terms,
                classifications, rules, parentCategory, retParentCategoryRelationship,
                dataProtectionRules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponsePolicyEntity {\n");
        super.toString(sb);
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    parentPolicy: ").append(toIndentedString(parentPolicy)).append("\n");
        sb.append("    subPolicies: ").append(toIndentedString(subPolicies)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    retParentCategoryRelationship: ").append(toIndentedString(retParentCategoryRelationship)).append("\n");
        sb.append("    dataProtectionRules: ").append(toIndentedString(dataProtectionRules)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
