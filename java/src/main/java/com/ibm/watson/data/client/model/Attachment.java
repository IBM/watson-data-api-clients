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

import java.util.Date;
import java.util.Objects;

/**
 * Attachment
 */
public class Attachment extends AttachmentHeader {

    private String id;
    private Double version;
    private String attachmentId;
    private String datasourceType;
    // TODO: this should probably be an enumeration
    private String attachmentType;
    private String href;
    private Date createdAt;
    private String message;
    private String creatorId;
    private Long createTime;
    private Long size;
    private Boolean isRemote;
    private Boolean isManaged;
    private Boolean isReferenced;
    private Boolean isObjectKeyReadOnly;
    private Boolean isUserProvidedPathKey;
    private Boolean transferComplete;
    private Long completeTimeTicks;
    private AttachmentHandle handle;
    private MetadataUsage usage;

    public Attachment id(String id) {
        this.id = id;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Attachment attachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
        return this;
    }

    /**
     * Get attachmentId
     * @return attachmentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("attachment_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAttachmentId() { return attachmentId; }
    public void setAttachmentId(String attachmentId) { this.attachmentId = attachmentId; }

    public Attachment version(Double version) {
        this.version = version;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getVersion() { return version; }
    public void setVersion(Double version) { this.version = version; }

    public Attachment datasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
        return this;
    }

    /**
     * Get datasourceType GUID
     * @return datasourceType
     */
    @javax.annotation.Nullable
    @JsonProperty("datasource_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDatasourceType() { return datasourceType; }
    public void setDatasourceType(String datasourceType) { this.datasourceType = datasourceType; }

    public Attachment attachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
        return this;
    }

    /**
     * Get attachment type
     * @return attachmentType
     */
    @javax.annotation.Nullable
    @JsonProperty("attachment_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAttachmentType() { return attachmentType; }
    public void setAttachmentType(String attachmentType) { this.attachmentType = attachmentType; }

    public Attachment href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get href
     * @return href
     */
    @javax.annotation.Nullable
    @JsonProperty("href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public Attachment createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Attachment message(String message) {
        this.message = message;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Attachment creatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    public Attachment createTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("create_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCreateTime() { return createTime; }
    public void setCreateTime(Long createTime) { this.createTime = createTime; }

    public Attachment size(Long size) {
        this.size = size;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }

    public Attachment isRemote(Boolean isRemote) {
        this.isRemote = isRemote;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("is_remote")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getRemote() { return isRemote; }
    public void setRemote(Boolean remote) { isRemote = remote; }

    public Attachment isManaged(Boolean isManaged) {
        this.isManaged = isManaged;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("is_managed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getManaged() { return isManaged; }
    public void setManaged(Boolean managed) { isManaged = managed; }

    public Attachment isReferenced(Boolean isReferenced) {
        this.isReferenced = isReferenced;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("is_referenced")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getReferenced() { return isReferenced; }
    public void setReferenced(Boolean referenced) { isReferenced = referenced; }

    public Attachment isObjectKeyReadOnly(Boolean isObjectKeyReadOnly) {
        this.isObjectKeyReadOnly = isObjectKeyReadOnly;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("is_object_key_read_only")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getObjectKeyReadOnly() { return isObjectKeyReadOnly; }
    public void setObjectKeyReadOnly(Boolean objectKeyReadOnly) { isObjectKeyReadOnly = objectKeyReadOnly; }

    public Attachment isUserProvidedPathKey(Boolean isUserProvidedPathKey) {
        this.isUserProvidedPathKey = isUserProvidedPathKey;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("is_user_provided_path_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getUserProvidedPathKey() { return isUserProvidedPathKey; }
    public void setUserProvidedPathKey(Boolean userProvidedPathKey) { isUserProvidedPathKey = userProvidedPathKey; }

    public Attachment transferComplete(Boolean transferComplete) {
        this.transferComplete = transferComplete;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("transfer_complete")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getTransferComplete() { return transferComplete; }
    public void setTransferComplete(Boolean transferComplete) { this.transferComplete = transferComplete; }

    public Attachment completeTimeTicks(Long completeTimeTicks) {
        this.completeTimeTicks = completeTimeTicks;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("complete_time_ticks")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCompleteTimeTicks() { return completeTimeTicks; }
    public void setCompleteTimeTicks(Long completeTimeTicks) { this.completeTimeTicks = completeTimeTicks; }

    public Attachment handle(AttachmentHandle handle) {
        this.handle = handle;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("handle")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AttachmentHandle getHandle() { return handle; }
    public void setHandle(AttachmentHandle handle) { this.handle = handle; }

    public Attachment usage(MetadataUsage usage) {
        this.usage = usage;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("usage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetadataUsage getUsage() { return usage; }
    public void setUsage(MetadataUsage usage) { this.usage = usage; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Attachment that = (Attachment)o;
        return super.equals(o) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.attachmentId, that.attachmentId) &&
                Objects.equals(this.datasourceType, that.datasourceType) &&
                Objects.equals(this.attachmentType, that.attachmentType) &&
                Objects.equals(this.href, that.href) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.message, that.message) &&
                Objects.equals(this.creatorId, that.creatorId) &&
                Objects.equals(this.createTime, that.createTime) &&
                Objects.equals(this.size, that.size) &&
                Objects.equals(this.isRemote, that.isRemote) &&
                Objects.equals(this.isManaged, that.isManaged) &&
                Objects.equals(this.isReferenced, that.isReferenced) &&
                Objects.equals(this.isObjectKeyReadOnly, that.isObjectKeyReadOnly) &&
                Objects.equals(this.isUserProvidedPathKey, that.isUserProvidedPathKey) &&
                Objects.equals(this.transferComplete, that.transferComplete) &&
                Objects.equals(this.completeTimeTicks, that.completeTimeTicks) &&
                Objects.equals(this.handle, that.handle) &&
                Objects.equals(this.usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, version, attachmentId, datasourceType, attachmentType, href,
                createdAt, message, creatorId, createTime, size, isRemote, isManaged, isReferenced, isObjectKeyReadOnly,
                isUserProvidedPathKey, transferComplete, completeTimeTicks, handle, usage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Attachment {\n");
        super.toString(sb);
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
        sb.append("    datasourceType: ").append(toIndentedString(datasourceType)).append("\n");
        sb.append("    attachmentType: ").append(toIndentedString(attachmentType)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    isRemote: ").append(toIndentedString(isRemote)).append("\n");
        sb.append("    isManaged: ").append(toIndentedString(isManaged)).append("\n");
        sb.append("    isReferenced: ").append(toIndentedString(isReferenced)).append("\n");
        sb.append("    isObjectKeyReadOnly: ").append(toIndentedString(isObjectKeyReadOnly)).append("\n");
        sb.append("    isUserProvidedPathKey: ").append(toIndentedString(isUserProvidedPathKey)).append("\n");
        sb.append("    transferComplete: ").append(toIndentedString(transferComplete)).append("\n");
        sb.append("    completeTimeTicks: ").append(toIndentedString(completeTimeTicks)).append("\n");
        sb.append("    handle: ").append(toIndentedString(handle)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
