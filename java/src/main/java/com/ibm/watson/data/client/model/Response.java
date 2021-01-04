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
import java.net.URI;
import java.util.*;

/**
 * Response
 */
public class Response {

    private Integer status;
    private StatusType statusInfo;
    private Object entity;
    private MediaType mediaType;
    private Locale language;
    private Integer length;
    private List<String> allowedMethods = null;
    private Map<String, NewCookie> cookies = null;
    private EntityTag entityTag;
    private Date date;
    private Date lastModified;
    private URI location;
    private List<Link> links = null;
    private Map<String, List<Object>> metadata = null;
    private Map<String, List<Object>> headers = null;
    private Map<String, List<String>> stringHeaders = null;

    public Response status(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Response statusInfo(StatusType statusInfo) {
        this.statusInfo = statusInfo;
        return this;
    }

    /**
     * Get statusInfo
     * @return statusInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("statusInfo")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public StatusType getStatusInfo() { return statusInfo; }
    public void setStatusInfo(StatusType statusInfo) { this.statusInfo = statusInfo; }

    public Response entity(Object entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Get entity
     * @return entity
     **/
    @javax.annotation.Nullable
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getEntity() { return entity; }
    public void setEntity(Object entity) { this.entity = entity; }

    public Response mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    /**
     * Get mediaType
     * @return mediaType
     **/
    @javax.annotation.Nullable
    @JsonProperty("mediaType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MediaType getMediaType() { return mediaType; }
    public void setMediaType(MediaType mediaType) { this.mediaType = mediaType; }

    public Response language(Locale language) {
        this.language = language;
        return this;
    }

    /**
     * Get language
     * @return language
     **/
    @javax.annotation.Nullable
    @JsonProperty("language")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Locale getLanguage() { return language; }
    public void setLanguage(Locale language) { this.language = language; }

    public Response length(Integer length) {
        this.length = length;
        return this;
    }

    /**
     * Get length
     * @return length
     **/
    @javax.annotation.Nullable
    @JsonProperty("length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getLength() { return length; }
    public void setLength(Integer length) { this.length = length; }

    public Response allowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
        return this;
    }

    public Response addAllowedMethodsItem(String allowedMethodsItem) {
        if (this.allowedMethods == null) {
            this.allowedMethods = new ArrayList<>();
        }
        this.allowedMethods.add(allowedMethodsItem);
        return this;
    }

    /**
     * Get allowedMethods
     * @return allowedMethods
     **/
    @javax.annotation.Nullable
    @JsonProperty("allowedMethods")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAllowedMethods() { return allowedMethods; }
    public void setAllowedMethods(List<String> allowedMethods) { this.allowedMethods = allowedMethods; }

    public Response cookies(Map<String, NewCookie> cookies) {
        this.cookies = cookies;
        return this;
    }

    public Response putCookiesItem(String key, NewCookie cookiesItem) {
        if (this.cookies == null) {
            this.cookies = new HashMap<>();
        }
        this.cookies.put(key, cookiesItem);
        return this;
    }

    /**
     * Get cookies
     * @return cookies
     **/
    @javax.annotation.Nullable
    @JsonProperty("cookies")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, NewCookie> getCookies() { return cookies; }
    public void setCookies(Map<String, NewCookie> cookies) { this.cookies = cookies; }

    public Response entityTag(EntityTag entityTag) {
        this.entityTag = entityTag;
        return this;
    }

    /**
     * Get entityTag
     * @return entityTag
     **/
    @javax.annotation.Nullable
    @JsonProperty("entityTag")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public EntityTag getEntityTag() { return entityTag; }
    public void setEntityTag(EntityTag entityTag) { this.entityTag = entityTag; }

    public Response date(Date date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     * @return date
     **/
    @javax.annotation.Nullable
    @JsonProperty("date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Response lastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    /**
     * Get lastModified
     * @return lastModified
     **/
    @javax.annotation.Nullable
    @JsonProperty("lastModified")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getLastModified() { return lastModified; }
    public void setLastModified(Date lastModified) { this.lastModified = lastModified; }

    public Response location(URI location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     * @return location
     **/
    @javax.annotation.Nullable
    @JsonProperty("location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public URI getLocation() { return location; }
    public void setLocation(URI location) { this.location = location; }

    public Response links(List<Link> links) {
        this.links = links;
        return this;
    }

    public Response addLinksItem(Link linksItem) {
        if (this.links == null) {
            this.links = new ArrayList<>();
        }
        this.links.add(linksItem);
        return this;
    }

    /**
     * Get links
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty("links")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Link> getLinks() { return links; }
    public void setLinks(List<Link> links) { this.links = links; }

    public Response metadata(Map<String, List<Object>> metadata) {
        this.metadata = metadata;
        return this;
    }

    public Response putMetadataItem(String key, List<Object> metadataItem) {
        if (this.metadata == null) {
            this.metadata = new HashMap<>();
        }
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @javax.annotation.Nullable
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, List<Object>> getMetadata() { return metadata; }
    public void setMetadata(Map<String, List<Object>> metadata) { this.metadata = metadata; }

    public Response headers(Map<String, List<Object>> headers) {
        this.headers = headers;
        return this;
    }

    public Response putHeadersItem(String key, List<Object> headersItem) {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(key, headersItem);
        return this;
    }

    /**
     * Get headers
     * @return headers
     **/
    @javax.annotation.Nullable
    @JsonProperty("headers")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, List<Object>> getHeaders() { return headers; }
    public void setHeaders(Map<String, List<Object>> headers) { this.headers = headers; }

    public Response stringHeaders(Map<String, List<String>> stringHeaders) {
        this.stringHeaders = stringHeaders;
        return this;
    }

    public Response putStringHeadersItem(String key, List<String> stringHeadersItem) {
        if (this.stringHeaders == null) {
            this.stringHeaders = new HashMap<>();
        }
        this.stringHeaders.put(key, stringHeadersItem);
        return this;
    }

    /**
     * Get stringHeaders
     * @return stringHeaders
     **/
    @javax.annotation.Nullable
    @JsonProperty("stringHeaders")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, List<String>> getStringHeaders() { return stringHeaders; }
    public void setStringHeaders(Map<String, List<String>> stringHeaders) { this.stringHeaders = stringHeaders; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Response response = (Response)o;
        return Objects.equals(this.status, response.status) &&
                Objects.equals(this.statusInfo, response.statusInfo) &&
                Objects.equals(this.entity, response.entity) &&
                Objects.equals(this.mediaType, response.mediaType) &&
                Objects.equals(this.language, response.language) &&
                Objects.equals(this.length, response.length) &&
                Objects.equals(this.allowedMethods, response.allowedMethods) &&
                Objects.equals(this.cookies, response.cookies) &&
                Objects.equals(this.entityTag, response.entityTag) &&
                Objects.equals(this.date, response.date) &&
                Objects.equals(this.lastModified, response.lastModified) &&
                Objects.equals(this.location, response.location) &&
                Objects.equals(this.links, response.links) &&
                Objects.equals(this.metadata, response.metadata) &&
                Objects.equals(this.headers, response.headers) &&
                Objects.equals(this.stringHeaders, response.stringHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, statusInfo, entity, mediaType, language, length,
                allowedMethods, cookies, entityTag, date, lastModified,
                location, links, metadata, headers, stringHeaders);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Response {\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusInfo: ").append(toIndentedString(statusInfo)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    allowedMethods: ").append(toIndentedString(allowedMethods)).append("\n");
        sb.append("    cookies: ").append(toIndentedString(cookies)).append("\n");
        sb.append("    entityTag: ").append(toIndentedString(entityTag)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
        sb.append("    stringHeaders: ").append(toIndentedString(stringHeaders)).append("\n");
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
