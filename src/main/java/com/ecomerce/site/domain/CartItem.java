package com.ecomerce.site.domain;

public class CartItem {
    private String itemId;
    private String itemName;
    private double price;

    // Constructors, getters, and setters


    public CartItem() {
    }

    public CartItem(String itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public CartItem setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public CartItem setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CartItem setPrice(double price) {
        this.price = price;
        return this;
    }
}
