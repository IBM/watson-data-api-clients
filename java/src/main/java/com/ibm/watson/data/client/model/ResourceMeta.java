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

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * ResourceMeta
 */
public class ResourceMeta {

    private String id;
    private String rev;
    private String owner;
    private Date createdAt;
    private Date modifiedAt;
    private String parentId;
    private String name;
    private String description;
    private List<String> tags = null;
    private ResourceMetaBaseCommitInfo commitInfo;
    private String spaceId;
    private String projectId;

    public ResourceMeta id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id of the resource.
     * @return id
     **/
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }


    public ResourceMeta rev(String rev) {
        this.rev = rev;
        return this;
    }

    /**
     * The revision of the resource.
     * @return rev
     **/
    @javax.annotation.Nullable
    @JsonProperty("rev")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRev() { return rev; }
    public void setRev(String rev) { this.rev = rev; }

    public ResourceMeta owner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * The user id which created this resource.
     * @return owner
     **/
    @javax.annotation.Nullable
    @JsonProperty("owner")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public ResourceMeta createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The time when the resource was created.
     * @return createdAt
     **/
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public ResourceMeta modifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    /**
     * The time when the resource was last modified.
     * @return modifiedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Date modifiedAt) { this.modifiedAt = modifiedAt; }

    public ResourceMeta parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * The id of the parent resource where applicable.
     * @return parentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentId() { return parentId; }
    public void setParentId(String parentId) { this.parentId = parentId; }

    public ResourceMeta name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the resource.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ResourceMeta description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the resource.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ResourceMeta tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ResourceMeta addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A list of tags for this resource.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public ResourceMeta commitInfo(ResourceMetaBaseCommitInfo commitInfo) {
        this.commitInfo = commitInfo;
        return this;
    }

    /**
     * Get commitInfo
     * @return commitInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("commit_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ResourceMetaBaseCommitInfo getCommitInfo() { return commitInfo; }
    public void setCommitInfo(ResourceMetaBaseCommitInfo commitInfo) { this.commitInfo = commitInfo; }

    public ResourceMeta spaceId(String spaceId) {
        this.spaceId = spaceId;
        return this;
    }

    /**
     * The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be given.
     * @return spaceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("space_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSpaceId() { return spaceId; }
    public void setSpaceId(String spaceId) { this.spaceId = spaceId; }

    public ResourceMeta projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be given.
     * @return projectId
     **/
    @javax.annotation.Nullable
    @JsonProperty("project_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResourceMeta resourceMeta = (ResourceMeta) o;
        return Objects.equals(this.id, resourceMeta.id) &&
                Objects.equals(this.rev, resourceMeta.rev) &&
                Objects.equals(this.owner, resourceMeta.owner) &&
                Objects.equals(this.createdAt, resourceMeta.createdAt) &&
                Objects.equals(this.modifiedAt, resourceMeta.modifiedAt) &&
                Objects.equals(this.parentId, resourceMeta.parentId) &&
                Objects.equals(this.name, resourceMeta.name) &&
                Objects.equals(this.description, resourceMeta.description) &&
                Objects.equals(this.tags, resourceMeta.tags) &&
                Objects.equals(this.commitInfo, resourceMeta.commitInfo) &&
                Objects.equals(this.spaceId, resourceMeta.spaceId) &&
                Objects.equals(this.projectId, resourceMeta.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rev, owner, createdAt, modifiedAt, parentId, name, description, tags, commitInfo, spaceId, projectId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResourceMeta {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    rev: ").append(toIndentedString(rev)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    commitInfo: ").append(toIndentedString(commitInfo)).append("\n");
        sb.append("    spaceId: ").append(toIndentedString(spaceId)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
