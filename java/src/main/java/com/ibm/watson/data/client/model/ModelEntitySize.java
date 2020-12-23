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

/**
 * This will be used by scoring to record the size of the model. 
 */
public class ModelEntitySize {

    private BigDecimal inMemory;
    private BigDecimal content;

    public ModelEntitySize inMemory(BigDecimal inMemory) {
        this.inMemory = inMemory;
        return this;
    }

    /**
     * The memory size of the model.
     * @return inMemory
     **/
    @javax.annotation.Nullable
    @JsonProperty("in_memory")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getInMemory() { return inMemory; }
    public void setInMemory(BigDecimal inMemory) { this.inMemory = inMemory; }

    public ModelEntitySize content(BigDecimal content) {
        this.content = content;
        return this;
    }

    /**
     * The size of the model on disk.
     * @return content
     **/
    @javax.annotation.Nullable
    @JsonProperty("content")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getContent() { return content; }
    public void setContent(BigDecimal content) { this.content = content; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ModelEntitySize modelEntitySize = (ModelEntitySize) o;
        return Objects.equals(this.inMemory, modelEntitySize.inMemory) &&
                Objects.equals(this.content, modelEntitySize.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inMemory, content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelEntitySize {\n");
        sb.append("    inMemory: ").append(toIndentedString(inMemory)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
