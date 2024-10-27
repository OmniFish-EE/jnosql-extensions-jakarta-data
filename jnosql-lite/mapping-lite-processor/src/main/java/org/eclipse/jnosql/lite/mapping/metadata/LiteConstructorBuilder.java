/*
 *  Copyright (c) 2024 Contributors to the Eclipse Foundation
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
package org.eclipse.jnosql.lite.mapping.metadata;

import org.eclipse.jnosql.mapping.metadata.ConstructorBuilder;
import org.eclipse.jnosql.mapping.metadata.ParameterMetaData;

import java.util.ArrayList;
import java.util.List;

public class LiteConstructorBuilder implements ConstructorBuilder {

    private final LiteConstructorMetadata metadata;

    private final List<Object> values = new ArrayList<>();

    public LiteConstructorBuilder(LiteConstructorMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public List<ParameterMetaData> parameters() {
        return metadata.parameters();
    }

    @Override
    public void add(Object value) {
        this.values.add(value);
    }

    @Override
    public void addEmptyParameter() {
        this.values.add(null);
    }

    @Override
    public <T> T build() {
        return metadata.build(values.toArray());
    }
}
