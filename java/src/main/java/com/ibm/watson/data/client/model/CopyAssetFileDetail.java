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
 * CopyAssetFileTarget
 */
public class CopyAssetFileDetail {

    private String type;
    private String guid;
    private String path;

    public CopyAssetFileDetail type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the source container.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public CopyAssetFileDetail guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * The guid of the source container.
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public CopyAssetFileDetail path(String path) {
        this.path = path;
        return this;
    }

    /**
     * The location where the asset should be copied
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty("path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CopyAssetFileDetail copyAssetFileTarget = (CopyAssetFileDetail)o;
        return Objects.equals(this.type, copyAssetFileTarget.type) &&
                Objects.equals(this.guid, copyAssetFileTarget.guid) &&
                Objects.equals(this.path, copyAssetFileTarget.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, guid, path);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CopyAssetFileTarget {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
