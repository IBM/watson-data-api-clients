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
import java.util.ArrayList;
import java.util.List;

/**
 * V3PolicyItemResponseEntity
 */
public class V3PolicyItemResponseEntity {

    private String itemId;
    private String itemType;
    private Object properties;
    private String policyDescriptor;
    private List<String> categoryIds = null;
    private String containerId;
    private String resourcePath;
    private String parentId;
    private Long level;
    private String hierarchyId;

    public V3PolicyItemResponseEntity itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * Get itemId
     * @return itemId
     **/
    @javax.annotation.Nullable
    @JsonProperty("item_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public V3PolicyItemResponseEntity itemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    /**
     * Get itemType
     * @return itemType
     **/
    @javax.annotation.Nullable
    @JsonProperty("item_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public V3PolicyItemResponseEntity properties(Object properties) {
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
     * Get policyDescriptor
     * @return policyDescriptor
     **/
    @javax.annotation.Nullable
    @JsonProperty("policy_descriptor")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPolicyDescriptor() {
        return policyDescriptor;
    }
    public void setPolicyDescriptor(String policyDescriptor) {
        this.policyDescriptor = policyDescriptor;
    }

    public V3PolicyItemResponseEntity categoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
        return this;
    }

    public V3PolicyItemResponseEntity addCategoryIdsItem(String categoryIdsItem) {
        if (this.categoryIds == null) {
            this.categoryIds = new ArrayList<>();
        }
        this.categoryIds.add(categoryIdsItem);
        return this;
    }

    /**
     * Get categoryIds
     * @return categoryIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("category_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getCategoryIds() {
        return categoryIds;
    }
    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
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
     * Get resourcePath
     * @return resourcePath
     **/
    @javax.annotation.Nullable
    @JsonProperty("resource_path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getResourcePath() {
        return resourcePath;
    }
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
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
        V3PolicyItemResponseEntity v3PolicyItemResponseEntity = (V3PolicyItemResponseEntity) o;
        return Objects.equals(this.itemId, v3PolicyItemResponseEntity.itemId) &&
                Objects.equals(this.itemType, v3PolicyItemResponseEntity.itemType) &&
                Objects.equals(this.properties, v3PolicyItemResponseEntity.properties) &&
                Objects.equals(this.policyDescriptor, v3PolicyItemResponseEntity.policyDescriptor) &&
                Objects.equals(this.categoryIds, v3PolicyItemResponseEntity.categoryIds) &&
                Objects.equals(this.containerId, v3PolicyItemResponseEntity.containerId) &&
                Objects.equals(this.resourcePath, v3PolicyItemResponseEntity.resourcePath) &&
                Objects.equals(this.parentId, v3PolicyItemResponseEntity.parentId) &&
                Objects.equals(this.level, v3PolicyItemResponseEntity.level) &&
                Objects.equals(this.hierarchyId, v3PolicyItemResponseEntity.hierarchyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemType, properties, policyDescriptor, categoryIds, containerId, resourcePath, parentId, level, hierarchyId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyItemResponseEntity {\n");
        sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
        sb.append("    itemType: ").append(toIndentedString(itemType)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    policyDescriptor: ").append(toIndentedString(policyDescriptor)).append("\n");
        sb.append("    categoryIds: ").append(toIndentedString(categoryIds)).append("\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    resourcePath: ").append(toIndentedString(resourcePath)).append("\n");
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
