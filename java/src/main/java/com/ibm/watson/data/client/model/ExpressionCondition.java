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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.Conjunction;
import com.ibm.watson.data.client.model.enums.Not;

import java.util.Objects;

/**
 * Condition
 */
public class ExpressionCondition {

    private Not not;
    private Conjunction conjunction;
    private Predicate predicate;

    public ExpressionCondition not(Not not) {
        this.not = not;
        return this;
    }

    /**
     * Get not
     * @return not
     **/
    @javax.annotation.Nullable
    @JsonProperty("not")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Not getNot() {
        return not;
    }
    public void setNot(Not not) {
        this.not = not;
    }

    public ExpressionCondition conjunction(Conjunction conjunction) {
        this.conjunction = conjunction;
        return this;
    }

    /**
     * Get conjunction
     * @return conjunction
     **/
    @javax.annotation.Nullable
    @JsonProperty("conjunction")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Conjunction getConjunction() {
        return conjunction;
    }
    public void setConjunction(Conjunction conjunction) {
        this.conjunction = conjunction;
    }

    public ExpressionCondition predicate(Predicate predicate) {
        this.predicate = predicate;
        return this;
    }

    /**
     * Get predicate
     * @return predicate
     **/
    @javax.annotation.Nullable
    @JsonProperty("predicate")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Predicate getPredicate() {
        return predicate;
    }
    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExpressionCondition condition = (ExpressionCondition) o;
        return Objects.equals(this.not, condition.not) &&
                Objects.equals(this.conjunction, condition.conjunction) &&
                Objects.equals(this.predicate, condition.predicate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(not, conjunction, predicate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExpressionCondition {\n");
        sb.append("    not: ").append(toIndentedString(not)).append("\n");
        sb.append("    conjunction: ").append(toIndentedString(conjunction)).append("\n");
        sb.append("    predicate: ").append(toIndentedString(predicate)).append("\n");
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