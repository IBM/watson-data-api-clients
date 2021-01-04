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
 * CommentMetadata
 */
public class CommentMetadata {

    private String id;
    private String assetVersionId;
    private String assetAncestorId;
    private String modifiedBy;
    private Date modifiedAt;
    private Date createdAt;

    public CommentMetadata id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Comment ID
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public CommentMetadata assetVersionId(String assetVersionId) {
        this.assetVersionId = assetVersionId;
        return this;
    }

    /**
     * Asset version ID
     * @return assetVersionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_version_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetVersionId() { return assetVersionId; }
    public void setAssetVersionId(String assetVersionId) { this.assetVersionId = assetVersionId; }

    public CommentMetadata assetAncestorId(String assetAncestorId) {
        this.assetAncestorId = assetAncestorId;
        return this;
    }

    /**
     * Asset ancestor ID
     * @return assetAncestorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_ancestor_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetAncestorId() { return assetAncestorId; }
    public void setAssetAncestorId(String assetAncestorId) { this.assetAncestorId = assetAncestorId; }

    public CommentMetadata modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    /**
     * User ID of the user who last modified the comment (system managed)
     * @return modifiedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public CommentMetadata modifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    /**
     * RFC 3339 timestamp on when the comment was last modified (system managed)
     * @return modifiedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Date modifiedAt) { this.modifiedAt = modifiedAt; }

    public CommentMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * RFC 3339 timestamp on when the comment was created (system managed)
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CommentMetadata commentMetadata = (CommentMetadata)o;
        return Objects.equals(this.id, commentMetadata.id) &&
                Objects.equals(this.assetVersionId, commentMetadata.assetVersionId) &&
                Objects.equals(this.assetAncestorId, commentMetadata.assetAncestorId) &&
                Objects.equals(this.modifiedBy, commentMetadata.modifiedBy) &&
                Objects.equals(this.modifiedAt, commentMetadata.modifiedAt) &&
                Objects.equals(this.createdAt, commentMetadata.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assetVersionId, assetAncestorId, modifiedBy,
                modifiedAt, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentMetadata {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    assetVersionId: ").append(toIndentedString(assetVersionId)).append("\n");
        sb.append("    assetAncestorId: ").append(toIndentedString(assetAncestorId)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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
