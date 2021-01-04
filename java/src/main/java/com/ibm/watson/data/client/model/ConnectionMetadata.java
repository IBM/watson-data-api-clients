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
 * Metadata about a connection asset
 */
public class ConnectionMetadata extends Metadata {

    private String assetId;
    private Date createTime;
    private String creatorId;
    private String projectId;
    private String catalogId;
    private ConnectionMetadataUsage usage;

    public ConnectionMetadata assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public ConnectionMetadata createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("create_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public ConnectionMetadata creatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    public ConnectionMetadata projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("project_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public ConnectionMetadata catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public ConnectionMetadata usage(ConnectionMetadataUsage usage) {
        this.usage = usage;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("usage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ConnectionMetadataUsage getUsage() { return usage; }
    public void setUsage(ConnectionMetadataUsage usage) { this.usage = usage; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConnectionMetadata that = (ConnectionMetadata)o;
        return super.equals(o) &&
                Objects.equals(this.assetId, that.assetId) &&
                Objects.equals(this.createTime, that.createTime) &&
                Objects.equals(this.creatorId, that.creatorId) &&
                Objects.equals(this.projectId, that.projectId) &&
                Objects.equals(this.catalogId, that.catalogId) &&
                Objects.equals(this.usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assetId, createTime, creatorId, projectId, catalogId, usage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionMetadata {\n");
        super.toString(sb);
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
