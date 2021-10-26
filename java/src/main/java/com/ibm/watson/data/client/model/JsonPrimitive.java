/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

/**
 * JsonPrimitive
 */
public class JsonPrimitive extends JsonElement {

    private Boolean number;
    private Boolean string;
    private Boolean _boolean;

    public JsonPrimitive number(Boolean number) {
        this.number = number;
        return this;
    }

    /**
     * Get number
     * @return number
     **/
    @javax.annotation.Nullable
    @JsonProperty("number")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getNumber() {
        return number;
    }
    public void setNumber(Boolean number) {
        this.number = number;
    }

    public JsonPrimitive string(Boolean string) {
        this.string = string;
        return this;
    }

    /**
     * Get string
     * @return string
     **/
    @javax.annotation.Nullable
    @JsonProperty("string")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getString() {
        return string;
    }
    public void setString(Boolean string) {
        this.string = string;
    }

    public JsonPrimitive _boolean(Boolean _boolean) {
        this._boolean = _boolean;
        return this;
    }

    /**
     * Get _boolean
     * @return _boolean
     **/
    @javax.annotation.Nullable
    @JsonProperty("boolean")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getBoolean() {
        return _boolean;
    }
    public void setBoolean(Boolean _boolean) {
        this._boolean = _boolean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) o;
        return super.equals(o) &&
                Objects.equals(this.number, jsonPrimitive.number) &&
                Objects.equals(this.string, jsonPrimitive.string) &&
                Objects.equals(this._boolean, jsonPrimitive._boolean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, string, _boolean);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JsonPrimitive {\n");
        this.toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    string: ").append(toIndentedString(string)).append("\n");
        sb.append("    _boolean: ").append(toIndentedString(_boolean)).append("\n");
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
