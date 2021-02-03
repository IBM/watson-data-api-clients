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
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

/**
 * ParentRelationshipEntity
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class ParentRelationshipEntity extends AbstractRelationshipEntity {

    private String parentId;
    private String parentGlobalId;
    private String parentName;
    private String parentHref;
    private Boolean parentEnabled;
    private String childId;
    private String childCategoryId;
    private String childGlobalId;
    private String childName;
    private String childHref;

    public ParentRelationshipEntity parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * ID of the parent artifact.
     * @return parentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentId() { return parentId; }
    public void setParentId(String parentId) { this.parentId = parentId; }

    public ParentRelationshipEntity parentGlobalId(String parentGlobalId) {
        this.parentGlobalId = parentGlobalId;
        return this;
    }

    /**
     * Global ID of the parent artifact.
     * @return parentGlobalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentGlobalId() { return parentGlobalId; }
    public void setParentGlobalId(String parentGlobalId) { this.parentGlobalId = parentGlobalId; }

    public ParentRelationshipEntity parentName(String parentName) {
        this.parentName = parentName;
        return this;
    }

    /**
     * Name of the parent artifact.
     * @return parentName
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentName() { return parentName; }
    public void setParentName(String parentName) { this.parentName = parentName; }

    public ParentRelationshipEntity parentHref(String parentHref) {
        this.parentHref = parentHref;
        return this;
    }

    /**
     * The URI to access the parent artifact.
     * @return parentHref
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentHref() { return parentHref; }
    public void setParentHref(String parentHref) { this.parentHref = parentHref; }

    public ParentRelationshipEntity parentEnabled(Boolean parentEnabled) {
        this.parentEnabled = parentEnabled;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("parent_enabled")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getParentEnabled() { return parentEnabled; }
    public void setParentEnabled(Boolean parentEnabled) { this.parentEnabled = parentEnabled; }

    public ParentRelationshipEntity childId(String childId) {
        this.childId = childId;
        return this;
    }

    /**
     * ID of the child artifact.
     * @return childId
     **/
    @javax.annotation.Nullable
    @JsonProperty("child_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getChildId() { return childId; }
    public void setChildId(String childId) { this.childId = childId; }

    public ParentRelationshipEntity childCategoryId(String childCategoryId) {
        this.childCategoryId = childCategoryId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("child_category_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getChildCategoryId() { return childCategoryId; }
    public void setChildCategoryId(String childCategoryId) { this.childCategoryId = childCategoryId; }

    public ParentRelationshipEntity childGlobalId(String childGlobalId) {
        this.childGlobalId = childGlobalId;
        return this;
    }

    /**
     * Global ID of the child artifact.
     * @return childGlobalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("child_global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getChildGlobalId() { return childGlobalId; }
    public void setChildGlobalId(String childGlobalId) { this.childGlobalId = childGlobalId; }

    public ParentRelationshipEntity childName(String childName) {
        this.childName = childName;
        return this;
    }

    /**
     * Name of the child artifact.
     * @return childName
     **/
    @javax.annotation.Nullable
    @JsonProperty("child_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getChildName() { return childName; }
    public void setChildName(String childName) { this.childName = childName; }

    public ParentRelationshipEntity childHref(String childHref) {
        this.childHref = childHref;
        return this;
    }

    /**
     * The URI to access the child artifact.
     * @return childHref
     **/
    @javax.annotation.Nullable
    @JsonProperty("child_href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getChildHref() { return childHref; }
    public void setChildHref(String childHref) { this.childHref = childHref; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ParentRelationshipEntity parentRelationshipEntity = (ParentRelationshipEntity)o;
        return super.equals(o) &&
                Objects.equals(this.parentId, parentRelationshipEntity.parentId) &&
                Objects.equals(this.parentGlobalId, parentRelationshipEntity.parentGlobalId) &&
                Objects.equals(this.parentName, parentRelationshipEntity.parentName) &&
                Objects.equals(this.parentHref, parentRelationshipEntity.parentHref) &&
                Objects.equals(this.parentEnabled, parentRelationshipEntity.parentEnabled) &&
                Objects.equals(this.childId, parentRelationshipEntity.childId) &&
                Objects.equals(this.childCategoryId, parentRelationshipEntity.childCategoryId) &&
                Objects.equals(this.childGlobalId, parentRelationshipEntity.childGlobalId) &&
                Objects.equals(this.childName, parentRelationshipEntity.childName) &&
                Objects.equals(this.childHref, parentRelationshipEntity.childHref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parentId, parentGlobalId, parentName,
                parentHref, parentEnabled, childId, childCategoryId, childGlobalId,
                childName, childHref);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ParentRelationshipEntity {\n");
        super.toString(sb);
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    parentGlobalId: ").append(toIndentedString(parentGlobalId)).append("\n");
        sb.append("    parentName: ").append(toIndentedString(parentName)).append("\n");
        sb.append("    parentHref: ").append(toIndentedString(parentHref)).append("\n");
        sb.append("    parentEnabled: ").append(toIndentedString(parentEnabled)).append("\n");
        sb.append("    childId: ").append(toIndentedString(childId)).append("\n");
        sb.append("    childCategoryId: ").append(toIndentedString(childCategoryId)).append("\n");
        sb.append("    childGlobalId: ").append(toIndentedString(childGlobalId)).append("\n");
        sb.append("    childName: ").append(toIndentedString(childName)).append("\n");
        sb.append("    childHref: ").append(toIndentedString(childHref)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
