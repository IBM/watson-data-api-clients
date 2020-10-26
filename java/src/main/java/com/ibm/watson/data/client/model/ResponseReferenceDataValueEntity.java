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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResponseReferenceDataValueEntity
 */
public class ResponseReferenceDataValueEntity extends ReferenceDataValueEntity {

    private String revision;
    private List<RelationshipObject> termRelationships = null;

    public ResponseReferenceDataValueEntity revision(String revision) {
        this.revision = revision;
        return this;
    }

    /**
     * The revision of the artifact. It is used for optimistic locking.
     * @return revision
     **/
    @javax.annotation.Nullable
    @JsonProperty("revision")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRevision() { return revision; }
    public void setRevision(String revision) { this.revision = revision; }

    public ResponseReferenceDataValueEntity termRelationships(List<RelationshipObject> termRelationships) {
        this.termRelationships = termRelationships;
        return this;
    }

    public ResponseReferenceDataValueEntity addTermRelationshipsItem(RelationshipObject termRelationshipsItem) {
        if (this.termRelationships == null) {
            this.termRelationships = new ArrayList<>();
        }
        this.termRelationships.add(termRelationshipsItem);
        return this;
    }

    /**
     * The relationships to business terms.
     * @return termRelationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("term_relationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipObject> getTermRelationships() { return termRelationships; }
    public void setTermRelationships(List<RelationshipObject> termRelationships) { this.termRelationships = termRelationships; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResponseReferenceDataValueEntity referenceDataValueEntity = (ResponseReferenceDataValueEntity)o;
        return super.equals(o) &&
                Objects.equals(this.revision, referenceDataValueEntity.revision) &&
                Objects.equals(this.termRelationships, referenceDataValueEntity.termRelationships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), revision, termRelationships);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseReferenceDataValueEntity {\n");
        super.toString(sb);
        sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
        sb.append("    termRelationships: ").append(toIndentedString(termRelationships)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
