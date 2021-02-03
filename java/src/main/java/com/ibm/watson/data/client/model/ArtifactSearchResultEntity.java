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
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * ArtifactSearchResultEntity
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class ArtifactSearchResultEntity extends AbstractSearchResultEntity {

    private List<String> synonymGlobalIds;
    private List<String> synonyms;
    private String globalId;
    private Date effectiveStartDate;
    private String versionId;
    private List<String> abbreviation;
    private String artifactId;

    @javax.annotation.Nullable
    @JsonProperty("synonym_global_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSynonymGlobalIds() { return synonymGlobalIds; }
    public void setSynonymGlobalIds(List<String> synonymGlobalIds) { this.synonymGlobalIds = synonymGlobalIds; }

    @javax.annotation.Nullable
    @JsonProperty("synonyms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSynonyms() { return synonyms; }
    public void setSynonyms(List<String> synonyms) { this.synonyms = synonyms; }

    @javax.annotation.Nullable
    @JsonProperty("global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGlobalId() { return globalId; }
    public void setGlobalId(String globalId) { this.globalId = globalId; }

    @javax.annotation.Nullable
    @JsonProperty("effective_start_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getEffectiveStartDate() { return effectiveStartDate; }
    public void setEffectiveStartDate(Date effectiveStartDate) { this.effectiveStartDate = effectiveStartDate; }

    @javax.annotation.Nullable
    @JsonProperty("version_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionId() { return versionId; }
    public void setVersionId(String versionId) { this.versionId = versionId; }

    @javax.annotation.Nullable
    @JsonProperty("abbreviation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAbbreviation() { return abbreviation; }
    public void setAbbreviation(List<String> abbreviation) { this.abbreviation = abbreviation; }

    @javax.annotation.Nullable
    @JsonProperty("artifact_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtifactSearchResultEntity that = (ArtifactSearchResultEntity) o;
        return Objects.equals(synonymGlobalIds, that.synonymGlobalIds) &&
                Objects.equals(synonyms, that.synonyms) &&
                Objects.equals(globalId, that.globalId) &&
                Objects.equals(effectiveStartDate, that.effectiveStartDate) &&
                Objects.equals(versionId, that.versionId) &&
                Objects.equals(abbreviation, that.abbreviation) &&
                Objects.equals(artifactId, that.artifactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(synonymGlobalIds, synonyms, globalId, effectiveStartDate,
                versionId, abbreviation, artifactId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArtifactSearchResultEntity {\n");
        sb.append("    synonymGlobalIds: ").append(toIndentedString(synonymGlobalIds)).append("\n");
        sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
        sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
        sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
        sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
        sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
        sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
