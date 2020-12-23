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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Optional details provided by the service about statistics of the number of deployments created with in a space or across all spaces. 
 */
public class DeploymentSystemDetails {

    private List<Warning> warnings = null;
    private List<Stats> stats = null;

    public DeploymentSystemDetails warnings(List<Warning> warnings) {
        this.warnings = warnings;
        return this;
    }

    public DeploymentSystemDetails addWarningsItem(Warning warningsItem) {
        if (this.warnings == null) {
            this.warnings = new ArrayList<>();
        }
        this.warnings.add(warningsItem);
        return this;
    }

    /**
     * Any warnings coming from the system.
     * @return warnings
     **/
    @javax.annotation.Nullable
    @JsonProperty("warnings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Warning> getWarnings() { return warnings; }
    public void setWarnings(List<Warning> warnings) { this.warnings = warnings; }

    public DeploymentSystemDetails stats(List<Stats> stats) {
        this.stats = stats;
        return this;
    }

    public DeploymentSystemDetails addStatsItem(Stats statsItem) {
        if (this.stats == null) {
            this.stats = new ArrayList<>();
        }
        this.stats.add(statsItem);
        return this;
    }

    /**
     * The stats about deployments for a space or across all spaces.
     * @return stats
     **/
    @javax.annotation.Nullable
    @JsonProperty("stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Stats> getStats() { return stats; }
    public void setStats(List<Stats> stats) { this.stats = stats; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentSystemDetails deploymentSystemDetails = (DeploymentSystemDetails) o;
        return Objects.equals(this.warnings, deploymentSystemDetails.warnings) &&
                Objects.equals(this.stats, deploymentSystemDetails.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warnings, stats);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentSystemDetails {\n");
        sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
        sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
