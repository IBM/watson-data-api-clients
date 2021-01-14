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

import java.util.Objects;

/**
 * ColumnDetail
 */
public class ColumnDetail {

    private String name;
    private String omrsGuid;
    private Double position;
    private ColumnTypeDetails type;

    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @javax.annotation.Nullable
    @JsonProperty("omrs_guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOmrsGuid() { return omrsGuid; }
    public void setOmrsGuid(String omrsGuid) { this.omrsGuid = omrsGuid; }

    @javax.annotation.Nullable
    @JsonProperty("position")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getPosition() { return position; }
    public void setPosition(Double position) { this.position = position; }

    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ColumnTypeDetails getType() { return type; }
    public void setType(ColumnTypeDetails type) { this.type = type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnDetail that = (ColumnDetail) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(omrsGuid, that.omrsGuid) &&
                Objects.equals(position, that.position) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, omrsGuid, position, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ColumnDetail {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    omrsGuid: ").append(toIndentedString(omrsGuid)).append("\n");
        sb.append("    position: ").append(toIndentedString(position)).append("\n");
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
