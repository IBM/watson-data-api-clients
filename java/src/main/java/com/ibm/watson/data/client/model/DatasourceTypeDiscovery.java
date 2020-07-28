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
 * The definition of the discovery features of the data source type.
 */
public class DatasourceTypeDiscovery {

    private List<String> topLevelFilters = null;
    private List<DiscoveryAssetType> assetTypes = null;

    public DatasourceTypeDiscovery topLevelFilters(List<String> topLevelFilters) {
        this.topLevelFilters = topLevelFilters;
        return this;
    }

    public DatasourceTypeDiscovery addTopLevelFiltersItem(String topLevelFiltersItem) {
        if (this.topLevelFilters == null) {
            this.topLevelFilters = new ArrayList<>();
        }
        this.topLevelFilters.add(topLevelFiltersItem);
        return this;
    }

    /**
     * Top level filters
     * @return topLevelFilters
     **/
    @javax.annotation.Nullable
    @JsonProperty("top_level_filters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTopLevelFilters() { return topLevelFilters; }
    public void setTopLevelFilters(List<String> topLevelFilters) { this.topLevelFilters = topLevelFilters; }

    public DatasourceTypeDiscovery assetTypes(List<DiscoveryAssetType> assetTypes) {
        this.assetTypes = assetTypes;
        return this;
    }

    public DatasourceTypeDiscovery addAssetTypesItem(DiscoveryAssetType assetTypesItem) {
        if (this.assetTypes == null) {
            this.assetTypes = new ArrayList<>();
        }
        this.assetTypes.add(assetTypesItem);
        return this;
    }

    /**
     * Asset types
     * @return assetTypes
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_types")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveryAssetType> getAssetTypes() { return assetTypes; }
    public void setAssetTypes(List<DiscoveryAssetType> assetTypes) { this.assetTypes = assetTypes; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeDiscovery datasourceTypeDiscovery = (DatasourceTypeDiscovery)o;
        return Objects.equals(this.topLevelFilters, datasourceTypeDiscovery.topLevelFilters) &&
                Objects.equals(this.assetTypes, datasourceTypeDiscovery.assetTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLevelFilters, assetTypes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeDiscovery {\n");
        sb.append("    topLevelFilters: ").append(toIndentedString(topLevelFilters)).append("\n");
        sb.append("    assetTypes: ").append(toIndentedString(assetTypes)).append("\n");
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
