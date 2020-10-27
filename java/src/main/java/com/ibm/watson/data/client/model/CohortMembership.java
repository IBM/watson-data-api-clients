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
 * CohortMembership
 */
public class CohortMembership {

    private MemberRegistration localRegistration;
    private List<MemberRegistration> remoteRegistrations = null;

    public CohortMembership localRegistration(MemberRegistration localRegistration) {
        this.localRegistration = localRegistration;
        return this;
    }

    /**
     * Get localRegistration
     * @return localRegistration
     **/
    @javax.annotation.Nullable
    @JsonProperty("localRegistration")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public MemberRegistration getLocalRegistration() { return localRegistration; }
    public void setLocalRegistration(MemberRegistration localRegistration) { this.localRegistration = localRegistration; }

    public CohortMembership remoteRegistrations(List<MemberRegistration> remoteRegistrations) {
        this.remoteRegistrations = remoteRegistrations;
        return this;
    }

    public CohortMembership addRemoteRegistrationsItem(MemberRegistration remoteRegistrationsItem) {
        if (this.remoteRegistrations == null) {
            this.remoteRegistrations = new ArrayList<>();
        }
        this.remoteRegistrations.add(remoteRegistrationsItem);
        return this;
    }

    /**
     * Get remoteRegistrations
     * @return remoteRegistrations
     **/
    @javax.annotation.Nullable
    @JsonProperty("remoteRegistrations")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<MemberRegistration> getRemoteRegistrations() { return remoteRegistrations; }
    public void setRemoteRegistrations(List<MemberRegistration> remoteRegistrations) { this.remoteRegistrations = remoteRegistrations; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CohortMembership cohortMembership = (CohortMembership)o;
        return Objects.equals(this.localRegistration, cohortMembership.localRegistration) &&
                Objects.equals(this.remoteRegistrations, cohortMembership.remoteRegistrations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localRegistration, remoteRegistrations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CohortMembership {\n");
        sb.append("    localRegistration: ").append(toIndentedString(localRegistration)).append("\n");
        sb.append("    remoteRegistrations: ").append(toIndentedString(remoteRegistrations)).append("\n");
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
