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
import java.util.Objects;

/**
 * entity object within the resource object within the response for the /v3/policy_rules/{ruleId}/terms API
 */
public class PolicyRuleTermListResponseEntity {

    private String displayName;
    private String name;

    public PolicyRuleTermListResponseEntity displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     * @return displayName
     **/
    @javax.annotation.Nullable
    @JsonProperty("display_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public PolicyRuleTermListResponseEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the name of a term specified in the rule
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRuleTermListResponseEntity policyRuleTermListResponseEntity = (PolicyRuleTermListResponseEntity) o;
        return Objects.equals(this.displayName, policyRuleTermListResponseEntity.displayName) &&
                Objects.equals(this.name, policyRuleTermListResponseEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRuleTermListResponseEntity {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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