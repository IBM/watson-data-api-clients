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
 * RuleRelationshipsRequest
 */
public class RuleRelationshipsRequest {

    private NewRelationship parentCategory;
    private List<NewRelationship> categories = null;
    private List<NewRelationship> policies = null;
    private List<NewRelationship> rules = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;
    private List<NewRelationship> referenceData = null;
    private List<NewRelationship> dataClasses = null;

    public RuleRelationshipsRequest parentCategory(NewRelationship parentCategory) {
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
    public NewRelationship getParentCategory() { return parentCategory; }
    public void setParentCategory(NewRelationship parentCategory) { this.parentCategory = parentCategory; }

    public RuleRelationshipsRequest categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public RuleRelationshipsRequest addCategoriesItem(NewRelationship categoriesItem) {
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(categoriesItem);
        return this;
    }

    /**
     * Category relationships.
     * @return categories
     **/
    @javax.annotation.Nullable
    @JsonProperty("categories")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getCategories() { return categories; }
    public void setCategories(List<NewRelationship> categories) { this.categories = categories; }

    public RuleRelationshipsRequest policies(List<NewRelationship> policies) {
        this.policies = policies;
        return this;
    }

    public RuleRelationshipsRequest addPoliciesItem(NewRelationship policiesItem) {
        if (this.policies == null) {
            this.policies = new ArrayList<>();
        }
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * The list of parent policies
     * @return policies
     **/
    @javax.annotation.Nullable
    @JsonProperty("policies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getPolicies() { return policies; }
    public void setPolicies(List<NewRelationship> policies) { this.policies = policies; }

    public RuleRelationshipsRequest rules(List<NewRelationship> rules) {
        this.rules = rules;
        return this;
    }

    public RuleRelationshipsRequest addRulesItem(NewRelationship rulesItem) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rulesItem);
        return this;
    }

    /**
     * The list of related rules
     * @return rules
     **/
    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getRules() { return rules; }
    public void setRules(List<NewRelationship> rules) { this.rules = rules; }

    public RuleRelationshipsRequest terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public RuleRelationshipsRequest addTermsItem(NewRelationship termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * The list of related business terms
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getTerms() { return terms; }
    public void setTerms(List<NewRelationship> terms) { this.terms = terms; }

    public RuleRelationshipsRequest classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public RuleRelationshipsRequest addClassificationsItem(NewRelationship classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * The list of related classifications
     * @return classifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getClassifications() { return classifications; }
    public void setClassifications(List<NewRelationship> classifications) { this.classifications = classifications; }

    public RuleRelationshipsRequest referenceData(List<NewRelationship> referenceData) {
        this.referenceData = referenceData;
        return this;
    }

    public RuleRelationshipsRequest addReferenceDataItem(NewRelationship referenceDataItem) {
        if (this.referenceData == null) {
            this.referenceData = new ArrayList<>();
        }
        this.referenceData.add(referenceDataItem);
        return this;
    }

    /**
     * The list of related reference data sets
     * @return referenceData
     **/
    @javax.annotation.Nullable
    @JsonProperty("reference_data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getReferenceData() { return referenceData; }
    public void setReferenceData(List<NewRelationship> referenceData) { this.referenceData = referenceData; }

    public RuleRelationshipsRequest dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public RuleRelationshipsRequest addDataClassesItem(NewRelationship dataClassesItem) {
        if (this.dataClasses == null) {
            this.dataClasses = new ArrayList<>();
        }
        this.dataClasses.add(dataClassesItem);
        return this;
    }

    /**
     * The list of related data classes
     * @return dataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getDataClasses() { return dataClasses; }
    public void setDataClasses(List<NewRelationship> dataClasses) { this.dataClasses = dataClasses; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RuleRelationshipsRequest ruleRelationshipsRequest = (RuleRelationshipsRequest)o;
        return Objects.equals(this.parentCategory, ruleRelationshipsRequest.parentCategory) &&
                Objects.equals(this.categories, ruleRelationshipsRequest.categories) &&
                Objects.equals(this.policies, ruleRelationshipsRequest.policies) &&
                Objects.equals(this.rules, ruleRelationshipsRequest.rules) &&
                Objects.equals(this.terms, ruleRelationshipsRequest.terms) &&
                Objects.equals(this.classifications, ruleRelationshipsRequest.classifications) &&
                Objects.equals(this.referenceData, ruleRelationshipsRequest.referenceData) &&
                Objects.equals(this.dataClasses, ruleRelationshipsRequest.dataClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentCategory, categories, policies, rules, terms,
                classifications, referenceData, dataClasses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RuleRelationshipsRequest {\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
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
