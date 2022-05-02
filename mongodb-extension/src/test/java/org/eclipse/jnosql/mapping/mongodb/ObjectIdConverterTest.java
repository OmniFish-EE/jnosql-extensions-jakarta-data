/*
 *  Copyright (c) 2022 Otávio Santana and others
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package org.eclipse.jnosql.mapping.mongodb;

import jakarta.nosql.mapping.AttributeConverter;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectIdConverterTest {

    private AttributeConverter<String, ObjectId> converter;

    @BeforeEach
    public void setUp() {
        this.converter = new ObjectIdConverter();
    }

    @Test
    public void shouldReturnNullWhenAttributeIsNull() {

    }

    @Test
    public void shouldReturnNullWhenDataIsNull() {

    }

    @Test
    public void shouldConvertToEntity() {

    }

    @Test
    public void shouldConvertToDatabase() {

    }
}