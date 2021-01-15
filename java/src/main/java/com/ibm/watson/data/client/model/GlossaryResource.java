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
 * GlossaryResource
 */
public class GlossaryResource {

    private String href;
    private String artifactId;
    private String versionId;
    private String workflowId;
    private String globalId;
    private String entityType;

    public GlossaryResource href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get href
     * @return href
     **/
    @javax.annotation.Nullable
    @JsonProperty("href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public GlossaryResource artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * The artifact ID (GUID) of the artifact.
     * @return artifactId
     **/
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public GlossaryResource versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * The version ID (GUID) of the artifact.
     * @return versionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("version_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    public GlossaryResource workflowId(String workflowId) {
        this.workflowId = workflowId;
        return this;
    }

    /**
     * The workflowId ID (GUID) of the artifact.
     * @return workflowId
     **/
    @javax.annotation.Nullable
    @JsonProperty("workflow_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getWorkflowId() { return workflowId; }
    public void setWorkflowId(String workflowId) { this.workflowId = workflowId; }

    public GlossaryResource globalId(String globalId) {
        this.globalId = globalId;
        return this;
    }

    /**
     * The Global ID of the resource
     * @return globalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGlobalId() { return globalId; }
    public void setGlobalId(String globalId) { this.globalId = globalId; }

    public GlossaryResource entityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * The type of the created entity.
     * @return entityType
     **/
    @javax.annotation.Nullable
    @JsonProperty("entity_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GlossaryResource glossaryResource = (GlossaryResource)o;
        return Objects.equals(this.href, glossaryResource.href) &&
                Objects.equals(this.artifactId, glossaryResource.artifactId) &&
                Objects.equals(this.versionId, glossaryResource.versionId) &&
                Objects.equals(this.workflowId, glossaryResource.workflowId) &&
                Objects.equals(this.globalId, glossaryResource.globalId) &&
                Objects.equals(this.entityType, glossaryResource.entityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, artifactId, versionId, workflowId, globalId,
                entityType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GlossaryResource {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
        sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
        sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
