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
 * Attachment
 */
public class Attachment {

    private String assetType;
    private String name;
    private String description;
    private String mime;
    private Integer dataPartitions;
    private Long testDoc;
    private Boolean privateUrl;
    private String connectionId;
    private String connectionPath;
    private String objectKey;
    private Boolean objectKeyIsReadOnly;
    private Object userData;
    private Boolean isPartitioned;

    public Attachment assetType(String assetType) {
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

    public Attachment name(String name) {
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

    public Attachment description(String description) {
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

    public Attachment mime(String mime) {
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

    public Attachment dataPartitions(Integer dataPartitions) {
        this.dataPartitions = dataPartitions;
        return this;
    }

    /**
     * Get dataPartitions
     * @return dataPartitions
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_partitions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getDataPartitions() { return dataPartitions; }
    public void setDataPartitions(Integer dataPartitions) { this.dataPartitions = dataPartitions; }

    public Attachment testDoc(Long testDoc) {
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

    public Attachment privateUrl(Boolean privateUrl) {
        this.privateUrl = privateUrl;
        return this;
    }

    /**
     * Get privateUrl
     * @return privateUrl
     **/
    @javax.annotation.Nullable
    @JsonProperty("private_url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getPrivateUrl() { return privateUrl; }
    public void setPrivateUrl(Boolean privateUrl) { this.privateUrl = privateUrl; }

    public Attachment connectionId(String connectionId) {
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

    public Attachment connectionPath(String connectionPath) {
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

    public Attachment objectKey(String objectKey) {
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

    public Attachment objectKeyIsReadOnly(Boolean objectKeyIsReadOnly) {
        this.objectKeyIsReadOnly = objectKeyIsReadOnly;
        return this;
    }

    /**
     * Get objectKeyIsReadOnly
     * @return objectKeyIsReadOnly
     **/
    @javax.annotation.Nullable
    @JsonProperty("object_key_is_read_only")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getObjectKeyIsReadOnly() { return objectKeyIsReadOnly; }
    public void setObjectKeyIsReadOnly(Boolean objectKeyIsReadOnly) { this.objectKeyIsReadOnly = objectKeyIsReadOnly; }

    public Attachment userData(Object userData) {
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

    public Attachment isPartitioned(Boolean isPartitioned) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Attachment attachment = (Attachment)o;
        return Objects.equals(this.assetType, attachment.assetType) &&
                Objects.equals(this.name, attachment.name) &&
                Objects.equals(this.description, attachment.description) &&
                Objects.equals(this.mime, attachment.mime) &&
                Objects.equals(this.dataPartitions, attachment.dataPartitions) &&
                Objects.equals(this.testDoc, attachment.testDoc) &&
                Objects.equals(this.privateUrl, attachment.privateUrl) &&
                Objects.equals(this.connectionId, attachment.connectionId) &&
                Objects.equals(this.connectionPath, attachment.connectionPath) &&
                Objects.equals(this.objectKey, attachment.objectKey) &&
                Objects.equals(this.objectKeyIsReadOnly, attachment.objectKeyIsReadOnly) &&
                Objects.equals(this.userData, attachment.userData) &&
                Objects.equals(this.isPartitioned, attachment.isPartitioned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetType, name, description, mime, dataPartitions,
                testDoc, privateUrl, connectionId, connectionPath,
                objectKey, objectKeyIsReadOnly, userData,
                isPartitioned);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Attachment {\n");
        sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    mime: ").append(toIndentedString(mime)).append("\n");
        sb.append("    dataPartitions: ").append(toIndentedString(dataPartitions)).append("\n");
        sb.append("    testDoc: ").append(toIndentedString(testDoc)).append("\n");
        sb.append("    privateUrl: ").append(toIndentedString(privateUrl)).append("\n");
        sb.append("    connectionId: ").append(toIndentedString(connectionId)).append("\n");
        sb.append("    connectionPath: ").append(toIndentedString(connectionPath)).append("\n");
        sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
        sb.append("    objectKeyIsReadOnly: ").append(toIndentedString(objectKeyIsReadOnly)).append("\n");
        sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
        sb.append("    isPartitioned: ").append(toIndentedString(isPartitioned)).append("\n");
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
