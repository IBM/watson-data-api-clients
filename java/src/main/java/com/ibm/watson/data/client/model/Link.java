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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Link
 */
public class Link {

    private URI uri;
    private Object uriBuilder;
    private String rel;
    private List<String> rels = null;
    private String title;
    private String type;
    private Map<String, String> params = null;

    public Link uri(URI uri) {
        this.uri = uri;
        return this;
    }

    /**
     * Get uri
     * @return uri
     **/
    @javax.annotation.Nullable
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public URI getUri() { return uri; }
    public void setUri(URI uri) { this.uri = uri; }

    public Link uriBuilder(Object uriBuilder) {
        this.uriBuilder = uriBuilder;
        return this;
    }

    /**
     * Get uriBuilder
     * @return uriBuilder
     **/
    @javax.annotation.Nullable
    @JsonProperty("uriBuilder")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getUriBuilder() { return uriBuilder; }
    public void setUriBuilder(Object uriBuilder) { this.uriBuilder = uriBuilder; }

    public Link rel(String rel) {
        this.rel = rel;
        return this;
    }

    /**
     * Get rel
     * @return rel
     **/
    @javax.annotation.Nullable
    @JsonProperty("rel")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRel() { return rel; }
    public void setRel(String rel) { this.rel = rel; }

    public Link rels(List<String> rels) {
        this.rels = rels;
        return this;
    }

    public Link addRelsItem(String relsItem) {
        if (this.rels == null) {
            this.rels = new ArrayList<>();
        }
        this.rels.add(relsItem);
        return this;
    }

    /**
     * Get rels
     * @return rels
     **/
    @javax.annotation.Nullable
    @JsonProperty("rels")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRels() { return rels; }
    public void setRels(List<String> rels) { this.rels = rels; }

    public Link title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     * @return title
     **/
    @javax.annotation.Nullable
    @JsonProperty("title")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Link type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Link params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public Link putParamsItem(String key, String paramsItem) {
        if (this.params == null) {
            this.params = new HashMap<>();
        }
        this.params.put(key, paramsItem);
        return this;
    }

    /**
     * Get params
     * @return params
     **/
    @javax.annotation.Nullable
    @JsonProperty("params")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, String> getParams() { return params; }
    public void setParams(Map<String, String> params) { this.params = params; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Link link = (Link)o;
        return Objects.equals(this.uri, link.uri) &&
                Objects.equals(this.uriBuilder, link.uriBuilder) &&
                Objects.equals(this.rel, link.rel) &&
                Objects.equals(this.rels, link.rels) &&
                Objects.equals(this.title, link.title) &&
                Objects.equals(this.type, link.type) &&
                Objects.equals(this.params, link.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, uriBuilder, rel, rels, title, type, params);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Link {\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
        sb.append("    uriBuilder: ").append(toIndentedString(uriBuilder)).append("\n");
        sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
        sb.append("    rels: ").append(toIndentedString(rels)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    params: ").append(toIndentedString(params)).append("\n");
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
