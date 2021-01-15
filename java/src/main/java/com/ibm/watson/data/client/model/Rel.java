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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A reference to a resource. 
 */
@JsonTypeName("rel")
public class Rel {

    private String id;
    private String rev;

    public Rel id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id of the referenced resource.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Rel rev(String rev) {
        this.rev = rev;
        return this;
    }

    /**
     * The revision of the referenced resource.
     * @return rev
     **/
    @javax.annotation.Nullable
    @JsonProperty("rev")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRev() { return rev; }
    public void setRev(String rev) { this.rev = rev; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Rel rel = (Rel) o;
        return Objects.equals(this.id, rel.id) &&
                Objects.equals(this.rev, rel.rev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rev);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Rel {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    rev: ").append(toIndentedString(rev)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
