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
 * GetAllRolesResponse
 */
@JsonPropertyOrder({
        GetAllRolesResponse.JSON_PROPERTY_MESSAGE_CODE,
        GetAllRolesResponse.JSON_PROPERTY_MESSAGE,
        GetAllRolesResponse.JSON_PROPERTY_ROLES
})
public class GetAllRolesResponse {

    public static final String JSON_PROPERTY_MESSAGE_CODE = "_messageCode_";
    private String messageCode;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_ROLES = "Roles";
    private List<Role> roles = null;

    public GetAllRolesResponse messageCode(String messageCode) {
        this.messageCode = messageCode;
        return this;
    }

    /**
     * The identifier of the response.
     * @return messageCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The identifier of the response.")
    @JsonProperty(JSON_PROPERTY_MESSAGE_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public GetAllRolesResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The explanation of the &#x60;messageCode&#x60;.
     * @return message
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The explanation of the `messageCode`.")
    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) { this.message = message; }

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
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ROLES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetAllRolesResponse getAllRolesResponse = (GetAllRolesResponse)o;
        return Objects.equals(this.messageCode, getAllRolesResponse.messageCode) &&
                Objects.equals(this.message, getAllRolesResponse.message) &&
                Objects.equals(this.roles, getAllRolesResponse.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, message, roles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAllRolesResponse {\n");
        sb.append("    messageCode: ")
                .append(toIndentedString(messageCode))
                .append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
