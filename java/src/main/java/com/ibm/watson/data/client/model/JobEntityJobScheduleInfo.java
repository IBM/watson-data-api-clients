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
 * JobPostBodyJobScheduleInfo
 */
public class JobEntityJobScheduleInfo {

    private Boolean repeat;
    private Integer startOn;
    private Integer endOn;

    public JobEntityJobScheduleInfo repeat(Boolean repeat) {
        this.repeat = repeat;
        return this;
    }

    /**
     * Indicate a repeated job
     * @return repeat
     **/
    @javax.annotation.Nullable
    @JsonProperty("repeat")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRepeat() { return repeat; }
    public void setRepeat(Boolean repeat) { this.repeat = repeat; }

    public JobEntityJobScheduleInfo startOn(Integer startOn) {
        this.startOn = startOn;
        return this;
    }

    /**
     * A timestamp in epoch time (e.g. 1547578689512), the scheduled job will be triggered after this
     * timestamp.
     * @return startOn
     **/
    @javax.annotation.Nullable
    @JsonProperty("startOn")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getStartOn() { return startOn; }
    public void setStartOn(Integer startOn) { this.startOn = startOn; }

    public JobEntityJobScheduleInfo endOn(Integer endOn) {
        this.endOn = endOn;
        return this;
    }

    /**
     * A timestamp in epoch time (e.g. 1547578689512), the scheduled job will be triggered before this
     * timestamp.
     * @return endOn
     **/
    @javax.annotation.Nullable
    @JsonProperty("endOn")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getEndOn() { return endOn; }
    public void setEndOn(Integer endOn) { this.endOn = endOn; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobEntityJobScheduleInfo jobPostBodyJobScheduleInfo = (JobEntityJobScheduleInfo)o;
        return Objects.equals(this.repeat, jobPostBodyJobScheduleInfo.repeat) &&
                Objects.equals(this.startOn, jobPostBodyJobScheduleInfo.startOn) &&
                Objects.equals(this.endOn, jobPostBodyJobScheduleInfo.endOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repeat, startOn, endOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobPostBodyJobScheduleInfo {\n");
        sb.append("    repeat: ").append(toIndentedString(repeat)).append("\n");
        sb.append("    startOn: ").append(toIndentedString(startOn)).append("\n");
        sb.append("    endOn: ").append(toIndentedString(endOn)).append("\n");
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
