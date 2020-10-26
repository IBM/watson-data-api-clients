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
 * ReferenceDataSetRelationships
 */
public class ReferenceDataSetRelationships {

    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;
    private NewRelationship parentCategory;
    private List<NewRelationship> categories = null;

    public ReferenceDataSetRelationships terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public ReferenceDataSetRelationships addTermsItem(NewRelationship termsItem) {
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

    public ReferenceDataSetRelationships classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public ReferenceDataSetRelationships addClassificationsItem(NewRelationship classificationsItem) {
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

    public ReferenceDataSetRelationships parentCategory(NewRelationship parentCategory) {
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

    public ReferenceDataSetRelationships categories(List<NewRelationship> categories) {
        this.categories = categories;
        return this;
    }

    public ReferenceDataSetRelationships addCategoriesItem(NewRelationship categoriesItem) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ReferenceDataSetRelationships referenceDataSetRelationships = (ReferenceDataSetRelationships)o;
        return Objects.equals(this.terms, referenceDataSetRelationships.terms) &&
                Objects.equals(this.classifications, referenceDataSetRelationships.classifications) &&
                Objects.equals(this.parentCategory, referenceDataSetRelationships.parentCategory) &&
                Objects.equals(this.categories, referenceDataSetRelationships.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terms, classifications, parentCategory, categories);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReferenceDataSetRelationships {\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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
