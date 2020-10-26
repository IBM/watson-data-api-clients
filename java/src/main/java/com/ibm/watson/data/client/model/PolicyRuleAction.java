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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * action object within the /v2/policy_rules API
 */
public class PolicyRuleAction {

    private String name;
    private List<PolicyRuleParameter> parameters = null;
    private PolicyRuleAction subaction;

    public PolicyRuleAction name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the name of the action.  This should be the name of one of the action
     * definitions on the governance type for the rule.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public PolicyRuleAction parameters(List<PolicyRuleParameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    public PolicyRuleAction addParametersItem(PolicyRuleParameter parametersItem) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * an array of parameters if required by the action
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<PolicyRuleParameter> getParameters() { return parameters; }
    public void setParameters(List<PolicyRuleParameter> parameters) { this.parameters = parameters; }

    public PolicyRuleAction subaction(PolicyRuleAction subaction) {
        this.subaction = subaction;
        return this;
    }

    /**
     * Get subaction
     * @return subaction
     **/
    @javax.annotation.Nullable
    @JsonProperty("subaction")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PolicyRuleAction getSubaction() { return subaction; }
    public void setSubaction(PolicyRuleAction subaction) { this.subaction = subaction; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRuleAction policyRuleAction = (PolicyRuleAction)o;
        return Objects.equals(this.name, policyRuleAction.name) &&
                Objects.equals(this.parameters, policyRuleAction.parameters) &&
                Objects.equals(this.subaction, policyRuleAction.subaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parameters, subaction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRuleAction {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    subaction: ").append(toIndentedString(subaction)).append("\n");
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
