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
 * OMRSAuditLogResponse
 */
public class OMRSAuditLogResponse {

    private String catalogId;
    private String serviceInstanceId;
    private String guid;
    private String messageId;
    private String messageTime;
    private Long timestamp;
    private String severity;
    private String component;
    private String message;

    public OMRSAuditLogResponse catalogId(String catalogId) {
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
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public OMRSAuditLogResponse serviceInstanceId(String serviceInstanceId) {
        this.serviceInstanceId = serviceInstanceId;
        return this;
    }

    /**
     * Get serviceInstanceId
     * @return serviceInstanceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("service_instance_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getServiceInstanceId() { return serviceInstanceId; }
    public void setServiceInstanceId(String serviceInstanceId) { this.serviceInstanceId = serviceInstanceId; }

    public OMRSAuditLogResponse guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get guid
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public OMRSAuditLogResponse messageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    /**
     * Get messageId
     * @return messageId
     **/
    @javax.annotation.Nullable
    @JsonProperty("message_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }

    public OMRSAuditLogResponse messageTime(String messageTime) {
        this.messageTime = messageTime;
        return this;
    }

    /**
     * Get messageTime
     * @return messageTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("message_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessageTime() { return messageTime; }
    public void setMessageTime(String messageTime) { this.messageTime = messageTime; }

    public OMRSAuditLogResponse timestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     * @return timestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTimestamp() { return timestamp; }
    public void setTimestamp(Long timestamp) { this.timestamp = timestamp; }

    public OMRSAuditLogResponse severity(String severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Get severity
     * @return severity
     **/
    @javax.annotation.Nullable
    @JsonProperty("severity")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public OMRSAuditLogResponse component(String component) {
        this.component = component;
        return this;
    }

    /**
     * Get component
     * @return component
     **/
    @javax.annotation.Nullable
    @JsonProperty("component")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getComponent() { return component; }
    public void setComponent(String component) { this.component = component; }

    public OMRSAuditLogResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OMRSAuditLogResponse omRSAuditLogResponse = (OMRSAuditLogResponse)o;
        return Objects.equals(this.catalogId, omRSAuditLogResponse.catalogId) &&
                Objects.equals(this.serviceInstanceId, omRSAuditLogResponse.serviceInstanceId) &&
                Objects.equals(this.guid, omRSAuditLogResponse.guid) &&
                Objects.equals(this.messageId, omRSAuditLogResponse.messageId) &&
                Objects.equals(this.messageTime, omRSAuditLogResponse.messageTime) &&
                Objects.equals(this.timestamp, omRSAuditLogResponse.timestamp) &&
                Objects.equals(this.severity, omRSAuditLogResponse.severity) &&
                Objects.equals(this.component, omRSAuditLogResponse.component) &&
                Objects.equals(this.message, omRSAuditLogResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogId, serviceInstanceId, guid, messageId,
                messageTime, timestamp, severity, component, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OMRSAuditLogResponse {\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    serviceInstanceId: ").append(toIndentedString(serviceInstanceId)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
        sb.append("    messageTime: ").append(toIndentedString(messageTime)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
        sb.append("    component: ").append(toIndentedString(component)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
