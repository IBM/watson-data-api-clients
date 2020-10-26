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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CreateValueRelationshipResponseResource
 */
public class CreateValueRelationshipResponseResource extends GlossaryResource {

    private List<ResponseRDVCreateRelationshipEntity> rdsValues = null;

    public CreateValueRelationshipResponseResource rdsValues(List<ResponseRDVCreateRelationshipEntity> rdsValues) {
        this.rdsValues = rdsValues;
        return this;
    }

    public CreateValueRelationshipResponseResource addRdsValuesItem(ResponseRDVCreateRelationshipEntity rdsValuesItem) {
        if (this.rdsValues == null) {
            this.rdsValues = new ArrayList<>();
        }
        this.rdsValues.add(rdsValuesItem);
        return this;
    }

    /**
     * reference data values to which relationship added
     * @return rdsValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("rds_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ResponseRDVCreateRelationshipEntity> getRdsValues() { return rdsValues; }
    public void setRdsValues(List<ResponseRDVCreateRelationshipEntity> rdsValues) { this.rdsValues = rdsValues; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateValueRelationshipResponseResource createValueRelationshipResponseResource = (CreateValueRelationshipResponseResource)o;
        return super.equals(o) &&
                Objects.equals(this.rdsValues, createValueRelationshipResponseResource.rdsValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rdsValues);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateValueRelationshipResponseResource {\n");
        toString(sb);
        sb.append("    rdsValues: ").append(toIndentedString(rdsValues)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
