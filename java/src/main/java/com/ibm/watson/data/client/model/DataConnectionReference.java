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

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.DataConnectionType;

/**
 * A reference to data with an optional data schema. 
 */
public class DataConnectionReference {

    private String id;
    private DataConnectionType type;
    private Map<String, Object> connection;
    private Map<String, Object> location;
    private DataSchema schema;

    public DataConnectionReference id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Item identification inside a collection.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public DataConnectionReference type(DataConnectionType type) {
        this.type = type;
        return this;
    }

    /**
     * The data source type.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public DataConnectionType getType() { return type; }
    public void setType(DataConnectionType type) { this.type = type; }

    public DataConnectionReference connection(Map<String, Object> connection) {
        this.connection = connection;
        return this;
    }

    /**
     * If the data reference refers to an asset (/v2/assets/&lt;asset_id&gt;), then the &#x60;href&#x60;needs to be specified in the &#39;location&#39; object and this field is not required.
     * @return connection
     **/
    @javax.annotation.Nullable
    @JsonProperty("connection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getConnection() { return connection; }
    public void setConnection(Map<String, Object> connection) { this.connection = connection; }

    public DataConnectionReference location(Map<String, Object> location) {
        this.location = location;
        return this;
    }

    /**
     * Path where to find the data. For s3 for example, this would be \&quot;bucket\&quot; and \&quot;path\&quot;. If data connection href is used it is an asset href(/v2/assets/&lt;asset_id&gt;) containing the data connection id and location. The &#39;connection&#39; field above is not required if data connection href is used.
     * @return location
     **/
    @javax.annotation.Nullable
    @JsonProperty("location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getLocation() { return location; }
    public void setLocation(Map<String, Object> location) { this.location = location; }

    public DataConnectionReference schema(DataSchema schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Get schema
     * @return schema
     **/
    @javax.annotation.Nullable
    @JsonProperty("schema")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataSchema getSchema() { return schema; }
    public void setSchema(DataSchema schema) { this.schema = schema; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataConnectionReference dataConnectionReference = (DataConnectionReference) o;
        return Objects.equals(this.id, dataConnectionReference.id) &&
                Objects.equals(this.type, dataConnectionReference.type) &&
                Objects.equals(this.connection, dataConnectionReference.connection) &&
                Objects.equals(this.location, dataConnectionReference.location) &&
                Objects.equals(this.schema, dataConnectionReference.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, connection, location, schema);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataConnectionReference {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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
