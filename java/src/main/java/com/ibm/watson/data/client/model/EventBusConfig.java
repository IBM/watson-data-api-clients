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
 * EventBusConfig
 */
public class EventBusConfig {

    private String connectorProvider;
    private String topicURLRoot;
    private Map<String, Object> configurationProperties = null;
    private Map<String, Object> additionalProperties = null;

    public EventBusConfig connectorProvider(String connectorProvider) {
        this.connectorProvider = connectorProvider;
        return this;
    }

    /**
     * Get connectorProvider
     * @return connectorProvider
     **/
    @javax.annotation.Nullable
    @JsonProperty("connectorProvider")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getConnectorProvider() { return connectorProvider; }
    public void setConnectorProvider(String connectorProvider) { this.connectorProvider = connectorProvider; }

    public EventBusConfig topicURLRoot(String topicURLRoot) {
        this.topicURLRoot = topicURLRoot;
        return this;
    }

    /**
     * Get topicURLRoot
     * @return topicURLRoot
     **/
    @javax.annotation.Nullable
    @JsonProperty("topicURLRoot")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTopicURLRoot() { return topicURLRoot; }
    public void setTopicURLRoot(String topicURLRoot) { this.topicURLRoot = topicURLRoot; }

    public EventBusConfig configurationProperties(Map<String, Object> configurationProperties) {
        this.configurationProperties = configurationProperties;
        return this;
    }

    public EventBusConfig putConfigurationPropertiesItem(String key, Object configurationPropertiesItem) {
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

    public EventBusConfig additionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    public EventBusConfig putAdditionalPropertiesItem(String key, Object additionalPropertiesItem) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<>();
        }
        this.additionalProperties.put(key, additionalPropertiesItem);
        return this;
    }

    /**
     * Get additionalProperties
     * @return additionalProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("additionalProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getAdditionalProperties() { return additionalProperties; }
    public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EventBusConfig eventBusConfig = (EventBusConfig)o;
        return Objects.equals(this.connectorProvider, eventBusConfig.connectorProvider) &&
                Objects.equals(this.topicURLRoot, eventBusConfig.topicURLRoot) &&
                Objects.equals(this.configurationProperties, eventBusConfig.configurationProperties) &&
                Objects.equals(this.additionalProperties, eventBusConfig.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectorProvider, topicURLRoot,
                configurationProperties, additionalProperties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventBusConfig {\n");
        sb.append("    connectorProvider: ").append(toIndentedString(connectorProvider)).append("\n");
        sb.append("    topicURLRoot: ").append(toIndentedString(topicURLRoot)).append("\n");
        sb.append("    configurationProperties: ").append(toIndentedString(configurationProperties)).append("\n");
        sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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
