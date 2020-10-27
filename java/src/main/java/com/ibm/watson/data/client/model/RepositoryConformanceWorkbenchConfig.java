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
 * RepositoryConformanceWorkbenchConfig
 */
public class RepositoryConformanceWorkbenchConfig {

    private String tutRepositoryServerName;

    public RepositoryConformanceWorkbenchConfig tutRepositoryServerName(String tutRepositoryServerName) {
        this.tutRepositoryServerName = tutRepositoryServerName;
        return this;
    }

    /**
     * Get tutRepositoryServerName
     * @return tutRepositoryServerName
     **/
    @javax.annotation.Nullable
    @JsonProperty("tutRepositoryServerName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTutRepositoryServerName() { return tutRepositoryServerName; }
    public void setTutRepositoryServerName(String tutRepositoryServerName) { this.tutRepositoryServerName = tutRepositoryServerName; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RepositoryConformanceWorkbenchConfig repositoryConformanceWorkbenchConfig = (RepositoryConformanceWorkbenchConfig)o;
        return Objects.equals(this.tutRepositoryServerName, repositoryConformanceWorkbenchConfig.tutRepositoryServerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutRepositoryServerName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryConformanceWorkbenchConfig {\n");
        sb.append("    tutRepositoryServerName: ").append(toIndentedString(tutRepositoryServerName)).append("\n");
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
