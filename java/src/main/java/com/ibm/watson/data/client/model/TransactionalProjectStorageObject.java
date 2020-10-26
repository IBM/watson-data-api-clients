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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * Object storage properties to be associated with the project.
 */
@ApiModel(description = "Object storage properties to be associated with the project.")
@JsonPropertyOrder({
        TransactionalProjectStorageObject.JSON_PROPERTY_DELEGATED,
        TransactionalProjectStorageObject.JSON_PROPERTY_GUID,
        TransactionalProjectStorageObject.JSON_PROPERTY_RESOURCE_CRN,
        TransactionalProjectStorageObject.JSON_PROPERTY_TYPE
})
public class TransactionalProjectStorageObject {

    public static final String JSON_PROPERTY_DELEGATED = "delegated";
    private Boolean delegated = false;

    public static final String JSON_PROPERTY_GUID = "guid";
    private String guid;

    public static final String JSON_PROPERTY_RESOURCE_CRN = "resource_crn";
    private String resourceCrn;

    /**
     * The type of the associated project storage.
     */
    public enum TypeEnum {
        BMCOS_OBJECT_STORAGE("bmcos_object_storage"),

        ASSETFILES("assetfiles");

        private String value;

        TypeEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type = TypeEnum.BMCOS_OBJECT_STORAGE;

    public TransactionalProjectStorageObject delegated(Boolean delegated) {
        this.delegated = delegated;
        return this;
    }

    /**
     * Set to true of the COS instance is delegated by the account admin
     * @return delegated
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Set to true of the COS instance is delegated by the account admin")
    @JsonProperty(JSON_PROPERTY_DELEGATED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDelegated() {
        return delegated;
    }

    public void setDelegated(Boolean delegated) { this.delegated = delegated; }

    public TransactionalProjectStorageObject guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Unique guid of the associated project storage object.
     * @return guid
     **/
    @ApiModelProperty(
            example = "d0e410a0-b358-42fc-b402-dba83316413a", required = true,
            value = "Unique guid of the associated project storage object.")
    @JsonProperty(JSON_PROPERTY_GUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) { this.guid = guid; }

    public TransactionalProjectStorageObject resourceCrn(String resourceCrn) {
        this.resourceCrn = resourceCrn;
        return this;
    }

    /**
     * A cloud resource name of the Cloud Object Storage instance
     * @return resourceCrn
     **/
    @ApiModelProperty(
            example = "crn:v1:staging:public:cloud-object-storage:global:a/a7026b374f39f570d20984c1ac6ecf63:5778e94f-c8c7-46a8-9878-d5eeadb51161::",
            required = true,
            value = "A cloud resource name of the Cloud Object Storage instance")
    @JsonProperty(JSON_PROPERTY_RESOURCE_CRN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getResourceCrn() {
        return resourceCrn;
    }

    public void setResourceCrn(String resourceCrn) {
        this.resourceCrn = resourceCrn;
    }

    public TransactionalProjectStorageObject type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the associated project storage.
     * @return type
     **/
    @ApiModelProperty(required = true,
            value = "The type of the associated project storage.")
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) { this.type = type; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionalProjectStorageObject transactionalProjectStorageObject =
                (TransactionalProjectStorageObject)o;
        return Objects.equals(this.delegated,
                transactionalProjectStorageObject.delegated) &&
                Objects.equals(this.guid, transactionalProjectStorageObject.guid) &&
                Objects.equals(this.resourceCrn,
                        transactionalProjectStorageObject.resourceCrn) &&
                Objects.equals(this.type, transactionalProjectStorageObject.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delegated, guid, resourceCrn, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionalProjectStorageObject {\n");
        sb.append("    delegated: ")
                .append(toIndentedString(delegated))
                .append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    resourceCrn: ")
                .append(toIndentedString(resourceCrn))
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
