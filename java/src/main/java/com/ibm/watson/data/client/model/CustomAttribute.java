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
 * Custom attribute with its values
 */
public class CustomAttribute {

    private String customAttributeDefinitionId;
    private String name;
    private List<CustomAttributeValueObject> values = null;

    public CustomAttribute customAttributeDefinitionId(String customAttributeDefinitionId) {
        this.customAttributeDefinitionId = customAttributeDefinitionId;
        return this;
    }

    /**
     * Custom attribute definition ID
     * @return customAttributeDefinitionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom_attribute_definition_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCustomAttributeDefinitionId() { return customAttributeDefinitionId; }
    public void setCustomAttributeDefinitionId(String customAttributeDefinitionId) { this.customAttributeDefinitionId = customAttributeDefinitionId; }

    public CustomAttribute name(String name) {
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

    public CustomAttribute values(List<CustomAttributeValueObject> values) {
        this.values = values;
        return this;
    }

    public CustomAttribute addValuesItem(CustomAttributeValueObject valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * List of values
     * @return values
     **/
    @javax.annotation.Nullable
    @JsonProperty("values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttributeValueObject> getValues() { return values; }
    public void setValues(List<CustomAttributeValueObject> values) { this.values = values; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CustomAttribute customAttribute = (CustomAttribute)o;
        return Objects.equals(this.customAttributeDefinitionId,
                customAttribute.customAttributeDefinitionId) &&
                Objects.equals(this.name, customAttribute.name) &&
                Objects.equals(this.values, customAttribute.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customAttributeDefinitionId, name, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomAttribute {\n");
        sb.append("    customAttributeDefinitionId: ").append(toIndentedString(customAttributeDefinitionId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
