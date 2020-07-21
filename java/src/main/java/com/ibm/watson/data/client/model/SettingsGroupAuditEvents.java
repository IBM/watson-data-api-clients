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
 * The audit events settings group.
 */
@ApiModel(description = "The audit events settings group.")
@JsonPropertyOrder({
        SettingsGroupAuditEvents.JSON_PROPERTY_ENABLED
})
public class SettingsGroupAuditEvents {

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    private Boolean enabled = false;

    public SettingsGroupAuditEvents enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * The enablement flag for the audit events feature.
     * @return enabled
     **/
    @ApiModelProperty(required = true,
            value = "The enablement flag for the audit events feature.")
    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SettingsGroupAuditEvents settingsGroupAuditEvents =
                (SettingsGroupAuditEvents)o;
        return Objects.equals(this.enabled, settingsGroupAuditEvents.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SettingsGroupAuditEvents {\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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
