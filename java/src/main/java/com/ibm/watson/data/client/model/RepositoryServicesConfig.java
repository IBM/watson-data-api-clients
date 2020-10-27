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
 * RepositoryServicesConfig
 */
public class RepositoryServicesConfig {

    private List<Connection> auditLogConnections = null;
    private List<Connection> openMetadataArchiveConnections = null;
    private LocalRepositoryConfig localRepositoryConfig;
    private EnterpriseAccessConfig enterpriseAccessConfig;
    private List<CohortConfig> cohortConfigList = null;

    public RepositoryServicesConfig auditLogConnections(List<Connection> auditLogConnections) {
        this.auditLogConnections = auditLogConnections;
        return this;
    }

    public RepositoryServicesConfig addAuditLogConnectionsItem(Connection auditLogConnectionsItem) {
        if (this.auditLogConnections == null) {
            this.auditLogConnections = new ArrayList<>();
        }
        this.auditLogConnections.add(auditLogConnectionsItem);
        return this;
    }

    /**
     * Get auditLogConnections
     * @return auditLogConnections
     **/
    @javax.annotation.Nullable
    @JsonProperty("auditLogConnections")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Connection> getAuditLogConnections() { return auditLogConnections; }
    public void setAuditLogConnections(List<Connection> auditLogConnections) { this.auditLogConnections = auditLogConnections; }

    public RepositoryServicesConfig openMetadataArchiveConnections(List<Connection> openMetadataArchiveConnections) {
        this.openMetadataArchiveConnections = openMetadataArchiveConnections;
        return this;
    }

    public RepositoryServicesConfig addOpenMetadataArchiveConnectionsItem(Connection openMetadataArchiveConnectionsItem) {
        if (this.openMetadataArchiveConnections == null) {
            this.openMetadataArchiveConnections = new ArrayList<>();
        }
        this.openMetadataArchiveConnections.add(openMetadataArchiveConnectionsItem);
        return this;
    }

    /**
     * Get openMetadataArchiveConnections
     * @return openMetadataArchiveConnections
     **/
    @javax.annotation.Nullable
    @JsonProperty("openMetadataArchiveConnections")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Connection> getOpenMetadataArchiveConnections() { return openMetadataArchiveConnections; }
    public void setOpenMetadataArchiveConnections(List<Connection> openMetadataArchiveConnections) { this.openMetadataArchiveConnections = openMetadataArchiveConnections; }

    public RepositoryServicesConfig localRepositoryConfig(LocalRepositoryConfig localRepositoryConfig) {
        this.localRepositoryConfig = localRepositoryConfig;
        return this;
    }

    /**
     * Get localRepositoryConfig
     * @return localRepositoryConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("localRepositoryConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public LocalRepositoryConfig getLocalRepositoryConfig() { return localRepositoryConfig; }
    public void setLocalRepositoryConfig(LocalRepositoryConfig localRepositoryConfig) { this.localRepositoryConfig = localRepositoryConfig; }

    public RepositoryServicesConfig enterpriseAccessConfig(EnterpriseAccessConfig enterpriseAccessConfig) {
        this.enterpriseAccessConfig = enterpriseAccessConfig;
        return this;
    }

    /**
     * Get enterpriseAccessConfig
     * @return enterpriseAccessConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("enterpriseAccessConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EnterpriseAccessConfig getEnterpriseAccessConfig() { return enterpriseAccessConfig; }
    public void setEnterpriseAccessConfig(EnterpriseAccessConfig enterpriseAccessConfig) { this.enterpriseAccessConfig = enterpriseAccessConfig; }

    public RepositoryServicesConfig cohortConfigList(List<CohortConfig> cohortConfigList) {
        this.cohortConfigList = cohortConfigList;
        return this;
    }

    public RepositoryServicesConfig addCohortConfigListItem(CohortConfig cohortConfigListItem) {
        if (this.cohortConfigList == null) {
            this.cohortConfigList = new ArrayList<>();
        }
        this.cohortConfigList.add(cohortConfigListItem);
        return this;
    }

    /**
     * Get cohortConfigList
     * @return cohortConfigList
     **/
    @javax.annotation.Nullable
    @JsonProperty("cohortConfigList")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CohortConfig> getCohortConfigList() { return cohortConfigList; }
    public void setCohortConfigList(List<CohortConfig> cohortConfigList) { this.cohortConfigList = cohortConfigList; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RepositoryServicesConfig repositoryServicesConfig = (RepositoryServicesConfig)o;
        return Objects.equals(this.auditLogConnections, repositoryServicesConfig.auditLogConnections) &&
                Objects.equals(this.openMetadataArchiveConnections, repositoryServicesConfig.openMetadataArchiveConnections) &&
                Objects.equals(this.localRepositoryConfig, repositoryServicesConfig.localRepositoryConfig) &&
                Objects.equals(this.enterpriseAccessConfig, repositoryServicesConfig.enterpriseAccessConfig) &&
                Objects.equals(this.cohortConfigList, repositoryServicesConfig.cohortConfigList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auditLogConnections, openMetadataArchiveConnections,
                localRepositoryConfig, enterpriseAccessConfig,
                cohortConfigList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryServicesConfig {\n");
        sb.append("    auditLogConnections: ").append(toIndentedString(auditLogConnections)).append("\n");
        sb.append("    openMetadataArchiveConnections: ").append(toIndentedString(openMetadataArchiveConnections)).append("\n");
        sb.append("    localRepositoryConfig: ").append(toIndentedString(localRepositoryConfig)).append("\n");
        sb.append("    enterpriseAccessConfig: ").append(toIndentedString(enterpriseAccessConfig)).append("\n");
        sb.append("    cohortConfigList: ").append(toIndentedString(cohortConfigList)).append("\n");
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
