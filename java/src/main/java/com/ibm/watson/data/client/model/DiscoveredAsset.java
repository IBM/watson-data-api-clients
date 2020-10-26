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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A discovered asset.
 */
public class DiscoveredAsset {

    private String id;
    private String type;
    private String name;
    private String description;
    private List<String> tags = null;
    private String path;
    private Boolean hasChildren;
    private Map<String, Object> details = null;

    public DiscoveredAsset id(String id) {
        this.id = id;
        return this;
    }

    /**
     * An ID for the asset.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public DiscoveredAsset type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the asset, such as SCHEMA, TABLE, FILE, or FOLDER.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public DiscoveredAsset name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A name for the asset.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DiscoveredAsset description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the asset.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DiscoveredAsset tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public DiscoveredAsset addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Tags associated with the asset.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public DiscoveredAsset path(String path) {
        this.path = path;
        return this;
    }

    /**
     * The path for the object which can be used to discover child assets.
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty("path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public DiscoveredAsset hasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
        return this;
    }

    /**
     * True if it is known that the asset has children. False if it is known that
     * the asset does not have children. If it is not known, or it is too expensive
     * to determine this, then this property will not be returned.
     * @return hasChildren
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_children")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getHasChildren() { return hasChildren; }
    public void setHasChildren(Boolean hasChildren) { this.hasChildren = hasChildren; }

    public DiscoveredAsset details(Map<String, Object> details) {
        this.details = details;
        return this;
    }

    public DiscoveredAsset putDetailsItem(String key, Object detailsItem) {
        if (this.details == null) {
            this.details = new HashMap<>();
        }
        this.details.put(key, detailsItem);
        return this;
    }

    /**
     * Details about a discovered asset.
     * @return details
     **/
    @javax.annotation.Nullable
    @JsonProperty("details")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getDetails() { return details; }
    public void setDetails(Map<String, Object> details) { this.details = details; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveredAsset discoveredAsset = (DiscoveredAsset)o;
        return Objects.equals(this.id, discoveredAsset.id) &&
                Objects.equals(this.type, discoveredAsset.type) &&
                Objects.equals(this.name, discoveredAsset.name) &&
                Objects.equals(this.description, discoveredAsset.description) &&
                Objects.equals(this.tags, discoveredAsset.tags) &&
                Objects.equals(this.path, discoveredAsset.path) &&
                Objects.equals(this.hasChildren, discoveredAsset.hasChildren) &&
                Objects.equals(this.details, discoveredAsset.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, description, tags, path, hasChildren,
                details);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveredAsset {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    hasChildren: ").append(toIndentedString(hasChildren)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
