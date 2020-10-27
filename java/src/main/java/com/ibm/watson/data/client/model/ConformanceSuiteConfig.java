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
 * ConformanceSuiteConfig
 */
public class ConformanceSuiteConfig {

    private PlatformConformanceWorkbenchConfig platformWorkbenchConfig;
    private RepositoryConformanceWorkbenchConfig repositoryWorkbenchConfig;

    public ConformanceSuiteConfig platformWorkbenchConfig(PlatformConformanceWorkbenchConfig platformWorkbenchConfig) {
        this.platformWorkbenchConfig = platformWorkbenchConfig;
        return this;
    }

    /**
     * Get platformWorkbenchConfig
     * @return platformWorkbenchConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("platformWorkbenchConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PlatformConformanceWorkbenchConfig getPlatformWorkbenchConfig() { return platformWorkbenchConfig; }
    public void setPlatformWorkbenchConfig(PlatformConformanceWorkbenchConfig platformWorkbenchConfig) { this.platformWorkbenchConfig = platformWorkbenchConfig; }

    public ConformanceSuiteConfig repositoryWorkbenchConfig(RepositoryConformanceWorkbenchConfig repositoryWorkbenchConfig) {
        this.repositoryWorkbenchConfig = repositoryWorkbenchConfig;
        return this;
    }

    /**
     * Get repositoryWorkbenchConfig
     * @return repositoryWorkbenchConfig
     **/
    @javax.annotation.Nullable
    @JsonProperty("repositoryWorkbenchConfig")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public RepositoryConformanceWorkbenchConfig getRepositoryWorkbenchConfig() { return repositoryWorkbenchConfig; }
    public void setRepositoryWorkbenchConfig(RepositoryConformanceWorkbenchConfig repositoryWorkbenchConfig) { this.repositoryWorkbenchConfig = repositoryWorkbenchConfig; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConformanceSuiteConfig conformanceSuiteConfig = (ConformanceSuiteConfig)o;
        return Objects.equals(this.platformWorkbenchConfig, conformanceSuiteConfig.platformWorkbenchConfig) &&
                Objects.equals(this.repositoryWorkbenchConfig, conformanceSuiteConfig.repositoryWorkbenchConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platformWorkbenchConfig, repositoryWorkbenchConfig);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConformanceSuiteConfig {\n");
        sb.append("    platformWorkbenchConfig: ").append(toIndentedString(platformWorkbenchConfig)).append("\n");
        sb.append("    repositoryWorkbenchConfig: ").append(toIndentedString(repositoryWorkbenchConfig)).append("\n");
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
