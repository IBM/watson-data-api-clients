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
 * Project metadata required to create a project.
 */
@ApiModel(description = "Project metadata required to create a project.")
@JsonPropertyOrder({
        TransactionalProjectCreate.JSON_PROPERTY_TAGS,
        TransactionalProjectCreate.JSON_PROPERTY_COMPUTE,
        TransactionalProjectCreate.JSON_PROPERTY_DESCRIPTION,
        TransactionalProjectCreate.JSON_PROPERTY_ENFORCE_MEMBERS,
        TransactionalProjectCreate.JSON_PROPERTY_GENERATOR,
        TransactionalProjectCreate.JSON_PROPERTY_NAME,
        TransactionalProjectCreate.JSON_PROPERTY_PUBLIC,
        TransactionalProjectCreate.JSON_PROPERTY_STORAGE,
        TransactionalProjectCreate.JSON_PROPERTY_TOOLS
})
public class TransactionalProjectCreate {

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_COMPUTE = "compute";
    private List<TransactionalProjectComputeObjectCloud> compute = null;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_ENFORCE_MEMBERS = "enforce_members";
    private Boolean enforceMembers = false;

    public static final String JSON_PROPERTY_GENERATOR = "generator";
    private String generator;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    private Boolean _public = false;

    public static final String JSON_PROPERTY_STORAGE = "storage";
    private TransactionalProjectStorageObject storage;

    /**
     * Names of tools configured with this project.
     */
    public enum ToolsEnum {
        WATSON_VISUAL_RECOGNITION("watson_visual_recognition"),

        JUPYTER_NOTEBOOKS("jupyter_notebooks"),

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

    public TransactionalProjectCreate tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public TransactionalProjectCreate addTagsItem(String tagsItem) {
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
    @ApiModelProperty(
            value = "List of user defined tags that are attached to the project.")
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) { this.tags = tags; }

    public TransactionalProjectCreate compute(List<TransactionalProjectComputeObjectCloud> compute) {
        this.compute = compute;
        return this;
    }

    public TransactionalProjectCreate addComputeItem(TransactionalProjectComputeObjectCloud computeItem) {
        if (this.compute == null) {
            this.compute = new ArrayList<>();
        }
        this.compute.add(computeItem);
        return this;
    }

    /**
     * List of computes to be associated with the project.
     * @return compute
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            value = "List of computes to be associated with the project.")
    @JsonProperty(JSON_PROPERTY_COMPUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<TransactionalProjectComputeObjectCloud> getCompute() {
        return compute;
    }

    public void setCompute(List<TransactionalProjectComputeObjectCloud> compute) {
        this.compute = compute;
    }

    public TransactionalProjectCreate description(String description) {
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

    public TransactionalProjectCreate enforceMembers(Boolean enforceMembers) {
        this.enforceMembers = enforceMembers;
        return this;
    }

    /**
     * Set to true of project members should be scoped to the account and/or SAML
     *of the creator
     * @return enforceMembers
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            value =
                    "Set to true of project members should be scoped to the account and/or SAML of the creator")
    @JsonProperty(JSON_PROPERTY_ENFORCE_MEMBERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEnforceMembers() {
        return enforceMembers;
    }

    public void setEnforceMembers(Boolean enforceMembers) {
        this.enforceMembers = enforceMembers;
    }

    public TransactionalProjectCreate generator(String generator) {
        this.generator = generator;
        return this;
    }

    /**
     * A tag to indicate where this project was generated. This is only intended
     *for use in metrics. It does not need to be unique and all consumers of this
     *API should use a consistent string for their &#39;generator&#39; field. The
     *value is stored in the project metadata for future consumption in metrics.
     * @return generator
     **/
    @ApiModelProperty(
            example = "DAP-Projects", required = true,
            value =
                    "A tag to indicate where this project was generated. This is only intended for use in metrics. It does not need to be unique and all consumers of this API should use a consistent string for their 'generator' field. The value is stored in the project metadata for future consumption in metrics.")
    @JsonProperty(JSON_PROPERTY_GENERATOR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) { this.generator = generator; }

    public TransactionalProjectCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the new project. The name must be a non-empty String. This does
     *not need to be unique.
     * @return name
     **/
    @ApiModelProperty(
            example = "Project Name", required = true,
            value =
                    "The name of the new project. The name must be a non-empty String. This does not need to be unique.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public TransactionalProjectCreate _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * A value of &#x60;true&#x60; makes the project public.
     * @return _public
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "A value of `true` makes the project public.")
    @JsonProperty(JSON_PROPERTY_PUBLIC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) { this._public = _public; }

    public TransactionalProjectCreate storage(TransactionalProjectStorageObject storage) {
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

    public TransactionalProjectStorageObject getStorage() {
        return storage;
    }

    public void setStorage(TransactionalProjectStorageObject storage) {
        this.storage = storage;
    }

    public TransactionalProjectCreate tools(List<ToolsEnum> tools) {
        this.tools = tools;
        return this;
    }

    public TransactionalProjectCreate addToolsItem(ToolsEnum toolsItem) {
        if (this.tools == null) {
            this.tools = new ArrayList<>();
        }
        this.tools.add(toolsItem);
        return this;
    }

    /**
     * List of tools to be associated with the project.
     * @return tools
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "List of tools to be associated with the project.")
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
        TransactionalProjectCreate transactionalProjectCreate =
                (TransactionalProjectCreate)o;
        return Objects.equals(this.tags, transactionalProjectCreate.tags) &&
                Objects.equals(this.compute, transactionalProjectCreate.compute) &&
                Objects.equals(this.description,
                        transactionalProjectCreate.description) &&
                Objects.equals(this.enforceMembers,
                        transactionalProjectCreate.enforceMembers) &&
                Objects.equals(this.generator, transactionalProjectCreate.generator) &&
                Objects.equals(this.name, transactionalProjectCreate.name) &&
                Objects.equals(this._public, transactionalProjectCreate._public) &&
                Objects.equals(this.storage, transactionalProjectCreate.storage) &&
                Objects.equals(this.tools, transactionalProjectCreate.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, compute, description, enforceMembers, generator,
                name, _public, storage, tools);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionalProjectCreate {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    description: ")
                .append(toIndentedString(description))
                .append("\n");
        sb.append("    enforceMembers: ")
                .append(toIndentedString(enforceMembers))
                .append("\n");
        sb.append("    generator: ")
                .append(toIndentedString(generator))
                .append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
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
