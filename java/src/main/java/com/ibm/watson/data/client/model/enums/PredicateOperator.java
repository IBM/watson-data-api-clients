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

/**
 * The operator to use in a predicate.
 */
public enum PredicateOperator {

    EQUALS("EQUALS"),

    GREATER_THAN("GREATER_THAN"),

    LESS_THAN("LESS_THAN"),

    EXISTS("EXISTS"),

    CONTAINS("CONTAINS"),

    GREATER_THAN_EQUALS("GREATER_THAN_EQUALS"),

    LESS_THAN_EQUALS("LESS_THAN_EQUALS"),

    LIKE("LIKE");

    private String value;

    PredicateOperator(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static PredicateOperator fromValue(String value) {
        for (PredicateOperator b : PredicateOperator.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

}
