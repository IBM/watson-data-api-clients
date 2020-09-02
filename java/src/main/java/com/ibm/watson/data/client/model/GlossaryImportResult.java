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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * GlossaryImportResult
 */
public class GlossaryImportResult {

    private String workflowId;
    private List<ImportMessage> messages = null;
    private Map<String, Map<String, Long>> operationsCount = null;

    public GlossaryImportResult workflowId(String workflowId) {
        this.workflowId = workflowId;
        return this;
    }

    /**
     * Get workflowId
     * @return workflowId
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowId() { return workflowId; }
    public void setWorkflowId(String workflowId) { this.workflowId = workflowId; }

    public GlossaryImportResult messages(List<ImportMessage> messages) {
        this.messages = messages;
        return this;
    }

    public GlossaryImportResult addMessagesItem(ImportMessage messagesItem) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(messagesItem);
        return this;
    }

    /**
     * Get messages
     * @return messages
     **/
    @javax.annotation.Nullable
    @JsonProperty("messages")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ImportMessage> getMessages() { return messages; }
    public void setMessages(List<ImportMessage> messages) { this.messages = messages; }

    public GlossaryImportResult operationsCount(Map<String, Map<String, Long>> operationsCount) {
        this.operationsCount = operationsCount;
        return this;
    }

    public GlossaryImportResult putOperationsCountItem(String key, Map<String, Long> operationsCountItem) {
        if (this.operationsCount == null) {
            this.operationsCount = new HashMap<>();
        }
        this.operationsCount.put(key, operationsCountItem);
        return this;
    }

    /**
     * Get operationsCount
     * @return operationsCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("operations_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Map<String, Long>> getOperationsCount() { return operationsCount; }
    public void setOperationsCount(Map<String, Map<String, Long>> operationsCount) { this.operationsCount = operationsCount; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GlossaryImportResult glossaryImportResult = (GlossaryImportResult)o;
        return Objects.equals(this.workflowId, glossaryImportResult.workflowId) &&
                Objects.equals(this.messages, glossaryImportResult.messages) &&
                Objects.equals(this.operationsCount, glossaryImportResult.operationsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workflowId, messages, operationsCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GlossaryImportResult {\n");
        sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
        sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
        sb.append("    operationsCount: ").append(toIndentedString(operationsCount)).append("\n");
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
