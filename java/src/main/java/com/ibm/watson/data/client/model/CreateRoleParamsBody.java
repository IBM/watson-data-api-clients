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
 * CreateRoleParamsBody
 */
public class CreateRoleParamsBody {

    private String description;
    private List<String> permissions = new ArrayList<>();
    private String roleName;

    public CreateRoleParamsBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the role.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public CreateRoleParamsBody permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public CreateRoleParamsBody addPermissionsItem(String permissionsItem) {
        this.permissions.add(permissionsItem);
        return this;
    }

    /**
     * The permissions associated with the role.
     * @return permissions
     **/
    @JsonProperty("permissions")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getPermissions() { return permissions; }
    public void setPermissions(List<String> permissions) { this.permissions = permissions; }

    public CreateRoleParamsBody roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    /**
     * Name for the role.
     * @return roleName
     **/
    @JsonProperty("role_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateRoleParamsBody createRoleParamsBody = (CreateRoleParamsBody)o;
        return Objects.equals(this.description, createRoleParamsBody.description) &&
                Objects.equals(this.permissions, createRoleParamsBody.permissions) &&
                Objects.equals(this.roleName, createRoleParamsBody.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, permissions, roleName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateRoleParamsBody {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
        sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
