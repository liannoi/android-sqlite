package org.itstep.liannoi.spot.infrastructure.storage.cqrs;

@FunctionalInterface
public interface ResultRequestHandler<TRequest extends ResultRequest<TResult>, TResult> {
    TResult handle(TRequest request);
}
