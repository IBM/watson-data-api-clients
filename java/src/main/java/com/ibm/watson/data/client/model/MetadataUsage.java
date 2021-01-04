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
 * Metadata usage information about an asset
 */
public class MetadataUsage {

    private Date lastUpdatedAt;
    private String lastUpdaterId;
    private Long lastUpdateTime;
    private Date lastAccessedAt;
    private Long lastAccessTime;
    private String lastAccessorId;
    private Integer accessCount;

    public MetadataUsage lastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    /**
     * The timestamp when the asset was last modified (in format
     * YYYY-MM-DDTHH:mm:ssZ or YYYY-MM-DDTHH:mm:ss.sssZ, matching the date-time
     * format as specified by RFC 3339)
     * @return lastUpdatedAt
     **/
    @JsonProperty("last_updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Date lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }

    public MetadataUsage lastUpdaterId(String lastUpdaterId) {
        this.lastUpdaterId = lastUpdaterId;
        return this;
    }

    /**
     * The IAM ID of the user that last modified the asset
     * @return lastUpdaterId
     **/
    @JsonProperty("last_updater_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLastUpdaterId() { return lastUpdaterId; }
    public void setLastUpdaterId(String lastUpdaterId) { this.lastUpdaterId = lastUpdaterId; }

    public MetadataUsage lastUpdateTime(Long lastAccessTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    /**
     * The epoch-based timestamp when the asset was last updated
     * @return lastUpdateTime
     **/
    @JsonProperty("last_update_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(Long lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }

    public MetadataUsage lastAccessedAt(Date lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
        return this;
    }

    /**
     * The timestamp when the asset was last accessed (in format
     * YYYY-MM-DDTHH:mm:ssZ or YYYY-MM-DDTHH:mm:ss.sssZ, matching the date-time
     * format as specified by RFC 3339)
     * @return lastAccessedAt
     **/
    @JsonProperty("last_accessed_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastAccessedAt() { return lastAccessedAt; }
    public void setLastAccessedAt(Date lastAccessedAt) { this.lastAccessedAt = lastAccessedAt; }

    public MetadataUsage lastAccessTime(Long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
        return this;
    }

    /**
     * The epoch-based timestamp when the asset was last accessed
     * @return lastAccessTime
     **/
    @JsonProperty("last_access_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLastAccessTime() { return lastAccessTime; }
    public void setLastAccessTime(Long lastAccessTime) { this.lastAccessTime = lastAccessTime; }

    public MetadataUsage lastAccessorId(String lastAccessorId) {
        this.lastAccessorId = lastAccessorId;
        return this;
    }

    /**
     * The IAM ID of the user that last accessed the asset
     * @return lastAccessorId
     **/
    @JsonProperty("last_accessor_id")
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getLastAccessorId() { return lastAccessorId; }
    public void setLastAccessorId(String lastAccessorId) { this.lastAccessorId = lastAccessorId; }

    public MetadataUsage accessCount(Integer accessCount) {
        this.accessCount = accessCount;
        return this;
    }

    /**
     * Number of times this asset has been accessed
     * @return accessCount
     **/
    @JsonProperty("access_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getAccessCount() { return accessCount; }
    public void setAccessCount(Integer accessCount) { this.accessCount = accessCount; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataUsage metadataUsage = (MetadataUsage)o;
        return Objects.equals(this.lastUpdatedAt, metadataUsage.lastUpdatedAt) &&
                Objects.equals(this.lastUpdaterId, metadataUsage.lastUpdaterId) &&
                Objects.equals(this.lastUpdateTime, metadataUsage.lastUpdateTime) &&
                Objects.equals(this.lastAccessedAt, metadataUsage.lastAccessedAt) &&
                Objects.equals(this.lastAccessTime, metadataUsage.lastAccessTime) &&
                Objects.equals(this.lastAccessorId, metadataUsage.lastAccessorId) &&
                Objects.equals(this.accessCount, metadataUsage.accessCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdatedAt, lastUpdaterId, lastUpdateTime, lastAccessedAt,
                lastAccessTime, lastAccessorId, accessCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataUsage {\n");
        sb.append("    lastUpdatedAt: ").append(toIndentedString(lastUpdatedAt)).append("\n");
        sb.append("    lastUpdaterId: ").append(toIndentedString(lastUpdaterId)).append("\n");
        sb.append("    lastUpdateTime: ").append(toIndentedString(lastUpdateTime)).append("\n");
        sb.append("    lastAccessedAt: ").append(toIndentedString(lastAccessedAt)).append("\n");
        sb.append("    lastAccessTime: ").append(toIndentedString(lastAccessTime)).append("\n");
        sb.append("    lastAccessorId: ").append(toIndentedString(lastAccessorId)).append("\n");
        sb.append("    accessCount: ").append(toIndentedString(accessCount)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
