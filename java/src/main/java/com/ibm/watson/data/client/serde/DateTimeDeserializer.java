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
package com.ibm.watson.data.client.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Custom deserialization for Dates, to handle deserialization
 * across timestamps that include and do not include millisecond-level detail (which can vary even
 * in the same object, depending on the underlying source of that object's data).
 */
public class DateTimeDeserializer extends StdDeserializer<Date> {

    protected DateTimeDeserializer() {
        super(Date.class);
    }

    public static final DateFormat DATE_FORMAT_MILLI = createDateFormatMilli();
    private static DateFormat createDateFormatMilli() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format;
    }

    public static final DateFormat DATE_FORMAT_SECONDS = createDateFormatSeconds();
    private static DateFormat createDateFormatSeconds() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText();
        try {
            if (date.contains(".")) {
                // If there is a '.' in the timestamp, then it's a separator between second and milli-seconds
                return DATE_FORMAT_MILLI.parse(date);
            } else {
                // Otherwise we only have a timestamp down to seconds-level detail
                return DATE_FORMAT_SECONDS.parse(date);
            }
        } catch (ParseException e) {
            throw new IOException("Unable to parse date and time: " + date, e);
        }
    }

}
