package org.itstep.liannoi.spot.application.common.storage.sqlite;

@FunctionalInterface
public interface SpecificContextFactory {
    SpecificContext create();
}
