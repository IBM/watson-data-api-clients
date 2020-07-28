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
 * A page from a collection of data source types.
 */
public class DatasourceTypeCollection {

    private List<DatasourceType> resources = null;
    private HrefModel first;
    private HrefModel prev;
    private HrefModel next;
    private HrefModel last;
    private Integer offset;
    private Integer totalCount;

    public DatasourceTypeCollection resources(List<DatasourceType> resources) {
        this.resources = resources;
        return this;
    }

    public DatasourceTypeCollection addResourcesItem(DatasourceType resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * List of data source types
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceType> getResources() { return resources; }
    public void setResources(List<DatasourceType> resources) { this.resources = resources; }

    public DatasourceTypeCollection first(HrefModel first) {
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

    public DatasourceTypeCollection prev(HrefModel prev) {
        this.prev = prev;
        return this;
    }

    /**
     * Get prev
     * @return prev
     **/
    @javax.annotation.Nullable
    @JsonProperty("prev")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getPrev() { return prev; }
    public void setPrev(HrefModel prev) { this.prev = prev; }

    public DatasourceTypeCollection next(HrefModel next) {
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

    public DatasourceTypeCollection last(HrefModel last) {
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

    public DatasourceTypeCollection offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * The number of assets skipped before this page.
     * @return offset
     **/
    @javax.annotation.Nullable
    @JsonProperty("offset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public DatasourceTypeCollection totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * The total number of assets available.
     * @return totalCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeCollection datasourceTypeCollection = (DatasourceTypeCollection)o;
        return Objects.equals(this.resources, datasourceTypeCollection.resources) &&
                Objects.equals(this.first, datasourceTypeCollection.first) &&
                Objects.equals(this.prev, datasourceTypeCollection.prev) &&
                Objects.equals(this.next, datasourceTypeCollection.next) &&
                Objects.equals(this.last, datasourceTypeCollection.last) &&
                Objects.equals(this.offset, datasourceTypeCollection.offset) &&
                Objects.equals(this.totalCount, datasourceTypeCollection.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources, first, prev, next, last, offset, totalCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeCollection {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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
