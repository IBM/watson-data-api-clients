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
import java.util.Objects;

/**
 * An asset type definition.
 */
public class DiscoveredAssetType {

    private String type;
    private Boolean dataset;
    private Boolean datasetContainer;

    public DiscoveredAssetType type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The name of the asset type.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public DiscoveredAssetType dataset(Boolean dataset) {
        this.dataset = dataset;
        return this;
    }

    /**
     * Whether the asset can be a source of data or whether it can be written to.
     * To illustrate by example, a database table is a data set, but a schema is
     * not. Likewise, a file is a data set, but a folder/directory is not.
     * @return dataset
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDataset() { return dataset; }
    public void setDataset(Boolean dataset) { this.dataset = dataset; }

    public DiscoveredAssetType datasetContainer(Boolean datasetContainer) {
        this.datasetContainer = datasetContainer;
        return this;
    }

    /**
     * Whether an asset can be created in this asset. To illustrate by example, a
     * schema is a data set container, as is a folder/directory.
     * @return datasetContainer
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataset_container")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDatasetContainer() { return datasetContainer; }
    public void setDatasetContainer(Boolean datasetContainer) { this.datasetContainer = datasetContainer; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveredAssetType discoveredAssetType = (DiscoveredAssetType)o;
        return Objects.equals(this.type, discoveredAssetType.type) &&
                Objects.equals(this.dataset, discoveredAssetType.dataset) &&
                Objects.equals(this.datasetContainer, discoveredAssetType.datasetContainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, dataset, datasetContainer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveredAssetType {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    dataset: ").append(toIndentedString(dataset)).append("\n");
        sb.append("    datasetContainer: ").append(toIndentedString(datasetContainer)).append("\n");
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
