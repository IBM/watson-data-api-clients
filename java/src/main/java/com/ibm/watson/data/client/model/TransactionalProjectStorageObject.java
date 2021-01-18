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
import com.ibm.watson.data.client.model.enums.StorageType;

import java.util.Objects;

/**
 * Object storage properties to be associated with the project.
 */
public class TransactionalProjectStorageObject {

    private Boolean delegated = false;
    private String guid;
    private String resourceCrn;
    private StorageType type = StorageType.BMCOS_OBJECT_STORAGE;

    public TransactionalProjectStorageObject delegated(Boolean delegated) {
        this.delegated = delegated;
        return this;
    }

    /**
     * Set to true of the COS instance is delegated by the account admin
     * @return delegated
     **/
    @javax.annotation.Nullable
    @JsonProperty("delegated")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDelegated() { return delegated; }
    public void setDelegated(Boolean delegated) { this.delegated = delegated; }

    public TransactionalProjectStorageObject guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Unique guid of the associated project storage object.
     * @return guid
     **/
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public TransactionalProjectStorageObject resourceCrn(String resourceCrn) {
        this.resourceCrn = resourceCrn;
        return this;
    }

    /**
     * A cloud resource name of the Cloud Object Storage instance
     * @return resourceCrn
     **/
    @JsonProperty("crn")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getResourceCrn() { return resourceCrn; }
    public void setResourceCrn(String resourceCrn) { this.resourceCrn = resourceCrn; }

    public TransactionalProjectStorageObject type(StorageType type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the associated project storage.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public StorageType getType() { return type; }
    public void setType(StorageType type) { this.type = type; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransactionalProjectStorageObject transactionalProjectStorageObject = (TransactionalProjectStorageObject)o;
        return Objects.equals(this.delegated, transactionalProjectStorageObject.delegated) &&
                Objects.equals(this.guid, transactionalProjectStorageObject.guid) &&
                Objects.equals(this.resourceCrn, transactionalProjectStorageObject.resourceCrn) &&
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
        sb.append("    delegated: ").append(toIndentedString(delegated)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    resourceCrn: ").append(toIndentedString(resourceCrn)).append("\n");
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
