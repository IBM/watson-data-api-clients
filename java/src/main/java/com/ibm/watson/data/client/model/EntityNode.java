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
import java.util.List;
import java.util.Objects;

/**
 * EntityNode
 */
public class EntityNode {

    private MappableOMRSEntity entityType;
    private MappableEntityType mappableType;
    private String omrsGuid;
    private String messageAssetId;
    private List<MappableOMRSRelationship> prunedRelationships = null;
    private EntityStatus status;
    private PurgeStatus purgeStatus;
    private FailureInfo failureInfo;
    private List<RelationshipNode> relationships = null;
    private Boolean pruned;
    private Boolean missing;

    public EntityNode entityType(MappableOMRSEntity entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * Get entityType
     * @return entityType
     **/
    @javax.annotation.Nullable
    @JsonProperty("entityType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MappableOMRSEntity getEntityType() { return entityType; }
    public void setEntityType(MappableOMRSEntity entityType) { this.entityType = entityType; }

    public EntityNode mappableType(MappableEntityType mappableType) {
        this.mappableType = mappableType;
        return this;
    }

    /**
     * Get mappableType
     * @return mappableType
     **/
    @javax.annotation.Nullable
    @JsonProperty("mappableType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MappableEntityType getMappableType() { return mappableType; }
    public void setMappableType(MappableEntityType mappableType) { this.mappableType = mappableType; }

    public EntityNode omrsGuid(String omrsGuid) {
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

    public EntityNode messageAssetId(String messageAssetId) {
        this.messageAssetId = messageAssetId;
        return this;
    }

    /**
     * Get messageAssetId
     * @return messageAssetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("messageAssetId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessageAssetId() { return messageAssetId; }
    public void setMessageAssetId(String messageAssetId) { this.messageAssetId = messageAssetId; }

    public EntityNode prunedRelationships(List<MappableOMRSRelationship> prunedRelationships) {
        this.prunedRelationships = prunedRelationships;
        return this;
    }

    public EntityNode addPrunedRelationshipsItem(MappableOMRSRelationship prunedRelationshipsItem) {
        if (this.prunedRelationships == null) {
            this.prunedRelationships = new ArrayList<>();
        }
        this.prunedRelationships.add(prunedRelationshipsItem);
        return this;
    }

    /**
     * Get prunedRelationships
     * @return prunedRelationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("prunedRelationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MappableOMRSRelationship> getPrunedRelationships() { return prunedRelationships; }
    public void setPrunedRelationships(List<MappableOMRSRelationship> prunedRelationships) { this.prunedRelationships = prunedRelationships; }

    public EntityNode status(EntityStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EntityStatus getStatus() { return status; }
    public void setStatus(EntityStatus status) { this.status = status; }

    public EntityNode purgeStatus(PurgeStatus purgeStatus) {
        this.purgeStatus = purgeStatus;
        return this;
    }

    /**
     * Get purgeStatus
     * @return purgeStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("purgeStatus")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PurgeStatus getPurgeStatus() { return purgeStatus; }
    public void setPurgeStatus(PurgeStatus purgeStatus) { this.purgeStatus = purgeStatus; }

    public EntityNode failureInfo(FailureInfo failureInfo) {
        this.failureInfo = failureInfo;
        return this;
    }

    /**
     * Get failureInfo
     * @return failureInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("failureInfo")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public FailureInfo getFailureInfo() { return failureInfo; }
    public void setFailureInfo(FailureInfo failureInfo) { this.failureInfo = failureInfo; }

    public EntityNode relationships(List<RelationshipNode> relationships) {
        this.relationships = relationships;
        return this;
    }

    public EntityNode addRelationshipsItem(RelationshipNode relationshipsItem) {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        this.relationships.add(relationshipsItem);
        return this;
    }

    /**
     * Get relationships
     * @return relationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RelationshipNode> getRelationships() { return relationships; }
    public void setRelationships(List<RelationshipNode> relationships) { this.relationships = relationships; }

    public EntityNode pruned(Boolean pruned) {
        this.pruned = pruned;
        return this;
    }

    /**
     * Get pruned
     * @return pruned
     **/
    @javax.annotation.Nullable
    @JsonProperty("pruned")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getPruned() { return pruned; }
    public void setPruned(Boolean pruned) { this.pruned = pruned; }

    public EntityNode missing(Boolean missing) {
        this.missing = missing;
        return this;
    }

    /**
     * Get missing
     * @return missing
     **/
    @javax.annotation.Nullable
    @JsonProperty("missing")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getMissing() { return missing; }
    public void setMissing(Boolean missing) { this.missing = missing; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EntityNode entityNode = (EntityNode)o;
        return Objects.equals(this.entityType, entityNode.entityType) &&
                Objects.equals(this.mappableType, entityNode.mappableType) &&
                Objects.equals(this.omrsGuid, entityNode.omrsGuid) &&
                Objects.equals(this.messageAssetId, entityNode.messageAssetId) &&
                Objects.equals(this.prunedRelationships, entityNode.prunedRelationships) &&
                Objects.equals(this.status, entityNode.status) &&
                Objects.equals(this.purgeStatus, entityNode.purgeStatus) &&
                Objects.equals(this.failureInfo, entityNode.failureInfo) &&
                Objects.equals(this.relationships, entityNode.relationships) &&
                Objects.equals(this.pruned, entityNode.pruned) &&
                Objects.equals(this.missing, entityNode.missing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityType, mappableType, omrsGuid, messageAssetId,
                prunedRelationships, status, purgeStatus, failureInfo,
                relationships, pruned, missing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityNode {\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    mappableType: ").append(toIndentedString(mappableType)).append("\n");
        sb.append("    omrsGuid: ").append(toIndentedString(omrsGuid)).append("\n");
        sb.append("    messageAssetId: ").append(toIndentedString(messageAssetId)).append("\n");
        sb.append("    prunedRelationships: ").append(toIndentedString(prunedRelationships)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    purgeStatus: ").append(toIndentedString(purgeStatus)).append("\n");
        sb.append("    failureInfo: ").append(toIndentedString(failureInfo)).append("\n");
        sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
        sb.append("    pruned: ").append(toIndentedString(pruned)).append("\n");
        sb.append("    missing: ").append(toIndentedString(missing)).append("\n");
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
