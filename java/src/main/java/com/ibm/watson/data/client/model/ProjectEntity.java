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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The entity payload representing the core project attributes.
 */
@ApiModel(description = "The entity payload representing the core project attributes.")
@JsonPropertyOrder({
        ProjectEntity.JSON_PROPERTY_TAGS,
        ProjectEntity.JSON_PROPERTY_COMPUTE,
        ProjectEntity.JSON_PROPERTY_CREATOR,
        ProjectEntity.JSON_PROPERTY_CREATOR_IAM_ID,
        ProjectEntity.JSON_PROPERTY_DEFINED_CROWD,
        ProjectEntity.JSON_PROPERTY_DESCRIPTION,
        ProjectEntity.JSON_PROPERTY_FIGURE_EIGHT,
        ProjectEntity.JSON_PROPERTY_GITHUB,
        ProjectEntity.JSON_PROPERTY_MEMBERS,
        ProjectEntity.JSON_PROPERTY_NAME,
        ProjectEntity.JSON_PROPERTY_PUBLIC,
        ProjectEntity.JSON_PROPERTY_SETTINGS,
        ProjectEntity.JSON_PROPERTY_STORAGE,
        ProjectEntity.JSON_PROPERTY_TOOLS
})
public class ProjectEntity {

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_COMPUTE = "compute";
    private List<ProjectCompute> compute;

    public static final String JSON_PROPERTY_CREATOR = "creator";
    private String creator;

    public static final String JSON_PROPERTY_CREATOR_IAM_ID = "creator_iam_id";
    private String creatorIamId;

    public static final String JSON_PROPERTY_DEFINED_CROWD = "defined_crowd";
    private ProjectDefinedCrowd definedCrowd;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_FIGURE_EIGHT = "figure_eight";
    private ProjectFigureEight figureEight;

    public static final String JSON_PROPERTY_GITHUB = "github";
    private ProjectGithub github;

    public static final String JSON_PROPERTY_MEMBERS = "members";
    private List<ProjectMember> members = null;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    private Boolean _public = false;

    public static final String JSON_PROPERTY_SETTINGS = "settings";
    private ProjectSettings settings;

    public static final String JSON_PROPERTY_STORAGE = "storage";
    private ProjectStorage storage;

    /**
     * Names of tools configured for this project
     */
    public enum ToolsEnum {

        JUPYTER_NOTEBOOKS("jupyter_notebooks"),

        WATSON_VISUAL_RECOGNITION("watson_visual_recognition"),

        DASHBOARDS("dashboards"),

        STREAMS_DESIGNER("streams_designer"),

        SPSS_MODELER("spss_modeler"),

        EXPERIMENTS("experiments"),

        DATA_REFINERY("data_refinery");

        private String value;

        ToolsEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ToolsEnum fromValue(String value) {
            for (ToolsEnum b : ToolsEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TOOLS = "tools";
    private List<ToolsEnum> tools = null;

    public ProjectEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ProjectEntity addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * The user-defined tags associated with a project.
     * @return tags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The user-defined tags associated with a project.")
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) { this.tags = tags; }

    public ProjectEntity compute(List<ProjectCompute> compute) {
        this.compute = compute;
        return this;
    }

    /**
     * Get compute
     * @return compute
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_COMPUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ProjectCompute> getCompute() {
        return compute;
    }

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
    @ApiModelProperty(
            example = "zapp.brannigan@ibm.com",
            value = "The username of the user that created the project.")
    @JsonProperty(JSON_PROPERTY_CREATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreator() {
        return creator;
    }

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
    @ApiModelProperty(example = "IBMid-55000353XF",
            value = "The IAM ID of the user that created the project.")
    @JsonProperty(JSON_PROPERTY_CREATOR_IAM_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatorIamId() {
        return creatorIamId;
    }

    public void setCreatorIamId(String creatorIamId) {
        this.creatorIamId = creatorIamId;
    }

    public ProjectEntity definedCrowd(ProjectDefinedCrowd definedCrowd) {
        this.definedCrowd = definedCrowd;
        return this;
    }

    /**
     * Get definedCrowd
     * @return definedCrowd
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DEFINED_CROWD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProjectDefinedCrowd getDefinedCrowd() {
        return definedCrowd;
    }

    public void setDefinedCrowd(ProjectDefinedCrowd definedCrowd) {
        this.definedCrowd = definedCrowd;
    }

    public ProjectEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description for the new project.
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "A project description.",
            value = "A description for the new project.")
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectEntity figureEight(ProjectFigureEight figureEight) {
        this.figureEight = figureEight;
        return this;
    }

    /**
     * Get figureEight
     * @return figureEight
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_FIGURE_EIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProjectFigureEight getFigureEight() {
        return figureEight;
    }

    public void setFigureEight(ProjectFigureEight figureEight) {
        this.figureEight = figureEight;
    }

    public ProjectEntity github(ProjectGithub github) {
        this.github = github;
        return this;
    }

    /**
     * Get github
     * @return github
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_GITHUB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProjectGithub getGithub() {
        return github;
    }

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
    @ApiModelProperty(value = "The members associated with the project.")
    @JsonProperty(JSON_PROPERTY_MEMBERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ProjectMember> getMembers() {
        return members;
    }

    public void setMembers(List<ProjectMember> members) {
        this.members = members;
    }

    public ProjectEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the project.
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Project Name",
            value = "The name of the project.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public ProjectEntity _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * A value of &#39;true&#39; makes the project public.
     * @return _public
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "A value of 'true' makes the project public.")
    @JsonProperty(JSON_PROPERTY_PUBLIC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) { this._public = _public; }

    public ProjectEntity settings(ProjectSettings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get settings
     * @return settings
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SETTINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProjectSettings getSettings() {
        return settings;
    }

    public void setSettings(ProjectSettings settings) {
        this.settings = settings;
    }

    public ProjectEntity storage(ProjectStorage storage) {
        this.storage = storage;
        return this;
    }

    /**
     * Get storage
     * @return storage
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_STORAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProjectStorage getStorage() {
        return storage;
    }

    public void setStorage(ProjectStorage storage) { this.storage = storage; }

    public ProjectEntity tools(List<ToolsEnum> tools) {
        this.tools = tools;
        return this;
    }

    public ProjectEntity addToolsItem(ToolsEnum toolsItem) {
        if (this.tools == null) {
            this.tools = new ArrayList<>();
        }
        this.tools.add(toolsItem);
        return this;
    }

    /**
     * The tools associated with the project.
     * @return tools
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The tools associated with the project.")
    @JsonProperty(JSON_PROPERTY_TOOLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ToolsEnum> getTools() {
        return tools;
    }

    public void setTools(List<ToolsEnum> tools) { this.tools = tools; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectEntity projectEntity = (ProjectEntity)o;
        return Objects.equals(this.tags, projectEntity.tags) &&
                Objects.equals(this.compute, projectEntity.compute) &&
                Objects.equals(this.creator, projectEntity.creator) &&
                Objects.equals(this.creatorIamId, projectEntity.creatorIamId) &&
                Objects.equals(this.definedCrowd, projectEntity.definedCrowd) &&
                Objects.equals(this.description, projectEntity.description) &&
                Objects.equals(this.figureEight, projectEntity.figureEight) &&
                Objects.equals(this.github, projectEntity.github) &&
                Objects.equals(this.members, projectEntity.members) &&
                Objects.equals(this.name, projectEntity.name) &&
                Objects.equals(this._public, projectEntity._public) &&
                Objects.equals(this.settings, projectEntity.settings) &&
                Objects.equals(this.storage, projectEntity.storage) &&
                Objects.equals(this.tools, projectEntity.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, compute, creator, creatorIamId, definedCrowd,
                description, figureEight, github, members, name,
                _public, settings, storage, tools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectEntity {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
        sb.append("    creatorIamId: ")
                .append(toIndentedString(creatorIamId))
                .append("\n");
        sb.append("    definedCrowd: ")
                .append(toIndentedString(definedCrowd))
                .append("\n");
        sb.append("    description: ")
                .append(toIndentedString(description))
                .append("\n");
        sb.append("    figureEight: ")
                .append(toIndentedString(figureEight))
                .append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
        sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
        sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
        sb.append("    tools: ").append(toIndentedString(tools)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
