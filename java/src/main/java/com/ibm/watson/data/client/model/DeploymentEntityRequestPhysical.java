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

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Indicates that this is an online deployment. An empty object has to be specified. More properties will be added later on to setup the online deployment.
 */
public class DeploymentEntityRequestPhysical {

    private Map<String, Object> parameters;

    public DeploymentEntityRequestPhysical parameters(Map<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * A set of key-value pairs where &#x60;key&#x60; is the parameter name.
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getParameters() { return parameters; }
    public void setParameters(Map<String, Object> parameters) { this.parameters = parameters; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentEntityRequestPhysical deploymentEntityRequestOnline = (DeploymentEntityRequestPhysical) o;
        return Objects.equals(this.parameters, deploymentEntityRequestOnline.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentEntityRequestPhysical {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
