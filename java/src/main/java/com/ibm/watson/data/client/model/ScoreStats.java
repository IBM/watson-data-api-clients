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
 * ScoreStats
 */
public class ScoreStats {

    private Long n;
    private Double mean;
    private Double variance;
    private Double stddev;
    private Double min;
    private Double max;
    private Double sum;

    @javax.annotation.Nullable
    @JsonProperty("n")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getN() { return n; }
    public void setN(Long n) { this.n = n; }

    @javax.annotation.Nullable
    @JsonProperty("mean")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMean() { return mean; }
    public void setMean(Double mean) { this.mean = mean; }

    @javax.annotation.Nullable
    @JsonProperty("variance")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getVariance() { return variance; }
    public void setVariance(Double variance) { this.variance = variance; }

    @javax.annotation.Nullable
    @JsonProperty("stddev")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getStddev() { return stddev; }
    public void setStddev(Double stddev) { this.stddev = stddev; }

    @javax.annotation.Nullable
    @JsonProperty("min")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMin() { return min; }
    public void setMin(Double min) { this.min = min; }

    @javax.annotation.Nullable
    @JsonProperty("max")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMax() { return max; }
    public void setMax(Double max) { this.max = max; }

    @javax.annotation.Nullable
    @JsonProperty("sum")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getSum() { return sum; }
    public void setSum(Double sum) { this.sum = sum; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreStats that = (ScoreStats) o;
        return Objects.equals(n, that.n) &&
                Objects.equals(mean, that.mean) &&
                Objects.equals(variance, that.variance) &&
                Objects.equals(stddev, that.stddev) &&
                Objects.equals(min, that.min) &&
                Objects.equals(max, that.max) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, mean, variance, stddev, min, max, sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScoreStats {\n");
        sb.append("    n: ").append(toIndentedString(n)).append("\n");
        sb.append("    mean: ").append(toIndentedString(mean)).append("\n");
        sb.append("    variance: ").append(toIndentedString(variance)).append("\n");
        sb.append("    stddev: ").append(toIndentedString(stddev)).append("\n");
        sb.append("    min: ").append(toIndentedString(min)).append("\n");
        sb.append("    max: ").append(toIndentedString(max)).append("\n");
        sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
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
