package org.itstep.liannoi.spot.ui.products.list;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.itstep.liannoi.spot.R;
import org.itstep.liannoi.spot.application.storage.products.models.ProductModel;
import org.itstep.liannoi.spot.application.storage.products.models.ProductsListViewModel;
import org.itstep.liannoi.spot.infrastructure.InfrastructureDefaults;
import org.itstep.liannoi.spot.infrastructure.primitives.Trimmer;

public final class ProductsListCardAdapter extends RecyclerView.Adapter<ProductsListCardAdapter.ViewHandler> {
    private ProductsListViewModel productsViewModel;

    public ProductsListCardAdapter(ProductsListViewModel productsViewModel) {
        this.productsViewModel = productsViewModel;
    }

    @NonNull
    @Override
    public ViewHandler onCreateViewHolder(@NonNull ViewGroup container, int viewType) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.card_adapter_products_list, container, false);

        return new ViewHandler(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHandler holder, int position) {
        ProductModel product = productsViewModel.getProducts().get(position);

        holder.nameText.setText(Trimmer.trimOrLeave(product.getName(),
                InfrastructureDefaults.PRODUCT_NAME_LENGTH_TRIM));

        holder.priceText.setText("Price: " + (int) product.getPrice());
        holder.weightText.setText("Weight: " + product.getWeight());
    }

    @Override
    public int getItemCount() {
        return productsViewModel.count();
    }

    public class ViewHandler extends RecyclerView.ViewHolder {
        private TextView nameText;
        private TextView priceText;
        private TextView weightText;

        public ViewHandler(@NonNull View container) {
            super(container);
            nameText = container.findViewById(R.id.nameText);
            priceText = container.findViewById(R.id.priceText);
            weightText = container.findViewById(R.id.weightText);
        }
    }
}
