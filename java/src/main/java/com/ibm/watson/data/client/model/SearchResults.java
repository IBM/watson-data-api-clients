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
 * SearchResults
 */
public class SearchResults {

    private Long size;
    private List<SearchResultRow> rows = null;
    private Object aggregations;

    public SearchResults size(Long size) {
        this.size = size;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }

    public SearchResults rows(List<SearchResultRow> rows) {
        this.rows = rows;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("rows")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<SearchResultRow> getRows() { return rows; }
    public void setRows(List<SearchResultRow> rows) { this.rows = rows; }

    public SearchResults aggregations(Object aggregations) {
        this.aggregations = aggregations;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("aggregations")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getAggregations() { return aggregations; }
    public void setAggregations(Object aggregations) { this.aggregations = aggregations; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SearchResults that = (SearchResults)o;
        return Objects.equals(this.size, that.size) &&
                Objects.equals(this.rows, that.rows) &&
                Objects.equals(this.aggregations, that.aggregations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, rows, aggregations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchResults {\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
        sb.append("    aggregations: ").append(toIndentedString(aggregations)).append("\n");
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
