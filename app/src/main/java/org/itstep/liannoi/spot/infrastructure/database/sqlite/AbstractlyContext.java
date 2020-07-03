package org.itstep.liannoi.spot.infrastructure.database.sqlite;

import android.database.sqlite.SQLiteDatabase;

public interface AbstractlyContext {
    void prepareToWrite();

    void prepareToRead();

    void close();

    SQLiteDatabase getDatabase();
}
