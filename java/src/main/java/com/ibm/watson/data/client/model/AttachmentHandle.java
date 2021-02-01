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
 * AttachmentHandle
 */
public class AttachmentHandle {

    private String key;
    private String uploadId;
    private Long maxPartNum;

    public AttachmentHandle key(String key) {
        this.key = key;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public AttachmentHandle uploadId(String uploadId) {
        this.uploadId = uploadId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("upload_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUploadId() { return uploadId; }
    public void setUploadId(String uploadId) { this.uploadId = uploadId; }

    public AttachmentHandle maxPartNum(Long maxPartNum) {
        this.maxPartNum = maxPartNum;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("max_part_num")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getMaxPartNum() { return maxPartNum; }
    public void setMaxPartNum(Long maxPartNum) { this.maxPartNum = maxPartNum; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AttachmentHandle that = (AttachmentHandle)o;
        return Objects.equals(this.key, that.key) &&
                Objects.equals(this.uploadId, that.uploadId) &&
                Objects.equals(this.maxPartNum, that.maxPartNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, uploadId, maxPartNum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AttachmentHandle {\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    uploadId: ").append(toIndentedString(uploadId)).append("\n");
        sb.append("    maxPartNum: ").append(toIndentedString(maxPartNum)).append("\n");
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
