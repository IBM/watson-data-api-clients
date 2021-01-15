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
 * The source asset that was used to create an asset
 */
public class SourceAsset {

    // TODO: this should probably be an enumeration?
    private String action;  // clone, publish
    private String catalogId;
    private String projectId;
    private String assetId;
    private String bssAccountId;
    private String assetName;

    public SourceAsset action(String action) {
        this.action = action;
        return this;
    }

    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public SourceAsset catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public SourceAsset projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    @JsonProperty("project_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public SourceAsset assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public SourceAsset bssAccountId(String bssAccountId) {
        this.bssAccountId = bssAccountId;
        return this;
    }

    @JsonProperty("bss_account_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getBssAccountId() { return bssAccountId; }
    public void setBssAccountId(String bssAccountId) { this.bssAccountId = bssAccountId; }

    public SourceAsset assetName(String assetName) {
        this.assetName = assetName;
        return this;
    }

    @JsonProperty("asset_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceAsset that = (SourceAsset) o;
        return Objects.equals(action, that.action) &&
                Objects.equals(catalogId, that.catalogId) &&
                Objects.equals(assetId, that.assetId) &&
                Objects.equals(bssAccountId, that.bssAccountId) &&
                Objects.equals(assetName, that.assetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, catalogId, assetId, bssAccountId, assetName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SourceAsset {\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    bssAccountId: ").append(toIndentedString(bssAccountId)).append("\n");
        sb.append("    assetName: ").append(toIndentedString(assetName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
