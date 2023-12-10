package com.ecomerce.site.repository;

import com.ecomerce.site.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, String> {
    // Custom query method to find a discount by code
    Discount findByCode(String code);
}
