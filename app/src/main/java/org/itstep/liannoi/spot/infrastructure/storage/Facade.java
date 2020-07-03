package org.itstep.liannoi.spot.infrastructure.storage;

public interface Facade<TModel, TListViewModel> {
    void delete(int id);

    TListViewModel get();
}
