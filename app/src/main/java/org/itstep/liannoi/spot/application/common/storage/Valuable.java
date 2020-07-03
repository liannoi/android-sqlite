package org.itstep.liannoi.spot.application.common.storage;

import android.content.ContentValues;

@FunctionalInterface
public interface Valuable {
    ContentValues getValues();
}
