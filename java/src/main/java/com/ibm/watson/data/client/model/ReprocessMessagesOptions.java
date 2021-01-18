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
import com.ibm.watson.data.client.model.enums.MessageReprocessingType;

import java.util.Objects;

/**
 * ReprocessMessagesOptions
 */
public class ReprocessMessagesOptions {

    private String guid;
    private Boolean force;
    private MessageReprocessingType lookup;

    public ReprocessMessagesOptions guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get guid
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public ReprocessMessagesOptions force(Boolean force) {
        this.force = force;
        return this;
    }

    /**
     * Get force
     * @return force
     **/
    @javax.annotation.Nullable
    @JsonProperty("force")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getForce() { return force; }
    public void setForce(Boolean force) { this.force = force; }

    public ReprocessMessagesOptions lookup(MessageReprocessingType lookup) {
        this.lookup = lookup;
        return this;
    }

    /**
     * Get lookup
     * @return lookup
     **/
    @javax.annotation.Nullable
    @JsonProperty("lookup")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MessageReprocessingType getLookup() { return lookup; }
    public void setLookup(MessageReprocessingType lookup) { this.lookup = lookup; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ReprocessMessagesOptions reprocessMessagesOptions = (ReprocessMessagesOptions)o;
        return Objects.equals(this.guid, reprocessMessagesOptions.guid) &&
                Objects.equals(this.force, reprocessMessagesOptions.force) &&
                Objects.equals(this.lookup, reprocessMessagesOptions.lookup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, force, lookup);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReprocessMessagesOptions {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    force: ").append(toIndentedString(force)).append("\n");
        sb.append("    lookup: ").append(toIndentedString(lookup)).append("\n");
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
