/*
 *  Copyright (c) 2024 Otávio Santana and others
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
package org.eclipse.jnsoql.entities;

import jakarta.data.metamodel.TextAttribute;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


class PersonTest {


    @Test
    void shouldGenerateStaticMetamodel() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(_Person.id).isNotNull();
            softly.assertThat(_Person.name).isNotNull();
        });
    }

    @Test
    void shouldCheckIdField() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(_Person.ID).isEqualTo("_id");
            softly.assertThat(_Person.id.name()).isEqualTo(_Person.ID);
            softly.assertThat(_Person.id).isInstanceOf(TextAttribute.class);
        });
    }

    @Test
    void shouldCheckNameField() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(_Person.NAME).isEqualTo("name");
            softly.assertThat(_Person.name.name()).isEqualTo(_Person.NAME);
            softly.assertThat(_Person.name).isInstanceOf(TextAttribute.class);
        });
    }
}