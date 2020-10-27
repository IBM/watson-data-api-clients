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
 * MemberSearchResult
 */
public class MemberSearchResult {

    private Long totalResults;
    private List<Member> members = new ArrayList<>();
    private String nextBookmark;

    public MemberSearchResult totalResults(Long totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * Get totalResults
     * @return totalResults
     **/
    @JsonProperty("total_results")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Long getTotalResults() { return totalResults; }
    public void setTotalResults(Long totalResults) { this.totalResults = totalResults; }

    public MemberSearchResult members(List<Member> members) {
        this.members = members;
        return this;
    }

    public MemberSearchResult addMembersItem(Member membersItem) {
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

    public MemberSearchResult nextBookmark(String nextBookmark) {
        this.nextBookmark = nextBookmark;
        return this;
    }

    /**
     * Get nextBookmark
     * @return nextBookmark
     **/
    @javax.annotation.Nullable
    @JsonProperty("nextBookmark")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getNextBookmark() {
        return nextBookmark;
    }
    public void setNextBookmark(String nextBookmark) { this.nextBookmark = nextBookmark; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MemberSearchResult memberSearchResult = (MemberSearchResult)o;
        return Objects.equals(this.totalResults, memberSearchResult.totalResults) &&
                Objects.equals(this.members, memberSearchResult.members) &&
                Objects.equals(this.nextBookmark, memberSearchResult.nextBookmark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalResults, members, nextBookmark);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MemberSearchResult {\n");
        sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    nextBookmark: ").append(toIndentedString(nextBookmark)).append("\n");
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
