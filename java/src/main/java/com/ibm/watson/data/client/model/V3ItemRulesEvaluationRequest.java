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
 * Request for the POST /v3/enforcement/governed_item/rules/evaluate/operationName API
 */
public class V3ItemRulesEvaluationRequest {

    private List<String> itemIds = new ArrayList<>();
    private List<V3PolicyRuleRequest> requestRules = new ArrayList<>();
    private PolicyEnforcementContext context;
    private List<PolicyRule> rules = null;

    public V3ItemRulesEvaluationRequest itemIds(List<String> itemIds) {
        this.itemIds = itemIds;
        return this;
    }

    public V3ItemRulesEvaluationRequest addItemIdsItem(String itemIdsItem) {
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

    public V3ItemRulesEvaluationRequest requestRules(List<V3PolicyRuleRequest> requestRules) {
        this.requestRules = requestRules;
        return this;
    }

    public V3ItemRulesEvaluationRequest addRequestRulesItem(V3PolicyRuleRequest requestRulesItem) {
        this.requestRules.add(requestRulesItem);
        return this;
    }

    /**
     * Get requestRules
     * @return requestRules
     **/
    @javax.annotation.Nonnull
    @JsonProperty("requestRules")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<V3PolicyRuleRequest> getRequestRules() {
        return requestRules;
    }
    public void setRequestRules(List<V3PolicyRuleRequest> requestRules) {
        this.requestRules = requestRules;
    }

    public V3ItemRulesEvaluationRequest context(PolicyEnforcementContext context) {
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

    public V3ItemRulesEvaluationRequest rules(List<PolicyRule> rules) {
        this.rules = rules;
        return this;
    }

    public V3ItemRulesEvaluationRequest addRulesItem(PolicyRule rulesItem) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rulesItem);
        return this;
    }

    /**
     * Get rules
     * @return rules
     **/
    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<PolicyRule> getRules() {
        return rules;
    }
    public void setRules(List<PolicyRule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3ItemRulesEvaluationRequest v3ItemRulesEvaluationRequest = (V3ItemRulesEvaluationRequest) o;
        return Objects.equals(this.itemIds, v3ItemRulesEvaluationRequest.itemIds) &&
                Objects.equals(this.requestRules, v3ItemRulesEvaluationRequest.requestRules) &&
                Objects.equals(this.context, v3ItemRulesEvaluationRequest.context) &&
                Objects.equals(this.rules, v3ItemRulesEvaluationRequest.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIds, requestRules, context, rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3ItemRulesEvaluationRequest {\n");
        sb.append("    itemIds: ").append(toIndentedString(itemIds)).append("\n");
        sb.append("    requestRules: ").append(toIndentedString(requestRules)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
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
