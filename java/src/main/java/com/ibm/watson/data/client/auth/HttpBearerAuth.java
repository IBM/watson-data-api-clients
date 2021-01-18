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
package com.ibm.watson.data.client.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

/**
 * For Bearer token-based authentication.
 */
public class HttpBearerAuth implements Authentication {

    private final String scheme;
    private String bearerToken;

    /**
     * Construct a new bearer token for the specified scheme
     * @param scheme for the authentication (usually just 'Bearer')
     */
    public HttpBearerAuth(String scheme) { this.scheme = scheme; }

    /**
     * Retrieve the bearer token
     * @return String
     */
    public String getBearerToken() { return bearerToken; }

    /**
     * Set the bearer token to the provided value
     * @param bearerToken to set
     */
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyToParams(MultiValueMap<String, String> queryParams,
                              HttpHeaders headerParams,
                              MultiValueMap<String, String> cookieParams) {
        if (bearerToken == null) {
            return;
        }
        headerParams.add(HttpHeaders.AUTHORIZATION,
                (scheme != null ? upperCaseBearer(scheme) + " " : "") +
                        bearerToken);
    }

    private static String upperCaseBearer(String scheme) {
        return ("bearer".equalsIgnoreCase(scheme)) ? "Bearer" : scheme;
    }

}
