package org.itstep.liannoi.spot.infrastructure.storage.cqrs;

@FunctionalInterface
public interface RequestHandler<TRequest extends Request> {
    void handle(TRequest request);
}

