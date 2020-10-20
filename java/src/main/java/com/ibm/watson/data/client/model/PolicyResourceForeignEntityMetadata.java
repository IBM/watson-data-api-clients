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
 * metadata object for responses from policy management related APIs for objects
 * that are not contained within policy management storage
 */
public class PolicyResourceForeignEntityMetadata {

    private String artifactId;
    private String globalId;
    private String artifactType;

    public PolicyResourceForeignEntityMetadata artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * an identifier for the resource
     * @return artifactId
     **/
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public PolicyResourceForeignEntityMetadata globalId(String globalId) {
        this.globalId = globalId;
        return this;
    }

    /**
     * a global identifier for the resource
     * @return globalId
     **/
    @JsonProperty("global_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGlobalId() { return globalId; }
    public void setGlobalId(String globalId) { this.globalId = globalId; }

    public PolicyResourceForeignEntityMetadata artifactType(String artifactType) {
        this.artifactType = artifactType;
        return this;
    }

    /**
     * artifact type of the resource
     * @return artifactType
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactType() { return artifactType; }
    public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyResourceForeignEntityMetadata policyResourceForeignEntityMetadata =
                (PolicyResourceForeignEntityMetadata)o;
        return Objects.equals(this.artifactId, policyResourceForeignEntityMetadata.artifactId) &&
                Objects.equals(this.globalId, policyResourceForeignEntityMetadata.globalId) &&
                Objects.equals(this.artifactType, policyResourceForeignEntityMetadata.artifactType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactId, globalId, artifactType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyResourceForeignEntityMetadata {\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
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
