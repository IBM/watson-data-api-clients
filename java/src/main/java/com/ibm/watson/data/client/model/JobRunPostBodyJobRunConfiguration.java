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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * JobRunPostBodyJobRunConfiguration
 */
public class JobRunPostBodyJobRunConfiguration {

    private List<String> envVariables = null;

    public JobRunPostBodyJobRunConfiguration envVariables(List<String> envVariables) {
        this.envVariables = envVariables;
        return this;
    }

    public JobRunPostBodyJobRunConfiguration addEnvVariablesItem(String envVariablesItem) {
        if (this.envVariables == null) {
            this.envVariables = new ArrayList<>();
        }
        this.envVariables.add(envVariablesItem);
        return this;
    }

    /**
     * The environment variables, only for Notebook and Script jobs (example: ['key1=value1', 'key2=value2']).
     * @return envVariables
     **/
    @javax.annotation.Nullable
    @JsonProperty("env_variables")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getEnvVariables() { return envVariables; }
    public void setEnvVariables(List<String> envVariables) { this.envVariables = envVariables; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobRunPostBodyJobRunConfiguration jobRunPostBodyJobRunConfiguration = (JobRunPostBodyJobRunConfiguration)o;
        return Objects.equals(this.envVariables, jobRunPostBodyJobRunConfiguration.envVariables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(envVariables);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobRunPostBodyJobRunConfiguration {\n");
        sb.append("    envVariables: ").append(toIndentedString(envVariables)).append("\n");
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
