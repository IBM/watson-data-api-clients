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

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information related to the revision. 
 */
public class ResourceMetaBaseCommitInfo {

    private Date committedAt;
    private String commitMessage;

    public ResourceMetaBaseCommitInfo committedAt(Date committedAt) {
        this.committedAt = committedAt;
        return this;
    }

    /**
     * The time when the revision was committed.
     * @return committedAt
     **/
    @JsonProperty("committed_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getCommittedAt() { return committedAt; }
    public void setCommittedAt(Date committedAt) { this.committedAt = committedAt; }

    public ResourceMetaBaseCommitInfo commitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
        return this;
    }

    /**
     * The message that was provided when the revision was created.
     * @return commitMessage
     **/
    @javax.annotation.Nullable
    @JsonProperty("commit_message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCommitMessage() { return commitMessage; }
    public void setCommitMessage(String commitMessage) { this.commitMessage = commitMessage; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ResourceMetaBaseCommitInfo resourceMetaBaseCommitInfo = (ResourceMetaBaseCommitInfo) o;
        return Objects.equals(this.committedAt, resourceMetaBaseCommitInfo.committedAt) &&
                Objects.equals(this.commitMessage, resourceMetaBaseCommitInfo.commitMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(committedAt, commitMessage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResourceMetaBaseCommitInfo {\n");
        sb.append("    committedAt: ").append(toIndentedString(committedAt)).append("\n");
        sb.append("    commitMessage: ").append(toIndentedString(commitMessage)).append("\n");
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
