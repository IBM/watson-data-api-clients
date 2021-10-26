/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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
import java.util.ArrayList;
import java.util.List;

/**
 * PolicyEnforcementContext
 */
public class PolicyEnforcementContext {

    private String user;
    private List<String> groups = null;
    private List<String> roles = null;
    private String country;
    private String operation;
    private List<String> operations = null;
    private String application;
    private Long currentTime;
    private Long lastUpdateTime;
    private String catalogId;
    private String bssAccountId;
    private Boolean transformForce;
    private String pepHostType;
    private String pepHostName;
    private String pepHostIp;
    private String pepVersion;
    private String physicalLocation;
    private String sovereignLocation;
    private String userAccessToken;
    private String platformPermissions;

    public PolicyEnforcementContext user(String user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @javax.annotation.Nullable
    @JsonProperty("user")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public PolicyEnforcementContext groups(List<String> groups) {
        this.groups = groups;
        return this;
    }

    public PolicyEnforcementContext addGroupsItem(String groupsItem) {
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.add(groupsItem);
        return this;
    }

    /**
     * Get groups
     * @return groups
     **/
    @javax.annotation.Nullable
    @JsonProperty("groups")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getGroups() {
        return groups;
    }
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public PolicyEnforcementContext roles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public PolicyEnforcementContext addRolesItem(String rolesItem) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * Get roles
     * @return roles
     **/
    @javax.annotation.Nullable
    @JsonProperty("roles")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public PolicyEnforcementContext country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     * @return country
     **/
    @javax.annotation.Nullable
    @JsonProperty("country")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public PolicyEnforcementContext operation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     * @return operation
     **/
    @javax.annotation.Nullable
    @JsonProperty("operation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public PolicyEnforcementContext operations(List<String> operations) {
        this.operations = operations;
        return this;
    }

    public PolicyEnforcementContext addOperationsItem(String operationsItem) {
        if (this.operations == null) {
            this.operations = new ArrayList<>();
        }
        this.operations.add(operationsItem);
        return this;
    }

    /**
     * Get operations
     * @return operations
     **/
    @javax.annotation.Nullable
    @JsonProperty("operations")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getOperations() {
        return operations;
    }
    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public PolicyEnforcementContext application(String application) {
        this.application = application;
        return this;
    }

    /**
     * Get application
     * @return application
     **/
    @javax.annotation.Nullable
    @JsonProperty("application")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getApplication() {
        return application;
    }
    public void setApplication(String application) {
        this.application = application;
    }

    public PolicyEnforcementContext currentTime(Long currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    /**
     * Get currentTime
     * @return currentTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("current_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public PolicyEnforcementContext lastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    /**
     * Get lastUpdateTime
     * @return lastUpdateTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_update_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public PolicyEnforcementContext catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    /**
     * Get catalogId
     * @return catalogId
     **/
    @javax.annotation.Nullable
    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() {
        return catalogId;
    }
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public PolicyEnforcementContext bssAccountId(String bssAccountId) {
        this.bssAccountId = bssAccountId;
        return this;
    }

    /**
     * Get bssAccountId
     * @return bssAccountId
     **/
    @javax.annotation.Nullable
    @JsonProperty("bss_account_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getBssAccountId() {
        return bssAccountId;
    }
    public void setBssAccountId(String bssAccountId) {
        this.bssAccountId = bssAccountId;
    }

    public PolicyEnforcementContext transformForce(Boolean transformForce) {
        this.transformForce = transformForce;
        return this;
    }

    /**
     * Get transformForce
     * @return transformForce
     **/
    @javax.annotation.Nullable
    @JsonProperty("transform_force")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getTransformForce() {
        return transformForce;
    }
    public void setTransformForce(Boolean transformForce) {
        this.transformForce = transformForce;
    }

    public PolicyEnforcementContext pepHostType(String pepHostType) {
        this.pepHostType = pepHostType;
        return this;
    }

    /**
     * Get pepHostType
     * @return pepHostType
     **/
    @javax.annotation.Nullable
    @JsonProperty("pep_host_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPepHostType() {
        return pepHostType;
    }
    public void setPepHostType(String pepHostType) {
        this.pepHostType = pepHostType;
    }

    public PolicyEnforcementContext pepHostName(String pepHostName) {
        this.pepHostName = pepHostName;
        return this;
    }

    /**
     * Get pepHostName
     * @return pepHostName
     **/
    @javax.annotation.Nullable
    @JsonProperty("pep_host_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPepHostName() {
        return pepHostName;
    }
    public void setPepHostName(String pepHostName) {
        this.pepHostName = pepHostName;
    }

    public PolicyEnforcementContext pepHostIp(String pepHostIp) {
        this.pepHostIp = pepHostIp;
        return this;
    }

    /**
     * Get pepHostIp
     * @return pepHostIp
     **/
    @javax.annotation.Nullable
    @JsonProperty("pep_host_ip")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPepHostIp() {
        return pepHostIp;
    }
    public void setPepHostIp(String pepHostIp) {
        this.pepHostIp = pepHostIp;
    }

    public PolicyEnforcementContext pepVersion(String pepVersion) {
        this.pepVersion = pepVersion;
        return this;
    }

    /**
     * Get pepVersion
     * @return pepVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty("pep_version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPepVersion() {
        return pepVersion;
    }
    public void setPepVersion(String pepVersion) {
        this.pepVersion = pepVersion;
    }

    public PolicyEnforcementContext physicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
        return this;
    }

    /**
     * Get physicalLocation
     * @return physicalLocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("physical_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPhysicalLocation() {
        return physicalLocation;
    }
    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    public PolicyEnforcementContext sovereignLocation(String sovereignLocation) {
        this.sovereignLocation = sovereignLocation;
        return this;
    }

    /**
     * Get sovereignLocation
     * @return sovereignLocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("sovereign_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSovereignLocation() {
        return sovereignLocation;
    }
    public void setSovereignLocation(String sovereignLocation) {
        this.sovereignLocation = sovereignLocation;
    }

    public PolicyEnforcementContext userAccessToken(String userAccessToken) {
        this.userAccessToken = userAccessToken;
        return this;
    }

    /**
     * Get userAccessToken
     * @return userAccessToken
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_access_token")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUserAccessToken() {
        return userAccessToken;
    }
    public void setUserAccessToken(String userAccessToken) {
        this.userAccessToken = userAccessToken;
    }

    public PolicyEnforcementContext platformPermissions(String platformPermissions) {
        this.platformPermissions = platformPermissions;
        return this;
    }

    /**
     * Get platformPermissions
     * @return platformPermissions
     **/
    @javax.annotation.Nullable
    @JsonProperty("platform_permissions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPlatformPermissions() {
        return platformPermissions;
    }
    public void setPlatformPermissions(String platformPermissions) {
        this.platformPermissions = platformPermissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyEnforcementContext policyEnforcementContext = (PolicyEnforcementContext) o;
        return Objects.equals(this.user, policyEnforcementContext.user) &&
                Objects.equals(this.groups, policyEnforcementContext.groups) &&
                Objects.equals(this.roles, policyEnforcementContext.roles) &&
                Objects.equals(this.country, policyEnforcementContext.country) &&
                Objects.equals(this.operation, policyEnforcementContext.operation) &&
                Objects.equals(this.operations, policyEnforcementContext.operations) &&
                Objects.equals(this.application, policyEnforcementContext.application) &&
                Objects.equals(this.currentTime, policyEnforcementContext.currentTime) &&
                Objects.equals(this.lastUpdateTime, policyEnforcementContext.lastUpdateTime) &&
                Objects.equals(this.catalogId, policyEnforcementContext.catalogId) &&
                Objects.equals(this.bssAccountId, policyEnforcementContext.bssAccountId) &&
                Objects.equals(this.transformForce, policyEnforcementContext.transformForce) &&
                Objects.equals(this.pepHostType, policyEnforcementContext.pepHostType) &&
                Objects.equals(this.pepHostName, policyEnforcementContext.pepHostName) &&
                Objects.equals(this.pepHostIp, policyEnforcementContext.pepHostIp) &&
                Objects.equals(this.pepVersion, policyEnforcementContext.pepVersion) &&
                Objects.equals(this.physicalLocation, policyEnforcementContext.physicalLocation) &&
                Objects.equals(this.sovereignLocation, policyEnforcementContext.sovereignLocation) &&
                Objects.equals(this.userAccessToken, policyEnforcementContext.userAccessToken) &&
                Objects.equals(this.platformPermissions, policyEnforcementContext.platformPermissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, groups, roles, country, operation, operations, application, currentTime, lastUpdateTime, catalogId, bssAccountId, transformForce, pepHostType, pepHostName, pepHostIp, pepVersion, physicalLocation, sovereignLocation, userAccessToken, platformPermissions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyEnforcementContext {\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
        sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
        sb.append("    application: ").append(toIndentedString(application)).append("\n");
        sb.append("    currentTime: ").append(toIndentedString(currentTime)).append("\n");
        sb.append("    lastUpdateTime: ").append(toIndentedString(lastUpdateTime)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    bssAccountId: ").append(toIndentedString(bssAccountId)).append("\n");
        sb.append("    transformForce: ").append(toIndentedString(transformForce)).append("\n");
        sb.append("    pepHostType: ").append(toIndentedString(pepHostType)).append("\n");
        sb.append("    pepHostName: ").append(toIndentedString(pepHostName)).append("\n");
        sb.append("    pepHostIp: ").append(toIndentedString(pepHostIp)).append("\n");
        sb.append("    pepVersion: ").append(toIndentedString(pepVersion)).append("\n");
        sb.append("    physicalLocation: ").append(toIndentedString(physicalLocation)).append("\n");
        sb.append("    sovereignLocation: ").append(toIndentedString(sovereignLocation)).append("\n");
        sb.append("    userAccessToken: ").append(toIndentedString(userAccessToken)).append("\n");
        sb.append("    platformPermissions: ").append(toIndentedString(platformPermissions)).append("\n");
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
