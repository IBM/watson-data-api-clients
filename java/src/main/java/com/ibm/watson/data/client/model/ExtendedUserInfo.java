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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * GetUserResponseAllOf1UserInfo
 */
@JsonPropertyOrder({
        UserInfo.JSON_PROPERTY_APPROVAL_STATUS,
        UserInfo.JSON_PROPERTY_AUTHENTICATOR,
        UserInfo.JSON_PROPERTY_CREATED_TIMESTAMP,
        UserInfo.JSON_PROPERTY_CURRENT_ACCOUNT_STATUS,
        UserInfo.JSON_PROPERTY_DISPLAY_NAME,
        UserInfo.JSON_PROPERTY_EMAIL,
        ExtendedUserInfo.JSON_PROPERTY_FIRST_FAILED_ATTEMPT_TIMESTAMP,
        UserInfo.JSON_PROPERTY_LAST_MODIFIED_TIMESTAMP,
        UserInfo.JSON_PROPERTY_PERMISSIONS,
        ExtendedUserInfo.JSON_PROPERTY_RECENT_NUMBER_OF_FAILED_ATTEMPTS,
        ExtendedUserInfo.JSON_PROPERTY_RELEASE_LOCK_AT_TIMESTAMP,
        UserInfo.JSON_PROPERTY_ROLE,
        UserInfo.JSON_PROPERTY_UID,
        UserInfo.JSON_PROPERTY_USER_ROLES,
        UserInfo.JSON_PROPERTY_USERNAME
})
public class ExtendedUserInfo extends UserInfo {

    public static final String JSON_PROPERTY_FIRST_FAILED_ATTEMPT_TIMESTAMP = "first_failed_attempt_timestamp";
    private String firstFailedAttemptTimestamp;

    public static final String JSON_PROPERTY_RECENT_NUMBER_OF_FAILED_ATTEMPTS = "recent_number_of_failed_attempts";
    private BigDecimal recentNumberOfFailedAttempts;

    public static final String JSON_PROPERTY_RELEASE_LOCK_AT_TIMESTAMP = "release_lock_at_timestamp";
    private String releaseLockAtTimestamp;

    public ExtendedUserInfo firstFailedAttemptTimestamp(String firstFailedAttemptTimestamp) {
        this.firstFailedAttemptTimestamp = firstFailedAttemptTimestamp;
        return this;
    }

    /**
     * The date and time of the first failed attempt to log in.
     * @return firstFailedAttemptTimestamp
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "2018-10-08T21:53:14.855Z",
            value = "The date and time of the first failed attempt to log in.")
    @JsonProperty(JSON_PROPERTY_FIRST_FAILED_ATTEMPT_TIMESTAMP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFirstFailedAttemptTimestamp() {
        return firstFailedAttemptTimestamp;
    }

    public void setFirstFailedAttemptTimestamp(String firstFailedAttemptTimestamp) {
        this.firstFailedAttemptTimestamp = firstFailedAttemptTimestamp;
    }

    public ExtendedUserInfo recentNumberOfFailedAttempts(BigDecimal recentNumberOfFailedAttempts) {
        this.recentNumberOfFailedAttempts = recentNumberOfFailedAttempts;
        return this;
    }

    /**
     * The number of recent failed attempts to log in.
     * @return recentNumberOfFailedAttempts
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "0",
            value = "The number of recent failed attempts to log in.")
    @JsonProperty(JSON_PROPERTY_RECENT_NUMBER_OF_FAILED_ATTEMPTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getRecentNumberOfFailedAttempts() {
        return recentNumberOfFailedAttempts;
    }

    public void setRecentNumberOfFailedAttempts(BigDecimal recentNumberOfFailedAttempts) {
        this.recentNumberOfFailedAttempts = recentNumberOfFailedAttempts;
    }

    public ExtendedUserInfo releaseLockAtTimestamp(String releaseLockAtTimestamp) {
        this.releaseLockAtTimestamp = releaseLockAtTimestamp;
        return this;
    }

    /**
     * The date and time of the release lock.
     * @return releaseLockAtTimestamp
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2018-10-08T21:53:14.855Z",
            value = "The date and time of the release lock.")
    @JsonProperty(JSON_PROPERTY_RELEASE_LOCK_AT_TIMESTAMP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getReleaseLockAtTimestamp() {
        return releaseLockAtTimestamp;
    }

    public void setReleaseLockAtTimestamp(String releaseLockAtTimestamp) {
        this.releaseLockAtTimestamp = releaseLockAtTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExtendedUserInfo getUserResponseAllOf1UserInfo =
                (ExtendedUserInfo)o;
        return super.equals(o) &&
                Objects.equals(
                        this.firstFailedAttemptTimestamp,
                        getUserResponseAllOf1UserInfo.firstFailedAttemptTimestamp) &&
                Objects.equals(
                        this.recentNumberOfFailedAttempts,
                        getUserResponseAllOf1UserInfo.recentNumberOfFailedAttempts) &&
                Objects.equals(this.releaseLockAtTimestamp,
                        getUserResponseAllOf1UserInfo.releaseLockAtTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApprovalStatus(), getAuthenticator(), getCreatedTimestamp(),
                getCurrentAccountStatus(), getDisplayName(), getEmail(),
                firstFailedAttemptTimestamp, getLastModifiedTimestamp(),
                getPermissions(), recentNumberOfFailedAttempts,
                releaseLockAtTimestamp, getRole(), getUid(), getUserRoles(), getUsername());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExtendedUserInfo {\n");
        sb.append("    approvalStatus: ")
                .append(toIndentedString(getApprovalStatus()))
                .append("\n");
        sb.append("    authenticator: ")
                .append(toIndentedString(getAuthenticator()))
                .append("\n");
        sb.append("    createdTimestamp: ")
                .append(toIndentedString(getCreatedTimestamp()))
                .append("\n");
        sb.append("    currentAccountStatus: ")
                .append(toIndentedString(getCurrentAccountStatus()))
                .append("\n");
        sb.append("    displayName: ")
                .append(toIndentedString(getDisplayName()))
                .append("\n");
        sb.append("    email: ").append(toIndentedString(getEmail())).append("\n");
        sb.append("    firstFailedAttemptTimestamp: ")
                .append(toIndentedString(firstFailedAttemptTimestamp))
                .append("\n");
        sb.append("    lastModifiedTimestamp: ")
                .append(toIndentedString(getLastModifiedTimestamp()))
                .append("\n");
        sb.append("    permissions: ")
                .append(toIndentedString(getPermissions()))
                .append("\n");
        sb.append("    recentNumberOfFailedAttempts: ")
                .append(toIndentedString(recentNumberOfFailedAttempts))
                .append("\n");
        sb.append("    releaseLockAtTimestamp: ")
                .append(toIndentedString(releaseLockAtTimestamp))
                .append("\n");
        sb.append("    role: ").append(toIndentedString(getRole())).append("\n");
        sb.append("    uid: ").append(toIndentedString(getUid())).append("\n");
        sb.append("    userRoles: ")
                .append(toIndentedString(getUserRoles()))
                .append("\n");
        sb.append("    username: ").append(toIndentedString(getUsername())).append("\n");
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
