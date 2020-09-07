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
 * Assignment of an artifact to a category
 */
public class NewCategoryAssignment {

    private String artifactType;
    private Boolean isPrimaryCategory;

    public NewCategoryAssignment artifactType(String artifactType) {
        this.artifactType = artifactType;
        return this;
    }

    /**
     * Type of the artifact to be added to a category
     * @return artifactType
     **/
    @JsonProperty("artifact_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getArtifactType() { return artifactType; }
    public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

    public NewCategoryAssignment isPrimaryCategory(Boolean isPrimaryCategory) {
        this.isPrimaryCategory = isPrimaryCategory;
        return this;
    }

    /**
     * true when a primary category should be set for an artifact, false when the
     * artifact should be added to a secondary category
     * @return isPrimaryCategory
     **/
    @JsonProperty("is_primary_category")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Boolean getIsPrimaryCategory() { return isPrimaryCategory; }
    public void setIsPrimaryCategory(Boolean isPrimaryCategory) { this.isPrimaryCategory = isPrimaryCategory; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NewCategoryAssignment newCategoryAssignment = (NewCategoryAssignment)o;
        return Objects.equals(this.artifactType, newCategoryAssignment.artifactType) &&
                Objects.equals(this.isPrimaryCategory, newCategoryAssignment.isPrimaryCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactType, isPrimaryCategory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewCategoryAssignment {\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
        sb.append("    isPrimaryCategory: ").append(toIndentedString(isPrimaryCategory)).append("\n");
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
