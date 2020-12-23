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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The metadata related to the attachment. 
 */
public class ContentMetadata {

    private String attachmentId;
    private String contentFormat;
    private String name;
    private String pipelineNodeId;
    private Boolean persisted = false;

    public ContentMetadata attachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
        return this;
    }

    /**
     * The content id for the attachment.
     * @return attachmentId
     **/
    @JsonProperty("attachment_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAttachmentId() { return attachmentId; }
    public void setAttachmentId(String attachmentId) { this.attachmentId = attachmentId; }

    public ContentMetadata contentFormat(String contentFormat) {
        this.contentFormat = contentFormat;
        return this;
    }

    /**
     * The type of the content (eg. 'native').
     * @return contentFormat
     **/
    @JsonProperty("content_format")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getContentFormat() { return contentFormat; }
    public void setContentFormat(String contentFormat) { this.contentFormat = contentFormat; }

    public ContentMetadata name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the attachment.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ContentMetadata pipelineNodeId(String pipelineNodeId) {
        this.pipelineNodeId = pipelineNodeId;
        return this;
    }

    /**
     * The &#x60;pipeline_node_id&#x60; that corresponds to this content.
     * @return pipelineNodeId
     **/
    @javax.annotation.Nullable
    @JsonProperty("pipeline_node_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPipelineNodeId() { return pipelineNodeId; }
    public void setPipelineNodeId(String pipelineNodeId) { this.pipelineNodeId = pipelineNodeId; }

    public ContentMetadata persisted(Boolean persisted) {
        this.persisted = persisted;
        return this;
    }

    /**
     * This will be set to &#x60;true&#x60; if the content has been persisted. If this content was part of the import process and the upload of the content failed then the message can be found in the &#x60;warnings&#x60; field of the &#x60;system_details&#x60; that are returned with the model details.
     * @return persisted
     **/
    @javax.annotation.Nullable
    @JsonProperty("persisted")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getPersisted() { return persisted; }
    public void setPersisted(Boolean persisted) { this.persisted = persisted; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ContentMetadata contentMetadata = (ContentMetadata) o;
        return Objects.equals(this.attachmentId, contentMetadata.attachmentId) &&
                Objects.equals(this.contentFormat, contentMetadata.contentFormat) &&
                Objects.equals(this.name, contentMetadata.name) &&
                Objects.equals(this.pipelineNodeId, contentMetadata.pipelineNodeId) &&
                Objects.equals(this.persisted, contentMetadata.persisted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachmentId, contentFormat, name, pipelineNodeId, persisted);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContentMetadata {\n");
        sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
        sb.append("    contentFormat: ").append(toIndentedString(contentFormat)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    pipelineNodeId: ").append(toIndentedString(pipelineNodeId)).append("\n");
        sb.append("    persisted: ").append(toIndentedString(persisted)).append("\n");
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
