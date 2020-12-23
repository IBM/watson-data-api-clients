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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * RocCurve
 */
public class RocCurve {

    private String trueClass;
    private BigDecimal tpr;
    private BigDecimal fpr;
    private List<BigDecimal> thresholds = null;

    public RocCurve trueClass(String trueClass) {
        this.trueClass = trueClass;
        return this;
    }

    /**
     * Get trueClass
     * @return trueClass
     **/
    @JsonProperty("true_class")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTrueClass() { return trueClass; }
    public void setTrueClass(String trueClass) { this.trueClass = trueClass; }

    public RocCurve tpr(BigDecimal tpr) {
        this.tpr = tpr;
        return this;
    }

    /**
     * Get true positive rate
     * @return tpr
     **/
    @JsonProperty("tpr")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public BigDecimal getTpr() { return tpr; }
    public void setTpr(BigDecimal tpr) { this.tpr = tpr; }

    public RocCurve fpr(BigDecimal fpr) {
        this.fpr = fpr;
        return this;
    }

    /**
     * Get false positive rate
     * @return fpr
     **/
    @JsonProperty("fpr")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public BigDecimal getFpr() { return fpr; }
    public void setFpr(BigDecimal fpr) { this.fpr = fpr; }

    public RocCurve thresholds(List<BigDecimal> thresholds) {
        this.thresholds = thresholds;
        return this;
    }

    public RocCurve addThresholdsItem(BigDecimal thresholdsItem) {
        if (this.thresholds == null) {
            this.thresholds = new ArrayList<>();
        }
        this.thresholds.add(thresholdsItem);
        return this;
    }

    /**
     * Get thresholds
     * @return thresholds
     **/
    @javax.annotation.Nullable
    @JsonProperty("thresholds")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<BigDecimal> getThresholds() { return thresholds; }
    public void setThresholds(List<BigDecimal> thresholds) { this.thresholds = thresholds; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RocCurve rocCurve = (RocCurve) o;
        return Objects.equals(this.trueClass, rocCurve.trueClass) &&
                Objects.equals(this.tpr, rocCurve.tpr) &&
                Objects.equals(this.fpr, rocCurve.fpr) &&
                Objects.equals(this.thresholds, rocCurve.thresholds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trueClass, tpr, fpr, thresholds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RocCurve {\n");
        sb.append("    trueClass: ").append(toIndentedString(trueClass)).append("\n");
        sb.append("    tpr: ").append(toIndentedString(tpr)).append("\n");
        sb.append("    fpr: ").append(toIndentedString(fpr)).append("\n");
        sb.append("    thresholds: ").append(toIndentedString(thresholds)).append("\n");
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
