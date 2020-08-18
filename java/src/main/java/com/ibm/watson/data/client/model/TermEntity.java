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
import com.ibm.watson.data.client.model.enums.TermState;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TermEntity
 */
public class TermEntity {

    private String longDescription;
    private TermState state;
    private List<CustomAttribute> customAttributes = null;
    private List<String> abbreviations = null;
    private String importSourceCreatedBy;
    private OffsetDateTime importSourceCreatedOn;
    private String importSourceUsage;
    private String example;

    public TermEntity longDescription(String longDescription) {
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

    public TermEntity state(TermState state) {
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
    public TermState getState() { return state; }
    public void setState(TermState state) { this.state = state; }

    public TermEntity customAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public TermEntity addCustomAttributesItem(CustomAttribute customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new ArrayList<>();
        }
        this.customAttributes.add(customAttributesItem);
        return this;
    }

    /**
     * List of custom attributes with their values.
     * @return customAttributes
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom_attributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttribute> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(List<CustomAttribute> customAttributes) { this.customAttributes = customAttributes; }

    public TermEntity abbreviations(List<String> abbreviations) {
        this.abbreviations = abbreviations;
        return this;
    }

    public TermEntity addAbbreviationsItem(String abbreviationsItem) {
        if (this.abbreviations == null) {
            this.abbreviations = new ArrayList<>();
        }
        this.abbreviations.add(abbreviationsItem);
        return this;
    }

    /**
     * The list of abbreviations of a business term.
     * @return abbreviations
     **/
    @javax.annotation.Nullable
    @JsonProperty("abbreviations")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAbbreviations() { return abbreviations; }
    public void setAbbreviations(List<String> abbreviations) { this.abbreviations = abbreviations; }

    public TermEntity importSourceCreatedBy(String importSourceCreatedBy) {
        this.importSourceCreatedBy = importSourceCreatedBy;
        return this;
    }

    /**
     * Name of the user who has created the term in the original source for
     * imported term.
     * @return importSourceCreatedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_source_created_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportSourceCreatedBy() { return importSourceCreatedBy; }
    public void setImportSourceCreatedBy(String importSourceCreatedBy) { this.importSourceCreatedBy = importSourceCreatedBy; }

    public TermEntity importSourceCreatedOn(OffsetDateTime importSourceCreatedOn) {
        this.importSourceCreatedOn = importSourceCreatedOn;
        return this;
    }

    /**
     * The timestamp when the term was created in the original source for imported
     * term.
     * @return importSourceCreatedOn
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_source_created_on")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public OffsetDateTime getImportSourceCreatedOn() { return importSourceCreatedOn; }
    public void setImportSourceCreatedOn(OffsetDateTime importSourceCreatedOn) { this.importSourceCreatedOn = importSourceCreatedOn; }

    public TermEntity importSourceUsage(String importSourceUsage) {
        this.importSourceUsage = importSourceUsage;
        return this;
    }

    /**
     * The usage of the term in the original source for imported term.
     * @return importSourceUsage
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_source_usage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportSourceUsage() { return importSourceUsage; }
    public void setImportSourceUsage(String importSourceUsage) { this.importSourceUsage = importSourceUsage; }

    public TermEntity example(String example) {
        this.example = example;
        return this;
    }

    /**
     * Get example
     * @return example
     **/
    @javax.annotation.Nullable
    @JsonProperty("example")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TermEntity newTermEntity = (TermEntity)o;
        return Objects.equals(this.longDescription, newTermEntity.longDescription) &&
                Objects.equals(this.state, newTermEntity.state) &&
                Objects.equals(this.customAttributes, newTermEntity.customAttributes) &&
                Objects.equals(this.abbreviations, newTermEntity.abbreviations) &&
                Objects.equals(this.importSourceCreatedBy, newTermEntity.importSourceCreatedBy) &&
                Objects.equals(this.importSourceCreatedOn, newTermEntity.importSourceCreatedOn) &&
                Objects.equals(this.importSourceUsage, newTermEntity.importSourceUsage) &&
                Objects.equals(this.example, newTermEntity.example);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                longDescription, state, customAttributes, abbreviations,
                importSourceCreatedBy, importSourceCreatedOn, importSourceUsage,
                example);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewTermEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    longDescription: ").append(toIndentedString(longDescription)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
        sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
        sb.append("    importSourceCreatedBy: ").append(toIndentedString(importSourceCreatedBy)).append("\n");
        sb.append("    importSourceCreatedOn: ").append(toIndentedString(importSourceCreatedOn)).append("\n");
        sb.append("    importSourceUsage: ").append(toIndentedString(importSourceUsage)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
