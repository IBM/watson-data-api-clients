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
 * LoginCredentials
 */
public class LoginCredentials {

    private String password;
    private String username;

    public LoginCredentials password(String password) {
        this.password = password;
        return this;
    }

    /**
     * IBM Cloud Pak for Data password.
     * @return password
     **/
    @JsonProperty("password")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LoginCredentials username(String username) {
        this.username = username;
        return this;
    }

    /**
     * IBM Cloud Pak for Data user name.
     * @return username
     **/
    @JsonProperty("username")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        LoginCredentials loginCredentials = (LoginCredentials)o;
        return Objects.equals(this.password, loginCredentials.password) &&
                Objects.equals(this.username, loginCredentials.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoginCredentials {\n");
        sb.append("    password: <redacted>\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
