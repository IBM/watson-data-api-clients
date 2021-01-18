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
 * CreateUserSuccessResponse
 */
public class CreateUserSuccessResponse extends BaseResponse {

    private CreateUserSuccessResponseAllOf1User user;

    public CreateUserSuccessResponse user(CreateUserSuccessResponseAllOf1User user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @javax.annotation.Nullable
    @JsonProperty("User")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CreateUserSuccessResponseAllOf1User getUser() { return user; }
    public void setUser(CreateUserSuccessResponseAllOf1User user) { this.user = user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateUserSuccessResponse createUserSuccessResponse = (CreateUserSuccessResponse)o;
        return super.equals(o) &&
                Objects.equals(this.user, createUserSuccessResponse.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateUserSuccessResponse {\n");
        super.toString(sb);
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
