package com.ecomerce.site.domain;

public class OrderCounter {
    private static int orderCount = 0;

    public static int getOrderCount() {
        return orderCount;
    }

    public static void incrementOrderCount() {
        orderCount++;
    }
}
