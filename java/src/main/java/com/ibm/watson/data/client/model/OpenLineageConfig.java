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
 * OpenLineageConfig
 */
public class OpenLineageConfig {

    private Integer openLineageId;
    private String openLineageName;
    private String openLineageDescription;
    private String lineageServerURL;
    private String inTopicName;
    private Connection inTopicConnection;
    private String openLineageProvider;
    private Connection openLineageBufferGraphConnection;
    private Connection openLineageMainGraphConnection;
    private Map<String, Object> bufferGraphConfig = null;
    private Map<String, Object> mainGraphConfig = null;

    public OpenLineageConfig openLineageId(Integer openLineageId) {
        this.openLineageId = openLineageId;
        return this;
    }

    /**
     * Get openLineageId
     * @return openLineageId
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOpenLineageId() { return openLineageId; }
    public void setOpenLineageId(Integer openLineageId) { this.openLineageId = openLineageId; }

    public OpenLineageConfig openLineageName(String openLineageName) {
        this.openLineageName = openLineageName;
        return this;
    }

    /**
     * Get openLineageName
     * @return openLineageName
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOpenLineageName() { return openLineageName; }
    public void setOpenLineageName(String openLineageName) { this.openLineageName = openLineageName; }

    public OpenLineageConfig openLineageDescription(String openLineageDescription) {
        this.openLineageDescription = openLineageDescription;
        return this;
    }

    /**
     * Get openLineageDescription
     * @return openLineageDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageDescription")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOpenLineageDescription() { return openLineageDescription; }
    public void setOpenLineageDescription(String openLineageDescription) { this.openLineageDescription = openLineageDescription; }

    public OpenLineageConfig lineageServerURL(String lineageServerURL) {
        this.lineageServerURL = lineageServerURL;
        return this;
    }

    /**
     * Get lineageServerURL
     * @return lineageServerURL
     **/
    @javax.annotation.Nullable
    @JsonProperty("lineageServerURL")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLineageServerURL() { return lineageServerURL; }
    public void setLineageServerURL(String lineageServerURL) { this.lineageServerURL = lineageServerURL; }

    public OpenLineageConfig inTopicName(String inTopicName) {
        this.inTopicName = inTopicName;
        return this;
    }

    /**
     * Get inTopicName
     * @return inTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("inTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getInTopicName() { return inTopicName; }
    public void setInTopicName(String inTopicName) { this.inTopicName = inTopicName; }

    public OpenLineageConfig inTopicConnection(Connection inTopicConnection) {
        this.inTopicConnection = inTopicConnection;
        return this;
    }

    /**
     * Get inTopicConnection
     * @return inTopicConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("inTopicConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getInTopicConnection() { return inTopicConnection; }
    public void setInTopicConnection(Connection inTopicConnection) { this.inTopicConnection = inTopicConnection; }

    public OpenLineageConfig openLineageProvider(String openLineageProvider) {
        this.openLineageProvider = openLineageProvider;
        return this;
    }

    /**
     * Get openLineageProvider
     * @return openLineageProvider
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageProvider")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOpenLineageProvider() { return openLineageProvider; }
    public void setOpenLineageProvider(String openLineageProvider) { this.openLineageProvider = openLineageProvider; }

    public OpenLineageConfig openLineageBufferGraphConnection(Connection openLineageBufferGraphConnection) {
        this.openLineageBufferGraphConnection = openLineageBufferGraphConnection;
        return this;
    }

    /**
     * Get openLineageBufferGraphConnection
     * @return openLineageBufferGraphConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageBufferGraphConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getOpenLineageBufferGraphConnection() { return openLineageBufferGraphConnection; }
    public void setOpenLineageBufferGraphConnection(Connection openLineageBufferGraphConnection) { this.openLineageBufferGraphConnection = openLineageBufferGraphConnection; }

    public OpenLineageConfig openLineageMainGraphConnection(Connection openLineageMainGraphConnection) {
        this.openLineageMainGraphConnection = openLineageMainGraphConnection;
        return this;
    }

    /**
     * Get openLineageMainGraphConnection
     * @return openLineageMainGraphConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("openLineageMainGraphConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getOpenLineageMainGraphConnection() { return openLineageMainGraphConnection; }
    public void setOpenLineageMainGraphConnection(Connection openLineageMainGraphConnection) { this.openLineageMainGraphConnection = openLineageMainGraphConnection; }

    public OpenLineageConfig bufferGraphConfig(Map<String, Object> bufferGraphConfig) {
        this.bufferGraphConfig = bufferGraphConfig;
        return this;
    }

    public OpenLineageConfig putBufferGraphConfigItem(String key, Object bufferGraphConfigItem) {
        if (this.bufferGraphConfig == null) {
            this.bufferGraphConfig = new HashMap<>();
        }
        this.bufferGraphConfig.put(key, bufferGraphConfigItem);
        return this;
    }

    /**
     * Get bufferGraphConfig
     * @return bufferGraphConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("bufferGraphConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getBufferGraphConfig() { return bufferGraphConfig; }
    public void setBufferGraphConfig(Map<String, Object> bufferGraphConfig) { this.bufferGraphConfig = bufferGraphConfig; }

    public OpenLineageConfig mainGraphConfig(Map<String, Object> mainGraphConfig) {
        this.mainGraphConfig = mainGraphConfig;
        return this;
    }

    public OpenLineageConfig putMainGraphConfigItem(String key, Object mainGraphConfigItem) {
        if (this.mainGraphConfig == null) {
            this.mainGraphConfig = new HashMap<>();
        }
        this.mainGraphConfig.put(key, mainGraphConfigItem);
        return this;
    }

    /**
     * Get mainGraphConfig
     * @return mainGraphConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("mainGraphConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getMainGraphConfig() { return mainGraphConfig; }
    public void setMainGraphConfig(Map<String, Object> mainGraphConfig) { this.mainGraphConfig = mainGraphConfig; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OpenLineageConfig openLineageConfig = (OpenLineageConfig)o;
        return Objects.equals(this.openLineageId, openLineageConfig.openLineageId) &&
                Objects.equals(this.openLineageName, openLineageConfig.openLineageName) &&
                Objects.equals(this.openLineageDescription, openLineageConfig.openLineageDescription) &&
                Objects.equals(this.lineageServerURL, openLineageConfig.lineageServerURL) &&
                Objects.equals(this.inTopicName, openLineageConfig.inTopicName) &&
                Objects.equals(this.inTopicConnection, openLineageConfig.inTopicConnection) &&
                Objects.equals(this.openLineageProvider, openLineageConfig.openLineageProvider) &&
                Objects.equals(this.openLineageBufferGraphConnection, openLineageConfig.openLineageBufferGraphConnection) &&
                Objects.equals(this.openLineageMainGraphConnection, openLineageConfig.openLineageMainGraphConnection) &&
                Objects.equals(this.bufferGraphConfig, openLineageConfig.bufferGraphConfig) &&
                Objects.equals(this.mainGraphConfig, openLineageConfig.mainGraphConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openLineageId, openLineageName, openLineageDescription,
                lineageServerURL, inTopicName, inTopicConnection,
                openLineageProvider, openLineageBufferGraphConnection,
                openLineageMainGraphConnection, bufferGraphConfig,
                mainGraphConfig);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenLineageConfig {\n");
        sb.append("    openLineageId: ").append(toIndentedString(openLineageId)).append("\n");
        sb.append("    openLineageName: ").append(toIndentedString(openLineageName)).append("\n");
        sb.append("    openLineageDescription: ").append(toIndentedString(openLineageDescription)).append("\n");
        sb.append("    lineageServerURL: ").append(toIndentedString(lineageServerURL)).append("\n");
        sb.append("    inTopicName: ").append(toIndentedString(inTopicName)).append("\n");
        sb.append("    inTopicConnection: ").append(toIndentedString(inTopicConnection)).append("\n");
        sb.append("    openLineageProvider: ").append(toIndentedString(openLineageProvider)).append("\n");
        sb.append("    openLineageBufferGraphConnection: ").append(toIndentedString(openLineageBufferGraphConnection)).append("\n");
        sb.append("    openLineageMainGraphConnection: ").append(toIndentedString(openLineageMainGraphConnection)).append("\n");
        sb.append("    bufferGraphConfig: ").append(toIndentedString(bufferGraphConfig)).append("\n");
        sb.append("    mainGraphConfig: ").append(toIndentedString(mainGraphConfig)).append("\n");
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
