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
 * Asset Type Field Model
 */
public class AssetTypeField {

    private String key;
    private String type;
    private Boolean facet;
    private Boolean isArray;
    private String searchPath;
    private Boolean isSearchableAcrossTypes;

    public AssetTypeField key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Asset type field key
     * @return key
     **/
    @JsonProperty("key")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public AssetTypeField type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Asset type field type
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public AssetTypeField facet(Boolean facet) {
        this.facet = facet;
        return this;
    }

    /**
     * Asset type field support facet search
     * @return facet
     **/
    @javax.annotation.Nullable
    @JsonProperty("facet")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getFacet() { return facet; }
    public void setFacet(Boolean facet) { this.facet = facet; }

    public AssetTypeField isArray(Boolean isArray) {
        this.isArray = isArray;
        return this;
    }

    /**
     * Get isArray
     * @return isArray
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_array")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsArray() { return isArray; }
    public void setIsArray(Boolean isArray) { this.isArray = isArray; }

    public AssetTypeField searchPath(String searchPath) {
        this.searchPath = searchPath;
        return this;
    }

    /**
     * A json path that leads to the field to be indexed, for example 'asset.columns[].*.name'.
     * @return searchPath
     **/
    @javax.annotation.Nullable
    @JsonProperty("search_path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSearchPath() { return searchPath; }
    public void setSearchPath(String searchPath) { this.searchPath = searchPath; }

    public AssetTypeField isSearchableAcrossTypes(Boolean isSearchableAcrossTypes) {
        this.isSearchableAcrossTypes = isSearchableAcrossTypes;
        return this;
    }

    /**
     * indicates whether this field is to be searchable using full-text search
     * @return isSearchableAcrossTypes
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_searchable_across_types")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsSearchableAcrossTypes() { return isSearchableAcrossTypes; }
    public void setIsSearchableAcrossTypes(Boolean isSearchableAcrossTypes) { this.isSearchableAcrossTypes = isSearchableAcrossTypes; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetTypeField assetTypeField = (AssetTypeField)o;
        return Objects.equals(this.key, assetTypeField.key) &&
                Objects.equals(this.type, assetTypeField.type) &&
                Objects.equals(this.facet, assetTypeField.facet) &&
                Objects.equals(this.isArray, assetTypeField.isArray) &&
                Objects.equals(this.searchPath, assetTypeField.searchPath) &&
                Objects.equals(this.isSearchableAcrossTypes, assetTypeField.isSearchableAcrossTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, type, facet, isArray, searchPath,
                isSearchableAcrossTypes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetTypeField {\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    facet: ").append(toIndentedString(facet)).append("\n");
        sb.append("    isArray: ").append(toIndentedString(isArray)).append("\n");
        sb.append("    searchPath: ").append(toIndentedString(searchPath)).append("\n");
        sb.append("    isSearchableAcrossTypes: ").append(toIndentedString(isSearchableAcrossTypes)).append("\n");
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
