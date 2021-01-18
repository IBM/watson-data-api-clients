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
 * The metadata containing information about the project.
 */
public class ProjectMetadata {

    private Date createdAt;
    private String guid;
    private Date updatedAt;
    private String url;

    public ProjectMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The date and time the project was created in UTC (ISO 8601)
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public ProjectMetadata guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * The project GUID.
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public ProjectMetadata updatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The date and time the project was last updated in UTC (ISO 8601)
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public ProjectMetadata url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The project URL.
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
        ProjectMetadata projectMetadata = (ProjectMetadata)o;
        return Objects.equals(this.createdAt, projectMetadata.createdAt) &&
                Objects.equals(this.guid, projectMetadata.guid) &&
                Objects.equals(this.updatedAt, projectMetadata.updatedAt) &&
                Objects.equals(this.url, projectMetadata.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, guid, updatedAt, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectMetadata {\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
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
