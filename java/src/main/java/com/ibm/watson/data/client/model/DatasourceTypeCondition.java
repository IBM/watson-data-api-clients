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
import com.ibm.watson.data.client.model.enums.DatasourceTypeConditionEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A specific condition to be applied to a property.
 */
public class DatasourceTypeCondition {

    private String propertyName;
    private DatasourceTypeConditionEnum condition;
    private List<String> values = null;

    public DatasourceTypeCondition propertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }

    /**
     * the name of the property used by this condition.
     * @return propertyName
     **/
    @javax.annotation.Nullable
    @JsonProperty("property_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public DatasourceTypeCondition condition(DatasourceTypeConditionEnum condition) {
        this.condition = condition;
        return this;
    }

    /**
     * the condition to validate between owning property and this property.
     * @return condition
     **/
    @javax.annotation.Nullable
    @JsonProperty("condition")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypeConditionEnum getCondition() { return condition; }
    public void setCondition(DatasourceTypeConditionEnum condition) { this.condition = condition; }

    public DatasourceTypeCondition values(List<String> values) {
        this.values = values;
        return this;
    }

    public DatasourceTypeCondition addValuesItem(String valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * the values to use in checking the condition.
     * @return values
     **/
    @javax.annotation.Nullable
    @JsonProperty("values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getValues() { return values; }
    public void setValues(List<String> values) { this.values = values; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeCondition datasourceTypeCondition = (DatasourceTypeCondition)o;
        return Objects.equals(this.propertyName, datasourceTypeCondition.propertyName) &&
                Objects.equals(this.condition, datasourceTypeCondition.condition) &&
                Objects.equals(this.values, datasourceTypeCondition.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, condition, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeCondition {\n");
        sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
        sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
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
