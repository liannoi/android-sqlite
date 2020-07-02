package org.itstep.liannoi.spot.storage.products;

import android.database.Cursor;

import org.itstep.liannoi.spot.PresentationDefaults;
import org.itstep.liannoi.spot.common.interfaces.BaseHometaskContext;
import org.itstep.liannoi.spot.common.interfaces.Repository;
import org.itstep.liannoi.spot.storage.products.models.ProductModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class ProductsRepository implements Repository<ProductModel> {
    private BaseHometaskContext context;

    public ProductsRepository(BaseHometaskContext context) {
        this.context = context;
    }

    @NotNull
    @Override
    public List<ProductModel> getAll() {
        context.prepareToRead();
        List<ProductModel> result = new ArrayList<>();
        Cursor cursor = context.prepareToGetAll();
        tryGetAll(result, cursor);
        cursor.close();
        context.close();

        return result;
    }

    // Helpers.

    private void tryGetAll(List<ProductModel> result, @NotNull Cursor cursor) {
        if (cursor.moveToFirst()) {
            do {
                result.add(new ProductModel(cursor.getInt(cursor.getColumnIndex(PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRODUCT_ID)),
                        cursor.getString(cursor.getColumnIndex(PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_NAME)),
                        cursor.getDouble(cursor.getColumnIndex(PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRICE)),
                        cursor.getDouble(cursor.getColumnIndex(PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_WEIGHT))));
            } while (cursor.moveToNext());
        }
    }
}
