package org.itstep.liannoi.spot.application.common.cqrs;

@FunctionalInterface
public interface ResultRequestHandler<TRequest extends ResultRequest<TResult>, TResult> {
    TResult handle(TRequest request);
}
