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
 * Metadata about an asset, as a result
 */
public class MetadataAssetResult {

    private MetadataAsset metadata;
    private String href;

    public MetadataAssetResult metadata(MetadataAsset metadata) {
        this.metadata = metadata;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetadataAsset getMetadata() { return metadata; }
    public void setMetadata(MetadataAsset metadata) { this.metadata = metadata; }

    public MetadataAssetResult href(String href) {
        this.href = href;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataAssetResult metadataAsset = (MetadataAssetResult)o;
        return Objects.equals(this.metadata, metadataAsset.metadata) &&
                Objects.equals(this.href, metadataAsset.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, href);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataAssetResult {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
