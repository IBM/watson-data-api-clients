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
import com.ibm.watson.data.client.model.enums.MappableOMRSRelationship;
import com.ibm.watson.data.client.model.enums.PurgeStatus;

import java.util.Objects;

/**
 * RelationshipNode
 */
public class RelationshipNode {

    private MappableOMRSRelationship relationshipType;
    private String omrsGuid;
    private String messageAssetId;
    private String targetGuid;
    private EntityNode target;
    private FailureInfo failureInfo;
    private PurgeStatus purgeStatus;

    public RelationshipNode relationshipType(MappableOMRSRelationship relationshipType) {
        this.relationshipType = relationshipType;
        return this;
    }

    /**
     * Get relationshipType
     * @return relationshipType
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationshipType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MappableOMRSRelationship getRelationshipType() { return relationshipType; }
    public void setRelationshipType(MappableOMRSRelationship relationshipType) { this.relationshipType = relationshipType; }

    public RelationshipNode omrsGuid(String omrsGuid) {
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

    public RelationshipNode messageAssetId(String messageAssetId) {
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

    public RelationshipNode targetGuid(String targetGuid) {
        this.targetGuid = targetGuid;
        return this;
    }

    /**
     * Get targetGuid
     * @return targetGuid
     **/
    @javax.annotation.Nullable
    @JsonProperty("targetGuid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetGuid() { return targetGuid; }
    public void setTargetGuid(String targetGuid) { this.targetGuid = targetGuid; }

    public RelationshipNode target(EntityNode target) {
        this.target = target;
        return this;
    }

    /**
     * Get target
     * @return target
     **/
    @javax.annotation.Nullable
    @JsonProperty("target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EntityNode getTarget() { return target; }
    public void setTarget(EntityNode target) { this.target = target; }

    public RelationshipNode failureInfo(FailureInfo failureInfo) {
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

    public RelationshipNode purgeStatus(PurgeStatus purgeStatus) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RelationshipNode relationshipNode = (RelationshipNode)o;
        return Objects.equals(this.relationshipType, relationshipNode.relationshipType) &&
                Objects.equals(this.omrsGuid, relationshipNode.omrsGuid) &&
                Objects.equals(this.messageAssetId, relationshipNode.messageAssetId) &&
                Objects.equals(this.targetGuid, relationshipNode.targetGuid) &&
                Objects.equals(this.target, relationshipNode.target) &&
                Objects.equals(this.failureInfo, relationshipNode.failureInfo) &&
                Objects.equals(this.purgeStatus, relationshipNode.purgeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipType, omrsGuid, messageAssetId, targetGuid,
                target, failureInfo, purgeStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RelationshipNode {\n");
        sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
        sb.append("    omrsGuid: ").append(toIndentedString(omrsGuid)).append("\n");
        sb.append("    messageAssetId: ").append(toIndentedString(messageAssetId)).append("\n");
        sb.append("    targetGuid: ").append(toIndentedString(targetGuid)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
        sb.append("    failureInfo: ").append(toIndentedString(failureInfo)).append("\n");
        sb.append("    purgeStatus: ").append(toIndentedString(purgeStatus)).append("\n");
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
