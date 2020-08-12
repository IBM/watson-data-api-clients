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
 * JobPostBodyConfiguration
 */
public class JobRuntimeConfiguration {

    private String envId;
    private String envType;
    private List<String> envVariables = null;
    private String version;
    private String deploymentJobDefinitionId;

    public JobRuntimeConfiguration envId(String envId) {
        this.envId = envId;
        return this;
    }

    /**
     * ID of associated runtime for the job (example: defaultsparkr1x4-18ce241b-c9e8-43ed-94a1-9f5585764924).
     * @return envId
     **/
    @javax.annotation.Nullable
    @JsonProperty("env_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEnvId() { return envId; }
    public void setEnvId(String envId) { this.envId = envId; }

    public JobRuntimeConfiguration envType(String envType) {
        this.envType = envType;
        return this;
    }

    /**
     * Type of associated runtime for the job (example: "default_spark").
     * @return envType
     **/
    @javax.annotation.Nullable
    @JsonProperty("env_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEnvType() { return envType; }
    public void setEnvType(String envType) { this.envType = envType; }

    public JobRuntimeConfiguration envVariables(List<String> envVariables) {
        this.envVariables = envVariables;
        return this;
    }

    public JobRuntimeConfiguration addEnvVariablesItem(String envVariablesItem) {
        if (this.envVariables == null) {
            this.envVariables = new ArrayList<>();
        }
        this.envVariables.add(envVariablesItem);
        return this;
    }

    /**
     * The environment variables, only for Notebook and Script jobs (example: ['key1=value1', 'key2=value2']).
     * @return envVariables
     **/
    @javax.annotation.Nullable
    @JsonProperty("env_variables")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getEnvVariables() { return envVariables; }
    public void setEnvVariables(List<String> envVariables) { this.envVariables = envVariables; }

    public JobRuntimeConfiguration version(String version) {
        this.version = version;
        return this;
    }

    /**
     * For Notebook jobs only, selected version (guid) of associated Notebook asset.
     * Empty if using latest version.
     * @return version
     **/
    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public JobRuntimeConfiguration deploymentJobDefinitionId(String deploymentJobDefinitionId) {
        this.deploymentJobDefinitionId = deploymentJobDefinitionId;
        return this;
    }

    /**
     * For WML batch deployment jobs only, the asset ID of a deployment job
     * definition.
     * @return deploymentJobDefinitionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("deployment_job_definition_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDeploymentJobDefinitionId() { return deploymentJobDefinitionId; }
    public void setDeploymentJobDefinitionId(String deploymentJobDefinitionId) { this.deploymentJobDefinitionId = deploymentJobDefinitionId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobRuntimeConfiguration jobPostBodyConfiguration = (JobRuntimeConfiguration)o;
        return Objects.equals(this.envId, jobPostBodyConfiguration.envId) &&
                Objects.equals(this.envVariables, jobPostBodyConfiguration.envVariables) &&
                Objects.equals(this.version, jobPostBodyConfiguration.version) &&
                Objects.equals(this.deploymentJobDefinitionId, jobPostBodyConfiguration.deploymentJobDefinitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(envId, envVariables, version,
                deploymentJobDefinitionId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobPostBodyConfiguration {\n");
        sb.append("    envId: ").append(toIndentedString(envId)).append("\n");
        sb.append("    envVariables: ").append(toIndentedString(envVariables)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    deploymentJobDefinitionId: ").append(toIndentedString(deploymentJobDefinitionId)).append("\n");
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
