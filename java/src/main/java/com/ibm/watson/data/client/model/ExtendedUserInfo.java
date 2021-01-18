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

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * GetUserResponseAllOf1UserInfo
 */
public class ExtendedUserInfo extends UserInfo {

    private Date firstFailedAttemptTimestamp;
    private BigDecimal recentNumberOfFailedAttempts;
    private Date releaseLockAtTimestamp;

    public ExtendedUserInfo firstFailedAttemptTimestamp(Date firstFailedAttemptTimestamp) {
        this.firstFailedAttemptTimestamp = firstFailedAttemptTimestamp;
        return this;
    }

    /**
     * The date and time of the first failed attempt to log in.
     * @return firstFailedAttemptTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("first_failed_attempt_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getFirstFailedAttemptTimestamp() {
        return firstFailedAttemptTimestamp;
    }
    public void setFirstFailedAttemptTimestamp(Date firstFailedAttemptTimestamp) { this.firstFailedAttemptTimestamp = firstFailedAttemptTimestamp; }

    public ExtendedUserInfo recentNumberOfFailedAttempts(BigDecimal recentNumberOfFailedAttempts) {
        this.recentNumberOfFailedAttempts = recentNumberOfFailedAttempts;
        return this;
    }

    /**
     * The number of recent failed attempts to log in.
     * @return recentNumberOfFailedAttempts
     **/
    @javax.annotation.Nullable
    @JsonProperty("recent_number_of_failed_attempts")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getRecentNumberOfFailedAttempts() { return recentNumberOfFailedAttempts; }
    public void setRecentNumberOfFailedAttempts(BigDecimal recentNumberOfFailedAttempts) { this.recentNumberOfFailedAttempts = recentNumberOfFailedAttempts; }

    public ExtendedUserInfo releaseLockAtTimestamp(Date releaseLockAtTimestamp) {
        this.releaseLockAtTimestamp = releaseLockAtTimestamp;
        return this;
    }

    /**
     * The date and time of the release lock.
     * @return releaseLockAtTimestamp
     **/
    @javax.annotation.Nullable
    @JsonProperty("release_lock_at_timestamp")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getReleaseLockAtTimestamp() { return releaseLockAtTimestamp; }
    public void setReleaseLockAtTimestamp(Date releaseLockAtTimestamp) { this.releaseLockAtTimestamp = releaseLockAtTimestamp; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExtendedUserInfo getUserResponseAllOf1UserInfo = (ExtendedUserInfo)o;
        return super.equals(o) && Objects.equals(this.firstFailedAttemptTimestamp, getUserResponseAllOf1UserInfo.firstFailedAttemptTimestamp) &&
                Objects.equals(this.recentNumberOfFailedAttempts, getUserResponseAllOf1UserInfo.recentNumberOfFailedAttempts) &&
                Objects.equals(this.releaseLockAtTimestamp, getUserResponseAllOf1UserInfo.releaseLockAtTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstFailedAttemptTimestamp,
                recentNumberOfFailedAttempts, releaseLockAtTimestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExtendedUserInfo {\n");
        super.toString(sb);
        sb.append("    firstFailedAttemptTimestamp: ").append(toIndentedString(firstFailedAttemptTimestamp)).append("\n");
        sb.append("    recentNumberOfFailedAttempts: ").append(toIndentedString(recentNumberOfFailedAttempts)).append("\n");
        sb.append("    releaseLockAtTimestamp: ").append(toIndentedString(releaseLockAtTimestamp)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
