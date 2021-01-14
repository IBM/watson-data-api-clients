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

import java.util.*;

/**
 * Asset Model
 */
public class Asset {

    private MetadataAsset metadata;
    private Map<String, AbstractAssetEntity> entity = null;
    private List<Attachment> attachments = null;

    public Asset metadata(MetadataAsset metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public MetadataAsset getMetadata() { return metadata; }
    public void setMetadata(MetadataAsset metadata) { this.metadata = metadata; }

    public Asset entity(Map<String, AbstractAssetEntity> entity) {
        this.entity = entity;
        return this;
    }

    public Asset putEntityItem(String key, AbstractAssetEntity entityItem) {
        if (this.entity == null) {
            this.entity = new HashMap<>();
        }
        this.entity.put(key, entityItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, AbstractAssetEntity> getEntity() { return entity; }
    public void setEntity(Map<String, AbstractAssetEntity> entity) { this.entity = entity; }

    public Asset attachments(List<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Asset addAttachmentsItem(Attachment attachmentsItem) {
        if (this.attachments == null) {
            this.attachments = new ArrayList<>();
        }
        this.attachments.add(attachmentsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("attachments")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Attachment> getAttachments() { return attachments; }
    public void setAttachments(List<Attachment> attachments) { this.attachments = attachments; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Asset asset = (Asset)o;
        return Objects.equals(this.metadata, asset.metadata) &&
                Objects.equals(this.entity, asset.entity) &&
                Objects.equals(this.attachments, asset.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, entity, attachments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Asset {\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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
