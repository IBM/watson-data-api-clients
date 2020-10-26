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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GetAllRolesResponseAllOf1RolesItems
 */
@JsonPropertyOrder({
        Role.JSON_PROPERTY_I_D,
        Role.JSON_PROPERTY_DESCRIPTION,
        Role.JSON_PROPERTY_PERMISSIONS,
        Role.JSON_PROPERTY_ROLE_NAME
})
public class Role {

    public static final String JSON_PROPERTY_I_D = "ID";
    private String ID;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
    private List<String> permissions = null;

    public static final String JSON_PROPERTY_ROLE_NAME = "role_name";
    private String roleName;

    public Role ID(String ID) {
        this.ID = ID;
        return this;
    }

    /**
     * The unique identifier of the role.
     * @return ID
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Administrator",
            value = "The unique identifier of the role.")
    @JsonProperty(JSON_PROPERTY_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getID() {
        return ID;
    }

    public void setID(String ID) { this.ID = ID; }

    public Role description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the role.
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Administrator role",
            value = "Description of the role.")
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public Role addPermissionsItem(String permissionsItem) {
        if (this.permissions == null) {
            this.permissions = new ArrayList<>();
        }
        this.permissions.add(permissionsItem);
        return this;
    }

    /**
     * The permissions associated with the role.
     * @return permissions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The permissions associated with the role.")
    @JsonProperty(JSON_PROPERTY_PERMISSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Role roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    /**
     * Name for the role.
     * @return roleName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Administrator", value = "Name for the role.")
    @JsonProperty(JSON_PROPERTY_ROLE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) { this.roleName = roleName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role getAllRolesResponseAllOf1RolesItems =
                (Role)o;
        return Objects.equals(this.ID, getAllRolesResponseAllOf1RolesItems.ID) &&
                Objects.equals(this.description,
                        getAllRolesResponseAllOf1RolesItems.description) &&
                Objects.equals(this.permissions,
                        getAllRolesResponseAllOf1RolesItems.permissions) &&
                Objects.equals(this.roleName,
                        getAllRolesResponseAllOf1RolesItems.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, description, permissions, roleName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAllRolesResponseAllOf1RolesItems {\n");
        sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
        sb.append("    description: ")
                .append(toIndentedString(description))
                .append("\n");
        sb.append("    permissions: ")
                .append(toIndentedString(permissions))
                .append("\n");
        sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
