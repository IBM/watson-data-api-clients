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
 * The access restrictions settings group.
 */
@ApiModel(description = "The access restrictions settings group.")
@JsonPropertyOrder({
        SettingsGroupAccessRestrictions.JSON_PROPERTY_DATA
})
public class SettingsGroupAccessRestrictions {

    public static final String JSON_PROPERTY_DATA = "data";
    private Boolean data = false;

    public SettingsGroupAccessRestrictions data(Boolean data) {
        this.data = data;
        return this;
    }

    /**
     * Restrict access to project data.
     * @return data
     **/
    @ApiModelProperty(required = true, value = "Restrict access to project data.")
    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) { this.data = data; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SettingsGroupAccessRestrictions settingsGroupAccessRestrictions =
                (SettingsGroupAccessRestrictions)o;
        return Objects.equals(this.data, settingsGroupAccessRestrictions.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SettingsGroupAccessRestrictions {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
