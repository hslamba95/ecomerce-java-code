package com.ecomerce.site.service;

import com.ecomerce.site.domain.*;
import com.ecomerce.site.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final int N = 3; // Replace with your specific value
    private final List<String> discountCodes = new ArrayList<>();

    private final DiscountRepository discountRepository;
    private final DiscountService discountService;

    public OrderServiceImpl(DiscountRepository discountRepository, DiscountService discountService) {
        this.discountRepository = discountRepository;
        this.discountService = discountService;
    }

    /*
    Checkout an order, apply discount if eligible
     */
    @Override
    public String checkout(Cart cart) {
        OrderCounter.incrementOrderCount(); // Increment the order count

        int orderCount = OrderCounter.getOrderCount();
        if (orderCount % N == 0) {
            List<String> discountCodes = generateDiscountCode();
            applyDiscountToCart(cart, discountCodes.get(0));
            return "Discount code applied: " + discountCodes.get(0);
        } else {
            return "Order placed successfully!";
        }
    }

    /*
    Generate a discount code
     */
    @Override
    public List<String> generateDiscountCode() {
        String discountCode = "DISCOUNT_" + System.currentTimeMillis();
        discountCodes.add(discountCode);
        return discountCodes;
    }

    /*
    Get the order summary
     */
    @Override
    public OrderSummary getOrderSummary(Cart cart) {
        int totalOrders = OrderCounter.getOrderCount();
        double totalAmount = calculateTotalAmount(cart);
        List<String> appliedDiscountCodes = discountService.getAppliedDiscountCodes();
        double totalDiscount = discountService.calculateTotalDiscount(cart);

        return new OrderSummary(totalOrders, totalAmount, appliedDiscountCodes, totalDiscount);
    }

    /*
    Calculate the total amount of items in the cart
     */
    private double calculateTotalAmount(Cart cart) {
        double totalAmount = 0.0;
        for (CartItem item : cart.getItems()) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }

    /*
    In this example, each discount code contributes a fixed discount amount (discountPerCode).
    You should replace this logic with the actual mechanism you have for determining the discount amount based on each discount code.
    If your discount logic is more complex, involves percentages, or varies for different codes, you'll need to adjust the calculateTotalDiscount method accordingly based on your specific requirements.
     */
    private double calculateTotalDiscount() {
        double totalDiscount = 0.0;

        // Here, you might query a discount table in a database
        // to get the corresponding discount amount for each applied discount code.
        for (String discountCode : discountCodes) {
            double discountAmount = getDiscountAmountFromDatabase(discountCode);
            totalDiscount += discountAmount;
        }

        return totalDiscount;
    }

    private void applyDiscountToCart(Cart cart, String discountCode) {
        // Retrieve the discount amount from the database based on the discount code
        double discountAmount = getDiscountAmountFromDatabase(discountCode);

        // Apply the discount to each item in the cart
        for (CartItem item : cart.getItems()) {
            double discountedPrice = item.getPrice() - discountAmount;
            item.setPrice(discountedPrice);
        }
    }

    private double getDiscountAmountFromDatabase(String discountCode) {
        /* Retrieve the discount amount from the database using Spring Data JPA */
        Discount discount = discountRepository.findByCode(discountCode);

        // Return the discount amount or a default value if not found
        return (discount != null) ? discount.getAmount() : 0.0;
    }
}
