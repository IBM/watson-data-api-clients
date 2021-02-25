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
 * CopyAssetFile
 */
public class CopyAssetFile {

    private CopyAssetFileDetail source;
    private CopyAssetFileDetail target;

    public CopyAssetFile source(CopyAssetFileDetail source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     * @return source
     **/
    @javax.annotation.Nullable
    @JsonProperty("source")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CopyAssetFileDetail getSource() { return source; }
    public void setSource(CopyAssetFileDetail source) { this.source = source; }

    public CopyAssetFile target(CopyAssetFileDetail target) {
        this.target = target;
        return this;
    }

    /**
     * Get target
     * @return target
     **/
    @javax.annotation.Nullable
    @JsonProperty("target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CopyAssetFileDetail getTarget() { return target; }
    public void setTarget(CopyAssetFileDetail target) { this.target = target; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CopyAssetFile copyAssetFile = (CopyAssetFile)o;
        return Objects.equals(this.source, copyAssetFile.source) &&
                Objects.equals(this.target, copyAssetFile.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CopyAssetFile {\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
