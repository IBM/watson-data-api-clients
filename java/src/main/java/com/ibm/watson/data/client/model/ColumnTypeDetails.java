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
 * ColumnTypeDetails
 */
public class ColumnTypeDetails {

    private String type;
    private Boolean nullable;
    private Double length;
    private Boolean isUnique;
    private Boolean signed;
    private Double scale;

    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @javax.annotation.Nullable
    @JsonProperty("nullable")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getNullable() { return nullable; }
    public void setNullable(Boolean nullable) { this.nullable = nullable; }

    @javax.annotation.Nullable
    @JsonProperty("length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getLength() { return length; }
    public void setLength(Double length) { this.length = length; }

    @javax.annotation.Nullable
    @JsonProperty("isUnique")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getUnique() { return isUnique; }
    public void setUnique(Boolean unique) { isUnique = unique; }

    @javax.annotation.Nullable
    @JsonProperty("signed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getSigned() { return signed; }
    public void setSigned(Boolean signed) { this.signed = signed; }

    @javax.annotation.Nullable
    @JsonProperty("scale")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getScale() { return scale; }
    public void setScale(Double scale) { this.scale = scale; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnTypeDetails that = (ColumnTypeDetails) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(nullable, that.nullable) &&
                Objects.equals(length, that.length) &&
                Objects.equals(isUnique, that.isUnique) &&
                Objects.equals(signed, that.signed) &&
                Objects.equals(scale, that.scale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, nullable, length, isUnique, signed, scale);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ColumnTypeDetails {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    nullable: ").append(toIndentedString(nullable)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
        sb.append("    signed: ").append(toIndentedString(signed)).append("\n");
        sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
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
