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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TransformOperation
 */
public class TransformOperation {

    private String operationType;
    private List<Map<String, Object>> parameters = null;
    private List<JsonElement> schemas = null;

    public TransformOperation operationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    /**
     * Get operationType
     * @return operationType
     **/
    @javax.annotation.Nullable
    @JsonProperty("operation_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public TransformOperation parameters(List<Map<String, Object>> parameters) {
        this.parameters = parameters;
        return this;
    }

    public TransformOperation addParametersItem(Map<String, Object> parametersItem) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * Get parameters
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Map<String, Object>> getParameters() {
        return parameters;
    }
    public void setParameters(List<Map<String, Object>> parameters) {
        this.parameters = parameters;
    }

    public TransformOperation schemas(List<JsonElement> schemas) {
        this.schemas = schemas;
        return this;
    }

    public TransformOperation addSchemasItem(JsonElement schemasItem) {
        if (this.schemas == null) {
            this.schemas = new ArrayList<>();
        }
        this.schemas.add(schemasItem);
        return this;
    }

    /**
     * Get schemas
     * @return schemas
     **/
    @javax.annotation.Nullable
    @JsonProperty("schemas")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<JsonElement> getSchemas() {
        return schemas;
    }
    public void setSchemas(List<JsonElement> schemas) {
        this.schemas = schemas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransformOperation transformOperation = (TransformOperation) o;
        return Objects.equals(this.operationType, transformOperation.operationType) &&
                Objects.equals(this.parameters, transformOperation.parameters) &&
                Objects.equals(this.schemas, transformOperation.schemas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, parameters, schemas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransformOperation {\n");
        sb.append("    operationType: ").append(toIndentedString(operationType)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
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
