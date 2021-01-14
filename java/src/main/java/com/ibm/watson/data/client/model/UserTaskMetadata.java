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
import com.ibm.watson.data.client.model.enums.UserTaskState;

import java.util.Date;
import java.util.Objects;

/**
 * UserTaskMetadata
 */
public class UserTaskMetadata {

    private String artifactType;
    private Date createdAt;
    private String name;
    private UserTaskState state;
    private String taskId;
    private String workflowId;

    public UserTaskMetadata artifactType(String artifactType) {
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

    public UserTaskMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * aka create_time, created_date
     * @return createdAt
     **/
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public UserTaskMetadata name(String name) {
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

    public UserTaskMetadata state(UserTaskState state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public UserTaskState getState() { return state; }
    public void setState(UserTaskState state) { this.state = state; }

    public UserTaskMetadata taskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    /**
     * Get taskId
     * @return taskId
     **/
    @JsonProperty("task_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public UserTaskMetadata workflowId(String workflowId) {
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
        UserTaskMetadata userTaskMetadata = (UserTaskMetadata)o;
        return Objects.equals(this.artifactType, userTaskMetadata.artifactType) &&
                Objects.equals(this.createdAt, userTaskMetadata.createdAt) &&
                Objects.equals(this.name, userTaskMetadata.name) &&
                Objects.equals(this.state, userTaskMetadata.state) &&
                Objects.equals(this.taskId, userTaskMetadata.taskId) &&
                Objects.equals(this.workflowId, userTaskMetadata.workflowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactType, createdAt, name, state, taskId,
                workflowId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserTaskMetadata {\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
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
