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
 * JobPostBodyJob
 */
public class JobPostBodyJob {

    private String assetRef;
    private String name;
    private String description;
    private String schedule;
    private JobEntityJobScheduleInfo scheduleInfo;
    private JobRuntimeConfiguration _configuration;

    public JobPostBodyJob assetRef(String assetRef) {
        this.assetRef = assetRef;
        return this;
    }

    /**
     * ID of associated asset to run.
     * @return assetRef
     **/
    @JsonProperty("asset_ref")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAssetRef() { return assetRef; }
    public void setAssetRef(String assetRef) { this.assetRef = assetRef; }

    public JobPostBodyJob name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the job
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public JobPostBodyJob description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the job.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public JobPostBodyJob schedule(String schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * A cron string defining when the job should be run (for example: '0 3 21 13 1 ? 2019'). If an empty string is
     * provided it means the job is not scheduled to run.
     * @return schedule
     **/
    @javax.annotation.Nullable
    @JsonProperty("schedule")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    public JobPostBodyJob scheduleInfo(JobEntityJobScheduleInfo scheduleInfo) {
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

    public JobPostBodyJob _configuration(JobRuntimeConfiguration _configuration) {
        this._configuration = _configuration;
        return this;
    }

    /**
     * Get _configuration
     * @return _configuration
     **/
    @JsonProperty("configuration")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public JobRuntimeConfiguration getConfiguration() { return _configuration; }
    public void setConfiguration(JobRuntimeConfiguration _configuration) { this._configuration = _configuration; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobPostBodyJob jobPostBodyJob = (JobPostBodyJob)o;
        return Objects.equals(this.assetRef, jobPostBodyJob.assetRef) &&
                Objects.equals(this.name, jobPostBodyJob.name) &&
                Objects.equals(this.description, jobPostBodyJob.description) &&
                Objects.equals(this.schedule, jobPostBodyJob.schedule) &&
                Objects.equals(this.scheduleInfo, jobPostBodyJob.scheduleInfo) &&
                Objects.equals(this._configuration, jobPostBodyJob._configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetRef, name, description, schedule, scheduleInfo,
                _configuration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobPostBodyJob {\n");
        sb.append("    assetRef: ").append(toIndentedString(assetRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
