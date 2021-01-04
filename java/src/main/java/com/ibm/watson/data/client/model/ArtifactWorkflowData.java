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
import com.ibm.watson.data.client.model.enums.GlossaryObjectDraftMode;
import com.ibm.watson.data.client.model.enums.WorkflowAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * ArtifactWorkflowData
 */
public class ArtifactWorkflowData {

    private WorkflowAction action;
    private String baseUrl;
    private GlossaryObjectDraftMode draftMode;
    private Date oldEffectiveEndDate;
    private Date oldEffectiveStartDate;
    private Category oldParentCategory;
    private List<Workflow> workflows = null;

    public ArtifactWorkflowData action(WorkflowAction action) {
        this.action = action;
        return this;
    }

    /**
     * create_draft, get (in theory, but we won&#39;t track reads), update,
     *publish, delete_draft
     * @return action
     **/
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public WorkflowAction getAction() { return action; }
    public void setAction(WorkflowAction action) { this.action = action; }

    public ArtifactWorkflowData baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * prefix for other URLs so that workflow service can reach CES API for this
     * @return baseUrl
     **/
    @JsonProperty("base_url")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public ArtifactWorkflowData draftMode(GlossaryObjectDraftMode draftMode) {
        this.draftMode = draftMode;
        return this;
    }

    /**
     * draft mode
     * @return draftMode
     **/
    @JsonProperty("draft_mode")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public GlossaryObjectDraftMode getDraftMode() { return draftMode; }
    public void setDraftMode(GlossaryObjectDraftMode draftMode) { this.draftMode = draftMode; }

    public ArtifactWorkflowData oldEffectiveEndDate(Date oldEffectiveEndDate) {
        this.oldEffectiveEndDate = oldEffectiveEndDate;
        return this;
    }

    /**
     * timestamp
     * @return oldEffectiveEndDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("old_effective_end_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getOldEffectiveEndDate() { return oldEffectiveEndDate; }
    public void setOldEffectiveEndDate(Date oldEffectiveEndDate) { this.oldEffectiveEndDate = oldEffectiveEndDate; }

    public ArtifactWorkflowData oldEffectiveStartDate(Date oldEffectiveStartDate) {
        this.oldEffectiveStartDate = oldEffectiveStartDate;
        return this;
    }

    /**
     * timestamp
     * @return oldEffectiveStartDate
     **/
    @JsonProperty("old_effective_start_date")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getOldEffectiveStartDate() { return oldEffectiveStartDate; }
    public void setOldEffectiveStartDate(Date oldEffectiveStartDate) { this.oldEffectiveStartDate = oldEffectiveStartDate; }

    public ArtifactWorkflowData oldParentCategory(Category oldParentCategory) {
        this.oldParentCategory = oldParentCategory;
        return this;
    }

    /**
     * Get oldParentCategory
     * @return oldParentCategory
     **/
    @javax.annotation.Nullable
    @JsonProperty("old_parent_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Category getOldParentCategory() { return oldParentCategory; }
    public void setOldParentCategory(Category oldParentCategory) { this.oldParentCategory = oldParentCategory; }

    public ArtifactWorkflowData workflows(List<Workflow> workflows) {
        this.workflows = workflows;
        return this;
    }

    public ArtifactWorkflowData addWorkflowsItem(Workflow workflowsItem) {
        if (this.workflows == null) {
            this.workflows = new ArrayList<>();
        }
        this.workflows.add(workflowsItem);
        return this;
    }

    /**
     * published or archived artifacts can have more than, draft has exactly one
     * workflow.
     * @return workflows
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflows")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Workflow> getWorkflows() { return workflows; }
    public void setWorkflows(List<Workflow> workflows) { this.workflows = workflows; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ArtifactWorkflowData artifactWorkflowData = (ArtifactWorkflowData)o;
        return Objects.equals(this.action, artifactWorkflowData.action) &&
                Objects.equals(this.baseUrl, artifactWorkflowData.baseUrl) &&
                Objects.equals(this.draftMode, artifactWorkflowData.draftMode) &&
                Objects.equals(this.oldEffectiveEndDate, artifactWorkflowData.oldEffectiveEndDate) &&
                Objects.equals(this.oldEffectiveStartDate, artifactWorkflowData.oldEffectiveStartDate) &&
                Objects.equals(this.oldParentCategory, artifactWorkflowData.oldParentCategory) &&
                Objects.equals(this.workflows, artifactWorkflowData.workflows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, baseUrl, draftMode, oldEffectiveEndDate,
                oldEffectiveStartDate, oldParentCategory, workflows);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArtifactWorkflowData {\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    baseUrl: ").append(toIndentedString(baseUrl)).append("\n");
        sb.append("    draftMode: ").append(toIndentedString(draftMode)).append("\n");
        sb.append("    oldEffectiveEndDate: ").append(toIndentedString(oldEffectiveEndDate)).append("\n");
        sb.append("    oldEffectiveStartDate: ").append(toIndentedString(oldEffectiveStartDate)).append("\n");
        sb.append("    oldParentCategory: ").append(toIndentedString(oldParentCategory)).append("\n");
        sb.append("    workflows: ").append(toIndentedString(workflows)).append("\n");
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
