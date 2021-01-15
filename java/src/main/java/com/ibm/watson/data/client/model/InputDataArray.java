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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * The input data. 
 */
public class InputDataArray {

    private String id;
    private List<String> fields = null;
    private List<List<Object>> values = null;

    public InputDataArray id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Discriminates the data for multi input data situation. For example in cases where multiple tensors are expected.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public InputDataArray fields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public InputDataArray addFieldsItem(String fieldsItem) {
        if (this.fields == null) {
            this.fields = new ArrayList<>();
        }
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * The names of the fields. The order of fields values must be consistent with the order of fields names.
     * @return fields
     **/
    @javax.annotation.Nullable
    @JsonProperty("fields")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getFields() { return fields; }
    public void setFields(List<String> fields) { this.fields = fields; }

    public InputDataArray values(List<List<Object>> values) {
        this.values = values;
        return this;
    }

    public InputDataArray addValuesItem(List<Object> valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * Input data as a vector for a single record or a matrix representing a mini batch of records.
     * @return values
     **/
    @javax.annotation.Nullable
    @JsonProperty("values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<List<Object>> getValues() { return values; }
    public void setValues(List<List<Object>> values) { this.values = values; }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        InputDataArray inputDataArray = (InputDataArray) o;
        return Objects.equals(this.id, inputDataArray.id) &&
                Objects.equals(this.fields, inputDataArray.fields) &&
                Objects.equals(this.values, inputDataArray.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fields, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InputDataArray {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
