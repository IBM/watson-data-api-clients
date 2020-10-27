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
 * FailureInfo
 */
public class FailureInfo {

    private String timestamp;
    private String transactionId;
    private String camsVersion;
    private Long threadId;
    private String thread;
    private String camsInstance;
    private String stackTrace;
    private String operation;

    public FailureInfo timestamp(String timestamp) {
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
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public FailureInfo transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Get transactionId
     * @return transactionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("transactionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public FailureInfo camsVersion(String camsVersion) {
        this.camsVersion = camsVersion;
        return this;
    }

    /**
     * Get camsVersion
     * @return camsVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty("camsVersion")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCamsVersion() { return camsVersion; }
    public void setCamsVersion(String camsVersion) { this.camsVersion = camsVersion; }

    public FailureInfo threadId(Long threadId) {
        this.threadId = threadId;
        return this;
    }

    /**
     * Get threadId
     * @return threadId
     **/
    @javax.annotation.Nullable
    @JsonProperty("threadId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getThreadId() { return threadId; }
    public void setThreadId(Long threadId) { this.threadId = threadId; }

    public FailureInfo thread(String thread) {
        this.thread = thread;
        return this;
    }

    /**
     * Get thread
     * @return thread
     **/
    @javax.annotation.Nullable
    @JsonProperty("thread")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getThread() { return thread; }
    public void setThread(String thread) { this.thread = thread; }

    public FailureInfo camsInstance(String camsInstance) {
        this.camsInstance = camsInstance;
        return this;
    }

    /**
     * Get camsInstance
     * @return camsInstance
     **/
    @javax.annotation.Nullable
    @JsonProperty("camsInstance")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCamsInstance() { return camsInstance; }
    public void setCamsInstance(String camsInstance) { this.camsInstance = camsInstance; }

    public FailureInfo stackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
        return this;
    }

    /**
     * Get stackTrace
     * @return stackTrace
     **/
    @javax.annotation.Nullable
    @JsonProperty("stackTrace")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getStackTrace() { return stackTrace; }
    public void setStackTrace(String stackTrace) { this.stackTrace = stackTrace; }

    public FailureInfo operation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     * @return operation
     **/
    @javax.annotation.Nullable
    @JsonProperty("operation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FailureInfo failureInfo = (FailureInfo)o;
        return Objects.equals(this.timestamp, failureInfo.timestamp) &&
                Objects.equals(this.transactionId, failureInfo.transactionId) &&
                Objects.equals(this.camsVersion, failureInfo.camsVersion) &&
                Objects.equals(this.threadId, failureInfo.threadId) &&
                Objects.equals(this.thread, failureInfo.thread) &&
                Objects.equals(this.camsInstance, failureInfo.camsInstance) &&
                Objects.equals(this.stackTrace, failureInfo.stackTrace) &&
                Objects.equals(this.operation, failureInfo.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, transactionId, camsVersion, threadId, thread,
                camsInstance, stackTrace, operation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FailureInfo {\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    camsVersion: ").append(toIndentedString(camsVersion)).append("\n");
        sb.append("    threadId: ").append(toIndentedString(threadId)).append("\n");
        sb.append("    thread: ").append(toIndentedString(thread)).append("\n");
        sb.append("    camsInstance: ").append(toIndentedString(camsInstance)).append("\n");
        sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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
