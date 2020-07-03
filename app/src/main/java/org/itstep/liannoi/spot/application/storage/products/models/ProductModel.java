package org.itstep.liannoi.spot.application.storage.products.models;

import android.content.ContentValues;

import org.itstep.liannoi.spot.application.common.interfaces.Valuable;
import org.itstep.liannoi.spot.infrastructure.persistence.PersistenceDefaults;

public class ProductModel implements Valuable {
    private int productId;
    private String name;
    private float price;
    private float weight;

    public ProductModel(int productId, String name, float price, float weight) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public ProductModel(String name, float price, float weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        values.put(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_NAME, name);
        values.put(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_PRICE, price);
        values.put(PersistenceDefaults.DATABASE_TABLE_PRODUCTS_COLUMN_WEIGHT, weight);

        return values;
    }
}
