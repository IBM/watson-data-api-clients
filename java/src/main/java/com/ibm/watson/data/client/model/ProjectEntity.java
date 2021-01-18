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
import java.util.List;
import java.util.Objects;

/**
 * The entity payload representing the core project attributes.
 */
public class ProjectEntity extends ProjectHeader {

    private List<ProjectCompute> compute;
    private String creator;
    private String creatorIamId;
    private ProjectDefinedCrowd definedCrowd;
    private ProjectFigureEight figureEight;
    private ProjectGithub github;
    private List<ProjectMember> members = null;
    private ProjectSettings settings;
    private ProjectStorage storage;

    public ProjectEntity compute(List<ProjectCompute> compute) {
        this.compute = compute;
        return this;
    }

    /**
     * Get compute
     * @return compute
     **/
    @javax.annotation.Nullable
    @JsonProperty("compute")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ProjectCompute> getCompute() { return compute; }
    public void setCompute(List<ProjectCompute> compute) { this.compute = compute; }

    public ProjectEntity creator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * The username of the user that created the project.
     * @return creator
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreator() { return creator; }
    public void setCreator(String creator) { this.creator = creator; }

    public ProjectEntity creatorIamId(String creatorIamId) {
        this.creatorIamId = creatorIamId;
        return this;
    }

    /**
     * The IAM ID of the user that created the project.
     * @return creatorIamId
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator_iam_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorIamId() { return creatorIamId; }
    public void setCreatorIamId(String creatorIamId) { this.creatorIamId = creatorIamId; }

    public ProjectEntity definedCrowd(ProjectDefinedCrowd definedCrowd) {
        this.definedCrowd = definedCrowd;
        return this;
    }

    /**
     * Get definedCrowd
     * @return definedCrowd
     **/
    @javax.annotation.Nullable
    @JsonProperty("defined_crowd")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectDefinedCrowd getDefinedCrowd() { return definedCrowd; }
    public void setDefinedCrowd(ProjectDefinedCrowd definedCrowd) { this.definedCrowd = definedCrowd; }

    public ProjectEntity figureEight(ProjectFigureEight figureEight) {
        this.figureEight = figureEight;
        return this;
    }

    /**
     * Get figureEight
     * @return figureEight
     **/
    @javax.annotation.Nullable
    @JsonProperty("figure_eight")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectFigureEight getFigureEight() { return figureEight; }
    public void setFigureEight(ProjectFigureEight figureEight) { this.figureEight = figureEight; }

    public ProjectEntity github(ProjectGithub github) {
        this.github = github;
        return this;
    }

    /**
     * Get github
     * @return github
     **/
    @javax.annotation.Nullable
    @JsonProperty("github")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectGithub getGithub() { return github; }
    public void setGithub(ProjectGithub github) { this.github = github; }

    public ProjectEntity members(List<ProjectMember> members) {
        this.members = members;
        return this;
    }

    public ProjectEntity addMembersItem(ProjectMember membersItem) {
        if (this.members == null) {
            this.members = new ArrayList<>();
        }
        this.members.add(membersItem);
        return this;
    }

    /**
     * The members associated with the project.
     * @return members
     **/
    @javax.annotation.Nullable
    @JsonProperty("members")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ProjectMember> getMembers() { return members; }
    public void setMembers(List<ProjectMember> members) { this.members = members; }

    public ProjectEntity settings(ProjectSettings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get settings
     * @return settings
     **/
    @javax.annotation.Nullable
    @JsonProperty("settings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectSettings getSettings() { return settings; }
    public void setSettings(ProjectSettings settings) { this.settings = settings; }

    public ProjectEntity storage(ProjectStorage storage) {
        this.storage = storage;
        return this;
    }

    /**
     * Get storage
     * @return storage
     **/
    @javax.annotation.Nullable
    @JsonProperty("storage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectStorage getStorage() { return storage; }
    public void setStorage(ProjectStorage storage) { this.storage = storage; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectEntity projectEntity = (ProjectEntity)o;
        return super.equals(o) &&
                Objects.equals(this.compute, projectEntity.compute) &&
                Objects.equals(this.creator, projectEntity.creator) &&
                Objects.equals(this.creatorIamId, projectEntity.creatorIamId) &&
                Objects.equals(this.definedCrowd, projectEntity.definedCrowd) &&
                Objects.equals(this.figureEight, projectEntity.figureEight) &&
                Objects.equals(this.github, projectEntity.github) &&
                Objects.equals(this.members, projectEntity.members) &&
                Objects.equals(this.settings, projectEntity.settings) &&
                Objects.equals(this.storage, projectEntity.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), compute, creator, creatorIamId, definedCrowd,
                figureEight, github, members, settings, storage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectEntity {\n");
        super.toString(sb);
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
        sb.append("    creatorIamId: ").append(toIndentedString(creatorIamId)).append("\n");
        sb.append("    definedCrowd: ").append(toIndentedString(definedCrowd)).append("\n");
        sb.append("    figureEight: ").append(toIndentedString(figureEight)).append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
        sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
