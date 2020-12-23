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
 * The schema of the expected data, see [datarecord-metadata-v2-schema](https://api.dataplatform.cloud.ibm.com/schemas/common-pipeline/datarecord-metadata/datarecord-metadata-v2-schema.json) for the schema definition. 
 */
public class DataSchema {

    private String id;
    private String name;
    private String type;
    private List<DataSchemaField> fields = new ArrayList<>();

    public DataSchema id(String id) {
        this.id = id;
        return this;
    }

    /**
     * An id to identify a schema.
     * @return id
     **/
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public DataSchema name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A name for the schema.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DataSchema type(String type) {
        this.type = type;
        return this;
    }

    /**
     * A type for the schema.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public DataSchema fields(List<DataSchemaField> fields) {
        this.fields = fields;
        return this;
    }

    public DataSchema addFieldsItem(DataSchemaField fieldsItem) {
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * The fields that describe the data schema (eg. '[{"name": "duration", "type": "number"}]').
     * @return fields
     **/
    @JsonProperty("fields")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<DataSchemaField> getFields() { return fields; }
    public void setFields(List<DataSchemaField> fields) { this.fields = fields; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataSchema dataSchema = (DataSchema) o;
        return Objects.equals(this.id, dataSchema.id) &&
                Objects.equals(this.name, dataSchema.name) &&
                Objects.equals(this.type, dataSchema.type) &&
                Objects.equals(this.fields, dataSchema.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fields);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataSchema {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
