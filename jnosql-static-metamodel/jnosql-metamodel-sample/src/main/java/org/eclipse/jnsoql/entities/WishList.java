/*
 *  Copyright (c) 2025 Otávio Santana and others
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

import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
public class WishList {

    @Id
    private UUID id;

    private List<String> products;

    private String[] travels;

    private Map<String, String> people;

}
