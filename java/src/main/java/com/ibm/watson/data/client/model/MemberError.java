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
 * Member Error
 */
public class MemberError {

    private String userIamId;
    private String accessGroupId;
    private ErrorModel reason = new ErrorModel();

    public MemberError userIamId(String userIamId) {
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

    public MemberError accessGroupId(String accessGroupId) {
        this.accessGroupId = accessGroupId;
        return this;
    }

    /**
     * ID of the access group member
     * @return accessGroupId
     **/
    @JsonProperty("access_group_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAccessGroupId() { return accessGroupId; }
    public void setAccessGroupId(String accessGroupId) { this.accessGroupId = accessGroupId; }

    public MemberError reason(ErrorModel reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     * @return reason
     **/
    @javax.annotation.Nullable
    @JsonProperty("reason")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ErrorModel getReason() { return reason; }
    public void setReason(ErrorModel reason) { this.reason = reason; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MemberError memberError = (MemberError)o;
        return Objects.equals(this.userIamId, memberError.userIamId) &&
                Objects.equals(this.accessGroupId, memberError.accessGroupId) &&
                Objects.equals(this.reason, memberError.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIamId, accessGroupId, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MemberError {\n");
        sb.append("    userIamId: ").append(toIndentedString(userIamId)).append("\n");
        sb.append("    accessGroupId: ").append(toIndentedString(accessGroupId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
