package org.itstep.liannoi.spot.storage.products.models;

import android.content.ContentValues;

import org.itstep.liannoi.spot.infrastructure.persistence.PersistenceDefaults;
import org.itstep.liannoi.spot.infrastructure.storage.models.Valuable;

public class ProductModel implements Valuable {
    private int productId;
    private String name;
    private double price;
    private double weight;

    public ProductModel(int productId, String name, double price, double weight) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public ProductModel(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
