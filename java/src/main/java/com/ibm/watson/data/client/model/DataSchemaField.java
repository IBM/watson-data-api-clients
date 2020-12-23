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
import com.ibm.watson.data.client.model.enums.DataSchemaFieldType;

/**
 * The definition of a field within the expected schema, see [datarecord-metadata-v2-schema](https://api.dataplatform.cloud.ibm.com/schemas/common-pipeline/datarecord-metadata/datarecord-metadata-v2-schema.json) for the schema definition.
 */
public class DataSchemaField {

    private String name;
    private DataSchemaFieldType type;
    private Boolean nullable;
    private DataSchemaFieldMetadata metadata;

    public DataSchemaField name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A name for the field.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DataSchemaField type(DataSchemaFieldType type) {
        this.type = type;
        return this;
    }

    /**
     * A type for the field.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public DataSchemaFieldType getType() { return type; }
    public void setType(DataSchemaFieldType type) { this.type = type; }

    public DataSchemaField nullable(Boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    /**
     * Whether the field can have null values (true) or not (false).
     * @return nullability
     */
    @javax.annotation.Nullable
    @JsonProperty("nullable")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getNullable() { return nullable; }
    public void setNullable(Boolean nullable) { this.nullable = nullable; }

    public DataSchemaField metadata(DataSchemaFieldMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Additional metadata about the field.
     * @return metadata
     */
    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataSchemaFieldMetadata getMetadata() { return metadata; }
    public void setMetadata(DataSchemaFieldMetadata metadata) { this.metadata = metadata; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataSchemaField that = (DataSchemaField) o;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.nullable, that.nullable) &&
                Objects.equals(this.metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, nullable, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataSchemaField {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    nullable: ").append(toIndentedString(nullable)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
