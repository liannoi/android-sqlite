package org.itstep.liannoi.spot.infrastructure.database.sqlite;

@FunctionalInterface
public interface SpecificContextFactory {
    SpecificContext create();
}
