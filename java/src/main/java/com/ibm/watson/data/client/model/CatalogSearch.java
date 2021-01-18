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
import java.util.Map;
import java.util.Objects;

/**
 * Catalog Search Model
 */
public class CatalogSearch {

    private String query;
    private Integer limit;
    private List<String> counts = null;
    private List<Map<String, List<String>>> drilldown = null;
    private String sort;
    private String include;

    public CatalogSearch query(String query) {
        this.query = query;
        return this;
    }

    /**
     * Lucene query
     * @return query
     **/
    @JsonProperty("query")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public CatalogSearch limit(Integer limit) {
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

    public CatalogSearch counts(List<String> counts) {
        this.counts = counts;
        return this;
    }

    public CatalogSearch addCountsItem(String countsItem) {
        if (this.counts == null) {
            this.counts = new ArrayList<>();
        }
        this.counts.add(countsItem);
        return this;
    }

    /**
     * Get counts
     * @return counts
     **/
    @javax.annotation.Nullable
    @JsonProperty("counts")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getCounts() { return counts; }
    public void setCounts(List<String> counts) { this.counts = counts; }

    public CatalogSearch drilldown(List<Map<String, List<String>>> drilldown) {
        this.drilldown = drilldown;
        return this;
    }

    public CatalogSearch addDrilldownItem(Map<String, List<String>> drilldownItem) {
        if (this.drilldown == null) {
            this.drilldown = new ArrayList<>();
        }
        this.drilldown.add(drilldownItem);
        return this;
    }

    /**
     * Get drilldown
     * @return drilldown
     **/
    @javax.annotation.Nullable
    @JsonProperty("drilldown")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Map<String, List<String>>> getDrilldown() { return drilldown; }
    public void setDrilldown(List<Map<String, List<String>>> drilldown) { this.drilldown = drilldown; }

    public CatalogSearch sort(String sort) {
        this.sort = sort;
        return this;
    }

    /**
     * Sort order for the query
     * @return sort
     **/
    @javax.annotation.Nullable
    @JsonProperty("sort")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }

    public CatalogSearch include(String include) {
        this.include = include;
        return this;
    }

    /**
     * entity
     * @return include
     **/
    @javax.annotation.Nullable
    @JsonProperty("include")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getInclude() { return include; }
    public void setInclude(String include) { this.include = include; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CatalogSearch catalogSearch = (CatalogSearch)o;
        return Objects.equals(this.query, catalogSearch.query) &&
                Objects.equals(this.limit, catalogSearch.limit) &&
                Objects.equals(this.counts, catalogSearch.counts) &&
                Objects.equals(this.drilldown, catalogSearch.drilldown) &&
                Objects.equals(this.sort, catalogSearch.sort) &&
                Objects.equals(this.include, catalogSearch.include);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, limit, counts, drilldown, sort, include);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CatalogSearch {\n");
        sb.append("    query: ").append(toIndentedString(query)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    counts: ").append(toIndentedString(counts)).append("\n");
        sb.append("    drilldown: ").append(toIndentedString(drilldown)).append("\n");
        sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
        sb.append("    include: ").append(toIndentedString(include)).append("\n");
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
