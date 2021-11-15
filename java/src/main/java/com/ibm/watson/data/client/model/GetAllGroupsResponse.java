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
 * GetAllGroupsResponse
 */
public class GetAllGroupsResponse extends BaseResponse {

    private List<ExtendedGroupInfo> results = null;

    public GetAllGroupsResponse results(List<ExtendedGroupInfo> results) {
        this.results = results;
        return this;
    }

    public GetAllGroupsResponse addResultsItem(ExtendedGroupInfo resultsItem) {
        if (this.results == null) {
            this.results = new ArrayList<>();
        }
        this.results.add(resultsItem);
        return this;
    }

    /**
     * Get results
     * @return results
     **/
    @javax.annotation.Nullable
    @JsonProperty("results")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ExtendedGroupInfo> getResults() { return results; }
    public void setResults(List<ExtendedGroupInfo> results) { this.results = results; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetAllGroupsResponse that = (GetAllGroupsResponse)o;
        return super.equals(o) &&
                Objects.equals(this.results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), results);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAllGroupsResponse {\n");
        super.toString(sb);
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
