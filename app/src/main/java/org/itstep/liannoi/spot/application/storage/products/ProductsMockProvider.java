package org.itstep.liannoi.spot.application.storage.products;

import org.itstep.liannoi.spot.application.common.interfaces.Randomise;
import org.itstep.liannoi.spot.application.common.storage.MockProvider;
import org.itstep.liannoi.spot.application.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.application.storage.products.models.ProductsListViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ProductsMockProvider implements MockProvider<ProductsListViewModel> {
    private int count;
    private Randomise randomise;

    public ProductsMockProvider(int count, Randomise randomise) {
        this.count = count;
        this.randomise = randomise;
    }

    @NotNull
    @Override
    public ProductsListViewModel provide() {
        List<ProductModel> products = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            products.add(new ProductModel(UUID.randomUUID().toString(),
                    randomise.random(200.0F, 3600.0F),
                    randomise.random(40.0F, 1000.0F)));
        }

        return new ProductsListViewModel(products);
    }
}
