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
import com.ibm.watson.data.client.model.enums.Severity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A log item for an event during the discovery of an asset.
 */
public class DiscoveryLog {

    private Severity severity;
    private String message;
    private Map<String, Object> details = null;

    public DiscoveryLog severity(Severity severity) {
        this.severity = severity;
        return this;
    }

    /**
     * The severity of the log item.
     * @return severity
     **/
    @javax.annotation.Nullable
    @JsonProperty("severity")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }

    public DiscoveryLog message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The description of the log item event.
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public DiscoveryLog details(Map<String, Object> details) {
        this.details = details;
        return this;
    }

    public DiscoveryLog putDetailsItem(String key, Object detailsItem) {
        if (this.details == null) {
            this.details = new HashMap<>();
        }
        this.details.put(key, detailsItem);
        return this;
    }

    /**
     * Additional details for the log item captured during the discovery of an
     * asset.
     * @return details
     **/
    @javax.annotation.Nullable
    @JsonProperty("details")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getDetails() { return details; }
    public void setDetails(Map<String, Object> details) { this.details = details; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveryLog discoveryLog = (DiscoveryLog)o;
        return Objects.equals(this.severity, discoveryLog.severity) &&
                Objects.equals(this.message, discoveryLog.message) &&
                Objects.equals(this.details, discoveryLog.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(severity, message, details);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveryLog {\n");
        sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
