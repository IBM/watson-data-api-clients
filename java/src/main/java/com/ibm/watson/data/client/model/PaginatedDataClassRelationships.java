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

import java.util.Objects;

/**
 * PaginatedDataClassRelationships
 */
public class PaginatedDataClassRelationships {

    private PaginatedParentRelationshipsList isATypeOfDataClass;
    private PaginatedParentRelationshipsList parentCategory;
    private PaginatedRelationshipsList hasTypesDataClasses;
    private PaginatedRelationshipsList categories;
    private PaginatedRelationshipsList terms;
    private PaginatedRelationshipsList classifications;

    public PaginatedDataClassRelationships isATypeOfDataClass(PaginatedParentRelationshipsList isATypeOfDataClass) {
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
    public PaginatedParentRelationshipsList getIsATypeOfDataClass() { return isATypeOfDataClass; }
    public void setIsATypeOfDataClass(PaginatedParentRelationshipsList isATypeOfDataClass) { this.isATypeOfDataClass = isATypeOfDataClass; }

    public PaginatedDataClassRelationships parentCategory(PaginatedParentRelationshipsList parentCategory) {
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

    public PaginatedDataClassRelationships hasTypesDataClasses(PaginatedRelationshipsList hasTypesDataClasses) {
        this.hasTypesDataClasses = hasTypesDataClasses;
        return this;
    }

    /**
     * Get hasTypesDataClasses
     * @return hasTypesDataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PaginatedRelationshipsList getHasTypesDataClasses() { return hasTypesDataClasses; }
    public void setHasTypesDataClasses(PaginatedRelationshipsList hasTypesDataClasses) { this.hasTypesDataClasses = hasTypesDataClasses; }

    public PaginatedDataClassRelationships categories(PaginatedRelationshipsList categories) {
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

    public PaginatedDataClassRelationships terms(PaginatedRelationshipsList terms) {
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

    public PaginatedDataClassRelationships classifications(PaginatedRelationshipsList classifications) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginatedDataClassRelationships responseDataClassEntity = (PaginatedDataClassRelationships)o;
        return Objects.equals(this.isATypeOfDataClass, responseDataClassEntity.isATypeOfDataClass) &&
                Objects.equals(this.parentCategory, responseDataClassEntity.parentCategory) &&
                Objects.equals(this.hasTypesDataClasses, responseDataClassEntity.hasTypesDataClasses) &&
                Objects.equals(this.categories, responseDataClassEntity.categories) &&
                Objects.equals(this.terms, responseDataClassEntity.terms) &&
                Objects.equals(this.classifications, responseDataClassEntity.classifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isATypeOfDataClass, parentCategory, hasTypesDataClasses, categories, terms, classifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginatedDataClassRelationships {\n");
        sb.append("    isATypeOfDataClass: ").append(toIndentedString(isATypeOfDataClass)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    hasTypesDataClasses: ").append(toIndentedString(hasTypesDataClasses)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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
