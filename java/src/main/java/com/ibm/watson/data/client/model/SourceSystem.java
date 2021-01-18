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
 * Source System Info
 */
public class SourceSystem {

    private Date creationTimestamp;
    private Long created;
    private Date lastModificationTimestamp;
    private Long lastModified;
    private String assetIdentifier;
    private String source;
    private String sourceSystemId;

    public SourceSystem creationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
        return this;
    }

    /**
     * Get creationTimestamp
     * @return creationTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("creation_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreationTimestamp() { return creationTimestamp; }
    public void setCreationTimestamp(Date creationTimestamp) { this.creationTimestamp = creationTimestamp; }

    public SourceSystem created(Long created) {
        this.created = created;
        return this;
    }

    /**
     * Get created
     * @return created
     **/
    @javax.annotation.Nullable
    @JsonProperty("created")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCreated() { return created; }
    public void setCreated(Long created) { this.created = created; }

    public SourceSystem lastModificationTimestamp(Date lastModificationTimestamp) {
        this.lastModificationTimestamp = lastModificationTimestamp;
        return this;
    }

    /**
     * Get lastModificationTimestamp
     * @return lastModificationTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_modification_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastModificationTimestamp() { return lastModificationTimestamp; }
    public void setLastModificationTimestamp(Date lastModificationTimestamp) { this.lastModificationTimestamp = lastModificationTimestamp; }

    public SourceSystem lastModified(Long lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    /**
     * Get lastModified
     * @return lastModified
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_modified")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLastModified() { return lastModified; }
    public void setLastModified(Long lastModified) { this.lastModified = lastModified; }

    public SourceSystem assetIdentifier(String assetIdentifier) {
        this.assetIdentifier = assetIdentifier;
        return this;
    }

    /**
     * Get assetIdentifier
     * @return assetIdentifier
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_identifier")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetIdentifier() { return assetIdentifier; }
    public void setAssetIdentifier(String assetIdentifier) { this.assetIdentifier = assetIdentifier; }

    public SourceSystem source(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     * @return source
     **/
    @javax.annotation.Nullable
    @JsonProperty("source")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public SourceSystem sourceSystemId(String sourceSystemId) {
        this.sourceSystemId = sourceSystemId;
        return this;
    }

    /**
     * Get sourceSystemId
     * @return sourceSystemId
     **/
    @javax.annotation.Nullable
    @JsonProperty("source_system_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSourceSystemId() { return sourceSystemId; }
    public void setSourceSystemId(String sourceSystemId) { this.sourceSystemId = sourceSystemId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SourceSystem sourceSystem = (SourceSystem)o;
        return Objects.equals(this.creationTimestamp, sourceSystem.creationTimestamp) &&
                Objects.equals(this.created, sourceSystem.created) &&
                Objects.equals(this.lastModificationTimestamp, sourceSystem.lastModificationTimestamp) &&
                Objects.equals(this.lastModified, sourceSystem.lastModified) &&
                Objects.equals(this.assetIdentifier, sourceSystem.assetIdentifier) &&
                Objects.equals(this.source, sourceSystem.source) &&
                Objects.equals(this.sourceSystemId, sourceSystem.sourceSystemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationTimestamp, created, lastModificationTimestamp,
                lastModified, assetIdentifier, source, sourceSystemId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SourceSystem {\n");
        sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    lastModificationTimestamp: ").append(toIndentedString(lastModificationTimestamp)).append("\n");
        sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
        sb.append("    assetIdentifier: ").append(toIndentedString(assetIdentifier)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
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
