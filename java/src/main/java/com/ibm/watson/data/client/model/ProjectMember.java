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
import com.ibm.watson.data.client.model.enums.MemberState;
import com.ibm.watson.data.client.model.enums.MemberType;
import java.util.Objects;

/**
 * A project member.
 */
public class ProjectMember {

    private String id;
    private String role;
    private MemberState state = MemberState.ACTIVE;
    private MemberType type = MemberType.USER;
    private String userName;

    public ProjectMember id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The IAM ID of the project member. This field is required for project
     *members with the &#39;ACTIVE&#39; state.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public ProjectMember role(String role) {
        this.role = role;
        return this;
    }

    /**
     * Get role
     * @return role
     **/
    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public ProjectMember state(MemberState state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MemberState getState() { return state; }
    public void setState(MemberState state) { this.state = state; }

    public ProjectMember type(MemberType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MemberType getType() { return type; }
    public void setType(MemberType type) { this.type = type; }

    public ProjectMember userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * The username of the project member. If the member type is
     *&#39;service&#39;, then the &#39;user_name&#39; and &#39;id&#39; fields must
     *match.
     * @return userName
     **/
    @JsonProperty("user_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectMember projectMember = (ProjectMember)o;
        return Objects.equals(this.id, projectMember.id) &&
                Objects.equals(this.role, projectMember.role) &&
                Objects.equals(this.state, projectMember.state) &&
                Objects.equals(this.type, projectMember.type) &&
                Objects.equals(this.userName, projectMember.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, state, type, userName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectMember {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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
