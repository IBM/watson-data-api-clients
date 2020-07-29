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
import com.ibm.watson.data.client.model.enums.TokenAudience;
import com.ibm.watson.data.client.model.enums.TokenRole;

import java.util.Objects;

/**
 * The project tenant access token scope.
 */
public class TokenScope {

    private TokenAudience audience = TokenAudience.PROJECT;
    private String guid;
    private TokenRole role;

    public TokenScope audience(TokenAudience audience) {
        this.audience = audience;
        return this;
    }

    /**
     * Get audience
     * @return audience
     **/
    @JsonProperty("audience")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public TokenAudience getAudience() { return audience; }
    public void setAudience(TokenAudience audience) { this.audience = audience; }

    public TokenScope guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * The project GUID.
     * @return guid
     **/
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public TokenScope role(TokenRole role) {
        this.role = role;
        return this;
    }

    /**
     * Get role
     * @return role
     **/
    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public TokenRole getRole() { return role; }
    public void setRole(TokenRole role) { this.role = role; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TokenScope tokenScope = (TokenScope)o;
        return Objects.equals(this.audience, tokenScope.audience) &&
                Objects.equals(this.guid, tokenScope.guid) &&
                Objects.equals(this.role, tokenScope.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(audience, guid, role);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenScope {\n");
        sb.append("    audience: ").append(toIndentedString(audience)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
