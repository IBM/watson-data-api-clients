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
 * A list of project tenant access tokens.
 */
public class ProjectTokens {

    private List<ProjectToken> tokens = null;

    public ProjectTokens tokens(List<ProjectToken> tokens) {
        this.tokens = tokens;
        return this;
    }

    public ProjectTokens addTokensItem(ProjectToken tokensItem) {
        if (this.tokens == null) {
            this.tokens = new ArrayList<>();
        }
        this.tokens.add(tokensItem);
        return this;
    }

    /**
     * A list of project tenant access tokens.
     * @return tokens
     **/
    @javax.annotation.Nullable
    @JsonProperty("tokens")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ProjectToken> getTokens() { return tokens; }
    public void setTokens(List<ProjectToken> tokens) { this.tokens = tokens; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectTokens projectTokens = (ProjectTokens)o;
        return Objects.equals(this.tokens, projectTokens.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokens);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectTokens {\n");
        sb.append("    tokens: ").append(toIndentedString(tokens)).append("\n");
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
