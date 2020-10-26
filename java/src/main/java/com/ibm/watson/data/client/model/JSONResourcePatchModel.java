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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * JSONResourcePatchModel
 */
@JsonPropertyOrder({
        JSONResourcePatchModel.JSON_PROPERTY_OP,
        JSONResourcePatchModel.JSON_PROPERTY_PATH,
        JSONResourcePatchModel.JSON_PROPERTY_FROM,
        JSONResourcePatchModel.JSON_PROPERTY_VALUE
})
public class JSONResourcePatchModel {
    /**
     * The operation to be performed
     */
    public enum OpEnum {
        ADD("add"),

        REMOVE("remove"),

        REPLACE("replace"),

        MOVE("move"),

        COPY("copy"),

        TEST("test");

        private String value;

        OpEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OpEnum fromValue(String value) {
            for (OpEnum b : OpEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_OP = "op";
    private OpEnum op;

    public static final String JSON_PROPERTY_PATH = "path";
    private String path;

    public static final String JSON_PROPERTY_FROM = "from";
    private String from;

    public static final String JSON_PROPERTY_VALUE = "value";
    private Object value;

    public JSONResourcePatchModel op(OpEnum op) {
        this.op = op;
        return this;
    }

    /**
     * The operation to be performed
     * @return op
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The operation to be performed")
    @JsonProperty(JSON_PROPERTY_OP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OpEnum getOp() {
        return op;
    }

    public void setOp(OpEnum op) { this.op = op; }

    public JSONResourcePatchModel path(String path) {
        this.path = path;
        return this;
    }

    /**
     * A JSON pointer to the field to update
     * @return path
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "A JSON pointer to the field to update")
    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPath() {
        return path;
    }

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
    @ApiModelProperty(value = "A string containing a JSON pointer value")
    @JsonProperty(JSON_PROPERTY_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFrom() {
        return from;
    }

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
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
