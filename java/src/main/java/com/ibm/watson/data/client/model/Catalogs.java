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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A list of catalogs.
 */
public class Catalogs {

    private List<Catalog> catalogs = null;
    private String nextBookmark;
    private Integer nextSkip;

    public Catalogs catalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
        return this;
    }

    public Catalogs addCatalogsItem(Catalog catalogsItem) {
        if (this.catalogs == null) {
            this.catalogs = new ArrayList<>();
        }
        this.catalogs.add(catalogsItem);
        return this;
    }

    /**
     * A list of catalogs returned in the query results.
     * @return catalogs
     **/
    @javax.annotation.Nullable
    @JsonProperty("catalogs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Catalog> getCatalogs() { return catalogs; }
    public void setCatalogs(List<Catalog> catalogs) { this.catalogs = catalogs; }

    public Catalogs nextBookmark(String nextBookmark) {
        this.nextBookmark = nextBookmark;
        return this;
    }

    /**
     * The next bookmark for returned query results.
     * @return nextBookmark
     **/
    @javax.annotation.Nullable
    @JsonProperty("nextBookmark")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getNextBookmark() { return nextBookmark; }
    public void setNextBookmark(String nextBookmark) { this.nextBookmark = nextBookmark; }

    public Catalogs nextSkip(Integer nextSkip) {
        this.nextSkip = nextSkip;
        return this;
    }

    /**
     * The next result to skip in the returned query results.
     * @return nextSkip
     */
    @javax.annotation.Nullable
    @JsonProperty("nextSkip")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getNextSkip() { return nextSkip; }
    public void setNextSkip(Integer nextSkip) { this.nextSkip = nextSkip; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Catalogs catalogs = (Catalogs)o;
        return Objects.equals(this.catalogs, catalogs.catalogs) &&
                Objects.equals(this.nextBookmark, catalogs.nextBookmark) &&
                Objects.equals(this.nextSkip, catalogs.nextSkip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogs, nextBookmark, nextSkip);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Catalogs {\n");
        sb.append("    catalogs: ").append(toIndentedString(catalogs)).append("\n");
        sb.append("    nextBookmark: ").append(toIndentedString(nextBookmark)).append("\n");
        sb.append("    nextSkip: ").append(toIndentedString(nextSkip)).append("\n");
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
