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
 * Headline member information for referential purposes
 */
public class MemberHeader {

    private String userId;
    private String userIamId;

    @Deprecated
    public MemberHeader userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * (Deprecated) User id like user email address of the member.
     * @return userId
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Deprecated
    public String getUserId() { return userId; }
    @Deprecated
    public void setUserId(String userId) { this.userId = userId; }

    public MemberHeader userIamId(String userIamId) {
        this.userIamId = userIamId;
        return this;
    }

    /**
     * Identity and Access Management ID (IAM) of the member
     * @return userIamId
     **/
    @JsonProperty("user_iam_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getUserIamId() { return userIamId; }
    public void setUserIamId(String userIamId) { this.userIamId = userIamId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MemberHeader that = (MemberHeader)o;
        return Objects.equals(this.userId, that.userId) &&
                Objects.equals(this.userIamId, that.userIamId);
    }

    @Override
    public int hashCode() { return Objects.hash(userId, userIamId); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MemberHeader {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    userIamId: ").append(toIndentedString(userIamId)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
