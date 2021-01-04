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
 * WriteableTermEntity
 */
public class WriteableTermEntity extends WriteableGlossaryObjectEntity {

    private List<String> abbreviations = null;
    private String importSourceCreatedBy;
    private Date importSourceCreatedOn;
    private String importSourceUsage;
    private String example;
    private List<RelationshipObject> relatedTermRelationships = null;
    private List<NewRelationship> isATypeOfTerms = null;
    private List<NewRelationship> hasTypeTerms = null;
    private List<NewRelationship> isOfTerms = null;
    private List<NewRelationship> hasTerms = null;
    private List<NewRelationship> synonymTerms = null;
    private List<NewRelationship> relatedTerms = null;
    private List<NewRelationship> replacesTerms = null;
    private List<NewRelationship> replacedByTerms = null;
    private List<NewRelationship> dataClasses = null;
    private List<NewRelationship> classifications = null;

    public WriteableTermEntity abbreviations(List<String> abbreviations) {
        this.abbreviations = abbreviations;
        return this;
    }

    public WriteableTermEntity addAbbreviationsItem(String abbreviationsItem) {
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

    public WriteableTermEntity importSourceCreatedBy(String importSourceCreatedBy) {
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

    public WriteableTermEntity importSourceCreatedOn(Date importSourceCreatedOn) {
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

    public WriteableTermEntity importSourceUsage(String importSourceUsage) {
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

    public WriteableTermEntity example(String example) {
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

    public WriteableTermEntity relatedTermRelationships(List<RelationshipObject> relatedTermRelationships) {
        this.relatedTermRelationships = relatedTermRelationships;
        return this;
    }

    public WriteableTermEntity addRelatedTermRelationshipsItem(RelationshipObject relatedTermRelationshipsItem) {
        if (this.relatedTermRelationships == null) {
            this.relatedTermRelationships = new ArrayList<>();
        }
        this.relatedTermRelationships.add(relatedTermRelationshipsItem);
        return this;
    }

    /**
     * The list of related business terms.
     * @return relatedTermRelationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("related_term_relationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipObject> getRelatedTermRelationships() { return relatedTermRelationships; }
    public void setRelatedTermRelationships(List<RelationshipObject> relatedTermRelationships) { this.relatedTermRelationships = relatedTermRelationships; }

    public WriteableTermEntity isATypeOfTerms(List<NewRelationship> isATypeOfTerms) {
        this.isATypeOfTerms = isATypeOfTerms;
        return this;
    }

    public WriteableTermEntity addIsATypeOfTermsItem(NewRelationship isATypeOfTermsItem) {
        if (this.isATypeOfTerms == null) {
            this.isATypeOfTerms = new ArrayList<>();
        }
        this.isATypeOfTerms.add(isATypeOfTermsItem);
        return this;
    }

    /**
     * The list of parent business terms in the business term type hierarchy.
     * @return isATypeOfTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_a_type_of_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getIsATypeOfTerms() { return isATypeOfTerms; }
    public void setIsATypeOfTerms(List<NewRelationship> isATypeOfTerms) { this.isATypeOfTerms = isATypeOfTerms; }

    public WriteableTermEntity hasTypeTerms(List<NewRelationship> hasTypeTerms) {
        this.hasTypeTerms = hasTypeTerms;
        return this;
    }

    public WriteableTermEntity addHasTypeTermsItem(NewRelationship hasTypeTermsItem) {
        if (this.hasTypeTerms == null) {
            this.hasTypeTerms = new ArrayList<>();
        }
        this.hasTypeTerms.add(hasTypeTermsItem);
        return this;
    }

    /**
     * The list of child business terms in the business term type hierarchy.
     * @return hasTypeTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_type_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getHasTypeTerms() { return hasTypeTerms; }
    public void setHasTypeTerms(List<NewRelationship> hasTypeTerms) { this.hasTypeTerms = hasTypeTerms; }

    public WriteableTermEntity isOfTerms(List<NewRelationship> isOfTerms) {
        this.isOfTerms = isOfTerms;
        return this;
    }

    public WriteableTermEntity addIsOfTermsItem(NewRelationship isOfTermsItem) {
        if (this.isOfTerms == null) {
            this.isOfTerms = new ArrayList<>();
        }
        this.isOfTerms.add(isOfTermsItem);
        return this;
    }

    /**
     * The list of parent business terms in the business term containment
     * hierarchy.
     * @return isOfTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_of_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getIsOfTerms() { return isOfTerms; }
    public void setIsOfTerms(List<NewRelationship> isOfTerms) { this.isOfTerms = isOfTerms; }

    public WriteableTermEntity hasTerms(List<NewRelationship> hasTerms) {
        this.hasTerms = hasTerms;
        return this;
    }

    public WriteableTermEntity addHasTermsItem(NewRelationship hasTermsItem) {
        if (this.hasTerms == null) {
            this.hasTerms = new ArrayList<>();
        }
        this.hasTerms.add(hasTermsItem);
        return this;
    }

    /**
     * The list of child business terms in the business term containment
     * hierarchy.
     * @return hasTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getHasTerms() { return hasTerms; }
    public void setHasTerms(List<NewRelationship> hasTerms) { this.hasTerms = hasTerms; }

    public WriteableTermEntity synonymTerms(List<NewRelationship> synonymTerms) {
        this.synonymTerms = synonymTerms;
        return this;
    }

    public WriteableTermEntity addSynonymTermsItem(NewRelationship synonymTermsItem) {
        if (this.synonymTerms == null) {
            this.synonymTerms = new ArrayList<>();
        }
        this.synonymTerms.add(synonymTermsItem);
        return this;
    }

    /**
     * The list of synonym business terms.
     * @return synonymTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("synonym_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getSynonymTerms() { return synonymTerms; }
    public void setSynonymTerms(List<NewRelationship> synonymTerms) { this.synonymTerms = synonymTerms; }

    public WriteableTermEntity relatedTerms(List<NewRelationship> relatedTerms) {
        this.relatedTerms = relatedTerms;
        return this;
    }

    public WriteableTermEntity addRelatedTermsItem(NewRelationship relatedTermsItem) {
        if (this.relatedTerms == null) {
            this.relatedTerms = new ArrayList<>();
        }
        this.relatedTerms.add(relatedTermsItem);
        return this;
    }

    /**
     * The list of related business terms.
     * @return relatedTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("related_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getRelatedTerms() { return relatedTerms; }
    public void setRelatedTerms(List<NewRelationship> relatedTerms) { this.relatedTerms = relatedTerms; }

    public WriteableTermEntity replacesTerms(List<NewRelationship> replacesTerms) {
        this.replacesTerms = replacesTerms;
        return this;
    }

    public WriteableTermEntity addReplacesTermsItem(NewRelationship replacesTermsItem) {
        if (this.replacesTerms == null) {
            this.replacesTerms = new ArrayList<>();
        }
        this.replacesTerms.add(replacesTermsItem);
        return this;
    }

    /**
     * The list of business terms that replace this business term.
     * @return replacesTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("replaces_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getReplacesTerms() { return replacesTerms; }
    public void setReplacesTerms(List<NewRelationship> replacesTerms) { this.replacesTerms = replacesTerms; }

    public WriteableTermEntity replacedByTerms(List<NewRelationship> replacedByTerms) {
        this.replacedByTerms = replacedByTerms;
        return this;
    }

    public WriteableTermEntity addReplacedByTermsItem(NewRelationship replacedByTermsItem) {
        if (this.replacedByTerms == null) {
            this.replacedByTerms = new ArrayList<>();
        }
        this.replacedByTerms.add(replacedByTermsItem);
        return this;
    }

    /**
     * The list of business terms that are replaced by this business term.
     * @return replacedByTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("replaced_by_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getReplacedByTerms() { return replacedByTerms; }
    public void setReplacedByTerms(List<NewRelationship> replacedByTerms) { this.replacedByTerms = replacedByTerms; }

    public WriteableTermEntity dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public WriteableTermEntity addDataClassesItem(NewRelationship dataClassesItem) {
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

    public WriteableTermEntity classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public WriteableTermEntity addClassificationsItem(NewRelationship classificationsItem) {
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
        WriteableTermEntity newTermEntity = (WriteableTermEntity)o;
        return super.equals(o) &&
                Objects.equals(this.abbreviations, newTermEntity.abbreviations) &&
                Objects.equals(this.importSourceCreatedBy, newTermEntity.importSourceCreatedBy) &&
                Objects.equals(this.importSourceCreatedOn, newTermEntity.importSourceCreatedOn) &&
                Objects.equals(this.importSourceUsage, newTermEntity.importSourceUsage) &&
                Objects.equals(this.example, newTermEntity.example) &&
                Objects.equals(this.relatedTermRelationships, newTermEntity.relatedTermRelationships) &&
                Objects.equals(this.isATypeOfTerms, newTermEntity.isATypeOfTerms) &&
                Objects.equals(this.hasTypeTerms, newTermEntity.hasTypeTerms) &&
                Objects.equals(this.isOfTerms, newTermEntity.isOfTerms) &&
                Objects.equals(this.hasTerms, newTermEntity.hasTerms) &&
                Objects.equals(this.synonymTerms, newTermEntity.synonymTerms) &&
                Objects.equals(this.relatedTerms, newTermEntity.relatedTerms) &&
                Objects.equals(this.replacesTerms, newTermEntity.replacesTerms) &&
                Objects.equals(this.replacedByTerms, newTermEntity.replacedByTerms) &&
                Objects.equals(this.dataClasses, newTermEntity.dataClasses) &&
                Objects.equals(this.classifications, newTermEntity.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                abbreviations, importSourceCreatedBy, importSourceCreatedOn,
                importSourceUsage, example, relatedTermRelationships, isATypeOfTerms,
                hasTypeTerms, isOfTerms, hasTerms, synonymTerms, relatedTerms,
                replacesTerms, replacedByTerms, dataClasses, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WriteableTermEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
        sb.append("    importSourceCreatedBy: ").append(toIndentedString(importSourceCreatedBy)).append("\n");
        sb.append("    importSourceCreatedOn: ").append(toIndentedString(importSourceCreatedOn)).append("\n");
        sb.append("    importSourceUsage: ").append(toIndentedString(importSourceUsage)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    relatedTermRelationships: ").append(toIndentedString(relatedTermRelationships)).append("\n");
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
    }

}
