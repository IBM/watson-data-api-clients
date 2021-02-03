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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.UserType;

/**
 * New collaborator data representing user with assigned role. It will be created in the context of specific category.
 */
public class NewRoleAssignment {

    private String role;
    private String principalId;
    private UserType userType;

    public NewRoleAssignment role(String role) {
        this.role = role;
        return this;
    }

    /**
     * Role to be assigned
     * @return role
     **/
    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public NewRoleAssignment principalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    /**
     * Id of the user to be assigned to given role
     * @return principalId
     **/
    @JsonProperty("principal_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getPrincipalId() { return principalId; }
    public void setPrincipalId(String principalId) { this.principalId = principalId; }

    public NewRoleAssignment userType(UserType userType) {
        this.userType = userType;
        return this;
    }

    /**
     * Type of the user. When not provided defaults to USER
     * @return userType
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NewRoleAssignment that = (NewRoleAssignment) o;
        return Objects.equals(this.role, that.role) &&
                Objects.equals(this.principalId, that.principalId) &&
                Objects.equals(this.userType, that.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, principalId, userType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewRoleAssignment {\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    principalId: ").append(toIndentedString(principalId)).append("\n");
        sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
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
