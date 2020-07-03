package org.itstep.liannoi.spot.ui.products.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.itstep.liannoi.spot.R;
import org.itstep.liannoi.spot.application.storage.products.ProductsFacade;
import org.itstep.liannoi.spot.application.storage.products.ProductsMockProvider;
import org.itstep.liannoi.spot.application.storage.products.models.ProductsListViewModel;
import org.itstep.liannoi.spot.infrastructure.InfrastructureDefaults;
import org.itstep.liannoi.spot.infrastructure.persistence.core.factory.HometaskContextFactory;
import org.itstep.liannoi.spot.infrastructure.primitives.RandomClient;

public class ProductsListActivity extends AppCompatActivity {
    private RecyclerView productsRecyclerView;
    private ProductsFacade productsFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        // Custom.

        productsFacade = new ProductsFacade(new HometaskContextFactory(this).create(),
                new ProductsMockProvider(InfrastructureDefaults.PRODUCTS_MOCK_LENGTH, new RandomClient()));

        productsFacade.clear();
        productsFacade.mock();

        prepareRecyclerView(productsFacade.get());
    }

    // Helpers.

    private void prepareRecyclerView(ProductsListViewModel productsViewModel) {
        productsRecyclerView = findViewById(R.id.productsRecyclerView);

        productsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));

        productsRecyclerView.setAdapter(new ProductsListCardAdapter(productsViewModel));
    }
}
