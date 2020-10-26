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
 * Member
 */
public class Member extends MemberHeader {

    private String accessGroupId;
    private String role;
    private String href;
    private String createTime;

    public Member accessGroupId(String accessGroupId) {
        this.accessGroupId = accessGroupId;
        return this;
    }

    /**
     * ID of the access group member, eg. "AccessGroupId-abcd1234"
     * @return accessGroupId
     **/
    @JsonProperty("access_group_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAccessGroupId() { return accessGroupId; }
    public void setAccessGroupId(String accessGroupId) { this.accessGroupId = accessGroupId; }

    public Member role(String role) {
        this.role = role;
        return this;
    }

    /**
     * Role of the member in the Catalog, eg. "admin"
     * @return role
     **/
    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRole() { return role; }
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
    @JsonProperty("href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHref() { return href; }
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
    @JsonProperty("create_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Member member = (Member)o;
        return super.equals(o) &&
                Objects.equals(this.accessGroupId, member.accessGroupId) &&
                Objects.equals(this.role, member.role) &&
                Objects.equals(this.href, member.href) &&
                Objects.equals(this.createTime, member.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accessGroupId, role, href, createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Member {\n");
        super.toString(sb);
        sb.append("    accessGroupId: ").append(toIndentedString(accessGroupId)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
