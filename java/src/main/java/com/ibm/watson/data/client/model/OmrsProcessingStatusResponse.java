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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * OmrsProcessingStatusResponse
 */
public class OmrsProcessingStatusResponse {

    private Long startTimestamp;
    private Long reportTimestamp;
    private Long numSyncedDataAssetsCreated;
    private Long numPendingDataAssets;
    private Long numSyncedConnectionsCreated;
    private Long numPendingConnections;
    private Long numNewEntitiesReceived;
    private Map<String, Long> newEntitiesReceivedByType = null;
    private Map<String, Long> numNewRelationshipsReceived = null;
    private Long unrecognizedConnections;
    private Boolean allStatsZero;

    public OmrsProcessingStatusResponse startTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
        return this;
    }

    /**
     * Get startTimestamp
     * @return startTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("start_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getStartTimestamp() { return startTimestamp; }
    public void setStartTimestamp(Long startTimestamp) { this.startTimestamp = startTimestamp; }

    public OmrsProcessingStatusResponse reportTimestamp(Long reportTimestamp) {
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

    public OmrsProcessingStatusResponse numSyncedDataAssetsCreated(Long numSyncedDataAssetsCreated) {
        this.numSyncedDataAssetsCreated = numSyncedDataAssetsCreated;
        return this;
    }

    /**
     * Total number of data assets created since the specified start time
     * @return numSyncedDataAssetsCreated
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_synced_data_assets_created")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNumSyncedDataAssetsCreated() { return numSyncedDataAssetsCreated; }
    public void setNumSyncedDataAssetsCreated(Long numSyncedDataAssetsCreated) { this.numSyncedDataAssetsCreated = numSyncedDataAssetsCreated; }

    public OmrsProcessingStatusResponse numPendingDataAssets(Long numPendingDataAssets) {
        this.numPendingDataAssets = numPendingDataAssets;
        return this;
    }

    /**
     * Total number of data assets whose creation is pending
     * @return numPendingDataAssets
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_pending_data_assets")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNumPendingDataAssets() { return numPendingDataAssets; }
    public void setNumPendingDataAssets(Long numPendingDataAssets) { this.numPendingDataAssets = numPendingDataAssets; }

    public OmrsProcessingStatusResponse numSyncedConnectionsCreated(Long numSyncedConnectionsCreated) {
        this.numSyncedConnectionsCreated = numSyncedConnectionsCreated;
        return this;
    }

    /**
     * Total number of connection assets created since the specified start time
     * @return numSyncedConnectionsCreated
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_synced_connections_created")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNumSyncedConnectionsCreated() { return numSyncedConnectionsCreated; }
    public void setNumSyncedConnectionsCreated(Long numSyncedConnectionsCreated) { this.numSyncedConnectionsCreated = numSyncedConnectionsCreated; }

    public OmrsProcessingStatusResponse numPendingConnections(Long numPendingConnections) {
        this.numPendingConnections = numPendingConnections;
        return this;
    }

    /**
     * Total number connections whose creation is pending
     * @return numPendingConnections
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_pending_connections")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNumPendingConnections() { return numPendingConnections; }
    public void setNumPendingConnections(Long numPendingConnections) { this.numPendingConnections = numPendingConnections; }

    public OmrsProcessingStatusResponse numNewEntitiesReceived(Long numNewEntitiesReceived) {
        this.numNewEntitiesReceived = numNewEntitiesReceived;
        return this;
    }

    /**
     * Total number of new entities received since the specified start time
     * @return numNewEntitiesReceived
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_new_entities_received")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNumNewEntitiesReceived() { return numNewEntitiesReceived; }
    public void setNumNewEntitiesReceived(Long numNewEntitiesReceived) { this.numNewEntitiesReceived = numNewEntitiesReceived; }

    public OmrsProcessingStatusResponse newEntitiesReceivedByType(Map<String, Long> newEntitiesReceivedByType) {
        this.newEntitiesReceivedByType = newEntitiesReceivedByType;
        return this;
    }

    public OmrsProcessingStatusResponse putNewEntitiesReceivedByTypeItem(String key, Long newEntitiesReceivedByTypeItem) {
        if (this.newEntitiesReceivedByType == null) {
            this.newEntitiesReceivedByType = new HashMap<>();
        }
        this.newEntitiesReceivedByType.put(key, newEntitiesReceivedByTypeItem);
        return this;
    }

    /**
     * Get newEntitiesReceivedByType
     * @return newEntitiesReceivedByType
     **/
    @javax.annotation.Nullable
    @JsonProperty("new_entities_received_by_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Long> getNewEntitiesReceivedByType() { return newEntitiesReceivedByType; }
    public void setNewEntitiesReceivedByType(Map<String, Long> newEntitiesReceivedByType) { this.newEntitiesReceivedByType = newEntitiesReceivedByType; }

    public OmrsProcessingStatusResponse numNewRelationshipsReceived(Map<String, Long> numNewRelationshipsReceived) {
        this.numNewRelationshipsReceived = numNewRelationshipsReceived;
        return this;
    }

    public OmrsProcessingStatusResponse putNumNewRelationshipsReceivedItem(String key, Long numNewRelationshipsReceivedItem) {
        if (this.numNewRelationshipsReceived == null) {
            this.numNewRelationshipsReceived = new HashMap<>();
        }
        this.numNewRelationshipsReceived.put(key, numNewRelationshipsReceivedItem);
        return this;
    }

    /**
     * Get numNewRelationshipsReceived
     * @return numNewRelationshipsReceived
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_new_relationships_received")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Long> getNumNewRelationshipsReceived() { return numNewRelationshipsReceived; }
    public void setNumNewRelationshipsReceived(Map<String, Long> numNewRelationshipsReceived) { this.numNewRelationshipsReceived = numNewRelationshipsReceived; }

    public OmrsProcessingStatusResponse unrecognizedConnections(Long unrecognizedConnections) {
        this.unrecognizedConnections = unrecognizedConnections;
        return this;
    }

    /**
     * Get unrecognizedConnections
     * @return unrecognizedConnections
     **/
    @javax.annotation.Nullable
    @JsonProperty("unrecognizedConnections")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getUnrecognizedConnections() { return unrecognizedConnections; }
    public void setUnrecognizedConnections(Long unrecognizedConnections) { this.unrecognizedConnections = unrecognizedConnections; }

    public OmrsProcessingStatusResponse allStatsZero(Boolean allStatsZero) {
        this.allStatsZero = allStatsZero;
        return this;
    }

    /**
     * Get allStatsZero
     * @return allStatsZero
     **/
    @javax.annotation.Nullable
    @JsonProperty("allStatsZero")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAllStatsZero() { return allStatsZero; }
    public void setAllStatsZero(Boolean allStatsZero) { this.allStatsZero = allStatsZero; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OmrsProcessingStatusResponse omrsProcessingStatusResponse = (OmrsProcessingStatusResponse)o;
        return Objects.equals(this.startTimestamp, omrsProcessingStatusResponse.startTimestamp) &&
                Objects.equals(this.reportTimestamp, omrsProcessingStatusResponse.reportTimestamp) &&
                Objects.equals(this.numSyncedDataAssetsCreated, omrsProcessingStatusResponse.numSyncedDataAssetsCreated) &&
                Objects.equals(this.numPendingDataAssets, omrsProcessingStatusResponse.numPendingDataAssets) &&
                Objects.equals(this.numSyncedConnectionsCreated, omrsProcessingStatusResponse.numSyncedConnectionsCreated) &&
                Objects.equals(this.numPendingConnections, omrsProcessingStatusResponse.numPendingConnections) &&
                Objects.equals(this.numNewEntitiesReceived, omrsProcessingStatusResponse.numNewEntitiesReceived) &&
                Objects.equals(this.newEntitiesReceivedByType, omrsProcessingStatusResponse.newEntitiesReceivedByType) &&
                Objects.equals(this.numNewRelationshipsReceived, omrsProcessingStatusResponse.numNewRelationshipsReceived) &&
                Objects.equals(this.unrecognizedConnections, omrsProcessingStatusResponse.unrecognizedConnections) &&
                Objects.equals(this.allStatsZero, omrsProcessingStatusResponse.allStatsZero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTimestamp, reportTimestamp,
                numSyncedDataAssetsCreated, numPendingDataAssets,
                numSyncedConnectionsCreated, numPendingConnections,
                numNewEntitiesReceived, newEntitiesReceivedByType,
                numNewRelationshipsReceived, unrecognizedConnections,
                allStatsZero);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OmrsProcessingStatusResponse {\n");
        sb.append("    startTimestamp: ").append(toIndentedString(startTimestamp)).append("\n");
        sb.append("    reportTimestamp: ").append(toIndentedString(reportTimestamp)).append("\n");
        sb.append("    numSyncedDataAssetsCreated: ").append(toIndentedString(numSyncedDataAssetsCreated)).append("\n");
        sb.append("    numPendingDataAssets: ").append(toIndentedString(numPendingDataAssets)).append("\n");
        sb.append("    numSyncedConnectionsCreated: ").append(toIndentedString(numSyncedConnectionsCreated)).append("\n");
        sb.append("    numPendingConnections: ").append(toIndentedString(numPendingConnections)).append("\n");
        sb.append("    numNewEntitiesReceived: ").append(toIndentedString(numNewEntitiesReceived)).append("\n");
        sb.append("    newEntitiesReceivedByType: ").append(toIndentedString(newEntitiesReceivedByType)).append("\n");
        sb.append("    numNewRelationshipsReceived: ").append(toIndentedString(numNewRelationshipsReceived)).append("\n");
        sb.append("    unrecognizedConnections: ").append(toIndentedString(unrecognizedConnections)).append("\n");
        sb.append("    allStatsZero: ").append(toIndentedString(allStatsZero)).append("\n");
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
