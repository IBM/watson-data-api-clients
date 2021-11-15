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
 * GroupInfo
 */
public class GroupInfo {

    private Long groupId;
    private String name;
    private String description;
    private String createdBy;
    private Date createdAt;
    private Date updatedAt;
    private Object misc;

    public GroupInfo groupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("group_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }

    public GroupInfo name(String name) {
        this.name = name;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public GroupInfo description(String description) {
        this.description = description;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public GroupInfo createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("created_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public GroupInfo createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public GroupInfo updatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public GroupInfo misc(Object misc) {
        this.misc = misc;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("misc")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getMisc() { return misc; }
    public void setMisc(Object misc) { this.misc = misc; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GroupInfo that = (GroupInfo)o;
        return Objects.equals(this.groupId, that.groupId) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.createdBy, that.createdBy) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.updatedAt, that.updatedAt) &&
                Objects.equals(this.misc, that.misc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, name, description,
                createdBy, createdAt, updatedAt, misc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupInfo {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    misc: ").append(toIndentedString(misc)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
