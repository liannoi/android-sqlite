package org.itstep.liannoi.spot.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public abstract class AbstractDatabaseContext extends SQLiteOpenHelper implements AbstractlyContext {
    protected SQLiteDatabase database;

    public AbstractDatabaseContext(@Nullable Context context, @Nullable String name, int version) {
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


}
