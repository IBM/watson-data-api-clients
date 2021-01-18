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
 * CreateUserSuccessResponseAllOf1User
 */
public class CreateUserSuccessResponseAllOf1User {

    private String ID;
    private String password;

    public CreateUserSuccessResponseAllOf1User ID(String ID) {
        this.ID = ID;
        return this;
    }

    /**
     * The user name.
     * @return ID
     **/
    @javax.annotation.Nullable
    @JsonProperty("ID")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public CreateUserSuccessResponseAllOf1User password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Auto generated password for the new user
     * @return password
     **/
    @javax.annotation.Nullable
    @JsonProperty("password")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateUserSuccessResponseAllOf1User createUserSuccessResponseAllOf1User = (CreateUserSuccessResponseAllOf1User)o;
        return Objects.equals(this.ID, createUserSuccessResponseAllOf1User.ID) &&
                Objects.equals(this.password, createUserSuccessResponseAllOf1User.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateUserSuccessResponseAllOf1User {\n");
        sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
        sb.append("    password: <redacted>\n");
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
