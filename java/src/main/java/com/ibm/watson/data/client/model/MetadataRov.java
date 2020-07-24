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
 * Metadata rules of visibility information about an asset
 */
public class MetadataRov {

    private Integer mode;
    // TODO: revisit, this is probably another bean to create rather than a generic Object
    private Object collaboratorIds;

    public MetadataRov mode(Integer mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Access mode of metadata asset
     * @return mode
     **/
    @JsonProperty("mode")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getMode() { return mode; }
    public void setMode(Integer mode) { this.mode = mode; }

    public Object collaboratorIds(Object collaboratorIds) {
        this.collaboratorIds = collaboratorIds;
        return this;
    }

    /**
     * List of collaborators that can access metadata asset
     * @return collaboratorIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("collaborator_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getCollaboratorIds() { return collaboratorIds; }
    public void setCollaboratorIds(Object collaboratorIds) { this.collaboratorIds = collaboratorIds; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataRov metadataUsage = (MetadataRov)o;
        return Objects.equals(this.mode, metadataUsage.mode) &&
                Objects.equals(this.collaboratorIds, metadataUsage.collaboratorIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, collaboratorIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataRov {\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    collaboratorIds: ").append(toIndentedString(collaboratorIds)).append("\n");
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
