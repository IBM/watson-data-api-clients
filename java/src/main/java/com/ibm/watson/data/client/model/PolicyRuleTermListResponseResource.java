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
 * resource object within the response for the /v3/policy_rules/{ruleId}/terms API
 */
public class PolicyRuleTermListResponseResource {

    private PolicyRuleTermListResponseEntity entity;
    private PolicyResourceForeignEntityMetadata metadata;

    public PolicyRuleTermListResponseResource entity(PolicyRuleTermListResponseEntity entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Get entity
     * @return entity
     **/
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public PolicyRuleTermListResponseEntity getEntity() { return entity; }
    public void setEntity(PolicyRuleTermListResponseEntity entity) { this.entity = entity; }


    public PolicyRuleTermListResponseResource metadata(PolicyResourceForeignEntityMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public PolicyResourceForeignEntityMetadata getMetadata() { return metadata; }
    public void setMetadata(PolicyResourceForeignEntityMetadata metadata) { this.metadata = metadata; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRuleTermListResponseResource policyRuleTermListResponseResource = (PolicyRuleTermListResponseResource) o;
        return Objects.equals(this.entity, policyRuleTermListResponseResource.entity) &&
                Objects.equals(this.metadata, policyRuleTermListResponseResource.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entity, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRuleTermListResponseResource {\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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