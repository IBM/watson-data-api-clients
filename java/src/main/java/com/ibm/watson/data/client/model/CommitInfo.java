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

import java.util.Date;
import java.util.Objects;

/**
 * Metadata commit (revision) information about an asset
 */
public class CommitInfo {

    private Date committedAt;
    private String commitMessage;
    private Long previousRevision;

    public CommitInfo committedAt(Date committedAt) {
        this.committedAt = committedAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("committed_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCommittedAt() { return committedAt; }
    public void setCommittedAt(Date committedAt) { this.committedAt = committedAt; }

    public CommitInfo commitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("commit_message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCommitMessage() { return commitMessage; }
    public void setCommitMessage(String commitMessage) { this.commitMessage = commitMessage; }

    public CommitInfo previousRevision(Long previousRevision) {
        this.previousRevision = previousRevision;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("previous_revision")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getPreviousRevision() { return previousRevision; }
    public void setPreviousRevision(Long previousRevision) { this.previousRevision = previousRevision; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CommitInfo that = (CommitInfo)o;
        return Objects.equals(this.committedAt, that.committedAt) &&
                Objects.equals(this.commitMessage, that.commitMessage) &&
                Objects.equals(this.previousRevision, that.previousRevision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(committedAt, commitMessage, previousRevision);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommitInfo {\n");
        sb.append("    committedAt: ").append(toIndentedString(committedAt)).append("\n");
        sb.append("    commitMessage: ").append(toIndentedString(commitMessage)).append("\n");
        sb.append("    previousRevision: ").append(toIndentedString(previousRevision)).append("\n");
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
