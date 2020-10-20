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
 * Details of rule failed to rule with reason.
 */
public class FailedRule {

    private String name;
    private Integer index;
    private String ruleGuidInRequest;
    private String reason;

    public FailedRule name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Rule name, matches with a corresponding one request data
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public FailedRule index(Integer index) {
        this.index = index;
        return this;
    }

    /**
     * Index to the rule specified in request data; 1-based.
     * @return index
     **/
    @JsonProperty("index")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getIndex() { return index; }
    public void setIndex(Integer index) { this.index = index; }

    public FailedRule ruleGuidInRequest(String ruleGuidInRequest) {
        this.ruleGuidInRequest = ruleGuidInRequest;
        return this;
    }

    /**
     * Corresponding rule GUID in request data
     * @return ruleGuidInRequest
     **/
    @javax.annotation.Nullable
    @JsonProperty("ruleGuidInRequest")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRuleGuidInRequest() { return ruleGuidInRequest; }
    public void setRuleGuidInRequest(String ruleGuidInRequest) { this.ruleGuidInRequest = ruleGuidInRequest; }

    public FailedRule reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Reason for failure
     * @return reason
     **/
    @JsonProperty("reason")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FailedRule failed = (FailedRule)o;
        return Objects.equals(this.name, failed.name) &&
                Objects.equals(this.index, failed.index) &&
                Objects.equals(this.ruleGuidInRequest, failed.ruleGuidInRequest) &&
                Objects.equals(this.reason, failed.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index, ruleGuidInRequest, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FailedRule {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    ruleGuidInRequest: ").append(toIndentedString(ruleGuidInRequest)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
