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
import com.ibm.watson.data.client.model.enums.PermissionMode;

import java.util.Objects;

/**
 * Request for publishing an asset from a project to a catalog
 */
public class PublishAssetRequest {

    private PermissionMode mode;
    private String catalogId;
    private MetadataMutable metadata;

    public PublishAssetRequest mode(PermissionMode mode) {
        this.mode = mode;
        return this;
    }

    @JsonProperty("mode")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PermissionMode getMode() { return mode; }
    public void setMode(PermissionMode mode) { this.mode = mode; }

    public PublishAssetRequest catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public PublishAssetRequest metadata(MetadataMutable metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetadataMutable getMetadata() { return metadata; }
    public void setMetadata(MetadataMutable metadata) { this.metadata = metadata; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PublishAssetRequest that = (PublishAssetRequest)o;
        return Objects.equals(this.mode, that.mode) &&
                Objects.equals(this.catalogId, that.catalogId) &&
                Objects.equals(this.metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, catalogId, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublishAssetRequest {\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
