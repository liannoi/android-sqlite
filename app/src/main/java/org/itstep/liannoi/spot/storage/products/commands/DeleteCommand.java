package org.itstep.liannoi.spot.storage.products.commands;

import org.itstep.liannoi.spot.infrastructure.database.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.persistence.PersistenceDefaults;
import org.itstep.liannoi.spot.infrastructure.storage.cqrs.Request;
import org.itstep.liannoi.spot.infrastructure.storage.cqrs.RequestHandler;
import org.jetbrains.annotations.NotNull;

public class DeleteCommand implements Request {
    private int productId;

    public DeleteCommand(int productId) {
        this.productId = productId;
    }

    public static class Handler implements RequestHandler<DeleteCommand> {
        private SpecificContext context;

        public Handler(SpecificContext context) {
            this.context = context;
        }

        @Override
        public void handle(@NotNull DeleteCommand request) {
            context.prepareToWrite();

            context.getDatabase()
                    .delete(PersistenceDefaults.DATABASE_TABLE_PRODUCTS,
                            PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRODUCT_ID + " = ?",
                            new String[]{String.valueOf(request.productId)});

            context.close();
        }
    }
}
