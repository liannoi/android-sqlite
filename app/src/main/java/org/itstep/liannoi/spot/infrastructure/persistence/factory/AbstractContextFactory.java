package org.itstep.liannoi.spot.infrastructure.persistence.factory;

import android.content.Context;

import org.itstep.liannoi.spot.infrastructure.database.sqlite.SpecificContextFactory;

public abstract class AbstractContextFactory implements SpecificContextFactory {
    protected Context context;

    public AbstractContextFactory(Context context) {
        this.context = context;
    }
}
