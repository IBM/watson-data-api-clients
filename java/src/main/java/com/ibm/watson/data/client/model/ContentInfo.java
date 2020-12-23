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
import com.ibm.watson.data.client.model.enums.ContentFormatType;

/**
 * The content information to be uploaded. 
 */
public class ContentInfo {

    private ContentFormatType contentFormat;
    private String location;
    private String fileName;
    private String pipelineNodeId;

    public ContentInfo contentFormat(ContentFormatType contentFormat) {
        this.contentFormat = contentFormat;
        return this;
    }

    /**
     * The content format of the attachment. This can be one of &#x60;native&#x60;, &#x60;coreML&#x60;, &#x60;pipeline-node&#x60;.
     * @return contentFormat
     **/
    @JsonProperty("content_format")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ContentFormatType getContentFormat() { return contentFormat; }
    public void setContentFormat(ContentFormatType contentFormat) { this.contentFormat = contentFormat; }

    public ContentInfo location(String location) {
        this.location = location;
        return this;
    }

    /**
     * The location of the content to be uploaded.
     * @return location
     **/
    @JsonProperty("location")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public ContentInfo fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * The file name that will be used when downloading the content from the UI.
     * @return fileName
     **/
    @JsonProperty("file_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public ContentInfo pipelineNodeId(String pipelineNodeId) {
        this.pipelineNodeId = pipelineNodeId;
        return this;
    }

    /**
     * The &#x60;pipeline_node_id&#x60; that corresponds to this content. This is required only if the &#x60;content_format&#x60; is &#x60;pipeline-node&#x60; otherwise it is rejected or ignored.
     * @return pipelineNodeId
     **/
    @javax.annotation.Nullable
    @JsonProperty("pipeline_node_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPipelineNodeId() { return pipelineNodeId; }
    public void setPipelineNodeId(String pipelineNodeId) { this.pipelineNodeId = pipelineNodeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ContentInfo contentInfo = (ContentInfo) o;
        return Objects.equals(this.contentFormat, contentInfo.contentFormat) &&
                Objects.equals(this.location, contentInfo.location) &&
                Objects.equals(this.fileName, contentInfo.fileName) &&
                Objects.equals(this.pipelineNodeId, contentInfo.pipelineNodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentFormat, location, fileName, pipelineNodeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContentInfo {\n");
        sb.append("    contentFormat: ").append(toIndentedString(contentFormat)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    pipelineNodeId: ").append(toIndentedString(pipelineNodeId)).append("\n");
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

