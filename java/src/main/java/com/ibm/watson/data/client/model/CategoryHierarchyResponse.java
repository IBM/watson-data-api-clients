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
 * CategoryHierarchyResponse
 */
public class CategoryHierarchyResponse {

    private List<CategoryHierarchyPath> categoryHierarchyPaths = null;

    public CategoryHierarchyResponse categoryHierarchyPaths(List<CategoryHierarchyPath> categoryHierarchyPaths) {
        this.categoryHierarchyPaths = categoryHierarchyPaths;
        return this;
    }

    public CategoryHierarchyResponse addCategoryHierarchyPathsItem(CategoryHierarchyPath categoryHierarchyPathsItem) {
        if (this.categoryHierarchyPaths == null) {
            this.categoryHierarchyPaths = new ArrayList<>();
        }
        this.categoryHierarchyPaths.add(categoryHierarchyPathsItem);
        return this;
    }

    /**
     * IDs and names of categories in category hierarchy path for each category id
     * @return categoryHierarchyPaths
     **/
    @javax.annotation.Nullable
    @JsonProperty("category_hierarchy_paths")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CategoryHierarchyPath> getCategoryHierarchyPaths() { return categoryHierarchyPaths; }
    public void setCategoryHierarchyPaths(List<CategoryHierarchyPath> categoryHierarchyPaths) { this.categoryHierarchyPaths = categoryHierarchyPaths; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CategoryHierarchyResponse categoryHierarchyResponse = (CategoryHierarchyResponse)o;
        return Objects.equals(this.categoryHierarchyPaths, categoryHierarchyResponse.categoryHierarchyPaths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryHierarchyPaths);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CategoryHierarchyResponse {\n");
        sb.append("    categoryHierarchyPaths: ").append(toIndentedString(categoryHierarchyPaths)).append("\n");
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
