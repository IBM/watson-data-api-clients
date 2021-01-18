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
 * The Bluemix Cloud Object Storage (BMCOS) editor credentials..
 */
public class BMCOSCredentialsEditor extends BluemixCOSCredentials {

    private String resourceKeyCrn;

    public BMCOSCredentialsEditor resourceKeyCrn(String resourceKeyCrn) {
        this.resourceKeyCrn = resourceKeyCrn;
        return this;
    }

    /**
     * Resource key CRN. Must be provided with other HMAC credentials for
     * non-admin entries.
     * @return resourceKeyCrn
     **/
    @javax.annotation.Nullable
    @JsonProperty("resource_key_crn")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getResourceKeyCrn() { return resourceKeyCrn; }
    public void setResourceKeyCrn(String resourceKeyCrn) { this.resourceKeyCrn = resourceKeyCrn; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BMCOSCredentialsEditor bmCOSCredentialsEditor = (BMCOSCredentialsEditor)o;
        return super.equals(o) &&
                Objects.equals(this.resourceKeyCrn, bmCOSCredentialsEditor.resourceKeyCrn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resourceKeyCrn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BMCOSCredentialsEditor {\n");
        super.toString(sb);
        sb.append("    resourceKeyCrn: ").append(toIndentedString(resourceKeyCrn)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
