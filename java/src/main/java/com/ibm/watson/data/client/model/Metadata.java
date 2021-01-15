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
 * Common metadata about all types and areas.
 */
public class Metadata {

    private List<String> tags;
    private String assetType;
    private AssetCategory assetCategory;

    public Metadata tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Metadata addTagsItem(String tagsItem) {
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

    public Metadata assetType(String assetType) {
        this.assetType = assetType;
        return this;
    }

    @JsonProperty("asset_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }

    public Metadata assetCategory(AssetCategory assetCategory) {
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
        Metadata that = (Metadata) o;
        return Objects.equals(this.tags, that.tags) &&
                Objects.equals(this.assetType, that.assetType) &&
                Objects.equals(this.assetCategory, that.assetCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, assetType, assetCategory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Metadata {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
        sb.append("    assetCategory: ").append(toIndentedString(assetCategory)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
