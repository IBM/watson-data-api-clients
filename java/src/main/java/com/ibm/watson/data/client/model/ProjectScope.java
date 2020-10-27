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
 * The project scope definition.
 */
public class ProjectScope {

    private String bssAccountId;
    private Boolean enforceMembers = true;
    private String samlInstanceName;

    public ProjectScope bssAccountId(String bssAccountId) {
        this.bssAccountId = bssAccountId;
        return this;
    }

    /**
     * The BSS Account ID associated with the project. In Private Cloud, the BSS
     * Account ID must be &#39;999&#39;.
     * @return bssAccountId
     **/
    @JsonProperty("bss_account_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getBssAccountId() { return bssAccountId; }
    public void setBssAccountId(String bssAccountId) { this.bssAccountId = bssAccountId; }

    public ProjectScope enforceMembers(Boolean enforceMembers) {
        this.enforceMembers = enforceMembers;
        return this;
    }

    /**
     * Setting to true indicates that members added to the project must also be
     * federated and belong to the matching SAML instance. Can only be set when
     * project is created and cannot be updated.
     * @return enforceMembers
     **/
    @javax.annotation.Nullable
    @JsonProperty("enforce_members")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getEnforceMembers() { return enforceMembers; }
    public void setEnforceMembers(Boolean enforceMembers) { this.enforceMembers = enforceMembers; }

    public ProjectScope samlInstanceName(String samlInstanceName) {
        this.samlInstanceName = samlInstanceName;
        return this;
    }

    /**
     * Name for a SAML 2.0 instance. Can be optionally provided during POST if the
     * project creator is federated. Can only be set when project is created and
     * cannot be updated.
     * @return samlInstanceName
     **/
    @javax.annotation.Nullable
    @JsonProperty("saml_instance_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSamlInstanceName() { return samlInstanceName; }
    public void setSamlInstanceName(String samlInstanceName) { this.samlInstanceName = samlInstanceName; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ProjectScope projectScope = (ProjectScope)o;
        return Objects.equals(this.bssAccountId, projectScope.bssAccountId) &&
                Objects.equals(this.enforceMembers, projectScope.enforceMembers) &&
                Objects.equals(this.samlInstanceName, projectScope.samlInstanceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bssAccountId, enforceMembers, samlInstanceName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectScope {\n");
        sb.append("    bssAccountId: ").append(toIndentedString(bssAccountId)).append("\n");
        sb.append("    enforceMembers: ").append(toIndentedString(enforceMembers)).append("\n");
        sb.append("    samlInstanceName: ").append(toIndentedString(samlInstanceName)).append("\n");
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
