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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * BinaryClassification
 */
public class BinaryClassification {

    private List<ConfusionMatrix> confusionMatrices = null;
    private List<RocCurve> rocCurves = null;

    public BinaryClassification confusionMatrices(List<ConfusionMatrix> confusionMatrices) {
        this.confusionMatrices = confusionMatrices;
        return this;
    }

    public BinaryClassification addConfusionMatricesItem(ConfusionMatrix confusionMatricesItem) {
        if (this.confusionMatrices == null) {
            this.confusionMatrices = new ArrayList<>();
        }
        this.confusionMatrices.add(confusionMatricesItem);
        return this;
    }

    /**
     * Get confusionMatrices
     * @return confusionMatrices
     **/
    @javax.annotation.Nullable
    @JsonProperty("confusion_matrices")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ConfusionMatrix> getConfusionMatrices() { return confusionMatrices; }
    public void setConfusionMatrices(List<ConfusionMatrix> confusionMatrices) { this.confusionMatrices = confusionMatrices; }

    public BinaryClassification rocCurves(List<RocCurve> rocCurves) {
        this.rocCurves = rocCurves;
        return this;
    }

    public BinaryClassification addRocCurvesItem(RocCurve rocCurvesItem) {
        if (this.rocCurves == null) {
            this.rocCurves = new ArrayList<>();
        }
        this.rocCurves.add(rocCurvesItem);
        return this;
    }

    /**
     * Get rocCurves
     * @return rocCurves
     **/
    @javax.annotation.Nullable
    @JsonProperty("roc_curves")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RocCurve> getRocCurves() { return rocCurves; }
    public void setRocCurves(List<RocCurve> rocCurves) { this.rocCurves = rocCurves; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BinaryClassification binaryClassification = (BinaryClassification) o;
        return Objects.equals(this.confusionMatrices, binaryClassification.confusionMatrices) &&
                Objects.equals(this.rocCurves, binaryClassification.rocCurves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(confusionMatrices, rocCurves);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BinaryClassification {\n");
        sb.append("    confusionMatrices: ").append(toIndentedString(confusionMatrices)).append("\n");
        sb.append("    rocCurves: ").append(toIndentedString(rocCurves)).append("\n");
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
