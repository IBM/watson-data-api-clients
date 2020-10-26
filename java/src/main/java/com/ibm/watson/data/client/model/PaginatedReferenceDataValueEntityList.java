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
 * PaginatedReferenceDataValueEntityList
 */
public class PaginatedReferenceDataValueEntityList extends PaginatedList {

    private List<ResponseReferenceDataValueEntity> resources = null;

    public PaginatedReferenceDataValueEntityList resources(List<ResponseReferenceDataValueEntity> resources) {
        this.resources = resources;
        return this;
    }

    public PaginatedReferenceDataValueEntityList addResourcesItem(ResponseReferenceDataValueEntity resourcesItem) {
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
    public List<ResponseReferenceDataValueEntity> getResources() { return resources; }
    public void setResources(List<ResponseReferenceDataValueEntity> resources) { this.resources = resources; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PaginatedReferenceDataValueEntityList paginatedReferenceDataValueEntityList = (PaginatedReferenceDataValueEntityList)o;
        return super.equals(o) &&
                Objects.equals(this.resources, paginatedReferenceDataValueEntityList.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginatedReferenceDataValueEntityList {\n");
        super.toString(sb);
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
