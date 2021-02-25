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

import java.util.List;
import java.util.Objects;

/**
 * DataProfileAttachment
 */
public class DataProfileAttachment {

    private DataProfileSummary summary;
    private List<DataProfileColumn> columns;

    @javax.annotation.Nullable
    @JsonProperty("summary")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataProfileSummary getSummary() { return summary; }
    public void setSummary(DataProfileSummary summary) { this.summary = summary; }

    @javax.annotation.Nullable
    @JsonProperty("columns")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DataProfileColumn> getColumns() { return columns; }
    public void setColumns(List<DataProfileColumn> columns) { this.columns = columns; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataProfileAttachment that = (DataProfileAttachment) o;
        return Objects.equals(summary, that.summary) &&
                Objects.equals(columns, that.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, columns);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataProfileAttachment {\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    columns: ").append(toIndentedString(columns)).append("\n");
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
