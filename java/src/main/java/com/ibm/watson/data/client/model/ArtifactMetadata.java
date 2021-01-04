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
import com.ibm.watson.data.client.model.enums.ArtifactState;

import java.util.Date;
import java.util.Objects;

/**
 * ArtifactMetadata
 */
public class ArtifactMetadata {

    private String artifactId;
    private String artifactType;
    private Date effectiveEndDate;
    private Date effectiveStartDate;
    private String name;
    private Category parentCategory;
    private String publishedAncestorId;
    private ArtifactState state;
    private String versionId;

    public ArtifactMetadata artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * UI can find workflows for given guid (&#x3D;assetId, asset_id)
     * @return artifactId
     **/
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public ArtifactMetadata artifactType(String artifactType) {
        this.artifactType = artifactType;
        return this;
    }

    /**
     * Get artifactType
     * @return artifactType
     **/
    @JsonProperty("artifact_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getArtifactType() { return artifactType; }
    public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

    public ArtifactMetadata effectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
        return this;
    }

    /**
     * timestamp
     * @return effectiveEndDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_end_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveEndDate() { return effectiveEndDate; }
    public void setEffectiveEndDate(Date effectiveEndDate) { this.effectiveEndDate = effectiveEndDate; }

    public ArtifactMetadata effectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
        return this;
    }

    /**
     * timestamp
     * @return effectiveStartDate
     **/
    @JsonProperty("effective_start_date")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getEffectiveStartDate() { return effectiveStartDate; }
    public void setEffectiveStartDate(Date effectiveStartDate) { this.effectiveStartDate = effectiveStartDate; }

    public ArtifactMetadata name(String name) {
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

    public ArtifactMetadata parentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    /**
     * Get parentCategory
     * @return parentCategory
     **/
    @JsonProperty("parent_category")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Category getParentCategory() { return parentCategory; }
    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }

    public ArtifactMetadata publishedAncestorId(String publishedAncestorId) {
        this.publishedAncestorId = publishedAncestorId;
        return this;
    }

    /**
     * optional, technical_id of published asset that was used to create draft,
     * can be null on draft_mode&#x3D;Created
     * @return publishedAncestorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("published_ancestor_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPublishedAncestorId() { return publishedAncestorId; }
    public void setPublishedAncestorId(String publishedAncestorId) { this.publishedAncestorId = publishedAncestorId; }

    public ArtifactMetadata state(ArtifactState state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ArtifactState getState() { return state; }
    public void setState(ArtifactState state) { this.state = state; }

    public ArtifactMetadata versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * identifies the draft, used for discarding the draft or potentially for
     * creating a cloned draft when validity period gets updated, optionally used
     * to detect update conflicts (&#x3D;technical_id)
     * @return versionId
     **/
    @JsonProperty("version_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ArtifactMetadata artifactMetadata = (ArtifactMetadata)o;
        return Objects.equals(this.artifactId, artifactMetadata.artifactId) &&
                Objects.equals(this.artifactType, artifactMetadata.artifactType) &&
                Objects.equals(this.effectiveEndDate, artifactMetadata.effectiveEndDate) &&
                Objects.equals(this.effectiveStartDate, artifactMetadata.effectiveStartDate) &&
                Objects.equals(this.name, artifactMetadata.name) &&
                Objects.equals(this.parentCategory, artifactMetadata.parentCategory) &&
                Objects.equals(this.publishedAncestorId, artifactMetadata.publishedAncestorId) &&
                Objects.equals(this.state, artifactMetadata.state) &&
                Objects.equals(this.versionId, artifactMetadata.versionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactId, artifactType, effectiveEndDate,
                effectiveStartDate, name, parentCategory,
                publishedAncestorId, state, versionId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArtifactMetadata {\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
        sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
        sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
        sb.append("    publishedAncestorId: ").append(toIndentedString(publishedAncestorId)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
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
