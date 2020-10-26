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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AssetRatingStatsResponse
 */
public class AssetRatingStatsResponse {

    private String assetId;
    private Long revisionId;
    private List<AssetRatingCount> stats = null;

    public AssetRatingStatsResponse assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * identifier for asset
     * @return assetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public AssetRatingStatsResponse revisionId(Long revisionId) {
        this.revisionId = revisionId;
        return this;
    }

    /**
     * revision for asset
     * @return revisionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("revision_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRevisionId() { return revisionId; }
    public void setRevisionId(Long revisionId) { this.revisionId = revisionId; }

    public AssetRatingStatsResponse stats(List<AssetRatingCount> stats) {
        this.stats = stats;
        return this;
    }

    public AssetRatingStatsResponse addStatsItem(AssetRatingCount statsItem) {
        if (this.stats == null) {
            this.stats = new ArrayList<>();
        }
        this.stats.add(statsItem);
        return this;
    }

    /**
     * count of ratings for each rating value
     * @return stats
     **/
    @javax.annotation.Nullable
    @JsonProperty("stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AssetRatingCount> getStats() { return stats; }
    public void setStats(List<AssetRatingCount> stats) { this.stats = stats; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetRatingStatsResponse assetRatingStatsResponse = (AssetRatingStatsResponse)o;
        return Objects.equals(this.assetId, assetRatingStatsResponse.assetId) &&
                Objects.equals(this.revisionId, assetRatingStatsResponse.revisionId) &&
                Objects.equals(this.stats, assetRatingStatsResponse.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId, revisionId, stats);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetRatingStatsResponse {\n");
        sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    revisionId: ").append(toIndentedString(revisionId)).append("\n");
        sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
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
