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
 * Project metadata required to create a project.
 */
public class TransactionalProjectCreate extends ProjectHeader {

    private List<TransactionalProjectComputeObjectCloud> compute = null;
    private Boolean enforceMembers = false;
    private String generator;
    private TransactionalProjectStorageObject storage;

    public TransactionalProjectCreate compute(List<TransactionalProjectComputeObjectCloud> compute) {
        this.compute = compute;
        return this;
    }

    public TransactionalProjectCreate addComputeItem(TransactionalProjectComputeObjectCloud computeItem) {
        if (this.compute == null) {
            this.compute = new ArrayList<>();
        }
        this.compute.add(computeItem);
        return this;
    }

    /**
     * List of computes to be associated with the project.
     * @return compute
     **/
    @javax.annotation.Nullable
    @JsonProperty("compute")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TransactionalProjectComputeObjectCloud> getCompute() { return compute; }
    public void setCompute(List<TransactionalProjectComputeObjectCloud> compute) { this.compute = compute; }

    public TransactionalProjectCreate enforceMembers(Boolean enforceMembers) {
        this.enforceMembers = enforceMembers;
        return this;
    }

    /**
     * Set to true if project members should be scoped to the account and/or SAML
     * of the creator
     * @return enforceMembers
     **/
    @javax.annotation.Nullable
    @JsonProperty("enforce_members")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getEnforceMembers() { return enforceMembers; }
    public void setEnforceMembers(Boolean enforceMembers) { this.enforceMembers = enforceMembers; }

    public TransactionalProjectCreate generator(String generator) {
        this.generator = generator;
        return this;
    }

    /**
     * A tag to indicate where this project was generated. This is only intended
     * for use in metrics. It does not need to be unique and all consumers of this
     * API should use a consistent string for their "generator" field. The
     * value is stored in the project metadata for future consumption in metrics.
     * @return generator
     **/
    @JsonProperty("generator")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGenerator() { return generator; }
    public void setGenerator(String generator) { this.generator = generator; }

    public TransactionalProjectCreate storage(TransactionalProjectStorageObject storage) {
        this.storage = storage;
        return this;
    }

    /**
     * Get storage
     * @return storage
     **/
    @javax.annotation.Nullable
    @JsonProperty("storage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public TransactionalProjectStorageObject getStorage() { return storage; }
    public void setStorage(TransactionalProjectStorageObject storage) { this.storage = storage; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransactionalProjectCreate transactionalProjectCreate = (TransactionalProjectCreate)o;
        return super.equals(o) &&
                Objects.equals(this.compute, transactionalProjectCreate.compute) &&
                Objects.equals(this.enforceMembers, transactionalProjectCreate.enforceMembers) &&
                Objects.equals(this.generator, transactionalProjectCreate.generator) &&
                Objects.equals(this.storage, transactionalProjectCreate.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), compute, enforceMembers, generator, storage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionalProjectCreate {\n");
        super.toString(sb);
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    enforceMembers: ").append(toIndentedString(enforceMembers)).append("\n");
        sb.append("    generator: ").append(toIndentedString(generator)).append("\n");
        sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
