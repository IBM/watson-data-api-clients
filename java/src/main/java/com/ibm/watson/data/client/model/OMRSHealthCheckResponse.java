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
import java.util.Objects;

/**
 * OMRSHealthCheckResponse
 */
public class OMRSHealthCheckResponse {

    private String status;
    private String metadataCollectionId;
    private String serverName;
    private String serverType;
    private String organizationName;

    public OMRSHealthCheckResponse status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public OMRSHealthCheckResponse metadataCollectionId(String metadataCollectionId) {
        this.metadataCollectionId = metadataCollectionId;
        return this;
    }

    /**
     * Get metadataCollectionId
     * @return metadataCollectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadata_collection_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMetadataCollectionId() { return metadataCollectionId; }
    public void setMetadataCollectionId(String metadataCollectionId) { this.metadataCollectionId = metadataCollectionId; }

    public OMRSHealthCheckResponse serverName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    /**
     * Get serverName
     * @return serverName
     **/
    @javax.annotation.Nullable
    @JsonProperty("server_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getServerName() { return serverName; }
    public void setServerName(String serverName) { this.serverName = serverName; }

    public OMRSHealthCheckResponse serverType(String serverType) {
        this.serverType = serverType;
        return this;
    }

    /**
     * Get serverType
     * @return serverType
     **/
    @javax.annotation.Nullable
    @JsonProperty("server_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getServerType() { return serverType; }
    public void setServerType(String serverType) { this.serverType = serverType; }

    public OMRSHealthCheckResponse organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    /**
     * Get organizationName
     * @return organizationName
     **/
    @javax.annotation.Nullable
    @JsonProperty("organization_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOrganizationName() { return organizationName; }
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OMRSHealthCheckResponse omRSHealthCheckResponse = (OMRSHealthCheckResponse)o;
        return Objects.equals(this.status, omRSHealthCheckResponse.status) &&
                Objects.equals(this.metadataCollectionId, omRSHealthCheckResponse.metadataCollectionId) &&
                Objects.equals(this.serverName, omRSHealthCheckResponse.serverName) &&
                Objects.equals(this.serverType, omRSHealthCheckResponse.serverType) &&
                Objects.equals(this.organizationName, omRSHealthCheckResponse.organizationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, metadataCollectionId, serverName, serverType,
                organizationName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OMRSHealthCheckResponse {\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    metadataCollectionId: ").append(toIndentedString(metadataCollectionId)).append("\n");
        sb.append("    serverName: ").append(toIndentedString(serverName)).append("\n");
        sb.append("    serverType: ").append(toIndentedString(serverType)).append("\n");
        sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
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
