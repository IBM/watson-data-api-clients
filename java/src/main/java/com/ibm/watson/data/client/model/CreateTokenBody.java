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
 * The request body for creating a new project tenant access token.
 */
public class CreateTokenBody {

    private String name;
    private List<TokenScope> scopes = new ArrayList<>();

    public CreateTokenBody name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the tenant access token.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CreateTokenBody scopes(List<TokenScope> scopes) {
        this.scopes = scopes;
        return this;
    }

    public CreateTokenBody addScopesItem(TokenScope scopesItem) {
        this.scopes.add(scopesItem);
        return this;
    }

    /**
     * A list of project tenant access token scopes.
     * @return scopes
     **/
    @JsonProperty("scopes")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<TokenScope> getScopes() { return scopes; }
    public void setScopes(List<TokenScope> scopes) { this.scopes = scopes; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateTokenBody createTokenBody = (CreateTokenBody)o;
        return Objects.equals(this.name, createTokenBody.name) &&
                Objects.equals(this.scopes, createTokenBody.scopes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scopes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateTokenBody {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
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
