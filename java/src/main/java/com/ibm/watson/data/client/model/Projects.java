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
 * A list of projects.
 */
public class Projects {

    private List<Project> resources = null;
    private Integer totalResults;

    public Projects resources(List<Project> resources) {
        this.resources = resources;
        return this;
    }

    public Projects addResourcesItem(Project resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * A list of projects returned in the query results.
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Project> getResources() { return resources; }
    public void setResources(List<Project> resources) { this.resources = resources; }

    public Projects totalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * The total number of project returned in the query results.
     * minimum: 0
     * @return totalResults
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_results")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalResults() { return totalResults; }
    public void setTotalResults(Integer totalResults) { this.totalResults = totalResults; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Projects projects = (Projects)o;
        return Objects.equals(this.resources, projects.resources) &&
                Objects.equals(this.totalResults, projects.totalResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources, totalResults);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Projects {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
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
