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
 * AssetFileMetadata
 */
public class AssetFileMetadata {

    private String path;
    private String etag;
    private Integer size;
    private String type;
    private String mimeType;
    private String lastModifed;

    public AssetFileMetadata path(String path) {
        this.path = path;
        return this;
    }

    /**
     * The path of the file.
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty("path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public AssetFileMetadata etag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * ETAG for the resource.
     * @return etag
     **/
    @javax.annotation.Nullable
    @JsonProperty("etag")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEtag() { return etag; }
    public void setEtag(String etag) { this.etag = etag; }

    public AssetFileMetadata size(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * The size in bytes for files. The number of resource for folders.
     * @return size
     **/
    @javax.annotation.Nullable
    @JsonProperty("size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getSize() { return size; }
    public void setSize(Integer size) { this.size = size; }

    public AssetFileMetadata type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Either folder or file.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public AssetFileMetadata mimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    /**
     * If the resource is a file this will be the mime type of the file.
     * @return mimeType
     **/
    @javax.annotation.Nullable
    @JsonProperty("mime_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMimeType() { return mimeType; }
    public void setMimeType(String mimeType) { this.mimeType = mimeType; }

    public AssetFileMetadata lastModifed(String lastModifed) {
        this.lastModifed = lastModifed;
        return this;
    }

    /**
     * Time when the asset was last modified, defaults to create date. Returned in
     * json timestamp format. (Yes, this is spelled wrong, as it is spelled wrong in the API itself.)
     * @return lastModifed
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_modifed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLastModifed() { return lastModifed; }
    public void setLastModifed(String lastModifed) { this.lastModifed = lastModifed; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetFileMetadata assetFileMetadata = (AssetFileMetadata)o;
        return Objects.equals(this.path, assetFileMetadata.path) &&
                Objects.equals(this.etag, assetFileMetadata.etag) &&
                Objects.equals(this.size, assetFileMetadata.size) &&
                Objects.equals(this.type, assetFileMetadata.type) &&
                Objects.equals(this.mimeType, assetFileMetadata.mimeType) &&
                Objects.equals(this.lastModifed, assetFileMetadata.lastModifed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, etag, size, type, mimeType, lastModifed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetFileMetadata {\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
        sb.append("    lastModifed: ").append(toIndentedString(lastModifed)).append("\n");
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
