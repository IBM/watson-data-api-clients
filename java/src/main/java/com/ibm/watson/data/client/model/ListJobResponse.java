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
 * ListJobResponse
 */
public class ListJobResponse {

    private Long totalRows;
    private List<Job> results = null;

    public ListJobResponse totalRows(Long totalRows) {
        this.totalRows = totalRows;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("total_rows")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalRows() { return totalRows; }
    public void setTotalRows(Long totalRows) { this.totalRows = totalRows; }

    public ListJobResponse results(List<Job> results) {
        this.results = results;
        return this;
    }

    public ListJobResponse addResultsItem(Job resultsItem) {
        if (this.results == null) {
            this.results = new ArrayList<>();
        }
        this.results.add(resultsItem);
        return this;
    }

    /**
     * Array of all jobs.
     * @return results
     **/
    @javax.annotation.Nullable
    @JsonProperty("results")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Job> getResults() { return results; }
    public void setResults(List<Job> results) { this.results = results; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ListJobResponse listJobResponse = (ListJobResponse)o;
        return Objects.equals(this.totalRows, listJobResponse.totalRows) &&
                Objects.equals(this.results, listJobResponse.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListJobResponse {\n");
        sb.append("    totalRows: ").append(toIndentedString(totalRows)).append("\n");
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
