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
 * The request body for creating a new project.
 */
@ApiModel(description = "The request body for creating a new project.")
@JsonPropertyOrder({
        CreateProjectBody.JSON_PROPERTY_TAGS,
        CreateProjectBody.JSON_PROPERTY_CATALOG,
        CreateProjectBody.JSON_PROPERTY_COMPUTE,
        CreateProjectBody.JSON_PROPERTY_DESCRIPTION,
        CreateProjectBody.JSON_PROPERTY_GENERATOR,
        CreateProjectBody.JSON_PROPERTY_GITHUB,
        CreateProjectBody.JSON_PROPERTY_NAME,
        CreateProjectBody.JSON_PROPERTY_PUBLIC,
        CreateProjectBody.JSON_PROPERTY_SCOPE,
        CreateProjectBody.JSON_PROPERTY_SETTINGS,
        CreateProjectBody.JSON_PROPERTY_STORAGE,
        CreateProjectBody.JSON_PROPERTY_TOOLS
})
public class CreateProjectBody {

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_CATALOG = "catalog";
    private ProjectCatalog catalog;

    public static final String JSON_PROPERTY_COMPUTE = "compute";
    private List<ProjectCompute> compute = null;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_GENERATOR = "generator";
    private String generator;

    public static final String JSON_PROPERTY_GITHUB = "github";
    private ProjectGithub github;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    private Boolean _public = false;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    private ProjectScope scope;

    public static final String JSON_PROPERTY_SETTINGS = "settings";
    private ProjectSettings settings;

    public static final String JSON_PROPERTY_STORAGE = "storage";
    private ProjectStorage storage;

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

    public CreateProjectBody tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public CreateProjectBody addTagsItem(String tagsItem) {
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

    public CreateProjectBody catalog(ProjectCatalog catalog) {
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

    public CreateProjectBody compute(List<ProjectCompute> compute) {
        this.compute = compute;
        return this;
    }

    public CreateProjectBody addComputeItem(ProjectCompute computeItem) {
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

    public CreateProjectBody description(String description) {
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

    public CreateProjectBody generator(String generator) {
        this.generator = generator;
        return this;
    }

    /**
     * A consistent label used to identify a client that created a project. A
     *generator must be comprised of the following characters - alphanumeric,
     *dash, underscore, space.
     * @return generator
     **/
    @ApiModelProperty(
            example = "Projects-API_Swagger-Docs", required = true,
            value =
                    "A consistent label used to identify a client that created a project. A generator must be comprised of the following characters - alphanumeric, dash, underscore, space.")
    @JsonProperty(JSON_PROPERTY_GENERATOR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) { this.generator = generator; }

    public CreateProjectBody github(ProjectGithub github) {
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

    public CreateProjectBody name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the project.
     * @return name
     **/
    @ApiModelProperty(example = "Project Name", required = true,
            value = "The name of the project.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public CreateProjectBody _public(Boolean _public) {
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

    public CreateProjectBody scope(ProjectScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     * @return scope
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_SCOPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ProjectScope getScope() {
        return scope;
    }

    public void setScope(ProjectScope scope) { this.scope = scope; }

    public CreateProjectBody settings(ProjectSettings settings) {
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

    public CreateProjectBody storage(ProjectStorage storage) {
        this.storage = storage;
        return this;
    }

    /**
     * Get storage
     * @return storage
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_STORAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ProjectStorage getStorage() {
        return storage;
    }

    public void setStorage(ProjectStorage storage) { this.storage = storage; }

    public CreateProjectBody tools(List<ToolsEnum> tools) {
        this.tools = tools;
        return this;
    }

    public CreateProjectBody addToolsItem(ToolsEnum toolsItem) {
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
        CreateProjectBody createProjectBody = (CreateProjectBody)o;
        return Objects.equals(this.tags, createProjectBody.tags) &&
                Objects.equals(this.catalog, createProjectBody.catalog) &&
                Objects.equals(this.compute, createProjectBody.compute) &&
                Objects.equals(this.description, createProjectBody.description) &&
                Objects.equals(this.generator, createProjectBody.generator) &&
                Objects.equals(this.github, createProjectBody.github) &&
                Objects.equals(this.name, createProjectBody.name) &&
                Objects.equals(this._public, createProjectBody._public) &&
                Objects.equals(this.scope, createProjectBody.scope) &&
                Objects.equals(this.settings, createProjectBody.settings) &&
                Objects.equals(this.storage, createProjectBody.storage) &&
                Objects.equals(this.tools, createProjectBody.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, catalog, compute, description, generator, github,
                name, _public, scope, settings, storage, tools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateProjectBody {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    description: ")
                .append(toIndentedString(description))
                .append("\n");
        sb.append("    generator: ")
                .append(toIndentedString(generator))
                .append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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
