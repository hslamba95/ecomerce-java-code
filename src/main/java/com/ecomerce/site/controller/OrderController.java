package com.ecomerce.site.controller;

import com.ecomerce.site.domain.Cart;
import com.ecomerce.site.domain.OrderSummary;
import com.ecomerce.site.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public String checkout(@RequestBody Cart cart) {
        return orderService.checkout(cart);
    }

    @GetMapping("/generateDiscountCode")
    public List<String> generateDiscountCode() {
        return orderService.generateDiscountCode();
    }

    @GetMapping("/orderSummary")
    public OrderSummary getOrderSummary(@RequestBody Cart cart) {
        return orderService.getOrderSummary(cart);
    }
}
