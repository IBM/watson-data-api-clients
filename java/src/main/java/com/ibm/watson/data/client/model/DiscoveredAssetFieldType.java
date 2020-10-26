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
 * The type description of a discovered asset field.
 */
public class DiscoveredAssetFieldType {

    private String type;
    private Integer length;
    private Integer scale;
    private Boolean nullable;
    private Boolean signed;

    public DiscoveredAssetFieldType type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the field.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public DiscoveredAssetFieldType length(Integer length) {
        this.length = length;
        return this;
    }

    /**
     * The precision (or length) of the field.
     * @return length
     **/
    @javax.annotation.Nullable
    @JsonProperty("length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLength() { return length; }
    public void setLength(Integer length) { this.length = length; }

    public DiscoveredAssetFieldType scale(Integer scale) {
        this.scale = scale;
        return this;
    }

    /**
     * The scale of the field if the type is decimal.
     * @return scale
     **/
    @javax.annotation.Nullable
    @JsonProperty("scale")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getScale() { return scale; }
    public void setScale(Integer scale) { this.scale = scale; }

    public DiscoveredAssetFieldType nullable(Boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    /**
     * Whether the field accepts null values.
     * @return nullable
     **/
    @javax.annotation.Nullable
    @JsonProperty("nullable")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getNullable() { return nullable; }
    public void setNullable(Boolean nullable) { this.nullable = nullable; }

    public DiscoveredAssetFieldType signed(Boolean signed) {
        this.signed = signed;
        return this;
    }

    /**
     * Whether an integer field holds signed or unsigned values.
     * @return signed
     **/
    @javax.annotation.Nullable
    @JsonProperty("signed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getSigned() { return signed; }
    public void setSigned(Boolean signed) { this.signed = signed; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveredAssetFieldType discoveredAssetFieldType = (DiscoveredAssetFieldType)o;
        return Objects.equals(this.type, discoveredAssetFieldType.type) &&
                Objects.equals(this.length, discoveredAssetFieldType.length) &&
                Objects.equals(this.scale, discoveredAssetFieldType.scale) &&
                Objects.equals(this.nullable, discoveredAssetFieldType.nullable) &&
                Objects.equals(this.signed, discoveredAssetFieldType.signed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, length, scale, nullable, signed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveredAssetFieldType {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
        sb.append("    nullable: ").append(toIndentedString(nullable)).append("\n");
        sb.append("    signed: ").append(toIndentedString(signed)).append("\n");
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
