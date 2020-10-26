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
 * GetAllUsersResponse
 */
@JsonPropertyOrder({
        BaseResponse.JSON_PROPERTY_MESSAGE_CODE,
        BaseResponse.JSON_PROPERTY_MESSAGE,
        GetAllUsersResponse.JSON_PROPERTY_USERS_INFO
})
public class GetAllUsersResponse extends BaseResponse {

    public static final String JSON_PROPERTY_USERS_INFO = "UsersInfo";
    private List<UserInfo> usersInfo = null;

    public GetAllUsersResponse usersInfo(List<UserInfo> usersInfo) {
        this.usersInfo = usersInfo;
        return this;
    }

    public GetAllUsersResponse addUsersInfoItem(UserInfo usersInfoItem) {
        if (this.usersInfo == null) {
            this.usersInfo = new ArrayList<>();
        }
        this.usersInfo.add(usersInfoItem);
        return this;
    }

    /**
     * Get usersInfo
     * @return usersInfo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_USERS_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<UserInfo> getUsersInfo() {
        return usersInfo;
    }

    public void setUsersInfo(List<UserInfo> usersInfo) {
        this.usersInfo = usersInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetAllUsersResponse getAllUsersResponse = (GetAllUsersResponse)o;
        return super.equals(o) &&
                Objects.equals(this.usersInfo, getAllUsersResponse.usersInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessageCode(), getMessage(), usersInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAllUsersResponse {\n");
        sb.append("    messageCode: ")
                .append(toIndentedString(getMessageCode()))
                .append("\n");
        sb.append("    message: ").append(toIndentedString(getMessage())).append("\n");
        sb.append("    usersInfo: ")
                .append(toIndentedString(usersInfo))
                .append("\n");
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
