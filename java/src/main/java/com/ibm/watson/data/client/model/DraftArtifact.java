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
 * DraftArtifact
 */
public class DraftArtifact {

    private String name;
    private String artifactId;
    private String versionId;
    private String workflowId;
    private String type;
    private String longDescription;
    private Date createdAt;
    private Date modifiedAt;
    private String createdBy;
    private String modifiedBy;
    private SearchRelatedAsset parentCategory;
    private String workflowStatus;
    private String draftMode;
    private List<String> abbreviations = null;
    private Boolean isEnabled;
    private List<String> tags = null;

    public DraftArtifact name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DraftArtifact artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * Get artifactId
     * @return artifactId
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public DraftArtifact versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * Get versionId
     * @return versionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("version_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    public DraftArtifact workflowId(String workflowId) {
        this.workflowId = workflowId;
        return this;
    }

    /**
     * Get workflowId
     * @return workflowId
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowId() { return workflowId; }
    public void setWorkflowId(String workflowId) { this.workflowId = workflowId; }

    public DraftArtifact type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public DraftArtifact longDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    /**
     * Get longDescription
     * @return longDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("long_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public DraftArtifact createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public DraftArtifact modifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    /**
     * Get modifiedAt
     * @return modifiedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Date modifiedAt) { this.modifiedAt = modifiedAt; }

    public DraftArtifact createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     * @return createdBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public DraftArtifact modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    /**
     * Get modifiedBy
     * @return modifiedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public DraftArtifact parentCategory(SearchRelatedAsset parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    /**
     * Get parentCategory
     * @return parentCategory
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SearchRelatedAsset getParentCategory() { return parentCategory; }
    public void setParentCategory(SearchRelatedAsset parentCategory) { this.parentCategory = parentCategory; }

    public DraftArtifact workflowStatus(String workflowStatus) {
        this.workflowStatus = workflowStatus;
        return this;
    }

    /**
     * Get workflowStatus
     * @return workflowStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowStatus() { return workflowStatus; }
    public void setWorkflowStatus(String workflowStatus) { this.workflowStatus = workflowStatus; }

    public DraftArtifact draftMode(String draftMode) {
        this.draftMode = draftMode;
        return this;
    }

    /**
     * Get draftMode
     * @return draftMode
     **/
    @javax.annotation.Nullable
    @JsonProperty("draft_mode")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDraftMode() { return draftMode; }
    public void setDraftMode(String draftMode) { this.draftMode = draftMode; }

    public DraftArtifact abbreviations(List<String> abbreviations) {
        this.abbreviations = abbreviations;
        return this;
    }

    public DraftArtifact addAbbreviationsItem(String abbreviationsItem) {
        if (this.abbreviations == null) {
            this.abbreviations = new ArrayList<>();
        }
        this.abbreviations.add(abbreviationsItem);
        return this;
    }

    /**
     * Get abbreviations
     * @return abbreviations
     **/
    @javax.annotation.Nullable
    @JsonProperty("abbreviations")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAbbreviations() { return abbreviations; }
    public void setAbbreviations(List<String> abbreviations) { this.abbreviations = abbreviations; }

    public DraftArtifact isEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Get isEnabled
     * @return isEnabled
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_enabled")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsEnabled() { return isEnabled; }
    public void setIsEnabled(Boolean isEnabled) { this.isEnabled = isEnabled; }

    public DraftArtifact tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public DraftArtifact addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Get tags
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DraftArtifact draftArtifact = (DraftArtifact)o;
        return Objects.equals(this.name, draftArtifact.name) &&
                Objects.equals(this.artifactId, draftArtifact.artifactId) &&
                Objects.equals(this.versionId, draftArtifact.versionId) &&
                Objects.equals(this.workflowId, draftArtifact.workflowId) &&
                Objects.equals(this.type, draftArtifact.type) &&
                Objects.equals(this.longDescription, draftArtifact.longDescription) &&
                Objects.equals(this.createdAt, draftArtifact.createdAt) &&
                Objects.equals(this.modifiedAt, draftArtifact.modifiedAt) &&
                Objects.equals(this.createdBy, draftArtifact.createdBy) &&
                Objects.equals(this.modifiedBy, draftArtifact.modifiedBy) &&
                Objects.equals(this.parentCategory, draftArtifact.parentCategory) &&
                Objects.equals(this.workflowStatus, draftArtifact.workflowStatus) &&
                Objects.equals(this.draftMode, draftArtifact.draftMode) &&
                Objects.equals(this.abbreviations, draftArtifact.abbreviations) &&
                Objects.equals(this.isEnabled, draftArtifact.isEnabled) &&
                Objects.equals(this.tags, draftArtifact.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artifactId, versionId, workflowId, type,
                longDescription, createdAt, modifiedAt, createdBy,
                modifiedBy, parentCategory, workflowStatus, draftMode,
                abbreviations, isEnabled, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DraftArtifact {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
        sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    longDescription: ").append(toIndentedString(longDescription)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    workflowStatus: ").append(toIndentedString(workflowStatus)).append("\n");
        sb.append("    draftMode: ").append(toIndentedString(draftMode)).append("\n");
        sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
        sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
