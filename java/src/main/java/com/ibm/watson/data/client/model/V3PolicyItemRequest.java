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
 * Request for the POST and PUT /v3/enforcement/governed_item APIs
 */
public class V3PolicyItemRequest {

    private String itemId;
    private String itemType;
    private Object properties;
    private String containerId;
    private String parentId;
    private Long level;
    private String hierarchyId;

    public V3PolicyItemRequest itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * Get itemId
     * @return itemId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("item_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public V3PolicyItemRequest itemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    /**
     * Get itemType
     * @return itemType
     **/
    @javax.annotation.Nonnull
    @JsonProperty("item_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public V3PolicyItemRequest properties(Object properties) {
        this.properties = properties;
        return this;
    }

    /**
     * arbitrary json object for property information
     * @return properties
     **/
    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getProperties() {
        return properties;
    }
    public void setProperties(Object properties) {
        this.properties = properties;
    }

    /**
     * Get containerId
     * @return containerId
     **/
    @javax.annotation.Nullable
    @JsonProperty("container_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getContainerId() {
        return containerId;
    }
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    /**
     * Get parentId
     * @return parentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Get level
     * @return level
     **/
    @javax.annotation.Nullable
    @JsonProperty("level")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLevel() {
        return level;
    }
    public void setLevel(Long level) {
        this.level = level;
    }

    /**
     * Get hierarchyId
     * @return hierarchyId
     **/
    @javax.annotation.Nullable
    @JsonProperty("hierarchy_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHierarchyId() {
        return hierarchyId;
    }
    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3PolicyItemRequest v3PolicyItemRequest = (V3PolicyItemRequest) o;
        return Objects.equals(this.itemId, v3PolicyItemRequest.itemId) &&
                Objects.equals(this.itemType, v3PolicyItemRequest.itemType) &&
                Objects.equals(this.properties, v3PolicyItemRequest.properties) &&
                Objects.equals(this.containerId, v3PolicyItemRequest.containerId) &&
                Objects.equals(this.parentId, v3PolicyItemRequest.parentId) &&
                Objects.equals(this.level, v3PolicyItemRequest.level) &&
                Objects.equals(this.hierarchyId, v3PolicyItemRequest.hierarchyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemType, properties, containerId, parentId, level, hierarchyId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyItemRequest {\n");
        sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
        sb.append("    itemType: ").append(toIndentedString(itemType)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    hierarchyId: ").append(toIndentedString(hierarchyId)).append("\n");
        sb.append("}");
        return sb.toString();
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
