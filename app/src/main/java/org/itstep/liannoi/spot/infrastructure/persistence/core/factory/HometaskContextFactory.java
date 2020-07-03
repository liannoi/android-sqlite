package org.itstep.liannoi.spot.infrastructure.persistence.core.factory;

import android.content.Context;

import org.itstep.liannoi.spot.application.common.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.persistence.HometaskContext;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class HometaskContextFactory extends AbstractContextFactory {
    public HometaskContextFactory(Context context) {
        super(context);
    }

    @NotNull
    @Contract(" -> new")
    public SpecificContext create() {
        return new HometaskContext(context);
    }
}
