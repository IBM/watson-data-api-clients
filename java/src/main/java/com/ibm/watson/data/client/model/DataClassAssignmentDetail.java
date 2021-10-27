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
 * DataClassAssignmentDetail
 */
public class DataClassAssignmentDetail {

    private String id;
    private Boolean setByUser;

    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @javax.annotation.Nullable
    @JsonProperty("setByUser")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean isSetByUser() { return setByUser; }
    public void setSetByUser(Boolean setByUser) { this.setByUser = setByUser; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataClassAssignmentDetail that = (DataClassAssignmentDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(setByUser, that.setByUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, setByUser);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataClassAssignmentDetail {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    setByUser: ").append(toIndentedString(setByUser)).append("\n");
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
