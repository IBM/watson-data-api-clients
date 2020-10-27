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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LocalRepositoryConfig
 */
public class LocalRepositoryConfig {

    private String metadataCollectionId;
    private String metadataCollectionName;
    private Connection localRepositoryLocalConnection;
    private Connection localRepositoryRemoteConnection;
    private EventTypeFilter eventsToSaveRule;
    private List<TypeDefSummary> selectedTypesToSave = null;
    private EventTypeFilter eventsToSendRule;
    private List<TypeDefSummary> selectedTypesToSend = null;
    private Connection eventMapperConnection;

    public LocalRepositoryConfig metadataCollectionId(String metadataCollectionId) {
        this.metadataCollectionId = metadataCollectionId;
        return this;
    }

    /**
     * Get metadataCollectionId
     * @return metadataCollectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadataCollectionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMetadataCollectionId() { return metadataCollectionId; }
    public void setMetadataCollectionId(String metadataCollectionId) { this.metadataCollectionId = metadataCollectionId; }

    public LocalRepositoryConfig metadataCollectionName(String metadataCollectionName) {
        this.metadataCollectionName = metadataCollectionName;
        return this;
    }

    /**
     * Get metadataCollectionName
     * @return metadataCollectionName
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadataCollectionName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMetadataCollectionName() { return metadataCollectionName; }
    public void setMetadataCollectionName(String metadataCollectionName) { this.metadataCollectionName = metadataCollectionName; }

    public LocalRepositoryConfig localRepositoryLocalConnection(Connection localRepositoryLocalConnection) {
        this.localRepositoryLocalConnection = localRepositoryLocalConnection;
        return this;
    }

    /**
     * Get localRepositoryLocalConnection
     * @return localRepositoryLocalConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("localRepositoryLocalConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getLocalRepositoryLocalConnection() { return localRepositoryLocalConnection; }
    public void setLocalRepositoryLocalConnection(Connection localRepositoryLocalConnection) { this.localRepositoryLocalConnection = localRepositoryLocalConnection; }

    public LocalRepositoryConfig localRepositoryRemoteConnection(Connection localRepositoryRemoteConnection) {
        this.localRepositoryRemoteConnection = localRepositoryRemoteConnection;
        return this;
    }

    /**
     * Get localRepositoryRemoteConnection
     * @return localRepositoryRemoteConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("localRepositoryRemoteConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getLocalRepositoryRemoteConnection() { return localRepositoryRemoteConnection; }
    public void setLocalRepositoryRemoteConnection(Connection localRepositoryRemoteConnection) { this.localRepositoryRemoteConnection = localRepositoryRemoteConnection; }

    public LocalRepositoryConfig eventsToSaveRule(EventTypeFilter eventsToSaveRule) {
        this.eventsToSaveRule = eventsToSaveRule;
        return this;
    }

    /**
     * Get eventsToSaveRule
     * @return eventsToSaveRule
     **/
    @javax.annotation.Nullable
    @JsonProperty("eventsToSaveRule")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EventTypeFilter getEventsToSaveRule() { return eventsToSaveRule; }
    public void setEventsToSaveRule(EventTypeFilter eventsToSaveRule) { this.eventsToSaveRule = eventsToSaveRule; }

    public LocalRepositoryConfig selectedTypesToSave(List<TypeDefSummary> selectedTypesToSave) {
        this.selectedTypesToSave = selectedTypesToSave;
        return this;
    }

    public LocalRepositoryConfig addSelectedTypesToSaveItem(TypeDefSummary selectedTypesToSaveItem) {
        if (this.selectedTypesToSave == null) {
            this.selectedTypesToSave = new ArrayList<>();
        }
        this.selectedTypesToSave.add(selectedTypesToSaveItem);
        return this;
    }

    /**
     * Get selectedTypesToSave
     * @return selectedTypesToSave
     **/
    @javax.annotation.Nullable
    @JsonProperty("selectedTypesToSave")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TypeDefSummary> getSelectedTypesToSave() { return selectedTypesToSave; }
    public void setSelectedTypesToSave(List<TypeDefSummary> selectedTypesToSave) { this.selectedTypesToSave = selectedTypesToSave; }

    public LocalRepositoryConfig eventsToSendRule(EventTypeFilter eventsToSendRule) {
        this.eventsToSendRule = eventsToSendRule;
        return this;
    }

    /**
     * Get eventsToSendRule
     * @return eventsToSendRule
     **/
    @javax.annotation.Nullable
    @JsonProperty("eventsToSendRule")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EventTypeFilter getEventsToSendRule() { return eventsToSendRule; }
    public void setEventsToSendRule(EventTypeFilter eventsToSendRule) { this.eventsToSendRule = eventsToSendRule; }

    public LocalRepositoryConfig selectedTypesToSend(List<TypeDefSummary> selectedTypesToSend) {
        this.selectedTypesToSend = selectedTypesToSend;
        return this;
    }

    public LocalRepositoryConfig addSelectedTypesToSendItem(TypeDefSummary selectedTypesToSendItem) {
        if (this.selectedTypesToSend == null) {
            this.selectedTypesToSend = new ArrayList<>();
        }
        this.selectedTypesToSend.add(selectedTypesToSendItem);
        return this;
    }

    /**
     * Get selectedTypesToSend
     * @return selectedTypesToSend
     **/
    @javax.annotation.Nullable
    @JsonProperty("selectedTypesToSend")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TypeDefSummary> getSelectedTypesToSend() { return selectedTypesToSend; }
    public void setSelectedTypesToSend(List<TypeDefSummary> selectedTypesToSend) { this.selectedTypesToSend = selectedTypesToSend; }

    public LocalRepositoryConfig eventMapperConnection(Connection eventMapperConnection) {
        this.eventMapperConnection = eventMapperConnection;
        return this;
    }

    /**
     * Get eventMapperConnection
     * @return eventMapperConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("eventMapperConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getEventMapperConnection() { return eventMapperConnection; }
    public void setEventMapperConnection(Connection eventMapperConnection) { this.eventMapperConnection = eventMapperConnection; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        LocalRepositoryConfig localRepositoryConfig = (LocalRepositoryConfig)o;
        return Objects.equals(this.metadataCollectionId, localRepositoryConfig.metadataCollectionId) &&
                Objects.equals(this.metadataCollectionName, localRepositoryConfig.metadataCollectionName) &&
                Objects.equals(this.localRepositoryLocalConnection, localRepositoryConfig.localRepositoryLocalConnection) &&
                Objects.equals(this.localRepositoryRemoteConnection, localRepositoryConfig.localRepositoryRemoteConnection) &&
                Objects.equals(this.eventsToSaveRule, localRepositoryConfig.eventsToSaveRule) &&
                Objects.equals(this.selectedTypesToSave, localRepositoryConfig.selectedTypesToSave) &&
                Objects.equals(this.eventsToSendRule, localRepositoryConfig.eventsToSendRule) &&
                Objects.equals(this.selectedTypesToSend, localRepositoryConfig.selectedTypesToSend) &&
                Objects.equals(this.eventMapperConnection, localRepositoryConfig.eventMapperConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadataCollectionId, metadataCollectionName,
                localRepositoryLocalConnection,
                localRepositoryRemoteConnection, eventsToSaveRule,
                selectedTypesToSave, eventsToSendRule,
                selectedTypesToSend, eventMapperConnection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LocalRepositoryConfig {\n");
        sb.append("    metadataCollectionId: ").append(toIndentedString(metadataCollectionId)).append("\n");
        sb.append("    metadataCollectionName: ").append(toIndentedString(metadataCollectionName)).append("\n");
        sb.append("    localRepositoryLocalConnection: ").append(toIndentedString(localRepositoryLocalConnection)).append("\n");
        sb.append("    localRepositoryRemoteConnection: ").append(toIndentedString(localRepositoryRemoteConnection)).append("\n");
        sb.append("    eventsToSaveRule: ").append(toIndentedString(eventsToSaveRule)).append("\n");
        sb.append("    selectedTypesToSave: ").append(toIndentedString(selectedTypesToSave)).append("\n");
        sb.append("    eventsToSendRule: ").append(toIndentedString(eventsToSendRule)).append("\n");
        sb.append("    selectedTypesToSend: ").append(toIndentedString(selectedTypesToSend)).append("\n");
        sb.append("    eventMapperConnection: ").append(toIndentedString(eventMapperConnection)).append("\n");
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
