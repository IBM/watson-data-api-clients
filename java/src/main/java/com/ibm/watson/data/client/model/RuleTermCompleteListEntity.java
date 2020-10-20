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
 * RuleTermCompleteListEntity
 */
public class RuleTermCompleteListEntity {

    private List<PolicyRuleTermListResponseResource> triggerTerms = new ArrayList<>();
    private List<PolicyRuleTermListResponseResource> actionTerms = null;

    public RuleTermCompleteListEntity triggerTerms(List<PolicyRuleTermListResponseResource> triggerTerms) {
        this.triggerTerms = triggerTerms;
        return this;
    }

    public RuleTermCompleteListEntity addTriggerTermsItem(PolicyRuleTermListResponseResource triggerTermsItem) {
        this.triggerTerms.add(triggerTermsItem);
        return this;
    }

    /**
     * the name of a term specified in the rule
     * @return triggerTerms
     **/
    @JsonProperty("trigger_terms")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<PolicyRuleTermListResponseResource> getTriggerTerms() { return triggerTerms; }
    public void setTriggerTerms(List<PolicyRuleTermListResponseResource> triggerTerms) { this.triggerTerms = triggerTerms; }

    public RuleTermCompleteListEntity actionTerms(List<PolicyRuleTermListResponseResource> actionTerms) {
        this.actionTerms = actionTerms;
        return this;
    }

    public RuleTermCompleteListEntity addActionTermsItem(PolicyRuleTermListResponseResource actionTermsItem) {
        if (this.actionTerms == null) {
            this.actionTerms = new ArrayList<>();
        }
        this.actionTerms.add(actionTermsItem);
        return this;
    }

    /**
     * Get actionTerms
     * @return actionTerms
     **/
    @javax.annotation.Nullable
    @JsonProperty("action_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<PolicyRuleTermListResponseResource> getActionTerms() { return actionTerms; }
    public void setActionTerms(List<PolicyRuleTermListResponseResource> actionTerms) { this.actionTerms = actionTerms; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RuleTermCompleteListEntity ruleTermCompleteListEntity =
                (RuleTermCompleteListEntity)o;
        return Objects.equals(this.triggerTerms, ruleTermCompleteListEntity.triggerTerms) &&
                Objects.equals(this.actionTerms, ruleTermCompleteListEntity.actionTerms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(triggerTerms, actionTerms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RuleTermCompleteListEntity {\n");
        sb.append("    triggerTerms: ").append(toIndentedString(triggerTerms)).append("\n");
        sb.append("    actionTerms: ").append(toIndentedString(actionTerms)).append("\n");
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
