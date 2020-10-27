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
 * VirtualizationConfig
 */
public class VirtualizationConfig {

    private String virtualizationProvider;
    private String virtualizerOutboundTopicName;
    private Connection virtualizerOutboundTopic;
    private String virtualizerInboundTopicName;
    private Connection virtualizerInboundTopic;
    private Connection virtualizationSolutionConnection;
    private Map<String, Object> virtualizationSolutionConfig = null;

    public VirtualizationConfig virtualizationProvider(String virtualizationProvider) {
        this.virtualizationProvider = virtualizationProvider;
        return this;
    }

    /**
     * Get virtualizationProvider
     * @return virtualizationProvider
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizationProvider")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVirtualizationProvider() { return virtualizationProvider; }
    public void setVirtualizationProvider(String virtualizationProvider) { this.virtualizationProvider = virtualizationProvider; }

    public VirtualizationConfig virtualizerOutboundTopicName(String virtualizerOutboundTopicName) {
        this.virtualizerOutboundTopicName = virtualizerOutboundTopicName;
        return this;
    }

    /**
     * Get virtualizerOutboundTopicName
     * @return virtualizerOutboundTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizerOutboundTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVirtualizerOutboundTopicName() { return virtualizerOutboundTopicName; }
    public void setVirtualizerOutboundTopicName(String virtualizerOutboundTopicName) { this.virtualizerOutboundTopicName = virtualizerOutboundTopicName; }

    public VirtualizationConfig virtualizerOutboundTopic(Connection virtualizerOutboundTopic) {
        this.virtualizerOutboundTopic = virtualizerOutboundTopic;
        return this;
    }

    /**
     * Get virtualizerOutboundTopic
     * @return virtualizerOutboundTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizerOutboundTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getVirtualizerOutboundTopic() { return virtualizerOutboundTopic; }
    public void setVirtualizerOutboundTopic(Connection virtualizerOutboundTopic) { this.virtualizerOutboundTopic = virtualizerOutboundTopic; }

    public VirtualizationConfig virtualizerInboundTopicName(String virtualizerInboundTopicName) {
        this.virtualizerInboundTopicName = virtualizerInboundTopicName;
        return this;
    }

    /**
     * Get virtualizerInboundTopicName
     * @return virtualizerInboundTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizerInboundTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVirtualizerInboundTopicName() { return virtualizerInboundTopicName; }
    public void setVirtualizerInboundTopicName(String virtualizerInboundTopicName) { this.virtualizerInboundTopicName = virtualizerInboundTopicName; }

    public VirtualizationConfig virtualizerInboundTopic(Connection virtualizerInboundTopic) {
        this.virtualizerInboundTopic = virtualizerInboundTopic;
        return this;
    }

    /**
     * Get virtualizerInboundTopic
     * @return virtualizerInboundTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizerInboundTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getVirtualizerInboundTopic() { return virtualizerInboundTopic; }
    public void setVirtualizerInboundTopic(Connection virtualizerInboundTopic) { this.virtualizerInboundTopic = virtualizerInboundTopic; }

    public VirtualizationConfig virtualizationSolutionConnection(Connection virtualizationSolutionConnection) {
        this.virtualizationSolutionConnection = virtualizationSolutionConnection;
        return this;
    }

    /**
     * Get virtualizationSolutionConnection
     * @return virtualizationSolutionConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizationSolutionConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getVirtualizationSolutionConnection() { return virtualizationSolutionConnection; }
    public void setVirtualizationSolutionConnection(Connection virtualizationSolutionConnection) { this.virtualizationSolutionConnection = virtualizationSolutionConnection; }

    public VirtualizationConfig virtualizationSolutionConfig(Map<String, Object> virtualizationSolutionConfig) {
        this.virtualizationSolutionConfig = virtualizationSolutionConfig;
        return this;
    }

    public VirtualizationConfig putVirtualizationSolutionConfigItem(String key, Object virtualizationSolutionConfigItem) {
        if (this.virtualizationSolutionConfig == null) {
            this.virtualizationSolutionConfig = new HashMap<>();
        }
        this.virtualizationSolutionConfig.put(key, virtualizationSolutionConfigItem);
        return this;
    }

    /**
     * Get virtualizationSolutionConfig
     * @return virtualizationSolutionConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtualizationSolutionConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getVirtualizationSolutionConfig() { return virtualizationSolutionConfig; }
    public void setVirtualizationSolutionConfig(Map<String, Object> virtualizationSolutionConfig) { this.virtualizationSolutionConfig = virtualizationSolutionConfig; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        VirtualizationConfig virtualizationConfig = (VirtualizationConfig)o;
        return Objects.equals(this.virtualizationProvider, virtualizationConfig.virtualizationProvider) &&
                Objects.equals(this.virtualizerOutboundTopicName, virtualizationConfig.virtualizerOutboundTopicName) &&
                Objects.equals(this.virtualizerOutboundTopic, virtualizationConfig.virtualizerOutboundTopic) &&
                Objects.equals(this.virtualizerInboundTopicName, virtualizationConfig.virtualizerInboundTopicName) &&
                Objects.equals(this.virtualizerInboundTopic, virtualizationConfig.virtualizerInboundTopic) &&
                Objects.equals(this.virtualizationSolutionConnection, virtualizationConfig.virtualizationSolutionConnection) &&
                Objects.equals(this.virtualizationSolutionConfig, virtualizationConfig.virtualizationSolutionConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(virtualizationProvider, virtualizerOutboundTopicName,
                virtualizerOutboundTopic, virtualizerInboundTopicName,
                virtualizerInboundTopic,
                virtualizationSolutionConnection,
                virtualizationSolutionConfig);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VirtualizationConfig {\n");
        sb.append("    virtualizationProvider: ").append(toIndentedString(virtualizationProvider)).append("\n");
        sb.append("    virtualizerOutboundTopicName: ").append(toIndentedString(virtualizerOutboundTopicName)).append("\n");
        sb.append("    virtualizerOutboundTopic: ").append(toIndentedString(virtualizerOutboundTopic)).append("\n");
        sb.append("    virtualizerInboundTopicName: ").append(toIndentedString(virtualizerInboundTopicName)).append("\n");
        sb.append("    virtualizerInboundTopic: ").append(toIndentedString(virtualizerInboundTopic)).append("\n");
        sb.append("    virtualizationSolutionConnection: ").append(toIndentedString(virtualizationSolutionConnection)).append("\n");
        sb.append("    virtualizationSolutionConfig: ").append(toIndentedString(virtualizationSolutionConfig)).append("\n");
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
