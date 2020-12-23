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
 * ModelEntityRequest
 */
public class ModelEntityRequest extends ModelEntity {

    private String name;
    private String projectId;
    private String spaceId;
    private String description;
    private List<String> tags = null;
    private ContentLocation contentLocation;

    public ModelEntityRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the resource.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ModelEntityRequest projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * The project that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be given.
     * @return projectId
     **/
    @javax.annotation.Nullable
    @JsonProperty("project_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public ModelEntityRequest spaceId(String spaceId) {
        this.spaceId = spaceId;
        return this;
    }

    /**
     * The space that contains the resource. Either &#x60;space_id&#x60; or &#x60;project_id&#x60; has to be given.
     * @return spaceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("space_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSpaceId() { return spaceId; }
    public void setSpaceId(String spaceId) { this.spaceId = spaceId; }

    public ModelEntityRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the resource.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ModelEntityRequest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ModelEntityRequest addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A list of tags for this resource.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public ModelEntityRequest contentLocation(ContentLocation contentLocation) {
        this.contentLocation = contentLocation;
        return this;
    }

    /**
     * Get contentLocation
     * @return contentLocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("content_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ContentLocation getContentLocation() { return contentLocation; }
    public void setContentLocation(ContentLocation contentLocation) { this.contentLocation = contentLocation; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModelEntityRequest modelEntityRequest = (ModelEntityRequest) o;
        return super.equals(o) &&
                Objects.equals(this.name, modelEntityRequest.name) &&
                Objects.equals(this.projectId, modelEntityRequest.projectId) &&
                Objects.equals(this.spaceId, modelEntityRequest.spaceId) &&
                Objects.equals(this.description, modelEntityRequest.description) &&
                Objects.equals(this.tags, modelEntityRequest.tags) &&
                Objects.equals(this.contentLocation, modelEntityRequest.contentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, projectId, spaceId, description, tags, contentLocation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelEntityRequest {\n");
        super.toString(sb);
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    spaceId: ").append(toIndentedString(spaceId)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    contentLocation: ").append(toIndentedString(contentLocation)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
