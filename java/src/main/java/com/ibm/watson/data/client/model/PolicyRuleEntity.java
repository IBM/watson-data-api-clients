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
import com.ibm.watson.data.client.model.enums.DataProtectionRuleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Request for the POST and PUT /v2/policy_rules APIs
 */
public class PolicyRuleEntity {

    private String name;
    private String description;
    private String governanceTypeId;
    private List<Object> trigger = new ArrayList<>();
    private PolicyRuleAction action;
    private DataProtectionRuleState state;

    public PolicyRuleEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the displayed name for the rule
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public PolicyRuleEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * a more detailed description of the rule
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public PolicyRuleEntity governanceTypeId(String governanceTypeId) {
        this.governanceTypeId = governanceTypeId;
        return this;
    }

    /**
     * the name of a governance type of this rule
     * @return governanceTypeId
     **/
    @JsonProperty("governance_type_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGovernanceTypeId() { return governanceTypeId; }
    public void setGovernanceTypeId(String governanceTypeId) { this.governanceTypeId = governanceTypeId; }

    public PolicyRuleEntity trigger(List<Object> trigger) {
        this.trigger = trigger;
        return this;
    }

    public PolicyRuleEntity addTriggerItem(Object triggerItem) {
        this.trigger.add(triggerItem);
        return this;
    }

    /**
     * Nested arrays representing a trigger expression within policy management
     * rules.  See the description on the POST /v2/policyRules for more details.
     * @return trigger
     **/
    @JsonProperty("trigger")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Object> getTrigger() { return trigger; }
    public void setTrigger(List<Object> trigger) { this.trigger = trigger; }

    public PolicyRuleEntity action(PolicyRuleAction action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     * @return action
     **/
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public PolicyRuleAction getAction() { return action; }
    public void setAction(PolicyRuleAction action) { this.action = action; }

    public PolicyRuleEntity state(DataProtectionRuleState state) {
        this.state = state;
        return this;
    }

    /**
     * the state of the rule.  Only the rules of policies in active are enforced.
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataProtectionRuleState getState() { return state; }
    public void setState(DataProtectionRuleState state) { this.state = state; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRuleEntity policyRuleRequest = (PolicyRuleEntity)o;
        return Objects.equals(this.name, policyRuleRequest.name) &&
                Objects.equals(this.description, policyRuleRequest.description) &&
                Objects.equals(this.governanceTypeId, policyRuleRequest.governanceTypeId) &&
                Objects.equals(this.trigger, policyRuleRequest.trigger) &&
                Objects.equals(this.action, policyRuleRequest.action) &&
                Objects.equals(this.state, policyRuleRequest.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, governanceTypeId, trigger, action,
                state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRuleRequest {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    governanceTypeId: ").append(toIndentedString(governanceTypeId)).append("\n");
        sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
