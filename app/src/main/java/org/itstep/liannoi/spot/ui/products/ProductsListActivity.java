package org.itstep.liannoi.spot.ui.products;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.itstep.liannoi.spot.R;
import org.itstep.liannoi.spot.common.interfaces.Repository;
import org.itstep.liannoi.spot.storage.HometaskContext;
import org.itstep.liannoi.spot.storage.products.ProductsRepository;
import org.itstep.liannoi.spot.storage.products.models.ProductModel;

public class ProductsListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        // Custom.
        Repository<ProductModel> productsRepository = new ProductsRepository(new HometaskContext(this));
        Toast.makeText(this, String.valueOf(productsRepository.getAll().size()), Toast.LENGTH_SHORT).show();
    }
}
