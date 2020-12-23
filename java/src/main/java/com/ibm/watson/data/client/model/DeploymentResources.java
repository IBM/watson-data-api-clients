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
 * DeploymentResources
 */
public class DeploymentResources extends PaginatedListAlternative {

    private List<DeploymentResource> resources = null;
    private DeploymentResourcesDetails system;

    public DeploymentResources resources(List<DeploymentResource> resources) {
        this.resources = resources;
        return this;
    }

    public DeploymentResources addResourcesItem(DeploymentResource resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * A list of deployment resources. This will be empty if &#39;stats&#39; query parameter is passed with &#39;true&#39;.
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DeploymentResource> getResources() { return resources; }
    public void setResources(List<DeploymentResource> resources) { this.resources = resources; }

    public DeploymentResources system(DeploymentResourcesDetails system) {
        this.system = system;
        return this;
    }

    /**
     * Get system
     * @return system
     **/
    @javax.annotation.Nullable
    @JsonProperty("system")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentResourcesDetails getSystem() { return system; }
    public void setSystem(DeploymentResourcesDetails system) { this.system = system; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentResources deploymentResources = (DeploymentResources) o;
        return super.equals(o) &&
                Objects.equals(this.resources, deploymentResources.resources) &&
                Objects.equals(this.system, deploymentResources.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resources, system);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentResources {\n");
        super.toString(sb);
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    system: ").append(toIndentedString(system)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
