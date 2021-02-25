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
public class AttachmentRequest extends AttachmentHeader {

    private Integer dataPartitions;
    private Boolean privateUrl;
    private Boolean objectKeyIsReadOnly;

    public AttachmentRequest dataPartitions(Integer dataPartitions) {
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

    public AttachmentRequest privateUrl(Boolean privateUrl) {
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

    public AttachmentRequest objectKeyIsReadOnly(Boolean objectKeyIsReadOnly) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AttachmentRequest that = (AttachmentRequest)o;
        return super.equals(o) &&
                Objects.equals(this.dataPartitions, that.dataPartitions) &&
                Objects.equals(this.privateUrl, that.privateUrl) &&
                Objects.equals(this.objectKeyIsReadOnly, that.objectKeyIsReadOnly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataPartitions, privateUrl, objectKeyIsReadOnly);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Attachment {\n");
        super.toString(sb);
        sb.append("    dataPartitions: ").append(toIndentedString(dataPartitions)).append("\n");
        sb.append("    privateUrl: ").append(toIndentedString(privateUrl)).append("\n");
        sb.append("    objectKeyIsReadOnly: ").append(toIndentedString(objectKeyIsReadOnly)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
