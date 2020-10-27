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
import com.ibm.watson.data.client.model.enums.OMRSProtocolVersion;

import java.util.Objects;

/**
 * EnterpriseAccessConfig
 */
public class EnterpriseAccessConfig {

    private String enterpriseMetadataCollectionName;
    private String enterpriseMetadataCollectionId;
    private Connection enterpriseOMRSTopicConnection;
    private OMRSProtocolVersion enterpriseOMRSTopicProtocolVersion;

    public EnterpriseAccessConfig enterpriseMetadataCollectionName(String enterpriseMetadataCollectionName) {
        this.enterpriseMetadataCollectionName = enterpriseMetadataCollectionName;
        return this;
    }

    /**
     * Get enterpriseMetadataCollectionName
     * @return enterpriseMetadataCollectionName
     **/
    @javax.annotation.Nullable
    @JsonProperty("enterpriseMetadataCollectionName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEnterpriseMetadataCollectionName() { return enterpriseMetadataCollectionName; }
    public void setEnterpriseMetadataCollectionName(String enterpriseMetadataCollectionName) { this.enterpriseMetadataCollectionName = enterpriseMetadataCollectionName; }

    public EnterpriseAccessConfig enterpriseMetadataCollectionId(String enterpriseMetadataCollectionId) {
        this.enterpriseMetadataCollectionId = enterpriseMetadataCollectionId;
        return this;
    }

    /**
     * Get enterpriseMetadataCollectionId
     * @return enterpriseMetadataCollectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("enterpriseMetadataCollectionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEnterpriseMetadataCollectionId() { return enterpriseMetadataCollectionId; }
    public void setEnterpriseMetadataCollectionId(String enterpriseMetadataCollectionId) { this.enterpriseMetadataCollectionId = enterpriseMetadataCollectionId; }

    public EnterpriseAccessConfig enterpriseOMRSTopicConnection(Connection enterpriseOMRSTopicConnection) {
        this.enterpriseOMRSTopicConnection = enterpriseOMRSTopicConnection;
        return this;
    }

    /**
     * Get enterpriseOMRSTopicConnection
     * @return enterpriseOMRSTopicConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("enterpriseOMRSTopicConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getEnterpriseOMRSTopicConnection() { return enterpriseOMRSTopicConnection; }
    public void setEnterpriseOMRSTopicConnection(Connection enterpriseOMRSTopicConnection) { this.enterpriseOMRSTopicConnection = enterpriseOMRSTopicConnection; }

    public EnterpriseAccessConfig enterpriseOMRSTopicProtocolVersion(OMRSProtocolVersion enterpriseOMRSTopicProtocolVersion) {
        this.enterpriseOMRSTopicProtocolVersion = enterpriseOMRSTopicProtocolVersion;
        return this;
    }

    /**
     * Get enterpriseOMRSTopicProtocolVersion
     * @return enterpriseOMRSTopicProtocolVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty("enterpriseOMRSTopicProtocolVersion")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OMRSProtocolVersion getEnterpriseOMRSTopicProtocolVersion() { return enterpriseOMRSTopicProtocolVersion; }
    public void setEnterpriseOMRSTopicProtocolVersion(OMRSProtocolVersion enterpriseOMRSTopicProtocolVersion) { this.enterpriseOMRSTopicProtocolVersion = enterpriseOMRSTopicProtocolVersion; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EnterpriseAccessConfig enterpriseAccessConfig = (EnterpriseAccessConfig)o;
        return Objects.equals(this.enterpriseMetadataCollectionName, enterpriseAccessConfig.enterpriseMetadataCollectionName) &&
                Objects.equals(this.enterpriseMetadataCollectionId, enterpriseAccessConfig.enterpriseMetadataCollectionId) &&
                Objects.equals(this.enterpriseOMRSTopicConnection, enterpriseAccessConfig.enterpriseOMRSTopicConnection) &&
                Objects.equals(this.enterpriseOMRSTopicProtocolVersion, enterpriseAccessConfig.enterpriseOMRSTopicProtocolVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                enterpriseMetadataCollectionName, enterpriseMetadataCollectionId,
                enterpriseOMRSTopicConnection, enterpriseOMRSTopicProtocolVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnterpriseAccessConfig {\n");
        sb.append("    enterpriseMetadataCollectionName: ").append(toIndentedString(enterpriseMetadataCollectionName)).append("\n");
        sb.append("    enterpriseMetadataCollectionId: ").append(toIndentedString(enterpriseMetadataCollectionId)).append("\n");
        sb.append("    enterpriseOMRSTopicConnection: ").append(toIndentedString(enterpriseOMRSTopicConnection)).append("\n");
        sb.append("    enterpriseOMRSTopicProtocolVersion: ").append(toIndentedString(enterpriseOMRSTopicProtocolVersion)).append("\n");
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
