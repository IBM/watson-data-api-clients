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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request body for creating a new project.
 */
public class CreateProjectBody extends ProjectHeader {

    private ProjectCatalog catalog;
    private List<ProjectCompute> compute = null;
    private String generator;
    private ProjectGithub github;
    private ProjectScope scope;
    private ProjectSettings settings;
    private ProjectStorage storage;

    public CreateProjectBody catalog(ProjectCatalog catalog) {
        this.catalog = catalog;
        return this;
    }

    /**
     * Get catalog
     * @return catalog
     **/
    @javax.annotation.Nullable
    @JsonProperty("catalog")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectCatalog getCatalog() { return catalog; }
    public void setCatalog(ProjectCatalog catalog) { this.catalog = catalog; }

    public CreateProjectBody compute(List<ProjectCompute> compute) {
        this.compute = compute;
        return this;
    }

    public CreateProjectBody addComputeItem(ProjectCompute computeItem) {
        if (this.compute == null) {
            this.compute = new ArrayList<>();
        }
        this.compute.add(computeItem);
        return this;
    }

    /**
     * A list of computes associated with the project.
     * @return compute
     **/
    @javax.annotation.Nullable
    @JsonProperty("compute")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ProjectCompute> getCompute() { return compute; }
    public void setCompute(List<ProjectCompute> compute) { this.compute = compute; }

    public CreateProjectBody generator(String generator) {
        this.generator = generator;
        return this;
    }

    /**
     * A consistent label used to identify a client that created a project. A
     * generator must be comprised of the following characters - alphanumeric,
     * dash, underscore, space.
     * @return generator
     **/
    @JsonProperty("generator")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGenerator() { return generator; }
    public void setGenerator(String generator) { this.generator = generator; }

    public CreateProjectBody github(ProjectGithub github) {
        this.github = github;
        return this;
    }

    /**
     * Get github
     * @return github
     **/
    @javax.annotation.Nullable
    @JsonProperty("github")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectGithub getGithub() { return github; }
    public void setGithub(ProjectGithub github) { this.github = github; }

    public CreateProjectBody scope(ProjectScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     * @return scope
     **/
    @JsonProperty("scope")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ProjectScope getScope() { return scope; }
    public void setScope(ProjectScope scope) { this.scope = scope; }

    public CreateProjectBody settings(ProjectSettings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get settings
     * @return settings
     **/
    @javax.annotation.Nullable
    @JsonProperty("settings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectSettings getSettings() { return settings; }
    public void setSettings(ProjectSettings settings) { this.settings = settings; }

    public CreateProjectBody storage(ProjectStorage storage) {
        this.storage = storage;
        return this;
    }

    /**
     * Get storage
     * @return storage
     **/
    @JsonProperty("storage")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ProjectStorage getStorage() { return storage; }
    public void setStorage(ProjectStorage storage) { this.storage = storage; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateProjectBody createProjectBody = (CreateProjectBody)o;
        return super.equals(o) &&
                Objects.equals(this.catalog, createProjectBody.catalog) &&
                Objects.equals(this.compute, createProjectBody.compute) &&
                Objects.equals(this.generator, createProjectBody.generator) &&
                Objects.equals(this.github, createProjectBody.github) &&
                Objects.equals(this.scope, createProjectBody.scope) &&
                Objects.equals(this.settings, createProjectBody.settings) &&
                Objects.equals(this.storage, createProjectBody.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), catalog, compute, generator, github, scope, settings, storage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateProjectBody {\n");
        super.toString(sb);
        sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    generator: ").append(toIndentedString(generator)).append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
        sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
