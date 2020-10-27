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
import java.util.Objects;

/**
 * Endpoint
 */
public class Endpoint extends BaseEntity {

    private String address;
    private String protocol;
    private String encryptionMethod;

    public Endpoint address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     * @return address
     **/
    @javax.annotation.Nullable
    @JsonProperty("address")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Endpoint protocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get protocol
     * @return protocol
     **/
    @javax.annotation.Nullable
    @JsonProperty("protocol")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public Endpoint encryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
        return this;
    }

    /**
     * Get encryptionMethod
     * @return encryptionMethod
     **/
    @javax.annotation.Nullable
    @JsonProperty("encryptionMethod")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEncryptionMethod() { return encryptionMethod; }
    public void setEncryptionMethod(String encryptionMethod) { this.encryptionMethod = encryptionMethod; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Endpoint endpoint = (Endpoint)o;
        return super.equals(o) &&
                Objects.equals(this.address, endpoint.address) &&
                Objects.equals(this.protocol, endpoint.protocol) &&
                Objects.equals(this.encryptionMethod, endpoint.encryptionMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, protocol, encryptionMethod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Endpoint {\n");
        super.toString(sb);
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    encryptionMethod: ").append(toIndentedString(encryptionMethod)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
