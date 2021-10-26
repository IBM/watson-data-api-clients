/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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
 * Item and operation pair.
 */
public class V3ItemAndOperation {

    private String itemId;
    private String operation;

    public V3ItemAndOperation itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * Get itemId
     * @return itemId
     **/
    @javax.annotation.Nonnull
    @JsonProperty("item_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public V3ItemAndOperation operation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     * @return operation
     **/
    @javax.annotation.Nonnull
    @JsonProperty("operation")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3ItemAndOperation v3ItemAndOperation = (V3ItemAndOperation) o;
        return Objects.equals(this.itemId, v3ItemAndOperation.itemId) &&
                Objects.equals(this.operation, v3ItemAndOperation.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, operation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3ItemAndOperation {\n");
        sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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
