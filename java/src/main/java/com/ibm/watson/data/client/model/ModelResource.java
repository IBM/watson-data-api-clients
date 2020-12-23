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
 * The information for a model. 
 */
public class ModelResource {

    private ResourceMeta metadata = null;
    private ModelEntity entity = null;
    private SystemDetails system;

    public ModelResource metadata(ResourceMeta metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ResourceMeta getMetadata() { return metadata; }
    public void setMetadata(ResourceMeta metadata) { this.metadata = metadata; }

    public ModelResource entity(ModelEntity entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Get entity
     * @return entity
     **/
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ModelEntity getEntity() { return entity; }
    public void setEntity(ModelEntity entity) { this.entity = entity; }

    public ModelResource system(SystemDetails system) {
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
        ModelResource modelResource = (ModelResource) o;
        return Objects.equals(this.metadata, modelResource.metadata) &&
                Objects.equals(this.entity, modelResource.entity) &&
                Objects.equals(this.system, modelResource.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, entity, system);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelResource {\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    system: ").append(toIndentedString(system)).append("\n");
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
