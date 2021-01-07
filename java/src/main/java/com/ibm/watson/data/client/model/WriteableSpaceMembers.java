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
 * A list of space members to create / update.
 */
public class WriteableSpaceMembers {

    private List<SpaceMember> members = new ArrayList<>();

    public WriteableSpaceMembers members(List<SpaceMember> members) {
        this.members = members;
        return this;
    }

    public WriteableSpaceMembers addMembersItem(SpaceMember membersItem) {
        this.members.add(membersItem);
        return this;
    }

    /**
     * A list of space members.
     * @return resources
     **/
    @JsonProperty("members")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<SpaceMember> getMembers() { return members; }
    public void setMembers(List<SpaceMember> members) { this.members = members; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WriteableSpaceMembers that = (WriteableSpaceMembers) o;
        return super.equals(o) &&
                Objects.equals(this.members, that.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), members);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WriteableSpaceMembers {\n");
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
