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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * The stats about deployments for a space. 
 */
public class Stats {

    private String spaceId;
    private BigDecimal totalCount;
    private BigDecimal onlineCount;
    private BigDecimal batchCount;
    private BigDecimal virtualCount;

    public Stats spaceId(String spaceId) {
        this.spaceId = spaceId;
        return this;
    }

    /**
     * An &#x60;id&#x60; associated with the space.
     * @return spaceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("space_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSpaceId() { return spaceId; }
    public void setSpaceId(String spaceId) { this.spaceId = spaceId; }

    public Stats totalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * The total number of deployments created in a space including online, batch and virtual.
     * @return totalCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getTotalCount() { return totalCount; }
    public void setTotalCount(BigDecimal totalCount) { this.totalCount = totalCount; }

    public Stats onlineCount(BigDecimal onlineCount) {
        this.onlineCount = onlineCount;
        return this;
    }

    /**
     * The number of online deployments created in a space.
     * @return onlineCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("online_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getOnlineCount() { return onlineCount; }
    public void setOnlineCount(BigDecimal onlineCount) { this.onlineCount = onlineCount; }

    public Stats batchCount(BigDecimal batchCount) {
        this.batchCount = batchCount;
        return this;
    }

    /**
     * The number of batch deployments created in a space.
     * @return batchCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("batch_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getBatchCount() { return batchCount; }
    public void setBatchCount(BigDecimal batchCount) { this.batchCount = batchCount; }

    public Stats virtualCount(BigDecimal virtualCount) {
        this.virtualCount = virtualCount;
        return this;
    }

    /**
     * The number of virtual deployments created in a space.
     * @return virtualCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtual_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getVirtualCount() { return virtualCount; }
    public void setVirtualCount(BigDecimal virtualCount) { this.virtualCount = virtualCount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Stats stats = (Stats) o;
        return Objects.equals(this.spaceId, stats.spaceId) &&
                Objects.equals(this.totalCount, stats.totalCount) &&
                Objects.equals(this.onlineCount, stats.onlineCount) &&
                Objects.equals(this.batchCount, stats.batchCount) &&
                Objects.equals(this.virtualCount, stats.virtualCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spaceId, totalCount, onlineCount, batchCount, virtualCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Stats {\n");
        sb.append("    spaceId: ").append(toIndentedString(spaceId)).append("\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    onlineCount: ").append(toIndentedString(onlineCount)).append("\n");
        sb.append("    batchCount: ").append(toIndentedString(batchCount)).append("\n");
        sb.append("    virtualCount: ").append(toIndentedString(virtualCount)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
