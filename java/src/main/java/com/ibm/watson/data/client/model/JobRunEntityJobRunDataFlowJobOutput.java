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
 * The output of a Data Flow jobs only.
 */
public class JobRunEntityJobRunDataFlowJobOutput {

    private Long totalRowsRead;
    private Long totalRowsWritten;
    private Long totalBytesRead;
    private Long totalBytesWritten;
    private Long engineElapsedSecs;

    public JobRunEntityJobRunDataFlowJobOutput totalRowsRead(Long totalRowsRead) {
        this.totalRowsRead = totalRowsRead;
        return this;
    }

    /**
     * The total rows read by the Data Flow job.
     * @return totalRowsRead
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_rows_read")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalRowsRead() { return totalRowsRead; }
    public void setTotalRowsRead(Long totalRowsRead) { this.totalRowsRead = totalRowsRead; }

    public JobRunEntityJobRunDataFlowJobOutput totalRowsWritten(Long totalRowsWritten) {
        this.totalRowsWritten = totalRowsWritten;
        return this;
    }

    /**
     * The total rows written by the Data Flow job.
     * @return totalRowsWritten
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_rows_written")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalRowsWritten() { return totalRowsWritten; }
    public void setTotalRowsWritten(Long totalRowsWritten) { this.totalRowsWritten = totalRowsWritten; }

    public JobRunEntityJobRunDataFlowJobOutput totalBytesRead(Long totalBytesRead) {
        this.totalBytesRead = totalBytesRead;
        return this;
    }

    /**
     * The total bytes read by the Data Flow job.
     * @return totalBytesRead
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_bytes_read")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalBytesRead() { return totalBytesRead; }
    public void setTotalBytesRead(Long totalBytesRead) { this.totalBytesRead = totalBytesRead; }

    public JobRunEntityJobRunDataFlowJobOutput totalBytesWritten(Long totalBytesWritten) {
        this.totalBytesWritten = totalBytesWritten;
        return this;
    }

    /**
     * The total bytes written by the Data Flow job.
     * @return totalBytesWritten
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_bytes_written")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalBytesWritten() { return totalBytesWritten; }
    public void setTotalBytesWritten(Long totalBytesWritten) { this.totalBytesWritten = totalBytesWritten; }

    public JobRunEntityJobRunDataFlowJobOutput engineElapsedSecs(Long engineElapsedSecs) {
        this.engineElapsedSecs = engineElapsedSecs;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("engine_elapsed_secs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getEngineElapsedSecs() { return engineElapsedSecs; }
    public void setEngineElapsedSecs(Long engineElapsedSecs) { this.engineElapsedSecs = engineElapsedSecs; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobRunEntityJobRunDataFlowJobOutput jobRunEntityJobRunDataFlowJobOutput = (JobRunEntityJobRunDataFlowJobOutput)o;
        return Objects.equals(this.totalRowsRead, jobRunEntityJobRunDataFlowJobOutput.totalRowsRead) &&
                Objects.equals(this.totalRowsWritten, jobRunEntityJobRunDataFlowJobOutput.totalRowsWritten) &&
                Objects.equals(this.totalBytesRead, jobRunEntityJobRunDataFlowJobOutput.totalBytesRead) &&
                Objects.equals(this.totalBytesWritten, jobRunEntityJobRunDataFlowJobOutput.totalBytesWritten) &&
                Objects.equals(this.engineElapsedSecs, jobRunEntityJobRunDataFlowJobOutput.engineElapsedSecs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRowsRead, totalRowsWritten, totalBytesRead,
                totalBytesWritten, engineElapsedSecs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobRunEntityJobRunDataFlowJobOutput {\n");
        sb.append("    totalRowsRead: ").append(toIndentedString(totalRowsRead)).append("\n");
        sb.append("    totalRowsWritten: ").append(toIndentedString(totalRowsWritten)).append("\n");
        sb.append("    totalBytesRead: ").append(toIndentedString(totalBytesRead)).append("\n");
        sb.append("    totalBytesWritten: ").append(toIndentedString(totalBytesWritten)).append("\n");
        sb.append("    engineElapsedSecs: ").append(toIndentedString(engineElapsedSecs)).append("\n");
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
