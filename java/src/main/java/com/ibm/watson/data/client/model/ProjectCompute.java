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
import com.ibm.watson.data.client.model.enums.ComputeType;

import java.util.Objects;

/**
 * A compute associated with the project.
 */
public class ProjectCompute {

    private Object credentials;
    private String crn;
    private String guid;
    private String label;
    private String name;
    private ComputeType type;
    private Object properties;

    public ProjectCompute credentials(Object credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * The credentials used to access the compute.
     * @return credentials
     **/
    @JsonProperty("credentials")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Object getCredentials() { return credentials; }
    public void setCredentials(Object credentials) { this.credentials = credentials; }

    public ProjectCompute crn(String crn) {
        this.crn = crn;
        return this;
    }

    /**
     * The Cloud Resource Name (CRN) for the compute service associated with the project.
     * @return crn
     **/
    @javax.annotation.Nullable
    @JsonProperty("crn")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCrn() { return crn; }
    public void setCrn(String crn) { this.crn = crn; }

    public ProjectCompute guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Unique GUID of the associated project compute. i.e. GUID of Spark or
     * Machine Learning service instance.
     * @return guid
     **/
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public ProjectCompute label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Service label when compute type is &#39;watson&#39;
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty("label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public ProjectCompute name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Display name of the compute instance associated with the project.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ProjectCompute type(ComputeType type) {
        this.type = type;
        return this;
    }

    /**
     * The type of compute associated with the project.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ComputeType getType() { return type; }
    public void setType(ComputeType type) { this.type = type; }

    public ProjectCompute properties(Object properties) {
        this.properties = properties;
        return this;
    }

    /**
     * The properties of the compute.
     * @return properties
     **/
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Object getProperties() { return properties; }
    public void setProperties(Object properties) { this.properties = properties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectCompute projectCompute = (ProjectCompute)o;
        return Objects.equals(this.credentials, projectCompute.credentials) &&
                Objects.equals(this.crn, projectCompute.crn) &&
                Objects.equals(this.guid, projectCompute.guid) &&
                Objects.equals(this.label, projectCompute.label) &&
                Objects.equals(this.name, projectCompute.name) &&
                Objects.equals(this.type, projectCompute.type) &&
                Objects.equals(this.properties, projectCompute.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentials, crn, guid, label, name, type, properties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectCompute {\n");
        sb.append("    credentials: <redacted>\n");
        sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
