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
import java.util.ArrayList;
import java.util.List;

/**
 * Provides extra information for this training stage in the context of auto-ml. 
 */
public class MetricsContext {

    private String deploymentId;
    private IntermediateModel intermediateModel;
    private String phase;
    private StepInfo step;
    private List<String> classes = null;
    private BinaryClassification binaryClassfication;
    private List<MultiClassClassification> multiClassClassification = null;
    private List<FeatureImportance> featuresImportance = null;
    private String schema;
    private List<String> estimators = null;

    public MetricsContext deploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
        return this;
    }

    /**
     * The deployment that created the metrics.
     * @return deploymentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("deployment_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDeploymentId() { return deploymentId; }
    public void setDeploymentId(String deploymentId) { this.deploymentId = deploymentId; }

    public MetricsContext intermediateModel(IntermediateModel intermediateModel) {
        this.intermediateModel = intermediateModel;
        return this;
    }

    /**
     * Get intermediateModel
     * @return intermediateModel
     **/
    @javax.annotation.Nullable
    @JsonProperty("intermediate_model")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public IntermediateModel getIntermediateModel() { return intermediateModel; }
    public void setIntermediateModel(IntermediateModel intermediateModel) { this.intermediateModel = intermediateModel; }

    public MetricsContext phase(String phase) {
        this.phase = phase;
        return this;
    }

    /**
     * Get phase
     * @return phase
     **/
    @javax.annotation.Nullable
    @JsonProperty("phase")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPhase() { return phase; }
    public void setPhase(String phase) { this.phase = phase; }

    public MetricsContext step(StepInfo step) {
        this.step = step;
        return this;
    }

    /**
     * Get step
     * @return step
     **/
    @javax.annotation.Nullable
    @JsonProperty("step")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public StepInfo getStep() { return step; }
    public void setStep(StepInfo step) { this.step = step; }

    public MetricsContext classes(List<String> classes) {
        this.classes = classes;
        return this;
    }

    public MetricsContext addClassesItem(String classesItem) {
        if (this.classes == null) {
            this.classes = new ArrayList<>();
        }
        this.classes.add(classesItem);
        return this;
    }

    /**
     * Get classes
     * @return classes
     **/
    @javax.annotation.Nullable
    @JsonProperty("classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getClasses() { return classes; }
    public void setClasses(List<String> classes) { this.classes = classes; }

    public MetricsContext binaryClassfication(BinaryClassification binaryClassfication) {
        this.binaryClassfication = binaryClassfication;
        return this;
    }

    /**
     * Get binaryClassfication
     * @return binaryClassfication
     **/
    @javax.annotation.Nullable
    @JsonProperty("binary_classfication")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BinaryClassification getBinaryClassfication() { return binaryClassfication; }
    public void setBinaryClassfication(BinaryClassification binaryClassfication) { this.binaryClassfication = binaryClassfication; }

    public MetricsContext multiClassClassification(List<MultiClassClassification> multiClassClassification) {
        this.multiClassClassification = multiClassClassification;
        return this;
    }

    public MetricsContext addMultiClassClassificationItem(MultiClassClassification multiClassClassificationItem) {
        if (this.multiClassClassification == null) {
            this.multiClassClassification = new ArrayList<>();
        }
        this.multiClassClassification.add(multiClassClassificationItem);
        return this;
    }

    /**
     * Get multiClassClassification
     * @return multiClassClassification
     **/
    @javax.annotation.Nullable
    @JsonProperty("multi_class_classification")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MultiClassClassification> getMultiClassClassification() { return multiClassClassification; }
    public void setMultiClassClassification(List<MultiClassClassification> multiClassClassification) { this.multiClassClassification = multiClassClassification; }

    public MetricsContext featuresImportance(List<FeatureImportance> featuresImportance) {
        this.featuresImportance = featuresImportance;
        return this;
    }

    public MetricsContext addFeaturesImportanceItem(FeatureImportance featuresImportanceItem) {
        if (this.featuresImportance == null) {
            this.featuresImportance = new ArrayList<>();
        }
        this.featuresImportance.add(featuresImportanceItem);
        return this;
    }

    /**
     * Get featuresImportance
     * @return featuresImportance
     **/
    @javax.annotation.Nullable
    @JsonProperty("features_importance")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<FeatureImportance> getFeaturesImportance() { return featuresImportance; }
    public void setFeaturesImportance(List<FeatureImportance> featuresImportance) { this.featuresImportance = featuresImportance; }

    public MetricsContext schema(String schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Get schema
     * @return schema
     **/
    @javax.annotation.Nullable
    @JsonProperty("schema")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSchema() { return schema; }
    public void setSchema(String schema) { this.schema = schema; }

    public MetricsContext estimators(List<String> estimators) {
        this.estimators = estimators;
        return this;
    }

    public MetricsContext addEstimatorsItem(String estimatorsItem) {
        if (this.estimators == null) {
            this.estimators = new ArrayList<>();
        }
        this.estimators.add(estimatorsItem);
        return this;
    }

    /**
     * Get estimators
     * @return estimators
     **/
    @javax.annotation.Nullable
    @JsonProperty("estimators")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getEstimators() { return estimators; }
    public void setEstimators(List<String> estimators) { this.estimators = estimators; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetricsContext metricsContext = (MetricsContext) o;
        return Objects.equals(this.deploymentId, metricsContext.deploymentId) &&
                Objects.equals(this.intermediateModel, metricsContext.intermediateModel) &&
                Objects.equals(this.phase, metricsContext.phase) &&
                Objects.equals(this.step, metricsContext.step) &&
                Objects.equals(this.classes, metricsContext.classes) &&
                Objects.equals(this.binaryClassfication, metricsContext.binaryClassfication) &&
                Objects.equals(this.multiClassClassification, metricsContext.multiClassClassification) &&
                Objects.equals(this.featuresImportance, metricsContext.featuresImportance) &&
                Objects.equals(this.schema, metricsContext.schema) &&
                Objects.equals(this.estimators, metricsContext.estimators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deploymentId, intermediateModel, phase, step, classes, binaryClassfication, multiClassClassification, featuresImportance, schema, estimators);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetricsContext {\n");
        sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
        sb.append("    intermediateModel: ").append(toIndentedString(intermediateModel)).append("\n");
        sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
        sb.append("    step: ").append(toIndentedString(step)).append("\n");
        sb.append("    classes: ").append(toIndentedString(classes)).append("\n");
        sb.append("    binaryClassfication: ").append(toIndentedString(binaryClassfication)).append("\n");
        sb.append("    multiClassClassification: ").append(toIndentedString(multiClassClassification)).append("\n");
        sb.append("    featuresImportance: ").append(toIndentedString(featuresImportance)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    estimators: ").append(toIndentedString(estimators)).append("\n");
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
