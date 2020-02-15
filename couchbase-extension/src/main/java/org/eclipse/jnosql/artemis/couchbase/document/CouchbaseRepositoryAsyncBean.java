/*
 *  Copyright (c) 2017 Otávio Santana and others
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
package org.eclipse.jnosql.artemis.couchbase.document;

import jakarta.nosql.mapping.RepositoryAsync;
import jakarta.nosql.mapping.document.DocumentRepositoryAsyncProducer;
import org.eclipse.jnosql.artemis.spi.AbstractBean;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Set;


class CouchbaseRepositoryAsyncBean extends AbstractBean<CouchbaseRepositoryAsync> {

    private final Class type;


    private final Set<Type> types;

    private final Set<Annotation> qualifiers = Collections.singleton(new AnnotationLiteral<Default>() {
    });

    CouchbaseRepositoryAsyncBean(Class type, BeanManager beanManager) {
        super(beanManager);
        this.type = type;
        this.types = Collections.singleton(type);
    }

    @Override
    public Class<?> getBeanClass() {
        return type;
    }

    @Override
    public CouchbaseRepositoryAsync create(CreationalContext<CouchbaseRepositoryAsync> creationalContext) {
        CouchbaseTemplateAsync templateAsync = getInstance(CouchbaseTemplateAsync.class);
        DocumentRepositoryAsyncProducer producer = getInstance(DocumentRepositoryAsyncProducer.class);
        RepositoryAsync<?,?> repositoryAsync = producer.get((Class<RepositoryAsync<Object, Object>>) type, templateAsync);
        CouchbaseRepositoryAsyncProxy handler = new CouchbaseRepositoryAsyncProxy(templateAsync, repositoryAsync);
        return (CouchbaseRepositoryAsync) Proxy.newProxyInstance(type.getClassLoader(),
                new Class[]{type},
                handler);
    }

    @Override
    public Set<Type> getTypes() {
        return types;
    }

    @Override
    public Set<Annotation> getQualifiers() {
        return qualifiers;
    }

    @Override
    public String getId() {
        return type.getName() + "Async@couchbase";
    }

}