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
import com.ibm.watson.data.client.model.enums.FormPropertyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FormProperty
 */
public class FormProperty {

    private String datePattern;
    private List<EnumValue> enumValues = null;
    private String id;
    private String name;
    private Boolean readable;
    private Boolean required;
    private FormPropertyType type;
    private String value;
    private Boolean writable;

    public FormProperty datePattern(String datePattern) {
        this.datePattern = datePattern;
        return this;
    }

    /**
     * only for dates
     * @return datePattern
     **/
    @javax.annotation.Nullable
    @JsonProperty("date_pattern")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDatePattern() { return datePattern; }
    public void setDatePattern(String datePattern) { this.datePattern = datePattern; }

    public FormProperty enumValues(List<EnumValue> enumValues) {
        this.enumValues = enumValues;
        return this;
    }

    public FormProperty addEnumValuesItem(EnumValue enumValuesItem) {
        if (this.enumValues == null) {
            this.enumValues = new ArrayList<>();
        }
        this.enumValues.add(enumValuesItem);
        return this;
    }

    /**
     * Get enumValues
     * @return enumValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("enum_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<EnumValue> getEnumValues() { return enumValues; }
    public void setEnumValues(List<EnumValue> enumValues) { this.enumValues = enumValues; }

    public FormProperty id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id (example: 'comment')
     * @return id
     **/
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public FormProperty name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public FormProperty readable(Boolean readable) {
        this.readable = readable;
        return this;
    }

    /**
     * display initial value
     * @return readable
     **/
    @javax.annotation.Nullable
    @JsonProperty("readable")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getReadable() { return readable; }
    public void setReadable(Boolean readable) { this.readable = readable; }

    public FormProperty required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * user is required to enter a value
     * @return required
     **/
    @javax.annotation.Nullable
    @JsonProperty("required")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }

    public FormProperty type(FormPropertyType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public FormPropertyType getType() { return type; }
    public void setType(FormPropertyType type) { this.type = type; }

    public FormProperty value(String value) {
        this.value = value;
        return this;
    }

    /**
     * initial value to display
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public FormProperty writable(Boolean writable) {
        this.writable = writable;
        return this;
    }

    /**
     * user can enter a value
     * @return writable
     **/
    @javax.annotation.Nullable
    @JsonProperty("writable")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getWritable() { return writable; }
    public void setWritable(Boolean writable) { this.writable = writable; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FormProperty formProperty = (FormProperty)o;
        return Objects.equals(this.datePattern, formProperty.datePattern) &&
                Objects.equals(this.enumValues, formProperty.enumValues) &&
                Objects.equals(this.id, formProperty.id) &&
                Objects.equals(this.name, formProperty.name) &&
                Objects.equals(this.readable, formProperty.readable) &&
                Objects.equals(this.required, formProperty.required) &&
                Objects.equals(this.type, formProperty.type) &&
                Objects.equals(this.value, formProperty.value) &&
                Objects.equals(this.writable, formProperty.writable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datePattern, enumValues, id, name, readable, required,
                type, value, writable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormProperty {\n");
        sb.append("    datePattern: ").append(toIndentedString(datePattern)).append("\n");
        sb.append("    enumValues: ").append(toIndentedString(enumValues)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    readable: ").append(toIndentedString(readable)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    writable: ").append(toIndentedString(writable)).append("\n");
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
