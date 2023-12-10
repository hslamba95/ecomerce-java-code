package com.ecomerce.site.service;

import com.ecomerce.site.domain.Cart;
import com.ecomerce.site.domain.OrderSummary;

import java.util.List;

public interface OrderService {
    String checkout(Cart cart);

    List<String> generateDiscountCode();

    OrderSummary getOrderSummary(Cart cart);
}
