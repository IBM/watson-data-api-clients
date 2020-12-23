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

/**
 * MultiClassClassification
 */
public class MultiClassClassification {

    private String className;
    private ConfusionMatrix confusionMatrix;
    private RocCurve rocCurve;

    public MultiClassClassification className(String className) {
        this.className = className;
        return this;
    }

    /**
     * Get className
     * @return className
     **/
    @JsonProperty("class_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public MultiClassClassification confusionMatrix(ConfusionMatrix confusionMatrix) {
        this.confusionMatrix = confusionMatrix;
        return this;
    }

    /**
     * Get confusionMatrix
     * @return confusionMatrix
     **/
    @JsonProperty("confusion_matrix")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ConfusionMatrix getConfusionMatrix() { return confusionMatrix; }
    public void setConfusionMatrix(ConfusionMatrix confusionMatrix) { this.confusionMatrix = confusionMatrix; }

    public MultiClassClassification rocCurve(RocCurve rocCurve) {
        this.rocCurve = rocCurve;
        return this;
    }

    /**
     * Get rocCurve
     * @return rocCurve
     **/
    @JsonProperty("roc_curve")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public RocCurve getRocCurve() { return rocCurve; }
    public void setRocCurve(RocCurve rocCurve) { this.rocCurve = rocCurve; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MultiClassClassification multiClassClassification = (MultiClassClassification) o;
        return Objects.equals(this.className, multiClassClassification.className) &&
                Objects.equals(this.confusionMatrix, multiClassClassification.confusionMatrix) &&
                Objects.equals(this.rocCurve, multiClassClassification.rocCurve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, confusionMatrix, rocCurve);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MultiClassClassification {\n");
        sb.append("    className: ").append(toIndentedString(className)).append("\n");
        sb.append("    confusionMatrix: ").append(toIndentedString(confusionMatrix)).append("\n");
        sb.append("    rocCurve: ").append(toIndentedString(rocCurve)).append("\n");
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
