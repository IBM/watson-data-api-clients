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
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * UserTaskEntity
 */
public class UserTaskEntity {

    private String assignee;
    private List<String> candidateGroups = null;
    private List<String> candidateUsers = null;
    private Date claimedAt;
    private Date completedAt;
    private Date dueDate;
    private String formKey;
    private List<FormProperty> formProperties = null;
    private String owner;
    private String parentTaskId;
    private Integer priority;
    private String taskDefinitionKey;
    private String taskInstruction;
    private String taskTitle;
    private List<Variable> variables = null;
    private String workflowTemplateId;

    public UserTaskEntity assignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    /**
     * Get assignee
     * @return assignee
     **/
    @javax.annotation.Nullable
    @JsonProperty("assignee")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

    public UserTaskEntity candidateGroups(List<String> candidateGroups) {
        this.candidateGroups = candidateGroups;
        return this;
    }

    public UserTaskEntity addCandidateGroupsItem(String candidateGroupsItem) {
        if (this.candidateGroups == null) {
            this.candidateGroups = new ArrayList<>();
        }
        this.candidateGroups.add(candidateGroupsItem);
        return this;
    }

    /**
     * list of candidate groups
     * @return candidateGroups
     **/
    @javax.annotation.Nullable
    @JsonProperty("candidate_groups")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getCandidateGroups() { return candidateGroups; }
    public void setCandidateGroups(List<String> candidateGroups) { this.candidateGroups = candidateGroups; }

    public UserTaskEntity candidateUsers(List<String> candidateUsers) {
        this.candidateUsers = candidateUsers;
        return this;
    }

    public UserTaskEntity addCandidateUsersItem(String candidateUsersItem) {
        if (this.candidateUsers == null) {
            this.candidateUsers = new ArrayList<>();
        }
        this.candidateUsers.add(candidateUsersItem);
        return this;
    }

    /**
     * list of candidate users
     * @return candidateUsers
     **/
    @javax.annotation.Nullable
    @JsonProperty("candidate_users")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getCandidateUsers() { return candidateUsers; }
    public void setCandidateUsers(List<String> candidateUsers) { this.candidateUsers = candidateUsers; }

    public UserTaskEntity claimedAt(Date claimedAt) {
        this.claimedAt = claimedAt;
        return this;
    }

    /**
     * optional aka claim_time, claimed_date
     * @return claimedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("claimed_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getClaimedAt() { return claimedAt; }
    public void setClaimedAt(Date claimedAt) { this.claimedAt = claimedAt; }

    public UserTaskEntity completedAt(Date completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * optional aka completed_date
     * @return completedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("completed_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCompletedAt() { return completedAt; }
    public void setCompletedAt(Date completedAt) { this.completedAt = completedAt; }

    public UserTaskEntity dueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     * Get dueDate
     * @return dueDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("due_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public UserTaskEntity formKey(String formKey) {
        this.formKey = formKey;
        return this;
    }

    /**
     * optional, refers to an externally defined form definition
     * @return formKey
     **/
    @javax.annotation.Nullable
    @JsonProperty("form_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getFormKey() { return formKey; }
    public void setFormKey(String formKey) { this.formKey = formKey; }

    public UserTaskEntity formProperties(List<FormProperty> formProperties) {
        this.formProperties = formProperties;
        return this;
    }

    public UserTaskEntity addFormPropertiesItem(FormProperty formPropertiesItem) {
        if (this.formProperties == null) {
            this.formProperties = new ArrayList<>();
        }
        this.formProperties.add(formPropertiesItem);
        return this;
    }

    /**
     * list of form properties
     * @return formProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("form_properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<FormProperty> getFormProperties() { return formProperties; }
    public void setFormProperties(List<FormProperty> formProperties) { this.formProperties = formProperties; }

    public UserTaskEntity owner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Get owner
     * @return owner
     **/
    @javax.annotation.Nullable
    @JsonProperty("owner")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public UserTaskEntity parentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
        return this;
    }

    /**
     * Get parentTaskId
     * @return parentTaskId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_task_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentTaskId() { return parentTaskId; }
    public void setParentTaskId(String parentTaskId) { this.parentTaskId = parentTaskId; }

    public UserTaskEntity priority(Integer priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Get priority
     * @return priority
     **/
    @JsonProperty("priority")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public UserTaskEntity taskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
        return this;
    }

    /**
     * need to get it from internal data structure!
     * @return taskDefinitionKey
     **/
    @JsonProperty("task_definition_key")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTaskDefinitionKey() { return taskDefinitionKey; }
    public void setTaskDefinitionKey(String taskDefinitionKey) { this.taskDefinitionKey = taskDefinitionKey; }

    public UserTaskEntity taskInstruction(String taskInstruction) {
        this.taskInstruction = taskInstruction;
        return this;
    }

    /**
     * Get taskInstruction
     * @return taskInstruction
     **/
    @JsonProperty("task_instruction")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTaskInstruction() { return taskInstruction; }
    public void setTaskInstruction(String taskInstruction) { this.taskInstruction = taskInstruction; }

    public UserTaskEntity taskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
        return this;
    }

    /**
     * Get taskTitle
     * @return taskTitle
     **/
    @JsonProperty("task_title")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTaskTitle() { return taskTitle; }
    public void setTaskTitle(String taskTitle) { this.taskTitle = taskTitle; }

    public UserTaskEntity variables(List<Variable> variables) {
        this.variables = variables;
        return this;
    }

    public UserTaskEntity addVariablesItem(Variable variablesItem) {
        if (this.variables == null) {
            this.variables = new ArrayList<>();
        }
        this.variables.add(variablesItem);
        return this;
    }

    /**
     * variables specifically for the task
     * @return variables
     **/
    @javax.annotation.Nullable
    @JsonProperty("variables")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Variable> getVariables() { return variables; }
    public void setVariables(List<Variable> variables) { this.variables = variables; }

    public UserTaskEntity workflowTemplateId(String workflowTemplateId) {
        this.workflowTemplateId = workflowTemplateId;
        return this;
    }

    /**
     * Get workflowTemplateId
     * @return workflowTemplateId
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_template_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowTemplateId() { return workflowTemplateId; }
    public void setWorkflowTemplateId(String workflowTemplateId) { this.workflowTemplateId = workflowTemplateId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserTaskEntity userTaskEntity = (UserTaskEntity)o;
        return Objects.equals(this.assignee, userTaskEntity.assignee) &&
                Objects.equals(this.candidateGroups, userTaskEntity.candidateGroups) &&
                Objects.equals(this.candidateUsers, userTaskEntity.candidateUsers) &&
                Objects.equals(this.claimedAt, userTaskEntity.claimedAt) &&
                Objects.equals(this.completedAt, userTaskEntity.completedAt) &&
                Objects.equals(this.dueDate, userTaskEntity.dueDate) &&
                Objects.equals(this.formKey, userTaskEntity.formKey) &&
                Objects.equals(this.formProperties, userTaskEntity.formProperties) &&
                Objects.equals(this.owner, userTaskEntity.owner) &&
                Objects.equals(this.parentTaskId, userTaskEntity.parentTaskId) &&
                Objects.equals(this.priority, userTaskEntity.priority) &&
                Objects.equals(this.taskDefinitionKey, userTaskEntity.taskDefinitionKey) &&
                Objects.equals(this.taskInstruction, userTaskEntity.taskInstruction) &&
                Objects.equals(this.taskTitle, userTaskEntity.taskTitle) &&
                Objects.equals(this.variables, userTaskEntity.variables) &&
                Objects.equals(this.workflowTemplateId, userTaskEntity.workflowTemplateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignee, candidateGroups, candidateUsers, claimedAt,
                completedAt, dueDate, formKey, formProperties, owner,
                parentTaskId, priority, taskDefinitionKey,
                taskInstruction, taskTitle, variables,
                workflowTemplateId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserTaskEntity {\n");
        sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
        sb.append("    candidateGroups: ").append(toIndentedString(candidateGroups)).append("\n");
        sb.append("    candidateUsers: ").append(toIndentedString(candidateUsers)).append("\n");
        sb.append("    claimedAt: ").append(toIndentedString(claimedAt)).append("\n");
        sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    formKey: ").append(toIndentedString(formKey)).append("\n");
        sb.append("    formProperties: ").append(toIndentedString(formProperties)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    parentTaskId: ").append(toIndentedString(parentTaskId)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    taskDefinitionKey: ").append(toIndentedString(taskDefinitionKey)).append("\n");
        sb.append("    taskInstruction: ").append(toIndentedString(taskInstruction)).append("\n");
        sb.append("    taskTitle: ").append(toIndentedString(taskTitle)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("    workflowTemplateId: ").append(toIndentedString(workflowTemplateId)).append("\n");
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
