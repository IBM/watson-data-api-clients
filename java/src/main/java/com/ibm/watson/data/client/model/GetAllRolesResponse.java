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
 * GetAllRolesResponse
 */
public class GetAllRolesResponse extends BaseResponse {

    private List<Role> roles = null;

    public GetAllRolesResponse roles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public GetAllRolesResponse addRolesItem(Role rolesItem) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * Get roles
     * @return roles
     **/
    @javax.annotation.Nullable
    @JsonProperty("Roles")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetAllRolesResponse getAllRolesResponse = (GetAllRolesResponse)o;
        return super.equals(o) &&
                Objects.equals(this.roles, getAllRolesResponse.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAllRolesResponse {\n");
        super.toString(sb);
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
