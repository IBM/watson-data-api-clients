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
import com.ibm.watson.data.client.model.enums.EventTypeFilter;
import com.ibm.watson.data.client.model.enums.OMRSProtocolVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CohortConfig
 */
public class CohortConfig {

    private String cohortName;
    private Connection cohortRegistryConnection;
    private Connection cohortOMRSTopicConnection;
    private OMRSProtocolVersion cohortOMRSTopicProtocolVersion;
    private EventTypeFilter eventsToProcessRule;
    private List<TypeDefSummary> selectedTypesToProcess = null;

    public CohortConfig cohortName(String cohortName) {
        this.cohortName = cohortName;
        return this;
    }

    /**
     * Get cohortName
     * @return cohortName
     **/
    @javax.annotation.Nullable
    @JsonProperty("cohortName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCohortName() { return cohortName; }
    public void setCohortName(String cohortName) { this.cohortName = cohortName; }

    public CohortConfig cohortRegistryConnection(Connection cohortRegistryConnection) {
        this.cohortRegistryConnection = cohortRegistryConnection;
        return this;
    }

    /**
     * Get cohortRegistryConnection
     * @return cohortRegistryConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("cohortRegistryConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getCohortRegistryConnection() { return cohortRegistryConnection; }
    public void setCohortRegistryConnection(Connection cohortRegistryConnection) { this.cohortRegistryConnection = cohortRegistryConnection; }

    public CohortConfig cohortOMRSTopicConnection(Connection cohortOMRSTopicConnection) {
        this.cohortOMRSTopicConnection = cohortOMRSTopicConnection;
        return this;
    }

    /**
     * Get cohortOMRSTopicConnection
     * @return cohortOMRSTopicConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("cohortOMRSTopicConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getCohortOMRSTopicConnection() { return cohortOMRSTopicConnection; }
    public void setCohortOMRSTopicConnection(Connection cohortOMRSTopicConnection) { this.cohortOMRSTopicConnection = cohortOMRSTopicConnection; }

    public CohortConfig cohortOMRSTopicProtocolVersion(OMRSProtocolVersion cohortOMRSTopicProtocolVersion) {
        this.cohortOMRSTopicProtocolVersion = cohortOMRSTopicProtocolVersion;
        return this;
    }

    /**
     * Get cohortOMRSTopicProtocolVersion
     * @return cohortOMRSTopicProtocolVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty("cohortOMRSTopicProtocolVersion")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OMRSProtocolVersion getCohortOMRSTopicProtocolVersion() { return cohortOMRSTopicProtocolVersion; }
    public void setCohortOMRSTopicProtocolVersion(OMRSProtocolVersion cohortOMRSTopicProtocolVersion) { this.cohortOMRSTopicProtocolVersion = cohortOMRSTopicProtocolVersion; }

    public CohortConfig eventsToProcessRule(EventTypeFilter eventsToProcessRule) {
        this.eventsToProcessRule = eventsToProcessRule;
        return this;
    }

    /**
     * Get eventsToProcessRule
     * @return eventsToProcessRule
     **/
    @javax.annotation.Nullable
    @JsonProperty("eventsToProcessRule")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EventTypeFilter getEventsToProcessRule() { return eventsToProcessRule; }
    public void setEventsToProcessRule(EventTypeFilter eventsToProcessRule) { this.eventsToProcessRule = eventsToProcessRule; }

    public CohortConfig selectedTypesToProcess(List<TypeDefSummary> selectedTypesToProcess) {
        this.selectedTypesToProcess = selectedTypesToProcess;
        return this;
    }

    public CohortConfig addSelectedTypesToProcessItem(TypeDefSummary selectedTypesToProcessItem) {
        if (this.selectedTypesToProcess == null) {
            this.selectedTypesToProcess = new ArrayList<>();
        }
        this.selectedTypesToProcess.add(selectedTypesToProcessItem);
        return this;
    }

    /**
     * Get selectedTypesToProcess
     * @return selectedTypesToProcess
     **/
    @javax.annotation.Nullable
    @JsonProperty("selectedTypesToProcess")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TypeDefSummary> getSelectedTypesToProcess() { return selectedTypesToProcess; }
    public void setSelectedTypesToProcess(List<TypeDefSummary> selectedTypesToProcess) { this.selectedTypesToProcess = selectedTypesToProcess; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CohortConfig cohortConfig = (CohortConfig)o;
        return Objects.equals(this.cohortName, cohortConfig.cohortName) &&
                Objects.equals(this.cohortRegistryConnection, cohortConfig.cohortRegistryConnection) &&
                Objects.equals(this.cohortOMRSTopicConnection, cohortConfig.cohortOMRSTopicConnection) &&
                Objects.equals(this.cohortOMRSTopicProtocolVersion, cohortConfig.cohortOMRSTopicProtocolVersion) &&
                Objects.equals(this.eventsToProcessRule, cohortConfig.eventsToProcessRule) &&
                Objects.equals(this.selectedTypesToProcess, cohortConfig.selectedTypesToProcess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cohortName, cohortRegistryConnection,
                cohortOMRSTopicConnection,
                cohortOMRSTopicProtocolVersion, eventsToProcessRule,
                selectedTypesToProcess);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CohortConfig {\n");
        sb.append("    cohortName: ").append(toIndentedString(cohortName)).append("\n");
        sb.append("    cohortRegistryConnection: ").append(toIndentedString(cohortRegistryConnection)).append("\n");
        sb.append("    cohortOMRSTopicConnection: ").append(toIndentedString(cohortOMRSTopicConnection)).append("\n");
        sb.append("    cohortOMRSTopicProtocolVersion: ").append(toIndentedString(cohortOMRSTopicProtocolVersion)).append("\n");
        sb.append("    eventsToProcessRule: ").append(toIndentedString(eventsToProcessRule)).append("\n");
        sb.append("    selectedTypesToProcess: ").append(toIndentedString(selectedTypesToProcess)).append("\n");
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
