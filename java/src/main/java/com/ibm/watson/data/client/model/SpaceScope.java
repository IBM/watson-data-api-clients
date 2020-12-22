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
 * The scope for a space.
 */
public class SpaceScope {

    private String bssAccountId;

    public SpaceScope bssAccountId(String bssAccountId) {
        this.bssAccountId = bssAccountId;
        return this;
    }

    /**
     * The account ID for the scope.
     * @return bssAccountId
     **/
    @javax.annotation.Nullable
    @JsonProperty("bss_account_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getBssAccountId() { return bssAccountId; }
    public void setBssAccountId(String bssAccountId) { this.bssAccountId = bssAccountId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SpaceScope that = (SpaceScope)o;
        return Objects.equals(this.bssAccountId, that.bssAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bssAccountId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SpaceScope {\n");
        sb.append("    bssAccountId: ").append(toIndentedString(bssAccountId)).append("\n");
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
