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
 * CustomAttributeDefinitionEntityHeader
 */
public class CustomAttributeDefinitionEntityHeader {

    private String name;
    private String reverseName;
    private String description;
    // TODO: should probably be an enumeration with values of NUMBER, TEXT, ?
    private String type;
    private List<String> artifactTypes = null;
    private List<String> relatedArtifactTypes = null;
    private Boolean multipleValues;
    private Boolean displayInChildAssets;
    private Boolean required;
    private Boolean readOnly;
    private Boolean hidden;
    private Boolean placeholder;
    private String defaultValue;
    private Double minimum;
    private Double maximum;
    private Integer minLength;
    private Integer maxLength;

    public CustomAttributeDefinitionEntityHeader name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the artifact.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CustomAttributeDefinitionEntityHeader reverseName(String reverseName) {
        this.reverseName = reverseName;
        return this;
    }

    /**
     * Reversed Custom Attribute relationship name which may be display on the
     * related artifact
     * @return reverseName
     **/
    @javax.annotation.Nullable
    @JsonProperty("reverse_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getReverseName() { return reverseName; }
    public void setReverseName(String reverseName) { this.reverseName = reverseName; }

    public CustomAttributeDefinitionEntityHeader description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public CustomAttributeDefinitionEntityHeader type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Type of custom attribute values (required for creation)
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public CustomAttributeDefinitionEntityHeader artifactTypes(List<String> artifactTypes) {
        this.artifactTypes = artifactTypes;
        return this;
    }

    public CustomAttributeDefinitionEntityHeader addArtifactTypesItem(String artifactTypesItem) {
        if (this.artifactTypes == null) {
            this.artifactTypes = new ArrayList<>();
        }
        this.artifactTypes.add(artifactTypesItem);
        return this;
    }

    /**
     * Set of artifact types
     * @return artifactTypes
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_types")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getArtifactTypes() { return artifactTypes; }
    public void setArtifactTypes(List<String> artifactTypes) { this.artifactTypes = artifactTypes; }

    public CustomAttributeDefinitionEntityHeader relatedArtifactTypes(List<String> relatedArtifactTypes) {
        this.relatedArtifactTypes = relatedArtifactTypes;
        return this;
    }

    public CustomAttributeDefinitionEntityHeader addRelatedArtifactTypesItem(String relatedArtifactTypesItem) {
        if (this.relatedArtifactTypes == null) {
            this.relatedArtifactTypes = new ArrayList<>();
        }
        this.relatedArtifactTypes.add(relatedArtifactTypesItem);
        return this;
    }

    /**
     * Set of related artifact types
     * @return relatedArtifactTypes
     **/
    @javax.annotation.Nullable
    @JsonProperty("related_artifact_types")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRelatedArtifactTypes() { return relatedArtifactTypes; }
    public void setRelatedArtifactTypes(List<String> relatedArtifactTypes) { this.relatedArtifactTypes = relatedArtifactTypes; }

    public CustomAttributeDefinitionEntityHeader multipleValues(Boolean multipleValues) {
        this.multipleValues = multipleValues;
        return this;
    }

    /**
     * Specifies whether the custom attribute can have more than one value
     * @return multipleValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("multiple_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getMultipleValues() { return multipleValues; }
    public void setMultipleValues(Boolean multipleValues) { this.multipleValues = multipleValues; }

    public CustomAttributeDefinitionEntityHeader displayInChildAssets(Boolean displayInChildAssets) {
        this.displayInChildAssets = displayInChildAssets;
        return this;
    }

    /**
     * Specifies whether custom attribute values should be diplayed in child
     *assets
     * @return displayInChildAssets
     **/
    @javax.annotation.Nullable
    @JsonProperty("display_in_child_assets")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDisplayInChildAssets() { return displayInChildAssets; }
    public void setDisplayInChildAssets(Boolean displayInChildAssets) { this.displayInChildAssets = displayInChildAssets; }

    public CustomAttributeDefinitionEntityHeader required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Get required
     * @return required
     **/
    @javax.annotation.Nullable
    @JsonProperty("required")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }

    public CustomAttributeDefinitionEntityHeader readOnly(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    /**
     * Specifies whether custom attribute values should be read only
     * @return readOnly
     **/
    @javax.annotation.Nullable
    @JsonProperty("read_only")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getReadOnly() { return readOnly; }
    public void setReadOnly(Boolean readOnly) { this.readOnly = readOnly; }

    public CustomAttributeDefinitionEntityHeader hidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Get hidden
     * @return hidden
     **/
    @javax.annotation.Nullable
    @JsonProperty("hidden")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getHidden() { return hidden; }
    public void setHidden(Boolean hidden) { this.hidden = hidden; }

    public CustomAttributeDefinitionEntityHeader placeholder(Boolean placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * Get placeholder
     * @return placeholder
     **/
    @javax.annotation.Nullable
    @JsonProperty("placeholder")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getPlaceholder() { return placeholder; }
    public void setPlaceholder(Boolean placeholder) { this.placeholder = placeholder; }

    public CustomAttributeDefinitionEntityHeader defaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * The default value of the custom attribute
     * @return defaultValue
     **/
    @javax.annotation.Nullable
    @JsonProperty("default_value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultValue() { return defaultValue; }
    public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }

    public CustomAttributeDefinitionEntityHeader minimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    /**
     * Get minimum
     * @return minimum
     **/
    @javax.annotation.Nullable
    @JsonProperty("minimum")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMinimum() { return minimum; }
    public void setMinimum(Double minimum) { this.minimum = minimum; }

    public CustomAttributeDefinitionEntityHeader maximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    /**
     * Get maximum
     * @return maximum
     **/
    @javax.annotation.Nullable
    @JsonProperty("maximum")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMaximum() { return maximum; }
    public void setMaximum(Double maximum) { this.maximum = maximum; }

    public CustomAttributeDefinitionEntityHeader minLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    /**
     * Minimuum length of custom attribute values of the type string
     * @return minLength
     **/
    @javax.annotation.Nullable
    @JsonProperty("min_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMinLength() { return minLength; }
    public void setMinLength(Integer minLength) { this.minLength = minLength; }

    public CustomAttributeDefinitionEntityHeader maxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * Maximuum length of custom attribute values of the type string
     * @return maxLength
     **/
    @javax.annotation.Nullable
    @JsonProperty("max_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMaxLength() { return maxLength; }
    public void setMaxLength(Integer maxLength) { this.maxLength = maxLength; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CustomAttributeDefinitionEntityHeader that = (CustomAttributeDefinitionEntityHeader)o;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.reverseName, that.reverseName) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.artifactTypes, that.artifactTypes) &&
                Objects.equals(this.relatedArtifactTypes, that.relatedArtifactTypes) &&
                Objects.equals(this.multipleValues, that.multipleValues) &&
                Objects.equals(this.displayInChildAssets, that.displayInChildAssets) &&
                Objects.equals(this.required, that.required) &&
                Objects.equals(this.readOnly, that.readOnly) &&
                Objects.equals(this.hidden, that.hidden) &&
                Objects.equals(this.placeholder, that.placeholder) &&
                Objects.equals(this.defaultValue, that.defaultValue) &&
                Objects.equals(this.minimum, that.minimum) &&
                Objects.equals(this.maximum, that.maximum) &&
                Objects.equals(this.minLength, that.minLength) &&
                Objects.equals(this.maxLength, that.maxLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, reverseName, description, type, artifactTypes,
                relatedArtifactTypes, multipleValues,
                displayInChildAssets, required, readOnly, hidden,
                placeholder, defaultValue, minimum, maximum, minLength,
                maxLength);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomAttributeDefinitionEntityHeader {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    reverseName: ").append(toIndentedString(reverseName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    artifactTypes: ").append(toIndentedString(artifactTypes)).append("\n");
        sb.append("    relatedArtifactTypes: ").append(toIndentedString(relatedArtifactTypes)).append("\n");
        sb.append("    multipleValues: ").append(toIndentedString(multipleValues)).append("\n");
        sb.append("    displayInChildAssets: ").append(toIndentedString(displayInChildAssets)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    placeholder: ").append(toIndentedString(placeholder)).append("\n");
        sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
        sb.append("    minimum: ").append(toIndentedString(minimum)).append("\n");
        sb.append("    maximum: ").append(toIndentedString(maximum)).append("\n");
        sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
        sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
