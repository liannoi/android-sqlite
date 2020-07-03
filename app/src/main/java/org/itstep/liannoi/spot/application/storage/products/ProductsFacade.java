package org.itstep.liannoi.spot.application.storage.products;

import org.itstep.liannoi.spot.application.common.interfaces.Facade;
import org.itstep.liannoi.spot.application.common.interfaces.MockProvider;
import org.itstep.liannoi.spot.application.common.sqlite.SpecificContext;
import org.itstep.liannoi.spot.application.storage.products.commands.CreateCommand;
import org.itstep.liannoi.spot.application.storage.products.commands.DeleteCommand;
import org.itstep.liannoi.spot.application.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.application.storage.products.models.ProductsListViewModel;
import org.itstep.liannoi.spot.application.storage.products.queries.ListQuery;

public final class ProductsFacade implements Facade<ProductModel, ProductsListViewModel> {
    private SpecificContext context;
    private MockProvider<ProductsListViewModel> mockProvider;

    public ProductsFacade(SpecificContext context, MockProvider<ProductsListViewModel> mockProvider) {
        this.context = context;
        this.mockProvider = mockProvider;
    }

    @Override
    public void delete(int id) {
        new DeleteCommand.Handler(context).handle(new DeleteCommand(id));
    }

    @Override
    public ProductsListViewModel get() {
        return new ListQuery.Handler(context).handle(new ListQuery());
    }

    @Override
    public void create(ProductModel product) {
        new CreateCommand.Handler(context).handle(new CreateCommand(product));
    }

    @Override
    public void clear() {
        get().getProducts().forEach(product -> delete(product.getProductId()));
    }

    @Override
    public void mock() {
        mockProvider.provide().getProducts().forEach(this::create);
    }
}
