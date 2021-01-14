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
 * ColumnTerm
 */
public class ColumnTerm {

    private String termDisplayName;
    private String termId;
    private String sourceMetadataCollectionId;

    @javax.annotation.Nullable
    @JsonProperty("term_display_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTermDisplayName() { return termDisplayName; }
    public void setTermDisplayName(String termDisplayName) { this.termDisplayName = termDisplayName; }

    @javax.annotation.Nullable
    @JsonProperty("term_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTermId() { return termId; }
    public void setTermId(String termId) { this.termId = termId; }

    @javax.annotation.Nullable
    @JsonProperty("source_metadata_collection_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSourceMetadataCollectionId() { return sourceMetadataCollectionId; }
    public void setSourceMetadataCollectionId(String sourceMetadataCollectionId) { this.sourceMetadataCollectionId = sourceMetadataCollectionId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnTerm that = (ColumnTerm) o;
        return Objects.equals(termDisplayName, that.termDisplayName) &&
                Objects.equals(termId, that.termId) &&
                Objects.equals(sourceMetadataCollectionId, that.sourceMetadataCollectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(termDisplayName, termId, sourceMetadataCollectionId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ColumnTerm {\n");
        sb.append("    termDisplayName: ").append(toIndentedString(termDisplayName)).append("\n");
        sb.append("    termId: ").append(toIndentedString(termId)).append("\n");
        sb.append("    sourceMetadataCollectionId: ").append(toIndentedString(sourceMetadataCollectionId)).append("\n");
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
