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
 * EntityInfoResponse
 */
public class EntityInfoResponse {

    private String catalogId;
    private Long reportTimestamp;
    private String reportTime;
    private EntityInfoSummary summary;
    private List<MappableAssetSummary> assets = null;
    private List<MappableAssetSummary> deletedAssets = null;
    private EntityNode reachabilityGraph;

    public EntityInfoResponse catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    /**
     * Get catalogId
     * @return catalogId
     **/
    @javax.annotation.Nullable
    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public EntityInfoResponse reportTimestamp(Long reportTimestamp) {
        this.reportTimestamp = reportTimestamp;
        return this;
    }

    /**
     * Get reportTimestamp
     * @return reportTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("report_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getReportTimestamp() { return reportTimestamp; }
    public void setReportTimestamp(Long reportTimestamp) { this.reportTimestamp = reportTimestamp; }

    public EntityInfoResponse reportTime(String reportTime) {
        this.reportTime = reportTime;
        return this;
    }

    /**
     * Get reportTime
     * @return reportTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("report_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getReportTime() { return reportTime; }
    public void setReportTime(String reportTime) { this.reportTime = reportTime; }

    public EntityInfoResponse summary(EntityInfoSummary summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Get summary
     * @return summary
     **/
    @javax.annotation.Nullable
    @JsonProperty("summary")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EntityInfoSummary getSummary() { return summary; }
    public void setSummary(EntityInfoSummary summary) { this.summary = summary; }

    public EntityInfoResponse assets(List<MappableAssetSummary> assets) {
        this.assets = assets;
        return this;
    }

    public EntityInfoResponse addAssetsItem(MappableAssetSummary assetsItem) {
        if (this.assets == null) {
            this.assets = new ArrayList<>();
        }
        this.assets.add(assetsItem);
        return this;
    }

    /**
     * Get assets
     * @return assets
     **/
    @javax.annotation.Nullable
    @JsonProperty("assets")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableAssetSummary> getAssets() { return assets; }
    public void setAssets(List<MappableAssetSummary> assets) { this.assets = assets; }

    public EntityInfoResponse deletedAssets(List<MappableAssetSummary> deletedAssets) {
        this.deletedAssets = deletedAssets;
        return this;
    }

    public EntityInfoResponse addDeletedAssetsItem(MappableAssetSummary deletedAssetsItem) {
        if (this.deletedAssets == null) {
            this.deletedAssets = new ArrayList<>();
        }
        this.deletedAssets.add(deletedAssetsItem);
        return this;
    }

    /**
     * Get deletedAssets
     * @return deletedAssets
     **/
    @javax.annotation.Nullable
    @JsonProperty("deleted_assets")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableAssetSummary> getDeletedAssets() { return deletedAssets; }
    public void setDeletedAssets(List<MappableAssetSummary> deletedAssets) { this.deletedAssets = deletedAssets; }

    public EntityInfoResponse reachabilityGraph(EntityNode reachabilityGraph) {
        this.reachabilityGraph = reachabilityGraph;
        return this;
    }

    /**
     * Get reachabilityGraph
     * @return reachabilityGraph
     **/
    @javax.annotation.Nullable
    @JsonProperty("reachability_graph")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EntityNode getReachabilityGraph() { return reachabilityGraph; }
    public void setReachabilityGraph(EntityNode reachabilityGraph) { this.reachabilityGraph = reachabilityGraph; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EntityInfoResponse entityInfoResponse = (EntityInfoResponse)o;
        return Objects.equals(this.catalogId, entityInfoResponse.catalogId) &&
                Objects.equals(this.reportTimestamp, entityInfoResponse.reportTimestamp) &&
                Objects.equals(this.reportTime, entityInfoResponse.reportTime) &&
                Objects.equals(this.summary, entityInfoResponse.summary) &&
                Objects.equals(this.assets, entityInfoResponse.assets) &&
                Objects.equals(this.deletedAssets, entityInfoResponse.deletedAssets) &&
                Objects.equals(this.reachabilityGraph, entityInfoResponse.reachabilityGraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogId, reportTimestamp, reportTime, summary, assets,
                deletedAssets, reachabilityGraph);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityInfoResponse {\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    reportTimestamp: ").append(toIndentedString(reportTimestamp)).append("\n");
        sb.append("    reportTime: ").append(toIndentedString(reportTime)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
        sb.append("    deletedAssets: ").append(toIndentedString(deletedAssets)).append("\n");
        sb.append("    reachabilityGraph: ").append(toIndentedString(reachabilityGraph)).append("\n");
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
