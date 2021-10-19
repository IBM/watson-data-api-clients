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
import com.ibm.watson.data.client.model.enums.PredicateOperator;

/**
 * Predicate
 */
public class Predicate {

    private Object lhs;
    private PredicateOperator operator;
    private Object rhs;
    private Expression expression;

    public Predicate lhs(Object lhs) {
        this.lhs = lhs;
        return this;
    }

    /**
     * Get lhs
     * @return lhs
     **/
    @javax.annotation.Nullable
    @JsonProperty("lhs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getLhs() {
        return lhs;
    }
    public void setLhs(Object lhs) {
        this.lhs = lhs;
    }

    public Predicate operator(PredicateOperator operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Get operator
     * @return operator
     **/
    @javax.annotation.Nullable
    @JsonProperty("operator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PredicateOperator getOperator() {
        return operator;
    }
    public void setOperator(PredicateOperator operator) {
        this.operator = operator;
    }

    public Predicate rhs(Object rhs) {
        this.rhs = rhs;
        return this;
    }

    /**
     * Get rhs
     * @return rhs
     **/
    @javax.annotation.Nullable
    @JsonProperty("rhs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getRhs() {
        return rhs;
    }
    public void setRhs(Object rhs) {
        this.rhs = rhs;
    }

    public Predicate expression(Expression expression) {
        this.expression = expression;
        return this;
    }

    /**
     * Get expression
     * @return expression
     **/
    @javax.annotation.Nullable
    @JsonProperty("expression")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Expression getExpression() {
        return expression;
    }
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Predicate predicate = (Predicate) o;
        return Objects.equals(this.lhs, predicate.lhs) &&
                Objects.equals(this.operator, predicate.operator) &&
                Objects.equals(this.rhs, predicate.rhs) &&
                Objects.equals(this.expression, predicate.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lhs, operator, rhs, expression);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Predicate {\n");
        sb.append("    lhs: ").append(toIndentedString(lhs)).append("\n");
        sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
        sb.append("    rhs: ").append(toIndentedString(rhs)).append("\n");
        sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
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
