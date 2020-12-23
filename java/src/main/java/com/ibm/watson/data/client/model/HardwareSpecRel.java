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
 * A hardware specification. 
 */
public class HardwareSpecRel extends Rel {

    private String name;
    private Integer numNodes;

    public HardwareSpecRel name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the hardware specification. One, and only one, of &#x60;id&#x60; or &#x60;name&#x60; must be set.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public HardwareSpecRel numNodes(Integer numNodes) {
        this.numNodes = numNodes;
        return this;
    }

    /**
     * The number of nodes applied to a computation.
     * @return numNodes
     **/
    @javax.annotation.Nullable
    @JsonProperty("num_nodes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getNumNodes() { return numNodes; }
    public void setNumNodes(Integer numNodes) { this.numNodes = numNodes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        HardwareSpecRel hardwareSpecRel = (HardwareSpecRel) o;
        return super.equals(o) &&
                Objects.equals(this.name, hardwareSpecRel.name) &&
                Objects.equals(this.numNodes, hardwareSpecRel.numNodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, numNodes);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HardwareSpecRel {\n");
        super.toString(sb);
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numNodes: ").append(toIndentedString(numNodes)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
