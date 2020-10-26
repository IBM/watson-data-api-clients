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
 * List of results for a find assets by type request
 */
public class FindAssetsResponse {

    private Integer totalRows;
    private List<MetadataAssetResult> results;

    public FindAssetsResponse totalRows(Integer totalRows) {
        this.totalRows = totalRows;
        return this;
    }

    /**
     * Get total rows
     * @return totalRows
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_rows")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalRows() { return totalRows; }
    public void setTotalRows(Integer totalRows) { this.totalRows = totalRows; }

    public FindAssetsResponse results(List<MetadataAssetResult> results) {
        this.results = results;
        return this;
    }

    /**
     * Get results
     * @return results
     **/
    @javax.annotation.Nullable
    @JsonProperty("results")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MetadataAssetResult> getResults() { return results; }
    public void setResults(List<MetadataAssetResult> results) { this.results = results; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FindAssetsResponse findAssetsResponse = (FindAssetsResponse)o;
        return Objects.equals(this.totalRows, findAssetsResponse.totalRows) &&
                Objects.equals(this.results, findAssetsResponse.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRows, results);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FindAssetsResponse {\n");
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
