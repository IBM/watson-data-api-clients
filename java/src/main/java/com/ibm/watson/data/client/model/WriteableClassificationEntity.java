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
 * WriteableClassificationEntity
 */
public class WriteableClassificationEntity extends WriteableGlossaryObjectEntity {

    private NewRelationship isATypeOfClassification;
    private List<NewRelationship> hasTypesClassifications = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> dataClasses = null;

    public WriteableClassificationEntity isATypeOfClassification(NewRelationship isATypeOfClassification) {
        this.isATypeOfClassification = isATypeOfClassification;
        return this;
    }

    /**
     * Get isATypeOfClassification
     * @return isATypeOfClassification
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_a_type_of_classification")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public NewRelationship getIsATypeOfClassification() { return isATypeOfClassification; }
    public void setIsATypeOfClassification(NewRelationship isATypeOfClassification) { this.isATypeOfClassification = isATypeOfClassification; }

    public WriteableClassificationEntity hasTypesClassifications(List<NewRelationship> hasTypesClassifications) {
        this.hasTypesClassifications = hasTypesClassifications;
        return this;
    }

    public WriteableClassificationEntity addHasTypesClassificationsItem(NewRelationship hasTypesClassificationsItem) {
        if (this.hasTypesClassifications == null) {
            this.hasTypesClassifications = new ArrayList<>();
        }
        this.hasTypesClassifications.add(hasTypesClassificationsItem);
        return this;
    }

    /**
     * The child classification relationships in the classification type
     * hierarchy.
     * @return hasTypesClassifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("has_types_classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getHasTypesClassifications() { return hasTypesClassifications; }
    public void setHasTypesClassifications(List<NewRelationship> hasTypesClassifications) { this.hasTypesClassifications = hasTypesClassifications; }

    public WriteableClassificationEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public WriteableClassificationEntity addTermsItem(NewRelationship termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    /**
     * Relationships to business terms.
     * @return terms
     **/
    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getTerms() { return terms; }
    public void setTerms(List<NewRelationship> terms) { this.terms = terms; }

    public WriteableClassificationEntity dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public WriteableClassificationEntity addDataClassesItem(NewRelationship dataClassesItem) {
        if (this.dataClasses == null) {
            this.dataClasses = new ArrayList<>();
        }
        this.dataClasses.add(dataClassesItem);
        return this;
    }

    /**
     * Relationships to data classes.
     * @return dataClasses
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getDataClasses() { return dataClasses; }
    public void setDataClasses(List<NewRelationship> dataClasses) { this.dataClasses = dataClasses; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WriteableClassificationEntity that = (WriteableClassificationEntity)o;
        return super.equals(o) &&
                Objects.equals(this.isATypeOfClassification, that.isATypeOfClassification) &&
                Objects.equals(this.hasTypesClassifications, that.hasTypesClassifications) &&
                Objects.equals(this.terms, that.terms) &&
                Objects.equals(this.dataClasses, that.dataClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isATypeOfClassification,
                hasTypesClassifications, terms, dataClasses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WriteableClassificationEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    isATypeOfClassification: ").append(toIndentedString(isATypeOfClassification)).append("\n");
        sb.append("    hasTypesClassifications: ").append(toIndentedString(hasTypesClassifications)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
    }

}
