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
import com.ibm.watson.data.client.model.enums.WorkflowState;

import java.util.Date;
import java.util.Objects;

/**
 * WorkflowMetadata
 */
public class WorkflowMetadata {

    private String artifactType;
    private Date createdAt;
    private String createdBy;
    private String description;
    private Date modifiedAt;
    private String modifiedBy;
    private String name;
    private WorkflowState state;
    private String workflowId;

    public WorkflowMetadata artifactType(String artifactType) {
        this.artifactType = artifactType;
        return this;
    }

    /**
     * Get artifactType
     * @return artifactType
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactType() { return artifactType; }
    public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

    public WorkflowMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     * @return createdAt
     **/
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public WorkflowMetadata createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     * @return createdBy
     **/
    @JsonProperty("created_by")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public WorkflowMetadata description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public WorkflowMetadata modifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    /**
     * Get modifiedAt
     * @return modifiedAt
     **/
    @JsonProperty("modified_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Date modifiedAt) { this.modifiedAt = modifiedAt; }

    public WorkflowMetadata modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    /**
     * Get modifiedBy
     * @return modifiedBy
     **/
    @JsonProperty("modified_by")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public WorkflowMetadata name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public WorkflowMetadata state(WorkflowState state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public WorkflowState getState() { return state; }
    public void setState(WorkflowState state) { this.state = state; }

    public WorkflowMetadata workflowId(String workflowId) {
        this.workflowId = workflowId;
        return this;
    }

    /**
     * Get workflowId
     * @return workflowId
     **/
    @JsonProperty("workflow_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getWorkflowId() { return workflowId; }
    public void setWorkflowId(String workflowId) { this.workflowId = workflowId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WorkflowMetadata workflowMetadata = (WorkflowMetadata)o;
        return Objects.equals(this.artifactType, workflowMetadata.artifactType) &&
                Objects.equals(this.createdAt, workflowMetadata.createdAt) &&
                Objects.equals(this.createdBy, workflowMetadata.createdBy) &&
                Objects.equals(this.description, workflowMetadata.description) &&
                Objects.equals(this.modifiedAt, workflowMetadata.modifiedAt) &&
                Objects.equals(this.modifiedBy, workflowMetadata.modifiedBy) &&
                Objects.equals(this.name, workflowMetadata.name) &&
                Objects.equals(this.state, workflowMetadata.state) &&
                Objects.equals(this.workflowId, workflowMetadata.workflowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactType, createdAt, createdBy, description,
                modifiedAt, modifiedBy, name, state, workflowId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkflowMetadata {\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
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
