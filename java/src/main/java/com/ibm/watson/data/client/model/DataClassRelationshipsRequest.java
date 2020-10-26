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
 * DataClassRelationshipsRequest
 */
public class DataClassRelationshipsRequest {

    private NewRelationship parentCategory;
    private List<NewRelationship> categories = null;
    private NewRelationship isATypeOfDataClass;
    private List<NewRelationship> hasTypesDataClasses = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;

    public DataClassRelationshipsRequest parentCategory(NewRelationship parentCategory) {
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

    public DataClassRelationshipsRequest categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public DataClassRelationshipsRequest addCategoriesItem(NewRelationship categoriesItem) {
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

    public DataClassRelationshipsRequest isATypeOfDataClass(NewRelationship isATypeOfDataClass) {
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

    public DataClassRelationshipsRequest hasTypesDataClasses(List<NewRelationship> hasTypesDataClasses) {
        this.hasTypesDataClasses = hasTypesDataClasses;
        return this;
    }

    public DataClassRelationshipsRequest addHasTypesDataClassesItem(NewRelationship hasTypesDataClassesItem) {
        if (this.hasTypesDataClasses == null) {
            this.hasTypesDataClasses = new ArrayList<>();
        }
        this.hasTypesDataClasses.add(hasTypesDataClassesItem);
        return this;
    }

    /**
     * New list of child data classes in the data class type hierarchy.
     * @return hasTypesDataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getHasTypesDataClasses() { return hasTypesDataClasses; }
    public void setHasTypesDataClasses(List<NewRelationship> hasTypesDataClasses) { this.hasTypesDataClasses = hasTypesDataClasses; }

    public DataClassRelationshipsRequest terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public DataClassRelationshipsRequest addTermsItem(NewRelationship termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * The relationships to business terms.
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getTerms() { return terms; }
    public void setTerms(List<NewRelationship> terms) { this.terms = terms; }

    public DataClassRelationshipsRequest classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public DataClassRelationshipsRequest addClassificationsItem(NewRelationship classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * The relationships to classifications.
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
        DataClassRelationshipsRequest dataClassRelationshipsRequest =
                (DataClassRelationshipsRequest)o;
        return Objects.equals(this.parentCategory, dataClassRelationshipsRequest.parentCategory) &&
                Objects.equals(this.categories, dataClassRelationshipsRequest.categories) &&
                Objects.equals(this.isATypeOfDataClass, dataClassRelationshipsRequest.isATypeOfDataClass) &&
                Objects.equals(this.hasTypesDataClasses, dataClassRelationshipsRequest.hasTypesDataClasses) &&
                Objects.equals(this.terms, dataClassRelationshipsRequest.terms) &&
                Objects.equals(this.classifications, dataClassRelationshipsRequest.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentCategory, categories, isATypeOfDataClass,
                hasTypesDataClasses, terms, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataClassRelationshipsRequest {\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    isATypeOfDataClass: ").append(toIndentedString(isATypeOfDataClass)).append("\n");
        sb.append("    hasTypesDataClasses: ").append(toIndentedString(hasTypesDataClasses)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
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
