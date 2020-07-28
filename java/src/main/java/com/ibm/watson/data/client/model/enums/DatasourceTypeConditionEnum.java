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
package com.ibm.watson.data.client.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DatasourceTypeConditionEnum {

    CONTAINS("contains"),

    ENDSWITH("endswith"),

    EQUALS("equals"),

    IN("in"),

    MATCHES("matches"),

    NOT_CONTAINS("not_contains"),

    NOT_ENDSWITH("not_endswith"),

    NOT_EQUALS("not_equals"),

    NOT_IN("not_in"),

    NOT_MATCHES("not_matches"),

    NOT_SET("not_set"),

    NOT_STARTSWITH("not_startswith"),

    SET("set"),

    STARTSWITH("startswith");

    private String value;

    DatasourceTypeConditionEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static DatasourceTypeConditionEnum fromValue(String value) {
        for (DatasourceTypeConditionEnum b : DatasourceTypeConditionEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

}
