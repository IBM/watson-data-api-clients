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
 * Response of get job run log
 */
public class LogsResponse {

    private List<String> results = null;
    private Integer totalCount;

    public LogsResponse results(List<String> results) {
        this.results = results;
        return this;
    }

    public LogsResponse addResultsItem(String resultsItem) {
        if (this.results == null) {
            this.results = new ArrayList<>();
        }
        this.results.add(resultsItem);
        return this;
    }

    /**
     * Array of log string split by line
     * @return results
     **/
    @javax.annotation.Nullable
    @JsonProperty("results")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getResults() { return results; }
    public void setResults(List<String> results) { this.results = results; }

    public LogsResponse totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * Total number of lines available
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
        LogsResponse logsResponse = (LogsResponse)o;
        return Objects.equals(this.results, logsResponse.results) &&
                Objects.equals(this.totalCount, logsResponse.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, totalCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LogsResponse {\n");
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
