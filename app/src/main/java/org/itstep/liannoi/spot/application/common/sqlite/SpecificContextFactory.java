package org.itstep.liannoi.spot.application.common.sqlite;

@FunctionalInterface
public interface SpecificContextFactory {
    SpecificContext create();
}
