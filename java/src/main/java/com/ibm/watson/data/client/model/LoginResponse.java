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
 * LoginResponse
 */
public class LoginResponse {

    private String messageCode;
    private String message;
    private String token;

    public LoginResponse messageCode(String messageCode) {
        this.messageCode = messageCode;
        return this;
    }

    /**
     * The identifier of the response.
     * @return messageCode
     **/
    @javax.annotation.Nullable
    @JsonProperty("messageCode")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessageCode() { return messageCode; }
    public void setMessageCode(String messageCode) { this.messageCode = messageCode; }

    public LoginResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The explanation of the "messageCode".
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LoginResponse token(String token) {
        this.token = token;
        return this;
    }

    /**
     * The bearer token associated with a user name.
     * @return token
     **/
    @javax.annotation.Nullable
    @JsonProperty("token")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        LoginResponse loginResponse = (LoginResponse)o;
        return Objects.equals(this.messageCode, loginResponse.messageCode) &&
                Objects.equals(this.message, loginResponse.message) &&
                Objects.equals(this.token, loginResponse.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, message, token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoginResponse {\n");
        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
