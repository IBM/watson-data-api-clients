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
 * ResponseTermEntity
 */
public class ResponseTermEntity extends GlossaryObjectEntity {

    private List<String> abbreviations = null;
    private String importSourceCreatedBy;
    private Date importSourceCreatedOn;
    private String importSourceUsage;
    private String example;
    private String abbreviation;
    private String defaultLocaleId;
    private PaginatedParentRelationshipsList parentCategory;
    private PaginatedRelationshipsList categories;
    private PaginatedParentRelationshipsList isATypeOfTerms;
    private PaginatedRelationshipsList hasTypeTerms;
    private PaginatedParentRelationshipsList isOfTerms;
    private PaginatedRelationshipsList hasTerms;
    private PaginatedRelationshipsList synonymTerms;
    private PaginatedRelationshipsList relatedTerms;
    private PaginatedRelationshipsList replacesTerms;
    private PaginatedRelationshipsList replacedByTerms;
    private PaginatedRelationshipsList dataClasses;
    private PaginatedRelationshipsList classifications;
    private PaginatedRelationshipsList referenceData;
    private PaginatedRelationshipsList referenceDataValues;
    private PaginatedRelationshipsList policies;
    private PaginatedRelationshipsList rules;

    public ResponseTermEntity abbreviations(List<String> abbreviations) {
        this.abbreviations = abbreviations;
        return this;
    }

    public ResponseTermEntity addAbbreviationsItem(String abbreviationsItem) {
        if (this.abbreviations == null) {
            this.abbreviations = new ArrayList<>();
        }
        this.abbreviations.add(abbreviationsItem);
        return this;
    }

    /**
     * The list of abbreviations of a business term.
     * @return abbreviations
     **/
    @javax.annotation.Nullable
    @JsonProperty("abbreviations")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAbbreviations() { return abbreviations; }
    public void setAbbreviations(List<String> abbreviations) { this.abbreviations = abbreviations; }

    public ResponseTermEntity importSourceCreatedBy(String importSourceCreatedBy) {
        this.importSourceCreatedBy = importSourceCreatedBy;
        return this;
    }

    /**
     * Name of the user who has created the term in the original source for
     * imported term.
     * @return importSourceCreatedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_source_created_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportSourceCreatedBy() { return importSourceCreatedBy; }
    public void setImportSourceCreatedBy(String importSourceCreatedBy) { this.importSourceCreatedBy = importSourceCreatedBy; }

    public ResponseTermEntity importSourceCreatedOn(Date importSourceCreatedOn) {
        this.importSourceCreatedOn = importSourceCreatedOn;
        return this;
    }

    /**
     * The timestamp when the term was created in the original source for imported
     * term.
     * @return importSourceCreatedOn
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_source_created_on")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getImportSourceCreatedOn() { return importSourceCreatedOn; }
    public void setImportSourceCreatedOn(Date importSourceCreatedOn) { this.importSourceCreatedOn = importSourceCreatedOn; }

    public ResponseTermEntity importSourceUsage(String importSourceUsage) {
        this.importSourceUsage = importSourceUsage;
        return this;
    }

    /**
     * The usage of the term in the original source for imported term.
     * @return importSourceUsage
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_source_usage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportSourceUsage() { return importSourceUsage; }
    public void setImportSourceUsage(String importSourceUsage) { this.importSourceUsage = importSourceUsage; }

    public ResponseTermEntity example(String example) {
        this.example = example;
        return this;
    }

    /**
     * Get example
     * @return example
     **/
    @javax.annotation.Nullable
    @JsonProperty("example")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    public ResponseTermEntity abbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("abbreviation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    public ResponseTermEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public ResponseTermEntity parentCategory(PaginatedParentRelationshipsList parentCategory) {
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

    public ResponseTermEntity categories(PaginatedRelationshipsList categories) {
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

    public ResponseTermEntity isATypeOfTerms(PaginatedParentRelationshipsList isATypeOfTerms) {
        this.isATypeOfTerms = isATypeOfTerms;
        return this;
    }

    /**
     * Get isATypeOfTerms
     * @return isATypeOfTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_a_type_of_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedParentRelationshipsList getIsATypeOfTerms() { return isATypeOfTerms; }
    public void setIsATypeOfTerms(PaginatedParentRelationshipsList isATypeOfTerms) { this.isATypeOfTerms = isATypeOfTerms; }

    public ResponseTermEntity hasTypeTerms(PaginatedRelationshipsList hasTypeTerms) {
        this.hasTypeTerms = hasTypeTerms;
        return this;
    }

    /**
     * Get hasTypeTerms
     * @return hasTypeTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_type_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getHasTypeTerms() { return hasTypeTerms; }
    public void setHasTypeTerms(PaginatedRelationshipsList hasTypeTerms) { this.hasTypeTerms = hasTypeTerms; }

    public ResponseTermEntity isOfTerms(PaginatedParentRelationshipsList isOfTerms) {
        this.isOfTerms = isOfTerms;
        return this;
    }

    /**
     * Get isOfTerms
     * @return isOfTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_of_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedParentRelationshipsList getIsOfTerms() { return isOfTerms; }
    public void setIsOfTerms(PaginatedParentRelationshipsList isOfTerms) { this.isOfTerms = isOfTerms; }

    public ResponseTermEntity hasTerms(PaginatedRelationshipsList hasTerms) {
        this.hasTerms = hasTerms;
        return this;
    }

    /**
     * Get hasTerms
     * @return hasTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getHasTerms() { return hasTerms; }
    public void setHasTerms(PaginatedRelationshipsList hasTerms) { this.hasTerms = hasTerms; }

    public ResponseTermEntity synonymTerms(PaginatedRelationshipsList synonymTerms) {
        this.synonymTerms = synonymTerms;
        return this;
    }

    /**
     * Get synonymTerms
     * @return synonymTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("synonym_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getSynonymTerms() { return synonymTerms; }
    public void setSynonymTerms(PaginatedRelationshipsList synonymTerms) { this.synonymTerms = synonymTerms; }

    public ResponseTermEntity relatedTerms(PaginatedRelationshipsList relatedTerms) {
        this.relatedTerms = relatedTerms;
        return this;
    }

    /**
     * Get relatedTerms
     * @return relatedTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("related_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getRelatedTerms() { return relatedTerms; }
    public void setRelatedTerms(PaginatedRelationshipsList relatedTerms) { this.relatedTerms = relatedTerms; }

    public ResponseTermEntity replacesTerms(PaginatedRelationshipsList replacesTerms) {
        this.replacesTerms = replacesTerms;
        return this;
    }

    /**
     * Get replacesTerms
     * @return replacesTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("replaces_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getReplacesTerms() { return replacesTerms; }
    public void setReplacesTerms(PaginatedRelationshipsList replacesTerms) { this.replacesTerms = replacesTerms; }

    public ResponseTermEntity replacedByTerms(PaginatedRelationshipsList replacedByTerms) {
        this.replacedByTerms = replacedByTerms;
        return this;
    }

    /**
     * Get replacedByTerms
     * @return replacedByTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("replaced_by_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getReplacedByTerms() { return replacedByTerms; }
    public void setReplacedByTerms(PaginatedRelationshipsList replacedByTerms) { this.replacedByTerms = replacedByTerms; }

    public ResponseTermEntity dataClasses(PaginatedRelationshipsList dataClasses) {
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

    public ResponseTermEntity classifications(PaginatedRelationshipsList classifications) {
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

    public ResponseTermEntity referenceData(PaginatedRelationshipsList referenceData) {
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

    public ResponseTermEntity referenceDataValues(PaginatedRelationshipsList referenceDataValues) {
        this.referenceDataValues = referenceDataValues;
        return this;
    }

    /**
     * Get referenceDataValues
     * @return referenceDataValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("reference_data_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getReferenceDataValues() { return referenceDataValues; }
    public void setReferenceDataValues(PaginatedRelationshipsList referenceDataValues) { this.referenceDataValues = referenceDataValues; }

    public ResponseTermEntity policies(PaginatedRelationshipsList policies) {
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

    public ResponseTermEntity rules(PaginatedRelationshipsList rules) {
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
        ResponseTermEntity responseTermEntity = (ResponseTermEntity)o;
        return super.equals(o) &&
                Objects.equals(this.abbreviations, responseTermEntity.abbreviations) &&
                Objects.equals(this.importSourceCreatedBy, responseTermEntity.importSourceCreatedBy) &&
                Objects.equals(this.importSourceCreatedOn, responseTermEntity.importSourceCreatedOn) &&
                Objects.equals(this.importSourceUsage, responseTermEntity.importSourceUsage) &&
                Objects.equals(this.example, responseTermEntity.example) &&
                Objects.equals(this.abbreviation, responseTermEntity.abbreviation) &&
                Objects.equals(this.defaultLocaleId, responseTermEntity.defaultLocaleId) &&
                Objects.equals(this.parentCategory, responseTermEntity.parentCategory) &&
                Objects.equals(this.categories, responseTermEntity.categories) &&
                Objects.equals(this.isATypeOfTerms, responseTermEntity.isATypeOfTerms) &&
                Objects.equals(this.hasTypeTerms, responseTermEntity.hasTypeTerms) &&
                Objects.equals(this.isOfTerms, responseTermEntity.isOfTerms) &&
                Objects.equals(this.hasTerms, responseTermEntity.hasTerms) &&
                Objects.equals(this.synonymTerms, responseTermEntity.synonymTerms) &&
                Objects.equals(this.relatedTerms, responseTermEntity.relatedTerms) &&
                Objects.equals(this.replacesTerms, responseTermEntity.replacesTerms) &&
                Objects.equals(this.replacedByTerms, responseTermEntity.replacedByTerms) &&
                Objects.equals(this.dataClasses, responseTermEntity.dataClasses) &&
                Objects.equals(this.classifications, responseTermEntity.classifications) &&
                Objects.equals(this.referenceData, responseTermEntity.referenceData) &&
                Objects.equals(this.referenceDataValues, responseTermEntity.referenceDataValues) &&
                Objects.equals(this.policies, responseTermEntity.policies) &&
                Objects.equals(this.rules, responseTermEntity.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), abbreviations,
                importSourceCreatedBy, importSourceCreatedOn, importSourceUsage,
                example, abbreviation, defaultLocaleId,
                parentCategory, categories,
                isATypeOfTerms, hasTypeTerms, isOfTerms, hasTerms,
                synonymTerms, relatedTerms, replacesTerms,
                replacedByTerms, dataClasses, classifications,
                referenceData, referenceDataValues, policies, rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseTermEntity {\n");
        super.toString(sb);
        sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
        sb.append("    importSourceCreatedBy: ").append(toIndentedString(importSourceCreatedBy)).append("\n");
        sb.append("    importSourceCreatedOn: ").append(toIndentedString(importSourceCreatedOn)).append("\n");
        sb.append("    importSourceUsage: ").append(toIndentedString(importSourceUsage)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    isATypeOfTerms: ").append(toIndentedString(isATypeOfTerms)).append("\n");
        sb.append("    hasTypeTerms: ").append(toIndentedString(hasTypeTerms)).append("\n");
        sb.append("    isOfTerms: ").append(toIndentedString(isOfTerms)).append("\n");
        sb.append("    hasTerms: ").append(toIndentedString(hasTerms)).append("\n");
        sb.append("    synonymTerms: ").append(toIndentedString(synonymTerms)).append("\n");
        sb.append("    relatedTerms: ").append(toIndentedString(relatedTerms)).append("\n");
        sb.append("    replacesTerms: ").append(toIndentedString(replacesTerms)).append("\n");
        sb.append("    replacedByTerms: ").append(toIndentedString(replacedByTerms)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    referenceDataValues: ").append(toIndentedString(referenceDataValues)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
