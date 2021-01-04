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
import java.util.HashMap;
import java.util.Map;

/**
 * A metric. 
 */
public class Metric {

    private Date timestamp;
    private Integer iteration;
    private Map<String, BigDecimal> mlMetrics = null;
    private Map<String, MlFederatedMetric> mlFederatedMetrics = null;
    private MetricsContext context;

    public Metric timestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * A timestamp for the metrics.
     * @return timestamp
     **/
    @JsonProperty("timestamp")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public Metric iteration(Integer iteration) {
        this.iteration = iteration;
        return this;
    }

    /**
     * The iteration number.
     * @return iteration
     **/
    @javax.annotation.Nullable
    @JsonProperty("iteration")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getIteration() { return iteration; }
    public void setIteration(Integer iteration) { this.iteration = iteration; }

    public Metric mlMetrics(Map<String, BigDecimal> mlMetrics) {
        this.mlMetrics = mlMetrics;
        return this;
    }

    public Metric putMlMetricsItem(String key, BigDecimal mlMetricsItem) {
        if (this.mlMetrics == null) {
            this.mlMetrics = new HashMap<>();
        }
        this.mlMetrics.put(key, mlMetricsItem);
        return this;
    }

    /**
     * The metrics.
     * @return mlMetrics
     **/
    @javax.annotation.Nullable
    @JsonProperty("ml_metrics")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, BigDecimal> getMlMetrics() { return mlMetrics; }
    public void setMlMetrics(Map<String, BigDecimal> mlMetrics) { this.mlMetrics = mlMetrics; }

    public Metric mlFederatedMetrics(Map<String, MlFederatedMetric> mlFederatedMetrics) {
        this.mlFederatedMetrics = mlFederatedMetrics;
        return this;
    }

    public Metric putMlFederatedMetricsItem(String key, MlFederatedMetric mlFederatedMetricsItem) {
        if (this.mlFederatedMetrics == null) {
            this.mlFederatedMetrics = new HashMap<>();
        }
        this.mlFederatedMetrics.put(key, mlFederatedMetricsItem);
        return this;
    }

    /**
     * The metrics from federated training.
     * @return mlFederatedMetrics
     **/
    @javax.annotation.Nullable
    @JsonProperty("ml_federated_metrics")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, MlFederatedMetric> getMlFederatedMetrics() { return mlFederatedMetrics; }
    public void setMlFederatedMetrics(Map<String, MlFederatedMetric> mlFederatedMetrics) { this.mlFederatedMetrics = mlFederatedMetrics; }

    public Metric context(MetricsContext context) {
        this.context = context;
        return this;
    }

    /**
     * Get context
     * @return context
     **/
    @javax.annotation.Nullable
    @JsonProperty("context")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MetricsContext getContext() { return context; }
    public void setContext(MetricsContext context) { this.context = context; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Metric metric = (Metric) o;
        return Objects.equals(this.timestamp, metric.timestamp) &&
                Objects.equals(this.iteration, metric.iteration) &&
                Objects.equals(this.mlMetrics, metric.mlMetrics) &&
                Objects.equals(this.mlFederatedMetrics, metric.mlFederatedMetrics) &&
                Objects.equals(this.context, metric.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, iteration, mlMetrics, mlFederatedMetrics, context);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Metric {\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    iteration: ").append(toIndentedString(iteration)).append("\n");
        sb.append("    mlMetrics: ").append(toIndentedString(mlMetrics)).append("\n");
        sb.append("    mlFederatedMetrics: ").append(toIndentedString(mlFederatedMetrics)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
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
