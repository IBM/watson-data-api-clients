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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * FeatureImportance
 */
public class FeatureImportance {

    private String stage;
    private String computationType;
    private Object features;

    public FeatureImportance stage(String stage) {
        this.stage = stage;
        return this;
    }

    /**
     * Get stage
     * @return stage
     **/
    @JsonProperty("stage")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }

    public FeatureImportance computationType(String computationType) {
        this.computationType = computationType;
        return this;
    }

    /**
     * Get computationType
     * @return computationType
     **/
    @JsonProperty("computation_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getComputationType() { return computationType; }
    public void setComputationType(String computationType) { this.computationType = computationType; }

    public FeatureImportance features(Object features) {
        this.features = features;
        return this;
    }

    /**
     * The feature names and importance values as numbers.
     * @return features
     **/
    @JsonProperty("features")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Object getFeatures() { return features; }
    public void setFeatures(Object features) { this.features = features; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FeatureImportance featureImportance = (FeatureImportance) o;
        return Objects.equals(this.stage, featureImportance.stage) &&
                Objects.equals(this.computationType, featureImportance.computationType) &&
                Objects.equals(this.features, featureImportance.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stage, computationType, features);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FeatureImportance {\n");
        sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
        sb.append("    computationType: ").append(toIndentedString(computationType)).append("\n");
        sb.append("    features: ").append(toIndentedString(features)).append("\n");
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
