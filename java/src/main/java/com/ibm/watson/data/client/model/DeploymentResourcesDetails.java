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
 * System details including warnings and stats. This will get populated only if &#39;stats&#39; query parameter is passed with &#39;true&#39;. 
 */
public class DeploymentResourcesDetails {

    private DeploymentSystemDetails system;

    public DeploymentResourcesDetails system(DeploymentSystemDetails system) {
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
    public DeploymentSystemDetails getSystem() { return system; }
    public void setSystem(DeploymentSystemDetails system) { this.system = system; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentResourcesDetails deploymentResourcesAllOfSystem = (DeploymentResourcesDetails) o;
        return Objects.equals(this.system, deploymentResourcesAllOfSystem.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentResourcesAllOfSystem {\n");
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
