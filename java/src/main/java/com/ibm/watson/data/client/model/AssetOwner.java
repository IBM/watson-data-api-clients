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
 * AssetOwner
 */
public class AssetOwner {

    private String owner;
    private String ownerId;

    public AssetOwner owner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Get owner username (example: test@us.ibm.com)
     * @return owner
     **/
    @javax.annotation.Nullable
    @JsonProperty("owner")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public AssetOwner ownerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    /**
     * Get ownerId (example: IBMid-310002980)
     * @return ownerId
     **/
    @javax.annotation.Nullable
    @JsonProperty("owner_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetOwner assetOwner = (AssetOwner)o;
        return Objects.equals(this.owner, assetOwner.owner) &&
                Objects.equals(this.ownerId, assetOwner.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, ownerId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetOwner {\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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
