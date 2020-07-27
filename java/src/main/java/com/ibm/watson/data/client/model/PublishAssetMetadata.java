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
 * Publish Asset Metadata
 */
public class PublishAssetMetadata extends MetadataHeader {

    private String resourceKey;
    private AssetRov rov;
    private SourceSystem sourceSystem;
    private List<SourceSystem> childSourceSystems = null;
    private AssetPublishedFrom publishedFrom;
    private AssetPublishedTo publishedTo;

    public PublishAssetMetadata resourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
        return this;
    }

    /**
     * Get resourceKey
     * @return resourceKey
     **/
    @javax.annotation.Nullable
    @JsonProperty("resource_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getResourceKey() { return resourceKey; }
    public void setResourceKey(String resourceKey) { this.resourceKey = resourceKey; }

    public PublishAssetMetadata rov(AssetRov rov) {
        this.rov = rov;
        return this;
    }

    /**
     * Get rov
     * @return rov
     **/
    @javax.annotation.Nullable
    @JsonProperty("rov")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AssetRov getRov() { return rov; }
    public void setRov(AssetRov rov) { this.rov = rov; }

    public PublishAssetMetadata sourceSystem(SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    /**
     * Get sourceSystem
     * @return sourceSystem
     **/
    @javax.annotation.Nullable
    @JsonProperty("source_system")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SourceSystem getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(SourceSystem sourceSystem) { this.sourceSystem = sourceSystem; }

    public PublishAssetMetadata childSourceSystems(List<SourceSystem> childSourceSystems) {
        this.childSourceSystems = childSourceSystems;
        return this;
    }

    public PublishAssetMetadata addChildSourceSystemsItem(SourceSystem childSourceSystemsItem) {
        if (this.childSourceSystems == null) {
            this.childSourceSystems = new ArrayList<>();
        }
        this.childSourceSystems.add(childSourceSystemsItem);
        return this;
    }

    /**
     * Get childSourceSystems
     * @return childSourceSystems
     **/
    @javax.annotation.Nullable
    @JsonProperty("child_source_systems")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<SourceSystem> getChildSourceSystems() { return childSourceSystems; }
    public void setChildSourceSystems(List<SourceSystem> childSourceSystems) { this.childSourceSystems = childSourceSystems; }

    public PublishAssetMetadata publishedFrom(AssetPublishedFrom publishedFrom) {
        this.publishedFrom = publishedFrom;
        return this;
    }

    /**
     * Get publishedFrom
     * @return publishedFrom
     **/
    @JsonProperty("published_from")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public AssetPublishedFrom getPublishedFrom() { return publishedFrom; }
    public void setPublishedFrom(AssetPublishedFrom publishedFrom) { this.publishedFrom = publishedFrom; }

    public PublishAssetMetadata publishedTo(AssetPublishedTo publishedTo) {
        this.publishedTo = publishedTo;
        return this;
    }

    /**
     * Get publishedTo
     * @return publishedTo
     **/
    @JsonProperty("published_to")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public AssetPublishedTo getPublishedTo() { return publishedTo; }
    public void setPublishedTo(AssetPublishedTo publishedTo) { this.publishedTo = publishedTo; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PublishAssetMetadata that = (PublishAssetMetadata)o;
        return super.equals(o) &&
                Objects.equals(this.resourceKey, that.resourceKey) &&
                Objects.equals(this.rov, that.rov) &&
                Objects.equals(this.sourceSystem, that.sourceSystem) &&
                Objects.equals(this.childSourceSystems, that.childSourceSystems) &&
                Objects.equals(this.publishedFrom, that.publishedFrom) &&
                Objects.equals(this.publishedTo, that.publishedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceKey, rov, sourceSystem,
                childSourceSystems, publishedFrom, publishedTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublishAssetMetadata {\n");
        super.toString(sb);
        sb.append("    resourceKey: ").append(toIndentedString(resourceKey)).append("\n");
        sb.append("    rov: ").append(toIndentedString(rov)).append("\n");
        sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
        sb.append("    childSourceSystems: ").append(toIndentedString(childSourceSystems)).append("\n");
        sb.append("    publishedFrom: ").append(toIndentedString(publishedFrom)).append("\n");
        sb.append("    publishedTo: ").append(toIndentedString(publishedTo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
