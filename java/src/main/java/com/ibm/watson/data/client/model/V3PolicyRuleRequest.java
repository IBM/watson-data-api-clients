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
import com.ibm.watson.data.client.model.enums.PolicyRuleState;

import java.util.ArrayList;
import java.util.List;

/**
 * Request for the POST and PUT /v3/enforcement/rules APIs
 */
public class V3PolicyRuleRequest {

    private String name;
    private String description;
    private String governanceTypeId;
    private List<Object> trigger = new ArrayList<>();
    private PolicyRuleAction action;
    private PolicyRuleState state;

    public V3PolicyRuleRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the displayed name for the rule
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public V3PolicyRuleRequest description(String description) {
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public V3PolicyRuleRequest governanceTypeId(String governanceTypeId) {
        this.governanceTypeId = governanceTypeId;
        return this;
    }

    /**
     * the name of a governance type of this rule
     * @return governanceTypeId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("governance_type_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGovernanceTypeId() {
        return governanceTypeId;
    }
    public void setGovernanceTypeId(String governanceTypeId) {
        this.governanceTypeId = governanceTypeId;
    }

    public V3PolicyRuleRequest trigger(List<Object> trigger) {
        this.trigger = trigger;
        return this;
    }

    public V3PolicyRuleRequest addTriggerItem(Object triggerItem) {
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

    public V3PolicyRuleRequest action(PolicyRuleAction action) {
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
    public PolicyRuleAction getAction() {
        return action;
    }
    public void setAction(PolicyRuleAction action) {
        this.action = action;
    }

    public V3PolicyRuleRequest state(PolicyRuleState state) {
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
    public PolicyRuleState getState() {
        return state;
    }
    public void setState(PolicyRuleState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3PolicyRuleRequest v3PolicyRuleRequest = (V3PolicyRuleRequest) o;
        return Objects.equals(this.name, v3PolicyRuleRequest.name) &&
                Objects.equals(this.description, v3PolicyRuleRequest.description) &&
                Objects.equals(this.governanceTypeId, v3PolicyRuleRequest.governanceTypeId) &&
                Objects.equals(this.trigger, v3PolicyRuleRequest.trigger) &&
                Objects.equals(this.action, v3PolicyRuleRequest.action) &&
                Objects.equals(this.state, v3PolicyRuleRequest.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, governanceTypeId, trigger, action, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyRuleRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    governanceTypeId: ").append(toIndentedString(governanceTypeId)).append("\n");
        sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
