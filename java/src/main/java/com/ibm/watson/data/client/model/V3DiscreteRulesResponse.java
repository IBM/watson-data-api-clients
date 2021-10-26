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
 * Response for the /v3/enforcement/governed_items/discrete/{governanceTypeName}/{itemId} API
 */
public class V3DiscreteRulesResponse {

    private List<V3DiscreteRulesResponseResource> resources = new ArrayList<>();
    private V3DiscreteRuleMetadataEntity metadata;

    public V3DiscreteRulesResponse resources(List<V3DiscreteRulesResponseResource> resources) {
        this.resources = resources;
        return this;
    }

    public V3DiscreteRulesResponse addResourcesItem(V3DiscreteRulesResponseResource resourcesItem) {
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * list of discrete rules
     * @return resources
     **/
    @javax.annotation.Nonnull
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<V3DiscreteRulesResponseResource> getResources() {
        return resources;
    }
    public void setResources(List<V3DiscreteRulesResponseResource> resources) {
        this.resources = resources;
    }

    /**
     * metadata of the column that was targeted by the discrete rule
     * @return metadata
     */
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public V3DiscreteRuleMetadataEntity getMetadata() {
        return metadata;
    }
    public void setMetadata(V3DiscreteRuleMetadataEntity metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3DiscreteRulesResponse v3DiscreteRulesResponse = (V3DiscreteRulesResponse) o;
        return Objects.equals(this.resources, v3DiscreteRulesResponse.resources) &&
                Objects.equals(this.metadata, v3DiscreteRulesResponse.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3DiscreteRulesResponse {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
