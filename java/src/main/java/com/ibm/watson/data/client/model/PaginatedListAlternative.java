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
 * PaginatedListAlternative -- basically the same as PaginatedList, but for some reason some
 * such lists use 'total_count' instead of 'count' and 'previous' instead of 'prev'.
 */
public class PaginatedListAlternative {

    private Integer limit;
    private Long totalCount;
    private HrefModel first;
    private HrefModel next;
    private Integer offset;
    private HrefModel last;
    private HrefModel previous;

    public PaginatedListAlternative limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * The limit parameter passed to the list / search method.
     * @return limit
     **/
    @javax.annotation.Nullable
    @JsonProperty("limit")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }

    public PaginatedListAlternative totalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * The total number of items that matches the given criteria.
     * @return count
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalCount() { return totalCount; }
    public void setTotalCount(Long totalCount) { this.totalCount = totalCount; }

    public PaginatedListAlternative first(HrefModel first) {
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

    public PaginatedListAlternative next(HrefModel next) {
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

    public PaginatedListAlternative offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Offset used in the list / search method.
     * @return offset
     **/
    @javax.annotation.Nullable
    @JsonProperty("offset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public PaginatedListAlternative last(HrefModel last) {
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

    public PaginatedListAlternative previous(HrefModel previous) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginatedListAlternative that = (PaginatedListAlternative)o;
        return Objects.equals(this.limit, that.limit) &&
                Objects.equals(this.totalCount, that.totalCount) &&
                Objects.equals(this.first, that.first) &&
                Objects.equals(this.next, that.next) &&
                Objects.equals(this.offset, that.offset) &&
                Objects.equals(this.last, that.last) &&
                Objects.equals(this.previous, that.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, totalCount, first, next, offset, last, previous);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginatedListAlternative {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    count: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
