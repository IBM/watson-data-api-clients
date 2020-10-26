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
 * NewReferenceDataValueEntity
 */
public class NewReferenceDataValueEntity extends ReferenceDataValueEntity {

    private List<NewRelationship> terms = null;

    public NewReferenceDataValueEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public NewReferenceDataValueEntity addTermsItem(NewRelationship termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * The relationships to business terms.
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getTerms() { return terms; }
    public void setTerms(List<NewRelationship> terms) { this.terms = terms; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NewReferenceDataValueEntity newReferenceDataValueEntity = (NewReferenceDataValueEntity)o;
        return super.equals(o) &&
                Objects.equals(this.terms, newReferenceDataValueEntity.terms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), terms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewReferenceDataValueEntity {\n");
        super.toString(sb);
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
