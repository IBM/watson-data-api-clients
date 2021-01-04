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
 * NewDataClassEntity
 */
public class NewDataClassEntity extends DataClassEntity {

    private String name;
    private String shortDescription;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private String workflowState;
    private List<String> tags = null;
    private List<String> stewardIds = null;
    private NewRelationship parentCategory;
    private NewRelationship isATypeOfDataClass;
    private List<NewRelationship> hasTypesDataClasses = null;
    private List<NewRelationship> categories = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;

    public NewDataClassEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the artifact.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public NewDataClassEntity shortDescription(String shortDescription) {
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

    public NewDataClassEntity effectiveStartDate(Date effectiveStartDate) {
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

    public NewDataClassEntity effectiveEndDate(Date effectiveEndDate) {
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

    public NewDataClassEntity workflowState(String workflowState) {
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

    public NewDataClassEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public NewDataClassEntity addTagsItem(String tagsItem) {
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

    public NewDataClassEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public NewDataClassEntity addStewardIdsItem(String stewardIdsItem) {
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

    public NewDataClassEntity parentCategory(NewRelationship parentCategory) {
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

    public NewDataClassEntity isATypeOfDataClass(NewRelationship isATypeOfDataClass) {
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
    public NewRelationship getIsATypeOfDataClass() { return isATypeOfDataClass; }
    public void setIsATypeOfDataClass(NewRelationship isATypeOfDataClass) { this.isATypeOfDataClass = isATypeOfDataClass; }

    public NewDataClassEntity hasTypesDataClasses(List<NewRelationship> hasTypesDataClasses) {
        this.hasTypesDataClasses = hasTypesDataClasses;
        return this;
    }

    public NewDataClassEntity addHasTypesDataClassesItem(NewRelationship hasTypesDataClassesItem) {
        if (this.hasTypesDataClasses == null) {
            this.hasTypesDataClasses = new ArrayList<>();
        }
        this.hasTypesDataClasses.add(hasTypesDataClassesItem);
        return this;
    }

    /**
     * List of child data classes in the data class type hierarchy.
     * @return hasTypesDataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getHasTypesDataClasses() { return hasTypesDataClasses; }
    public void setHasTypesDataClasses(List<NewRelationship> hasTypesDataClasses) { this.hasTypesDataClasses = hasTypesDataClasses; }

    public NewDataClassEntity categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public NewDataClassEntity addCategoriesItem(NewRelationship categoriesItem) {
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

    public NewDataClassEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public NewDataClassEntity addTermsItem(NewRelationship termsItem) {
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

    public NewDataClassEntity classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public NewDataClassEntity addClassificationsItem(NewRelationship classificationsItem) {
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
        NewDataClassEntity newDataClassEntity = (NewDataClassEntity)o;
        return super.equals(o) &&
                Objects.equals(this.name, newDataClassEntity.name) &&
                Objects.equals(this.shortDescription, newDataClassEntity.shortDescription) &&
                Objects.equals(this.effectiveStartDate, newDataClassEntity.effectiveStartDate) &&
                Objects.equals(this.effectiveEndDate, newDataClassEntity.effectiveEndDate) &&
                Objects.equals(this.workflowState, newDataClassEntity.workflowState) &&
                Objects.equals(this.tags, newDataClassEntity.tags) &&
                Objects.equals(this.stewardIds, newDataClassEntity.stewardIds) &&
                Objects.equals(this.parentCategory, newDataClassEntity.parentCategory) &&
                Objects.equals(this.isATypeOfDataClass, newDataClassEntity.isATypeOfDataClass) &&
                Objects.equals(this.hasTypesDataClasses, newDataClassEntity.hasTypesDataClasses) &&
                Objects.equals(this.categories, newDataClassEntity.categories) &&
                Objects.equals(this.terms, newDataClassEntity.terms) &&
                Objects.equals(this.classifications, newDataClassEntity.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                name, shortDescription, effectiveStartDate,
                effectiveEndDate, workflowState, tags, stewardIds,
                parentCategory, isATypeOfDataClass, hasTypesDataClasses, categories,
                terms, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewDataClassEntity {\n");
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
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    isATypeOfDataClass: ").append(toIndentedString(isATypeOfDataClass)).append("\n");
        sb.append("    hasTypesDataClasses: ").append(toIndentedString(hasTypesDataClasses)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
    }

}
