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
 * NewRuleEntity
 */
public class WriteableRuleEntity extends WriteableGlossaryObjectEntity {

    private List<NewRelationship> policies = null;
    private List<NewRelationship> rules = null;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;
    private List<NewRelationship> referenceData = null;
    private List<NewRelationship> dataClasses = null;

    public WriteableRuleEntity policies(List<NewRelationship> policies) {
        this.policies = policies;
        return this;
    }

    public WriteableRuleEntity addPoliciesItem(NewRelationship policiesItem) {
        if (this.policies == null) {
            this.policies = new ArrayList<>();
        }
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * The relationships to governance policies.
     * @return policies
     **/
    @javax.annotation.Nullable
    @JsonProperty("policies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getPolicies() { return policies; }
    public void setPolicies(List<NewRelationship> policies) { this.policies = policies; }

    public WriteableRuleEntity rules(List<NewRelationship> rules) {
        this.rules = rules;
        return this;
    }

    public WriteableRuleEntity addRulesItem(NewRelationship rulesItem) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rulesItem);
        return this;
    }

    /**
     * Relationships to governance rules only. Does not include other rule
     * relastionships.
     * @return rules
     **/
    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getRules() { return rules; }
    public void setRules(List<NewRelationship> rules) { this.rules = rules; }

    public WriteableRuleEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public WriteableRuleEntity addTermsItem(NewRelationship termsItem) {
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

    public WriteableRuleEntity classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public WriteableRuleEntity addClassificationsItem(NewRelationship classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * Relationships to classifications.
     * @return classifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getClassifications() { return classifications; }
    public void setClassifications(List<NewRelationship> classifications) { this.classifications = classifications; }

    public WriteableRuleEntity referenceData(List<NewRelationship> referenceData) {
        this.referenceData = referenceData;
        return this;
    }

    public WriteableRuleEntity addReferenceDataItem(NewRelationship referenceDataItem) {
        if (this.referenceData == null) {
            this.referenceData = new ArrayList<>();
        }
        this.referenceData.add(referenceDataItem);
        return this;
    }

    /**
     * The relationships to reference data sets.
     * @return referenceData
     **/
    @javax.annotation.Nullable
    @JsonProperty("reference_data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewRelationship> getReferenceData() { return referenceData; }
    public void setReferenceData(List<NewRelationship> referenceData) { this.referenceData = referenceData; }

    public WriteableRuleEntity dataClasses(List<NewRelationship> dataClasses) {
        this.dataClasses = dataClasses;
        return this;
    }

    public WriteableRuleEntity addDataClassesItem(NewRelationship dataClassesItem) {
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
        WriteableRuleEntity newRuleEntity = (WriteableRuleEntity)o;
        return super.equals(o) &&
                Objects.equals(this.policies, newRuleEntity.policies) &&
                Objects.equals(this.rules, newRuleEntity.rules) &&
                Objects.equals(this.terms, newRuleEntity.terms) &&
                Objects.equals(this.classifications, newRuleEntity.classifications) &&
                Objects.equals(this.referenceData, newRuleEntity.referenceData) &&
                Objects.equals(this.dataClasses, newRuleEntity.dataClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), policies, rules, terms,
                classifications, referenceData, dataClasses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WriteableRuleEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
        sb.append("    dataClasses: ").append(toIndentedString(dataClasses)).append("\n");
    }

}
