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
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * WriteableReferenceDataSetEntity
 */
public class WriteableReferenceDataSetEntity {

    private String name;
    private String longDescription;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private GlossaryObjectState state;
    private List<String> tags = null;
    private List<String> stewardIds = null;
    // TODO: type should probably be an enumeration?
    private String type;
    private List<NewRelationship> terms = null;
    private List<NewRelationship> classifications = null;
    private List<NewReferenceDataValueEntity> rdsValues = null;
    private NewRelationship parentCategory;

    public WriteableReferenceDataSetEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the artifact.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public WriteableReferenceDataSetEntity longDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    /**
     * The long description of an artifact.
     * @return longDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("long_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public WriteableReferenceDataSetEntity effectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
        return this;
    }

    /**
     * The effective start date at which the artifact goes into effect. If the
     * effective start date is not specified, then the artifact goes into effect
     * immediately.
     * @return effectiveStartDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_start_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveStartDate() { return effectiveStartDate; }
    public void setEffectiveStartDate(Date effectiveStartDate) { this.effectiveStartDate = effectiveStartDate; }

    public WriteableReferenceDataSetEntity effectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
        return this;
    }

    /**
     * The effective end date at which the artifact ends and no longer effective.
     * If the effective end date is not specified, then the artifact remains effect
     * forever.
     * @return effectiveEndDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("effective_end_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveEndDate() { return effectiveEndDate; }
    public void setEffectiveEndDate(Date effectiveEndDate) { this.effectiveEndDate = effectiveEndDate; }

    public WriteableReferenceDataSetEntity state(GlossaryObjectState state) {
        this.state = state;
        return this;
    }

    /**
     * The state of an artifact, such as DRAFT, ACTIVE or ARCHIVED.
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GlossaryObjectState getState() { return state; }
    public void setState(GlossaryObjectState state) { this.state = state; }

    public WriteableReferenceDataSetEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public WriteableReferenceDataSetEntity addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * The tags assigned to an artifact.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public WriteableReferenceDataSetEntity stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public WriteableReferenceDataSetEntity addStewardIdsItem(String stewardIdsItem) {
        if (this.stewardIds == null) {
            this.stewardIds = new ArrayList<>();
        }
        this.stewardIds.add(stewardIdsItem);
        return this;
    }

    /**
     * The stewards assigned to an artifact.
     * @return stewardIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("steward_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getStewardIds() { return stewardIds; }
    public void setStewardIds(List<String> stewardIds) { this.stewardIds = stewardIds; }

    public WriteableReferenceDataSetEntity type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Type, e.g. "TEXT"
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public WriteableReferenceDataSetEntity terms(List<NewRelationship> terms) {
        this.terms = terms;
        return this;
    }

    public WriteableReferenceDataSetEntity addTermsItem(NewRelationship termsItem) {
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

    public WriteableReferenceDataSetEntity classifications(List<NewRelationship> classifications) {
        this.classifications = classifications;
        return this;
    }

    public WriteableReferenceDataSetEntity addClassificationsItem(NewRelationship classificationsItem) {
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

    public WriteableReferenceDataSetEntity rdsValues(List<NewReferenceDataValueEntity> rdsValues) {
        this.rdsValues = rdsValues;
        return this;
    }

    public WriteableReferenceDataSetEntity addRdsValuesItem(NewReferenceDataValueEntity rdsValuesItem) {
        if (this.rdsValues == null) {
            this.rdsValues = new ArrayList<>();
        }
        this.rdsValues.add(rdsValuesItem);
        return this;
    }

    /**
     * The value entities for rds.
     * @return rdsValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("rds_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NewReferenceDataValueEntity> getRdsValues() { return rdsValues; }
    public void setRdsValues(List<NewReferenceDataValueEntity> rdsValues) { this.rdsValues = rdsValues; }

    /**
     * Get parentCategory
     * @return parentCategory
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public NewRelationship getParentCategory() { return parentCategory; }
    public void setParentCategory(NewRelationship parentCategory) { this.parentCategory = parentCategory; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WriteableReferenceDataSetEntity that = (WriteableReferenceDataSetEntity)o;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.longDescription, that.longDescription) &&
                Objects.equals(this.effectiveStartDate, that.effectiveStartDate) &&
                Objects.equals(this.effectiveEndDate, that.effectiveEndDate) &&
                Objects.equals(this.state, that.state) &&
                Objects.equals(this.tags, that.tags) &&
                Objects.equals(this.stewardIds, that.stewardIds) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.terms, that.terms) &&
                Objects.equals(this.classifications, that.classifications) &&
                Objects.equals(this.rdsValues, that.rdsValues) &&
                Objects.equals(this.parentCategory, that.parentCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, longDescription, effectiveStartDate,
                effectiveEndDate, state, tags, stewardIds, type, terms,
                classifications, rdsValues, parentCategory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WriteableReferenceDataSetEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    longDescription: ").append(toIndentedString(longDescription)).append("\n");
        sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
        sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    rdsValues: ").append(toIndentedString(rdsValues)).append("\n");
        sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
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
