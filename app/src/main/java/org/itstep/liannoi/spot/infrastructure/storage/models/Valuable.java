package org.itstep.liannoi.spot.infrastructure.storage.models;

import android.content.ContentValues;

@FunctionalInterface
public interface Valuable {
    ContentValues getValues();
}
