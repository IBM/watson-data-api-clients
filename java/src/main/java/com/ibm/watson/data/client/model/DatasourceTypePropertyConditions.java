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
 * Conditions to be used to validate properties.
 */
public class DatasourceTypePropertyConditions {

    private List<DatasourceTypePropertyCondition> connection = null;
    private List<DatasourceTypePropertyCondition> source = null;
    private List<DatasourceTypePropertyCondition> target = null;
    private List<DatasourceTypePropertyCondition> filter = null;

    public DatasourceTypePropertyConditions connection(List<DatasourceTypePropertyCondition> connection) {
        this.connection = connection;
        return this;
    }

    public DatasourceTypePropertyConditions addConnectionItem(DatasourceTypePropertyCondition connectionItem) {
        if (this.connection == null) {
            this.connection = new ArrayList<>();
        }
        this.connection.add(connectionItem);
        return this;
    }

    /**
     * Conditions related to connection properties.
     * @return connection
     **/
    @javax.annotation.Nullable
    @JsonProperty("connection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypePropertyCondition> getConnection() { return connection; }
    public void setConnection(List<DatasourceTypePropertyCondition> connection) { this.connection = connection; }

    public DatasourceTypePropertyConditions source(List<DatasourceTypePropertyCondition> source) {
        this.source = source;
        return this;
    }

    public DatasourceTypePropertyConditions addSourceItem(DatasourceTypePropertyCondition sourceItem) {
        if (this.source == null) {
            this.source = new ArrayList<>();
        }
        this.source.add(sourceItem);
        return this;
    }

    /**
     * Conditions related to source properties.
     * @return source
     **/
    @javax.annotation.Nullable
    @JsonProperty("source")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypePropertyCondition> getSource() { return source; }
    public void setSource(List<DatasourceTypePropertyCondition> source) { this.source = source; }

    public DatasourceTypePropertyConditions target(List<DatasourceTypePropertyCondition> target) {
        this.target = target;
        return this;
    }

    public DatasourceTypePropertyConditions addTargetItem(DatasourceTypePropertyCondition targetItem) {
        if (this.target == null) {
            this.target = new ArrayList<>();
        }
        this.target.add(targetItem);
        return this;
    }

    /**
     * Conditions related to target properties.
     * @return target
     **/
    @javax.annotation.Nullable
    @JsonProperty("target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypePropertyCondition> getTarget() { return target; }
    public void setTarget(List<DatasourceTypePropertyCondition> target) { this.target = target; }

    public DatasourceTypePropertyConditions filter(List<DatasourceTypePropertyCondition> filter) {
        this.filter = filter;
        return this;
    }

    public DatasourceTypePropertyConditions addFilterItem(DatasourceTypePropertyCondition filterItem) {
        if (this.filter == null) {
            this.filter = new ArrayList<>();
        }
        this.filter.add(filterItem);
        return this;
    }

    /**
     * Conditions related to filter properties.
     * @return filter
     **/
    @javax.annotation.Nullable
    @JsonProperty("filter")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypePropertyCondition> getFilter() { return filter; }
    public void setFilter(List<DatasourceTypePropertyCondition> filter) { this.filter = filter; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypePropertyConditions datasourceTypePropertyConditions = (DatasourceTypePropertyConditions)o;
        return Objects.equals(this.connection, datasourceTypePropertyConditions.connection) &&
                Objects.equals(this.source, datasourceTypePropertyConditions.source) &&
                Objects.equals(this.target, datasourceTypePropertyConditions.target) &&
                Objects.equals(this.filter, datasourceTypePropertyConditions.filter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection, source, target, filter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypePropertyConditions {\n");
        sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
        sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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
