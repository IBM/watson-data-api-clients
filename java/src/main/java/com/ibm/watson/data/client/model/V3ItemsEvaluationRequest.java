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
import java.util.ArrayList;
import java.util.List;

/**
 * Request for the POST /v3/enforcement/governed_item/evaluate/operationName API
 */
public class V3ItemsEvaluationRequest {

    private List<String> itemIds = new ArrayList<>();
    private List<V3ItemAndOperation> itemOpPairs = null;
    private PolicyEnforcementContext context;

    public V3ItemsEvaluationRequest itemIds(List<String> itemIds) {
        this.itemIds = itemIds;
        return this;
    }

    public V3ItemsEvaluationRequest addItemIdsItem(String itemIdsItem) {
        this.itemIds.add(itemIdsItem);
        return this;
    }

    /**
     * Get itemIds
     * @return itemIds
     **/
    @javax.annotation.Nonnull
    @JsonProperty("item_ids")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getItemIds() {
        return itemIds;
    }
    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public V3ItemsEvaluationRequest itemOpPairs(List<V3ItemAndOperation> itemOpPairs) {
        this.itemOpPairs = itemOpPairs;
        return this;
    }

    public V3ItemsEvaluationRequest addItemOpPairsItem(V3ItemAndOperation itemOpPairsItem) {
        if (this.itemOpPairs == null) {
            this.itemOpPairs = new ArrayList<>();
        }
        this.itemOpPairs.add(itemOpPairsItem);
        return this;
    }

    /**
     * Get itemOpPairs
     * @return itemOpPairs
     **/
    @javax.annotation.Nullable
    @JsonProperty("item_op_pairs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<V3ItemAndOperation> getItemOpPairs() {
        return itemOpPairs;
    }
    public void setItemOpPairs(List<V3ItemAndOperation> itemOpPairs) {
        this.itemOpPairs = itemOpPairs;
    }

    public V3ItemsEvaluationRequest context(PolicyEnforcementContext context) {
        this.context = context;
        return this;
    }

    /**
     * Get context
     * @return context
     **/
    @javax.annotation.Nonnull
    @JsonProperty("context")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public PolicyEnforcementContext getContext() {
        return context;
    }
    public void setContext(PolicyEnforcementContext context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3ItemsEvaluationRequest v3ItemsEvaluationRequest = (V3ItemsEvaluationRequest) o;
        return Objects.equals(this.itemIds, v3ItemsEvaluationRequest.itemIds) &&
                Objects.equals(this.itemOpPairs, v3ItemsEvaluationRequest.itemOpPairs) &&
                Objects.equals(this.context, v3ItemsEvaluationRequest.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIds, itemOpPairs, context);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3ItemsEvaluationRequest {\n");
        sb.append("    itemIds: ").append(toIndentedString(itemIds)).append("\n");
        sb.append("    itemOpPairs: ").append(toIndentedString(itemOpPairs)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
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
