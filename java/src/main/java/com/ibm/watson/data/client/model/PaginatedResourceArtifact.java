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
 * PaginatedResourceArtifact
 */
public class PaginatedResourceArtifact {

    private HrefModel first;
    private HrefModel last;
    private Integer limit;
    private HrefModel next;
    private Integer offset;
    private HrefModel previous;
    private List<Artifact> resources = null;
    private Long totalCount;

    public PaginatedResourceArtifact first(HrefModel first) {
        this.first = first;
        return this;
    }

    /**
     * Get first
     * @return first
     **/
    @JsonProperty("first")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public HrefModel getFirst() { return first; }
    public void setFirst(HrefModel first) { this.first = first; }

    public PaginatedResourceArtifact last(HrefModel last) {
        this.last = last;
        return this;
    }

    /**
     * Get last
     * @return last
     **/
    @JsonProperty("last")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public HrefModel getLast() { return last; }
    public void setLast(HrefModel last) { this.last = last; }

    public PaginatedResourceArtifact limit(Integer limit) {
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

    public PaginatedResourceArtifact next(HrefModel next) {
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

    public PaginatedResourceArtifact offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Get offset
     * @return offset
     **/
    @javax.annotation.Nullable
    @JsonProperty("offset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public PaginatedResourceArtifact previous(HrefModel previous) {
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

    public PaginatedResourceArtifact resources(List<Artifact> resources) {
        this.resources = resources;
        return this;
    }

    public PaginatedResourceArtifact addResourcesItem(Artifact resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * resources of the page that this object represents
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Artifact> getResources() { return resources; }
    public void setResources(List<Artifact> resources) { this.resources = resources; }

    public PaginatedResourceArtifact totalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * Get totalCount
     * @return totalCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalCount() { return totalCount; }
    public void setTotalCount(Long totalCount) { this.totalCount = totalCount; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginatedResourceArtifact paginatedResourceArtifact = (PaginatedResourceArtifact)o;
        return Objects.equals(this.first, paginatedResourceArtifact.first) &&
                Objects.equals(this.last, paginatedResourceArtifact.last) &&
                Objects.equals(this.limit, paginatedResourceArtifact.limit) &&
                Objects.equals(this.next, paginatedResourceArtifact.next) &&
                Objects.equals(this.offset, paginatedResourceArtifact.offset) &&
                Objects.equals(this.previous, paginatedResourceArtifact.previous) &&
                Objects.equals(this.resources, paginatedResourceArtifact.resources) &&
                Objects.equals(this.totalCount, paginatedResourceArtifact.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, limit, next, offset, previous, resources,
                totalCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginatedResourceArtifact {\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
        sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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
