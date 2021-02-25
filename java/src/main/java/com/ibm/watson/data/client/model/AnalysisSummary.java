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
 * AnalysisSummary
 */
public class AnalysisSummary {

    private Integer score;
    private ScoreStats scoreStats;
    private List<Object> problemDistribution;

    @javax.annotation.Nullable
    @JsonProperty("score")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    @javax.annotation.Nullable
    @JsonProperty("score_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ScoreStats getScoreStats() { return scoreStats; }
    public void setScoreStats(ScoreStats scoreStats) { this.scoreStats = scoreStats; }

    @javax.annotation.Nullable
    @JsonProperty("problem_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getProblemDistribution() { return problemDistribution; }
    public void setProblemDistribution(List<Object> problemDistribution) { this.problemDistribution = problemDistribution; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisSummary that = (AnalysisSummary) o;
        return Objects.equals(score, that.score) &&
                Objects.equals(scoreStats, that.scoreStats) &&
                Objects.equals(problemDistribution, that.problemDistribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, scoreStats, problemDistribution);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnalysisSummary {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    score: ").append(toIndentedString(score)).append("\n");
        sb.append("    scoreStats: ").append(toIndentedString(scoreStats)).append("\n");
        sb.append("    problemDistribution: ").append(toIndentedString(problemDistribution)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
