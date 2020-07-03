package org.itstep.liannoi.spot.storage.products;

import org.itstep.liannoi.spot.infrastructure.database.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.storage.Facade;
import org.itstep.liannoi.spot.storage.products.commands.DeleteCommand;
import org.itstep.liannoi.spot.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.storage.products.models.ProductsListViewModel;
import org.itstep.liannoi.spot.storage.products.queries.ListQuery;

public final class ProductsFacade implements Facade<ProductModel, ProductsListViewModel> {
    private SpecificContext context;

    public ProductsFacade(SpecificContext context) {
        this.context = context;
    }

    @Override
    public void delete(int id) {
        new DeleteCommand.Handler(context).handle(new DeleteCommand(id));
    }

    @Override
    public ProductsListViewModel get() {
        return new ListQuery.Handler(context).handle(new ListQuery());
    }
}
