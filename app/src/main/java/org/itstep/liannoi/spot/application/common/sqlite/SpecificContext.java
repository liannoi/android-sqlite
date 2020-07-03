package org.itstep.liannoi.spot.application.common.sqlite;

import android.database.Cursor;

public interface SpecificContext extends AbstractlyContext {
    Cursor openForGetAll();
}
