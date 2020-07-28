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
 * System metadata about an asset
 */
public class ConnectionAssetSystemMetadata {

    private String assetId;
    private String assetType;
    private String creatorId;

    public ConnectionAssetSystemMetadata assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * The ID of the asset
     * @return assetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public ConnectionAssetSystemMetadata assetType(String assetType) {
        this.assetType = assetType;
        return this;
    }

    /**
     * The type of the asset (always 'datasource_type'?)
     * @return assetType
     */
    @javax.annotation.Nullable
    @JsonProperty("asset_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }

    public ConnectionAssetSystemMetadata creatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    /**
     * The IAM ID of the user that created the asset
     * @return creatorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConnectionAssetSystemMetadata that = (ConnectionAssetSystemMetadata)o;
        return Objects.equals(this.assetId, that.assetId) &&
                Objects.equals(this.assetType, that.assetType) &&
                Objects.equals(this.creatorId, that.creatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId, assetType, creatorId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionAssetSystemMetadata {\n");
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
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
