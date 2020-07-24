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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Headline metadata about an asset
 */
public class MetadataHeader {

    private String name;
    private String description;
    private List<String> tags;
    private String assetType;
    private String originCountry;
    private AssetCategory assetCategory;

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

    public MetadataHeader tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public MetadataHeader addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public MetadataHeader assetType(String assetType) {
        this.assetType = assetType;
        return this;
    }

    @JsonProperty("asset_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }

    public MetadataHeader originCountry(String originCountry) {
        this.originCountry = originCountry;
        return this;
    }

    @JsonProperty("origin_country")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getOriginCountry() { return originCountry; }
    public void setOriginCountry(String originCountry) { this.originCountry = originCountry; }

    public MetadataHeader assetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("asset_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AssetCategory getAssetCategory() { return assetCategory; }
    public void setAssetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataHeader that = (MetadataHeader) o;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.tags, that.tags) &&
                Objects.equals(this.assetType, that.assetType) &&
                Objects.equals(this.originCountry, that.originCountry) &&
                Objects.equals(this.assetCategory, that.assetCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, tags, assetType, originCountry, assetCategory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataHeader {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
        sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
        sb.append("    assetCategory: ").append(toIndentedString(assetCategory)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
