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
 * WriteableTermEntity
 */
public class WriteableTermEntity extends TermEntity {

    private String name;
    private String shortDescription;
    private OffsetDateTime effectiveStartDate;
    private OffsetDateTime effectiveEndDate;
    private List<String> tags = null;
    private List<String> stewardIds = null;
    private List<RelationshipObject> relatedTermRelationships = null;
    private NewRelationship parentCategory;
    private List<NewRelationship> categories = null;
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

    public WriteableTermEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the artifact.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public WriteableTermEntity shortDescription(String shortDescription) {
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

    public WriteableTermEntity effectiveStartDate(OffsetDateTime effectiveStartDate) {
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

    public WriteableTermEntity effectiveEndDate(OffsetDateTime effectiveEndDate) {
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

    public WriteableTermEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public WriteableTermEntity addTagsItem(String tagsItem) {
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

    public WriteableTermEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public WriteableTermEntity addStewardIdsItem(String stewardIdsItem) {
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

    public WriteableTermEntity parentCategory(NewRelationship parentCategory) {
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

    public WriteableTermEntity categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public WriteableTermEntity addCategoriesItem(NewRelationship categoriesItem) {
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
                Objects.equals(this.name, newTermEntity.name) &&
                Objects.equals(this.shortDescription, newTermEntity.shortDescription) &&
                Objects.equals(this.effectiveStartDate, newTermEntity.effectiveStartDate) &&
                Objects.equals(this.effectiveEndDate, newTermEntity.effectiveEndDate) &&
                Objects.equals(this.tags, newTermEntity.tags) &&
                Objects.equals(this.stewardIds, newTermEntity.stewardIds) &&
                Objects.equals(this.relatedTermRelationships, newTermEntity.relatedTermRelationships) &&
                Objects.equals(this.parentCategory, newTermEntity.parentCategory) &&
                Objects.equals(this.categories, newTermEntity.categories) &&
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
                name, shortDescription, effectiveStartDate,
                effectiveEndDate, tags, stewardIds,
                relatedTermRelationships, parentCategory, categories, isATypeOfTerms, hasTypeTerms,
                isOfTerms, hasTerms, synonymTerms, relatedTerms, replacesTerms,
                replacedByTerms, dataClasses, classifications);
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
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    shortDescription: ").append(toIndentedString(shortDescription)).append("\n");
        sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
        sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    relatedTermRelationships: ").append(toIndentedString(relatedTermRelationships)).append("\n");
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
    }

}
