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
 * PageinatedAssetFileListResponse
 */
public class PaginatedAssetFileListResponse {

    private Integer totalCount;
    private Integer limit;
    private Integer offset;
    private HrefModel first;
    private HrefModel last;
    private HrefModel next;
    private HrefModel previous;
    private List<AssetFileMetadata> resources = null;

    public PaginatedAssetFileListResponse totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * The total number of resource for the query.
     * @return totalCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    public PaginatedAssetFileListResponse limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * The limit used for the request.
     * @return limit
     **/
    @javax.annotation.Nullable
    @JsonProperty("limit")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }

    public PaginatedAssetFileListResponse offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * The offset used for the request.
     * @return offset
     **/
    @javax.annotation.Nullable
    @JsonProperty("offset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public PaginatedAssetFileListResponse first(HrefModel first) {
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
    public HrefModel getFirst() { return first; }
    public void setFirst(HrefModel first) { this.first = first; }

    public PaginatedAssetFileListResponse last(HrefModel last) {
        this.last = last;
        return this;
    }

    /**
     * Get last
     * @return last
     **/
    @javax.annotation.Nullable
    @JsonProperty("last")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getLast() { return last; }
    public void setLast(HrefModel last) { this.last = last; }

    public PaginatedAssetFileListResponse next(HrefModel next) {
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
    public HrefModel getNext() { return next; }
    public void setNext(HrefModel next) { this.next = next; }

    public PaginatedAssetFileListResponse previous(HrefModel previous) {
        this.previous = previous;
        return this;
    }

    /**
     * Get previous
     * @return previous
     **/
    @javax.annotation.Nullable
    @JsonProperty("previous")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getPrevious() { return previous; }
    public void setPrevious(HrefModel previous) { this.previous = previous; }

    public PaginatedAssetFileListResponse resources(List<AssetFileMetadata> resources) {
        this.resources = resources;
        return this;
    }

    public PaginatedAssetFileListResponse addResourcesItem(AssetFileMetadata resourcesItem) {
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
    public List<AssetFileMetadata> getResources() { return resources; }
    public void setResources(List<AssetFileMetadata> resources) { this.resources = resources; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginatedAssetFileListResponse paginatedAssetFileListResponse = (PaginatedAssetFileListResponse)o;
        return Objects.equals(this.totalCount, paginatedAssetFileListResponse.totalCount) &&
                Objects.equals(this.limit, paginatedAssetFileListResponse.limit) &&
                Objects.equals(this.offset, paginatedAssetFileListResponse.offset) &&
                Objects.equals(this.first, paginatedAssetFileListResponse.first) &&
                Objects.equals(this.last, paginatedAssetFileListResponse.last) &&
                Objects.equals(this.next, paginatedAssetFileListResponse.next) &&
                Objects.equals(this.previous, paginatedAssetFileListResponse.previous) &&
                Objects.equals(this.resources, paginatedAssetFileListResponse.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCount, limit, offset, first, last, next, previous,
                resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PageinatedAssetFileListResponse {\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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
