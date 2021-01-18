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
 * GetMeResponse
 */
public class GetMeResponse extends BaseResponse {

    private GetMeResponseAllOf1UserInfo userInfo;

    public GetMeResponse userInfo(GetMeResponseAllOf1UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    /**
     * Get userInfo
     * @return userInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("UserInfo")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GetMeResponseAllOf1UserInfo getUserInfo() { return userInfo; }
    public void setUserInfo(GetMeResponseAllOf1UserInfo userInfo) { this.userInfo = userInfo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetMeResponse getMeResponse = (GetMeResponse)o;
        return super.equals(o) &&
                Objects.equals(this.userInfo, getMeResponse.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetMeResponse {\n");
        super.toString(sb);
        sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
