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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Connection
 */
public class Connection extends BaseEntity {

    private ConnectorType connectorType;
    private Endpoint endpoint;
    private String userId;
    private String encryptedPassword;
    private String clearPassword;
    private Map<String, Object> configurationProperties = null;
    private Map<String, Object> securedProperties = null;

    public Connection connectorType(ConnectorType connectorType) {
        this.connectorType = connectorType;
        return this;
    }

    /**
     * Get connectorType
     * @return connectorType
     **/
    @javax.annotation.Nullable
    @JsonProperty("connectorType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ConnectorType getConnectorType() { return connectorType; }
    public void setConnectorType(ConnectorType connectorType) { this.connectorType = connectorType; }

    public Connection endpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Get endpoint
     * @return endpoint
     **/
    @javax.annotation.Nullable
    @JsonProperty("endpoint")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Endpoint getEndpoint() { return endpoint; }
    public void setEndpoint(Endpoint endpoint) { this.endpoint = endpoint; }

    public Connection userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     * @return userId
     **/
    @javax.annotation.Nullable
    @JsonProperty("userId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Connection encryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        return this;
    }

    /**
     * Get encryptedPassword
     * @return encryptedPassword
     **/
    @javax.annotation.Nullable
    @JsonProperty("encryptedPassword")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEncryptedPassword() { return encryptedPassword; }
    public void setEncryptedPassword(String encryptedPassword) { this.encryptedPassword = encryptedPassword; }

    public Connection clearPassword(String clearPassword) {
        this.clearPassword = clearPassword;
        return this;
    }

    /**
     * Get clearPassword
     * @return clearPassword
     **/
    @javax.annotation.Nullable
    @JsonProperty("clearPassword")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getClearPassword() { return clearPassword; }
    public void setClearPassword(String clearPassword) { this.clearPassword = clearPassword; }

    public Connection configurationProperties(Map<String, Object> configurationProperties) {
        this.configurationProperties = configurationProperties;
        return this;
    }

    public Connection putConfigurationPropertiesItem(String key, Object configurationPropertiesItem) {
        if (this.configurationProperties == null) {
            this.configurationProperties = new HashMap<>();
        }
        this.configurationProperties.put(key, configurationPropertiesItem);
        return this;
    }

    /**
     * Get configurationProperties
     * @return configurationProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("configurationProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getConfigurationProperties() { return configurationProperties; }
    public void setConfigurationProperties(Map<String, Object> configurationProperties) { this.configurationProperties = configurationProperties; }

    public Connection securedProperties(Map<String, Object> securedProperties) {
        this.securedProperties = securedProperties;
        return this;
    }

    public Connection putSecuredPropertiesItem(String key, Object securedPropertiesItem) {
        if (this.securedProperties == null) {
            this.securedProperties = new HashMap<>();
        }
        this.securedProperties.put(key, securedPropertiesItem);
        return this;
    }

    /**
     * Get securedProperties
     * @return securedProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("securedProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getSecuredProperties() { return securedProperties; }
    public void setSecuredProperties(Map<String, Object> securedProperties) { this.securedProperties = securedProperties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Connection connection = (Connection)o;
        return super.equals(o) &&
                Objects.equals(this.connectorType, connection.connectorType) &&
                Objects.equals(this.endpoint, connection.endpoint) &&
                Objects.equals(this.userId, connection.userId) &&
                Objects.equals(this.encryptedPassword, connection.encryptedPassword) &&
                Objects.equals(this.clearPassword, connection.clearPassword) &&
                Objects.equals(this.configurationProperties, connection.configurationProperties) &&
                Objects.equals(this.securedProperties, connection.securedProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), connectorType, endpoint,
                userId, encryptedPassword, clearPassword,
                configurationProperties, securedProperties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Connection {\n");
        super.toString(sb);
        sb.append("    connectorType: ").append(toIndentedString(connectorType)).append("\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    encryptedPassword: ").append(toIndentedString(encryptedPassword)).append("\n");
        sb.append("    clearPassword: ").append(toIndentedString(clearPassword)).append("\n");
        sb.append("    configurationProperties: ").append(toIndentedString(configurationProperties)).append("\n");
        sb.append("    securedProperties: ").append(toIndentedString(securedProperties)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
