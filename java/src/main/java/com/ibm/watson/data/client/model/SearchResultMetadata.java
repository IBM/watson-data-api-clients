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
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * SearchResultMetadata
 */
public class SearchResultMetadata {

    private Date modifiedOn;
    private List<String> classifications;
    private String artifactType;
    private List<String> classificationGlobalIds;
    private String name;
    private String modifiedBy;
    private String description;
    private String state;
    private List<String> stewardIds;
    private List<String> tags;
    private List<String> termGlobalIds;
    private List<String> terms;

    public SearchResultMetadata modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("modified_on")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getModifiedOn() { return modifiedOn; }
    public void setModifiedOn(Date modifiedOn) { this.modifiedOn = modifiedOn; }

    public SearchResultMetadata classifications(List<String> classifications) {
        this.classifications = classifications;
        return this;
    }

    public SearchResultMetadata addClassificationsItem(String classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getClassifications() { return classifications; }
    public void setClassifications(List<String> classifications) { this.classifications = classifications; }

    public SearchResultMetadata artifactType(String artifactType) {
        this.artifactType = artifactType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("artifact_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactType() { return artifactType; }
    public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

    public SearchResultMetadata classificationGlobalIds(List<String> classificationGlobalIds) {
        this.classificationGlobalIds = classificationGlobalIds;
        return this;
    }

    public SearchResultMetadata addClassificationGlobalIdsItem(String classificationGlobalIdsItem) {
        if (this.classificationGlobalIds == null) {
            this.classificationGlobalIds = new ArrayList<>();
        }
        this.classificationGlobalIds.add(classificationGlobalIdsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("classification_global_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getClassificationGlobalIds() { return classificationGlobalIds; }
    public void setClassificationGlobalIds(List<String> classificationGlobalIds) { this.classificationGlobalIds = classificationGlobalIds; }

    public SearchResultMetadata name(String name) {
        this.name = name;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SearchResultMetadata modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("modified_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public SearchResultMetadata description(String description) {
        this.description = description;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public SearchResultMetadata state(String state) {
        this.state = state;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public SearchResultMetadata stewardIds(List<String> stewardIds) {
        this.stewardIds = stewardIds;
        return this;
    }

    public SearchResultMetadata addStewardIdsItem(String stewardIdsItem) {
        if (this.stewardIds == null) {
            this.stewardIds = new ArrayList<>();
        }
        this.stewardIds.add(stewardIdsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("steward_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getStewardIds() { return stewardIds; }
    public void setStewardIds(List<String> stewardIds) { this.stewardIds = stewardIds; }

    public SearchResultMetadata tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public SearchResultMetadata addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public SearchResultMetadata termGlobalIds(List<String> termGlobalIds) {
        this.termGlobalIds = termGlobalIds;
        return this;
    }

    public SearchResultMetadata addTermGlobalIdsItem(String termGlobalIdsItem) {
        if (this.termGlobalIds == null) {
            this.termGlobalIds = new ArrayList<>();
        }
        this.termGlobalIds.add(termGlobalIdsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("term_global_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTermGlobalIds() { return termGlobalIds; }
    public void setTermGlobalIds(List<String> termGlobalIds) { this.termGlobalIds = termGlobalIds; }

    public SearchResultMetadata terms(List<String> terms) {
        this.terms = terms;
        return this;
    }

    public SearchResultMetadata addTermsItem(String termsItem) {
        if (this.terms == null) {
            this.terms = new ArrayList<>();
        }
        this.terms.add(termsItem);
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTerms() { return terms; }
    public void setTerms(List<String> terms) { this.terms = terms; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SearchResultMetadata that = (SearchResultMetadata) o;
        return Objects.equals(this.modifiedOn, that.modifiedOn) &&
                Objects.equals(this.classifications, that.classifications) &&
                Objects.equals(this.artifactType, that.artifactType) &&
                Objects.equals(this.classificationGlobalIds, that.classificationGlobalIds) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.modifiedBy, that.modifiedBy) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.state, that.state) &&
                Objects.equals(this.stewardIds, that.stewardIds) &&
                Objects.equals(this.tags, that.tags) &&
                Objects.equals(this.termGlobalIds, that.termGlobalIds) &&
                Objects.equals(this.terms, that.terms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifiedOn, classifications, artifactType, classificationGlobalIds,
                name, modifiedBy, description, state, stewardIds, tags, termGlobalIds, terms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchResultMetadata {\n");
        sb.append("    modifiedOn: ").append(toIndentedString(modifiedOn)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    artifactType: ").append(toIndentedString(artifactType)).append("\n");
        sb.append("    classificationGlobalIds: ").append(toIndentedString(classificationGlobalIds)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    stewardIds: ").append(toIndentedString(stewardIds)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    termGlobalIds: ").append(toIndentedString(termGlobalIds)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
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
