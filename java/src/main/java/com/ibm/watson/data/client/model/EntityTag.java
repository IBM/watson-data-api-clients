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
 * EntityTag
 */
public class EntityTag {

    private String value;
    private Boolean weak;

    public EntityTag value(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public EntityTag weak(Boolean weak) {
        this.weak = weak;
        return this;
    }

    /**
     * Get weak
     * @return weak
     **/
    @javax.annotation.Nullable
    @JsonProperty("weak")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getWeak() { return weak; }
    public void setWeak(Boolean weak) { this.weak = weak; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        EntityTag entityTag = (EntityTag)o;
        return Objects.equals(this.value, entityTag.value) &&
                Objects.equals(this.weak, entityTag.weak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weak);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityTag {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    weak: ").append(toIndentedString(weak)).append("\n");
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
