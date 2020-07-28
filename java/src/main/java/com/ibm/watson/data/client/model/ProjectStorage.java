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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ibm.watson.data.client.model.enums.StorageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * The storage associated with the project.
 */
@ApiModel(description = "The storage associated with the project.")
@JsonPropertyOrder({
        ProjectStorage.JSON_PROPERTY_GUID,
        ProjectStorage.JSON_PROPERTY_PROPERTIES,
        ProjectStorage.JSON_PROPERTY_TYPE
})
public class ProjectStorage {

    public static final String JSON_PROPERTY_GUID = "guid";
    private String guid;

    public static final String JSON_PROPERTY_PROPERTIES = "properties";
    private CloudObjectStorageProperties properties;

    public static final String JSON_PROPERTY_TYPE = "type";
    private StorageType type;

    public ProjectStorage guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * The associated project storage GUID.
     * @return guid
     **/
    @ApiModelProperty(example = "d0e410a0-b358-42fc-b402-dba83316413a",
            required = true,
            value = "The associated project storage GUID.")
    @JsonProperty(JSON_PROPERTY_GUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String
    getGuid() {
        return guid;
    }

    public void setGuid(String guid) { this.guid = guid; }

    public ProjectStorage properties(CloudObjectStorageProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get properties
     * @return properties
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_PROPERTIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CloudObjectStorageProperties getProperties() {
        return properties;
    }

    public void setProperties(CloudObjectStorageProperties properties) {
        this.properties = properties;
    }

    public ProjectStorage type(StorageType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public StorageType getType() {
        return type;
    }

    public void setType(StorageType type) { this.type = type; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectStorage projectStorage = (ProjectStorage)o;
        return Objects.equals(this.guid, projectStorage.guid) &&
                Objects.equals(this.properties, projectStorage.properties) &&
                Objects.equals(this.type, projectStorage.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, properties, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectStorage {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    properties: ")
                .append(toIndentedString(properties))
                .append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
