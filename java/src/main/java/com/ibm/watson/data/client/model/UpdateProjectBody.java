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
 * The request body for updating an existing project.
 */
public class UpdateProjectBody extends ProjectHeader {

    private ProjectCatalog catalog;
    private List<ProjectCompute> compute = null;
    private ProjectDefinedCrowd definedCrowd;
    private ProjectFigureEight figureEight;
    private ProjectGithub github;

    public UpdateProjectBody catalog(ProjectCatalog catalog) {
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

    public UpdateProjectBody compute(List<ProjectCompute> compute) {
        this.compute = compute;
        return this;
    }

    public UpdateProjectBody addComputeItem(ProjectCompute computeItem) {
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

    public UpdateProjectBody definedCrowd(ProjectDefinedCrowd definedCrowd) {
        this.definedCrowd = definedCrowd;
        return this;
    }

    /**
     * Get definedCrowd
     * @return definedCrowd
     **/
    @javax.annotation.Nullable
    @JsonProperty("defined_crowd")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectDefinedCrowd getDefinedCrowd() { return definedCrowd; }
    public void setDefinedCrowd(ProjectDefinedCrowd definedCrowd) { this.definedCrowd = definedCrowd; }

    public UpdateProjectBody figureEight(ProjectFigureEight figureEight) {
        this.figureEight = figureEight;
        return this;
    }

    /**
     * Get figureEight
     * @return figureEight
     **/
    @javax.annotation.Nullable
    @JsonProperty("figure_eight")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ProjectFigureEight getFigureEight() { return figureEight; }
    public void setFigureEight(ProjectFigureEight figureEight) { this.figureEight = figureEight; }

    public UpdateProjectBody github(ProjectGithub github) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateProjectBody updateProjectBody = (UpdateProjectBody)o;
        return super.equals(o) &&
                Objects.equals(this.catalog, updateProjectBody.catalog) &&
                Objects.equals(this.compute, updateProjectBody.compute) &&
                Objects.equals(this.definedCrowd, updateProjectBody.definedCrowd) &&
                Objects.equals(this.figureEight, updateProjectBody.figureEight) &&
                Objects.equals(this.github, updateProjectBody.github);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), catalog, compute, definedCrowd, figureEight, github);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateProjectBody {\n");
        super.toString(sb);
        sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    definedCrowd: ").append(toIndentedString(definedCrowd)).append("\n");
        sb.append("    figureEight: ").append(toIndentedString(figureEight)).append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
