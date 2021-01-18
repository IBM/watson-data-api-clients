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
 * CreateUserParamsBody
 */
public class CreateUserParamsBody {

    private String displayName;
    private String email;
    private String userName;
    private List<String> userRoles = new ArrayList<>();

    public CreateUserParamsBody displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name that is displayed for this user.
     * @return displayName
     **/
    @JsonProperty("displayName")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public CreateUserParamsBody email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The user's email address.
     * @return email
     **/
    @JsonProperty("email")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public CreateUserParamsBody userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * The user name.
     * @return userName
     **/
    @JsonProperty("user_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public CreateUserParamsBody userRoles(List<String> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public CreateUserParamsBody addUserRolesItem(String userRolesItem) {
        this.userRoles.add(userRolesItem);
        return this;
    }

    /**
     * The roles assigned to the user.
     * @return userRoles
     **/
    @JsonProperty("user_roles")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getUserRoles() { return userRoles; }
    public void setUserRoles(List<String> userRoles) { this.userRoles = userRoles; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateUserParamsBody createUserParamsBody = (CreateUserParamsBody)o;
        return Objects.equals(this.displayName, createUserParamsBody.displayName) &&
                Objects.equals(this.email, createUserParamsBody.email) &&
                Objects.equals(this.userName, createUserParamsBody.userName) &&
                Objects.equals(this.userRoles, createUserParamsBody.userRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, email, userName, userRoles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateUserParamsBody {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
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
