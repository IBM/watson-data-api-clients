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
import com.ibm.watson.data.client.model.enums.JsonPatchOperation;

import java.util.Objects;

/**
 * JSONResourcePatchModel
 */
public class JSONResourcePatchModel {

    private JsonPatchOperation op;
    private String path;
    private String from;
    private Object value;

    public JSONResourcePatchModel op(JsonPatchOperation op) {
        this.op = op;
        return this;
    }

    /**
     * The operation to be performed
     * @return op
     **/
    @javax.annotation.Nullable
    @JsonProperty("op")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JsonPatchOperation getOp() { return op; }
    public void setOp(JsonPatchOperation op) { this.op = op; }

    public JSONResourcePatchModel path(String path) {
        this.path = path;
        return this;
    }

    /**
     * A JSON pointer to the field to update
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty("path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public JSONResourcePatchModel from(String from) {
        this.from = from;
        return this;
    }

    /**
     * A string containing a JSON pointer value
     * @return from
     **/
    @javax.annotation.Nullable
    @JsonProperty("from")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public JSONResourcePatchModel value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JSONResourcePatchModel jsONResourcePatchModel = (JSONResourcePatchModel)o;
        return Objects.equals(this.op, jsONResourcePatchModel.op) &&
                Objects.equals(this.path, jsONResourcePatchModel.path) &&
                Objects.equals(this.from, jsONResourcePatchModel.from) &&
                Objects.equals(this.value, jsONResourcePatchModel.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(op, path, from, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JSONResourcePatchModel {\n");
        sb.append("    op: ").append(toIndentedString(op)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    from: ").append(toIndentedString(from)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
