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
import com.ibm.watson.data.client.model.enums.QueryConditionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * QueryCondition
 */
public class QueryCondition {

    private QueryConditionType type;
    private List<String> values = null;

    public QueryCondition type(QueryConditionType type) {
        this.type = type;
        return this;
    }

    /**
     * type of condition
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public QueryConditionType getType() { return type; }
    public void setType(QueryConditionType type) { this.type = type; }

    public QueryCondition values(List<String> values) {
        this.values = values;
        return this;
    }

    public QueryCondition addValuesItem(String valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * values of condition
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
        QueryCondition queryCondition = (QueryCondition)o;
        return Objects.equals(this.type, queryCondition.type) &&
                Objects.equals(this.values, queryCondition.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryCondition {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
