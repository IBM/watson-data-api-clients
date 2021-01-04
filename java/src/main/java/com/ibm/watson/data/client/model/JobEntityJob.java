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

import java.util.Date;
import java.util.Objects;

/**
 * JobEntityJob
 */
public class JobEntityJob {

    private String assetRef;
    private String assetRefName;
    private String assetRefType;
    private String lastRunStatus;
    private Integer lastRunStatusTimestamp;
    private Date lastRunTime;
    private String lastRunInitiator;
    private String schedule;
    private JobEntityJobScheduleInfo scheduleInfo;
    private JobRuntimeConfiguration _configuration;

    public JobEntityJob assetRef(String assetRef) {
        this.assetRef = assetRef;
        return this;
    }

    /**
     * ID of associated asset to run.
     * @return assetRef
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_ref")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetRef() { return assetRef; }
    public void setAssetRef(String assetRef) { this.assetRef = assetRef; }

    public JobEntityJob assetRefName(String assetRefName) {
        this.assetRefName = assetRefName;
        return this;
    }

    /**
     * Name of associated asset to run.
     * @return assetRefName
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_ref_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetRefName() { return assetRefName; }
    public void setAssetRefName(String assetRefName) { this.assetRefName = assetRefName; }

    public JobEntityJob assetRefType(String assetRefType) {
        this.assetRefType = assetRefType;
        return this;
    }

    /**
     * Read-only field used to distinguish between different types of jobs based
     * on the associated asset to run.
     * @return assetRefType
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_ref_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetRefType() { return assetRefType; }
    public void setAssetRefType(String assetRefType) { this.assetRefType = assetRefType; }

    public JobEntityJob lastRunStatus(String lastRunStatus) {
        this.lastRunStatus = lastRunStatus;
        return this;
    }

    /**
     * Status of the last run. &#39;None&#39; if there is no run yet.
     * @return lastRunStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_run_status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLastRunStatus() { return lastRunStatus; }
    public void setLastRunStatus(String lastRunStatus) { this.lastRunStatus = lastRunStatus; }

    public JobEntityJob lastRunStatusTimestamp(Integer lastRunStatusTimestamp) {
        this.lastRunStatusTimestamp = lastRunStatusTimestamp;
        return this;
    }

    /**
     * Status of the last run. &#39;None&#39; if there is no run yet.
     * @return lastRunStatusTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_run_status_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLastRunStatusTimestamp() { return lastRunStatusTimestamp; }
    public void setLastRunStatusTimestamp(Integer lastRunStatusTimestamp) { this.lastRunStatusTimestamp = lastRunStatusTimestamp; }

    public JobEntityJob lastRunTime(Date lastRunTime) {
        this.lastRunTime = lastRunTime;
        return this;
    }

    /**
     * Creation time of the last run. &#39;None&#39; if there is no run yet.
     * @return lastRunTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_run_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastRunTime() { return lastRunTime; }
    public void setLastRunTime(Date lastRunTime) { this.lastRunTime = lastRunTime; }

    public JobEntityJob lastRunInitiator(String lastRunInitiator) {
        this.lastRunInitiator = lastRunInitiator;
        return this;
    }

    /**
     * Initiator of last run. None if there is no run yet, and Scheduler if the
     * job is a scheduled job.
     * @return lastRunInitiator
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_run_initiator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLastRunInitiator() { return lastRunInitiator; }
    public void setLastRunInitiator(String lastRunInitiator) { this.lastRunInitiator = lastRunInitiator; }

    public JobEntityJob schedule(String schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * A cron string defining when the job should be run (example: '0 3 21 13 1 ? 2019'). If an empty string is
     * provided it means the job is not scheduled to run.
     * @return schedule
     **/
    @javax.annotation.Nullable
    @JsonProperty("schedule")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    public JobEntityJob scheduleInfo(JobEntityJobScheduleInfo scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
        return this;
    }

    /**
     * Get scheduleInfo
     * @return scheduleInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("schedule_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JobEntityJobScheduleInfo getScheduleInfo() { return scheduleInfo; }
    public void setScheduleInfo(JobEntityJobScheduleInfo scheduleInfo) { this.scheduleInfo = scheduleInfo; }

    public JobEntityJob _configuration(JobRuntimeConfiguration _configuration) {
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
        JobEntityJob jobEntityJob = (JobEntityJob)o;
        return Objects.equals(this.assetRef, jobEntityJob.assetRef) &&
                Objects.equals(this.assetRefName, jobEntityJob.assetRefName) &&
                Objects.equals(this.assetRefType, jobEntityJob.assetRefType) &&
                Objects.equals(this.lastRunStatus, jobEntityJob.lastRunStatus) &&
                Objects.equals(this.lastRunStatusTimestamp, jobEntityJob.lastRunStatusTimestamp) &&
                Objects.equals(this.lastRunTime, jobEntityJob.lastRunTime) &&
                Objects.equals(this.lastRunInitiator, jobEntityJob.lastRunInitiator) &&
                Objects.equals(this.schedule, jobEntityJob.schedule) &&
                Objects.equals(this.scheduleInfo, jobEntityJob.scheduleInfo) &&
                Objects.equals(this._configuration, jobEntityJob._configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetRef, assetRefName, assetRefType, lastRunStatus,
                lastRunStatusTimestamp, lastRunTime, lastRunInitiator,
                schedule, scheduleInfo, _configuration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobEntityJob {\n");
        sb.append("    assetRef: ").append(toIndentedString(assetRef)).append("\n");
        sb.append("    assetRefName: ").append(toIndentedString(assetRefName)).append("\n");
        sb.append("    assetRefType: ").append(toIndentedString(assetRefType)).append("\n");
        sb.append("    lastRunStatus: ").append(toIndentedString(lastRunStatus)).append("\n");
        sb.append("    lastRunStatusTimestamp: ").append(toIndentedString(lastRunStatusTimestamp)).append("\n");
        sb.append("    lastRunTime: ").append(toIndentedString(lastRunTime)).append("\n");
        sb.append("    lastRunInitiator: ").append(toIndentedString(lastRunInitiator)).append("\n");
        sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
        sb.append("    scheduleInfo: ").append(toIndentedString(scheduleInfo)).append("\n");
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
