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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * Copy Asset Model
 */
@ApiModel(description = "Copy Asset Model")
public class AssetCopyTo {

    public static final String JSON_PROPERTY_PROJECT_ID = "project_id";
    private String projectId;

    public AssetCopyTo projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * Get projectId
     * @return projectId
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) { this.projectId = projectId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssetCopyTo assetCopyTo = (AssetCopyTo)o;
        return Objects.equals(this.projectId, assetCopyTo.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetCopyTo {\n");
        sb.append("    projectId: ")
                .append(toIndentedString(projectId))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
