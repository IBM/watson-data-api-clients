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
 * action definition within the /v3/enforcement/governance_types API
 */
public class PolicyGovernanceTypeActionDef {

    private String name;
    private String displayName;
    private String description;
    private List<PolicyGovernanceTypeActionParameterDef> parameters = null;
    private List<PolicyGovernanceTypeActionDef> subactions = null;

    public PolicyGovernanceTypeActionDef name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the name of the allowed action, as specified in  rule actions
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

    public PolicyGovernanceTypeActionDef displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * a displayable name for the action.
     * @return displayName
     **/
    @javax.annotation.Nonnull
    @JsonProperty("display_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PolicyGovernanceTypeActionDef description(String description) {
        this.description = description;
        return this;
    }

    /**
     * a description of the action
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

    public PolicyGovernanceTypeActionDef parameters(List<PolicyGovernanceTypeActionParameterDef> parameters) {
        this.parameters = parameters;
        return this;
    }

    public PolicyGovernanceTypeActionDef addParametersItem(PolicyGovernanceTypeActionParameterDef parametersItem) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * an array of parameter definitions for the action if the action has parameters
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<PolicyGovernanceTypeActionParameterDef> getParameters() {
        return parameters;
    }
    public void setParameters(List<PolicyGovernanceTypeActionParameterDef> parameters) {
        this.parameters = parameters;
    }

    public PolicyGovernanceTypeActionDef subactions(List<PolicyGovernanceTypeActionDef> subactions) {
        this.subactions = subactions;
        return this;
    }

    public PolicyGovernanceTypeActionDef addSubactionsItem(PolicyGovernanceTypeActionDef subactionsItem) {
        if (this.subactions == null) {
            this.subactions = new ArrayList<>();
        }
        this.subactions.add(subactionsItem);
        return this;
    }

    /**
     * an array of subactions for the action if the action has subactions.  (When an action has subactions the action will not have parameters.)
     * @return subactions
     **/
    @javax.annotation.Nullable
    @JsonProperty("subactions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<PolicyGovernanceTypeActionDef> getSubactions() {
        return subactions;
    }
    public void setSubactions(List<PolicyGovernanceTypeActionDef> subactions) {
        this.subactions = subactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyGovernanceTypeActionDef policyGovernanceTypeActionDef = (PolicyGovernanceTypeActionDef) o;
        return Objects.equals(this.name, policyGovernanceTypeActionDef.name) &&
                Objects.equals(this.displayName, policyGovernanceTypeActionDef.displayName) &&
                Objects.equals(this.description, policyGovernanceTypeActionDef.description) &&
                Objects.equals(this.parameters, policyGovernanceTypeActionDef.parameters) &&
                Objects.equals(this.subactions, policyGovernanceTypeActionDef.subactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, description, parameters, subactions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyGovernanceTypeActionDef {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    subactions: ").append(toIndentedString(subactions)).append("\n");
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
