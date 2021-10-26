/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Response for the /v3/enforcement/governance_types API
 */
public class V3PolicyGovernanceTypeListResponse {

    private List<V3PolicyGovernanceTypeListResponseResource> resources = new ArrayList<>();

    public V3PolicyGovernanceTypeListResponse resources(List<V3PolicyGovernanceTypeListResponseResource> resources) {
        this.resources = resources;
        return this;
    }

    public V3PolicyGovernanceTypeListResponse addResourcesItem(V3PolicyGovernanceTypeListResponseResource resourcesItem) {
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * list of governance types
     * @return resources
     **/
    @javax.annotation.Nonnull
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<V3PolicyGovernanceTypeListResponseResource> getResources() {
        return resources;
    }
    public void setResources(List<V3PolicyGovernanceTypeListResponseResource> resources) {
        this.resources = resources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3PolicyGovernanceTypeListResponse v3PolicyGovernanceTypeListResponse = (V3PolicyGovernanceTypeListResponse) o;
        return Objects.equals(this.resources, v3PolicyGovernanceTypeListResponse.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyGovernanceTypeListResponse {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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

