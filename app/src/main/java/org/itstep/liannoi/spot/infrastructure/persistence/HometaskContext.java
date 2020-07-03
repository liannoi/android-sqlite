package org.itstep.liannoi.spot.infrastructure.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import org.itstep.liannoi.spot.application.common.storage.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.persistence.core.AbstractContext;
import org.jetbrains.annotations.NotNull;

public final class HometaskContext extends AbstractContext implements SpecificContext {
    public HometaskContext(@Nullable Context context) {
        super(context, PersistenceDefaults.DATABASE_NAME, PersistenceDefaults.DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NotNull SQLiteDatabase database) {
        String query = "CREATE TABLE " + PersistenceDefaults.DATABASE_TABLE_PRODUCTS +
                "(" +
                PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_NAME + " TEXT," +
                PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRICE + " REAL," +
                PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_WEIGHT + " REAL" +
                ");";

        database.execSQL(query);
        String message = "onCreate: Created database " + PersistenceDefaults.DATABASE_NAME + ".";
        Log.i(getClass().getName(), message);
    }

    @Override
    public Cursor openForGetAll() {
        return getDatabase().query(PersistenceDefaults.DATABASE_TABLE_PRODUCTS,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
