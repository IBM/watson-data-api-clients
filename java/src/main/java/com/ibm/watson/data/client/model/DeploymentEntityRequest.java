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

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Details about the deployment to be created.  The parameters specifying the deployment type are &#x60;online&#x60;, &#x60;batch&#x60; and &#x60;virtual&#x60;. These parameters are mutually exclusive. Specify only any one of these when creating a deployment.  Use &#x60;hybrid_pipeline_hardware_specs&#x60; only when creating a batch deployment job of a hybrid pipeline in order to specify compute configuration for each pipeline node. For all other batch deployment cases use &#x60;hardware_spec&#x60; to specify compute configuration. &#x60;hybrid_pipeline_hardware_specs&#x60; and &#x60;hardware_spec&#x60; are mutually exclusive, specify only any one.  &#x60;hybrid_pipeline_hardware_specs&#x60; or &#x60;hardware_spec&#x60; cannot be specified at the time of creation of &#x60;online&#x60; and &#x60;virtual&#x60; deployments.  For batch deployments, &#x60;hardware_spec.num_nodes&#x60; parameter is not currently supported.  For online deployments, &#x60;hardware_spec.num_nodes&#x60; parameter is not supported as part of POST /ml/v4/deployments API request. It can be updated using PATCH /ml/v4/deployments/&lt;deployment id&gt;. 
 */
public class DeploymentEntityRequest {

    private List<String> tags = null;
    private String spaceId;
    private String name;
    private String description;
    private Map<String, Object> custom;
    private Rel asset;
    private HardwareSpecRel hardwareSpec;
    private List<Object> hybridPipelineHardwareSpecs = null;
    private DeploymentEntityRequestPhysical online;
    private DeploymentEntityRequestPhysical batch;
    private DeploymentEntityRequestVirtual virtual;

    public DeploymentEntityRequest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public DeploymentEntityRequest addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Tags that can be used when searching for resources.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public DeploymentEntityRequest spaceId(String spaceId) {
        this.spaceId = spaceId;
        return this;
    }

    /**
     * The space that contains the resource.
     * @return spaceId
     **/
    @JsonProperty("space_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSpaceId() { return spaceId; }
    public void setSpaceId(String spaceId) { this.spaceId = spaceId; }

    public DeploymentEntityRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the deployment (required for creation).
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DeploymentEntityRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the deployment.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DeploymentEntityRequest custom(Map<String, Object> custom) {
        this.custom = custom;
        return this;
    }

    /**
     * User defined properties specified as key-value pairs.
     * @return custom
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getCustom() { return custom; }
    public void setCustom(Map<String, Object> custom) { this.custom = custom; }

    public DeploymentEntityRequest asset(Rel asset) {
        this.asset = asset;
        return this;
    }

    /**
     * Get asset
     * @return asset
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Rel getAsset() { return asset; }
    public void setAsset(Rel asset) { this.asset = asset; }

    public DeploymentEntityRequest hardwareSpec(HardwareSpecRel hardwareSpec) {
        this.hardwareSpec = hardwareSpec;
        return this;
    }

    /**
     * Get hardwareSpec
     * @return hardwareSpec
     **/
    @javax.annotation.Nullable
    @JsonProperty("hardware_spec")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HardwareSpecRel getHardwareSpec() { return hardwareSpec; }
    public void setHardwareSpec(HardwareSpecRel hardwareSpec) { this.hardwareSpec = hardwareSpec; }

    public DeploymentEntityRequest hybridPipelineHardwareSpecs(List<Object> hybridPipelineHardwareSpecs) {
        this.hybridPipelineHardwareSpecs = hybridPipelineHardwareSpecs;
        return this;
    }

    public DeploymentEntityRequest addHybridPipelineHardwareSpecsItem(Object hybridPipelineHardwareSpecsItem) {
        if (this.hybridPipelineHardwareSpecs == null) {
            this.hybridPipelineHardwareSpecs = new ArrayList<>();
        }
        this.hybridPipelineHardwareSpecs.add(hybridPipelineHardwareSpecsItem);
        return this;
    }

    /**
     * Hybrid pipeline hardware specification.
     * @return hybridPipelineHardwareSpecs
     **/
    @javax.annotation.Nullable
    @JsonProperty("hybrid_pipeline_hardware_specs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getHybridPipelineHardwareSpecs() { return hybridPipelineHardwareSpecs; }
    public void setHybridPipelineHardwareSpecs(List<Object> hybridPipelineHardwareSpecs) { this.hybridPipelineHardwareSpecs = hybridPipelineHardwareSpecs; }

    public DeploymentEntityRequest online(DeploymentEntityRequestPhysical online) {
        this.online = online;
        return this;
    }

    /**
     * Get online
     * @return online
     **/
    @javax.annotation.Nullable
    @JsonProperty("online")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentEntityRequestPhysical getOnline() { return online; }
    public void setOnline(DeploymentEntityRequestPhysical online) { this.online = online; }

    public DeploymentEntityRequest batch(DeploymentEntityRequestPhysical batch) {
        this.batch = batch;
        return this;
    }

    /**
     * Get batch
     * @return batch
     **/
    @javax.annotation.Nullable
    @JsonProperty("batch")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentEntityRequestPhysical getBatch() { return batch; }
    public void setBatch(DeploymentEntityRequestPhysical batch) { this.batch = batch; }

    public DeploymentEntityRequest virtual(DeploymentEntityRequestVirtual virtual) {
        this.virtual = virtual;
        return this;
    }

    /**
     * Get virtual
     * @return virtual
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtual")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentEntityRequestVirtual getVirtual() { return virtual; }
    public void setVirtual(DeploymentEntityRequestVirtual virtual) { this.virtual = virtual; }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentEntityRequest deploymentEntityRequest = (DeploymentEntityRequest) o;
        return Objects.equals(this.tags, deploymentEntityRequest.tags) &&
                Objects.equals(this.spaceId, deploymentEntityRequest.spaceId) &&
                Objects.equals(this.name, deploymentEntityRequest.name) &&
                Objects.equals(this.description, deploymentEntityRequest.description) &&
                Objects.equals(this.custom, deploymentEntityRequest.custom) &&
                Objects.equals(this.asset, deploymentEntityRequest.asset) &&
                Objects.equals(this.hardwareSpec, deploymentEntityRequest.hardwareSpec) &&
                Objects.equals(this.hybridPipelineHardwareSpecs, deploymentEntityRequest.hybridPipelineHardwareSpecs) &&
                Objects.equals(this.online, deploymentEntityRequest.online) &&
                Objects.equals(this.batch, deploymentEntityRequest.batch) &&
                Objects.equals(this.virtual, deploymentEntityRequest.virtual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, spaceId, name, description, custom, asset, hardwareSpec, hybridPipelineHardwareSpecs, online, batch, virtual);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentEntityRequest {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    spaceId: ").append(toIndentedString(spaceId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
        sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
        sb.append("    hardwareSpec: ").append(toIndentedString(hardwareSpec)).append("\n");
        sb.append("    hybridPipelineHardwareSpecs: ").append(toIndentedString(hybridPipelineHardwareSpecs)).append("\n");
        sb.append("    online: ").append(toIndentedString(online)).append("\n");
        sb.append("    batch: ").append(toIndentedString(batch)).append("\n");
        sb.append("    virtual: ").append(toIndentedString(virtual)).append("\n");
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
