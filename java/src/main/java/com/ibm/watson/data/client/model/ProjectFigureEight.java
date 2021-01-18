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
 * The Figure Eight feature integration with the project.
 */
public class ProjectFigureEight {

    private String apiKey;

    public ProjectFigureEight apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * The API key for a figure eight resource.
     * @return apiKey
     **/
    @JsonProperty("api_key")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectFigureEight projectFigureEight = (ProjectFigureEight)o;
        return Objects.equals(this.apiKey, projectFigureEight.apiKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectFigureEight {\n");
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
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
