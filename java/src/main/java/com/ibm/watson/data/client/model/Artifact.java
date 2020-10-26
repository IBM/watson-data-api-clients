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
 * Artifact
 */
public class Artifact {

    private ArtifactMetadata metadata;
    private ArtifactWorkflowData workflowData;

    public Artifact metadata(ArtifactMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ArtifactMetadata getMetadata() { return metadata; }
    public void setMetadata(ArtifactMetadata metadata) { this.metadata = metadata; }

    public Artifact workflowData(ArtifactWorkflowData workflowData) {
        this.workflowData = workflowData;
        return this;
    }

    /**
     * Get workflowData
     * @return workflowData
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ArtifactWorkflowData getWorkflowData() { return workflowData; }
    public void setWorkflowData(ArtifactWorkflowData workflowData) { this.workflowData = workflowData; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Artifact artifact = (Artifact)o;
        return Objects.equals(this.metadata, artifact.metadata) &&
                Objects.equals(this.workflowData, artifact.workflowData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, workflowData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Artifact {\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    workflowData: ").append(toIndentedString(workflowData)).append("\n");
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
