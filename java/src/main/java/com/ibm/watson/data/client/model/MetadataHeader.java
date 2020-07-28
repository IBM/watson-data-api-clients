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

import com.fasterxml.jackson.annotation.*;
import com.ibm.watson.data.client.model.enums.AssetCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Headline metadata about an asset (probably eventually merged when AssetMetadata and MetadataAsset merge)
 */
public class MetadataHeader extends Metadata {

    private String name;
    private String description;
    private String originCountry;

    public MetadataHeader name(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public MetadataHeader description(String description) {
        this.description = description;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public MetadataHeader originCountry(String originCountry) {
        this.originCountry = originCountry;
        return this;
    }

    @JsonProperty("origin_country")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getOriginCountry() { return originCountry; }
    public void setOriginCountry(String originCountry) { this.originCountry = originCountry; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataHeader that = (MetadataHeader) o;
        return super.equals(o) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.originCountry, that.originCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, originCountry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataHeader {\n");
        this.toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    }

}
