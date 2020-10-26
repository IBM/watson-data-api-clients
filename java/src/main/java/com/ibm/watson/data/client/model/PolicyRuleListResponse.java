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
 * Response for the /v2/policy_rules API
 */
public class PolicyRuleListResponse extends PaginatedList {

    private HrefModel previous;
    private List<PolicyRuleResponse> resources = new ArrayList<>();

    // TODO: docs say this is "previous" but all other paginated lists use "prev"?

    /**
     * Get previous
     * @return previous
     **/
    @JsonProperty("previous")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getPrevious() { return previous; }
    public void setPrevious(HrefModel previous) { this.previous = previous; }

    public PolicyRuleListResponse resources(List<PolicyRuleResponse> resources) {
        this.resources = resources;
        return this;
    }

    public PolicyRuleListResponse addResourcesItem(PolicyRuleResponse resourcesItem) {
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * list of rules
     * @return resources
     **/
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<PolicyRuleResponse> getResources() { return resources; }
    public void setResources(List<PolicyRuleResponse> resources) { this.resources = resources; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRuleListResponse policyRuleListResponse = (PolicyRuleListResponse)o;
        return super.equals(o) &&
                Objects.equals(this.previous, policyRuleListResponse.previous) &&
                Objects.equals(this.resources, policyRuleListResponse.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), previous, resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRuleListResponse {\n");
        super.toString(sb);
        sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
