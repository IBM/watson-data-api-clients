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
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * GlossaryObjectMetadata
 */
public class GlossaryObjectMetadata {

    private String artifactType;
    private String artifactId;
    private String versionId;
    private String sourceRepositoryId;
    private String externalId;
    private String globalId;
    private String workflowId;
    private GlossaryObjectDraftMode draftMode;
    private String publishedAncestorId;
    private String draftAncestorId;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private String createdBy;
    private Date createdAt;
    private String modifiedBy;
    private Date modifiedAt;
    private String revision;
    private String name;
    private String shortDescription;
    private GlossaryObjectState state;
    private List<String> tags = null;
    private List<String> stewardIds = null;
    private String workflowState;
    private Boolean readOnly;
    private Boolean removeStartDate;
    private Boolean removeEndDate;
    private Boolean userAccess;

    public GlossaryObjectMetadata artifactType(String artifactType) {
        this.artifactType = artifactType;
        return this;
    }

    /**
     * Artifact type
     * @return artifactType
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactType() { return artifactType; }
    public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

    public GlossaryObjectMetadata artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * Artifact ID
     * @return artifactId
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public GlossaryObjectMetadata versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * Version ID
     * @return versionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("version_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    public GlossaryObjectMetadata sourceRepositoryId(String sourceRepositoryId) {
        this.sourceRepositoryId = sourceRepositoryId;
        return this;
    }

    /**
     * Source Repository ID that is applicable to artifacts shared through OMRS.
     * ID of the external metadata source of the artifact.
     * @return sourceRepositoryId
     **/
    @javax.annotation.Nullable
    @JsonProperty("source_repository_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSourceRepositoryId() { return sourceRepositoryId; }
    public void setSourceRepositoryId(String sourceRepositoryId) { this.sourceRepositoryId = sourceRepositoryId; }

    public GlossaryObjectMetadata externalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    /**
     * External ID that is applicable to artifacts shared through OMRS. ID of the
     *artifact in the external metadata source.
     * @return externalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("external_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public GlossaryObjectMetadata globalId(String globalId) {
        this.globalId = globalId;
        return this;
    }

    /**
     * Global ID that uniquely identifies a specific artifact in any repository in
     * the OMRS cohort. Formatted as
     * &#39;&lt;source_repository_id&gt;_&lt;artifact_id_in_source_repository&gt;&#39;.
     * @return globalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGlobalId() { return globalId; }
    public void setGlobalId(String globalId) { this.globalId = globalId; }

    public GlossaryObjectMetadata workflowId(String workflowId) {
        this.workflowId = workflowId;
        return this;
    }

    /**
     * Workflow ID
     * @return workflowId
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowId() { return workflowId; }
    public void setWorkflowId(String workflowId) { this.workflowId = workflowId; }

    public GlossaryObjectMetadata draftMode(GlossaryObjectDraftMode draftMode) {
        this.draftMode = draftMode;
        return this;
    }

    /**
     * Draft mode
     * @return draftMode
     **/
    @javax.annotation.Nullable
    @JsonProperty("draft_mode")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GlossaryObjectDraftMode getDraftMode() { return draftMode; }
    public void setDraftMode(GlossaryObjectDraftMode draftMode) { this.draftMode = draftMode; }

    public GlossaryObjectMetadata publishedAncestorId(String publishedAncestorId) {
        this.publishedAncestorId = publishedAncestorId;
        return this;
    }

    /**
     * Published Ancestor ID
     * @return publishedAncestorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("published_ancestor_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPublishedAncestorId() { return publishedAncestorId; }
    public void setPublishedAncestorId(String publishedAncestorId) { this.publishedAncestorId = publishedAncestorId; }

    public GlossaryObjectMetadata draftAncestorId(String draftAncestorId) {
        this.draftAncestorId = draftAncestorId;
        return this;
    }

    /**
     * Draft Ancestor ID
     * @return draftAncestorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("draft_ancestor_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDraftAncestorId() { return draftAncestorId; }
    public void setDraftAncestorId(String draftAncestorId) { this.draftAncestorId = draftAncestorId; }

    public GlossaryObjectMetadata effectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
        return this;
    }

    /**
     * Effective Start Date
     * @return effectiveStartDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_start_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveStartDate() { return effectiveStartDate; }
    public void setEffectiveStartDate(Date effectiveStartDate) { this.effectiveStartDate = effectiveStartDate; }

    public GlossaryObjectMetadata effectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
        return this;
    }

    /**
     * Effective End Date
     * @return effectiveEndDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_end_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveEndDate() { return effectiveEndDate; }
    public void setEffectiveEndDate(Date effectiveEndDate) { this.effectiveEndDate = effectiveEndDate; }

    public GlossaryObjectMetadata createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * User ID of the user who created the artifact (system managed)
     * @return createdBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public GlossaryObjectMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * RFC 3339 timestamp on when the artifact was created (system managed)
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public GlossaryObjectMetadata modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    /**
     * User ID of the user who last modified the artifact (system managed)
     * @return modifiedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public GlossaryObjectMetadata modifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    /**
     * RFC 3339 timestamp on when the artifact was last modified (system managed)
     * @return modifiedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Date modifiedAt) { this.modifiedAt = modifiedAt; }

    public GlossaryObjectMetadata revision(String revision) {
        this.revision = revision;
        return this;
    }

    /**
     * The revision of the artifact. It is used for optimistic locking.
     * @return revision
     **/
    @javax.annotation.Nullable
    @JsonProperty("revision")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRevision() { return revision; }
    public void setRevision(String revision) { this.revision = revision; }

    public GlossaryObjectMetadata name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the artifact
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public GlossaryObjectMetadata shortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    /**
     * Short description of the artifact
     * @return shortDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("short_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public GlossaryObjectMetadata state(GlossaryObjectState state) {
        this.state = state;
        return this;
    }

    /**
     * State of the artifact
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GlossaryObjectState getState() { return state; }
    public void setState(GlossaryObjectState state) { this.state = state; }

    public GlossaryObjectMetadata tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public GlossaryObjectMetadata addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Tags
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public GlossaryObjectMetadata stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public GlossaryObjectMetadata addStewardIdsItem(String stewardIdsItem) {
        if (this.stewardIds == null) {
            this.stewardIds = new ArrayList<>();
        }
        this.stewardIds.add(stewardIdsItem);
        return this;
    }

    /**
     * Steward IDs
     * @return stewardIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("steward_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getStewardIds() { return stewardIds; }
    public void setStewardIds(List<String> stewardIds) { this.stewardIds = stewardIds; }

    public GlossaryObjectMetadata workflowState(String workflowState) {
        this.workflowState = workflowState;
        return this;
    }

    /**
     * State of the workflow
     * @return workflowState
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowState() { return workflowState; }
    public void setWorkflowState(String workflowState) { this.workflowState = workflowState; }

    public GlossaryObjectMetadata readOnly(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    /**
     * Get readOnly
     * @return readOnly
     **/
    @javax.annotation.Nullable
    @JsonProperty("read_only")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getReadOnly() { return readOnly; }
    public void setReadOnly(Boolean readOnly) { this.readOnly = readOnly; }

    public GlossaryObjectMetadata removeStartDate(Boolean removeStartDate) {
        this.removeStartDate = removeStartDate;
        return this;
    }

    /**
     * Get removeStartDate
     * @return removeStartDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("remove_start_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRemoveStartDate() { return removeStartDate; }
    public void setRemoveStartDate(Boolean removeStartDate) { this.removeStartDate = removeStartDate; }

    public GlossaryObjectMetadata removeEndDate(Boolean removeEndDate) {
        this.removeEndDate = removeEndDate;
        return this;
    }

    /**
     * Get removeStartDate
     * @return removeStartDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("remove_end_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRemoveEndDate() { return removeEndDate; }
    public void setRemoveEndDate(Boolean removeEndDate) { this.removeEndDate = removeEndDate; }

    public GlossaryObjectMetadata userAccess(Boolean userAccess) {
        this.userAccess = userAccess;
        return this;
    }

    /**
     * Get userAccess
     * @return userAccess
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_access")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getUserAccess() { return userAccess; }
    public void setUserAccess(Boolean userAccess) { this.userAccess = userAccess; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GlossaryObjectMetadata glossaryObjectMetadata = (GlossaryObjectMetadata)o;
        return Objects.equals(this.artifactType, glossaryObjectMetadata.artifactType) &&
                Objects.equals(this.artifactId, glossaryObjectMetadata.artifactId) &&
                Objects.equals(this.versionId, glossaryObjectMetadata.versionId) &&
                Objects.equals(this.sourceRepositoryId, glossaryObjectMetadata.sourceRepositoryId) &&
                Objects.equals(this.externalId, glossaryObjectMetadata.externalId) &&
                Objects.equals(this.globalId, glossaryObjectMetadata.globalId) &&
                Objects.equals(this.workflowId, glossaryObjectMetadata.workflowId) &&
                Objects.equals(this.draftMode, glossaryObjectMetadata.draftMode) &&
                Objects.equals(this.publishedAncestorId, glossaryObjectMetadata.publishedAncestorId) &&
                Objects.equals(this.draftAncestorId, glossaryObjectMetadata.draftAncestorId) &&
                Objects.equals(this.effectiveStartDate, glossaryObjectMetadata.effectiveStartDate) &&
                Objects.equals(this.effectiveEndDate, glossaryObjectMetadata.effectiveEndDate) &&
                Objects.equals(this.createdBy, glossaryObjectMetadata.createdBy) &&
                Objects.equals(this.createdAt, glossaryObjectMetadata.createdAt) &&
                Objects.equals(this.modifiedBy, glossaryObjectMetadata.modifiedBy) &&
                Objects.equals(this.modifiedAt, glossaryObjectMetadata.modifiedAt) &&
                Objects.equals(this.revision, glossaryObjectMetadata.revision) &&
                Objects.equals(this.name, glossaryObjectMetadata.name) &&
                Objects.equals(this.shortDescription, glossaryObjectMetadata.shortDescription) &&
                Objects.equals(this.state, glossaryObjectMetadata.state) &&
                Objects.equals(this.tags, glossaryObjectMetadata.tags) &&
                Objects.equals(this.stewardIds, glossaryObjectMetadata.stewardIds) &&
                Objects.equals(this.workflowState, glossaryObjectMetadata.workflowState) &&
                Objects.equals(this.readOnly, glossaryObjectMetadata.readOnly) &&
                Objects.equals(this.removeStartDate, glossaryObjectMetadata.removeStartDate) &&
                Objects.equals(this.removeEndDate, glossaryObjectMetadata.removeEndDate) &&
                Objects.equals(this.userAccess, glossaryObjectMetadata.userAccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                artifactType, artifactId, versionId, sourceRepositoryId, externalId,
                globalId, workflowId, draftMode, publishedAncestorId, draftAncestorId,
                effectiveStartDate, effectiveEndDate, createdBy, createdAt, modifiedBy,
                modifiedAt, revision, name, shortDescription, state, tags, stewardIds,
                workflowState, readOnly, removeStartDate, removeEndDate, userAccess);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GlossaryObjectMetadata {\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
        sb.append("    sourceRepositoryId: ").append(toIndentedString(sourceRepositoryId)).append("\n");
        sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
        sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
        sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
        sb.append("    draftMode: ").append(toIndentedString(draftMode)).append("\n");
        sb.append("    publishedAncestorId: ").append(toIndentedString(publishedAncestorId)).append("\n");
        sb.append("    draftAncestorId: ").append(toIndentedString(draftAncestorId)).append("\n");
        sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
        sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    shortDescription: ").append(toIndentedString(shortDescription)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    workflowState: ").append(toIndentedString(workflowState)).append("\n");
        sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
        sb.append("    removeStartDate: ").append(toIndentedString(removeStartDate)).append("\n");
        sb.append("    removeEndDate: ").append(toIndentedString(removeEndDate)).append("\n");
        sb.append("    userAccess: ").append(toIndentedString(userAccess)).append("\n");
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
