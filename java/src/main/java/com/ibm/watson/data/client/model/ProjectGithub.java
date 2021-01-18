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
import java.util.Objects;

/**
 * The GitHub repository associated with the project.
 */
public class ProjectGithub {

    private String repository;

    public ProjectGithub repository(String repository) {
        this.repository = repository;
        return this;
    }

    /**
     * Allows for project integration with GitHub. Must be a valid URL to a Github repository
     * (eg. 'git@github.ibm.com:dap/ngp-projects-api.git').
     * @return repository
     **/
    @JsonProperty("repository")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRepository() { return repository; }
    public void setRepository(String repository) { this.repository = repository; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectGithub projectGithub = (ProjectGithub)o;
        return Objects.equals(this.repository, projectGithub.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectGithub {\n");
        sb.append("    repository: ").append(toIndentedString(repository)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
