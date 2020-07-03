package org.itstep.liannoi.spot.infrastructure.persistence.core.factory;

import android.content.Context;

import org.itstep.liannoi.spot.application.common.sqlite.SpecificContextFactory;

public abstract class AbstractContextFactory implements SpecificContextFactory {
    protected Context context;

    public AbstractContextFactory(Context context) {
        this.context = context;
    }
}
