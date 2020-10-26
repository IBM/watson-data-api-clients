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
 * Metadata about an asset, as a result of creation
 */
public class AssetCreateResponse extends MetadataEntityResult {

    private String assetId;

    public AssetCreateResponse assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Get asset ID
     * @return assetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetCreateResponse asset = (AssetCreateResponse)o;
        return super.equals(o) &&
                Objects.equals(this.assetId, asset.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assetId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataEntityResult {\n");
        super.toString(sb);
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
