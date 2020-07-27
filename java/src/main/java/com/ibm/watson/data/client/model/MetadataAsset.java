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

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Metadata about an asset
 */
public class MetadataAsset extends MetadataHeader {

    private MetadataRov rov;
    private String projectId;
    private String sandboxId;
    private MetadataUsage usage;
    private Double rating;
    private Long totalRatings;
    private String catalogId;
    private Long created;
    private OffsetDateTime createdAt;
    private String ownerId;
    private Long size;
    private Double version;
    // TODO: this is probably an enum rather than a String?
    private String assetState;
    private List<String> assetAttributes;
    private String assetId;
    private SourceAsset sourceAsset;
    private Long revisionId;
    private CommitInfo commitInfo;

    public MetadataAsset rov(MetadataRov rov) {
        this.rov = rov;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("rov")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetadataRov getRov() { return rov; }
    public void setRov(MetadataRov rov) { this.rov = rov; }

    public MetadataAsset projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("project_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public MetadataAsset sandboxId(String sandboxId) {
        this.sandboxId = sandboxId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("sandbox_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSandboxId() { return sandboxId; }
    public void setSandboxId(String sandboxId) { this.sandboxId = sandboxId; }

    public MetadataAsset usage(MetadataUsage usage) {
        this.usage = usage;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("usage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetadataUsage getUsage() { return usage; }
    public void setUsage(MetadataUsage usage) { this.usage = usage; }

    public MetadataAsset rating(Double rating) {
        this.rating = rating;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("rating")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public MetadataAsset totalRatings(Long totalRatings) {
        this.totalRatings = totalRatings;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("total_ratings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalRatings() { return totalRatings; }
    public void setTotalRatings(Long totalRatings) { this.totalRatings = totalRatings; }

    public MetadataAsset catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public MetadataAsset created(Long created) {
        this.created = created;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("created")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCreated() { return created; }
    public void setCreated(Long created) { this.created = created; }

    public MetadataAsset createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public MetadataAsset ownerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("owner_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    public MetadataAsset size(Long size) {
        this.size = size;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }

    public MetadataAsset version(Double version) {
        this.version = version;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getVersion() { return version; }
    public void setVersion(Double version) { this.version = version; }

    public MetadataAsset assetState(String assetState) {
        this.assetState = assetState;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("asset_state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetState() { return assetState; }
    public void setAssetState(String assetState) { this.assetState = assetState; }

    public MetadataAsset assetAttributes(List<String> assetAttributes) {
        this.assetAttributes = assetAttributes;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("asset_attributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAssetAttributes() { return assetAttributes; }
    public void setAssetAttributes(List<String> assetAttributes) { this.assetAttributes = assetAttributes; }

    public MetadataAsset assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public MetadataAsset sourceAsset(SourceAsset sourceAsset) {
        this.sourceAsset = sourceAsset;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("source_asset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SourceAsset getSourceAsset() { return sourceAsset; }
    public void setSourceAsset(SourceAsset sourceAsset) { this.sourceAsset = sourceAsset; }

    public MetadataAsset revisionId(Long revisionId) {
        this.revisionId = revisionId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("revision_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRevisionId() { return revisionId; }
    public void setRevisionId(Long revisionId) { this.revisionId = revisionId; }

    public MetadataAsset commitInfo(CommitInfo commitInfo) {
        this.commitInfo = commitInfo;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("commit_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CommitInfo getCommitInfo() { return commitInfo; }
    public void setCommitInfo(CommitInfo commitInfo) { this.commitInfo = commitInfo; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataAsset that = (MetadataAsset)o;
        return super.equals(o) &&
                Objects.equals(this.rov, that.rov) &&
                Objects.equals(this.projectId, that.projectId) &&
                Objects.equals(this.sandboxId, that.sandboxId) &&
                Objects.equals(this.usage, that.usage) &&
                Objects.equals(this.rating, that.rating) &&
                Objects.equals(this.totalRatings, that.totalRatings) &&
                Objects.equals(this.catalogId, that.catalogId) &&
                Objects.equals(this.created, that.created) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.ownerId, that.ownerId) &&
                Objects.equals(this.size, that.size) &&
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.assetState, that.assetState) &&
                Objects.equals(this.assetAttributes, that.assetAttributes) &&
                Objects.equals(this.assetId, that.assetId) &&
                Objects.equals(this.sourceAsset, that.sourceAsset) &&
                Objects.equals(this.revisionId, that.revisionId) &&
                Objects.equals(this.commitInfo, that.commitInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rov, projectId, sandboxId, usage, rating, totalRatings, catalogId,
                created, createdAt, ownerId, size, version, assetState, assetAttributes, assetId, sourceAsset,
                revisionId, commitInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataAsset {\n");
        super.toString(sb);
        sb.append("    rov: ").append(toIndentedString(rov)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    sandboxId: ").append(toIndentedString(sandboxId)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    totalRatings: ").append(toIndentedString(totalRatings)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    assetState: ").append(toIndentedString(assetState)).append("\n");
        sb.append("    assetAttributes: ").append(toIndentedString(assetAttributes)).append("\n");
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    sourceAsset: ").append(toIndentedString(sourceAsset)).append("\n");
        sb.append("    revisionId: ").append(toIndentedString(revisionId)).append("\n");
        sb.append("    commitInfo: ").append(toIndentedString(commitInfo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
