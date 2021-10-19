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

/**
 * TransformedColumn
 */
public class TransformedColumn {

    private String name;
    private String operation;
    private String policyId;
    private String ruleId;

    public TransformedColumn name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public TransformedColumn operation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     * @return operation
     **/
    @javax.annotation.Nullable
    @JsonProperty("operation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public TransformedColumn policyId(String policyId) {
        this.policyId = policyId;
        return this;
    }

    /**
     * Get policyId
     * @return policyId
     **/
    @javax.annotation.Nullable
    @JsonProperty("policy_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPolicyId() {
        return policyId;
    }
    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public TransformedColumn ruleId(String ruleId) {
        this.ruleId = ruleId;
        return this;
    }

    /**
     * Get ruleId
     * @return ruleId
     **/
    @javax.annotation.Nullable
    @JsonProperty("rule_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransformedColumn transformedColumn = (TransformedColumn) o;
        return Objects.equals(this.name, transformedColumn.name) &&
                Objects.equals(this.operation, transformedColumn.operation) &&
                Objects.equals(this.policyId, transformedColumn.policyId) &&
                Objects.equals(this.ruleId, transformedColumn.ruleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operation, policyId, ruleId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransformedColumn {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
        sb.append("    policyId: ").append(toIndentedString(policyId)).append("\n");
        sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
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
