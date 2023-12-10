package com.ecomerce.site.domain;

import java.util.List;

public class OrderSummary {
    private int totalOrders;
    private double totalAmount;
    private List<String> discountCodes;
    private double totalDiscount;

    // Constructors, getters, and setters


    public OrderSummary() {
    }

    public OrderSummary(int totalOrders, double totalAmount, List<String> discountCodes, double totalDiscount) {
        this.totalOrders = totalOrders;
        this.totalAmount = totalAmount;
        this.discountCodes = discountCodes;
        this.totalDiscount = totalDiscount;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public OrderSummary setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
        return this;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderSummary setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public List<String> getDiscountCodes() {
        return discountCodes;
    }

    public OrderSummary setDiscountCodes(List<String> discountCodes) {
        this.discountCodes = discountCodes;
        return this;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public OrderSummary setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
        return this;
    }
}
