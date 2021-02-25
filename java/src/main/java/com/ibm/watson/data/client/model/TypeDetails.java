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

import java.util.Objects;

/**
 * TypeDetails
 */
public class TypeDetails {

    private Integer length;
    private Integer precision;
    private Integer scale;
    private String type;

    @javax.annotation.Nullable
    @JsonProperty("length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLength() { return length; }
    public void setLength(Integer length) { this.length = length; }

    @javax.annotation.Nullable
    @JsonProperty("precision")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getPrecision() { return precision; }
    public void setPrecision(Integer precision) { this.precision = precision; }

    @javax.annotation.Nullable
    @JsonProperty("scale")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getScale() { return scale; }
    public void setScale(Integer scale) { this.scale = scale; }

    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDetails that = (TypeDetails) o;
        return Objects.equals(length, that.length) &&
                Objects.equals(precision, that.precision) &&
                Objects.equals(scale, that.scale) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, precision, scale, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TypeDetails {\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    precision: ").append(toIndentedString(precision)).append("\n");
        sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
