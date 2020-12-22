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
 * A compute associated with the space.
 */
public class SpaceCompute {

    private String crn;
    private String guid;
    private String name;
    private ComputeType type;

    public SpaceCompute crn(String crn) {
        this.crn = crn;
        return this;
    }

    /**
     * The Cloud Resource Name (CRN) for the compute service associated with the space.
     * @return crn
     **/
    @javax.annotation.Nullable
    @JsonProperty("crn")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCrn() { return crn; }
    public void setCrn(String crn) { this.crn = crn; }

    public SpaceCompute guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Unique GUID of the associated space compute. i.e. GUID of Spark or
     * Machine Learning service instance.
     * @return guid
     **/
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public SpaceCompute name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Display name of the compute instance associated with the space.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SpaceCompute type(ComputeType type) {
        this.type = type;
        return this;
    }

    /**
     * The type of compute associated with the space.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ComputeType getType() { return type; }
    public void setType(ComputeType type) { this.type = type; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SpaceCompute that = (SpaceCompute)o;
        return Objects.equals(this.crn, that.crn) &&
                Objects.equals(this.guid, that.guid) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crn, guid, name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SpaceCompute {\n");
        sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
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
