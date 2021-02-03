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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * RoleAssignmentResponse
 */
public class RoleAssignmentResponse {

    private List<RoleAssignment> collaborators = null;
    private Integer totalResults;

    public RoleAssignmentResponse collaborators(List<RoleAssignment> collaborators) {
        this.collaborators = collaborators;
        return this;
    }

    public RoleAssignmentResponse addCollaboratorsItem(RoleAssignment collaboratorsItem) {
        if (this.collaborators == null) {
            this.collaborators = new ArrayList<>();
        }
        this.collaborators.add(collaboratorsItem);
        return this;
    }

    /**
     * Category permission list for given category id
     * @return collaborators
     **/
    @javax.annotation.Nullable
    @JsonProperty("collaborators")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RoleAssignment> getCollaborators() { return collaborators; }
    public void setCollaborators(List<RoleAssignment> collaborators) { this.collaborators = collaborators; }

    public RoleAssignmentResponse totalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * Number of category permissions
     * @return totalResults
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_results")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalResults() { return totalResults; }
    public void setTotalResults(Integer totalResults) { this.totalResults = totalResults; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RoleAssignmentResponse that = (RoleAssignmentResponse) o;
        return Objects.equals(this.collaborators, that.collaborators) &&
                Objects.equals(this.totalResults, that.totalResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collaborators, totalResults);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RoleAssignmentResponse {\n");
        sb.append("    collaborators: ").append(toIndentedString(collaborators)).append("\n");
        sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
