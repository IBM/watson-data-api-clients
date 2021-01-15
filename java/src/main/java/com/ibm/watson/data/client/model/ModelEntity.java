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

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The details of the model to be created. 
 */
public class ModelEntity {

    private String type;
    private SoftwareSpecRel softwareSpec;
    private Rel pipeline;
    private ModelDefinitionId modelDefinition;
    private Object hyperParameters;
    private String domain;
    private List<DataConnectionReference> trainingDataReferences = null;
    private FunctionEntitySchemas schemas;
    private String labelColumn;
    private String transformedLabelColumn;
    private ModelEntitySize size;
    private List<Metric> metrics = null;
    private Map<String, Object> custom;
    private Map<String, String> userDefinedObjects = null;

    public ModelEntity type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The model type (eg. 'tensorflow_1.5'). The supported model types can be found in the documentation.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public ModelEntity softwareSpec(SoftwareSpecRel softwareSpec) {
        this.softwareSpec = softwareSpec;
        return this;
    }

    /**
     * Get softwareSpec
     * @return softwareSpec
     **/
    @JsonProperty("software_spec")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public SoftwareSpecRel getSoftwareSpec() { return softwareSpec; }
    public void setSoftwareSpec(SoftwareSpecRel softwareSpec) { this.softwareSpec = softwareSpec; }

    public ModelEntity pipeline(Rel pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /**
     * Get pipeline
     * @return pipeline
     **/
    @javax.annotation.Nullable
    @JsonProperty("pipeline")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Rel getPipeline() { return pipeline; }
    public void setPipeline(Rel pipeline) { this.pipeline = pipeline; }

    public ModelEntity modelDefinition(ModelDefinitionId modelDefinition) {
        this.modelDefinition = modelDefinition;
        return this;
    }

    /**
     * Get modelDefinition
     * @return modelDefinition
     **/
    @javax.annotation.Nullable
    @JsonProperty("model_definition")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ModelDefinitionId getModelDefinition() { return modelDefinition; }
    public void setModelDefinition(ModelDefinitionId modelDefinition) { this.modelDefinition = modelDefinition; }

    public ModelEntity hyperParameters(Object hyperParameters) {
        this.hyperParameters = hyperParameters;
        return this;
    }

    /**
     * Hyper parameters used for training this model.
     * @return hyperParameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("hyper_parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getHyperParameters() { return hyperParameters; }
    public void setHyperParameters(Object hyperParameters) { this.hyperParameters = hyperParameters; }

    public ModelEntity domain(String domain) {
        this.domain = domain;
        return this;
    }

    /**
     * User provided domain name for this model. For example: sentiment, entity, visual-recognition, finance, retail, real estate etc.
     * @return domain
     **/
    @javax.annotation.Nullable
    @JsonProperty("domain")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }

    public ModelEntity trainingDataReferences(List<DataConnectionReference> trainingDataReferences) {
        this.trainingDataReferences = trainingDataReferences;
        return this;
    }

    public ModelEntity addTrainingDataReferencesItem(DataConnectionReference trainingDataReferencesItem) {
        if (this.trainingDataReferences == null) {
            this.trainingDataReferences = new ArrayList<>();
        }
        this.trainingDataReferences.add(trainingDataReferencesItem);
        return this;
    }

    /**
     * The training data that was used to create this model.
     * @return trainingDataReferences
     **/
    @javax.annotation.Nullable
    @JsonProperty("training_data_references")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DataConnectionReference> getTrainingDataReferences() { return trainingDataReferences; }
    public void setTrainingDataReferences(List<DataConnectionReference> trainingDataReferences) { this.trainingDataReferences = trainingDataReferences; }

    public ModelEntity schemas(FunctionEntitySchemas schemas) {
        this.schemas = schemas;
        return this;
    }

    /**
     * Get schemas
     * @return schemas
     **/
    @javax.annotation.Nullable
    @JsonProperty("schemas")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public FunctionEntitySchemas getSchemas() { return schemas; }
    public void setSchemas(FunctionEntitySchemas schemas) { this.schemas = schemas; }

    public ModelEntity labelColumn(String labelColumn) {
        this.labelColumn = labelColumn;
        return this;
    }

    /**
     * The name of the label column.
     * @return labelColumn
     **/
    @javax.annotation.Nullable
    @JsonProperty("label_column")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabelColumn() { return labelColumn; }
    public void setLabelColumn(String labelColumn) { this.labelColumn = labelColumn; }

    public ModelEntity transformedLabelColumn(String transformedLabelColumn) {
        this.transformedLabelColumn = transformedLabelColumn;
        return this;
    }

    /**
     * The name of the  label column seen by the estimator, which may have been transformed by the previous transformers in the pipeline. This is not necessarily the same column as the &#x60;label_column&#x60; in the initial data set.
     * @return transformedLabelColumn
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformed_label_column")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTransformedLabelColumn() { return transformedLabelColumn; }
    public void setTransformedLabelColumn(String transformedLabelColumn) { this.transformedLabelColumn = transformedLabelColumn; }

    public ModelEntity size(ModelEntitySize size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     * @return size
     **/
    @javax.annotation.Nullable
    @JsonProperty("size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ModelEntitySize getSize() { return size; }
    public void setSize(ModelEntitySize size) { this.size = size; }

    public ModelEntity metrics(List<Metric> metrics) {
        this.metrics = metrics;
        return this;
    }

    public ModelEntity addMetricsItem(Metric metricsItem) {
        if (this.metrics == null) {
            this.metrics = new ArrayList<>();
        }
        this.metrics.add(metricsItem);
        return this;
    }

    /**
     * Metrics that can be returned by an operation.
     * @return metrics
     **/
    @javax.annotation.Nullable
    @JsonProperty("metrics")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Metric> getMetrics() { return metrics; }
    public void setMetrics(List<Metric> metrics) { this.metrics = metrics; }

    public ModelEntity custom(Map<String, Object> custom) {
        this.custom = custom;
        return this;
    }

    public ModelEntity putCustom(String key, Object customItem) {
        if (this.custom == null) {
            this.custom = new HashMap<>();
        }
        this.custom.put(key, customItem);
        return this;
    }

    /**
     * User defined properties specified as key-value pairs (eg. '{"name": "model", "size": 2}').
     * @return custom
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getCustom() { return custom; }
    public void setCustom(Map<String, Object> custom) { this.custom = custom; }

    public ModelEntity userDefinedObjects(Map<String, String> userDefinedObjects) {
        this.userDefinedObjects = userDefinedObjects;
        return this;
    }

    public ModelEntity putUserDefinedObjectsItem(String key, String userDefinedObjectsItem) {
        if (this.userDefinedObjects == null) {
            this.userDefinedObjects = new HashMap<>();
        }
        this.userDefinedObjects.put(key, userDefinedObjectsItem);
        return this;
    }

    /**
     * User defined objects referenced by the model (eg. '{"MyLayer": "my_layers.MyLayer"}'). For any user defined class or function used in the model, its name, as referenced in the model, must be specified as the &#x60;key&#x60; and its fully qualified class or function name must be specified as the &#x60;value&#x60;. This is applicable for &#x60;Tensorflow 2.X&#x60; models serialized in &#x60;H5&#x60; format using the &#x60;tf.keras&#x60; API.
     * @return userDefinedObjects
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_defined_objects")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, String> getUserDefinedObjects() { return userDefinedObjects; }
    public void setUserDefinedObjects(Map<String, String> userDefinedObjects) { this.userDefinedObjects = userDefinedObjects; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModelEntity modelEntity = (ModelEntity) o;
        return Objects.equals(this.type, modelEntity.type) &&
                Objects.equals(this.softwareSpec, modelEntity.softwareSpec) &&
                Objects.equals(this.pipeline, modelEntity.pipeline) &&
                Objects.equals(this.modelDefinition, modelEntity.modelDefinition) &&
                Objects.equals(this.hyperParameters, modelEntity.hyperParameters) &&
                Objects.equals(this.domain, modelEntity.domain) &&
                Objects.equals(this.trainingDataReferences, modelEntity.trainingDataReferences) &&
                Objects.equals(this.schemas, modelEntity.schemas) &&
                Objects.equals(this.labelColumn, modelEntity.labelColumn) &&
                Objects.equals(this.transformedLabelColumn, modelEntity.transformedLabelColumn) &&
                Objects.equals(this.size, modelEntity.size) &&
                Objects.equals(this.metrics, modelEntity.metrics) &&
                Objects.equals(this.custom, modelEntity.custom) &&
                Objects.equals(this.userDefinedObjects, modelEntity.userDefinedObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, softwareSpec, pipeline, modelDefinition, hyperParameters, domain, trainingDataReferences, schemas, labelColumn, transformedLabelColumn, size, metrics, custom, userDefinedObjects);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    softwareSpec: ").append(toIndentedString(softwareSpec)).append("\n");
        sb.append("    pipeline: ").append(toIndentedString(pipeline)).append("\n");
        sb.append("    modelDefinition: ").append(toIndentedString(modelDefinition)).append("\n");
        sb.append("    hyperParameters: ").append(toIndentedString(hyperParameters)).append("\n");
        sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
        sb.append("    trainingDataReferences: ").append(toIndentedString(trainingDataReferences)).append("\n");
        sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
        sb.append("    labelColumn: ").append(toIndentedString(labelColumn)).append("\n");
        sb.append("    transformedLabelColumn: ").append(toIndentedString(transformedLabelColumn)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
        sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
        sb.append("    userDefinedObjects: ").append(toIndentedString(userDefinedObjects)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
