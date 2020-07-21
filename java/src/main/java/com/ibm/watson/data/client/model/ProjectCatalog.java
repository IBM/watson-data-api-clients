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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * A catalog associated with the project.
 */
@ApiModel(description = "A catalog associated with the project.")
@JsonPropertyOrder({
        ProjectCatalog.JSON_PROPERTY_GUID,
        ProjectCatalog.JSON_PROPERTY_PUBLIC
})
public class ProjectCatalog {

    public static final String JSON_PROPERTY_GUID = "guid";
    private String guid;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    private Boolean _public;

    public ProjectCatalog guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * The catalog GUID.
     * @return guid
     **/
    @ApiModelProperty(example = "fcce617b-1fc9-4965-8820-272864f58399",
            required = true, value = "The catalog GUID.")
    @JsonProperty(JSON_PROPERTY_GUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) { this.guid = guid; }

    public ProjectCatalog _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * A boolean value indicating whether the catalog is public (true) or private
     *(false).
     * @return _public
     **/
    @ApiModelProperty(
            example = "false", required = true,
            value = "A boolean value indicating whether the catalog is public (true) or private (false).")
    @JsonProperty(JSON_PROPERTY_PUBLIC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) { this._public = _public; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectCatalog projectCatalog = (ProjectCatalog)o;
        return Objects.equals(this.guid, projectCatalog.guid) &&
                Objects.equals(this._public, projectCatalog._public);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, _public);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectCatalog {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
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
