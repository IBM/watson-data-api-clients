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
 * Definitions of the properties that are supported for the data source.
 */
public class DatasourceTypeProperties {

    private List<DatasourceTypeProperty> connection = null;
    private List<DatasourceTypeProperty> source = null;
    private List<DatasourceTypeProperty> target = null;
    private List<DatasourceTypeProperty> filter = null;
    private DatasourceTypePropertyConditions conditions;

    public DatasourceTypeProperties connection(List<DatasourceTypeProperty> connection) {
        this.connection = connection;
        return this;
    }

    public DatasourceTypeProperties addConnectionItem(DatasourceTypeProperty connectionItem) {
        if (this.connection == null) {
            this.connection = new ArrayList<>();
        }
        this.connection.add(connectionItem);
        return this;
    }

    /**
     * The connection properties.
     * @return connection
     **/
    @javax.annotation.Nullable
    @JsonProperty("connection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeProperty> getConnection() { return connection; }
    public void setConnection(List<DatasourceTypeProperty> connection) { this.connection = connection; }

    public DatasourceTypeProperties source(List<DatasourceTypeProperty> source) {
        this.source = source;
        return this;
    }

    public DatasourceTypeProperties addSourceItem(DatasourceTypeProperty sourceItem) {
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

    public DatasourceTypeProperties target(List<DatasourceTypeProperty> target) {
        this.target = target;
        return this;
    }

    public DatasourceTypeProperties addTargetItem(DatasourceTypeProperty targetItem) {
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

    public DatasourceTypeProperties filter(List<DatasourceTypeProperty> filter) {
        this.filter = filter;
        return this;
    }

    public DatasourceTypeProperties addFilterItem(DatasourceTypeProperty filterItem) {
        if (this.filter == null) {
            this.filter = new ArrayList<>();
        }
        this.filter.add(filterItem);
        return this;
    }

    /**
     * The filter properties that can be set for a discovery interaction.
     * @return filter
     **/
    @javax.annotation.Nullable
    @JsonProperty("filter")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeProperty> getFilter() { return filter; }
    public void setFilter(List<DatasourceTypeProperty> filter) { this.filter = filter; }

    public DatasourceTypeProperties conditions(DatasourceTypePropertyConditions conditions) {
        this.conditions = conditions;
        return this;
    }

    /**
     * Get conditions
     * @return conditions
     **/
    @javax.annotation.Nullable
    @JsonProperty("conditions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypePropertyConditions getConditions() { return conditions; }
    public void setConditions(DatasourceTypePropertyConditions conditions) { this.conditions = conditions; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeProperties datasourceTypeProperties = (DatasourceTypeProperties)o;
        return Objects.equals(this.connection,
                datasourceTypeProperties.connection) &&
                Objects.equals(this.source, datasourceTypeProperties.source) &&
                Objects.equals(this.target, datasourceTypeProperties.target) &&
                Objects.equals(this.filter, datasourceTypeProperties.filter) &&
                Objects.equals(this.conditions, datasourceTypeProperties.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection, source, target, filter, conditions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeProperties {\n");
        sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
        sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
        sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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
