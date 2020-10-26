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
import com.ibm.watson.data.client.model.enums.DatasourceTypePropertyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Definition of a data source property.
 */
public class DatasourceTypeProperty {

    private String name;
    private DatasourceTypePropertyType type;
    private String label;
    private String description;
    private String placeholder;
    private Boolean required;
    private Boolean masked;
    private Boolean hidden;
    private Boolean readonly;
    private Boolean multiline;
    private String defaultValue;
    private List<DatasourceTypePropertyValues> values = null;
    private List<String> tags = null;
    private String group;
    private List<String> supportedEnvironments = null;

    public DatasourceTypeProperty name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The property name.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DatasourceTypeProperty type(DatasourceTypePropertyType type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the property.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypePropertyType getType() { return type; }
    public void setType(DatasourceTypePropertyType type) { this.type = type; }

    public DatasourceTypeProperty label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The label for the property.
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty("label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public DatasourceTypeProperty description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description for the property.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DatasourceTypeProperty placeholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * An example value for the property.
     * @return placeholder
     **/
    @javax.annotation.Nullable
    @JsonProperty("placeholder")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPlaceholder() { return placeholder; }
    public void setPlaceholder(String placeholder) { this.placeholder = placeholder; }

    public DatasourceTypeProperty required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Whether the property is required.
     * @return required
     **/
    @javax.annotation.Nullable
    @JsonProperty("required")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }

    public DatasourceTypeProperty masked(Boolean masked) {
        this.masked = masked;
        return this;
    }

    /**
     * Whether the property should be masked. For example, when the property is a
     * password.
     * @return masked
     **/
    @javax.annotation.Nullable
    @JsonProperty("masked")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getMasked() { return masked; }
    public void setMasked(Boolean masked) { this.masked = masked; }

    public DatasourceTypeProperty hidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Whether the property should be displayed in a user interface.
     * @return hidden
     **/
    @javax.annotation.Nullable
    @JsonProperty("hidden")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getHidden() { return hidden; }
    public void setHidden(Boolean hidden) { this.hidden = hidden; }

    public DatasourceTypeProperty readonly(Boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    /**
     * Whether the property is a read-only value.
     * @return readonly
     **/
    @javax.annotation.Nullable
    @JsonProperty("readonly")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getReadonly() { return readonly; }
    public void setReadonly(Boolean readonly) { this.readonly = readonly; }

    public DatasourceTypeProperty multiline(Boolean multiline) {
        this.multiline = multiline;
        return this;
    }

    /**
     * Whether the property should be displayed in a multi-line field.
     * @return multiline
     **/
    @javax.annotation.Nullable
    @JsonProperty("multiline")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getMultiline() { return multiline; }
    public void setMultiline(Boolean multiline) { this.multiline = multiline; }

    public DatasourceTypeProperty defaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * The default value for the property if the value is not otherwise specified.
     * @return defaultValue
     **/
    @javax.annotation.Nullable
    @JsonProperty("default_value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultValue() { return defaultValue; }
    public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }

    public DatasourceTypeProperty values(List<DatasourceTypePropertyValues> values) {
        this.values = values;
        return this;
    }

    public DatasourceTypeProperty addValuesItem(DatasourceTypePropertyValues valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * If the property type is enum, the list of enumerated values that the
     *property can take.
     * @return values
     **/
    @javax.annotation.Nullable
    @JsonProperty("values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypePropertyValues> getValues() { return values; }
    public void setValues(List<DatasourceTypePropertyValues> values) { this.values = values; }

    public DatasourceTypeProperty tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public DatasourceTypeProperty addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Tags associated with a property.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public DatasourceTypeProperty group(String group) {
        this.group = group;
        return this;
    }

    /**
     * A classification group for the property.
     * @return group
     **/
    @javax.annotation.Nullable
    @JsonProperty("group")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public DatasourceTypeProperty supportedEnvironments(List<String> supportedEnvironments) {
        this.supportedEnvironments = supportedEnvironments;
        return this;
    }

    public DatasourceTypeProperty addSupportedEnvironmentsItem(String supportedEnvironmentsItem) {
        if (this.supportedEnvironments == null) {
            this.supportedEnvironments = new ArrayList<>();
        }
        this.supportedEnvironments.add(supportedEnvironmentsItem);
        return this;
    }

    /**
     * The list of environments where this property may be used.
     * @return supportedEnvironments
     **/
    @javax.annotation.Nullable
    @JsonProperty("supported_environments")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSupportedEnvironments() { return supportedEnvironments; }
    public void setSupportedEnvironments(List<String> supportedEnvironments) { this.supportedEnvironments = supportedEnvironments; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeProperty datasourceTypeProperty = (DatasourceTypeProperty)o;
        return Objects.equals(this.name, datasourceTypeProperty.name) &&
                Objects.equals(this.type, datasourceTypeProperty.type) &&
                Objects.equals(this.label, datasourceTypeProperty.label) &&
                Objects.equals(this.description, datasourceTypeProperty.description) &&
                Objects.equals(this.placeholder, datasourceTypeProperty.placeholder) &&
                Objects.equals(this.required, datasourceTypeProperty.required) &&
                Objects.equals(this.masked, datasourceTypeProperty.masked) &&
                Objects.equals(this.hidden, datasourceTypeProperty.hidden) &&
                Objects.equals(this.readonly, datasourceTypeProperty.readonly) &&
                Objects.equals(this.multiline, datasourceTypeProperty.multiline) &&
                Objects.equals(this.defaultValue, datasourceTypeProperty.defaultValue) &&
                Objects.equals(this.values, datasourceTypeProperty.values) &&
                Objects.equals(this.tags, datasourceTypeProperty.tags) &&
                Objects.equals(this.group, datasourceTypeProperty.group) &&
                Objects.equals(this.supportedEnvironments, datasourceTypeProperty.supportedEnvironments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, label, description, placeholder, required,
                masked, hidden, readonly, multiline, defaultValue,
                values, tags, group, supportedEnvironments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeProperty {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    placeholder: ").append(toIndentedString(placeholder)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    masked: ").append(toIndentedString(masked)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    readonly: ").append(toIndentedString(readonly)).append("\n");
        sb.append("    multiline: ").append(toIndentedString(multiline)).append("\n");
        sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    supportedEnvironments: ").append(toIndentedString(supportedEnvironments)).append("\n");
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
