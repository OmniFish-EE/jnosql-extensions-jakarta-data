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
package org.eclipse.jnosql.metamodel.processor;


final class FieldModel extends BaseMappingModel {
    public static final String STRING_ATTRIBUTE = "TextAttribute";
    public static final String SORTABLE_ATTRIBUTE = "SortableAttribute";

    public static final String STRING_IMPLEMENTATION = "TextAttributeRecord";
    public static final String SORTABLE_IMPLEMENTATION = "SortableAttributeRecord";

    private String className;
    private String fieldName;
    private String name;
    private String constantName;
    private String implementation;
    private AttributeElementType type;

    private FieldModel() {
    }
    public String getClassName() {
        return className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getName() {
        return name;
    }

    public String getConstantName() {
        return constantName;
    }

    public boolean isStringAttribute() {
        return STRING_ATTRIBUTE.equals(className);
    }

    public boolean isSortableAttribute() {
        return SORTABLE_ATTRIBUTE.equals(className);
    }

    public String getImplementation() {
        return implementation;
    }

    @Override
    public String toString() {
        return "FieldModel{" +
                "className='" + className + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", name='" + name + '\'' +
                ", constantName='" + constantName + '\'' +
                ", implementation='" + implementation + '\'' +
                ", type=" + type +
                '}';
    }

    public static FieldMetaDataBuilder builder() {
        return new FieldMetaDataBuilder();
    }

    public static class FieldMetaDataBuilder {

        private final FieldModel fieldModel;

        private FieldMetaDataBuilder() {
            this.fieldModel = new FieldModel();
        }

        public FieldMetaDataBuilder className(String className) {
            this.fieldModel.className = className;
            return this;
        }

        public FieldMetaDataBuilder name(String name) {
            this.fieldModel.name = name;
            return this;
        }

        public FieldMetaDataBuilder fieldName(String fieldName) {
            this.fieldModel.fieldName = fieldName;
            return this;
        }

        public FieldMetaDataBuilder constantName(String constantName) {
            this.fieldModel.constantName = constantName;
            return this;
        }

        public FieldMetaDataBuilder implementation(String implementation) {
            this.fieldModel.implementation = implementation;
            return this;
        }

        public FieldMetaDataBuilder type(AttributeElementType type) {
            this.fieldModel.type = type;
            return this;
        }

        FieldModel build() {
           return fieldModel;
        }
    }
}
