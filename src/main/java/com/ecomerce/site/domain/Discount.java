package com.ecomerce.site.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discount {

    @Id
    private String code;
    private double amount;

    public Discount() {
        // Default constructor required by JPA
    }

    public Discount(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public double getAmount() {
        return amount;
    }
}
