package com.ecomerce.site;

import com.ecomerce.site.domain.Cart;
import com.ecomerce.site.service.DiscountService;
import com.ecomerce.site.service.OrderServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {
    @Mock
    private DiscountService discountService;

    @InjectMocks
    private OrderServiceImpl orderService;

    public OrderServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCheckoutWithDiscountApplied() {
        Cart cart = new Cart(); // Create a sample cart
        when(discountService.isValidDiscountCode("DISCOUNT_123")).thenReturn(true);

        String result = orderService.checkout(cart);

        assertEquals("Discount code applied: DISCOUNT_123", result);
    }

    @Test
    public void testCheckoutWithoutDiscount() {
        Cart cart = new Cart(); // Create a sample cart
        when(discountService.isValidDiscountCode("DISCOUNT_123")).thenReturn(false);

        String result = orderService.checkout(cart);

        assertEquals("Order placed successfully!", result);
    }
}
