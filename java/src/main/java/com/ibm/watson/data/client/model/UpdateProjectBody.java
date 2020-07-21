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
 * The request body for updating an existing project.
 */
@ApiModel(description = "The request body for updating an existing project.")
@JsonPropertyOrder({
        UpdateProjectBody.JSON_PROPERTY_TAGS,
        UpdateProjectBody.JSON_PROPERTY_CATALOG,
        UpdateProjectBody.JSON_PROPERTY_COMPUTE,
        UpdateProjectBody.JSON_PROPERTY_DEFINED_CROWD,
        UpdateProjectBody.JSON_PROPERTY_DESCRIPTION,
        UpdateProjectBody.JSON_PROPERTY_FIGURE_EIGHT,
        UpdateProjectBody.JSON_PROPERTY_GITHUB,
        UpdateProjectBody.JSON_PROPERTY_NAME,
        UpdateProjectBody.JSON_PROPERTY_PUBLIC,
        UpdateProjectBody.JSON_PROPERTY_TOOLS
})
public class UpdateProjectBody {

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_CATALOG = "catalog";
    private ProjectCatalog catalog;

    public static final String JSON_PROPERTY_COMPUTE = "compute";
    private List<ProjectCompute> compute = null;

    public static final String JSON_PROPERTY_DEFINED_CROWD = "defined_crowd";
    private ProjectDefinedCrowd definedCrowd;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_FIGURE_EIGHT = "figure_eight";
    private ProjectFigureEight figureEight;

    public static final String JSON_PROPERTY_GITHUB = "github";
    private ProjectGithub github;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    private Boolean _public = false;

    /**
     * The tools configured and associated with the project.
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

    public UpdateProjectBody tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public UpdateProjectBody addTagsItem(String tagsItem) {
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

    public UpdateProjectBody catalog(ProjectCatalog catalog) {
        this.catalog = catalog;
        return this;
    }

    /**
     * Get catalog
     * @return catalog
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CATALOG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProjectCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ProjectCatalog catalog) { this.catalog = catalog; }

    public UpdateProjectBody compute(List<ProjectCompute> compute) {
        this.compute = compute;
        return this;
    }

    public UpdateProjectBody addComputeItem(ProjectCompute computeItem) {
        if (this.compute == null) {
            this.compute = new ArrayList<>();
        }
        this.compute.add(computeItem);
        return this;
    }

    /**
     * A list of computes associated with the project.
     * @return compute
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "A list of computes associated with the project.")
    @JsonProperty(JSON_PROPERTY_COMPUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ProjectCompute> getCompute() {
        return compute;
    }

    public void setCompute(List<ProjectCompute> compute) {
        this.compute = compute;
    }

    public UpdateProjectBody definedCrowd(ProjectDefinedCrowd definedCrowd) {
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

    public UpdateProjectBody description(String description) {
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

    public UpdateProjectBody figureEight(ProjectFigureEight figureEight) {
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

    public UpdateProjectBody github(ProjectGithub github) {
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

    public UpdateProjectBody name(String name) {
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

    public UpdateProjectBody _public(Boolean _public) {
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

    public UpdateProjectBody tools(List<ToolsEnum> tools) {
        this.tools = tools;
        return this;
    }

    public UpdateProjectBody addToolsItem(ToolsEnum toolsItem) {
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
        UpdateProjectBody updateProjectBody = (UpdateProjectBody)o;
        return Objects.equals(this.tags, updateProjectBody.tags) &&
                Objects.equals(this.catalog, updateProjectBody.catalog) &&
                Objects.equals(this.compute, updateProjectBody.compute) &&
                Objects.equals(this.definedCrowd, updateProjectBody.definedCrowd) &&
                Objects.equals(this.description, updateProjectBody.description) &&
                Objects.equals(this.figureEight, updateProjectBody.figureEight) &&
                Objects.equals(this.github, updateProjectBody.github) &&
                Objects.equals(this.name, updateProjectBody.name) &&
                Objects.equals(this._public, updateProjectBody._public) &&
                Objects.equals(this.tools, updateProjectBody.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, catalog, compute, definedCrowd, description,
                figureEight, github, name, _public, tools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateProjectBody {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
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
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
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
