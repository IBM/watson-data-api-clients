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

import java.util.List;
import java.util.Objects;

/**
 * ExtendedGroupInfo
 */
public class ExtendedGroupInfo extends GroupInfo {

    private List<RoleInfo> roles;
    private List<UserInfo> members;

    public ExtendedGroupInfo roles(List<RoleInfo> roles) {
        this.roles = roles;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("roles")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RoleInfo> getRoles() { return roles; }
    public void setRoles(List<RoleInfo> roles) { this.roles = roles; }

    public ExtendedGroupInfo members(List<UserInfo> members) {
        this.members = members;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("members")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<UserInfo> getMembers() { return members; }
    public void setMembers(List<UserInfo> members) { this.members = members; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExtendedGroupInfo that = (ExtendedGroupInfo)o;
        return super.equals(o) &&
                Objects.equals(this.roles, that.roles) &&
                Objects.equals(this.members, that.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roles, members);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExtendedGroupInfo {\n");
        super.toString(sb);
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
