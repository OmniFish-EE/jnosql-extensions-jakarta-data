/*
 * Copyright (c) 2024 Contributors to the Eclipse Foundation
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *  You may elect to redistribute this code under either of these licenses.
 *
 *  Contributors:
 *
 *  Ondro Mihalyi
 */
package org.eclipse.jnosql.tck.jakartapersistence;

import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Ondro Mihalyi
 */
@Tag("development")
@DisplayName(value = "Selected EntityTests tests")
@EnableAutoWeld
class SelectedJNoSqlEntityTests extends JNoSqlEntityTests {

    @Test
    @Override
    // Ignore case (findByHexadecimalIgnoreCase)
    public void testSingleEntity() {
        super.testSingleEntity();
    }

    @Test
    @Override
    // AND condition (findByHexadecimalContainsAndIsControlNot)
    public void testContainsInString() {
        super.testContainsInString();
    }

    @Test
    @Override
    public void testStaticMetamodelDescendingSorts() {
        super.testStaticMetamodelDescendingSorts();
    }

    @Test
    @Override
    public void testStaticMetamodelAscendingSortsPreGenerated() {
        super.testStaticMetamodelAscendingSortsPreGenerated();
    }

    @Test
    @Override
    public void testPrimaryEntityClassDeterminedByLifeCycleMethods() {
        super.testPrimaryEntityClassDeterminedByLifeCycleMethods();
    }

    @Test
    @Override
    public void testLiteralTrue() {
        super.testLiteralTrue();
    }

    @Test
    @Override
    public void testIgnoreCase() {
        super.testIgnoreCase();
    }

    @Test
    @Override
    public void testGreaterThanEqualExists() {
        super.testGreaterThanEqualExists();
    }

    @Test
    @Override
    public void testFindFirst3() {
        super.testFindFirst3();
    }

    @Test
    @Override
    public void testFindFirst() {
        super.testFindFirst();
    }

    @Test
    @Override
    public void testEmptyResultException() {
        super.testEmptyResultException();
    }

    @Test
    @Override
    public void testDataRepository() {
        super.testDataRepository();
    }

    @Test
    @Override
    public void testCommonInterfaceQueries() {
        super.testCommonInterfaceQueries();
    }
}
