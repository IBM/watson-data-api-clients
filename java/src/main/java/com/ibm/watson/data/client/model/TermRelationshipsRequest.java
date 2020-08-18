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
 * TermRelationshipsRequest
 */
public class TermRelationshipsRequest {

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

    public TermRelationshipsRequest parentCategory(NewRelationship parentCategory) {
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

    public TermRelationshipsRequest categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public TermRelationshipsRequest addCategoriesItem(NewRelationship categoriesItem) {
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

    public TermRelationshipsRequest isATypeOfTerms(List<NewRelationship> isATypeOfTerms) {
        this.isATypeOfTerms = isATypeOfTerms;
        return this;
    }

    public TermRelationshipsRequest addIsATypeOfTermsItem(NewRelationship isATypeOfTermsItem) {
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

    public TermRelationshipsRequest hasTypeTerms(List<NewRelationship> hasTypeTerms) {
        this.hasTypeTerms = hasTypeTerms;
        return this;
    }

    public TermRelationshipsRequest addHasTypeTermsItem(NewRelationship hasTypeTermsItem) {
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

    public TermRelationshipsRequest isOfTerms(List<NewRelationship> isOfTerms) {
        this.isOfTerms = isOfTerms;
        return this;
    }

    public TermRelationshipsRequest addIsOfTermsItem(NewRelationship isOfTermsItem) {
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

    public TermRelationshipsRequest hasTerms(List<NewRelationship> hasTerms) {
        this.hasTerms = hasTerms;
        return this;
    }

    public TermRelationshipsRequest addHasTermsItem(NewRelationship hasTermsItem) {
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

    public TermRelationshipsRequest synonymTerms(List<NewRelationship> synonymTerms) {
        this.synonymTerms = synonymTerms;
        return this;
    }

    public TermRelationshipsRequest addSynonymTermsItem(NewRelationship synonymTermsItem) {
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

    public TermRelationshipsRequest relatedTerms(List<NewRelationship> relatedTerms) {
        this.relatedTerms = relatedTerms;
        return this;
    }

    public TermRelationshipsRequest addRelatedTermsItem(NewRelationship relatedTermsItem) {
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

    public TermRelationshipsRequest replacesTerms(List<NewRelationship> replacesTerms) {
        this.replacesTerms = replacesTerms;
        return this;
    }

    public TermRelationshipsRequest addReplacesTermsItem(NewRelationship replacesTermsItem) {
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

    public TermRelationshipsRequest replacedByTerms(List<NewRelationship> replacedByTerms) {
        this.replacedByTerms = replacedByTerms;
        return this;
    }

    public TermRelationshipsRequest addReplacedByTermsItem(NewRelationship replacedByTermsItem) {
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

    public TermRelationshipsRequest dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public TermRelationshipsRequest addDataClassesItem(NewRelationship dataClassesItem) {
        if (this.dataClasses == null) {
            this.dataClasses = new ArrayList<>();
        }
        this.dataClasses.add(dataClassesItem);
        return this;
    }

    /**
     * The relationships to the data classes.
     * @return dataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getDataClasses() { return dataClasses; }
    public void setDataClasses(List<NewRelationship> dataClasses) { this.dataClasses = dataClasses; }

    public TermRelationshipsRequest classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public TermRelationshipsRequest addClassificationsItem(NewRelationship classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * The relationships to the classifications.
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
        TermRelationshipsRequest termRelationshipsRequest = (TermRelationshipsRequest)o;
        return Objects.equals(this.parentCategory, termRelationshipsRequest.parentCategory) &&
                Objects.equals(this.categories, termRelationshipsRequest.categories) &&
                Objects.equals(this.isATypeOfTerms, termRelationshipsRequest.isATypeOfTerms) &&
                Objects.equals(this.hasTypeTerms, termRelationshipsRequest.hasTypeTerms) &&
                Objects.equals(this.isOfTerms, termRelationshipsRequest.isOfTerms) &&
                Objects.equals(this.hasTerms, termRelationshipsRequest.hasTerms) &&
                Objects.equals(this.synonymTerms, termRelationshipsRequest.synonymTerms) &&
                Objects.equals(this.relatedTerms, termRelationshipsRequest.relatedTerms) &&
                Objects.equals(this.replacesTerms, termRelationshipsRequest.replacesTerms) &&
                Objects.equals(this.replacedByTerms, termRelationshipsRequest.replacedByTerms) &&
                Objects.equals(this.dataClasses, termRelationshipsRequest.dataClasses) &&
                Objects.equals(this.classifications, termRelationshipsRequest.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentCategory, categories, isATypeOfTerms,
                hasTypeTerms, isOfTerms, hasTerms, synonymTerms,
                relatedTerms, replacesTerms, replacedByTerms,
                dataClasses, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TermRelationshipsRequest {\n");
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
