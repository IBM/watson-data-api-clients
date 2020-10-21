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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * NewRuleEntity
 */
public class WriteableRuleEntity extends GlossaryObjectEntity {

    private String name;
    private String shortDescription;
    private OffsetDateTime effectiveStartDate;
    private OffsetDateTime effectiveEndDate;
    private List<String> tags = null;
    private List<String> stewardIds = null;
    private NewRelationship parentCategory;
    private List<NewRelationship> categories = null;
    private List<NewRelationship> policies = null;
    private List<NewRelationship> rules = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;
    private List<NewRelationship> referenceData = null;
    private List<NewRelationship> dataClasses = null;

    public WriteableRuleEntity name(String name) {
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

    public WriteableRuleEntity shortDescription(String shortDescription) {
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

    public WriteableRuleEntity effectiveStartDate(OffsetDateTime effectiveStartDate) {
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
    public OffsetDateTime getEffectiveStartDate() { return effectiveStartDate; }
    public void setEffectiveStartDate(OffsetDateTime effectiveStartDate) { this.effectiveStartDate = effectiveStartDate; }

    public WriteableRuleEntity effectiveEndDate(OffsetDateTime effectiveEndDate) {
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
    public OffsetDateTime getEffectiveEndDate() { return effectiveEndDate; }
    public void setEffectiveEndDate(OffsetDateTime effectiveEndDate) { this.effectiveEndDate = effectiveEndDate; }

    public WriteableRuleEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public WriteableRuleEntity addTagsItem(String tagsItem) {
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

    public WriteableRuleEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public WriteableRuleEntity addStewardIdsItem(String stewardIdsItem) {
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

    public WriteableRuleEntity parentCategory(NewRelationship parentCategory) {
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

    public WriteableRuleEntity categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public WriteableRuleEntity addCategoriesItem(NewRelationship categoriesItem) {
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

    public WriteableRuleEntity policies(List<NewRelationship> policies) {
        this.policies = policies;
        return this;
    }

    public WriteableRuleEntity addPoliciesItem(NewRelationship policiesItem) {
        if (this.policies == null) {
            this.policies = new ArrayList<>();
        }
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * The relationships to governance policies.
     * @return policies
     **/
    @javax.annotation.Nullable
    @JsonProperty("policies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getPolicies() { return policies; }
    public void setPolicies(List<NewRelationship> policies) { this.policies = policies; }

    public WriteableRuleEntity rules(List<NewRelationship> rules) {
        this.rules = rules;
        return this;
    }

    public WriteableRuleEntity addRulesItem(NewRelationship rulesItem) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rulesItem);
        return this;
    }

    /**
     * Relationships to governance rules only. Does not include other rule
     * relastionships.
     * @return rules
     **/
    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getRules() { return rules; }
    public void setRules(List<NewRelationship> rules) { this.rules = rules; }

    public WriteableRuleEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public WriteableRuleEntity addTermsItem(NewRelationship termsItem) {
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

    public WriteableRuleEntity classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public WriteableRuleEntity addClassificationsItem(NewRelationship classificationsItem) {
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

    public WriteableRuleEntity referenceData(List<NewRelationship> referenceData) {
        this.referenceData = referenceData;
        return this;
    }

    public WriteableRuleEntity addReferenceDataItem(NewRelationship referenceDataItem) {
        if (this.referenceData == null) {
            this.referenceData = new ArrayList<>();
        }
        this.referenceData.add(referenceDataItem);
        return this;
    }

    /**
     * The relationships to reference data sets.
     * @return referenceData
     **/
    @javax.annotation.Nullable
    @JsonProperty("reference_data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getReferenceData() { return referenceData; }
    public void setReferenceData(List<NewRelationship> referenceData) { this.referenceData = referenceData; }

    public WriteableRuleEntity dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public WriteableRuleEntity addDataClassesItem(NewRelationship dataClassesItem) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WriteableRuleEntity newRuleEntity = (WriteableRuleEntity)o;
        return super.equals(o) &&
                Objects.equals(this.name, newRuleEntity.name) &&
                Objects.equals(this.shortDescription, newRuleEntity.shortDescription) &&
                Objects.equals(this.effectiveStartDate, newRuleEntity.effectiveStartDate) &&
                Objects.equals(this.effectiveEndDate, newRuleEntity.effectiveEndDate) &&
                Objects.equals(this.tags, newRuleEntity.tags) &&
                Objects.equals(this.stewardIds, newRuleEntity.stewardIds) &&
                Objects.equals(this.parentCategory, newRuleEntity.parentCategory) &&
                Objects.equals(this.categories, newRuleEntity.categories) &&
                Objects.equals(this.policies, newRuleEntity.policies) &&
                Objects.equals(this.rules, newRuleEntity.rules) &&
                Objects.equals(this.terms, newRuleEntity.terms) &&
                Objects.equals(this.classifications, newRuleEntity.classifications) &&
                Objects.equals(this.referenceData, newRuleEntity.referenceData) &&
                Objects.equals(this.dataClasses, newRuleEntity.dataClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, shortDescription,
                effectiveStartDate, effectiveEndDate, tags, stewardIds,
                parentCategory, categories, policies, rules, terms,
                classifications, referenceData, dataClasses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WriteableRuleEntity {\n");
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
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
    }

}
