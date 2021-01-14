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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Custom serialization for Dates, to handle the variations that exist in the API endpoints
 * and underlying meta-model, where some dates have millisecond-level detail and others do not.
 */
public class DateTimeSerializer extends StdSerializer<Date> {

    protected DateTimeSerializer(DateFormat dateFormat) {
        super(Date.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        gen.writeString(DateTimeDeserializer.DATE_FORMAT_MILLI.format(value));
    }

}
