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
import com.ibm.watson.data.client.model.enums.AssetCategory;

import java.util.Objects;

/**
 * Attachment
 */
public class AttachmentHeader {

    private String assetType;
    private String name;
    private String description;
    private String mime;
    private Long testDoc;
    private String connectionId;
    private String connectionPath;
    private String objectKey;
    private Object userData;
    private Boolean isPartitioned;
    private AssetCategory assetCategory;

    public AttachmentHeader assetType(String assetType) {
        this.assetType = assetType;
        return this;
    }

    /**
     * Get assetType
     * @return assetType
     **/
    @JsonProperty("asset_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }

    public AttachmentHeader name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public AttachmentHeader description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public AttachmentHeader mime(String mime) {
        this.mime = mime;
        return this;
    }

    /**
     * Get mime
     * @return mime
     **/
    @javax.annotation.Nullable
    @JsonProperty("mime")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMime() { return mime; }
    public void setMime(String mime) { this.mime = mime; }

    public AttachmentHeader testDoc(Long testDoc) {
        this.testDoc = testDoc;
        return this;
    }

    /**
     * Get testDoc
     * @return testDoc
     **/
    @javax.annotation.Nullable
    @JsonProperty("test_doc")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTestDoc() { return testDoc; }
    public void setTestDoc(Long testDoc) { this.testDoc = testDoc; }

    public AttachmentHeader connectionId(String connectionId) {
        this.connectionId = connectionId;
        return this;
    }

    /**
     * Get connectionId
     * @return connectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("connection_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getConnectionId() { return connectionId; }
    public void setConnectionId(String connectionId) { this.connectionId = connectionId; }

    public AttachmentHeader connectionPath(String connectionPath) {
        this.connectionPath = connectionPath;
        return this;
    }

    /**
     * Get connectionPath
     * @return connectionPath
     **/
    @javax.annotation.Nullable
    @JsonProperty("connection_path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getConnectionPath() { return connectionPath; }
    public void setConnectionPath(String connectionPath) { this.connectionPath = connectionPath; }

    public AttachmentHeader objectKey(String objectKey) {
        this.objectKey = objectKey;
        return this;
    }

    /**
     * Get objectKey
     * @return objectKey
     **/
    @javax.annotation.Nullable
    @JsonProperty("object_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getObjectKey() { return objectKey; }
    public void setObjectKey(String objectKey) { this.objectKey = objectKey; }

    public AttachmentHeader userData(Object userData) {
        this.userData = userData;
        return this;
    }

    /**
     * Get userData
     * @return userData
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getUserData() { return userData; }
    public void setUserData(Object userData) { this.userData = userData; }

    public AttachmentHeader isPartitioned(Boolean isPartitioned) {
        this.isPartitioned = isPartitioned;
        return this;
    }

    /**
     * Get isPartitioned
     * @return isPartitioned
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_partitioned")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsPartitioned() { return isPartitioned; }
    public void setIsPartitioned(Boolean isPartitioned) { this.isPartitioned = isPartitioned; }

    public AttachmentHeader assetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
        return this;
    }

    /**
     * Get the asset category
     * @return assetCategory
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AssetCategory getAssetCategory() { return assetCategory; }
    public void setAssetCategory(AssetCategory assetCategory) { this.assetCategory = assetCategory; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AttachmentHeader that = (AttachmentHeader)o;
        return Objects.equals(this.assetType, that.assetType) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.mime, that.mime) &&
                Objects.equals(this.testDoc, that.testDoc) &&
                Objects.equals(this.connectionId, that.connectionId) &&
                Objects.equals(this.connectionPath, that.connectionPath) &&
                Objects.equals(this.objectKey, that.objectKey) &&
                Objects.equals(this.userData, that.userData) &&
                Objects.equals(this.isPartitioned, that.isPartitioned) &&
                Objects.equals(this.assetCategory, that.assetCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetType, name, description, mime,
                testDoc, connectionId, connectionPath, objectKey, userData, isPartitioned, assetCategory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Attachment {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    mime: ").append(toIndentedString(mime)).append("\n");
        sb.append("    testDoc: ").append(toIndentedString(testDoc)).append("\n");
        sb.append("    connectionId: ").append(toIndentedString(connectionId)).append("\n");
        sb.append("    connectionPath: ").append(toIndentedString(connectionPath)).append("\n");
        sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
        sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
        sb.append("    isPartitioned: ").append(toIndentedString(isPartitioned)).append("\n");
        sb.append("    assetCategory: ").append(toIndentedString(assetCategory)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
