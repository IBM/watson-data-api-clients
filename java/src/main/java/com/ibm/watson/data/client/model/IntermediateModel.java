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
 * The details of the intermediate model. 
 */
public class IntermediateModel {

    private String name;
    private String process;
    private ModelLocation location;
    private String notebookLocation;
    private String sdkNotebookLocation;
    private List<String> pipelineNodes = null;
    private List<String> compositionSteps = null;
    private Integer duration;
    private String modelAsset;

    public IntermediateModel name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the pipeline.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public IntermediateModel process(String process) {
        this.process = process;
        return this;
    }

    /**
     * The process that generated this pipeline.
     * @return process
     **/
    @JsonProperty("process")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getProcess() { return process; }
    public void setProcess(String process) { this.process = process; }

    public IntermediateModel location(ModelLocation location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     * @return location
     **/
    @javax.annotation.Nullable
    @JsonProperty("location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ModelLocation getLocation() { return location; }
    public void setLocation(ModelLocation location) { this.location = location; }

    public IntermediateModel notebookLocation(String notebookLocation) {
        this.notebookLocation = notebookLocation;
        return this;
    }

    /**
     * Get notebookLocation
     * @return notebookLocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("notebook_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getNotebookLocation() { return notebookLocation; }
    public void setNotebookLocation(String notebookLocation) { this.notebookLocation = notebookLocation; }

    public IntermediateModel sdkNotebookLocation(String sdkNotebookLocation) {
        this.sdkNotebookLocation = sdkNotebookLocation;
        return this;
    }

    /**
     * Get sdkNotebookLocation
     * @return sdkNotebookLocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("sdk_notebook_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSdkNotebookLocation() { return sdkNotebookLocation; }
    public void setSdkNotebookLocation(String sdkNotebookLocation) { this.sdkNotebookLocation = sdkNotebookLocation; }

    public IntermediateModel pipelineNodes(List<String> pipelineNodes) {
        this.pipelineNodes = pipelineNodes;
        return this;
    }

    public IntermediateModel addPipelineNodesItem(String pipelineNodesItem) {
        if (this.pipelineNodes == null) {
            this.pipelineNodes = new ArrayList<>();
        }
        this.pipelineNodes.add(pipelineNodesItem);
        return this;
    }

    /**
     * The nodes of this pipeline.
     * @return pipelineNodes
     **/
    @javax.annotation.Nullable
    @JsonProperty("pipeline_nodes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getPipelineNodes() { return pipelineNodes; }
    public void setPipelineNodes(List<String> pipelineNodes) { this.pipelineNodes = pipelineNodes; }

    public IntermediateModel compositionSteps(List<String> compositionSteps) {
        this.compositionSteps = compositionSteps;
        return this;
    }

    public IntermediateModel addCompositionStepsItem(String compositionStepsItem) {
        if (this.compositionSteps == null) {
            this.compositionSteps = new ArrayList<>();
        }
        this.compositionSteps.add(compositionStepsItem);
        return this;
    }

    /**
     * The steps that lead to the creation of this pipeline.
     * @return compositionSteps
     **/
    @javax.annotation.Nullable
    @JsonProperty("composition_steps")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getCompositionSteps() { return compositionSteps; }
    public void setCompositionSteps(List<String> compositionSteps) { this.compositionSteps = compositionSteps; }

    public IntermediateModel duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Get duration
     * @return duration
     **/
    @javax.annotation.Nullable
    @JsonProperty("duration")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public IntermediateModel modelAsset(String modelAsset) {
        this.modelAsset = modelAsset;
        return this;
    }

    /**
     * Get modelAsset
     * @return modelAsset
     **/
    @javax.annotation.Nullable
    @JsonProperty("model_asset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModelAsset() { return modelAsset; }
    public void setModelAsset(String modelAsset) { this.modelAsset = modelAsset; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        IntermediateModel intermediateModel = (IntermediateModel) o;
        return Objects.equals(this.name, intermediateModel.name) &&
                Objects.equals(this.process, intermediateModel.process) &&
                Objects.equals(this.location, intermediateModel.location) &&
                Objects.equals(this.notebookLocation, intermediateModel.notebookLocation) &&
                Objects.equals(this.sdkNotebookLocation, intermediateModel.sdkNotebookLocation) &&
                Objects.equals(this.pipelineNodes, intermediateModel.pipelineNodes) &&
                Objects.equals(this.compositionSteps, intermediateModel.compositionSteps) &&
                Objects.equals(this.duration, intermediateModel.duration) &&
                Objects.equals(this.modelAsset, intermediateModel.modelAsset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, process, location, notebookLocation, sdkNotebookLocation, pipelineNodes, compositionSteps, duration, modelAsset);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IntermediateModel {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    process: ").append(toIndentedString(process)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    notebookLocation: ").append(toIndentedString(notebookLocation)).append("\n");
        sb.append("    sdkNotebookLocation: ").append(toIndentedString(sdkNotebookLocation)).append("\n");
        sb.append("    pipelineNodes: ").append(toIndentedString(pipelineNodes)).append("\n");
        sb.append("    compositionSteps: ").append(toIndentedString(compositionSteps)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    modelAsset: ").append(toIndentedString(modelAsset)).append("\n");
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
