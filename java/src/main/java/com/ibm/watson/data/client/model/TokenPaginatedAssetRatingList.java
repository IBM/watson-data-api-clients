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
 * TokenPaginatedAssetRatingList
 */
public class TokenPaginatedAssetRatingList {

    private List<AssetRating> resources = null;
    private Integer limit;
    private Long count;
    private Link first;
    private Link next;

    public TokenPaginatedAssetRatingList resources(List<AssetRating> resources) {
        this.resources = resources;
        return this;
    }

    public TokenPaginatedAssetRatingList addResourcesItem(AssetRating resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * Get resources
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AssetRating> getResources() { return resources; }
    public void setResources(List<AssetRating> resources) { this.resources = resources; }

    public TokenPaginatedAssetRatingList limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Get limit
     * @return limit
     **/
    @javax.annotation.Nullable
    @JsonProperty("limit")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }

    public TokenPaginatedAssetRatingList count(Long count) {
        this.count = count;
        return this;
    }

    /**
     * Get count
     * @return count
     **/
    @javax.annotation.Nullable
    @JsonProperty("count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }

    public TokenPaginatedAssetRatingList first(Link first) {
        this.first = first;
        return this;
    }

    /**
     * Get first
     * @return first
     **/
    @javax.annotation.Nullable
    @JsonProperty("first")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Link getFirst() { return first; }
    public void setFirst(Link first) { this.first = first; }

    public TokenPaginatedAssetRatingList next(Link next) {
        this.next = next;
        return this;
    }

    /**
     * Get next
     * @return next
     **/
    @javax.annotation.Nullable
    @JsonProperty("next")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Link getNext() { return next; }
    public void setNext(Link next) { this.next = next; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TokenPaginatedAssetRatingList tokenPaginatedAssetRatingList = (TokenPaginatedAssetRatingList)o;
        return Objects.equals(this.resources,
                tokenPaginatedAssetRatingList.resources) &&
                Objects.equals(this.limit, tokenPaginatedAssetRatingList.limit) &&
                Objects.equals(this.count, tokenPaginatedAssetRatingList.count) &&
                Objects.equals(this.first, tokenPaginatedAssetRatingList.first) &&
                Objects.equals(this.next, tokenPaginatedAssetRatingList.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources, limit, count, first, next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenPaginatedAssetRatingList {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
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
