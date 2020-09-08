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

import java.util.Objects;

/**
 * RelationshipEntity
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class RelationshipEntity extends AbstractRelationshipEntity {

    private String targetId;
    private String targetGlobalId;
    private String targetName;
    private String targetHref;

    public RelationshipEntity targetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    /**
     * ID of the referenced entity.
     * @return targetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("target_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetId() { return targetId; }
    public void setTargetId(String targetId) { this.targetId = targetId; }

    public RelationshipEntity targetGlobalId(String targetGlobalId) {
        this.targetGlobalId = targetGlobalId;
        return this;
    }

    /**
     * Global ID of the referenced entity.
     * @return targetGlobalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("target_global_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetGlobalId() { return targetGlobalId; }
    public void setTargetGlobalId(String targetGlobalId) { this.targetGlobalId = targetGlobalId; }

    public RelationshipEntity targetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    /**
     * Name of the referenced entity.
     * @return targetName
     **/
    @javax.annotation.Nullable
    @JsonProperty("target_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetName() { return targetName; }
    public void setTargetName(String targetName) { this.targetName = targetName; }

    public RelationshipEntity targetHref(String targetHref) {
        this.targetHref = targetHref;
        return this;
    }

    /**
     * The URI to access the referenced entity.
     * @return targetHref
     **/
    @javax.annotation.Nullable
    @JsonProperty("target_href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetHref() { return targetHref; }
    public void setTargetHref(String targetHref) { this.targetHref = targetHref; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RelationshipEntity relationshipEntity = (RelationshipEntity)o;
        return super.equals(o) &&
                Objects.equals(this.targetId, relationshipEntity.targetId) &&
                Objects.equals(this.targetGlobalId, relationshipEntity.targetGlobalId) &&
                Objects.equals(this.targetName, relationshipEntity.targetName) &&
                Objects.equals(this.targetHref, relationshipEntity.targetHref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), targetId, targetGlobalId, targetName,
                targetHref);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RelationshipEntity {\n");
        super.toString(sb);
        sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
        sb.append("    targetGlobalId: ").append(toIndentedString(targetGlobalId)).append("\n");
        sb.append("    targetName: ").append(toIndentedString(targetName)).append("\n");
        sb.append("    targetHref: ").append(toIndentedString(targetHref)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
