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
 * CreateRelationshipResponseResource
 */
public class CreateRelationshipResponseResource extends GlossaryResource {

    private List<RelationshipCreateResponseIds> terms = null;
    private List<RelationshipCreateResponseIds> classifications = null;
    private List<RelationshipCreateResponseIds> categories = null;
    private RelationshipCreateResponseIds parentCategory;
    private List<RelationshipCreateResponseIds> child = null;
    private List<RelationshipCreateResponseIds> parent = null;

    public CreateRelationshipResponseResource terms(List<RelationshipCreateResponseIds> terms) {
        this.terms = terms;
        return this;
    }

    public CreateRelationshipResponseResource addTermsItem(RelationshipCreateResponseIds termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * term relatiosnhips added
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipCreateResponseIds> getTerms() { return terms; }
    public void setTerms(List<RelationshipCreateResponseIds> terms) { this.terms = terms; }

    public CreateRelationshipResponseResource classifications(List<RelationshipCreateResponseIds> classifications) {
        this.classifications = classifications;
        return this;
    }

    public CreateRelationshipResponseResource addClassificationsItem(RelationshipCreateResponseIds classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * classification relatiosnhips added
     * @return classifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipCreateResponseIds> getClassifications() { return classifications; }
    public void setClassifications(List<RelationshipCreateResponseIds> classifications) { this.classifications = classifications; }

    public CreateRelationshipResponseResource categories(List<RelationshipCreateResponseIds> categories) {
        this.categories = categories;
        return this;
    }

    public CreateRelationshipResponseResource addCategoriesItem(RelationshipCreateResponseIds categoriesItem) {
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(categoriesItem);
        return this;
    }

    /**
     * secondary category relatiosnhips added
     * @return categories
     **/
    @javax.annotation.Nullable
    @JsonProperty("categories")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipCreateResponseIds> getCategories() { return categories; }
    public void setCategories(List<RelationshipCreateResponseIds> categories) { this.categories = categories; }

    public CreateRelationshipResponseResource parentCategory(RelationshipCreateResponseIds parentCategory) {
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
    public RelationshipCreateResponseIds getParentCategory() { return parentCategory; }
    public void setParentCategory(RelationshipCreateResponseIds parentCategory) { this.parentCategory = parentCategory; }

    public CreateRelationshipResponseResource child(List<RelationshipCreateResponseIds> child) {
        this.child = child;
        return this;
    }

    public CreateRelationshipResponseResource addChildItem(RelationshipCreateResponseIds childItem) {
        if (this.child == null) {
            this.child = new ArrayList<>();
        }
        this.child.add(childItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("child")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipCreateResponseIds> getChild() { return child; }
    public void setChild(List<RelationshipCreateResponseIds> child) { this.child = child; }

    public CreateRelationshipResponseResource parent(List<RelationshipCreateResponseIds> parent) {
        this.parent = parent;
        return this;
    }

    public CreateRelationshipResponseResource addParentItem(RelationshipCreateResponseIds parentItem) {
        if (this.parent == null) {
            this.parent = new ArrayList<>();
        }
        this.parent.add(parentItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("parent")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipCreateResponseIds> getParent() { return parent; }
    public void setParent(List<RelationshipCreateResponseIds> parent) { this.parent = parent; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateRelationshipResponseResource createRelationshipResponseResource = (CreateRelationshipResponseResource)o;
        return super.equals(o) &&
                Objects.equals(this.terms, createRelationshipResponseResource.terms) &&
                Objects.equals(this.classifications, createRelationshipResponseResource.classifications) &&
                Objects.equals(this.categories, createRelationshipResponseResource.categories) &&
                Objects.equals(this.parentCategory, createRelationshipResponseResource.parentCategory) &&
                Objects.equals(this.child, createRelationshipResponseResource.child) &&
                Objects.equals(this.parent, createRelationshipResponseResource.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), terms, classifications, categories,
                parentCategory, child, parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateRelationshipResponseResource {\n");
        super.toString(sb);
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    child: ").append(toIndentedString(child)).append("\n");
        sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
