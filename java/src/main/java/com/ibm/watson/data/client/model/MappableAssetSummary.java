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
import com.ibm.watson.data.client.model.enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * MappableAssetSummary
 */
public class MappableAssetSummary {

    private MappableAssetType type;
    private String metadataCollectionId;
    private String omrsGuid;
    private MappableAssetState state;
    private ExistsInWKC existsInWkc;
    private String assetPath;
    private String relatedWkcAssetId;
    private List<MappableOMRSEntity> missingEntities = null;
    private List<MappableOMRSEntity> potentiallyMissingEntities = null;
    private List<MappableOMRSEntity> existingEntities = null;
    private List<MappableOMRSRelationship> existingRelationships = null;
    private List<MappableOMRSRelationship> missingRelationships = null;
    private Map<String, FailureInfo> failures = null;

    public MappableAssetSummary type(MappableAssetType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MappableAssetType getType() { return type; }
    public void setType(MappableAssetType type) { this.type = type; }

    public MappableAssetSummary metadataCollectionId(String metadataCollectionId) {
        this.metadataCollectionId = metadataCollectionId;
        return this;
    }

    /**
     * Get metadataCollectionId
     * @return metadataCollectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadataCollectionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMetadataCollectionId() { return metadataCollectionId; }
    public void setMetadataCollectionId(String metadataCollectionId) { this.metadataCollectionId = metadataCollectionId; }

    public MappableAssetSummary omrsGuid(String omrsGuid) {
        this.omrsGuid = omrsGuid;
        return this;
    }

    /**
     * Get omrsGuid
     * @return omrsGuid
     **/
    @javax.annotation.Nullable
    @JsonProperty("omrsGuid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOmrsGuid() { return omrsGuid; }
    public void setOmrsGuid(String omrsGuid) { this.omrsGuid = omrsGuid; }

    public MappableAssetSummary state(MappableAssetState state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MappableAssetState getState() { return state; }
    public void setState(MappableAssetState state) { this.state = state; }

    public MappableAssetSummary existsInWkc(ExistsInWKC existsInWkc) {
        this.existsInWkc = existsInWkc;
        return this;
    }

    /**
     * Get existsInWkc
     * @return existsInWkc
     **/
    @javax.annotation.Nullable
    @JsonProperty("existsInWkc")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ExistsInWKC getExistsInWkc() { return existsInWkc; }
    public void setExistsInWkc(ExistsInWKC existsInWkc) { this.existsInWkc = existsInWkc; }

    public MappableAssetSummary assetPath(String assetPath) {
        this.assetPath = assetPath;
        return this;
    }

    /**
     * Get assetPath
     * @return assetPath
     **/
    @javax.annotation.Nullable
    @JsonProperty("assetPath")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetPath() { return assetPath; }
    public void setAssetPath(String assetPath) { this.assetPath = assetPath; }

    public MappableAssetSummary relatedWkcAssetId(String relatedWkcAssetId) {
        this.relatedWkcAssetId = relatedWkcAssetId;
        return this;
    }

    /**
     * Get relatedWkcAssetId
     * @return relatedWkcAssetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("relatedWkcAssetId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRelatedWkcAssetId() { return relatedWkcAssetId; }
    public void setRelatedWkcAssetId(String relatedWkcAssetId) { this.relatedWkcAssetId = relatedWkcAssetId; }

    public MappableAssetSummary missingEntities(List<MappableOMRSEntity> missingEntities) {
        this.missingEntities = missingEntities;
        return this;
    }

    public MappableAssetSummary addMissingEntitiesItem(MappableOMRSEntity missingEntitiesItem) {
        if (this.missingEntities == null) {
            this.missingEntities = new ArrayList<>();
        }
        this.missingEntities.add(missingEntitiesItem);
        return this;
    }

    /**
     * Get missingEntities
     * @return missingEntities
     **/
    @javax.annotation.Nullable
    @JsonProperty("missingEntities")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableOMRSEntity> getMissingEntities() { return missingEntities; }
    public void setMissingEntities(List<MappableOMRSEntity> missingEntities) { this.missingEntities = missingEntities; }

    public MappableAssetSummary potentiallyMissingEntities(List<MappableOMRSEntity> potentiallyMissingEntities) {
        this.potentiallyMissingEntities = potentiallyMissingEntities;
        return this;
    }

    public MappableAssetSummary addPotentiallyMissingEntitiesItem(MappableOMRSEntity potentiallyMissingEntitiesItem) {
        if (this.potentiallyMissingEntities == null) {
            this.potentiallyMissingEntities = new ArrayList<>();
        }
        this.potentiallyMissingEntities.add(potentiallyMissingEntitiesItem);
        return this;
    }

    /**
     * Get potentiallyMissingEntities
     * @return potentiallyMissingEntities
     **/
    @javax.annotation.Nullable
    @JsonProperty("potentiallyMissingEntities")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableOMRSEntity> getPotentiallyMissingEntities() { return potentiallyMissingEntities; }
    public void setPotentiallyMissingEntities(List<MappableOMRSEntity> potentiallyMissingEntities) { this.potentiallyMissingEntities = potentiallyMissingEntities; }

    public MappableAssetSummary existingEntities(List<MappableOMRSEntity> existingEntities) {
        this.existingEntities = existingEntities;
        return this;
    }

    public MappableAssetSummary addExistingEntitiesItem(MappableOMRSEntity existingEntitiesItem) {
        if (this.existingEntities == null) {
            this.existingEntities = new ArrayList<>();
        }
        this.existingEntities.add(existingEntitiesItem);
        return this;
    }

    /**
     * Get existingEntities
     * @return existingEntities
     **/
    @javax.annotation.Nullable
    @JsonProperty("existingEntities")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableOMRSEntity> getExistingEntities() { return existingEntities; }
    public void setExistingEntities(List<MappableOMRSEntity> existingEntities) { this.existingEntities = existingEntities; }

    public MappableAssetSummary existingRelationships(List<MappableOMRSRelationship> existingRelationships) {
        this.existingRelationships = existingRelationships;
        return this;
    }

    public MappableAssetSummary addExistingRelationshipsItem(MappableOMRSRelationship existingRelationshipsItem) {
        if (this.existingRelationships == null) {
            this.existingRelationships = new ArrayList<>();
        }
        this.existingRelationships.add(existingRelationshipsItem);
        return this;
    }

    /**
     * Get existingRelationships
     * @return existingRelationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("existingRelationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableOMRSRelationship> getExistingRelationships() { return existingRelationships; }
    public void setExistingRelationships(List<MappableOMRSRelationship> existingRelationships) { this.existingRelationships = existingRelationships; }

    public MappableAssetSummary missingRelationships(List<MappableOMRSRelationship> missingRelationships) {
        this.missingRelationships = missingRelationships;
        return this;
    }

    public MappableAssetSummary addMissingRelationshipsItem(MappableOMRSRelationship missingRelationshipsItem) {
        if (this.missingRelationships == null) {
            this.missingRelationships = new ArrayList<>();
        }
        this.missingRelationships.add(missingRelationshipsItem);
        return this;
    }

    /**
     * Get missingRelationships
     * @return missingRelationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("missingRelationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableOMRSRelationship> getMissingRelationships() { return missingRelationships; }
    public void setMissingRelationships(List<MappableOMRSRelationship> missingRelationships) { this.missingRelationships = missingRelationships; }

    public MappableAssetSummary failures(Map<String, FailureInfo> failures) {
        this.failures = failures;
        return this;
    }

    public MappableAssetSummary putFailuresItem(String key, FailureInfo failuresItem) {
        if (this.failures == null) {
            this.failures = new HashMap<>();
        }
        this.failures.put(key, failuresItem);
        return this;
    }

    /**
     * Get failures
     * @return failures
     **/
    @javax.annotation.Nullable
    @JsonProperty("failures")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, FailureInfo> getFailures() { return failures; }
    public void setFailures(Map<String, FailureInfo> failures) { this.failures = failures; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MappableAssetSummary mappableAssetSummary = (MappableAssetSummary)o;
        return Objects.equals(this.type, mappableAssetSummary.type) &&
                Objects.equals(this.metadataCollectionId, mappableAssetSummary.metadataCollectionId) &&
                Objects.equals(this.omrsGuid, mappableAssetSummary.omrsGuid) &&
                Objects.equals(this.state, mappableAssetSummary.state) &&
                Objects.equals(this.existsInWkc, mappableAssetSummary.existsInWkc) &&
                Objects.equals(this.assetPath, mappableAssetSummary.assetPath) &&
                Objects.equals(this.relatedWkcAssetId, mappableAssetSummary.relatedWkcAssetId) &&
                Objects.equals(this.missingEntities, mappableAssetSummary.missingEntities) &&
                Objects.equals(this.potentiallyMissingEntities, mappableAssetSummary.potentiallyMissingEntities) &&
                Objects.equals(this.existingEntities, mappableAssetSummary.existingEntities) &&
                Objects.equals(this.existingRelationships, mappableAssetSummary.existingRelationships) &&
                Objects.equals(this.missingRelationships, mappableAssetSummary.missingRelationships) &&
                Objects.equals(this.failures, mappableAssetSummary.failures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, metadataCollectionId, omrsGuid, state,
                existsInWkc, assetPath, relatedWkcAssetId,
                missingEntities, potentiallyMissingEntities,
                existingEntities, existingRelationships,
                missingRelationships, failures);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MappableAssetSummary {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    metadataCollectionId: ").append(toIndentedString(metadataCollectionId)).append("\n");
        sb.append("    omrsGuid: ").append(toIndentedString(omrsGuid)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    existsInWkc: ").append(toIndentedString(existsInWkc)).append("\n");
        sb.append("    assetPath: ").append(toIndentedString(assetPath)).append("\n");
        sb.append("    relatedWkcAssetId: ").append(toIndentedString(relatedWkcAssetId)).append("\n");
        sb.append("    missingEntities: ").append(toIndentedString(missingEntities)).append("\n");
        sb.append("    potentiallyMissingEntities: ").append(toIndentedString(potentiallyMissingEntities)).append("\n");
        sb.append("    existingEntities: ").append(toIndentedString(existingEntities)).append("\n");
        sb.append("    existingRelationships: ").append(toIndentedString(existingRelationships)).append("\n");
        sb.append("    missingRelationships: ").append(toIndentedString(missingRelationships)).append("\n");
        sb.append("    failures: ").append(toIndentedString(failures)).append("\n");
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
