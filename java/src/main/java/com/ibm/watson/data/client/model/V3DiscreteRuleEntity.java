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
 * entity object within the response for the /v3/enforcement/governed_items/discrete/{governanceTypeName}/{itemId} API
 */
public class V3DiscreteRuleEntity {

    private Action action;
    private String governanceType;
    private String policyId;
    private String ruleId;
    private List<Object> trigger = new ArrayList<>();

    public V3DiscreteRuleEntity action(Action action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     * @return action
     **/
    @javax.annotation.Nonnull
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Action getAction() {
        return action;
    }
    public void setAction(Action action) {
        this.action = action;
    }

    public V3DiscreteRuleEntity governanceType(String governanceType) {
        this.governanceType = governanceType;
        return this;
    }

    /**
     * governance type of the discrete rule
     * @return governanceType
     **/
    @javax.annotation.Nonnull
    @JsonProperty("governance_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGovernanceType() {
        return governanceType;
    }
    public void setGovernanceType(String governanceType) {
        this.governanceType = governanceType;
    }

    public V3DiscreteRuleEntity policyId(String policyId) {
        this.policyId = policyId;
        return this;
    }

    /**
     * policy id of the discrete rule
     * @return policyId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("policy_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getPolicyId() {
        return policyId;
    }
    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public V3DiscreteRuleEntity ruleId(String ruleId) {
        this.ruleId = ruleId;
        return this;
    }

    /**
     * id of the discrete rule
     * @return ruleId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("rule_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public V3DiscreteRuleEntity trigger(List<Object> trigger) {
        this.trigger = trigger;
        return this;
    }

    public V3DiscreteRuleEntity addTriggerItem(Object triggerItem) {
        this.trigger.add(triggerItem);
        return this;
    }

    /**
     * Nested arrays representing a trigger expression within policy management rules.  See the description on the POST /v3/enforcement/rules for more details.
     * @return trigger
     **/
    @javax.annotation.Nonnull
    @JsonProperty("trigger")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Object> getTrigger() {
        return trigger;
    }
    public void setTrigger(List<Object> trigger) {
        this.trigger = trigger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3DiscreteRuleEntity v3DiscreteRuleEntity = (V3DiscreteRuleEntity) o;
        return Objects.equals(this.action, v3DiscreteRuleEntity.action) &&
                Objects.equals(this.governanceType, v3DiscreteRuleEntity.governanceType) &&
                Objects.equals(this.policyId, v3DiscreteRuleEntity.policyId) &&
                Objects.equals(this.ruleId, v3DiscreteRuleEntity.ruleId) &&
                Objects.equals(this.trigger, v3DiscreteRuleEntity.trigger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, governanceType, policyId, ruleId, trigger);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3DiscreteRuleEntity {\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    governanceType: ").append(toIndentedString(governanceType)).append("\n");
        sb.append("    policyId: ").append(toIndentedString(policyId)).append("\n");
        sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
        sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
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
