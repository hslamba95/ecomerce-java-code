package com.ecomerce.site.domain;


import java.util.List;

public class Cart {
    private List<CartItem> items;

    // Constructors, getters, and setters


    public Cart() {
    }

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Cart setItems(List<CartItem> items) {
        this.items = items;
        return this;
    }
}