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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.watson.data.client.serde.AbstractRelationshipEntityDeserializer;

import java.util.Objects;

/**
 * AbstractRelationshipEntity
 */
@JsonDeserialize(using = AbstractRelationshipEntityDeserializer.class)
public class AbstractRelationshipEntity {

    private String description;
    private String relationshipType;
    private String sourceType;
    private String targetType;

    public AbstractRelationshipEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the relationship.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public AbstractRelationshipEntity relationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("relationship_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) { this.relationshipType = relationshipType; }

    public AbstractRelationshipEntity sourceType(String sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("source_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSourceType() { return sourceType; }
    public void setSourceType(String sourceType) { this.sourceType = sourceType; }

    public AbstractRelationshipEntity targetType(String targetType) {
        this.targetType = targetType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("target_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTargetType() { return targetType; }
    public void setTargetType(String targetType) { this.targetType = targetType; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AbstractRelationshipEntity abstractRelationshipEntity = (AbstractRelationshipEntity)o;
        return Objects.equals(this.description, abstractRelationshipEntity.description) &&
                Objects.equals(this.relationshipType, abstractRelationshipEntity.relationshipType) &&
                Objects.equals(this.sourceType, abstractRelationshipEntity.sourceType) &&
                Objects.equals(this.targetType, abstractRelationshipEntity.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, relationshipType, sourceType, targetType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AbstractRelationshipEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
        sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
        sb.append("    targetType: ").append(toIndentedString(targetType)).append("\n");
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
