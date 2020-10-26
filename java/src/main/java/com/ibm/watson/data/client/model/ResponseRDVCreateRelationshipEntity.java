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
 * ResponseRDVCreateRelationshipEntity
 */
public class ResponseRDVCreateRelationshipEntity {

    private String code;
    private List<RelationshipCreateResponseIds> terms = null;
    private List<Object> child = null;

    public ResponseRDVCreateRelationshipEntity code(String code) {
        this.code = code;
        return this;
    }

    /**
     * code
     * @return code
     **/
    @javax.annotation.Nullable
    @JsonProperty("code")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public ResponseRDVCreateRelationshipEntity terms(List<RelationshipCreateResponseIds> terms) {
        this.terms = terms;
        return this;
    }

    public ResponseRDVCreateRelationshipEntity addTermsItem(RelationshipCreateResponseIds termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * term relatiosnhips added
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipCreateResponseIds> getTerms() { return terms; }
    public void setTerms(List<RelationshipCreateResponseIds> terms) { this.terms = terms; }

    public ResponseRDVCreateRelationshipEntity child(List<Object> child) {
        this.child = child;
        return this;
    }

    public ResponseRDVCreateRelationshipEntity addChildItem(Object childItem) {
        if (this.child == null) {
            this.child = new ArrayList<>();
        }
        this.child.add(childItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("child")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getChild() { return child; }
    public void setChild(List<Object> child) { this.child = child; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResponseRDVCreateRelationshipEntity responseRDVCreateRelationshipEntity = (ResponseRDVCreateRelationshipEntity)o;
        return Objects.equals(this.code, responseRDVCreateRelationshipEntity.code) &&
                Objects.equals(this.terms, responseRDVCreateRelationshipEntity.terms) &&
                Objects.equals(this.child, responseRDVCreateRelationshipEntity.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, terms, child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseRDVCreateRelationshipEntity {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    child: ").append(toIndentedString(child)).append("\n");
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
