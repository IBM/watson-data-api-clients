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

import java.util.*;

/**
 * DataProfileExecution
 */
public class DataProfileExecution {

    private String status;
    private Boolean isSupported;
    private String dataflowId;
    private String dataflowRunId;

    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @javax.annotation.Nullable
    @JsonProperty("is_supported")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getSupported() { return isSupported; }
    public void setSupported(Boolean supported) { isSupported = supported; }

    @javax.annotation.Nullable
    @JsonProperty("dataflow_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataflowId() { return dataflowId; }
    public void setDataflowId(String dataflowId) { this.dataflowId = dataflowId; }

    @javax.annotation.Nullable
    @JsonProperty("dataflow_run_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataflowRunId() { return dataflowRunId; }
    public void setDataflowRunId(String dataflowRunId) { this.dataflowRunId = dataflowRunId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataProfileExecution that = (DataProfileExecution)o;
        return Objects.equals(this.status, that.status) &&
                Objects.equals(this.isSupported, that.isSupported) &&
                Objects.equals(this.dataflowId, that.dataflowId) &&
                Objects.equals(this.dataflowRunId, that.dataflowRunId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, isSupported, dataflowId, dataflowRunId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataProfileExecution {\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    isSupported: ").append(toIndentedString(isSupported)).append("\n");
        sb.append("    dataflowId: ").append(toIndentedString(dataflowId)).append("\n");
        sb.append("    dataflowRunId: ").append(toIndentedString(dataflowRunId)).append("\n");
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
