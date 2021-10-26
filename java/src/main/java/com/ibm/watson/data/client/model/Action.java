/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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
 * Action
 */
public class Action {

    private String name;
    private List<Parameter> parameters = null;
    private Action subaction;

    public Action name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Action parameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    public Action addParametersItem(Parameter parametersItem) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * Get parameters
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Parameter> getParameters() {
        return parameters;
    }
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Action subaction(Action subaction) {
        this.subaction = subaction;
        return this;
    }

    /**
     * Get subaction
     * @return subaction
     **/
    @javax.annotation.Nullable
    @JsonProperty("subaction")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Action getSubaction() {
        return subaction;
    }
    public void setSubaction(Action subaction) {
        this.subaction = subaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Action action = (Action) o;
        return Objects.equals(this.name, action.name) &&
                Objects.equals(this.parameters, action.parameters) &&
                Objects.equals(this.subaction, action.subaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parameters, subaction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Action {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    subaction: ").append(toIndentedString(subaction)).append("\n");
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
