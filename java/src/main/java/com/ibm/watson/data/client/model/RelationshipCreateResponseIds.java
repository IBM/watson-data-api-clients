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
import java.util.Objects;

/**
 * RelationshipCreateResponseIds
 */
public class RelationshipCreateResponseIds {

    private String relationshipId;
    private String targetId;

    public RelationshipCreateResponseIds relationshipId(String relationshipId) {
        this.relationshipId = relationshipId;
        return this;
    }

    /**
     * Get relationshipId
     * @return relationshipId
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationship_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRelationshipId() { return relationshipId; }
    public void setRelationshipId(String relationshipId) { this.relationshipId = relationshipId; }

    public RelationshipCreateResponseIds targetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    /**
     * Get targetId
     * @return targetId
     **/
    @javax.annotation.Nullable
    @JsonProperty("target_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetId() { return targetId; }
    public void setTargetId(String targetId) { this.targetId = targetId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RelationshipCreateResponseIds relationshipCreateResponseIds = (RelationshipCreateResponseIds)o;
        return Objects.equals(this.relationshipId, relationshipCreateResponseIds.relationshipId) &&
                Objects.equals(this.targetId, relationshipCreateResponseIds.targetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipId, targetId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RelationshipCreateResponseIds {\n");
        sb.append("    relationshipId: ").append(toIndentedString(relationshipId)).append("\n");
        sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
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
