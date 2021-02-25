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
 * NumericStats
 */
public class NumericStats {

    private Long count;
    private Double mean;
    private Double variance;
    private List<Object> bins;

    @javax.annotation.Nullable
    @JsonProperty("count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }

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
    @JsonProperty("bins")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getBins() { return bins; }
    public void setBins(List<Object> bins) { this.bins = bins; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumericStats that = (NumericStats) o;
        return Objects.equals(count, that.count) &&
                Objects.equals(mean, that.mean) &&
                Objects.equals(variance, that.variance) &&
                Objects.equals(bins, that.bins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, mean, variance, bins);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NumericStats {\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    mean: ").append(toIndentedString(mean)).append("\n");
        sb.append("    variance: ").append(toIndentedString(variance)).append("\n");
        sb.append("    bins: ").append(toIndentedString(bins)).append("\n");
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
