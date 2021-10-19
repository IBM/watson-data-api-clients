/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * resource object within the response for the /v3/enforcement/governed_items/discrete/{governanceTypeName}/{itemId} API
 */
public class V3DiscreteRulesResponseResource {

    private String containerId;
    private String itemId;
    private String columnName;
    private V3DiscreteRuleEntity rule;
    private V3DiscreteRuleMetadataEntity metadata;

    public V3DiscreteRulesResponseResource containerId(String containerId) {
        this.containerId = containerId;
        return this;
    }

    /**
     * container that holds the item of the discrete rule
     * @return containerId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("container_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getContainerId() {
        return containerId;
    }
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public V3DiscreteRulesResponseResource itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * item that was targeted by the discrete rule
     * @return itemId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("item_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public V3DiscreteRulesResponseResource columnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    /**
     * column name that was targeted by the discrete rule
     * @return columnName
     **/
    @javax.annotation.Nullable
    @JsonProperty("column_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public V3DiscreteRulesResponseResource rule(V3DiscreteRuleEntity rule) {
        this.rule = rule;
        return this;
    }

    /**
     * Get rule
     * @return rule
     **/
    @javax.annotation.Nonnull
    @JsonProperty("rule")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public V3DiscreteRuleEntity getRule() {
        return rule;
    }
    public void setRule(V3DiscreteRuleEntity rule) {
        this.rule = rule;
    }

    public V3DiscreteRulesResponseResource metadata(V3DiscreteRuleMetadataEntity metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public V3DiscreteRuleMetadataEntity getMetadata() {
        return metadata;
    }
    public void setMetadata(V3DiscreteRuleMetadataEntity metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3DiscreteRulesResponseResource v3DiscreteRulesResponseResource = (V3DiscreteRulesResponseResource) o;
        return Objects.equals(this.containerId, v3DiscreteRulesResponseResource.containerId) &&
                Objects.equals(this.itemId, v3DiscreteRulesResponseResource.itemId) &&
                Objects.equals(this.columnName, v3DiscreteRulesResponseResource.columnName) &&
                Objects.equals(this.rule, v3DiscreteRulesResponseResource.rule) &&
                Objects.equals(this.metadata, v3DiscreteRulesResponseResource.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerId, itemId, columnName, rule, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3DiscreteRulesResponseResource {\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
        sb.append("    columnName: ").append(toIndentedString(columnName)).append("\n");
        sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
