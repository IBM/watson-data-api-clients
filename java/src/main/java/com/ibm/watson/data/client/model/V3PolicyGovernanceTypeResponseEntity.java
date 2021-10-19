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
 * entity object within the response for the /v3/enforcement/governance_types/{governanceTypeId} API
 */
public class V3PolicyGovernanceTypeResponseEntity {

    private String name;
    private String description;
    private List<PolicyGovernanceTypeActionDef> actions = new ArrayList<>();
    private PolicyRuleAction defaultAction;

    public V3PolicyGovernanceTypeResponseEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the displayed name of the governance type
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

    public V3PolicyGovernanceTypeResponseEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * a more detailed description of the governance type
     * @return description
     **/
    @javax.annotation.Nonnull
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public V3PolicyGovernanceTypeResponseEntity actions(List<PolicyGovernanceTypeActionDef> actions) {
        this.actions = actions;
        return this;
    }

    public V3PolicyGovernanceTypeResponseEntity addActionsItem(PolicyGovernanceTypeActionDef actionsItem) {
        this.actions.add(actionsItem);
        return this;
    }

    /**
     * the possible actions defined for the governance type
     * @return actions
     **/
    @javax.annotation.Nonnull
    @JsonProperty("actions")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<PolicyGovernanceTypeActionDef> getActions() {
        return actions;
    }
    public void setActions(List<PolicyGovernanceTypeActionDef> actions) {
        this.actions = actions;
    }

    public V3PolicyGovernanceTypeResponseEntity defaultAction(PolicyRuleAction defaultAction) {
        this.defaultAction = defaultAction;
        return this;
    }

    /**
     * Get defaultAction
     * @return defaultAction
     **/
    @javax.annotation.Nullable
    @JsonProperty("default_action")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PolicyRuleAction getDefaultAction() {
        return defaultAction;
    }
    public void setDefaultAction(PolicyRuleAction defaultAction) {
        this.defaultAction = defaultAction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3PolicyGovernanceTypeResponseEntity v3PolicyGovernanceTypeResponseEntity = (V3PolicyGovernanceTypeResponseEntity) o;
        return Objects.equals(this.name, v3PolicyGovernanceTypeResponseEntity.name) &&
                Objects.equals(this.description, v3PolicyGovernanceTypeResponseEntity.description) &&
                Objects.equals(this.actions, v3PolicyGovernanceTypeResponseEntity.actions) &&
                Objects.equals(this.defaultAction, v3PolicyGovernanceTypeResponseEntity.defaultAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, actions, defaultAction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyGovernanceTypeResponseEntity {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
        sb.append("    defaultAction: ").append(toIndentedString(defaultAction)).append("\n");
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
