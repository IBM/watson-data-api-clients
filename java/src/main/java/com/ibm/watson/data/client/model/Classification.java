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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classification
 */
public class Classification {

    private String classificationName;
    private Map<String, Object> classificationProperties = null;

    public Classification classificationName(String classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    /**
     * Get classificationName
     * @return classificationName
     **/
    @javax.annotation.Nullable
    @JsonProperty("classificationName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getClassificationName() { return classificationName; }
    public void setClassificationName(String classificationName) { this.classificationName = classificationName; }

    public Classification classificationProperties(Map<String, Object> classificationProperties) {
        this.classificationProperties = classificationProperties;
        return this;
    }

    public Classification putClassificationPropertiesItem(String key, Object classificationPropertiesItem) {
        if (this.classificationProperties == null) {
            this.classificationProperties = new HashMap<>();
        }
        this.classificationProperties.put(key, classificationPropertiesItem);
        return this;
    }

    /**
     * Get classificationProperties
     * @return classificationProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("classificationProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getClassificationProperties() { return classificationProperties; }
    public void setClassificationProperties(Map<String, Object> classificationProperties) { this.classificationProperties = classificationProperties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Classification classification = (Classification)o;
        return Objects.equals(this.classificationName, classification.classificationName) &&
                Objects.equals(this.classificationProperties, classification.classificationProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classificationName, classificationProperties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Classification {\n");
        sb.append("    classificationName: ").append(toIndentedString(classificationName)).append("\n");
        sb.append("    classificationProperties: ").append(toIndentedString(classificationProperties)).append("\n");
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
