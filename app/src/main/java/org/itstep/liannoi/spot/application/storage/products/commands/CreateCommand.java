package org.itstep.liannoi.spot.application.storage.products.commands;

import org.itstep.liannoi.spot.application.common.cqrs.Request;
import org.itstep.liannoi.spot.application.common.cqrs.RequestHandler;
import org.itstep.liannoi.spot.application.common.sqlite.SpecificContext;
import org.itstep.liannoi.spot.application.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.infrastructure.persistence.PersistenceDefaults;
import org.jetbrains.annotations.NotNull;

public class CreateCommand implements Request {
    private ProductModel product;

    public CreateCommand(ProductModel product) {
        this.product = product;
    }

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
