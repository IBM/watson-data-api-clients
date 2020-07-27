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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Asset Type Relationship Model
 */
public class AssetTypeRelationship {

    private String key;
    private String targetAssetType;

    /**
     * Determines processing of the source object when a reference target is
     * deleted.  Allowed values: CASCADE - delete the object that contains the
     * reference, DISCONNECT - disconnect the reference to the target asset.
     * IGNORE - leave the reference to the target asset unmodified so it continues
     * to point to the deleted asset.  This creates a dangling reference. Default:
     * IGNORE
     */
    public enum OnDeleteTargetEnum {
        CASCADE("CASCADE"),

        DISCONNECT("DISCONNECT"),

        IGNORE("IGNORE");

        private String value;

        OnDeleteTargetEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OnDeleteTargetEnum fromValue(String value) {
            for (OnDeleteTargetEnum b : OnDeleteTargetEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private OnDeleteTargetEnum onDeleteTarget;

    /**
     * Determines processing of the reference target when the source object is
     * deleted.  Allowed values: CASCADE - delete the referenced object, IGNORE -
     * do not delete the referenced object.  Default: IGNORE
     */
    public enum OnDeleteEnum {
        CASCADE("CASCADE"),

        IGNORE("IGNORE");

        private String value;

        OnDeleteEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OnDeleteEnum fromValue(String value) {
            for (OnDeleteEnum b : OnDeleteEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private OnDeleteEnum onDelete;

    /**
     * Determines processing of the source object when a reference target is
     * cloned.  Allowed values: CASCADE - clone the object that contains the
     * reference, IGNORE - ignore the reference.  Default: IGNORE
     */
    public enum OnCloneTargetEnum {
        CASCADE("CASCADE"),

        IGNORE("IGNORE");

        private String value;

        OnCloneTargetEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OnCloneTargetEnum fromValue(String value) {
            for (OnCloneTargetEnum b : OnCloneTargetEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private OnCloneTargetEnum onCloneTarget;

    public AssetTypeRelationship key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Path to the JSON attribute containing the asset ID of the target asset, eg. "connection_id"
     * @return key
     **/
    @JsonProperty("key")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public AssetTypeRelationship targetAssetType(String targetAssetType) {
        this.targetAssetType = targetAssetType;
        return this;
    }

    /**
     * Asset type of target asset, eg. "connection"
     * @return targetAssetType
     **/
    @JsonProperty("target_asset_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTargetAssetType() { return targetAssetType; }
    public void setTargetAssetType(String targetAssetType) { this.targetAssetType = targetAssetType; }

    public AssetTypeRelationship onDeleteTarget(OnDeleteTargetEnum onDeleteTarget) {
        this.onDeleteTarget = onDeleteTarget;
        return this;
    }

    /**
     * Determines processing of the source object when a reference target is
     *deleted.  Allowed values: CASCADE - delete the object that contains the
     *reference, DISCONNECT - disconnect the reference to the target asset. IGNORE
     *- leave the reference to the target asset unmodified so it continues to
     *point to the deleted asset.  This creates a dangling reference.  Default:
     *IGNORE
     * @return onDeleteTarget
     **/
    @javax.annotation.Nullable
    @JsonProperty("on_delete_target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OnDeleteTargetEnum getOnDeleteTarget() { return onDeleteTarget; }
    public void setOnDeleteTarget(OnDeleteTargetEnum onDeleteTarget) { this.onDeleteTarget = onDeleteTarget; }

    public AssetTypeRelationship onDelete(OnDeleteEnum onDelete) {
        this.onDelete = onDelete;
        return this;
    }

    /**
     * Determines processing of the reference target when the source object is
     *deleted.  Allowed values: CASCADE - delete the referenced object, IGNORE -
     *do not delete the referenced object.  Default: IGNORE
     * @return onDelete
     **/
    @javax.annotation.Nullable
    @JsonProperty("on_delete")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OnDeleteEnum getOnDelete() { return onDelete; }
    public void setOnDelete(OnDeleteEnum onDelete) { this.onDelete = onDelete; }

    public AssetTypeRelationship onCloneTarget(OnCloneTargetEnum onCloneTarget) {
        this.onCloneTarget = onCloneTarget;
        return this;
    }

    /**
     * Determines processing of the source object when a reference target is
     *cloned.  Allowed values: CASCADE - clone the object that contains the
     *reference, IGNORE - ignore the reference.  Default: IGNORE
     * @return onCloneTarget
     **/
    @javax.annotation.Nullable
    @JsonProperty("on_clone_target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OnCloneTargetEnum getOnCloneTarget() { return onCloneTarget; }
    public void setOnCloneTarget(OnCloneTargetEnum onCloneTarget) { this.onCloneTarget = onCloneTarget; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetTypeRelationship assetTypeRelationship = (AssetTypeRelationship)o;
        return Objects.equals(this.key, assetTypeRelationship.key) &&
                Objects.equals(this.targetAssetType, assetTypeRelationship.targetAssetType) &&
                Objects.equals(this.onDeleteTarget, assetTypeRelationship.onDeleteTarget) &&
                Objects.equals(this.onDelete, assetTypeRelationship.onDelete) &&
                Objects.equals(this.onCloneTarget, assetTypeRelationship.onCloneTarget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, targetAssetType, onDeleteTarget, onDelete,
                onCloneTarget);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetTypeRelationship {\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    targetAssetType: ").append(toIndentedString(targetAssetType)).append("\n");
        sb.append("    onDeleteTarget: ").append(toIndentedString(onDeleteTarget)).append("\n");
        sb.append("    onDelete: ").append(toIndentedString(onDelete)).append("\n");
        sb.append("    onCloneTarget: ").append(toIndentedString(onCloneTarget)).append("\n");
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
