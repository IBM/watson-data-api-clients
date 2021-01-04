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
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A project tenant access token.
 */
public class ProjectToken {

    private Date createdAt;
    private String guid;
    private Date lastUsedAt;
    private String name;
    private List<TokenScope> scopes = null;
    private String token;

    public ProjectToken createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The date and time the tenant access token was created in UTC (ISO 8601).
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public ProjectToken guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * The GUID of the tenant access token.
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public ProjectToken lastUsedAt(Date lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
        return this;
    }

    /**
     * The date and time the tenant access token was last used in UTC (ISO 8601).
     * @return lastUsedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("last_used_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastUsedAt() { return lastUsedAt; }
    public void setLastUsedAt(Date lastUsedAt) { this.lastUsedAt = lastUsedAt; }

    public ProjectToken name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the tenant access token.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ProjectToken scopes(List<TokenScope> scopes) {
        this.scopes = scopes;
        return this;
    }

    public ProjectToken addScopesItem(TokenScope scopesItem) {
        if (this.scopes == null) {
            this.scopes = new ArrayList<>();
        }
        this.scopes.add(scopesItem);
        return this;
    }

    /**
     * A list of project tenant access token scopes.
     * @return scopes
     **/
    @javax.annotation.Nullable
    @JsonProperty("scopes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TokenScope> getScopes() { return scopes; }
    public void setScopes(List<TokenScope> scopes) { this.scopes = scopes; }

    public ProjectToken token(String token) {
        this.token = token;
        return this;
    }

    /**
     * The tenant access token. Once a token is issued (created), it does not
     * expire; but, it can be revoked (deleted).
     * @return token
     **/
    @javax.annotation.Nullable
    @JsonProperty("token")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectToken projectToken = (ProjectToken)o;
        return Objects.equals(this.createdAt, projectToken.createdAt) &&
                Objects.equals(this.guid, projectToken.guid) &&
                Objects.equals(this.lastUsedAt, projectToken.lastUsedAt) &&
                Objects.equals(this.name, projectToken.name) &&
                Objects.equals(this.scopes, projectToken.scopes) &&
                Objects.equals(this.token, projectToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, guid, lastUsedAt, name, scopes, token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectToken {\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    lastUsedAt: ").append(toIndentedString(lastUsedAt)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
