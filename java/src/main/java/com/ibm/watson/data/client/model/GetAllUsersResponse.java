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
 * GetAllUsersResponse
 */
public class GetAllUsersResponse extends BaseResponse {

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
    @JsonProperty("UsersInfo")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<UserInfo> getUsersInfo() { return usersInfo; }
    public void setUsersInfo(List<UserInfo> usersInfo) { this.usersInfo = usersInfo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetAllUsersResponse getAllUsersResponse = (GetAllUsersResponse)o;
        return super.equals(o) &&
                Objects.equals(this.usersInfo, getAllUsersResponse.usersInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), usersInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAllUsersResponse {\n");
        super.toString(sb);
        sb.append("    usersInfo: ").append(toIndentedString(usersInfo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
