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
import com.ibm.watson.data.client.model.enums.RuleType;
import java.util.Objects;

/**
 * NewRuleEntity
 */
public class NewRuleEntity extends WriteableRuleEntity {

    private RuleType ruleType;

    public NewRuleEntity ruleType(RuleType ruleType) {
        this.ruleType = ruleType;
        return this;
    }

    /**
     * Currently supported: Governance.
     * @return ruleType
     **/
    @JsonProperty("rule_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public RuleType getRuleType() { return ruleType; }
    public void setRuleType(RuleType ruleType) { this.ruleType = ruleType; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NewRuleEntity newRuleEntity = (NewRuleEntity)o;
        return super.equals(o) &&
                Objects.equals(this.ruleType, newRuleEntity.ruleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ruleType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewRuleEntity {\n");
        super.toString(sb);
        sb.append("    ruleType: ").append(toIndentedString(ruleType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
