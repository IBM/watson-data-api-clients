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
 * The definition of a Discovery asset type.
 */
public class DiscoveryAssetType {

    private String name;
    private String label;
    private List<String> nextLevelFilters = null;

    public DiscoveryAssetType name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the asset type.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DiscoveryAssetType label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The label of the asset type.
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty("label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public DiscoveryAssetType nextLevelFilters(List<String> nextLevelFilters) {
        this.nextLevelFilters = nextLevelFilters;
        return this;
    }

    public DiscoveryAssetType addNextLevelFiltersItem(String nextLevelFiltersItem) {
        if (this.nextLevelFilters == null) {
            this.nextLevelFilters = new ArrayList<>();
        }
        this.nextLevelFilters.add(nextLevelFiltersItem);
        return this;
    }

    /**
     * The filters which can be used to discover the next level of assets.
     * @return nextLevelFilters
     **/
    @javax.annotation.Nullable
    @JsonProperty("next_level_filters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getNextLevelFilters() { return nextLevelFilters; }
    public void setNextLevelFilters(List<String> nextLevelFilters) { this.nextLevelFilters = nextLevelFilters; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveryAssetType discoveryAssetType = (DiscoveryAssetType)o;
        return Objects.equals(this.name, discoveryAssetType.name) &&
                Objects.equals(this.label, discoveryAssetType.label) &&
                Objects.equals(this.nextLevelFilters, discoveryAssetType.nextLevelFilters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, label, nextLevelFilters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveryAssetType {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    nextLevelFilters: ").append(toIndentedString(nextLevelFilters)).append("\n");
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
