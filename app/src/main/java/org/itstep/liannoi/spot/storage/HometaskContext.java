package org.itstep.liannoi.spot.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import org.itstep.liannoi.spot.PresentationDefaults;
import org.itstep.liannoi.spot.common.database.AbstractDatabaseContext;
import org.itstep.liannoi.spot.common.interfaces.BaseHometaskContext;
import org.jetbrains.annotations.NotNull;

public final class HometaskContext extends AbstractDatabaseContext implements BaseHometaskContext {
    public HometaskContext(@Nullable Context context) {
        super(context, PresentationDefaults.DATABASE_NAME, PresentationDefaults.DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NotNull SQLiteDatabase database) {
        String query = "CREATE TABLE " + PresentationDefaults.DATABASE_TABLE_PRODUCTS +
                "(" +
                PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_NAME + " TEXT," +
                PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRICE + " REAL," +
                PresentationDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_WEIGHT + " REAL" +
                ");";

        database.execSQL(query);
        String message = "onCreate: Created database " + PresentationDefaults.DATABASE_NAME + ".";
        Log.i(getClass().getName(), message);
    }

    @Override
    public Cursor prepareToGetAll() {
        return database.query(PresentationDefaults.DATABASE_TABLE_PRODUCTS,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
