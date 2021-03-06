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
 * CreateRDVResponse
 */
public class RDVGlossaryResource extends GlossaryResource {

    private List<ResponseReferenceDataValueEntity> rdsValues;

    public RDVGlossaryResource rdsValues(List<ResponseReferenceDataValueEntity> rdsValues) {
        this.rdsValues = rdsValues;
        return this;
    }

    public RDVGlossaryResource addRdsValuesItem(ResponseReferenceDataValueEntity rdsValuesItem) {
        if (this.rdsValues == null) {
            this.rdsValues = new ArrayList<>();
        }
        this.rdsValues.add(rdsValuesItem);
        return this;
    }

    /**
     * IDs of the created items.
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty("rds_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ResponseReferenceDataValueEntity> getRdsValues() { return rdsValues; }
    public void setRdsValues(List<ResponseReferenceDataValueEntity> rdsValues) { this.rdsValues = rdsValues; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RDVGlossaryResource that = (RDVGlossaryResource)o;
        return super.equals(o) &&
                Objects.equals(this.rdsValues, that.rdsValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rdsValues);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateRDVResponse {\n");
        super.toString(sb);
        sb.append("    rdsValues: ").append(toIndentedString(rdsValues)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
