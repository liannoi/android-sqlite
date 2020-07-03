package org.itstep.liannoi.spot.storage.products.commands;

import org.itstep.liannoi.spot.infrastructure.database.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.persistence.PersistenceDefaults;
import org.itstep.liannoi.spot.infrastructure.storage.cqrs.Request;
import org.itstep.liannoi.spot.infrastructure.storage.cqrs.RequestHandler;
import org.itstep.liannoi.spot.storage.products.models.ProductModel;
import org.jetbrains.annotations.NotNull;

public class CreateCommand implements Request {
    private ProductModel product;

    public static class Handler implements RequestHandler<CreateCommand> {
        private SpecificContext context;

        public Handler(SpecificContext context) {
            this.context = context;
        }

        @Override
        public void handle(@NotNull CreateCommand request) {
            context.prepareToWrite();

            context.getDatabase()
                    .insert(PersistenceDefaults.DATABASE_TABLE_PRODUCTS,
                            null,
                            request.product.getValues());

            context.close();
        }
    }
}
