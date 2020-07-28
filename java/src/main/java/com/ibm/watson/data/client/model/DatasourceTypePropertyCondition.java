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
 * Definition of a property enablement condition.
 */
public class DatasourceTypePropertyCondition {

    private String propertyName;
    private List<DatasourceTypeCondition> conditions = null;
    private Boolean allConditionsRequired;

    public DatasourceTypePropertyCondition propertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }

    /**
     * The name of the property to be enabled based on these conditions.
     * @return propertyName
     **/
    @javax.annotation.Nullable
    @JsonProperty("property_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public DatasourceTypePropertyCondition conditions(List<DatasourceTypeCondition> conditions) {
        this.conditions = conditions;
        return this;
    }

    public DatasourceTypePropertyCondition addConditionsItem(DatasourceTypeCondition conditionsItem) {
        if (this.conditions == null) {
            this.conditions = new ArrayList<>();
        }
        this.conditions.add(conditionsItem);
        return this;
    }

    /**
     * the conditions to apply to the property.
     * @return conditions
     **/
    @javax.annotation.Nullable
    @JsonProperty("conditions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeCondition> getConditions() { return conditions; }
    public void setConditions(List<DatasourceTypeCondition> conditions) { this.conditions = conditions; }

    public DatasourceTypePropertyCondition allConditionsRequired(Boolean allConditionsRequired) {
        this.allConditionsRequired = allConditionsRequired;
        return this;
    }

    /**
     * Whether all conditions must be satisfied to enable this property.
     * @return allConditionsRequired
     **/
    @javax.annotation.Nullable
    @JsonProperty("all_conditions_required")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAllConditionsRequired() { return allConditionsRequired; }
    public void setAllConditionsRequired(Boolean allConditionsRequired) { this.allConditionsRequired = allConditionsRequired; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypePropertyCondition datasourceTypePropertyCondition = (DatasourceTypePropertyCondition)o;
        return Objects.equals(this.propertyName, datasourceTypePropertyCondition.propertyName) &&
                Objects.equals(this.conditions, datasourceTypePropertyCondition.conditions) &&
                Objects.equals(this.allConditionsRequired, datasourceTypePropertyCondition.allConditionsRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, conditions, allConditionsRequired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypePropertyCondition {\n");
        sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
        sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
        sb.append("    allConditionsRequired: ").append(toIndentedString(allConditionsRequired)).append("\n");
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
