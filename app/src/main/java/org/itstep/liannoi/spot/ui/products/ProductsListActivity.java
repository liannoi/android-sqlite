package org.itstep.liannoi.spot.ui.products;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.itstep.liannoi.spot.R;
import org.itstep.liannoi.spot.infrastructure.database.sqlite.SpecificContext;
import org.itstep.liannoi.spot.infrastructure.persistence.factory.HometaskContextFactory;
import org.itstep.liannoi.spot.infrastructure.storage.Facade;
import org.itstep.liannoi.spot.storage.products.ProductsFacade;
import org.itstep.liannoi.spot.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.storage.products.models.ProductsListViewModel;

public class ProductsListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        // Custom.

        SpecificContext context = new HometaskContextFactory(this).create();
        Facade<ProductModel, ProductsListViewModel> productsFacade = new ProductsFacade(context);
        productsFacade.delete(1);
        ProductsListViewModel productsViewModel = productsFacade.get();
        Toast.makeText(this, String.valueOf(productsViewModel.count()), Toast.LENGTH_SHORT).show();
    }
}
