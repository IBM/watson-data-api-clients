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
 * The location of the intermediate model. 
 */
public class ModelLocation {

    private String pipeline;
    private String pipelineModel;
    private String model;

    public ModelLocation pipeline(String pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /**
     * The generated pipeline at this stage.
     * @return pipeline
     **/
    @javax.annotation.Nullable
    @JsonProperty("pipeline")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPipeline() { return pipeline; }
    public void setPipeline(String pipeline) { this.pipeline = pipeline; }

    public ModelLocation pipelineModel(String pipelineModel) {
        this.pipelineModel = pipelineModel;
        return this;
    }

    /**
     * The generated pipeline model.
     * @return pipelineModel
     **/
    @javax.annotation.Nullable
    @JsonProperty("pipeline_model")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPipelineModel() { return pipelineModel; }
    public void setPipelineModel(String pipelineModel) { this.pipelineModel = pipelineModel; }

    public ModelLocation model(String model) {
        this.model = model;
        return this;
    }

    /**
     * The generated model at this stage.
     * @return model
     **/
    @javax.annotation.Nullable
    @JsonProperty("model")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModelLocation modelLocation = (ModelLocation) o;
        return Objects.equals(this.pipeline, modelLocation.pipeline) &&
                Objects.equals(this.pipelineModel, modelLocation.pipelineModel) &&
                Objects.equals(this.model, modelLocation.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pipeline, pipelineModel, model);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelLocation {\n");
        sb.append("    pipeline: ").append(toIndentedString(pipeline)).append("\n");
        sb.append("    pipelineModel: ").append(toIndentedString(pipelineModel)).append("\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
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
