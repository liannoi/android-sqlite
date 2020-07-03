package org.itstep.liannoi.spot.application.common.cqrs;

@FunctionalInterface
public interface RequestHandler<TRequest extends Request> {
    void handle(TRequest request);
}

