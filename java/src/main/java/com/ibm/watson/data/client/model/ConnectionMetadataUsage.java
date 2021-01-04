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
 * Metadata usage information about a connection asset
 */
public class ConnectionMetadataUsage {

    private Date lastAccessTime;
    private String lastAccessorId;
    private Integer accessCount;

    public ConnectionMetadataUsage lastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
        return this;
    }

    /**
     * The epoch-based timestamp when the asset was last accessed
     * @return lastAccessTime
     **/
    @JsonProperty("last_access_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastAccessTime() { return lastAccessTime; }
    public void setLastAccessTime(Date lastAccessTime) { this.lastAccessTime = lastAccessTime; }

    public ConnectionMetadataUsage lastAccessorId(String lastAccessorId) {
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

    public ConnectionMetadataUsage accessCount(Integer accessCount) {
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
        ConnectionMetadataUsage that = (ConnectionMetadataUsage)o;
        return Objects.equals(this.lastAccessTime, that.lastAccessTime) &&
                Objects.equals(this.lastAccessorId, that.lastAccessorId) &&
                Objects.equals(this.accessCount, that.accessCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastAccessTime, lastAccessorId, accessCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionMetadataUsage {\n");
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
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
