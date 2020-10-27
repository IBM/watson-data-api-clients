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
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * OMRSAuditLogMapResponse
 */
public class OMRSAuditLogMapResponse {

    private Map<String, List<OMRSAuditLogResponse>> auditLogs = new HashMap<>();

    public OMRSAuditLogMapResponse auditLogs(Map<String, List<OMRSAuditLogResponse>> auditLogs) {
        this.auditLogs = auditLogs;
        return this;
    }

    public OMRSAuditLogMapResponse putAuditLogsItem(String key, List<OMRSAuditLogResponse> auditLogsItem) {
        this.auditLogs.put(key, auditLogsItem);
        return this;
    }

    /**
     * Get auditLogs
     * @return auditLogs
     **/
    @JsonProperty("audit_logs")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Map<String, List<OMRSAuditLogResponse>> getAuditLogs() { return auditLogs; }
    public void setAuditLogs(Map<String, List<OMRSAuditLogResponse>> auditLogs) { this.auditLogs = auditLogs; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OMRSAuditLogMapResponse omRSAuditLogMapResponse = (OMRSAuditLogMapResponse)o;
        return Objects.equals(this.auditLogs, omRSAuditLogMapResponse.auditLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auditLogs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OMRSAuditLogMapResponse {\n");
        sb.append("    auditLogs: ").append(toIndentedString(auditLogs)).append("\n");
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
