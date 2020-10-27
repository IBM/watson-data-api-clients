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
 * Locale
 */
public class Locale {

    private String language;
    private String script;
    private String country;
    private String variant;
    private List<String> extensionKeys = null;
    private List<String> unicodeLocaleAttributes = null;
    private List<String> unicodeLocaleKeys = null;
    private String iso3Language;
    private String iso3Country;
    private String displayLanguage;
    private String displayScript;
    private String displayCountry;
    private String displayVariant;
    private String displayName;

    public Locale language(String language) {
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
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Locale script(String script) {
        this.script = script;
        return this;
    }

    /**
     * Get script
     * @return script
     **/
    @javax.annotation.Nullable
    @JsonProperty("script")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getScript() { return script; }
    public void setScript(String script) { this.script = script; }

    public Locale country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     * @return country
     **/
    @javax.annotation.Nullable
    @JsonProperty("country")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Locale variant(String variant) {
        this.variant = variant;
        return this;
    }

    /**
     * Get variant
     * @return variant
     **/
    @javax.annotation.Nullable
    @JsonProperty("variant")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVariant() { return variant; }
    public void setVariant(String variant) { this.variant = variant; }

    public Locale extensionKeys(List<String> extensionKeys) {
        this.extensionKeys = extensionKeys;
        return this;
    }

    public Locale addExtensionKeysItem(String extensionKeysItem) {
        if (this.extensionKeys == null) {
            this.extensionKeys = new ArrayList<>();
        }
        this.extensionKeys.add(extensionKeysItem);
        return this;
    }

    /**
     * Get extensionKeys
     * @return extensionKeys
     **/
    @javax.annotation.Nullable
    @JsonProperty("extensionKeys")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getExtensionKeys() { return extensionKeys; }
    public void setExtensionKeys(List<String> extensionKeys) { this.extensionKeys = extensionKeys; }

    public Locale unicodeLocaleAttributes(List<String> unicodeLocaleAttributes) {
        this.unicodeLocaleAttributes = unicodeLocaleAttributes;
        return this;
    }

    public Locale addUnicodeLocaleAttributesItem(String unicodeLocaleAttributesItem) {
        if (this.unicodeLocaleAttributes == null) {
            this.unicodeLocaleAttributes = new ArrayList<>();
        }
        this.unicodeLocaleAttributes.add(unicodeLocaleAttributesItem);
        return this;
    }

    /**
     * Get unicodeLocaleAttributes
     * @return unicodeLocaleAttributes
     **/
    @javax.annotation.Nullable
    @JsonProperty("unicodeLocaleAttributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getUnicodeLocaleAttributes() { return unicodeLocaleAttributes; }
    public void setUnicodeLocaleAttributes(List<String> unicodeLocaleAttributes) { this.unicodeLocaleAttributes = unicodeLocaleAttributes; }

    public Locale unicodeLocaleKeys(List<String> unicodeLocaleKeys) {
        this.unicodeLocaleKeys = unicodeLocaleKeys;
        return this;
    }

    public Locale addUnicodeLocaleKeysItem(String unicodeLocaleKeysItem) {
        if (this.unicodeLocaleKeys == null) {
            this.unicodeLocaleKeys = new ArrayList<>();
        }
        this.unicodeLocaleKeys.add(unicodeLocaleKeysItem);
        return this;
    }

    /**
     * Get unicodeLocaleKeys
     * @return unicodeLocaleKeys
     **/
    @javax.annotation.Nullable
    @JsonProperty("unicodeLocaleKeys")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getUnicodeLocaleKeys() { return unicodeLocaleKeys; }
    public void setUnicodeLocaleKeys(List<String> unicodeLocaleKeys) { this.unicodeLocaleKeys = unicodeLocaleKeys; }

    public Locale iso3Language(String iso3Language) {
        this.iso3Language = iso3Language;
        return this;
    }

    /**
     * Get iso3Language
     * @return iso3Language
     **/
    @javax.annotation.Nullable
    @JsonProperty("iso3Language")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getIso3Language() { return iso3Language; }
    public void setIso3Language(String iso3Language) { this.iso3Language = iso3Language; }

    public Locale iso3Country(String iso3Country) {
        this.iso3Country = iso3Country;
        return this;
    }

    /**
     * Get iso3Country
     * @return iso3Country
     **/
    @javax.annotation.Nullable
    @JsonProperty("iso3Country")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getIso3Country() { return iso3Country; }
    public void setIso3Country(String iso3Country) { this.iso3Country = iso3Country; }

    public Locale displayLanguage(String displayLanguage) {
        this.displayLanguage = displayLanguage;
        return this;
    }

    /**
     * Get displayLanguage
     * @return displayLanguage
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayLanguage")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayLanguage() { return displayLanguage; }
    public void setDisplayLanguage(String displayLanguage) { this.displayLanguage = displayLanguage; }

    public Locale displayScript(String displayScript) {
        this.displayScript = displayScript;
        return this;
    }

    /**
     * Get displayScript
     * @return displayScript
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayScript")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayScript() { return displayScript; }
    public void setDisplayScript(String displayScript) { this.displayScript = displayScript; }

    public Locale displayCountry(String displayCountry) {
        this.displayCountry = displayCountry;
        return this;
    }

    /**
     * Get displayCountry
     * @return displayCountry
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayCountry")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayCountry() { return displayCountry; }
    public void setDisplayCountry(String displayCountry) { this.displayCountry = displayCountry; }

    public Locale displayVariant(String displayVariant) {
        this.displayVariant = displayVariant;
        return this;
    }

    /**
     * Get displayVariant
     * @return displayVariant
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayVariant")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayVariant() { return displayVariant; }
    public void setDisplayVariant(String displayVariant) { this.displayVariant = displayVariant; }

    public Locale displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     * @return displayName
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Locale locale = (Locale)o;
        return Objects.equals(this.language, locale.language) &&
                Objects.equals(this.script, locale.script) &&
                Objects.equals(this.country, locale.country) &&
                Objects.equals(this.variant, locale.variant) &&
                Objects.equals(this.extensionKeys, locale.extensionKeys) &&
                Objects.equals(this.unicodeLocaleAttributes, locale.unicodeLocaleAttributes) &&
                Objects.equals(this.unicodeLocaleKeys, locale.unicodeLocaleKeys) &&
                Objects.equals(this.iso3Language, locale.iso3Language) &&
                Objects.equals(this.iso3Country, locale.iso3Country) &&
                Objects.equals(this.displayLanguage, locale.displayLanguage) &&
                Objects.equals(this.displayScript, locale.displayScript) &&
                Objects.equals(this.displayCountry, locale.displayCountry) &&
                Objects.equals(this.displayVariant, locale.displayVariant) &&
                Objects.equals(this.displayName, locale.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, script, country, variant, extensionKeys,
                unicodeLocaleAttributes, unicodeLocaleKeys,
                iso3Language, iso3Country, displayLanguage,
                displayScript, displayCountry, displayVariant,
                displayName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Locale {\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    script: ").append(toIndentedString(script)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
        sb.append("    extensionKeys: ").append(toIndentedString(extensionKeys)).append("\n");
        sb.append("    unicodeLocaleAttributes: ").append(toIndentedString(unicodeLocaleAttributes)).append("\n");
        sb.append("    unicodeLocaleKeys: ").append(toIndentedString(unicodeLocaleKeys)).append("\n");
        sb.append("    iso3Language: ").append(toIndentedString(iso3Language)).append("\n");
        sb.append("    iso3Country: ").append(toIndentedString(iso3Country)).append("\n");
        sb.append("    displayLanguage: ").append(toIndentedString(displayLanguage)).append("\n");
        sb.append("    displayScript: ").append(toIndentedString(displayScript)).append("\n");
        sb.append("    displayCountry: ").append(toIndentedString(displayCountry)).append("\n");
        sb.append("    displayVariant: ").append(toIndentedString(displayVariant)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
