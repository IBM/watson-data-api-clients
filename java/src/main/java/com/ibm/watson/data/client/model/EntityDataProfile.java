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

import java.util.*;

/**
 * Entity Data Profile
 */
public class EntityDataProfile {

    private EmbeddedDataProfile dataProfile;

    public EntityDataProfile dataProfile(EmbeddedDataProfile dataProfile) {
        this.dataProfile = dataProfile;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("data_profile")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EmbeddedDataProfile getDataProfile() { return dataProfile; }
    public void setDataProfile(EmbeddedDataProfile dataProfile) { this.dataProfile = dataProfile; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EntityDataProfile that = (EntityDataProfile)o;
        return Objects.equals(this.dataProfile, that.dataProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataProfile);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityDataProfile {\n");
        sb.append("    dataProfile: ").append(toIndentedString(dataProfile)).append("\n");
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
