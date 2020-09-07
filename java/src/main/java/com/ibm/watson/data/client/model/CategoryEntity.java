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
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CategoryEntity
 */
public class CategoryEntity {

    private String longDescription;
    private List<String> stewardIds = null;
    private GlossaryObjectState state;
    private String defaultLocaleId;
    private List<CustomAttribute> customAttributes = null;
    private String parentCategoryId;
    private List<RelationshipObject> hasTypesCategoryRels = null;
    private List<RelationshipObject> groupedAssetsRels = null;
    private List<RelationshipObject> parentCategoryFor = null;

    public CategoryEntity longDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    /**
     * The long description of an artifact.
     * @return longDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("long_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public CategoryEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public CategoryEntity addStewardIdsItem(String stewardIdsItem) {
        if (this.stewardIds == null) {
            this.stewardIds = new ArrayList<>();
        }
        this.stewardIds.add(stewardIdsItem);
        return this;
    }

    /**
     * The stewards assigned to an artifact.
     * @return stewardIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("steward_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getStewardIds() { return stewardIds; }
    public void setStewardIds(List<String> stewardIds) { this.stewardIds = stewardIds; }

    public CategoryEntity state(GlossaryObjectState state) {
        this.state = state;
        return this;
    }

    /**
     * State of the artifact
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GlossaryObjectState getState() { return state; }
    public void setState(GlossaryObjectState state) { this.state = state; }

    public CategoryEntity defaultLocaleId(String defaultLocaleId) {
        this.defaultLocaleId = defaultLocaleId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("default_locale_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDefaultLocaleId() { return defaultLocaleId; }
    public void setDefaultLocaleId(String defaultLocaleId) { this.defaultLocaleId = defaultLocaleId; }

    public CategoryEntity customAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public CategoryEntity addCustomAttributesItem(CustomAttribute customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new ArrayList<>();
        }
        this.customAttributes.add(customAttributesItem);
        return this;
    }

    /**
     * List of custom attributes with their values.
     * @return customAttributes
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom_attributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttribute> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(List<CustomAttribute> customAttributes) { this.customAttributes = customAttributes; }

    public CategoryEntity parentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
        return this;
    }

    /**
     * Artifact ID of a parent category
     * @return parentCategoryId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_category_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentCategoryId() { return parentCategoryId; }
    public void setParentCategoryId(String parentCategoryId) { this.parentCategoryId = parentCategoryId; }

    public CategoryEntity hasTypesCategoryRels(List<RelationshipObject> hasTypesCategoryRels) {
        this.hasTypesCategoryRels = hasTypesCategoryRels;
        return this;
    }

    public CategoryEntity addHasTypesCategoryRelsItem(RelationshipObject hasTypesCategoryRelsItem) {
        if (this.hasTypesCategoryRels == null) {
            this.hasTypesCategoryRels = new ArrayList<>();
        }
        this.hasTypesCategoryRels.add(hasTypesCategoryRelsItem);
        return this;
    }

    /**
     * The list of child categories in the category type hierarchy.
     * @return hasTypesCategoryRels
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_category_rels")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipObject> getHasTypesCategoryRels() { return hasTypesCategoryRels; }
    public void setHasTypesCategoryRels(List<RelationshipObject> hasTypesCategoryRels) { this.hasTypesCategoryRels = hasTypesCategoryRels; }

    public CategoryEntity groupedAssetsRels(List<RelationshipObject> groupedAssetsRels) {
        this.groupedAssetsRels = groupedAssetsRels;
        return this;
    }

    public CategoryEntity addGroupedAssetsRelsItem(RelationshipObject groupedAssetsRelsItem) {
        if (this.groupedAssetsRels == null) {
            this.groupedAssetsRels = new ArrayList<>();
        }
        this.groupedAssetsRels.add(groupedAssetsRelsItem);
        return this;
    }

    /**
     * Assets grouped by category. If a certain asset type requires a workflow
     * process, only published assets of this type can belong to this list.
     * @return groupedAssetsRels
     **/
    @javax.annotation.Nullable
    @JsonProperty("grouped_assets_rels")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipObject> getGroupedAssetsRels() { return groupedAssetsRels; }
    public void setGroupedAssetsRels(List<RelationshipObject> groupedAssetsRels) { this.groupedAssetsRels = groupedAssetsRels; }

    public CategoryEntity parentCategoryFor(List<RelationshipObject> parentCategoryFor) {
        this.parentCategoryFor = parentCategoryFor;
        return this;
    }

    public CategoryEntity addParentCategoryForItem(RelationshipObject parentCategoryForItem) {
        if (this.parentCategoryFor == null) {
            this.parentCategoryFor = new ArrayList<>();
        }
        this.parentCategoryFor.add(parentCategoryForItem);
        return this;
    }

    /**
     * List of artifacts for which this category is a parent category. If a
     * certain asset type requires a workflow process, only published assets of
     * this type can belong to this list.
     * @return parentCategoryFor
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_category_for")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipObject> getParentCategoryFor() { return parentCategoryFor; }
    public void setParentCategoryFor(List<RelationshipObject> parentCategoryFor) { this.parentCategoryFor = parentCategoryFor; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CategoryEntity categoryEntity = (CategoryEntity)o;
        return Objects.equals(this.longDescription, categoryEntity.longDescription) &&
                Objects.equals(this.stewardIds, categoryEntity.stewardIds) &&
                Objects.equals(this.state, categoryEntity.state) &&
                Objects.equals(this.defaultLocaleId, categoryEntity.defaultLocaleId) &&
                Objects.equals(this.customAttributes, categoryEntity.customAttributes) &&
                Objects.equals(this.parentCategoryId, categoryEntity.parentCategoryId) &&
                Objects.equals(this.hasTypesCategoryRels, categoryEntity.hasTypesCategoryRels) &&
                Objects.equals(this.groupedAssetsRels, categoryEntity.groupedAssetsRels) &&
                Objects.equals(this.parentCategoryFor, categoryEntity.parentCategoryFor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longDescription, stewardIds, state, defaultLocaleId,
                customAttributes, parentCategoryId, hasTypesCategoryRels,
                groupedAssetsRels, parentCategoryFor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CategoryEntity {\n");
        sb.append("    longDescription: ").append(toIndentedString(longDescription)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    defaultLocaleId: ").append(toIndentedString(defaultLocaleId)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
        sb.append("    parentCategoryId: ").append(toIndentedString(parentCategoryId)).append("\n");
        sb.append("    hasTypesCategoryRels: ").append(toIndentedString(hasTypesCategoryRels)).append("\n");
        sb.append("    groupedAssetsRels: ").append(toIndentedString(groupedAssetsRels)).append("\n");
        sb.append("    parentCategoryFor: ").append(toIndentedString(parentCategoryFor)).append("\n");
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
