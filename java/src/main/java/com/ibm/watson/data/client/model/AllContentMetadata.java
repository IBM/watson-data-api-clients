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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * The metadata related to the attachments. 
 */
public class AllContentMetadata {

    private Integer totalCount;
    private List<ContentMetadata> attachments = new ArrayList<>();

    public AllContentMetadata totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * The number of attachments associated with the resource.
     * @return totalCount
     **/
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    public AllContentMetadata attachments(List<ContentMetadata> attachments) {
        this.attachments = attachments;
        return this;
    }

    public AllContentMetadata addAttachmentsItem(ContentMetadata attachmentsItem) {
        this.attachments.add(attachmentsItem);
        return this;
    }

    /**
     * Get attachments
     * @return attachments
     **/
    @JsonProperty("attachments")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<ContentMetadata> getAttachments() { return attachments; }
    public void setAttachments(List<ContentMetadata> attachments) { this.attachments = attachments; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AllContentMetadata allContentMetadata = (AllContentMetadata) o;
        return Objects.equals(this.totalCount, allContentMetadata.totalCount) &&
                Objects.equals(this.attachments, allContentMetadata.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCount, attachments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AllContentMetadata {\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
