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
import java.util.List;
import java.util.Objects;

/**
 * AssetCommentPropertyModification
 */
public class AssetCommentPropertyModification {

    private String propertyName;
    private String oldValue;
    private String newValue;
    private String propertyType;
    private Long numberOfElements;
    private String additionalInfo;
    private String action;
    private String modId;
    private List<AssetCommentsModificationDetails> initialValues = null;

    public AssetCommentPropertyModification propertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }

    /**
     * Modified Property Name
     * @return propertyName
     **/
    @javax.annotation.Nullable
    @JsonProperty("property_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public AssetCommentPropertyModification oldValue(String oldValue) {
        this.oldValue = oldValue;
        return this;
    }

    /**
     * The old value of the property
     * @return oldValue
     **/
    @javax.annotation.Nullable
    @JsonProperty("old_value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOldValue() { return oldValue; }
    public void setOldValue(String oldValue) { this.oldValue = oldValue; }

    public AssetCommentPropertyModification newValue(String newValue) {
        this.newValue = newValue;
        return this;
    }

    /**
     * The new value of the property
     * @return newValue
     **/
    @javax.annotation.Nullable
    @JsonProperty("new_value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getNewValue() { return newValue; }
    public void setNewValue(String newValue) { this.newValue = newValue; }

    public AssetCommentPropertyModification propertyType(String propertyType) {
        this.propertyType = propertyType;
        return this;
    }

    /**
     * A type of the property
     * @return propertyType
     **/
    @javax.annotation.Nullable
    @JsonProperty("property_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPropertyType() { return propertyType; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }

    public AssetCommentPropertyModification numberOfElements(Long numberOfElements) {
        this.numberOfElements = numberOfElements;
        return this;
    }

    /**
     * Indicates number of elements in this collection
     * @return numberOfElements
     **/
    @javax.annotation.Nullable
    @JsonProperty("number_of_elements")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNumberOfElements() { return numberOfElements; }
    public void setNumberOfElements(Long numberOfElements) { this.numberOfElements = numberOfElements; }

    public AssetCommentPropertyModification additionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**
     * Additional info for the property, eg. for relationship it&#39;s a type of
     * second end of the relationship
     * @return additionalInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("additional_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAdditionalInfo() { return additionalInfo; }
    public void setAdditionalInfo(String additionalInfo) { this.additionalInfo = additionalInfo; }

    public AssetCommentPropertyModification action(String action) {
        this.action = action;
        return this;
    }

    /**
     * A type of an performed action
     * @return action
     **/
    @javax.annotation.Nullable
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public AssetCommentPropertyModification modId(String modId) {
        this.modId = modId;
        return this;
    }

    /**
     * Modification Id
     * @return modId
     **/
    @javax.annotation.Nullable
    @JsonProperty("mod_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModId() { return modId; }
    public void setModId(String modId) { this.modId = modId; }

    public AssetCommentPropertyModification initialValues(List<AssetCommentsModificationDetails> initialValues) {
        this.initialValues = initialValues;
        return this;
    }

    public AssetCommentPropertyModification addInitialValuesItem(AssetCommentsModificationDetails initialValuesItem) {
        if (this.initialValues == null) {
            this.initialValues = new ArrayList<>();
        }
        this.initialValues.add(initialValuesItem);
        return this;
    }

    /**
     * Initial Values
     * @return initialValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("initial_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AssetCommentsModificationDetails> getInitialValues() { return initialValues; }
    public void setInitialValues(List<AssetCommentsModificationDetails> initialValues) { this.initialValues = initialValues; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetCommentPropertyModification assetAggregatedCommentPropertyModification = (AssetCommentPropertyModification)o;
        return Objects.equals(this.propertyName, assetAggregatedCommentPropertyModification.propertyName) &&
                Objects.equals(this.oldValue, assetAggregatedCommentPropertyModification.oldValue) &&
                Objects.equals(this.newValue, assetAggregatedCommentPropertyModification.newValue) &&
                Objects.equals(this.propertyType, assetAggregatedCommentPropertyModification.propertyType) &&
                Objects.equals(this.numberOfElements, assetAggregatedCommentPropertyModification.numberOfElements) &&
                Objects.equals(this.additionalInfo, assetAggregatedCommentPropertyModification.additionalInfo) &&
                Objects.equals(this.action, assetAggregatedCommentPropertyModification.action) &&
                Objects.equals(this.modId, assetAggregatedCommentPropertyModification.modId) &&
                Objects.equals(this.initialValues, assetAggregatedCommentPropertyModification.initialValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, oldValue, newValue, propertyType,
                numberOfElements, additionalInfo, action, modId,
                initialValues);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetCommentPropertyModification {\n");
        sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
        sb.append("    oldValue: ").append(toIndentedString(oldValue)).append("\n");
        sb.append("    newValue: ").append(toIndentedString(newValue)).append("\n");
        sb.append("    propertyType: ").append(toIndentedString(propertyType)).append("\n");
        sb.append("    numberOfElements: ").append(toIndentedString(numberOfElements)).append("\n");
        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    modId: ").append(toIndentedString(modId)).append("\n");
        sb.append("    initialValues: ").append(toIndentedString(initialValues)).append("\n");
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
