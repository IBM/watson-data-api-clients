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
 * Interaction properties allowed for a connection.
 */
public class ConnectionInteractionProperties {

    private List<DatasourceTypeProperty> source = null;
    private List<DatasourceTypeProperty> target = null;

    public ConnectionInteractionProperties source(List<DatasourceTypeProperty> source) {
        this.source = source;
        return this;
    }

    public ConnectionInteractionProperties addSourceItem(DatasourceTypeProperty sourceItem) {
        if (this.source == null) {
            this.source = new ArrayList<>();
        }
        this.source.add(sourceItem);
        return this;
    }

    /**
     * The properties that can be set for a source interaction.
     * @return source
     **/
    @javax.annotation.Nullable
    @JsonProperty("source")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeProperty> getSource() { return source; }
    public void setSource(List<DatasourceTypeProperty> source) { this.source = source; }

    public ConnectionInteractionProperties target(List<DatasourceTypeProperty> target) {
        this.target = target;
        return this;
    }

    public ConnectionInteractionProperties addTargetItem(DatasourceTypeProperty targetItem) {
        if (this.target == null) {
            this.target = new ArrayList<>();
        }
        this.target.add(targetItem);
        return this;
    }

    /**
     * The properties that can be set for a target interaction.
     * @return target
     **/
    @javax.annotation.Nullable
    @JsonProperty("target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeProperty> getTarget() { return target; }
    public void setTarget(List<DatasourceTypeProperty> target) { this.target = target; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConnectionInteractionProperties connectionInteractionProperties = (ConnectionInteractionProperties)o;
        return Objects.equals(this.source, connectionInteractionProperties.source) &&
                Objects.equals(this.target, connectionInteractionProperties.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionInteractionProperties {\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
