package org.itstep.liannoi.spot.ui.products;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.itstep.liannoi.spot.R;
import org.itstep.liannoi.spot.infrastructure.persistence.HometaskContext;
import org.itstep.liannoi.spot.storage.products.commands.DeleteCommand;
import org.itstep.liannoi.spot.storage.products.models.ProductsListViewModel;
import org.itstep.liannoi.spot.storage.products.queries.ListQuery;

public class ProductsListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        // Custom.

        HometaskContext context = new HometaskContext(this);
        new DeleteCommand.Handler(context).handle(new DeleteCommand(1));
        ProductsListViewModel productsViewModel = new ListQuery.Handler(context).handle(new ListQuery());
        Toast.makeText(this, String.valueOf(productsViewModel.getProducts().size()), Toast.LENGTH_SHORT).show();
    }
}
