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
import com.ibm.watson.data.client.model.enums.WorkflowAction;
import com.ibm.watson.data.client.model.enums.WorkflowRelationshipType;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

/**
 * WorkflowEntity
 */
public class WorkflowEntity {

    private List<Artifact> artifacts = null;
    private String businessKey;
    private WorkflowAction lastAction;
    private String parentId;
    private WorkflowRelationshipType relationshipType;
    private List<UserTask> userTasks = null;
    private List<Variable> variables = null;
    private String workflowState;
    private String workflowTemplateId;
    private String workflowTemplateKey;
    private Integer workflowTemplateVersion;

    public WorkflowEntity artifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
        return this;
    }

    public WorkflowEntity addArtifactsItem(Artifact artifactsItem) {
        if (this.artifacts == null) {
            this.artifacts = new ArrayList<>();
        }
        this.artifacts.add(artifactsItem);
        return this;
    }

    /**
     * optional if includeArtifacts&#x3D;true
     * @return artifacts
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifacts")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Artifact> getArtifacts() { return artifacts; }
    public void setArtifacts(List<Artifact> artifacts) { this.artifacts = artifacts; }

    public WorkflowEntity businessKey(String businessKey) {
        this.businessKey = businessKey;
        return this;
    }

    /**
     * Get businessKey
     * @return businessKey
     **/
    @javax.annotation.Nullable
    @JsonProperty("business_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getBusinessKey() { return businessKey; }
    public void setBusinessKey(String businessKey) { this.businessKey = businessKey; }

    public WorkflowEntity lastAction(WorkflowAction lastAction) {
        this.lastAction = lastAction;
        return this;
    }

    /**
     * create_draft, get (in theory, but we won&#39;t track reads), update,
     * publish
     * @return lastAction
     **/
    @JsonProperty("last_action")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public WorkflowAction getLastAction() { return lastAction; }
    public void setLastAction(WorkflowAction lastAction) { this.lastAction = lastAction; }

    public WorkflowEntity parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * Get parentId
     * @return parentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentId() { return parentId; }
    public void setParentId(String parentId) { this.parentId = parentId; }

    public WorkflowEntity relationshipType(WorkflowRelationshipType relationshipType) {
        this.relationshipType = relationshipType;
        return this;
    }

    /**
     * relationship to parent workflow
     * @return relationshipType
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationship_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public WorkflowRelationshipType getRelationshipType() { return relationshipType; }
    public void setRelationshipType(WorkflowRelationshipType relationshipType) { this.relationshipType = relationshipType; }

    public WorkflowEntity userTasks(List<UserTask> userTasks) {
        this.userTasks = userTasks;
        return this;
    }

    public WorkflowEntity addUserTasksItem(UserTask userTasksItem) {
        if (this.userTasks == null) {
            this.userTasks = new ArrayList<>();
        }
        this.userTasks.add(userTasksItem);
        return this;
    }

    /**
     * optional if includeUserTasks&#x3D;true
     * @return userTasks
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_tasks")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<UserTask> getUserTasks() { return userTasks; }
    public void setUserTasks(List<UserTask> userTasks) { this.userTasks = userTasks; }

    public WorkflowEntity variables(List<Variable> variables) {
        this.variables = variables;
        return this;
    }

    public WorkflowEntity addVariablesItem(Variable variablesItem) {
        if (this.variables == null) {
            this.variables = new ArrayList<>();
        }
        this.variables.add(variablesItem);
        return this;
    }

    /**
     * optional if includeVariables&#x3D;true
     * @return variables
     **/
    @javax.annotation.Nullable
    @JsonProperty("variables")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Variable> getVariables() { return variables; }
    public void setVariables(List<Variable> variables) { this.variables = variables; }

    public WorkflowEntity workflowState(String workflowState) {
        this.workflowState = workflowState;
        return this;
    }

    /**
     * Get workflowState
     * @return workflowState
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowState() { return workflowState; }
    public void setWorkflowState(String workflowState) { this.workflowState = workflowState; }

    public WorkflowEntity workflowTemplateId(String workflowTemplateId) {
        this.workflowTemplateId = workflowTemplateId;
        return this;
    }

    /**
     * Get workflowTemplateId
     * @return workflowTemplateId
     **/
    @JsonProperty("workflow_template_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getWorkflowTemplateId() { return workflowTemplateId; }
    public void setWorkflowTemplateId(String workflowTemplateId) { this.workflowTemplateId = workflowTemplateId; }

    public WorkflowEntity workflowTemplateKey(String workflowTemplateKey) {
        this.workflowTemplateKey = workflowTemplateKey;
        return this;
    }

    /**
     * Get workflowTemplateKey
     * @return workflowTemplateKey
     **/
    @JsonProperty("workflow_template_key")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getWorkflowTemplateKey() { return workflowTemplateKey; }
    public void setWorkflowTemplateKey(String workflowTemplateKey) { this.workflowTemplateKey = workflowTemplateKey; }

    public WorkflowEntity workflowTemplateVersion(Integer workflowTemplateVersion) {
        this.workflowTemplateVersion = workflowTemplateVersion;
        return this;
    }

    /**
     * Get workflowTemplateVersion
     * @return workflowTemplateVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_template_version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getWorkflowTemplateVersion() { return workflowTemplateVersion; }
    public void setWorkflowTemplateVersion(Integer workflowTemplateVersion) { this.workflowTemplateVersion = workflowTemplateVersion; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WorkflowEntity workflowEntity = (WorkflowEntity)o;
        return Objects.equals(this.artifacts, workflowEntity.artifacts) &&
                Objects.equals(this.businessKey, workflowEntity.businessKey) &&
                Objects.equals(this.lastAction, workflowEntity.lastAction) &&
                Objects.equals(this.parentId, workflowEntity.parentId) &&
                Objects.equals(this.relationshipType, workflowEntity.relationshipType) &&
                Objects.equals(this.userTasks, workflowEntity.userTasks) &&
                Objects.equals(this.variables, workflowEntity.variables) &&
                Objects.equals(this.workflowState, workflowEntity.workflowState) &&
                Objects.equals(this.workflowTemplateId, workflowEntity.workflowTemplateId) &&
                Objects.equals(this.workflowTemplateKey, workflowEntity.workflowTemplateKey) &&
                Objects.equals(this.workflowTemplateVersion, workflowEntity.workflowTemplateVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifacts, businessKey, lastAction, parentId,
                relationshipType, userTasks, variables, workflowState,
                workflowTemplateId, workflowTemplateKey,
                workflowTemplateVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkflowEntity {\n");
        sb.append("    artifacts: ").append(toIndentedString(artifacts)).append("\n");
        sb.append("    businessKey: ").append(toIndentedString(businessKey)).append("\n");
        sb.append("    lastAction: ").append(toIndentedString(lastAction)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
        sb.append("    userTasks: ").append(toIndentedString(userTasks)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("    workflowState: ").append(toIndentedString(workflowState)).append("\n");
        sb.append("    workflowTemplateId: ").append(toIndentedString(workflowTemplateId)).append("\n");
        sb.append("    workflowTemplateKey: ").append(toIndentedString(workflowTemplateKey)).append("\n");
        sb.append("    workflowTemplateVersion: ").append(toIndentedString(workflowTemplateVersion)).append("\n");
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
