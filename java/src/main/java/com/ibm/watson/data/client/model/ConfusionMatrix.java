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
 * ConfusionMatrix
 */
public class ConfusionMatrix {

    private String trueClass;
    private Integer tp;
    private Integer tn;
    private Integer fp;
    private Integer fn;

    public ConfusionMatrix trueClass(String trueClass) {
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

    public ConfusionMatrix tp(Integer tp) {
        this.tp = tp;
        return this;
    }

    /**
     * Get true positives
     * @return tp
     **/
    @JsonProperty("tp")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getTp() { return tp; }
    public void setTp(Integer tp) { this.tp = tp; }

    public ConfusionMatrix tn(Integer tn) {
        this.tn = tn;
        return this;
    }

    /**
     * Get true negatives
     * @return tn
     **/
    @JsonProperty("tn")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getTn() { return tn; }
    public void setTn(Integer tn) { this.tn = tn; }

    public ConfusionMatrix fp(Integer fp) {
        this.fp = fp;
        return this;
    }

    /**
     * Get false positives
     * @return fp
     **/
    @JsonProperty("fp")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getFp() { return fp; }
    public void setFp(Integer fp) { this.fp = fp; }

    public ConfusionMatrix fn(Integer fn) {
        this.fn = fn;
        return this;
    }

    /**
     * Get false negatives
     * @return fn
     **/
    @JsonProperty("fn")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getFn() { return fn; }
    public void setFn(Integer fn) { this.fn = fn; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConfusionMatrix confusionMatrix = (ConfusionMatrix) o;
        return Objects.equals(this.trueClass, confusionMatrix.trueClass) &&
                Objects.equals(this.tp, confusionMatrix.tp) &&
                Objects.equals(this.tn, confusionMatrix.tn) &&
                Objects.equals(this.fp, confusionMatrix.fp) &&
                Objects.equals(this.fn, confusionMatrix.fn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trueClass, tp, tn, fp, fn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConfusionMatrix {\n");
        sb.append("    trueClass: ").append(toIndentedString(trueClass)).append("\n");
        sb.append("    tp: ").append(toIndentedString(tp)).append("\n");
        sb.append("    tn: ").append(toIndentedString(tn)).append("\n");
        sb.append("    fp: ").append(toIndentedString(fp)).append("\n");
        sb.append("    fn: ").append(toIndentedString(fn)).append("\n");
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
