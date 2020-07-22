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
 * Member
 */
@JsonPropertyOrder({
        Member.JSON_PROPERTY_USER_ID,
        Member.JSON_PROPERTY_USER_IAM_ID,
        Member.JSON_PROPERTY_ACCESS_GROUP_ID,
        Member.JSON_PROPERTY_ROLE,
        Member.JSON_PROPERTY_HREF,
        Member.JSON_PROPERTY_CREATE_TIME
})
public class Member {

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    private String userId;

    public static final String JSON_PROPERTY_USER_IAM_ID = "user_iam_id";
    private String userIamId;

    public static final String JSON_PROPERTY_ACCESS_GROUP_ID = "access_group_id";
    private String accessGroupId;

    public static final String JSON_PROPERTY_ROLE = "role";
    private String role;

    public static final String JSON_PROPERTY_HREF = "href";
    private String href;

    public static final String JSON_PROPERTY_CREATE_TIME = "create_time";
    private String createTime;

    @Deprecated
    public Member userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * (Deprecated) User id like user email address of the member.
     * @return userId
     **/
    @ApiModelProperty(
            example = "xyz@ibm.com", required = true,
            value = "(Deprecated) User id like user email address of the member.")
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    @Deprecated
    public String getUserId() {
        return userId;
    }

    @Deprecated
    public void setUserId(String userId) { this.userId = userId; }

    public Member userIamId(String userIamId) {
        this.userIamId = userIamId;
        return this;
    }

    /**
     * Identity and Access Management ID (IAM) of the member
     * @return userIamId
     **/
    @ApiModelProperty(
            example = "IBMid-abcd1234", required = true,
            value = "Identity and Access Management ID (IAM) of the member")
    @JsonProperty(JSON_PROPERTY_USER_IAM_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUserIamId() {
        return userIamId;
    }

    public void setUserIamId(String userIamId) { this.userIamId = userIamId; }

    public Member accessGroupId(String accessGroupId) {
        this.accessGroupId = accessGroupId;
        return this;
    }

    /**
     * ID of the access group member
     * @return accessGroupId
     **/
    @ApiModelProperty(example = "AccessGroupId-abcd1234", required = true,
            value = "ID of the access group member")
    @JsonProperty(JSON_PROPERTY_ACCESS_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getAccessGroupId() {
        return accessGroupId;
    }

    public void setAccessGroupId(String accessGroupId) {
        this.accessGroupId = accessGroupId;
    }

    public Member role(String role) {
        this.role = role;
        return this;
    }

    /**
     * Role of the member in the Catalog
     * @return role
     **/
    @ApiModelProperty(example = "admin", required = true,
            value = "Role of the member in the Catalog")
    @JsonProperty(JSON_PROPERTY_ROLE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getRole() {
        return role;
    }

    public void setRole(String role) { this.role = role; }

    public Member href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get href
     * @return href
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_HREF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHref() {
        return href;
    }

    public void setHref(String href) { this.href = href; }

    public Member createTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * Read only - The date and time when the member is added to the catalog
     * @return createTime
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            value = "Read only - The date and time when the member is added to the catalog")
    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) { this.createTime = createTime; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member)o;
        return Objects.equals(this.userId, member.userId) &&
                Objects.equals(this.userIamId, member.userIamId) &&
                Objects.equals(this.accessGroupId, member.accessGroupId) &&
                Objects.equals(this.role, member.role) &&
                Objects.equals(this.href, member.href) &&
                Objects.equals(this.createTime, member.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userIamId, accessGroupId, role, href,
                createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Member {\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    userIamId: ")
                .append(toIndentedString(userIamId))
                .append("\n");
        sb.append("    accessGroupId: ")
                .append(toIndentedString(accessGroupId))
                .append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    createTime: ")
                .append(toIndentedString(createTime))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
