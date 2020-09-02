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
 * AssetAggregatedCommentsList
 */
public class AssetAggregatedCommentsList {

    private String logStatus;
    private AssetAggregatedCommentsMetadata metadata;
    private List<AssetComment> entities = null;

    public AssetAggregatedCommentsList logStatus(String logStatus) {
        this.logStatus = logStatus;
        return this;
    }

    /**
     * Get logStatus
     * @return logStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("log_status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLogStatus() { return logStatus; }
    public void setLogStatus(String logStatus) { this.logStatus = logStatus; }

    public AssetAggregatedCommentsList metadata(AssetAggregatedCommentsMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AssetAggregatedCommentsMetadata getMetadata() { return metadata; }
    public void setMetadata(AssetAggregatedCommentsMetadata metadata) { this.metadata = metadata; }

    public AssetAggregatedCommentsList entities(List<AssetComment> entities) {
        this.entities = entities;
        return this;
    }

    public AssetAggregatedCommentsList addEntitiesItem(AssetComment entitiesItem) {
        if (this.entities == null) {
            this.entities = new ArrayList<>();
        }
        this.entities.add(entitiesItem);
        return this;
    }

    /**
     * Get entities
     * @return entities
     **/
    @javax.annotation.Nullable
    @JsonProperty("entities")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AssetComment> getEntities() { return entities; }
    public void setEntities(List<AssetComment> entities) { this.entities = entities; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetAggregatedCommentsList assetAggregatedCommentsList = (AssetAggregatedCommentsList)o;
        return Objects.equals(this.logStatus, assetAggregatedCommentsList.logStatus) &&
                Objects.equals(this.metadata, assetAggregatedCommentsList.metadata) &&
                Objects.equals(this.entities, assetAggregatedCommentsList.entities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logStatus, metadata, entities);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetAggregatedCommentsList {\n");
        sb.append("    logStatus: ").append(toIndentedString(logStatus)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
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
