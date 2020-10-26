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

import java.util.Map;
import java.util.Objects;

/**
 * Metadata rules of visibility information about an asset
 */
public class MetadataRov extends BaseRov {

    private Map<String, MemberHeader> collaboratorIds;

    /**
     * List of collaborators that can access metadata asset
     * @return collaboratorIds
     **/
    @javax.annotation.Nullable
    @JsonProperty("collaborator_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, MemberHeader> getCollaboratorIds() { return collaboratorIds; }
    public void setCollaboratorIds(Map<String, MemberHeader> collaboratorIds) { this.collaboratorIds = collaboratorIds; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataRov metadataUsage = (MetadataRov)o;
        return super.equals(o) &&
                Objects.equals(this.collaboratorIds, metadataUsage.collaboratorIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collaboratorIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataRov {\n");
        super.toString(sb);
        sb.append("    collaboratorIds: ").append(toIndentedString(collaboratorIds)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
