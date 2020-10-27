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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MemberSet with partial success result
 */
public class MemberSetPartialResult {

    private List<Member> members = new ArrayList<>();
    private List<MemberError> failures = null;
    private String trace;

    public MemberSetPartialResult members(List<Member> members) {
        this.members = members;
        return this;
    }

    public MemberSetPartialResult addMembersItem(Member membersItem) {
        this.members.add(membersItem);
        return this;
    }

    /**
     * Get members
     * @return members
     **/
    @JsonProperty("members")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }

    public MemberSetPartialResult failures(List<MemberError> failures) {
        this.failures = failures;
        return this;
    }

    public MemberSetPartialResult addFailuresItem(MemberError failuresItem) {
        if (this.failures == null) {
            this.failures = new ArrayList<>();
        }
        this.failures.add(failuresItem);
        return this;
    }

    /**
     * Get failures
     * @return failures
     **/
    @javax.annotation.Nullable
    @JsonProperty("failures")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MemberError> getFailures() { return failures; }
    public void setFailures(List<MemberError> failures) { this.failures = failures; }

    public MemberSetPartialResult trace(String trace) {
        this.trace = trace;
        return this;
    }

    /**
     * Get trace
     * @return trace
     **/
    @javax.annotation.Nullable
    @JsonProperty("trace")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTrace() { return trace; }
    public void setTrace(String trace) { this.trace = trace; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MemberSetPartialResult memberSetPartialResult = (MemberSetPartialResult)o;
        return Objects.equals(this.members, memberSetPartialResult.members) &&
                Objects.equals(this.failures, memberSetPartialResult.failures) &&
                Objects.equals(this.trace, memberSetPartialResult.trace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, failures, trace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MemberSetPartialResult {\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    failures: ").append(toIndentedString(failures)).append("\n");
        sb.append("    trace: ").append(toIndentedString(trace)).append("\n");
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
