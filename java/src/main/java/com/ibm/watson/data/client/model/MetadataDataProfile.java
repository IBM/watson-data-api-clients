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

import java.util.Date;
import java.util.Objects;

/**
 * Metadata about a data profile
 */
public class MetadataDataProfile {

    private String guid;
    private String assetId;
    private String datasetId;
    private String url;
    private String catalogId;
    private Date createdAt;
    private Date accessedAt;
    private String owner;
    private String ownerId;
    private String lastUpdaterId;

    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    @javax.annotation.Nullable
    @JsonProperty("dataset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDatasetId() { return datasetId; }
    public void setDatasetId(String datasetId) { this.datasetId = datasetId; }

    @javax.annotation.Nullable
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @javax.annotation.Nullable
    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @javax.annotation.Nullable
    @JsonProperty("accessed_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getAccessedAt() { return accessedAt; }
    public void setAccessedAt(Date accessedAt) { this.accessedAt = accessedAt; }

    @javax.annotation.Nullable
    @JsonProperty("owner")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    @javax.annotation.Nullable
    @JsonProperty("owner_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    @javax.annotation.Nullable
    @JsonProperty("last_updater_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLastUpdaterId() { return lastUpdaterId; }
    public void setLastUpdaterId(String lastUpdaterId) { this.lastUpdaterId = lastUpdaterId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataDataProfile that = (MetadataDataProfile)o;
        return Objects.equals(this.guid, that.guid) &&
                Objects.equals(this.assetId, that.assetId) &&
                Objects.equals(this.datasetId, that.datasetId) &&
                Objects.equals(this.url, that.url) &&
                Objects.equals(this.catalogId, that.catalogId) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.accessedAt, that.accessedAt) &&
                Objects.equals(this.owner, that.owner) &&
                Objects.equals(this.ownerId, that.ownerId) &&
                Objects.equals(this.lastUpdaterId, that.lastUpdaterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, assetId, datasetId, url, catalogId, createdAt, accessedAt, owner, ownerId, lastUpdaterId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataDataProfile {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    datasetId: ").append(toIndentedString(datasetId)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    accessedAt: ").append(toIndentedString(accessedAt)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
        sb.append("    lastUpdaterId: ").append(toIndentedString(lastUpdaterId)).append("\n");
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
