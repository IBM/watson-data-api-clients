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
import com.ibm.watson.data.client.model.enums.PropertyType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Asset Type Property Model
 */
public class AssetTypeProperty {

    private PropertyType type;
    private String description;
    private String placeholder;
    private Boolean isArray;
    private Boolean required;
    private Boolean hidden;
    private Boolean readonly;
    private Object defaultValue;
    private List<Object> values = null;
    private Object minimum;
    private Object maximum;
    private Integer minLength;
    private Integer maxLength;
    private Map<String, AssetTypeProperty> properties = null;

    public AssetTypeProperty type(PropertyType type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the property.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public PropertyType getType() { return type; }
    public void setType(PropertyType type) { this.type = type; }

    public AssetTypeProperty description(String description) {
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

    public AssetTypeProperty placeholder(String placeholder) {
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

    public AssetTypeProperty isArray(Boolean isArray) {
        this.isArray = isArray;
        return this;
    }

    /**
     * Whether the property is an array.
     * @return isArray
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_array")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsArray() { return isArray; }
    public void setIsArray(Boolean isArray) { this.isArray = isArray; }

    public AssetTypeProperty required(Boolean required) {
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

    public AssetTypeProperty hidden(Boolean hidden) {
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

    public AssetTypeProperty readonly(Boolean readonly) {
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

    public AssetTypeProperty defaultValue(Object defaultValue) {
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
    public Object getDefaultValue() { return defaultValue; }
    public void setDefaultValue(Object defaultValue) { this.defaultValue = defaultValue; }

    public AssetTypeProperty values(List<Object> values) {
        this.values = values;
        return this;
    }

    public AssetTypeProperty addValuesItem(Object valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * The list of enumerated values that the property can take.
     * @return values
     **/
    @javax.annotation.Nullable
    @JsonProperty("values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getValues() { return values; }
    public void setValues(List<Object> values) { this.values = values; }

    public AssetTypeProperty minimum(Object minimum) {
        this.minimum = minimum;
        return this;
    }

    /**
     * The minimum value the property can accept.
     * @return minimum
     **/
    @javax.annotation.Nullable
    @JsonProperty("minimum")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getMinimum() { return minimum; }
    public void setMinimum(Object minimum) { this.minimum = minimum; }

    public AssetTypeProperty maximum(Object maximum) {
        this.maximum = maximum;
        return this;
    }

    /**
     * The maximum value the property can accept.
     * @return maximum
     **/
    @javax.annotation.Nullable
    @JsonProperty("maximum")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getMaximum() { return maximum; }
    public void setMaximum(Object maximum) { this.maximum = maximum; }

    public AssetTypeProperty minLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    /**
     * The minimum length the property can accept.
     * @return minLength
     **/
    @javax.annotation.Nullable
    @JsonProperty("min_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMinLength() { return minLength; }
    public void setMinLength(Integer minLength) { this.minLength = minLength; }

    public AssetTypeProperty maxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * The maximum length the property can accept.
     * @return maxLength
     **/
    @javax.annotation.Nullable
    @JsonProperty("max_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMaxLength() { return maxLength; }
    public void setMaxLength(Integer maxLength) { this.maxLength = maxLength; }

    public AssetTypeProperty properties(Map<String, AssetTypeProperty> properties) {
        this.properties = properties;
        return this;
    }

    public AssetTypeProperty putPropertiesItem(String key, AssetTypeProperty propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * If the property type is object, the properties of the expected object type.
     * @return properties
     **/
    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, AssetTypeProperty> getProperties() { return properties; }
    public void setProperties(Map<String, AssetTypeProperty> properties) { this.properties = properties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetTypeProperty assetTypeProperty = (AssetTypeProperty)o;
        return Objects.equals(this.type, assetTypeProperty.type) &&
                Objects.equals(this.description, assetTypeProperty.description) &&
                Objects.equals(this.placeholder, assetTypeProperty.placeholder) &&
                Objects.equals(this.isArray, assetTypeProperty.isArray) &&
                Objects.equals(this.required, assetTypeProperty.required) &&
                Objects.equals(this.hidden, assetTypeProperty.hidden) &&
                Objects.equals(this.readonly, assetTypeProperty.readonly) &&
                Objects.equals(this.defaultValue, assetTypeProperty.defaultValue) &&
                Objects.equals(this.values, assetTypeProperty.values) &&
                Objects.equals(this.minimum, assetTypeProperty.minimum) &&
                Objects.equals(this.maximum, assetTypeProperty.maximum) &&
                Objects.equals(this.minLength, assetTypeProperty.minLength) &&
                Objects.equals(this.maxLength, assetTypeProperty.maxLength) &&
                Objects.equals(this.properties, assetTypeProperty.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description, placeholder, isArray, required,
                hidden, readonly, defaultValue, values, minimum,
                maximum, minLength, maxLength, properties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetTypeProperty {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    placeholder: ").append(toIndentedString(placeholder)).append("\n");
        sb.append("    isArray: ").append(toIndentedString(isArray)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    readonly: ").append(toIndentedString(readonly)).append("\n");
        sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
        sb.append("    minimum: ").append(toIndentedString(minimum)).append("\n");
        sb.append("    maximum: ").append(toIndentedString(maximum)).append("\n");
        sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
        sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
