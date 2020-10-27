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
 * OMAGServerConfig
 */
public class OMAGServerConfig {

    private String versionId;
    private String localServerId;
    private String localServerName;
    private String localServerType;
    private String organizationName;
    private String localServerURL;
    private String localServerUserId;
    private String localServerPassword;
    private Integer maxPageSize;
    private Connection serverSecurityConnection;
    private EventBusConfig eventBusConfig;
    private List<AccessServiceConfig> accessServicesConfig = null;
    private RepositoryServicesConfig repositoryServicesConfig;
    private ConformanceSuiteConfig conformanceSuiteConfig;
    private DiscoveryServerConfig discoveryServerConfig;
    private OpenLineageConfig openLineageConfig;
    private StewardshipServicesConfig stewardshipServicesConfig;
    private SecuritySyncConfig securitySyncConfig;
    private SecurityOfficerConfig securityOfficerConfig;
    private List<String> auditTrail = null;
    private VirtualizationConfig virtualizationConfig;
    private DataEngineProxyConfig dataEngineProxyConfig;
    private DataPlatformConfig dataPlatformConfig;

    public OMAGServerConfig versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * Get versionId
     * @return versionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("versionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    public OMAGServerConfig localServerId(String localServerId) {
        this.localServerId = localServerId;
        return this;
    }

    /**
     * Get localServerId
     * @return localServerId
     **/
    @javax.annotation.Nullable
    @JsonProperty("localServerId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLocalServerId() { return localServerId; }
    public void setLocalServerId(String localServerId) { this.localServerId = localServerId; }

    public OMAGServerConfig localServerName(String localServerName) {
        this.localServerName = localServerName;
        return this;
    }

    /**
     * Get localServerName
     * @return localServerName
     **/
    @javax.annotation.Nullable
    @JsonProperty("localServerName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLocalServerName() { return localServerName; }
    public void setLocalServerName(String localServerName) { this.localServerName = localServerName; }

    public OMAGServerConfig localServerType(String localServerType) {
        this.localServerType = localServerType;
        return this;
    }

    /**
     * Get localServerType
     * @return localServerType
     **/
    @javax.annotation.Nullable
    @JsonProperty("localServerType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLocalServerType() { return localServerType; }
    public void setLocalServerType(String localServerType) { this.localServerType = localServerType; }

    public OMAGServerConfig organizationName(String organizationName) {
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

    public OMAGServerConfig localServerURL(String localServerURL) {
        this.localServerURL = localServerURL;
        return this;
    }

    /**
     * Get localServerURL
     * @return localServerURL
     **/
    @javax.annotation.Nullable
    @JsonProperty("localServerURL")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLocalServerURL() { return localServerURL; }
    public void setLocalServerURL(String localServerURL) { this.localServerURL = localServerURL; }

    public OMAGServerConfig localServerUserId(String localServerUserId) {
        this.localServerUserId = localServerUserId;
        return this;
    }

    /**
     * Get localServerUserId
     * @return localServerUserId
     **/
    @javax.annotation.Nullable
    @JsonProperty("localServerUserId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLocalServerUserId() { return localServerUserId; }
    public void setLocalServerUserId(String localServerUserId) { this.localServerUserId = localServerUserId; }

    public OMAGServerConfig localServerPassword(String localServerPassword) {
        this.localServerPassword = localServerPassword;
        return this;
    }

    /**
     * Get localServerPassword
     * @return localServerPassword
     **/
    @javax.annotation.Nullable
    @JsonProperty("localServerPassword")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLocalServerPassword() { return localServerPassword; }
    public void setLocalServerPassword(String localServerPassword) { this.localServerPassword = localServerPassword; }

    public OMAGServerConfig maxPageSize(Integer maxPageSize) {
        this.maxPageSize = maxPageSize;
        return this;
    }

    /**
     * Get maxPageSize
     * @return maxPageSize
     **/
    @javax.annotation.Nullable
    @JsonProperty("maxPageSize")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMaxPageSize() { return maxPageSize; }
    public void setMaxPageSize(Integer maxPageSize) { this.maxPageSize = maxPageSize; }

    public OMAGServerConfig serverSecurityConnection(Connection serverSecurityConnection) {
        this.serverSecurityConnection = serverSecurityConnection;
        return this;
    }

    /**
     * Get serverSecurityConnection
     * @return serverSecurityConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("serverSecurityConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getServerSecurityConnection() { return serverSecurityConnection; }
    public void setServerSecurityConnection(Connection serverSecurityConnection) { this.serverSecurityConnection = serverSecurityConnection; }

    public OMAGServerConfig eventBusConfig(EventBusConfig eventBusConfig) {
        this.eventBusConfig = eventBusConfig;
        return this;
    }

    /**
     * Get eventBusConfig
     * @return eventBusConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("eventBusConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EventBusConfig getEventBusConfig() { return eventBusConfig; }
    public void setEventBusConfig(EventBusConfig eventBusConfig) { this.eventBusConfig = eventBusConfig; }

    public OMAGServerConfig accessServicesConfig(List<AccessServiceConfig> accessServicesConfig) {
        this.accessServicesConfig = accessServicesConfig;
        return this;
    }

    public OMAGServerConfig addAccessServicesConfigItem(AccessServiceConfig accessServicesConfigItem) {
        if (this.accessServicesConfig == null) {
            this.accessServicesConfig = new ArrayList<>();
        }
        this.accessServicesConfig.add(accessServicesConfigItem);
        return this;
    }

    /**
     * Get accessServicesConfig
     * @return accessServicesConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServicesConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AccessServiceConfig> getAccessServicesConfig() { return accessServicesConfig; }
    public void setAccessServicesConfig(List<AccessServiceConfig> accessServicesConfig) { this.accessServicesConfig = accessServicesConfig; }

    public OMAGServerConfig repositoryServicesConfig(RepositoryServicesConfig repositoryServicesConfig) {
        this.repositoryServicesConfig = repositoryServicesConfig;
        return this;
    }

    /**
     * Get repositoryServicesConfig
     * @return repositoryServicesConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("repositoryServicesConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public RepositoryServicesConfig getRepositoryServicesConfig() { return repositoryServicesConfig; }
    public void setRepositoryServicesConfig(RepositoryServicesConfig repositoryServicesConfig) { this.repositoryServicesConfig = repositoryServicesConfig; }

    public OMAGServerConfig conformanceSuiteConfig(ConformanceSuiteConfig conformanceSuiteConfig) {
        this.conformanceSuiteConfig = conformanceSuiteConfig;
        return this;
    }

    /**
     * Get conformanceSuiteConfig
     * @return conformanceSuiteConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("conformanceSuiteConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ConformanceSuiteConfig getConformanceSuiteConfig() { return conformanceSuiteConfig; }
    public void setConformanceSuiteConfig(ConformanceSuiteConfig conformanceSuiteConfig) { this.conformanceSuiteConfig = conformanceSuiteConfig; }

    public OMAGServerConfig discoveryServerConfig(DiscoveryServerConfig discoveryServerConfig) {
        this.discoveryServerConfig = discoveryServerConfig;
        return this;
    }

    /**
     * Get discoveryServerConfig
     * @return discoveryServerConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("discoveryServerConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DiscoveryServerConfig getDiscoveryServerConfig() { return discoveryServerConfig; }
    public void setDiscoveryServerConfig(DiscoveryServerConfig discoveryServerConfig) { this.discoveryServerConfig = discoveryServerConfig; }

    public OMAGServerConfig openLineageConfig(OpenLineageConfig openLineageConfig) {
        this.openLineageConfig = openLineageConfig;
        return this;
    }

    /**
     * Get openLineageConfig
     * @return openLineageConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OpenLineageConfig getOpenLineageConfig() { return openLineageConfig; }
    public void setOpenLineageConfig(OpenLineageConfig openLineageConfig) { this.openLineageConfig = openLineageConfig; }

    public OMAGServerConfig stewardshipServicesConfig(StewardshipServicesConfig stewardshipServicesConfig) {
        this.stewardshipServicesConfig = stewardshipServicesConfig;
        return this;
    }

    /**
     * Get stewardshipServicesConfig
     * @return stewardshipServicesConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("stewardshipServicesConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public StewardshipServicesConfig getStewardshipServicesConfig() { return stewardshipServicesConfig; }
    public void setStewardshipServicesConfig(StewardshipServicesConfig stewardshipServicesConfig) { this.stewardshipServicesConfig = stewardshipServicesConfig; }

    public OMAGServerConfig securitySyncConfig(SecuritySyncConfig securitySyncConfig) {
        this.securitySyncConfig = securitySyncConfig;
        return this;
    }

    /**
     * Get securitySyncConfig
     * @return securitySyncConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SecuritySyncConfig getSecuritySyncConfig() { return securitySyncConfig; }
    public void setSecuritySyncConfig(SecuritySyncConfig securitySyncConfig) { this.securitySyncConfig = securitySyncConfig; }

    public OMAGServerConfig securityOfficerConfig(SecurityOfficerConfig securityOfficerConfig) {
        this.securityOfficerConfig = securityOfficerConfig;
        return this;
    }

    /**
     * Get securityOfficerConfig
     * @return securityOfficerConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("securityOfficerConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SecurityOfficerConfig getSecurityOfficerConfig() { return securityOfficerConfig; }
    public void setSecurityOfficerConfig(SecurityOfficerConfig securityOfficerConfig) { this.securityOfficerConfig = securityOfficerConfig; }

    public OMAGServerConfig auditTrail(List<String> auditTrail) {
        this.auditTrail = auditTrail;
        return this;
    }

    public OMAGServerConfig addAuditTrailItem(String auditTrailItem) {
        if (this.auditTrail == null) {
            this.auditTrail = new ArrayList<>();
        }
        this.auditTrail.add(auditTrailItem);
        return this;
    }

    /**
     * Get auditTrail
     * @return auditTrail
     **/
    @javax.annotation.Nullable
    @JsonProperty("auditTrail")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAuditTrail() { return auditTrail; }
    public void setAuditTrail(List<String> auditTrail) { this.auditTrail = auditTrail; }

    public OMAGServerConfig virtualizationConfig(VirtualizationConfig virtualizationConfig) {
        this.virtualizationConfig = virtualizationConfig;
        return this;
    }

    /**
     * Get virtualizationConfig
     * @return virtualizationConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizationConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public VirtualizationConfig getVirtualizationConfig() { return virtualizationConfig; }
    public void setVirtualizationConfig(VirtualizationConfig virtualizationConfig) { this.virtualizationConfig = virtualizationConfig; }

    public OMAGServerConfig dataEngineProxyConfig(DataEngineProxyConfig dataEngineProxyConfig) {
        this.dataEngineProxyConfig = dataEngineProxyConfig;
        return this;
    }

    /**
     * Get dataEngineProxyConfig
     * @return dataEngineProxyConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataEngineProxyConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataEngineProxyConfig getDataEngineProxyConfig() { return dataEngineProxyConfig; }
    public void setDataEngineProxyConfig(DataEngineProxyConfig dataEngineProxyConfig) { this.dataEngineProxyConfig = dataEngineProxyConfig; }

    public OMAGServerConfig dataPlatformConfig(DataPlatformConfig dataPlatformConfig) {
        this.dataPlatformConfig = dataPlatformConfig;
        return this;
    }

    /**
     * Get dataPlatformConfig
     * @return dataPlatformConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataPlatformConfig getDataPlatformConfig() { return dataPlatformConfig; }
    public void setDataPlatformConfig(DataPlatformConfig dataPlatformConfig) { this.dataPlatformConfig = dataPlatformConfig; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OMAGServerConfig omAGServerConfig = (OMAGServerConfig)o;
        return Objects.equals(this.versionId, omAGServerConfig.versionId) &&
                Objects.equals(this.localServerId, omAGServerConfig.localServerId) &&
                Objects.equals(this.localServerName, omAGServerConfig.localServerName) &&
                Objects.equals(this.localServerType, omAGServerConfig.localServerType) &&
                Objects.equals(this.organizationName, omAGServerConfig.organizationName) &&
                Objects.equals(this.localServerURL, omAGServerConfig.localServerURL) &&
                Objects.equals(this.localServerUserId, omAGServerConfig.localServerUserId) &&
                Objects.equals(this.localServerPassword, omAGServerConfig.localServerPassword) &&
                Objects.equals(this.maxPageSize, omAGServerConfig.maxPageSize) &&
                Objects.equals(this.serverSecurityConnection, omAGServerConfig.serverSecurityConnection) &&
                Objects.equals(this.eventBusConfig, omAGServerConfig.eventBusConfig) &&
                Objects.equals(this.accessServicesConfig, omAGServerConfig.accessServicesConfig) &&
                Objects.equals(this.repositoryServicesConfig, omAGServerConfig.repositoryServicesConfig) &&
                Objects.equals(this.conformanceSuiteConfig, omAGServerConfig.conformanceSuiteConfig) &&
                Objects.equals(this.discoveryServerConfig, omAGServerConfig.discoveryServerConfig) &&
                Objects.equals(this.openLineageConfig, omAGServerConfig.openLineageConfig) &&
                Objects.equals(this.stewardshipServicesConfig, omAGServerConfig.stewardshipServicesConfig) &&
                Objects.equals(this.securitySyncConfig, omAGServerConfig.securitySyncConfig) &&
                Objects.equals(this.securityOfficerConfig, omAGServerConfig.securityOfficerConfig) &&
                Objects.equals(this.auditTrail, omAGServerConfig.auditTrail) &&
                Objects.equals(this.virtualizationConfig, omAGServerConfig.virtualizationConfig) &&
                Objects.equals(this.dataEngineProxyConfig, omAGServerConfig.dataEngineProxyConfig) &&
                Objects.equals(this.dataPlatformConfig, omAGServerConfig.dataPlatformConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                versionId, localServerId, localServerName, localServerType,
                organizationName, localServerURL, localServerUserId,
                localServerPassword, maxPageSize, serverSecurityConnection,
                eventBusConfig, accessServicesConfig, repositoryServicesConfig,
                conformanceSuiteConfig, discoveryServerConfig, openLineageConfig,
                stewardshipServicesConfig, securitySyncConfig, securityOfficerConfig,
                auditTrail, virtualizationConfig, dataEngineProxyConfig,
                dataPlatformConfig);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OMAGServerConfig {\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
        sb.append("    localServerId: ").append(toIndentedString(localServerId)).append("\n");
        sb.append("    localServerName: ").append(toIndentedString(localServerName)).append("\n");
        sb.append("    localServerType: ").append(toIndentedString(localServerType)).append("\n");
        sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
        sb.append("    localServerURL: ").append(toIndentedString(localServerURL)).append("\n");
        sb.append("    localServerUserId: ").append(toIndentedString(localServerUserId)).append("\n");
        sb.append("    localServerPassword: ").append(toIndentedString(localServerPassword)).append("\n");
        sb.append("    maxPageSize: ").append(toIndentedString(maxPageSize)).append("\n");
        sb.append("    serverSecurityConnection: ").append(toIndentedString(serverSecurityConnection)).append("\n");
        sb.append("    eventBusConfig: ").append(toIndentedString(eventBusConfig)).append("\n");
        sb.append("    accessServicesConfig: ").append(toIndentedString(accessServicesConfig)).append("\n");
        sb.append("    repositoryServicesConfig: ").append(toIndentedString(repositoryServicesConfig)).append("\n");
        sb.append("    conformanceSuiteConfig: ").append(toIndentedString(conformanceSuiteConfig)).append("\n");
        sb.append("    discoveryServerConfig: ").append(toIndentedString(discoveryServerConfig)).append("\n");
        sb.append("    openLineageConfig: ").append(toIndentedString(openLineageConfig)).append("\n");
        sb.append("    stewardshipServicesConfig: ").append(toIndentedString(stewardshipServicesConfig)).append("\n");
        sb.append("    securitySyncConfig: ").append(toIndentedString(securitySyncConfig)).append("\n");
        sb.append("    securityOfficerConfig: ").append(toIndentedString(securityOfficerConfig)).append("\n");
        sb.append("    auditTrail: ").append(toIndentedString(auditTrail)).append("\n");
        sb.append("    virtualizationConfig: ").append(toIndentedString(virtualizationConfig)).append("\n");
        sb.append("    dataEngineProxyConfig: ").append(toIndentedString(dataEngineProxyConfig)).append("\n");
        sb.append("    dataPlatformConfig: ").append(toIndentedString(dataPlatformConfig)).append("\n");
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
