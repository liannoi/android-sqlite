package org.itstep.liannoi.spot.infrastructure.database.sqlite;

import android.database.Cursor;

public interface SpecificContext extends AbstractlyContext {
    Cursor openForGetAll();
}
