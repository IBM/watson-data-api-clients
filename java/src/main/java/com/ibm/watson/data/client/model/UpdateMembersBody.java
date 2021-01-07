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
 * The request body for updating project members.
 */
public class UpdateMembersBody {

    private List<UpdateMemberBody> members = new ArrayList<>();

    public UpdateMembersBody members(List<UpdateMemberBody> members) {
        this.members = members;
        return this;
    }

    public UpdateMembersBody addMembersItem(UpdateMemberBody membersItem) {
        this.members.add(membersItem);
        return this;
    }

    /**
     * A list of project members to update.
     * @return members
     **/
    @JsonProperty("members")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<UpdateMemberBody> getMembers() { return members; }
    public void setMembers(List<UpdateMemberBody> members) { this.members = members; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateMembersBody updateMembersBody = (UpdateMembersBody)o;
        return Objects.equals(this.members, updateMembersBody.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateMembersBody {\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
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
