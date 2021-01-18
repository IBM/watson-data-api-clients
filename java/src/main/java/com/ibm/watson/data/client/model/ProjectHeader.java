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
import com.ibm.watson.data.client.model.enums.ProjectToolType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Common metadata related to projects.
 */
public class ProjectHeader {

    private List<String> tags = null;
    private String description;
    private String name;
    private Boolean _public = false;
    private List<ProjectToolType> tools = null;

    public ProjectHeader tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ProjectHeader addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * List of user defined tags that are attached to the project.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public ProjectHeader description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the project.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ProjectHeader name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the project. The name must be a non-empty String for creation, but does
     * not need to be unique.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ProjectHeader _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * A value of "true" makes the project public.
     * @return _public
     **/
    @javax.annotation.Nullable
    @JsonProperty("public")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getPublic() { return _public; }
    public void setPublic(Boolean _public) { this._public = _public; }

    public ProjectHeader tools(List<ProjectToolType> tools) {
        this.tools = tools;
        return this;
    }

    public ProjectHeader addToolsItem(ProjectToolType toolsItem) {
        if (this.tools == null) {
            this.tools = new ArrayList<>();
        }
        this.tools.add(toolsItem);
        return this;
    }

    /**
     * List of tools associated with the project.
     * @return tools
     **/
    @javax.annotation.Nullable
    @JsonProperty("tools")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ProjectToolType> getTools() { return tools; }
    public void setTools(List<ProjectToolType> tools) { this.tools = tools; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectHeader that = (ProjectHeader) o;
        return Objects.equals(tags, that.tags) &&
                Objects.equals(description, that.description) &&
                Objects.equals(name, that.name) &&
                Objects.equals(_public, that._public)
                && Objects.equals(tools, that.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, description, name, _public, tools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectHeader {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
        sb.append("    tools: ").append(toIndentedString(tools)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
