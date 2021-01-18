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
 * UpdateMeParamsBody
 */
public class UpdateMeParamsBody {

    private String displayName;
    private String email;

    public UpdateMeParamsBody displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name that is displayed for this user.
     * @return displayName
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public UpdateMeParamsBody email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The user's email address.
     * @return email
     **/
    @javax.annotation.Nullable
    @JsonProperty("email")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateMeParamsBody updateMeParamsBody = (UpdateMeParamsBody)o;
        return Objects.equals(this.displayName, updateMeParamsBody.displayName) &&
                Objects.equals(this.email, updateMeParamsBody.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, email);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateMeParamsBody {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
