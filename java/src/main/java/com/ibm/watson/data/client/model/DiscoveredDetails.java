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
 * DiscoveredDetails
 */
public class DiscoveredDetails {

    private Long count;
    private Long distinctCount;
    private Double confidence;
    private Integer priority;

    @javax.annotation.Nullable
    @JsonProperty("count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }

    @javax.annotation.Nullable
    @JsonProperty("distinct_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getDistinctCount() { return distinctCount; }
    public void setDistinctCount(Long distinctCount) { this.distinctCount = distinctCount; }

    @javax.annotation.Nullable
    @JsonProperty("confidence")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    @javax.annotation.Nullable
    @JsonProperty("priority")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscoveredDetails that = (DiscoveredDetails) o;
        return Objects.equals(count, that.count) &&
                Objects.equals(distinctCount, that.distinctCount) &&
                Objects.equals(confidence, that.confidence) &&
                Objects.equals(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, distinctCount, confidence, priority);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveredDetails {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    distinctCount: ").append(toIndentedString(distinctCount)).append("\n");
        sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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
