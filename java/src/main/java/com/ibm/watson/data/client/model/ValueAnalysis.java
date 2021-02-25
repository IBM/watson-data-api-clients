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

import java.util.List;
import java.util.Objects;

/**
 * ValueAnalysis
 */
public class ValueAnalysis {

    private Long distinctCount;
    private Long nullCount;
    private Long emptyCount;
    private Long uniqueCount;
    private Long maxValueFrequency;
    private String minString;
    private String maxString;
    private DiscoveredType inferredType;
    private DiscoveredClass inferredClass;
    private DiscoveredFormat inferredFormat;
    private List<ValueCount> valueDistribution;
    private List<Object> valueProblemDistribution;
    private List<DiscoveredClassDetails> classDistribution;
    private List<DiscoveredTypeDetails> typeDistribution;
    private List<DiscoveredStringDetails> logicalTypeDistribution;
    private List<DiscoveredFormatDetails> formatDistribution;
    private List<Object> bigramDistribution;
    private List<DiscoveredNumericDetails> lengthDistribution;
    private List<DiscoveredNumericDetails> precisionDistribution;
    private List<DiscoveredNumericDetails> scaleDistribution;
    private List<DiscoveredStringDetails> caseDistribution;
    private List<Object> wordDistribution;
    private NumericStats numericStats;
    private ScoreStats wordStats;
    private ScoreStats alphaCharacterStats;
    private ScoreStats digitCharacterStats;
    private ScoreStats otherCharacterStats;
    private ScoreStats lengthStats;
    private DateStats dateStats;
    private Object minHashSignature;

    @javax.annotation.Nullable
    @JsonProperty("distinct_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getDistinctCount() { return distinctCount; }
    public void setDistinctCount(Long distinctCount) { this.distinctCount = distinctCount; }

    @javax.annotation.Nullable
    @JsonProperty("null_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getNullCount() { return nullCount; }
    public void setNullCount(Long nullCount) { this.nullCount = nullCount; }

    @javax.annotation.Nullable
    @JsonProperty("empty_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getEmptyCount() { return emptyCount; }
    public void setEmptyCount(Long emptyCount) { this.emptyCount = emptyCount; }

    @javax.annotation.Nullable
    @JsonProperty("unique_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getUniqueCount() { return uniqueCount; }
    public void setUniqueCount(Long uniqueCount) { this.uniqueCount = uniqueCount; }

    @javax.annotation.Nullable
    @JsonProperty("max_value_frequency")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getMaxValueFrequency() { return maxValueFrequency; }
    public void setMaxValueFrequency(Long maxValueFrequency) { this.maxValueFrequency = maxValueFrequency; }

    @javax.annotation.Nullable
    @JsonProperty("min_string")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMinString() { return minString; }
    public void setMinString(String minString) { this.minString = minString; }

    @javax.annotation.Nullable
    @JsonProperty("max_string")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMaxString() { return maxString; }
    public void setMaxString(String maxString) { this.maxString = maxString; }

    @javax.annotation.Nullable
    @JsonProperty("inferred_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DiscoveredType getInferredType() { return inferredType; }
    public void setInferredType(DiscoveredType inferredType) { this.inferredType = inferredType; }

    @javax.annotation.Nullable
    @JsonProperty("inferred_class")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DiscoveredClass getInferredClass() { return inferredClass; }
    public void setInferredClass(DiscoveredClass inferredClass) { this.inferredClass = inferredClass; }

    @javax.annotation.Nullable
    @JsonProperty("inferred_format")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DiscoveredFormat getInferredFormat() { return inferredFormat; }
    public void setInferredFormat(DiscoveredFormat inferredFormat) { this.inferredFormat = inferredFormat; }

    @javax.annotation.Nullable
    @JsonProperty("value_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ValueCount> getValueDistribution() { return valueDistribution; }
    public void setValueDistribution(List<ValueCount> valueDistribution) { this.valueDistribution = valueDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("value_problem_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getValueProblemDistribution() { return valueProblemDistribution; }
    public void setValueProblemDistribution(List<Object> valueProblemDistribution) { this.valueProblemDistribution = valueProblemDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("class_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredClassDetails> getClassDistribution() { return classDistribution; }
    public void setClassDistribution(List<DiscoveredClassDetails> classDistribution) { this.classDistribution = classDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("type_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredTypeDetails> getTypeDistribution() { return typeDistribution; }
    public void setTypeDistribution(List<DiscoveredTypeDetails> typeDistribution) { this.typeDistribution = typeDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("logical_type_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredStringDetails> getLogicalTypeDistribution() { return logicalTypeDistribution; }
    public void setLogicalTypeDistribution(List<DiscoveredStringDetails> logicalTypeDistribution) { this.logicalTypeDistribution = logicalTypeDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("format_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredFormatDetails> getFormatDistribution() { return formatDistribution; }
    public void setFormatDistribution(List<DiscoveredFormatDetails> formatDistribution) { this.formatDistribution = formatDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("bigram_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getBigramDistribution() { return bigramDistribution; }
    public void setBigramDistribution(List<Object> bigramDistribution) { this.bigramDistribution = bigramDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("length_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredNumericDetails> getLengthDistribution() { return lengthDistribution; }
    public void setLengthDistribution(List<DiscoveredNumericDetails> lengthDistribution) { this.lengthDistribution = lengthDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("precision_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredNumericDetails> getPrecisionDistribution() { return precisionDistribution; }
    public void setPrecisionDistribution(List<DiscoveredNumericDetails> precisionDistribution) { this.precisionDistribution = precisionDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("scale_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredNumericDetails> getScaleDistribution() { return scaleDistribution; }
    public void setScaleDistribution(List<DiscoveredNumericDetails> scaleDistribution) { this.scaleDistribution = scaleDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("case_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredStringDetails> getCaseDistribution() { return caseDistribution; }
    public void setCaseDistribution(List<DiscoveredStringDetails> caseDistribution) { this.caseDistribution = caseDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("word_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getWordDistribution() { return wordDistribution; }
    public void setWordDistribution(List<Object> wordDistribution) { this.wordDistribution = wordDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("numeric_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public NumericStats getNumericStats() { return numericStats; }
    public void setNumericStats(NumericStats numericStats) { this.numericStats = numericStats; }

    @javax.annotation.Nullable
    @JsonProperty("word_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ScoreStats getWordStats() { return wordStats; }
    public void setWordStats(ScoreStats wordStats) { this.wordStats = wordStats; }

    @javax.annotation.Nullable
    @JsonProperty("alpha_chatacter_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ScoreStats getAlphaCharacterStats() { return alphaCharacterStats; }
    public void setAlphaCharacterStats(ScoreStats alphaCharacterStats) { this.alphaCharacterStats = alphaCharacterStats; }

    @javax.annotation.Nullable
    @JsonProperty("digit_chatacter_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ScoreStats getDigitCharacterStats() { return digitCharacterStats; }
    public void setDigitCharacterStats(ScoreStats digitCharacterStats) { this.digitCharacterStats = digitCharacterStats; }

    @javax.annotation.Nullable
    @JsonProperty("other_chatacter_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ScoreStats getOtherCharacterStats() { return otherCharacterStats; }
    public void setOtherCharacterStats(ScoreStats otherCharacterStats) { this.otherCharacterStats = otherCharacterStats; }

    @javax.annotation.Nullable
    @JsonProperty("length_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ScoreStats getLengthStats() { return lengthStats; }
    public void setLengthStats(ScoreStats lengthStats) { this.lengthStats = lengthStats; }

    @javax.annotation.Nullable
    @JsonProperty("date_stats")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DateStats getDateStats() { return dateStats; }
    public void setDateStats(DateStats dateStats) { this.dateStats = dateStats; }

    @javax.annotation.Nullable
    @JsonProperty("min_hash_signature")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getMinHashSignature() { return minHashSignature; }
    public void setMinHashSignature(Object minHashSignature) { this.minHashSignature = minHashSignature; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueAnalysis that = (ValueAnalysis) o;
        return Objects.equals(distinctCount, that.distinctCount) &&
                Objects.equals(nullCount, that.nullCount) &&
                Objects.equals(emptyCount, that.emptyCount) &&
                Objects.equals(uniqueCount, that.uniqueCount) &&
                Objects.equals(maxValueFrequency, that.maxValueFrequency) &&
                Objects.equals(minString, that.minString) &&
                Objects.equals(maxString, that.maxString) &&
                Objects.equals(inferredType, that.inferredType) &&
                Objects.equals(inferredClass, that.inferredClass) &&
                Objects.equals(inferredFormat, that.inferredFormat) &&
                Objects.equals(valueDistribution, that.valueDistribution) &&
                Objects.equals(valueProblemDistribution, that.valueProblemDistribution) &&
                Objects.equals(classDistribution, that.classDistribution) &&
                Objects.equals(typeDistribution, that.typeDistribution) &&
                Objects.equals(logicalTypeDistribution, that.logicalTypeDistribution) &&
                Objects.equals(formatDistribution, that.formatDistribution) &&
                Objects.equals(bigramDistribution, that.bigramDistribution) &&
                Objects.equals(lengthDistribution, that.lengthDistribution) &&
                Objects.equals(precisionDistribution, that.precisionDistribution) &&
                Objects.equals(scaleDistribution, that.scaleDistribution) &&
                Objects.equals(caseDistribution, that.caseDistribution) &&
                Objects.equals(wordDistribution, that.wordDistribution) &&
                Objects.equals(numericStats, that.numericStats) &&
                Objects.equals(wordStats, that.wordStats) &&
                Objects.equals(alphaCharacterStats, that.alphaCharacterStats) &&
                Objects.equals(digitCharacterStats, that.digitCharacterStats) &&
                Objects.equals(otherCharacterStats, that.otherCharacterStats) &&
                Objects.equals(lengthStats, that.lengthStats) &&
                Objects.equals(dateStats, that.dateStats) &&
                Objects.equals(minHashSignature, that.minHashSignature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distinctCount, nullCount, emptyCount, uniqueCount, maxValueFrequency,
                minString, maxString, inferredType, inferredClass, inferredFormat, valueDistribution,
                valueProblemDistribution, classDistribution, typeDistribution, logicalTypeDistribution,
                formatDistribution, bigramDistribution, lengthDistribution, precisionDistribution,
                scaleDistribution, caseDistribution, wordDistribution, numericStats, wordStats,
                alphaCharacterStats, digitCharacterStats, otherCharacterStats, lengthStats, dateStats,
                minHashSignature);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ValueAnalysis {\n");
        sb.append("    distinctCount: ").append(toIndentedString(distinctCount)).append("\n");
        sb.append("    nullCount: ").append(toIndentedString(nullCount)).append("\n");
        sb.append("    emptyCount: ").append(toIndentedString(emptyCount)).append("\n");
        sb.append("    uniqueCount: ").append(toIndentedString(uniqueCount)).append("\n");
        sb.append("    maxValueFrequency: ").append(toIndentedString(maxValueFrequency)).append("\n");
        sb.append("    minString: ").append(toIndentedString(minString)).append("\n");
        sb.append("    maxString: ").append(toIndentedString(maxString)).append("\n");
        sb.append("    inferredType: ").append(toIndentedString(inferredType)).append("\n");
        sb.append("    inferredClass: ").append(toIndentedString(inferredClass)).append("\n");
        sb.append("    inferredFormat: ").append(toIndentedString(inferredFormat)).append("\n");
        sb.append("    valueDistribution: ").append(toIndentedString(valueDistribution)).append("\n");
        sb.append("    valueProblemDistribution: ").append(toIndentedString(valueProblemDistribution)).append("\n");
        sb.append("    classDistribution: ").append(toIndentedString(classDistribution)).append("\n");
        sb.append("    typeDistribution: ").append(toIndentedString(typeDistribution)).append("\n");
        sb.append("    logicalTypeDistribution: ").append(toIndentedString(logicalTypeDistribution)).append("\n");
        sb.append("    formatDistribution: ").append(toIndentedString(formatDistribution)).append("\n");
        sb.append("    bigramDistribution: ").append(toIndentedString(bigramDistribution)).append("\n");
        sb.append("    lengthDistribution: ").append(toIndentedString(lengthDistribution)).append("\n");
        sb.append("    precisionDistribution: ").append(toIndentedString(precisionDistribution)).append("\n");
        sb.append("    scaleDistribution: ").append(toIndentedString(scaleDistribution)).append("\n");
        sb.append("    caseDistribution: ").append(toIndentedString(caseDistribution)).append("\n");
        sb.append("    wordDistribution: ").append(toIndentedString(wordDistribution)).append("\n");
        sb.append("    numericStats: ").append(toIndentedString(numericStats)).append("\n");
        sb.append("    wordStats: ").append(toIndentedString(wordStats)).append("\n");
        sb.append("    alphaCharacterStats: ").append(toIndentedString(alphaCharacterStats)).append("\n");
        sb.append("    digitCharacterStats: ").append(toIndentedString(digitCharacterStats)).append("\n");
        sb.append("    otherCharacterStats: ").append(toIndentedString(otherCharacterStats)).append("\n");
        sb.append("    lengthStats: ").append(toIndentedString(lengthStats)).append("\n");
        sb.append("    dateStats: ").append(toIndentedString(dateStats)).append("\n");
        sb.append("    minHashSignature: ").append(toIndentedString(minHashSignature)).append("\n");
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
