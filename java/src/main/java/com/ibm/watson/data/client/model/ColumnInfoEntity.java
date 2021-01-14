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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ibm.watson.data.client.serde.ColumnInfoEntitySerializer;

import java.util.Map;
import java.util.Objects;

/**
 * ColumnInfoEntity
 */
@JsonSerialize(using = ColumnInfoEntitySerializer.class)
@JsonDeserialize(using = JsonDeserializer.None.class)
public class ColumnInfoEntity extends AbstractAssetEntity {

    @JsonIgnore
    private Map<String, ColumnInfoDetails> fields;

    @JsonIgnore
    public Map<String, ColumnInfoDetails> getFields() { return fields; }
    public void setFields(Map<String, ColumnInfoDetails> fields) { this.fields = fields; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnInfoEntity that = (ColumnInfoEntity) o;
        return Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ColumnInfoEntity {\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
