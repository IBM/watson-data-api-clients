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
 * The metadata containing information about the space.
 */
public class SpaceMetadata {

    private Date createdAt;
    private String creatorId;
    private String id;
    private Date updatedAt;
    private String url;

    public SpaceMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The date and time the space was created in UTC (ISO 8601)
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public SpaceMetadata creatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    /**
     * The user ID of the creator of the space.
     * @return creatorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    public SpaceMetadata id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The space GUID.
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public SpaceMetadata updatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The date and time the space was last updated in UTC (ISO 8601)
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public SpaceMetadata url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The space URL.
     * @return url
     **/
    @javax.annotation.Nullable
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SpaceMetadata that = (SpaceMetadata)o;
        return Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.creatorId, that.creatorId) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.updatedAt, that.updatedAt) &&
                Objects.equals(this.url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, creatorId, id, updatedAt, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectMetadata {\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
