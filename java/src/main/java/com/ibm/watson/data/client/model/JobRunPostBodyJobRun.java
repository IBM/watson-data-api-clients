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
 * JobRunPostBodyJobRun
 */
public class JobRunPostBodyJobRun {

    private JobRunPostBodyJobRunConfiguration _configuration;

    public JobRunPostBodyJobRun _configuration(JobRunPostBodyJobRunConfiguration _configuration) {
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
    public JobRunPostBodyJobRunConfiguration getConfiguration() { return _configuration; }
    public void setConfiguration(JobRunPostBodyJobRunConfiguration _configuration) { this._configuration = _configuration; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobRunPostBodyJobRun jobRunPostBodyJobRun = (JobRunPostBodyJobRun)o;
        return Objects.equals(this._configuration, jobRunPostBodyJobRun._configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_configuration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobRunPostBodyJobRun {\n");
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
