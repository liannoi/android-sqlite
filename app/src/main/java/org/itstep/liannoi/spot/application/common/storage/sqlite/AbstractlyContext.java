package org.itstep.liannoi.spot.application.common.storage.sqlite;

import android.database.sqlite.SQLiteDatabase;

public interface AbstractlyContext {
    void prepareToWrite();

    void prepareToRead();

    void close();

    SQLiteDatabase getDatabase();
}
