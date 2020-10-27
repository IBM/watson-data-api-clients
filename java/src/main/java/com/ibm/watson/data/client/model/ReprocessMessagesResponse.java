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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ReprocessMessagesResponse
 */
public class ReprocessMessagesResponse {

    private ReprocessMessagesOptions options;
    private Integer totalEntityGuidsSubmitted;
    private Integer totalRelationshipGuidsSubmitted;
    private Map<String, List<String>> entityGuidsSubmitted = null;
    private Map<String, List<String>> relationshipGuidsSubmitted = null;

    public ReprocessMessagesResponse options(ReprocessMessagesOptions options) {
        this.options = options;
        return this;
    }

    /**
     * Get options
     * @return options
     **/
    @javax.annotation.Nullable
    @JsonProperty("options")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ReprocessMessagesOptions getOptions() { return options; }
    public void setOptions(ReprocessMessagesOptions options) { this.options = options; }

    public ReprocessMessagesResponse totalEntityGuidsSubmitted(Integer totalEntityGuidsSubmitted) {
        this.totalEntityGuidsSubmitted = totalEntityGuidsSubmitted;
        return this;
    }

    /**
     * Get totalEntityGuidsSubmitted
     * @return totalEntityGuidsSubmitted
     **/
    @javax.annotation.Nullable
    @JsonProperty("totalEntityGuidsSubmitted")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalEntityGuidsSubmitted() { return totalEntityGuidsSubmitted; }
    public void setTotalEntityGuidsSubmitted(Integer totalEntityGuidsSubmitted) { this.totalEntityGuidsSubmitted = totalEntityGuidsSubmitted; }

    public ReprocessMessagesResponse totalRelationshipGuidsSubmitted(Integer totalRelationshipGuidsSubmitted) {
        this.totalRelationshipGuidsSubmitted = totalRelationshipGuidsSubmitted;
        return this;
    }

    /**
     * Get totalRelationshipGuidsSubmitted
     * @return totalRelationshipGuidsSubmitted
     **/
    @javax.annotation.Nullable
    @JsonProperty("totalRelationshipGuidsSubmitted")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalRelationshipGuidsSubmitted() { return totalRelationshipGuidsSubmitted; }
    public void setTotalRelationshipGuidsSubmitted(Integer totalRelationshipGuidsSubmitted) { this.totalRelationshipGuidsSubmitted = totalRelationshipGuidsSubmitted; }

    public ReprocessMessagesResponse entityGuidsSubmitted(Map<String, List<String>> entityGuidsSubmitted) {
        this.entityGuidsSubmitted = entityGuidsSubmitted;
        return this;
    }

    public ReprocessMessagesResponse putEntityGuidsSubmittedItem(String key, List<String> entityGuidsSubmittedItem) {
        if (this.entityGuidsSubmitted == null) {
            this.entityGuidsSubmitted = new HashMap<>();
        }
        this.entityGuidsSubmitted.put(key, entityGuidsSubmittedItem);
        return this;
    }

    /**
     * Get entityGuidsSubmitted
     * @return entityGuidsSubmitted
     **/
    @javax.annotation.Nullable
    @JsonProperty("entityGuidsSubmitted")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, List<String>> getEntityGuidsSubmitted() { return entityGuidsSubmitted; }
    public void setEntityGuidsSubmitted(Map<String, List<String>> entityGuidsSubmitted) { this.entityGuidsSubmitted = entityGuidsSubmitted; }

    public ReprocessMessagesResponse relationshipGuidsSubmitted(Map<String, List<String>> relationshipGuidsSubmitted) {
        this.relationshipGuidsSubmitted = relationshipGuidsSubmitted;
        return this;
    }

    public ReprocessMessagesResponse putRelationshipGuidsSubmittedItem(String key, List<String> relationshipGuidsSubmittedItem) {
        if (this.relationshipGuidsSubmitted == null) {
            this.relationshipGuidsSubmitted = new HashMap<>();
        }
        this.relationshipGuidsSubmitted.put(key, relationshipGuidsSubmittedItem);
        return this;
    }

    /**
     * Get relationshipGuidsSubmitted
     * @return relationshipGuidsSubmitted
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationshipGuidsSubmitted")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, List<String>> getRelationshipGuidsSubmitted() { return relationshipGuidsSubmitted; }
    public void setRelationshipGuidsSubmitted(Map<String, List<String>> relationshipGuidsSubmitted) { this.relationshipGuidsSubmitted = relationshipGuidsSubmitted; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ReprocessMessagesResponse reprocessMessagesResponse = (ReprocessMessagesResponse)o;
        return Objects.equals(this.options, reprocessMessagesResponse.options) &&
                Objects.equals(this.totalEntityGuidsSubmitted, reprocessMessagesResponse.totalEntityGuidsSubmitted) &&
                Objects.equals(this.totalRelationshipGuidsSubmitted, reprocessMessagesResponse.totalRelationshipGuidsSubmitted) &&
                Objects.equals(this.entityGuidsSubmitted, reprocessMessagesResponse.entityGuidsSubmitted) &&
                Objects.equals(this.relationshipGuidsSubmitted, reprocessMessagesResponse.relationshipGuidsSubmitted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, totalEntityGuidsSubmitted,
                totalRelationshipGuidsSubmitted, entityGuidsSubmitted,
                relationshipGuidsSubmitted);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReprocessMessagesResponse {\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
        sb.append("    totalEntityGuidsSubmitted: ").append(toIndentedString(totalEntityGuidsSubmitted)).append("\n");
        sb.append("    totalRelationshipGuidsSubmitted: ").append(toIndentedString(totalRelationshipGuidsSubmitted)).append("\n");
        sb.append("    entityGuidsSubmitted: ").append(toIndentedString(entityGuidsSubmitted)).append("\n");
        sb.append("    relationshipGuidsSubmitted: ").append(toIndentedString(relationshipGuidsSubmitted)).append("\n");
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
