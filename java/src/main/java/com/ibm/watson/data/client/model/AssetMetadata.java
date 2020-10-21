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
 * AssetMetadata Model
 */
public class AssetMetadata extends MetadataHeader {

    private String resourceKey;
    private BaseRov rov;
    private SourceSystem sourceSystem;
    private List<SourceSystem> childSourceSystems = null;

    public AssetMetadata resourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("resource_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getResourceKey() { return resourceKey; }
    public void setResourceKey(String resourceKey) { this.resourceKey = resourceKey; }

    public AssetMetadata rov(BaseRov rov) {
        this.rov = rov;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("rov")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BaseRov getRov() { return rov; }
    public void setRov(BaseRov rov) { this.rov = rov; }

    public AssetMetadata sourceSystem(SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("source_system")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SourceSystem getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(SourceSystem sourceSystem) { this.sourceSystem = sourceSystem; }

    public AssetMetadata childSourceSystems(List<SourceSystem> childSourceSystems) {
        this.childSourceSystems = childSourceSystems;
        return this;
    }

    public AssetMetadata addChildSourceSystemsItem(SourceSystem childSourceSystemsItem) {
        if (this.childSourceSystems == null) {
            this.childSourceSystems = new ArrayList<>();
        }
        this.childSourceSystems.add(childSourceSystemsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("child_source_systems")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<SourceSystem> getChildSourceSystems() { return childSourceSystems; }
    public void setChildSourceSystems(List<SourceSystem> childSourceSystems) { this.childSourceSystems = childSourceSystems; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetMetadata assetMetadata = (AssetMetadata)o;
        return super.equals(o) &&
                Objects.equals(this.resourceKey, assetMetadata.resourceKey) &&
                Objects.equals(this.rov, assetMetadata.rov) &&
                Objects.equals(this.sourceSystem, assetMetadata.sourceSystem) &&
                Objects.equals(this.childSourceSystems, assetMetadata.childSourceSystems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resourceKey, rov, sourceSystem, childSourceSystems);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetMetadata {\n");
        this.toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    resourceKey: ").append(toIndentedString(resourceKey)).append("\n");
        sb.append("    rov: ").append(toIndentedString(rov)).append("\n");
        sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
        sb.append("    childSourceSystems: ").append(toIndentedString(childSourceSystems)).append("\n");
    }

}
