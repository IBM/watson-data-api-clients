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

import java.util.Objects;

/**
 * GetRoleResponse
 */
@JsonPropertyOrder({
        GetRoleResponse.JSON_PROPERTY_MESSAGE_CODE,
        GetRoleResponse.JSON_PROPERTY_MESSAGE,
        GetRoleResponse.JSON_PROPERTY_ROLE_INFO
})
public class GetRoleResponse {

    public static final String JSON_PROPERTY_MESSAGE_CODE = "_messageCode_";
    private String messageCode;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_ROLE_INFO = "RoleInfo";
    private Role roleInfo;

    public GetRoleResponse messageCode(String messageCode) {
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

    public GetRoleResponse message(String message) {
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

    public GetRoleResponse roleInfo(Role roleInfo) {
        this.roleInfo = roleInfo;
        return this;
    }

    /**
     * Get roleInfo
     * @return roleInfo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ROLE_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Role getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(Role roleInfo) {
        this.roleInfo = roleInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetRoleResponse getRoleResponse = (GetRoleResponse)o;
        return Objects.equals(this.messageCode, getRoleResponse.messageCode) &&
                Objects.equals(this.message, getRoleResponse.message) &&
                Objects.equals(this.roleInfo, getRoleResponse.roleInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, message, roleInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRoleResponse {\n");
        sb.append("    messageCode: ")
                .append(toIndentedString(messageCode))
                .append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    roleInfo: ").append(toIndentedString(roleInfo)).append("\n");
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
