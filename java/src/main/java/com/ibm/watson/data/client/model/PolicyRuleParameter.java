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

import java.util.List;
import java.util.Objects;

/**
 * parameter object within action object within the /v2/policy_rules API
 */
public class PolicyRuleParameter {

    private String name;
    private List<String> value;

    public PolicyRuleParameter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the name of a parameter as defined for the action on the governance type
     * for the rule
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public PolicyRuleParameter value(List<String> value) {
        this.value = value;
        return this;
    }

    /**
     * a value of the parameter.  This should of the datatype specified for the
     * parameter on the governance type for the rule.  If multivalue, this should
     * be a list (array).
     * @return value
     **/
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getValue() { return value; }
    public void setValue(List<String> value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRuleParameter policyRuleParameter = (PolicyRuleParameter)o;
        return Objects.equals(this.name, policyRuleParameter.name) &&
                Objects.equals(this.value, policyRuleParameter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRuleParameter {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
