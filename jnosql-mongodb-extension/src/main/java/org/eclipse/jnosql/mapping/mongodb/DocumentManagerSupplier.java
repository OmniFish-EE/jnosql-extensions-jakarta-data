/*
 *  Copyright (c) 2022 Eclipse Contribuitor
 * All rights reserved. This program and the accompanying materials
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *    You may elect to redistribute this code under either of these licenses.
 */

package org.eclipse.jnosql.mapping.mongodb;

import jakarta.nosql.Settings;
import jakarta.nosql.mapping.MappingException;
import org.eclipse.jnosql.communication.mongodb.document.MongoDBDocumentConfiguration;
import org.eclipse.jnosql.communication.mongodb.document.MongoDBDocumentManager;
import org.eclipse.jnosql.communication.mongodb.document.MongoDBDocumentManagerFactory;
import org.eclipse.jnosql.mapping.config.MicroProfileSettings;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.eclipse.jnosql.mapping.config.MappingConfigurations.DOCUMENT_DATABASE;

@ApplicationScoped
class DocumentManagerSupplier implements Supplier<MongoDBDocumentManager> {

    private static final Logger LOGGER = Logger.getLogger(DocumentManagerSupplier.class.getName());


    @Override
    @Produces
    @Typed(MongoDBDocumentManager.class)
    public MongoDBDocumentManager get() {
        Settings settings = MicroProfileSettings.INSTANCE;
        MongoDBDocumentConfiguration configuration = new MongoDBDocumentConfiguration();
        MongoDBDocumentManagerFactory factory = configuration.apply(settings);
        Optional<String> database = settings.get(DOCUMENT_DATABASE, String.class);
        String db = database.orElseThrow(() -> new MappingException("Please, inform the database filling up the property "
                + DOCUMENT_DATABASE));
        MongoDBDocumentManager manager = factory.apply(db);
        LOGGER.log(Level.FINEST, "Starting  a MongoDBDocumentManager instance using Eclipse MicroProfile Config," +
                " database name: " + db);
        return manager;
    }

    public void close(@Disposes MongoDBDocumentManager manager) {
        LOGGER.log(Level.FINEST, "Closing MongoDBDocumentManager resource, database name: " + manager.getName());
        manager.close();
    }

}