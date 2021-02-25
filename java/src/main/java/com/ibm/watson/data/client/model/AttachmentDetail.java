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
 * AttachmentDetail
 */
public class AttachmentDetail extends AttachmentHeader {

    private String attachmentId;
    private Date createdAt;
    private Boolean objectKeyIsReadOnly;
    private String datasourceType;
    private String url;
    private Boolean transferComplete;
    private Long size;
    private String creatorId;
    private MetadataUsage usage;
    private String href;

    public AttachmentDetail attachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("attachment_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAttachmentId() { return attachmentId; }
    public void setAttachmentId(String attachmentId) { this.attachmentId = attachmentId; }

    public AttachmentDetail createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public AttachmentDetail objectKeyIsReadOnly(Boolean objectKeyIsReadOnly) {
        this.objectKeyIsReadOnly = objectKeyIsReadOnly;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("object_key_is_read_only")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getObjectKeyIsReadOnly() { return objectKeyIsReadOnly; }
    public void setObjectKeyIsReadOnly(Boolean objectKeyIsReadOnly) { this.objectKeyIsReadOnly = objectKeyIsReadOnly; }

    public AttachmentDetail datasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("datasource_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDatasourceType() { return datasourceType; }
    public void setDatasourceType(String datasourceType) { this.datasourceType = datasourceType; }

    public AttachmentDetail url(String url) {
        this.url = url;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public AttachmentDetail transferComplete(Boolean transferComplete) {
        this.transferComplete = transferComplete;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("transfer_complete")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getTransferComplete() { return transferComplete; }
    public void setTransferComplete(Boolean transferComplete) { this.transferComplete = transferComplete; }

    public AttachmentDetail size(Long size) {
        this.size = size;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }

    public AttachmentDetail creatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    public AttachmentDetail usage(MetadataUsage usage) {
        this.usage = usage;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("usage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetadataUsage getUsage() { return usage; }
    public void setUsage(MetadataUsage usage) { this.usage = usage; }

    public AttachmentDetail href(String href) {
        this.href = href;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AttachmentDetail that = (AttachmentDetail) o;
        return super.equals(o) &&
                Objects.equals(attachmentId, that.attachmentId) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(objectKeyIsReadOnly, that.objectKeyIsReadOnly) &&
                Objects.equals(datasourceType, that.datasourceType) &&
                Objects.equals(url, that.url) &&
                Objects.equals(transferComplete, that.transferComplete) &&
                Objects.equals(size, that.size) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(usage, that.usage) &&
                Objects.equals(href, that.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attachmentId, createdAt, objectKeyIsReadOnly,
                datasourceType, url, transferComplete, size, creatorId, usage, href);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AttachmentDetail{");
        sb.append("class AttachmentDetail {\n");
        super.toString(sb);
        sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    objectKeyIsReadOnly: ").append(toIndentedString(objectKeyIsReadOnly)).append("\n");
        sb.append("    datasourceType: ").append(toIndentedString(datasourceType)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    transferComplete: ").append(toIndentedString(transferComplete)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
