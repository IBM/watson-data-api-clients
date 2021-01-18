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
 * Compute properties for the cloud.
 */
public class TransactionalProjectComputeObjectCloud {

    private String crn;
    private String guid;
    private String label;
    private String name;
    private ComputeType type = ComputeType.SPARK;

    public TransactionalProjectComputeObjectCloud crn(String crn) {
        this.crn = crn;
        return this;
    }

    /**
     * The Cloud Resource Name (CRN) for the compute service associated with the
     * project.
     * @return crn
     **/
    @javax.annotation.Nullable
    @JsonProperty("crn")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCrn() { return crn; }
    public void setCrn(String crn) { this.crn = crn; }

    public TransactionalProjectComputeObjectCloud guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Unique guid of the associated project compute (i.e. GUID of Spark or
     * Machine Learning service instance).
     * @return guid
     **/
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public TransactionalProjectComputeObjectCloud label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Service label when compute type is "watson" (eg. 'watson_vision_combined').
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty("label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public TransactionalProjectComputeObjectCloud name(String name) {
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

    public TransactionalProjectComputeObjectCloud type(ComputeType type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the associated project compute.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ComputeType getType() { return type; }
    public void setType(ComputeType type) { this.type = type; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransactionalProjectComputeObjectCloud transactionalProjectComputeObjectCloud = (TransactionalProjectComputeObjectCloud)o;
        return Objects.equals(this.crn, transactionalProjectComputeObjectCloud.crn) &&
                Objects.equals(this.guid, transactionalProjectComputeObjectCloud.guid) &&
                Objects.equals(this.label, transactionalProjectComputeObjectCloud.label) &&
                Objects.equals(this.name, transactionalProjectComputeObjectCloud.name) &&
                Objects.equals(this.type, transactionalProjectComputeObjectCloud.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crn, guid, label, name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionalProjectComputeObjectCloud {\n");
        sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
