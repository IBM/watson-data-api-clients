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

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * Details about the step. 
 */
public class StepInfo {

    private String id;
    private String name;
    private Date startedAt;
    private Date completedAt;
    private Object hyperParameters;
    private Integer dataAllocation;
    private String estimator;
    private String transformer;
    private BigDecimal score;

    public StepInfo id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public StepInfo name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public StepInfo startedAt(Date startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    /**
     * Get startedAt
     * @return startedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("started_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getStartedAt() { return startedAt; }
    public void setStartedAt(Date startedAt) { this.startedAt = startedAt; }

    public StepInfo completedAt(Date completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * Get completedAt
     * @return completedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("completed_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCompletedAt() { return completedAt; }
    public void setCompletedAt(Date completedAt) { this.completedAt = completedAt; }

    public StepInfo hyperParameters(Object hyperParameters) {
        this.hyperParameters = hyperParameters;
        return this;
    }

    /**
     * Get hyperParameters
     * @return hyperParameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("hyper_parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getHyperParameters() { return hyperParameters; }
    public void setHyperParameters(Object hyperParameters) { this.hyperParameters = hyperParameters; }

    public StepInfo dataAllocation(Integer dataAllocation) {
        this.dataAllocation = dataAllocation;
        return this;
    }

    /**
     * Get dataAllocation
     * @return dataAllocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_allocation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getDataAllocation() { return dataAllocation; }
    public void setDataAllocation(Integer dataAllocation) { this.dataAllocation = dataAllocation; }

    public StepInfo estimator(String estimator) {
        this.estimator = estimator;
        return this;
    }

    /**
     * Get estimator
     * @return estimator
     **/
    @javax.annotation.Nullable
    @JsonProperty("estimator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEstimator() { return estimator; }
    public void setEstimator(String estimator) { this.estimator = estimator; }

    public StepInfo transformer(String transformer) {
        this.transformer = transformer;
        return this;
    }

    /**
     * Get transformer
     * @return transformer
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformer")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTransformer() { return transformer; }
    public void setTransformer(String transformer) { this.transformer = transformer; }

    public StepInfo score(BigDecimal score) {
        this.score = score;
        return this;
    }

    /**
     * Get score
     * @return score
     **/
    @javax.annotation.Nullable
    @JsonProperty("score")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getScore() { return score; }
    public void setScore(BigDecimal score) { this.score = score; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        StepInfo stepInfo = (StepInfo) o;
        return Objects.equals(this.id, stepInfo.id) &&
                Objects.equals(this.name, stepInfo.name) &&
                Objects.equals(this.startedAt, stepInfo.startedAt) &&
                Objects.equals(this.completedAt, stepInfo.completedAt) &&
                Objects.equals(this.hyperParameters, stepInfo.hyperParameters) &&
                Objects.equals(this.dataAllocation, stepInfo.dataAllocation) &&
                Objects.equals(this.estimator, stepInfo.estimator) &&
                Objects.equals(this.transformer, stepInfo.transformer) &&
                Objects.equals(this.score, stepInfo.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startedAt, completedAt, hyperParameters, dataAllocation, estimator, transformer, score);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StepInfo {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
        sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
        sb.append("    hyperParameters: ").append(toIndentedString(hyperParameters)).append("\n");
        sb.append("    dataAllocation: ").append(toIndentedString(dataAllocation)).append("\n");
        sb.append("    estimator: ").append(toIndentedString(estimator)).append("\n");
        sb.append("    transformer: ").append(toIndentedString(transformer)).append("\n");
        sb.append("    score: ").append(toIndentedString(score)).append("\n");
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
