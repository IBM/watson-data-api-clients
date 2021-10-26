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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * JsonElement
 */
public class JsonElement {

    private Boolean jsonArray;
    private JsonElement asJsonNull;
    private Boolean jsonObject;
    private Object asNumber;
    private Double asDouble;
    private Float asFloat;
    private Integer asInt;
    private byte[] asByte;
    private String asCharacter;
    private BigDecimal asBigDecimal;
    private Integer asBigInteger;
    private Integer asShort;
    private Boolean jsonNull;
    private Boolean jsonPrimitive;
    private Boolean asBoolean;
    private JsonElement asJsonObject;
    private JsonElement asJsonArray;
    private JsonPrimitive asJsonPrimitive;
    private Long asLong;
    private String asString;

    public JsonElement jsonArray(Boolean jsonArray) {
        this.jsonArray = jsonArray;
        return this;
    }

    /**
     * Get jsonArray
     * @return jsonArray
     **/
    @javax.annotation.Nullable
    @JsonProperty("jsonArray")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getJsonArray() {
        return jsonArray;
    }
    public void setJsonArray(Boolean jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JsonElement asJsonNull(JsonElement asJsonNull) {
        this.asJsonNull = asJsonNull;
        return this;
    }

    /**
     * Get asJsonNull
     * @return asJsonNull
     **/
    @javax.annotation.Nullable
    @JsonProperty("asJsonNull")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JsonElement getAsJsonNull() {
        return asJsonNull;
    }
    public void setAsJsonNull(JsonElement asJsonNull) {
        this.asJsonNull = asJsonNull;
    }

    public JsonElement jsonObject(Boolean jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    /**
     * Get jsonObject
     * @return jsonObject
     **/
    @javax.annotation.Nullable
    @JsonProperty("jsonObject")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getJsonObject() {
        return jsonObject;
    }
    public void setJsonObject(Boolean jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonElement asNumber(Object asNumber) {
        this.asNumber = asNumber;
        return this;
    }

    /**
     * Get asNumber
     * @return asNumber
     **/
    @javax.annotation.Nullable
    @JsonProperty("asNumber")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getAsNumber() {
        return asNumber;
    }
    public void setAsNumber(Object asNumber) {
        this.asNumber = asNumber;
    }

    public JsonElement asDouble(Double asDouble) {
        this.asDouble = asDouble;
        return this;
    }

    /**
     * Get asDouble
     * @return asDouble
     **/
    @javax.annotation.Nullable
    @JsonProperty("asDouble")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getAsDouble() {
        return asDouble;
    }
    public void setAsDouble(Double asDouble) {
        this.asDouble = asDouble;
    }

    public JsonElement asFloat(Float asFloat) {
        this.asFloat = asFloat;
        return this;
    }

    /**
     * Get asFloat
     * @return asFloat
     **/
    @javax.annotation.Nullable
    @JsonProperty("asFloat")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Float getAsFloat() {
        return asFloat;
    }
    public void setAsFloat(Float asFloat) {
        this.asFloat = asFloat;
    }

    public JsonElement asInt(Integer asInt) {
        this.asInt = asInt;
        return this;
    }

    /**
     * Get asInt
     * @return asInt
     **/
    @javax.annotation.Nullable
    @JsonProperty("asInt")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getAsInt() {
        return asInt;
    }
    public void setAsInt(Integer asInt) {
        this.asInt = asInt;
    }

    public JsonElement asByte(byte[] asByte) {
        this.asByte = asByte;
        return this;
    }

    /**
     * Get asByte
     * @return asByte
     **/
    @javax.annotation.Nullable
    @JsonProperty("asByte")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public byte[] getAsByte() {
        return asByte;
    }
    public void setAsByte(byte[] asByte) {
        this.asByte = asByte;
    }

    public JsonElement asCharacter(String asCharacter) {
        this.asCharacter = asCharacter;
        return this;
    }

    /**
     * Get asCharacter
     * @return asCharacter
     **/
    @javax.annotation.Nullable
    @JsonProperty("asCharacter")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAsCharacter() {
        return asCharacter;
    }
    public void setAsCharacter(String asCharacter) {
        this.asCharacter = asCharacter;
    }

    public JsonElement asBigDecimal(BigDecimal asBigDecimal) {
        this.asBigDecimal = asBigDecimal;
        return this;
    }

    /**
     * Get asBigDecimal
     * @return asBigDecimal
     **/
    @javax.annotation.Nullable
    @JsonProperty("asBigDecimal")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getAsBigDecimal() {
        return asBigDecimal;
    }
    public void setAsBigDecimal(BigDecimal asBigDecimal) {
        this.asBigDecimal = asBigDecimal;
    }

    public JsonElement asBigInteger(Integer asBigInteger) {
        this.asBigInteger = asBigInteger;
        return this;
    }

    /**
     * Get asBigInteger
     * @return asBigInteger
     **/
    @javax.annotation.Nullable
    @JsonProperty("asBigInteger")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getAsBigInteger() {
        return asBigInteger;
    }
    public void setAsBigInteger(Integer asBigInteger) {
        this.asBigInteger = asBigInteger;
    }

    public JsonElement asShort(Integer asShort) {
        this.asShort = asShort;
        return this;
    }

    /**
     * Get asShort
     * @return asShort
     **/
    @javax.annotation.Nullable
    @JsonProperty("asShort")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getAsShort() {
        return asShort;
    }
    public void setAsShort(Integer asShort) {
        this.asShort = asShort;
    }

    public JsonElement jsonNull(Boolean jsonNull) {
        this.jsonNull = jsonNull;
        return this;
    }

    /**
     * Get jsonNull
     * @return jsonNull
     **/
    @javax.annotation.Nullable
    @JsonProperty("jsonNull")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getJsonNull() {
        return jsonNull;
    }
    public void setJsonNull(Boolean jsonNull) {
        this.jsonNull = jsonNull;
    }

    public JsonElement jsonPrimitive(Boolean jsonPrimitive) {
        this.jsonPrimitive = jsonPrimitive;
        return this;
    }

    /**
     * Get jsonPrimitive
     * @return jsonPrimitive
     **/
    @javax.annotation.Nullable
    @JsonProperty("jsonPrimitive")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getJsonPrimitive() {
        return jsonPrimitive;
    }
    public void setJsonPrimitive(Boolean jsonPrimitive) {
        this.jsonPrimitive = jsonPrimitive;
    }

    public JsonElement asBoolean(Boolean asBoolean) {
        this.asBoolean = asBoolean;
        return this;
    }

    /**
     * Get asBoolean
     * @return asBoolean
     **/
    @javax.annotation.Nullable
    @JsonProperty("asBoolean")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAsBoolean() {
        return asBoolean;
    }
    public void setAsBoolean(Boolean asBoolean) {
        this.asBoolean = asBoolean;
    }

    public JsonElement asJsonObject(JsonElement asJsonObject) {
        this.asJsonObject = asJsonObject;
        return this;
    }

    /**
     * Get asJsonObject
     * @return asJsonObject
     **/
    @javax.annotation.Nullable
    @JsonProperty("asJsonObject")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JsonElement getAsJsonObject() {
        return asJsonObject;
    }
    public void setAsJsonObject(JsonElement asJsonObject) {
        this.asJsonObject = asJsonObject;
    }

    public JsonElement asJsonArray(JsonElement asJsonArray) {
        this.asJsonArray = asJsonArray;
        return this;
    }

    /**
     * Get asJsonArray
     * @return asJsonArray
     **/
    @javax.annotation.Nullable
    @JsonProperty("asJsonArray")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JsonElement getAsJsonArray() {
        return asJsonArray;
    }
    public void setAsJsonArray(JsonElement asJsonArray) {
        this.asJsonArray = asJsonArray;
    }

    public JsonElement asJsonPrimitive(JsonPrimitive asJsonPrimitive) {
        this.asJsonPrimitive = asJsonPrimitive;
        return this;
    }

    /**
     * Get asJsonPrimitive
     * @return asJsonPrimitive
     **/
    @javax.annotation.Nullable
    @JsonProperty("asJsonPrimitive")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public JsonPrimitive getAsJsonPrimitive() {
        return asJsonPrimitive;
    }
    public void setAsJsonPrimitive(JsonPrimitive asJsonPrimitive) {
        this.asJsonPrimitive = asJsonPrimitive;
    }

    public JsonElement asLong(Long asLong) {
        this.asLong = asLong;
        return this;
    }

    /**
     * Get asLong
     * @return asLong
     **/
    @javax.annotation.Nullable
    @JsonProperty("asLong")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getAsLong() {
        return asLong;
    }
    public void setAsLong(Long asLong) {
        this.asLong = asLong;
    }

    public JsonElement asString(String asString) {
        this.asString = asString;
        return this;
    }

    /**
     * Get asString
     * @return asString
     **/
    @javax.annotation.Nullable
    @JsonProperty("asString")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAsString() {
        return asString;
    }
    public void setAsString(String asString) {
        this.asString = asString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JsonElement jsonElement = (JsonElement) o;
        return Objects.equals(this.jsonArray, jsonElement.jsonArray) &&
                Objects.equals(this.asJsonNull, jsonElement.asJsonNull) &&
                Objects.equals(this.jsonObject, jsonElement.jsonObject) &&
                Objects.equals(this.asNumber, jsonElement.asNumber) &&
                Objects.equals(this.asDouble, jsonElement.asDouble) &&
                Objects.equals(this.asFloat, jsonElement.asFloat) &&
                Objects.equals(this.asInt, jsonElement.asInt) &&
                Arrays.equals(this.asByte, jsonElement.asByte) &&
                Objects.equals(this.asCharacter, jsonElement.asCharacter) &&
                Objects.equals(this.asBigDecimal, jsonElement.asBigDecimal) &&
                Objects.equals(this.asBigInteger, jsonElement.asBigInteger) &&
                Objects.equals(this.asShort, jsonElement.asShort) &&
                Objects.equals(this.jsonNull, jsonElement.jsonNull) &&
                Objects.equals(this.jsonPrimitive, jsonElement.jsonPrimitive) &&
                Objects.equals(this.asBoolean, jsonElement.asBoolean) &&
                Objects.equals(this.asJsonObject, jsonElement.asJsonObject) &&
                Objects.equals(this.asJsonArray, jsonElement.asJsonArray) &&
                Objects.equals(this.asJsonPrimitive, jsonElement.asJsonPrimitive) &&
                Objects.equals(this.asLong, jsonElement.asLong) &&
                Objects.equals(this.asString, jsonElement.asString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonArray, asJsonNull, jsonObject, asNumber, asDouble, asFloat, asInt, Arrays.hashCode(asByte), asCharacter, asBigDecimal, asBigInteger, asShort, jsonNull, jsonPrimitive, asBoolean, asJsonObject, asJsonArray, asJsonPrimitive, asLong, asString);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JsonElement {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    jsonArray: ").append(toIndentedString(jsonArray)).append("\n");
        sb.append("    asJsonNull: ").append(toIndentedString(asJsonNull)).append("\n");
        sb.append("    jsonObject: ").append(toIndentedString(jsonObject)).append("\n");
        sb.append("    asNumber: ").append(toIndentedString(asNumber)).append("\n");
        sb.append("    asDouble: ").append(toIndentedString(asDouble)).append("\n");
        sb.append("    asFloat: ").append(toIndentedString(asFloat)).append("\n");
        sb.append("    asInt: ").append(toIndentedString(asInt)).append("\n");
        sb.append("    asByte: ").append(toIndentedString(asByte)).append("\n");
        sb.append("    asCharacter: ").append(toIndentedString(asCharacter)).append("\n");
        sb.append("    asBigDecimal: ").append(toIndentedString(asBigDecimal)).append("\n");
        sb.append("    asBigInteger: ").append(toIndentedString(asBigInteger)).append("\n");
        sb.append("    asShort: ").append(toIndentedString(asShort)).append("\n");
        sb.append("    jsonNull: ").append(toIndentedString(jsonNull)).append("\n");
        sb.append("    jsonPrimitive: ").append(toIndentedString(jsonPrimitive)).append("\n");
        sb.append("    asBoolean: ").append(toIndentedString(asBoolean)).append("\n");
        sb.append("    asJsonObject: ").append(toIndentedString(asJsonObject)).append("\n");
        sb.append("    asJsonArray: ").append(toIndentedString(asJsonArray)).append("\n");
        sb.append("    asJsonPrimitive: ").append(toIndentedString(asJsonPrimitive)).append("\n");
        sb.append("    asLong: ").append(toIndentedString(asLong)).append("\n");
        sb.append("    asString: ").append(toIndentedString(asString)).append("\n");
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
