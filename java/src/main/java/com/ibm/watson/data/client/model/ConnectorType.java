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
 * ConnectorType
 */
public class ConnectorType extends BaseEntity {

    private String connectorProviderClassName;
    private List<String> recognizedAdditionalProperties = null;
    private List<String> recognizedConfigurationProperties = null;
    private List<String> recognizedSecuredProperties = null;

    public ConnectorType connectorProviderClassName(String connectorProviderClassName) {
        this.connectorProviderClassName = connectorProviderClassName;
        return this;
    }

    /**
     * Get connectorProviderClassName
     * @return connectorProviderClassName
     **/
    @javax.annotation.Nullable
    @JsonProperty("connectorProviderClassName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getConnectorProviderClassName() { return connectorProviderClassName; }
    public void setConnectorProviderClassName(String connectorProviderClassName) { this.connectorProviderClassName = connectorProviderClassName; }

    public ConnectorType recognizedAdditionalProperties(List<String> recognizedAdditionalProperties) {
        this.recognizedAdditionalProperties = recognizedAdditionalProperties;
        return this;
    }

    public ConnectorType addRecognizedAdditionalPropertiesItem(String recognizedAdditionalPropertiesItem) {
        if (this.recognizedAdditionalProperties == null) {
            this.recognizedAdditionalProperties = new ArrayList<>();
        }
        this.recognizedAdditionalProperties.add(recognizedAdditionalPropertiesItem);
        return this;
    }

    /**
     * Get recognizedAdditionalProperties
     * @return recognizedAdditionalProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("recognizedAdditionalProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRecognizedAdditionalProperties() { return recognizedAdditionalProperties; }
    public void setRecognizedAdditionalProperties(List<String> recognizedAdditionalProperties) { this.recognizedAdditionalProperties = recognizedAdditionalProperties; }

    public ConnectorType recognizedConfigurationProperties(List<String> recognizedConfigurationProperties) {
        this.recognizedConfigurationProperties = recognizedConfigurationProperties;
        return this;
    }

    public ConnectorType addRecognizedConfigurationPropertiesItem(String recognizedConfigurationPropertiesItem) {
        if (this.recognizedConfigurationProperties == null) {
            this.recognizedConfigurationProperties = new ArrayList<>();
        }
        this.recognizedConfigurationProperties.add(
                recognizedConfigurationPropertiesItem);
        return this;
    }

    /**
     * Get recognizedConfigurationProperties
     * @return recognizedConfigurationProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("recognizedConfigurationProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRecognizedConfigurationProperties() { return recognizedConfigurationProperties; }
    public void setRecognizedConfigurationProperties(List<String> recognizedConfigurationProperties) { this.recognizedConfigurationProperties = recognizedConfigurationProperties; }

    public ConnectorType recognizedSecuredProperties(List<String> recognizedSecuredProperties) {
        this.recognizedSecuredProperties = recognizedSecuredProperties;
        return this;
    }

    public ConnectorType addRecognizedSecuredPropertiesItem(String recognizedSecuredPropertiesItem) {
        if (this.recognizedSecuredProperties == null) {
            this.recognizedSecuredProperties = new ArrayList<>();
        }
        this.recognizedSecuredProperties.add(recognizedSecuredPropertiesItem);
        return this;
    }

    /**
     * Get recognizedSecuredProperties
     * @return recognizedSecuredProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("recognizedSecuredProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRecognizedSecuredProperties() { return recognizedSecuredProperties; }
    public void setRecognizedSecuredProperties(List<String> recognizedSecuredProperties) { this.recognizedSecuredProperties = recognizedSecuredProperties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConnectorType connectorType = (ConnectorType)o;
        return super.equals(o) &&
                Objects.equals(this.connectorProviderClassName, connectorType.connectorProviderClassName) &&
                Objects.equals(this.recognizedAdditionalProperties, connectorType.recognizedAdditionalProperties) &&
                Objects.equals(this.recognizedConfigurationProperties, connectorType.recognizedConfigurationProperties) &&
                Objects.equals(this.recognizedSecuredProperties, connectorType.recognizedSecuredProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                connectorProviderClassName, recognizedAdditionalProperties,
                recognizedConfigurationProperties, recognizedSecuredProperties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectorType {\n");
        super.toString(sb);
        sb.append("    connectorProviderClassName: ").append(toIndentedString(connectorProviderClassName)).append("\n");
        sb.append("    recognizedAdditionalProperties: ").append(toIndentedString(recognizedAdditionalProperties)).append("\n");
        sb.append("    recognizedConfigurationProperties: ").append(toIndentedString(recognizedConfigurationProperties)).append("\n");
        sb.append("    recognizedSecuredProperties: ").append(toIndentedString(recognizedSecuredProperties)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
