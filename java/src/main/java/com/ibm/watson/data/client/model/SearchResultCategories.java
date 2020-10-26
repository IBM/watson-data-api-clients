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
import java.util.List;
import java.util.Objects;

/**
 * SearchResultCategories
 */
public class SearchResultCategories {

    private List<String> secondaryCategoryIds;
    private Long lastUpdatedAt;
    private List<String> secondaryCategoryGlobalIds;
    private String primaryCategoryGlobalId;
    private String primaryCategoryId;
    private String primaryCategoryName;
    private List<String> secondaryCategoryNames;

    public SearchResultCategories secondaryCategoryIds(List<String> secondaryCategoryIds) {
        this.secondaryCategoryIds = secondaryCategoryIds;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("secondary_category_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSecondaryCategoryIds() { return secondaryCategoryIds; }
    public void setSecondaryCategoryIds(List<String> secondaryCategoryIds) { this.secondaryCategoryIds = secondaryCategoryIds; }

    public SearchResultCategories lastUpdatedAt(Long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("last_updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Long lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }

    public SearchResultCategories secondaryCategoryGlobalIds(List<String> secondaryCategoryGlobalIds) {
        this.secondaryCategoryGlobalIds = secondaryCategoryGlobalIds;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("secondary_category_global_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSecondaryCategoryGlobalIds() { return secondaryCategoryGlobalIds; }
    public void setSecondaryCategoryGlobalIds(List<String> secondaryCategoryGlobalIds) { this.secondaryCategoryGlobalIds = secondaryCategoryGlobalIds; }

    public SearchResultCategories primaryCategoryGlobalId(String primaryCategoryGlobalId) {
        this.primaryCategoryGlobalId = primaryCategoryGlobalId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("primary_category_global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPrimaryCategoryGlobalId() { return primaryCategoryGlobalId; }
    public void setPrimaryCategoryGlobalId(String primaryCategoryGlobalId) { this.primaryCategoryGlobalId = primaryCategoryGlobalId; }

    public SearchResultCategories primaryCategoryId(String primaryCategoryId) {
        this.primaryCategoryId = primaryCategoryId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("primary_category_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPrimaryCategoryId() { return primaryCategoryId; }
    public void setPrimaryCategoryId(String primaryCategoryId) { this.primaryCategoryId = primaryCategoryId; }

    public SearchResultCategories primaryCategoryName(String primaryCategoryName) {
        this.primaryCategoryName = primaryCategoryName;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("primary_category_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPrimaryCategoryName() { return primaryCategoryName; }
    public void setPrimaryCategoryName(String primaryCategoryName) { this.primaryCategoryName = primaryCategoryName; }

    public SearchResultCategories secondaryCategoryNames(List<String> secondaryCategoryNames) {
        this.secondaryCategoryNames = secondaryCategoryNames;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("secondary_category_names")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSecondaryCategoryNames() { return secondaryCategoryNames; }
    public void setSecondaryCategoryNames(List<String> secondaryCategoryNames) { this.secondaryCategoryNames = secondaryCategoryNames; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SearchResultCategories that = (SearchResultCategories)o;
        return Objects.equals(this.secondaryCategoryIds, that.secondaryCategoryIds) &&
                Objects.equals(this.lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(this.secondaryCategoryGlobalIds, that.secondaryCategoryGlobalIds) &&
                Objects.equals(this.primaryCategoryGlobalId, that.primaryCategoryGlobalId) &&
                Objects.equals(this.primaryCategoryId, that.primaryCategoryId) &&
                Objects.equals(this.primaryCategoryName, that.primaryCategoryName) &&
                Objects.equals(this.secondaryCategoryNames, that.secondaryCategoryNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondaryCategoryIds, lastUpdatedAt, secondaryCategoryGlobalIds,
                primaryCategoryGlobalId, primaryCategoryId, primaryCategoryName, secondaryCategoryNames);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchResultCategories {\n");
        sb.append("    secondaryCategoryIds: ").append(toIndentedString(secondaryCategoryIds)).append("\n");
        sb.append("    lastUpdatedAt: ").append(toIndentedString(lastUpdatedAt)).append("\n");
        sb.append("    secondaryCategoryGlobalIds: ").append(toIndentedString(secondaryCategoryGlobalIds)).append("\n");
        sb.append("    primaryCategoryGlobalId: ").append(toIndentedString(primaryCategoryGlobalId)).append("\n");
        sb.append("    primaryCategoryId: ").append(toIndentedString(primaryCategoryId)).append("\n");
        sb.append("    primaryCategoryName: ").append(toIndentedString(primaryCategoryName)).append("\n");
        sb.append("    secondaryCategoryNames: ").append(toIndentedString(secondaryCategoryNames)).append("\n");
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
