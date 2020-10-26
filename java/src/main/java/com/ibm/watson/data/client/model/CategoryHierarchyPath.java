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
 * CategoryHierarchyPath
 */
public class CategoryHierarchyPath {

    private String categoryId;
    private List<CategoryHierarchyRecord> categoryHierarchyPath = null;

    public CategoryHierarchyPath categoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    /**
     * The artifact ID of the category.
     * @return categoryId
     **/
    @javax.annotation.Nullable
    @JsonProperty("category_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public CategoryHierarchyPath categoryHierarchyPath(List<CategoryHierarchyRecord> categoryHierarchyPath) {
        this.categoryHierarchyPath = categoryHierarchyPath;
        return this;
    }

    public CategoryHierarchyPath addCategoryHierarchyPathItem(CategoryHierarchyRecord categoryHierarchyPathItem) {
        if (this.categoryHierarchyPath == null) {
            this.categoryHierarchyPath = new ArrayList<>();
        }
        this.categoryHierarchyPath.add(categoryHierarchyPathItem);
        return this;
    }

    /**
     * Get categoryHierarchyPath
     * @return categoryHierarchyPath
     **/
    @javax.annotation.Nullable
    @JsonProperty("category_hierarchy_path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CategoryHierarchyRecord> getCategoryHierarchyPath() { return categoryHierarchyPath; }
    public void setCategoryHierarchyPath(List<CategoryHierarchyRecord> categoryHierarchyPath) { this.categoryHierarchyPath = categoryHierarchyPath; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CategoryHierarchyPath categoryHierarchyPath = (CategoryHierarchyPath)o;
        return Objects.equals(this.categoryId, categoryHierarchyPath.categoryId) &&
                Objects.equals(this.categoryHierarchyPath, categoryHierarchyPath.categoryHierarchyPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryHierarchyPath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CategoryHierarchyPath {\n");
        sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
        sb.append("    categoryHierarchyPath: ").append(toIndentedString(categoryHierarchyPath)).append("\n");
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
