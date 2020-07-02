package org.itstep.liannoi.spot.common.interfaces;

import android.database.Cursor;

import org.itstep.liannoi.spot.common.database.AbstractlyContext;

public interface BaseHometaskContext extends AbstractlyContext {
    Cursor prepareToGetAll();
}
