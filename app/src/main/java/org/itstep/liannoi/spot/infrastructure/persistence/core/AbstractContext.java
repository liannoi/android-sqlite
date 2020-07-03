package org.itstep.liannoi.spot.infrastructure.persistence.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.itstep.liannoi.spot.application.common.storage.sqlite.AbstractlyContext;

public abstract class AbstractContext extends SQLiteOpenHelper implements AbstractlyContext {
    private SQLiteDatabase database;

    public AbstractContext(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public abstract void onCreate(SQLiteDatabase database);

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        // Do nothing.
    }

    @Override
    public void prepareToWrite() {
        database = this.getWritableDatabase();
    }

    @Override
    public void prepareToRead() {
        database = this.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getDatabase() {
        return database;
    }
}
