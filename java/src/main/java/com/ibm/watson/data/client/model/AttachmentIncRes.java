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
 * AttachmentIncRes
 */
public class AttachmentIncRes {

    private Integer dataPartitions;
    private Boolean privateUrl;

    public AttachmentIncRes dataPartitions(Integer dataPartitions) {
        this.dataPartitions = dataPartitions;
        return this;
    }

    /**
     * Get dataPartitions
     * @return dataPartitions
     **/
    @JsonProperty("data_partitions")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getDataPartitions() { return dataPartitions; }
    public void setDataPartitions(Integer dataPartitions) { this.dataPartitions = dataPartitions; }

    public AttachmentIncRes privateUrl(Boolean privateUrl) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AttachmentIncRes attachmentIncRes = (AttachmentIncRes)o;
        return Objects.equals(this.dataPartitions,
                attachmentIncRes.dataPartitions) &&
                Objects.equals(this.privateUrl, attachmentIncRes.privateUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataPartitions, privateUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AttachmentIncRes {\n");
        sb.append("    dataPartitions: ").append(toIndentedString(dataPartitions)).append("\n");
        sb.append("    privateUrl: ").append(toIndentedString(privateUrl)).append("\n");
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
