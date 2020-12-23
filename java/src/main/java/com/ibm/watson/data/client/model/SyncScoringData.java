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
import java.util.ArrayList;
import java.util.List;

/**
 * Scoring data. 
 */
public class SyncScoringData {

    private List<InputDataArray> inputData = new ArrayList<>();

    public SyncScoringData inputData(List<InputDataArray> inputData) {
        this.inputData = inputData;
        return this;
    }

    public SyncScoringData addInputDataItem(InputDataArray inputDataItem) {
        this.inputData.add(inputDataItem);
        return this;
    }

    /**
     * The input data.
     * @return inputData
     **/
    @JsonProperty("input_data")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<InputDataArray> getInputData() { return inputData; }
    public void setInputData(List<InputDataArray> inputData) { this.inputData = inputData; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SyncScoringData syncScoringData = (SyncScoringData) o;
        return Objects.equals(this.inputData, syncScoringData.inputData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SyncScoringData {\n");
        sb.append("    inputData: ").append(toIndentedString(inputData)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
