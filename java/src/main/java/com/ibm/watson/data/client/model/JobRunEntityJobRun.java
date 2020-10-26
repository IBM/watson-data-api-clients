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
import com.ibm.watson.data.client.model.enums.JobRunState;

import java.util.Objects;

/**
 * JobRunEntityJobRun
 */
public class JobRunEntityJobRun {

    private String jobRef;
    private JobRunState state;
    private Boolean isScheduledRun;
    private String runtimeJobId;
    private Long duration;
    private JobRunEntityJobRunDataFlowJobOutput dataFlowJobOutput;
    private JobRuntimeConfiguration _configuration;

    public JobRunEntityJobRun jobRef(String jobRef) {
        this.jobRef = jobRef;
        return this;
    }

    /**
     * The ID (GUID) of the job used to create this run.
     * @return jobRef
     **/
    @javax.annotation.Nullable
    @JsonProperty("job_ref")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getJobRef() { return jobRef; }
    public void setJobRef(String jobRef) { this.jobRef = jobRef; }

    public JobRunEntityJobRun state(JobRunState state) {
        this.state = state;
        return this;
    }

    /**
     * The state that a job can be in. Possible values: &#39;Completed&#39;,
     * &#39;Failed&#39;, &#39;Canceled&#39;, &#39;Starting&#39;, &#39;Running&#39;.
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JobRunState getState() { return state; }
    public void setState(JobRunState state) { this.state = state; }

    public JobRunEntityJobRun isScheduledRun(Boolean isScheduledRun) {
        this.isScheduledRun = isScheduledRun;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("isScheduledRun")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsScheduledRun() { return isScheduledRun; }
    public void setIsScheduledRun(Boolean isScheduledRun) { this.isScheduledRun = isScheduledRun; }

    public JobRunEntityJobRun runtimeJobId(String runtimeJobId) {
        this.runtimeJobId = runtimeJobId;
        return this;
    }

    /**
     * The runtime job ID (GUID) returned from the runtime system, used to identify the
     * job run in the runtime system.
     * @return runtimeJobId
     **/
    @javax.annotation.Nullable
    @JsonProperty("runtime_job_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRuntimeJobId() { return runtimeJobId; }
    public void setRuntimeJobId(String runtimeJobId) { this.runtimeJobId = runtimeJobId; }

    public JobRunEntityJobRun duration(Long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * The duration of the job run in seconds.
     * @return duration
     **/
    @javax.annotation.Nullable
    @JsonProperty("duration")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getDuration() { return duration; }
    public void setDuration(Long duration) { this.duration = duration; }

    public JobRunEntityJobRun dataFlowJobOutput(JobRunEntityJobRunDataFlowJobOutput dataFlowJobOutput) {
        this.dataFlowJobOutput = dataFlowJobOutput;
        return this;
    }

    /**
     * Get dataFlowJobOutput
     * @return dataFlowJobOutput
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_flow_job_output")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JobRunEntityJobRunDataFlowJobOutput getDataFlowJobOutput() { return dataFlowJobOutput; }
    public void setDataFlowJobOutput(JobRunEntityJobRunDataFlowJobOutput dataFlowJobOutput) { this.dataFlowJobOutput = dataFlowJobOutput; }

    public JobRunEntityJobRun _configuration(JobRuntimeConfiguration _configuration) {
        this._configuration = _configuration;
        return this;
    }

    /**
     * Get _configuration
     * @return _configuration
     **/
    @javax.annotation.Nullable
    @JsonProperty("configuration")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JobRuntimeConfiguration getConfiguration() { return _configuration; }
    public void setConfiguration(JobRuntimeConfiguration _configuration) { this._configuration = _configuration; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobRunEntityJobRun jobRunEntityJobRun = (JobRunEntityJobRun)o;
        return Objects.equals(this.jobRef, jobRunEntityJobRun.jobRef) &&
                Objects.equals(this.state, jobRunEntityJobRun.state) &&
                Objects.equals(this.isScheduledRun, jobRunEntityJobRun.isScheduledRun) &&
                Objects.equals(this.runtimeJobId, jobRunEntityJobRun.runtimeJobId) &&
                Objects.equals(this.duration, jobRunEntityJobRun.duration) &&
                Objects.equals(this.dataFlowJobOutput, jobRunEntityJobRun.dataFlowJobOutput) &&
                Objects.equals(this._configuration, jobRunEntityJobRun._configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobRef, state, isScheduledRun, runtimeJobId, duration,
                dataFlowJobOutput, _configuration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobRunEntityJobRun {\n");
        sb.append("    jobRef: ").append(toIndentedString(jobRef)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    isScheduledRun").append(toIndentedString(isScheduledRun)).append("\n");
        sb.append("    runtimeJobId: ").append(toIndentedString(runtimeJobId)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    dataFlowJobOutput: ").append(toIndentedString(dataFlowJobOutput)).append("\n");
        sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
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
