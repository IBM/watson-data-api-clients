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
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * NewPolicyEntity
 */
public class NewPolicyEntity extends GlossaryObjectEntity {

    private String name;
    private String shortDescription;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private String workflowState;
    private List<String> tags = null;
    private NewRelationship parentPolicy;
    private List<NewRelationship> subPolicies = null;
    private NewRelationship parentCategory;
    private List<NewRelationship> categories = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> dataClasses = null;
    private List<NewRelationship> rules = null;
    private List<NewRelationship> classifications = null;

    public NewPolicyEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the artifact.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public NewPolicyEntity shortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    /**
     * The short description of an artifact.
     * @return shortDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("short_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public NewPolicyEntity effectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
        return this;
    }

    /**
     * The effective start date at which the artifact goes into effect. If the
     * effective start date is not specified, then the artifact goes into effect
     * immediately.
     * @return effectiveStartDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_start_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveStartDate() { return effectiveStartDate; }
    public void setEffectiveStartDate(Date effectiveStartDate) { this.effectiveStartDate = effectiveStartDate; }

    public NewPolicyEntity effectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
        return this;
    }

    /**
     * The effective end date at which the artifact ends and no longer effective.
     * If the effective end date is not specified, then the artifact remains effect
     * forever.
     * @return effectiveEndDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_end_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveEndDate() { return effectiveEndDate; }
    public void setEffectiveEndDate(Date effectiveEndDate) { this.effectiveEndDate = effectiveEndDate; }

    public NewPolicyEntity workflowState(String workflowState) {
        this.workflowState = workflowState;
        return this;
    }

    /**
     * The workflow state of an artifact
     * @return workflowState
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowState() { return workflowState; }
    public void setWorkflowState(String workflowState) { this.workflowState = workflowState; }

    public NewPolicyEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public NewPolicyEntity addTagsItem(String tagsItem) {
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

    public NewPolicyEntity parentPolicy(NewRelationship parentPolicy) {
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
    public NewRelationship getParentPolicy() { return parentPolicy; }
    public void setParentPolicy(NewRelationship parentPolicy) { this.parentPolicy = parentPolicy; }

    public NewPolicyEntity subPolicies(List<NewRelationship> subPolicies) {
        this.subPolicies = subPolicies;
        return this;
    }

    public NewPolicyEntity addSubPoliciesItem(NewRelationship subPoliciesItem) {
        if (this.subPolicies == null) {
            this.subPolicies = new ArrayList<>();
        }
        this.subPolicies.add(subPoliciesItem);
        return this;
    }

    /**
     * The list of sub-policies in the policy type hierarchy.
     * @return subPolicies
     **/
    @javax.annotation.Nullable
    @JsonProperty("sub_policies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getSubPolicies() { return subPolicies; }
    public void setSubPolicies(List<NewRelationship> subPolicies) { this.subPolicies = subPolicies; }

    public NewPolicyEntity parentCategory(NewRelationship parentCategory) {
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

    public NewPolicyEntity categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public NewPolicyEntity addCategoriesItem(NewRelationship categoriesItem) {
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(categoriesItem);
        return this;
    }

    /**
     * Secondary categories the artifact belongs to.
     * @return categories
     **/
    @javax.annotation.Nullable
    @JsonProperty("categories")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getCategories() { return categories; }
    public void setCategories(List<NewRelationship> categories) { this.categories = categories; }

    public NewPolicyEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public NewPolicyEntity addTermsItem(NewRelationship termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * Relationships to business terms.
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getTerms() { return terms; }
    public void setTerms(List<NewRelationship> terms) { this.terms = terms; }

    public NewPolicyEntity dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public NewPolicyEntity addDataClassesItem(NewRelationship dataClassesItem) {
        if (this.dataClasses == null) {
            this.dataClasses = new ArrayList<>();
        }
        this.dataClasses.add(dataClassesItem);
        return this;
    }

    /**
     * Relationships to data classes.
     * @return dataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getDataClasses() { return dataClasses; }
    public void setDataClasses(List<NewRelationship> dataClasses) { this.dataClasses = dataClasses; }

    public NewPolicyEntity rules(List<NewRelationship> rules) {
        this.rules = rules;
        return this;
    }

    public NewPolicyEntity addRulesItem(NewRelationship rulesItem) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rulesItem);
        return this;
    }

    /**
     * Relationships to governance rules only. Does not include other rule
     *relastionships.
     * @return rules
     **/
    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getRules() { return rules; }
    public void setRules(List<NewRelationship> rules) { this.rules = rules; }

    public NewPolicyEntity classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public NewPolicyEntity addClassificationsItem(NewRelationship classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * Relationships to classifications.
     * @return classifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getClassifications() { return classifications; }
    public void setClassifications(List<NewRelationship> classifications) { this.classifications = classifications; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NewPolicyEntity newPolicyEntity = (NewPolicyEntity)o;
        return super.equals(o) &&
                Objects.equals(this.name, newPolicyEntity.name) &&
                Objects.equals(this.shortDescription, newPolicyEntity.shortDescription) &&
                Objects.equals(this.effectiveStartDate, newPolicyEntity.effectiveStartDate) &&
                Objects.equals(this.effectiveEndDate, newPolicyEntity.effectiveEndDate) &&
                Objects.equals(this.workflowState, newPolicyEntity.workflowState) &&
                Objects.equals(this.tags, newPolicyEntity.tags) &&
                Objects.equals(this.parentPolicy, newPolicyEntity.parentPolicy) &&
                Objects.equals(this.subPolicies, newPolicyEntity.subPolicies) &&
                Objects.equals(this.parentCategory, newPolicyEntity.parentCategory) &&
                Objects.equals(this.categories, newPolicyEntity.categories) &&
                Objects.equals(this.terms, newPolicyEntity.terms) &&
                Objects.equals(this.dataClasses, newPolicyEntity.dataClasses) &&
                Objects.equals(this.rules, newPolicyEntity.rules) &&
                Objects.equals(this.classifications, newPolicyEntity.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shortDescription, effectiveStartDate,
                effectiveEndDate, workflowState, tags, parentPolicy,
                subPolicies, parentCategory, categories, terms,
                dataClasses, rules, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewPolicyEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    shortDescription: ").append(toIndentedString(shortDescription)).append("\n");
        sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
        sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
        sb.append("    workflowState: ").append(toIndentedString(workflowState)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    parentPolicy: ").append(toIndentedString(parentPolicy)).append("\n");
        sb.append("    subPolicies: ").append(toIndentedString(subPolicies)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
    }

}
