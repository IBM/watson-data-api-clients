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
 * EmbeddedDataProfile
 */
public class EmbeddedDataProfile {

    private DataProfileOptions options;
    private DataProfileExecution execution;
    private List<Object> columns; // TODO: probably either Strings or more detailed than general Object
    private String attachmentId;

    @javax.annotation.Nullable
    @JsonProperty("options")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataProfileOptions getOptions() { return options; }
    public void setOptions(DataProfileOptions options) { this.options = options; }

    @javax.annotation.Nullable
    @JsonProperty("execution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataProfileExecution getExecution() { return execution; }
    public void setExecution(DataProfileExecution execution) { this.execution = execution; }

    @javax.annotation.Nullable
    @JsonProperty("columns")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getColumns() { return columns; }
    public void setColumns(List<Object> columns) { this.columns = columns; }

    @javax.annotation.Nullable
    @JsonProperty("attachment_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAttachmentId() { return attachmentId; }
    public void setAttachmentId(String attachmentId) { this.attachmentId = attachmentId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EmbeddedDataProfile that = (EmbeddedDataProfile)o;
        return Objects.equals(this.options, that.options) &&
                Objects.equals(this.execution, that.execution) &&
                Objects.equals(this.columns, that.columns) &&
                Objects.equals(this.attachmentId, that.attachmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, execution, columns, attachmentId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EmbeddedDataProfile {\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
        sb.append("    execution: ").append(toIndentedString(execution)).append("\n");
        sb.append("    columns: ").append(toIndentedString(columns)).append("\n");
        sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
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
