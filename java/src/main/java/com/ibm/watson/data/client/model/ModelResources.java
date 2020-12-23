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
 * ModelResources
 */
public class ModelResources extends PaginatedListAlternative {

    private List<ModelResource> resources = null;
    private SystemDetails system;

    public ModelResources resources(List<ModelResource> resources) {
        this.resources = resources;
        return this;
    }

    public ModelResources addResourcesItem(ModelResource resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * A list of models.
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("resources")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ModelResource> getResources() { return resources; }
    public void setResources(List<ModelResource> resources) { this.resources = resources; }

    public ModelResources system(SystemDetails system) {
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
    public SystemDetails getSystem() { return system; }
    public void setSystem(SystemDetails system) { this.system = system; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModelResources modelResources = (ModelResources) o;
        return super.equals(o) &&
                Objects.equals(this.resources, modelResources.resources) &&
                Objects.equals(this.system, modelResources.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resources, system);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelResources {\n");
        super.toString(sb);
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    system: ").append(toIndentedString(system)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
