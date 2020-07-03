package org.itstep.liannoi.spot.storage.products.queries;

import android.database.Cursor;

import org.itstep.liannoi.spot.infrastructure.database.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.persistence.PersistenceDefaults;
import org.itstep.liannoi.spot.infrastructure.storage.cqrs.ResultRequest;
import org.itstep.liannoi.spot.infrastructure.storage.cqrs.ResultRequestHandler;
import org.itstep.liannoi.spot.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.storage.products.models.ProductsListViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListQuery implements ResultRequest<ProductsListViewModel> {
    public static class Handler implements ResultRequestHandler<ListQuery, ProductsListViewModel> {
        private SpecificContext context;

        public Handler(SpecificContext context) {
            this.context = context;
        }

        @Override
        public ProductsListViewModel handle(ListQuery request) {
            List<ProductModel> result = new ArrayList<>();
            context.prepareToRead();

            try (Cursor cursor = context.openForGetAll()) {
                readTo(cursor, result);
                context.close();
            }

            return new ProductsListViewModel(result);
        }

        private void readTo(@NotNull Cursor cursor, List<ProductModel> result) {
            if (cursor.moveToFirst()) {
                do {
                    result.add(new ProductModel(cursor.getInt(cursor.getColumnIndex(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRODUCT_ID)),
                            cursor.getString(cursor.getColumnIndex(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_NAME)),
                            cursor.getDouble(cursor.getColumnIndex(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRICE)),
                            cursor.getDouble(cursor.getColumnIndex(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_WEIGHT))));
                } while (cursor.moveToNext());
            }
        }
    }
}
