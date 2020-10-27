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
 * SecuritySyncConfig
 */
public class SecuritySyncConfig {

    private String accessServiceRootURL;
    private String accessServiceServerName;
    private String securityServerURL;
    private String securitySyncServerType;
    private String securitySyncServerAuthorization;
    private String securitySyncTagServiceName;
    private String securitySyncAccessResourceServiceName;
    private Long pollingInterval;
    private Connection securitySyncServerConnection;
    private String securitySyncInTopicName;
    private Connection securitySyncInTopic;
    private String securitySyncOutTopicName;
    private Connection securitySyncOutTopic;

    public SecuritySyncConfig accessServiceRootURL(String accessServiceRootURL) {

        this.accessServiceRootURL = accessServiceRootURL;
        return this;
    }

    /**
     * Get accessServiceRootURL
     * @return accessServiceRootURL
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceRootURL")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceRootURL() { return accessServiceRootURL; }
    public void setAccessServiceRootURL(String accessServiceRootURL) { this.accessServiceRootURL = accessServiceRootURL; }

    public SecuritySyncConfig accessServiceServerName(String accessServiceServerName) {
        this.accessServiceServerName = accessServiceServerName;
        return this;
    }

    /**
     * Get accessServiceServerName
     * @return accessServiceServerName
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceServerName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceServerName() { return accessServiceServerName; }
    public void setAccessServiceServerName(String accessServiceServerName) { this.accessServiceServerName = accessServiceServerName; }

    public SecuritySyncConfig securityServerURL(String securityServerURL) {
        this.securityServerURL = securityServerURL;
        return this;
    }

    /**
     * Get securityServerURL
     * @return securityServerURL
     **/
    @javax.annotation.Nullable
    @JsonProperty("securityServerURL")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecurityServerURL() { return securityServerURL; }
    public void setSecurityServerURL(String securityServerURL) { this.securityServerURL = securityServerURL; }

    public SecuritySyncConfig securitySyncServerType(String securitySyncServerType) {
        this.securitySyncServerType = securitySyncServerType;
        return this;
    }

    /**
     * Get securitySyncServerType
     * @return securitySyncServerType
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncServerType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecuritySyncServerType() { return securitySyncServerType; }
    public void setSecuritySyncServerType(String securitySyncServerType) { this.securitySyncServerType = securitySyncServerType; }

    public SecuritySyncConfig securitySyncServerAuthorization(String securitySyncServerAuthorization) {
        this.securitySyncServerAuthorization = securitySyncServerAuthorization;
        return this;
    }

    /**
     * Get securitySyncServerAuthorization
     * @return securitySyncServerAuthorization
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncServerAuthorization")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecuritySyncServerAuthorization() { return securitySyncServerAuthorization; }
    public void setSecuritySyncServerAuthorization(String securitySyncServerAuthorization) { this.securitySyncServerAuthorization = securitySyncServerAuthorization; }

    public SecuritySyncConfig securitySyncTagServiceName(String securitySyncTagServiceName) {
        this.securitySyncTagServiceName = securitySyncTagServiceName;
        return this;
    }

    /**
     * Get securitySyncTagServiceName
     * @return securitySyncTagServiceName
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncTagServiceName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecuritySyncTagServiceName() { return securitySyncTagServiceName; }
    public void setSecuritySyncTagServiceName(String securitySyncTagServiceName) { this.securitySyncTagServiceName = securitySyncTagServiceName; }

    public SecuritySyncConfig securitySyncAccessResourceServiceName(String securitySyncAccessResourceServiceName) {
        this.securitySyncAccessResourceServiceName = securitySyncAccessResourceServiceName;
        return this;
    }

    /**
     * Get securitySyncAccessResourceServiceName
     * @return securitySyncAccessResourceServiceName
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncAccessResourceServiceName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecuritySyncAccessResourceServiceName() { return securitySyncAccessResourceServiceName; }
    public void setSecuritySyncAccessResourceServiceName(String securitySyncAccessResourceServiceName) { this.securitySyncAccessResourceServiceName = securitySyncAccessResourceServiceName; }

    public SecuritySyncConfig pollingInterval(Long pollingInterval) {
        this.pollingInterval = pollingInterval;
        return this;
    }

    /**
     * Get pollingInterval
     * @return pollingInterval
     **/
    @javax.annotation.Nullable
    @JsonProperty("pollingInterval")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getPollingInterval() { return pollingInterval; }
    public void setPollingInterval(Long pollingInterval) { this.pollingInterval = pollingInterval; }

    public SecuritySyncConfig securitySyncServerConnection(Connection securitySyncServerConnection) {
        this.securitySyncServerConnection = securitySyncServerConnection;
        return this;
    }

    /**
     * Get securitySyncServerConnection
     * @return securitySyncServerConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncServerConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getSecuritySyncServerConnection() { return securitySyncServerConnection; }
    public void setSecuritySyncServerConnection(Connection securitySyncServerConnection) { this.securitySyncServerConnection = securitySyncServerConnection; }

    public SecuritySyncConfig securitySyncInTopicName(String securitySyncInTopicName) {
        this.securitySyncInTopicName = securitySyncInTopicName;
        return this;
    }

    /**
     * Get securitySyncInTopicName
     * @return securitySyncInTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncInTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecuritySyncInTopicName() { return securitySyncInTopicName; }
    public void setSecuritySyncInTopicName(String securitySyncInTopicName) { this.securitySyncInTopicName = securitySyncInTopicName; }

    public SecuritySyncConfig securitySyncInTopic(Connection securitySyncInTopic) {
        this.securitySyncInTopic = securitySyncInTopic;
        return this;
    }

    /**
     * Get securitySyncInTopic
     * @return securitySyncInTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncInTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getSecuritySyncInTopic() { return securitySyncInTopic; }
    public void setSecuritySyncInTopic(Connection securitySyncInTopic) { this.securitySyncInTopic = securitySyncInTopic; }

    public SecuritySyncConfig securitySyncOutTopicName(String securitySyncOutTopicName) {
        this.securitySyncOutTopicName = securitySyncOutTopicName;
        return this;
    }

    /**
     * Get securitySyncOutTopicName
     * @return securitySyncOutTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncOutTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecuritySyncOutTopicName() { return securitySyncOutTopicName; }
    public void setSecuritySyncOutTopicName(String securitySyncOutTopicName) { this.securitySyncOutTopicName = securitySyncOutTopicName; }

    public SecuritySyncConfig securitySyncOutTopic(Connection securitySyncOutTopic) {
        this.securitySyncOutTopic = securitySyncOutTopic;
        return this;
    }

    /**
     * Get securitySyncOutTopic
     * @return securitySyncOutTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("securitySyncOutTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getSecuritySyncOutTopic() { return securitySyncOutTopic; }
    public void setSecuritySyncOutTopic(Connection securitySyncOutTopic) { this.securitySyncOutTopic = securitySyncOutTopic; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SecuritySyncConfig securitySyncConfig = (SecuritySyncConfig)o;
        return Objects.equals(this.accessServiceRootURL, securitySyncConfig.accessServiceRootURL) &&
                Objects.equals(this.accessServiceServerName, securitySyncConfig.accessServiceServerName) &&
                Objects.equals(this.securityServerURL, securitySyncConfig.securityServerURL) &&
                Objects.equals(this.securitySyncServerType, securitySyncConfig.securitySyncServerType) &&
                Objects.equals(this.securitySyncServerAuthorization, securitySyncConfig.securitySyncServerAuthorization) &&
                Objects.equals(this.securitySyncTagServiceName, securitySyncConfig.securitySyncTagServiceName) &&
                Objects.equals(this.securitySyncAccessResourceServiceName, securitySyncConfig.securitySyncAccessResourceServiceName) &&
                Objects.equals(this.pollingInterval, securitySyncConfig.pollingInterval) &&
                Objects.equals(this.securitySyncServerConnection, securitySyncConfig.securitySyncServerConnection) &&
                Objects.equals(this.securitySyncInTopicName, securitySyncConfig.securitySyncInTopicName) &&
                Objects.equals(this.securitySyncInTopic, securitySyncConfig.securitySyncInTopic) &&
                Objects.equals(this.securitySyncOutTopicName, securitySyncConfig.securitySyncOutTopicName) &&
                Objects.equals(this.securitySyncOutTopic, securitySyncConfig.securitySyncOutTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                accessServiceRootURL, accessServiceServerName, securityServerURL,
                securitySyncServerType, securitySyncServerAuthorization,
                securitySyncTagServiceName, securitySyncAccessResourceServiceName,
                pollingInterval, securitySyncServerConnection, securitySyncInTopicName,
                securitySyncInTopic, securitySyncOutTopicName, securitySyncOutTopic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SecuritySyncConfig {\n");
        sb.append("    accessServiceRootURL: ").append(toIndentedString(accessServiceRootURL)).append("\n");
        sb.append("    accessServiceServerName: ").append(toIndentedString(accessServiceServerName)).append("\n");
        sb.append("    securityServerURL: ").append(toIndentedString(securityServerURL)).append("\n");
        sb.append("    securitySyncServerType: ").append(toIndentedString(securitySyncServerType)).append("\n");
        sb.append("    securitySyncServerAuthorization: ").append(toIndentedString(securitySyncServerAuthorization)).append("\n");
        sb.append("    securitySyncTagServiceName: ").append(toIndentedString(securitySyncTagServiceName)).append("\n");
        sb.append("    securitySyncAccessResourceServiceName: ").append(toIndentedString(securitySyncAccessResourceServiceName)).append("\n");
        sb.append("    pollingInterval: ").append(toIndentedString(pollingInterval)).append("\n");
        sb.append("    securitySyncServerConnection: ").append(toIndentedString(securitySyncServerConnection)).append("\n");
        sb.append("    securitySyncInTopicName: ").append(toIndentedString(securitySyncInTopicName)).append("\n");
        sb.append("    securitySyncInTopic: ").append(toIndentedString(securitySyncInTopic)).append("\n");
        sb.append("    securitySyncOutTopicName: ").append(toIndentedString(securitySyncOutTopicName)).append("\n");
        sb.append("    securitySyncOutTopic: ").append(toIndentedString(securitySyncOutTopic)).append("\n");
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
