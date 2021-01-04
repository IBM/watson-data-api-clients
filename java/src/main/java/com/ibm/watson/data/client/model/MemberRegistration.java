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
 * MemberRegistration
 */
public class MemberRegistration {

    private String metadataCollectionId;
    private String metadataCollectionName;
    private String serverName;
    private String serverType;
    private String organizationName;
    private Date registrationTime;
    private Connection repositoryConnection;

    public MemberRegistration metadataCollectionId(String metadataCollectionId) {
        this.metadataCollectionId = metadataCollectionId;
        return this;
    }

    /**
     * Get metadataCollectionId
     * @return metadataCollectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadataCollectionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMetadataCollectionId() { return metadataCollectionId; }
    public void setMetadataCollectionId(String metadataCollectionId) { this.metadataCollectionId = metadataCollectionId; }

    public MemberRegistration metadataCollectionName(String metadataCollectionName) {
        this.metadataCollectionName = metadataCollectionName;
        return this;
    }

    /**
     * Get metadataCollectionName
     * @return metadataCollectionName
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadataCollectionName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMetadataCollectionName() { return metadataCollectionName; }
    public void setMetadataCollectionName(String metadataCollectionName) { this.metadataCollectionName = metadataCollectionName; }

    public MemberRegistration serverName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    /**
     * Get serverName
     * @return serverName
     **/
    @javax.annotation.Nullable
    @JsonProperty("serverName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getServerName() { return serverName; }
    public void setServerName(String serverName) { this.serverName = serverName; }

    public MemberRegistration serverType(String serverType) {
        this.serverType = serverType;
        return this;
    }

    /**
     * Get serverType
     * @return serverType
     **/
    @javax.annotation.Nullable
    @JsonProperty("serverType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getServerType() { return serverType; }
    public void setServerType(String serverType) { this.serverType = serverType; }

    public MemberRegistration organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    /**
     * Get organizationName
     * @return organizationName
     **/
    @javax.annotation.Nullable
    @JsonProperty("organizationName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOrganizationName() { return organizationName; }
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }

    public MemberRegistration registrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
        return this;
    }

    /**
     * Get registrationTime
     * @return registrationTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("registrationTime")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getRegistrationTime() { return registrationTime; }
    public void setRegistrationTime(Date registrationTime) { this.registrationTime = registrationTime; }

    public MemberRegistration repositoryConnection(Connection repositoryConnection) {
        this.repositoryConnection = repositoryConnection;
        return this;
    }

    /**
     * Get repositoryConnection
     * @return repositoryConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("repositoryConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getRepositoryConnection() { return repositoryConnection; }
    public void setRepositoryConnection(Connection repositoryConnection) { this.repositoryConnection = repositoryConnection; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MemberRegistration memberRegistration = (MemberRegistration)o;
        return Objects.equals(this.metadataCollectionId, memberRegistration.metadataCollectionId) &&
                Objects.equals(this.metadataCollectionName, memberRegistration.metadataCollectionName) &&
                Objects.equals(this.serverName, memberRegistration.serverName) &&
                Objects.equals(this.serverType, memberRegistration.serverType) &&
                Objects.equals(this.organizationName, memberRegistration.organizationName) &&
                Objects.equals(this.registrationTime, memberRegistration.registrationTime) &&
                Objects.equals(this.repositoryConnection, memberRegistration.repositoryConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadataCollectionId, metadataCollectionName,
                serverName, serverType, organizationName,
                registrationTime, repositoryConnection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MemberRegistration {\n");
        sb.append("    metadataCollectionId: ").append(toIndentedString(metadataCollectionId)).append("\n");
        sb.append("    metadataCollectionName: ").append(toIndentedString(metadataCollectionName)).append("\n");
        sb.append("    serverName: ").append(toIndentedString(serverName)).append("\n");
        sb.append("    serverType: ").append(toIndentedString(serverType)).append("\n");
        sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
        sb.append("    registrationTime: ").append(toIndentedString(registrationTime)).append("\n");
        sb.append("    repositoryConnection: ").append(toIndentedString(repositoryConnection)).append("\n");
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
