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
 * AssetRatingMetadata
 */
public class AssetRatingMetadata {

    private String assetRatingId;
    private String assetId;
    private String creator;
    private String creatorId;
    private Date createdAt;
    private Date updatedAt;
    private Long revisionId;

    public AssetRatingMetadata assetRatingId(String assetRatingId) {
        this.assetRatingId = assetRatingId;
        return this;
    }

    /**
     * unique asset rating identifier
     * @return assetRatingId
     **/
    @JsonProperty("asset_rating_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAssetRatingId() { return assetRatingId; }
    public void setAssetRatingId(String assetRatingId) { this.assetRatingId = assetRatingId; }

    /**
     * identifier for asset associated with this rating (system managed)
     * @return assetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }

    /**
     * IAM ID of user that creating the asset rating (system managed)
     * @return creator
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreator() { return creator; }

    public AssetRatingMetadata creatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    /**
     * Get creatorId
     * @return creatorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    /**
     * RFC 3339 timestamp when the asset rating was created (system managed)
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }

    /**
     * RFC 3339 timestamp when the asset rating was updated (system managed)
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getUpdatedAt() { return updatedAt; }

    /**
     * identifier for asset associated with this rating (system managed)
     * @return revisionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("revision_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRevisionId() { return revisionId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetRatingMetadata assetRatingMetadata = (AssetRatingMetadata)o;
        return Objects.equals(this.assetRatingId, assetRatingMetadata.assetRatingId) &&
                Objects.equals(this.assetId, assetRatingMetadata.assetId) &&
                Objects.equals(this.creator, assetRatingMetadata.creator) &&
                Objects.equals(this.creatorId, assetRatingMetadata.creatorId) &&
                Objects.equals(this.createdAt, assetRatingMetadata.createdAt) &&
                Objects.equals(this.updatedAt, assetRatingMetadata.updatedAt) &&
                Objects.equals(this.revisionId, assetRatingMetadata.revisionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetRatingId, assetId, creator, creatorId, createdAt,
                updatedAt, revisionId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetRatingMetadata {\n");
        sb.append("    assetRatingId: ").append(toIndentedString(assetRatingId)).append("\n");
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    revisionId: ").append(toIndentedString(revisionId)).append("\n");
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
