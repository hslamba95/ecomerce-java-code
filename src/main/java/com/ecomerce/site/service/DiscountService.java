package com.ecomerce.site.service;

import com.ecomerce.site.domain.Cart;
import com.ecomerce.site.domain.Discount;
import com.ecomerce.site.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService {
    private List<String> appliedDiscountCodes = new ArrayList<>();

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<String> getAppliedDiscountCodes() {
        List<Discount> appliedDiscounts = discountRepository.findAll(); // Assuming you have a findAll() method

        for (Discount discount : appliedDiscounts) {
            appliedDiscountCodes.add(discount.getCode());
        }

        return appliedDiscountCodes;
    }

    // Method to calculate total discount based on applied discount codes in the database
    public double calculateTotalDiscount(Cart cart) {
        double totalDiscount = 0.0;

        // Retrieve applied discount codes from the database
        List<Discount> appliedDiscounts = discountRepository.findAll();

        // Iterate through applied discount codes and calculate the total discount
        for (Discount discount : appliedDiscounts) {
            double discountAmount = discount.getAmount();
            totalDiscount += discountAmount;
        }

        return totalDiscount;
    }

    // Method to apply a discount code and track it
    public void applyDiscountCode(String discountCode) {
        // Validate and apply the discount code
        if (isValidDiscountCode(discountCode)) {
            // If the discount code is valid, apply the logic to use it
            // For simplicity, we are just tracking the applied discount code
            appliedDiscountCodes.add(discountCode);
            System.out.println("Discount code applied: " + discountCode);
        } else {
            // If the discount code is not valid, handle the situation
            System.out.println("Invalid discount code: " + discountCode);
            // You might throw an exception, log the error, or take other actions based on your requirements
        }
    }

    // Method to validate the discount code
    public boolean isValidDiscountCode(String discountCode) {
        // Example: Check if the discount code exists in the database
        return discountRepository.findByCode(discountCode) != null;
    }

    private double getDiscountAmountFromDatabase(String discountCode) {
        // Retrieve the discount amount from the database using Spring Data JPA
        Discount discount = discountRepository.findByCode(discountCode);

        // Return the discount amount or a default value if not found
        return (discount != null) ? discount.getAmount() : 0.0;
    }

}
