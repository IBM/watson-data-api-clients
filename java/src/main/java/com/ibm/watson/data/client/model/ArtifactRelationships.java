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

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;

/**
 * Artifact relationships
 */
public class ArtifactRelationships {

    private String artifactId;
    private String versionId;
    private Map<String, PaginatedAbstractRelationshipList> relationships = null;

    public ArtifactRelationships artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * Artifact ID.
     * @return artifactId
     **/
    @javax.annotation.Nullable
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public ArtifactRelationships versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * Version ID.
     * @return versionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("version_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    public ArtifactRelationships relationships(Map<String, PaginatedAbstractRelationshipList> relationships) {
        this.relationships = relationships;
        return this;
    }

    public ArtifactRelationships putRelationshipsItem(String key, PaginatedAbstractRelationshipList relationshipsItem) {
        if (this.relationships == null) {
            this.relationships = new HashMap<>();
        }
        this.relationships.put(key, relationshipsItem);
        return this;
    }

    /**
     * Relationships grouped by relationship type.
     * @return relationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, PaginatedAbstractRelationshipList> getRelationships() { return relationships; }
    public void setRelationships(Map<String, PaginatedAbstractRelationshipList> relationships) { this.relationships = relationships; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ArtifactRelationships that = (ArtifactRelationships) o;
        return Objects.equals(this.artifactId, that.artifactId) &&
                Objects.equals(this.versionId, that.versionId) &&
                Objects.equals(this.relationships, that.relationships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactId, versionId, relationships);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArtifactRelationships {\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
        sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
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
