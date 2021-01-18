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
 * GetPermissionsResponse
 */
public class GetPermissionsResponse {

    private String messageCode;
    private String message;
    private List<String> permissions = null;

    public GetPermissionsResponse messageCode(String messageCode) {
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

    public GetPermissionsResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The explanation of the &#x60;messageCode&#x60;.
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public GetPermissionsResponse permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public GetPermissionsResponse addPermissionsItem(String permissionsItem) {
        if (this.permissions == null) {
            this.permissions = new ArrayList<>();
        }
        this.permissions.add(permissionsItem);
        return this;
    }

    /**
     * The array of permissions.
     * @return permissions
     **/
    @javax.annotation.Nullable
    @JsonProperty("Permissions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getPermissions() { return permissions; }
    public void setPermissions(List<String> permissions) { this.permissions = permissions; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetPermissionsResponse getPermissionsResponse = (GetPermissionsResponse)o;
        return Objects.equals(this.messageCode, getPermissionsResponse.messageCode) &&
                Objects.equals(this.message, getPermissionsResponse.message) &&
                Objects.equals(this.permissions, getPermissionsResponse.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, message, permissions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetPermissionsResponse {\n");
        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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
