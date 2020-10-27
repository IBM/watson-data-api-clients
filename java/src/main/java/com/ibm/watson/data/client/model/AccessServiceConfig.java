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
import com.ibm.watson.data.client.model.enums.AccessServiceStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * AccessServiceConfig
 */
public class AccessServiceConfig {

    private Integer accessServiceId;
    private String accessServiceAdminClass;
    private String accessServiceName;
    private String accessServiceURLMarker;
    private String accessServiceDescription;
    private String accessServiceWiki;
    private AccessServiceStatus accessServiceOperationalStatus;
    private Connection accessServiceInTopic;
    private Connection accessServiceOutTopic;
    private Map<String, Object> accessServiceOptions = null;

    public AccessServiceConfig accessServiceId(Integer accessServiceId) {
        this.accessServiceId = accessServiceId;
        return this;
    }

    /**
     * Get accessServiceId
     * @return accessServiceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getAccessServiceId() { return accessServiceId; }
    public void setAccessServiceId(Integer accessServiceId) { this.accessServiceId = accessServiceId; }

    public AccessServiceConfig accessServiceAdminClass(String accessServiceAdminClass) {
        this.accessServiceAdminClass = accessServiceAdminClass;
        return this;
    }

    /**
     * Get accessServiceAdminClass
     * @return accessServiceAdminClass
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceAdminClass")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceAdminClass() { return accessServiceAdminClass; }
    public void setAccessServiceAdminClass(String accessServiceAdminClass) { this.accessServiceAdminClass = accessServiceAdminClass; }

    public AccessServiceConfig accessServiceName(String accessServiceName) {
        this.accessServiceName = accessServiceName;
        return this;
    }

    /**
     * Get accessServiceName
     * @return accessServiceName
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceName() { return accessServiceName; }
    public void setAccessServiceName(String accessServiceName) { this.accessServiceName = accessServiceName; }

    public AccessServiceConfig accessServiceURLMarker(String accessServiceURLMarker) {
        this.accessServiceURLMarker = accessServiceURLMarker;
        return this;
    }

    /**
     * Get accessServiceURLMarker
     * @return accessServiceURLMarker
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceURLMarker")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceURLMarker() { return accessServiceURLMarker; }
    public void setAccessServiceURLMarker(String accessServiceURLMarker) { this.accessServiceURLMarker = accessServiceURLMarker; }

    public AccessServiceConfig accessServiceDescription(String accessServiceDescription) {
        this.accessServiceDescription = accessServiceDescription;
        return this;
    }

    /**
     * Get accessServiceDescription
     * @return accessServiceDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceDescription")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceDescription() { return accessServiceDescription; }
    public void setAccessServiceDescription(String accessServiceDescription) { this.accessServiceDescription = accessServiceDescription; }

    public AccessServiceConfig accessServiceWiki(String accessServiceWiki) {
        this.accessServiceWiki = accessServiceWiki;
        return this;
    }

    /**
     * Get accessServiceWiki
     * @return accessServiceWiki
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceWiki")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceWiki() { return accessServiceWiki; }
    public void setAccessServiceWiki(String accessServiceWiki) { this.accessServiceWiki = accessServiceWiki; }

    public AccessServiceConfig accessServiceOperationalStatus(AccessServiceStatus accessServiceOperationalStatus) {
        this.accessServiceOperationalStatus = accessServiceOperationalStatus;
        return this;
    }

    /**
     * Get accessServiceOperationalStatus
     * @return accessServiceOperationalStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceOperationalStatus")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AccessServiceStatus getAccessServiceOperationalStatus() { return accessServiceOperationalStatus; }
    public void setAccessServiceOperationalStatus(AccessServiceStatus accessServiceOperationalStatus) { this.accessServiceOperationalStatus = accessServiceOperationalStatus; }

    public AccessServiceConfig accessServiceInTopic(Connection accessServiceInTopic) {
        this.accessServiceInTopic = accessServiceInTopic;
        return this;
    }

    /**
     * Get accessServiceInTopic
     * @return accessServiceInTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceInTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getAccessServiceInTopic() { return accessServiceInTopic; }
    public void setAccessServiceInTopic(Connection accessServiceInTopic) { this.accessServiceInTopic = accessServiceInTopic; }

    public AccessServiceConfig accessServiceOutTopic(Connection accessServiceOutTopic) {
        this.accessServiceOutTopic = accessServiceOutTopic;
        return this;
    }

    /**
     * Get accessServiceOutTopic
     * @return accessServiceOutTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceOutTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getAccessServiceOutTopic() { return accessServiceOutTopic; }
    public void setAccessServiceOutTopic(Connection accessServiceOutTopic) { this.accessServiceOutTopic = accessServiceOutTopic; }

    public AccessServiceConfig accessServiceOptions(Map<String, Object> accessServiceOptions) {
        this.accessServiceOptions = accessServiceOptions;
        return this;
    }

    public AccessServiceConfig putAccessServiceOptionsItem(String key, Object accessServiceOptionsItem) {
        if (this.accessServiceOptions == null) {
            this.accessServiceOptions = new HashMap<>();
        }
        this.accessServiceOptions.put(key, accessServiceOptionsItem);
        return this;
    }

    /**
     * Get accessServiceOptions
     * @return accessServiceOptions
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceOptions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getAccessServiceOptions() { return accessServiceOptions; }
    public void setAccessServiceOptions(Map<String, Object> accessServiceOptions) { this.accessServiceOptions = accessServiceOptions; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AccessServiceConfig accessServiceConfig = (AccessServiceConfig)o;
        return Objects.equals(this.accessServiceId, accessServiceConfig.accessServiceId) &&
                Objects.equals(this.accessServiceAdminClass, accessServiceConfig.accessServiceAdminClass) &&
                Objects.equals(this.accessServiceName, accessServiceConfig.accessServiceName) &&
                Objects.equals(this.accessServiceURLMarker, accessServiceConfig.accessServiceURLMarker) &&
                Objects.equals(this.accessServiceDescription, accessServiceConfig.accessServiceDescription) &&
                Objects.equals(this.accessServiceWiki, accessServiceConfig.accessServiceWiki) &&
                Objects.equals(this.accessServiceOperationalStatus, accessServiceConfig.accessServiceOperationalStatus) &&
                Objects.equals(this.accessServiceInTopic, accessServiceConfig.accessServiceInTopic) &&
                Objects.equals(this.accessServiceOutTopic, accessServiceConfig.accessServiceOutTopic) &&
                Objects.equals(this.accessServiceOptions, accessServiceConfig.accessServiceOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessServiceId, accessServiceAdminClass,
                accessServiceName, accessServiceURLMarker,
                accessServiceDescription, accessServiceWiki,
                accessServiceOperationalStatus, accessServiceInTopic,
                accessServiceOutTopic, accessServiceOptions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccessServiceConfig {\n");
        sb.append("    accessServiceId: ").append(toIndentedString(accessServiceId)).append("\n");
        sb.append("    accessServiceAdminClass: ").append(toIndentedString(accessServiceAdminClass)).append("\n");
        sb.append("    accessServiceName: ").append(toIndentedString(accessServiceName)).append("\n");
        sb.append("    accessServiceURLMarker: ").append(toIndentedString(accessServiceURLMarker)).append("\n");
        sb.append("    accessServiceDescription: ").append(toIndentedString(accessServiceDescription)).append("\n");
        sb.append("    accessServiceWiki: ").append(toIndentedString(accessServiceWiki)).append("\n");
        sb.append("    accessServiceOperationalStatus: ").append(toIndentedString(accessServiceOperationalStatus)).append("\n");
        sb.append("    accessServiceInTopic: ").append(toIndentedString(accessServiceInTopic)).append("\n");
        sb.append("    accessServiceOutTopic: ").append(toIndentedString(accessServiceOutTopic)).append("\n");
        sb.append("    accessServiceOptions: ").append(toIndentedString(accessServiceOptions)).append("\n");
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
