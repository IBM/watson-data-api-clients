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
 * The entity payload representing the core space attributes.
 */
public class SpaceEntity {

    private List<String> tags = null;
    private List<SpaceCompute> compute;
    private String description;
    private List<SpaceMember> members;
    private String name;
    private SpaceScope scope;
    private SpaceStatus status;

    public SpaceEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public SpaceEntity addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * The user-defined tags associated with a space.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public SpaceEntity compute(List<SpaceCompute> compute) {
        this.compute = compute;
        return this;
    }

    public SpaceEntity addComputeItem(SpaceCompute computeItem) {
        if (this.compute == null) {
            this.compute = new ArrayList<>();
        }
        this.compute.add(computeItem);
        return this;
    }

    /**
     * Get compute
     * @return compute
     **/
    @javax.annotation.Nullable
    @JsonProperty("compute")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<SpaceCompute> getCompute() { return compute; }
    public void setCompute(List<SpaceCompute> compute) { this.compute = compute; }

    public SpaceEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description for the new space.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public SpaceEntity members(List<SpaceMember> members) {
        this.members = members;
        return this;
    }

    public SpaceEntity addMembersItem(SpaceMember membersItem) {
        if (this.members == null) {
            this.members = new ArrayList<>();
        }
        this.members.add(membersItem);
        return this;
    }

    /**
     * Get members
     * @return members
     **/
    @javax.annotation.Nullable
    @JsonProperty("members")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<SpaceMember> getMembers() { return members; }
    public void setMembers(List<SpaceMember> members) { this.members = members; }

    public SpaceEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the space.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SpaceEntity scope(SpaceScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * The scope of the space.
     * @return scope
     **/
    @javax.annotation.Nullable
    @JsonProperty("scope")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SpaceScope getScope() { return scope; }
    public void setScope(SpaceScope scope) { this.scope = scope; }

    public SpaceEntity status(SpaceStatus status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the space.
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SpaceStatus getStatus() { return status; }
    public void setStatus(SpaceStatus status) { this.status = status; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SpaceEntity that = (SpaceEntity)o;
        return Objects.equals(this.tags, that.tags) &&
                Objects.equals(this.compute, that.compute) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.members, that.members) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.scope, that.scope) &&
                Objects.equals(this.status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, compute, description, members, name, scope, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectEntity {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    scope: ").append(toIndentedString(status)).append("\n");
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
