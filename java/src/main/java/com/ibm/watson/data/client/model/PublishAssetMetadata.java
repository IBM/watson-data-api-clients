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
 * Publish Asset Metadata
 */
public class PublishAssetMetadata extends MetadataAsset {

    private AssetPublishedFrom publishedFrom;
    private AssetPublishedTo publishedTo;

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
                Objects.equals(this.publishedFrom, that.publishedFrom) &&
                Objects.equals(this.publishedTo, that.publishedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publishedFrom, publishedTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublishAssetMetadata {\n");
        super.toString(sb);
        sb.append("    publishedFrom: ").append(toIndentedString(publishedFrom)).append("\n");
        sb.append("    publishedTo: ").append(toIndentedString(publishedTo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
