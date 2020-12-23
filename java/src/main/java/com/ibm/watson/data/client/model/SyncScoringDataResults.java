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
 * Scoring results. 
 */
public class SyncScoringDataResults {

    private List<ScoringPayload> predictions = null;

    public SyncScoringDataResults predictions(List<ScoringPayload> predictions) {
        this.predictions = predictions;
        return this;
    }

    public SyncScoringDataResults addPredictionsItem(ScoringPayload predictionsItem) {
        if (this.predictions == null) {
            this.predictions = new ArrayList<>();
        }
        this.predictions.add(predictionsItem);
        return this;
    }

    /**
     * The predictions.
     * @return predictions
     **/
    @javax.annotation.Nullable
    @JsonProperty("predictions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ScoringPayload> getPredictions() { return predictions; }
    public void setPredictions(List<ScoringPayload> predictions) { this.predictions = predictions; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SyncScoringDataResults syncScoringDataResults = (SyncScoringDataResults) o;
        return Objects.equals(this.predictions, syncScoringDataResults.predictions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predictions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SyncScoringDataResults {\n");
        sb.append("    predictions: ").append(toIndentedString(predictions)).append("\n");
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
