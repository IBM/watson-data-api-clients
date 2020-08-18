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
 * PaginatedRelationshipsList
 */
public class PaginatedRelationshipsList extends PaginatedList {

    private List<RelationshipRelationshipEntity> resources = null;

    public PaginatedRelationshipsList resources(List<RelationshipRelationshipEntity> resources) {
        this.resources = resources;
        return this;
    }

    public PaginatedRelationshipsList addResourcesItem(RelationshipRelationshipEntity resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * Results of the list / search.
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipRelationshipEntity> getResources() { return resources; }
    public void setResources(List<RelationshipRelationshipEntity> resources) { this.resources = resources; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginatedRelationshipsList paginatedRelationshipsList = (PaginatedRelationshipsList)o;
        return super.equals(o) &&
                Objects.equals(this.resources, paginatedRelationshipsList.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginatedRelationshipsList {\n");
        toString(sb);
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
