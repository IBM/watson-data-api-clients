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
 * GetRoleResponse
 */
public class GetRoleResponse extends BaseResponse {

    private Role roleInfo;

    public GetRoleResponse roleInfo(Role roleInfo) {
        this.roleInfo = roleInfo;
        return this;
    }

    /**
     * Get roleInfo
     * @return roleInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("RoleInfo")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Role getRoleInfo() { return roleInfo; }
    public void setRoleInfo(Role roleInfo) { this.roleInfo = roleInfo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetRoleResponse getRoleResponse = (GetRoleResponse)o;
        return super.equals(o) &&
                Objects.equals(this.roleInfo, getRoleResponse.roleInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRoleResponse {\n");
        super.toString(sb);
        sb.append("    roleInfo: ").append(toIndentedString(roleInfo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
