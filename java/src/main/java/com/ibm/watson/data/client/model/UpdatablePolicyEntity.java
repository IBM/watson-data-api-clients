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
 * UpdatablePolicyEntity
 */
public class UpdatablePolicyEntity extends NewPolicyEntity {

    private String revision;

    public UpdatablePolicyEntity revision(String revision) {
        this.revision = revision;
        return this;
    }

    /**
     * The revision of the artifact. It is used for optimistic locking.
     * @return revision
     **/
    @JsonProperty("revision")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRevision() { return revision; }
    public void setRevision(String revision) { this.revision = revision; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdatablePolicyEntity updatablePolicyEntity = (UpdatablePolicyEntity)o;
        return super.equals(o) &&
                Objects.equals(this.revision, updatablePolicyEntity.revision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), revision);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdatablePolicyEntity {\n");
        super.toString(sb);
        sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
