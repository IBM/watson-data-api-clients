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
import com.ibm.watson.data.client.model.CustomFieldAssetEntity;

import java.io.IOException;

/**
 * Custom serialization for CustomfieldAssetEntities.
 */
public class CustomFieldAssetEntitySerializer extends StdSerializer<CustomFieldAssetEntity> {

    public CustomFieldAssetEntitySerializer() {
        super(CustomFieldAssetEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialize(CustomFieldAssetEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        gen.writeObject(value.getFields());
    }

}
