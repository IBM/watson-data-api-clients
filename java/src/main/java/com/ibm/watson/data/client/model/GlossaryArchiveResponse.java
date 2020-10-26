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
 * GlossaryArchiveResponse
 */
public class GlossaryArchiveResponse {

    private List<String> archivedGuids = null;
    private List<String> updatedGuids = null;
    private List<String> deleteGuids = null;

    public GlossaryArchiveResponse archivedGuids(List<String> archivedGuids) {
        this.archivedGuids = archivedGuids;
        return this;
    }

    public GlossaryArchiveResponse addArchivedGuidsItem(String archivedGuidsItem) {
        if (this.archivedGuids == null) {
            this.archivedGuids = new ArrayList<>();
        }
        this.archivedGuids.add(archivedGuidsItem);
        return this;
    }

    /**
     * Guids of the archived objects.
     * @return archivedGuids
     **/
    @javax.annotation.Nullable
    @JsonProperty("archived_guids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getArchivedGuids() { return archivedGuids; }
    public void setArchivedGuids(List<String> archivedGuids) { this.archivedGuids = archivedGuids; }

    public GlossaryArchiveResponse updatedGuids(List<String> updatedGuids) {
        this.updatedGuids = updatedGuids;
        return this;
    }

    public GlossaryArchiveResponse addUpdatedGuidsItem(String updatedGuidsItem) {
        if (this.updatedGuids == null) {
            this.updatedGuids = new ArrayList<>();
        }
        this.updatedGuids.add(updatedGuidsItem);
        return this;
    }

    /**
     * Guids of the updated objects.
     * @return updatedGuids
     **/
    @javax.annotation.Nullable
    @JsonProperty("updated_guids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getUpdatedGuids() { return updatedGuids; }
    public void setUpdatedGuids(List<String> updatedGuids) { this.updatedGuids = updatedGuids; }

    public GlossaryArchiveResponse deleteGuids(List<String> deleteGuids) {
        this.deleteGuids = deleteGuids;
        return this;
    }

    public GlossaryArchiveResponse addDeleteGuidsItem(String deleteGuidsItem) {
        if (this.deleteGuids == null) {
            this.deleteGuids = new ArrayList<>();
        }
        this.deleteGuids.add(deleteGuidsItem);
        return this;
    }

    /**
     * Guids of the deleted objects.
     * @return deleteGuids
     **/
    @javax.annotation.Nullable
    @JsonProperty("delete_guids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getDeleteGuids() { return deleteGuids; }
    public void setDeleteGuids(List<String> deleteGuids) { this.deleteGuids = deleteGuids; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GlossaryArchiveResponse glossaryArchiveResponse = (GlossaryArchiveResponse)o;
        return Objects.equals(this.archivedGuids, glossaryArchiveResponse.archivedGuids) &&
                Objects.equals(this.updatedGuids, glossaryArchiveResponse.updatedGuids) &&
                Objects.equals(this.deleteGuids, glossaryArchiveResponse.deleteGuids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivedGuids, updatedGuids, deleteGuids);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GlossaryArchiveResponse {\n");
        sb.append("    archivedGuids: ").append(toIndentedString(archivedGuids)).append("\n");
        sb.append("    updatedGuids: ").append(toIndentedString(updatedGuids)).append("\n");
        sb.append("    deleteGuids: ").append(toIndentedString(deleteGuids)).append("\n");
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
