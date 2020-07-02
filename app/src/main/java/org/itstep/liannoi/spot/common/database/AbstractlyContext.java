package org.itstep.liannoi.spot.common.database;

public interface AbstractlyContext {
    void prepareToWrite();

    void prepareToRead();

    void close();
}
