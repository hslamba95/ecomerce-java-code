package com.ecomerce.site;

import com.ecomerce.site.domain.Discount;
import com.ecomerce.site.repository.DiscountRepository;
import com.ecomerce.site.service.DiscountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

class DiscountServiceImplTest {

    @Mock
    private DiscountRepository discountRepository;

    @InjectMocks
    private DiscountService discountService;

    public DiscountServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testApplyValidDiscountCode() {
        String discountCode = "DISCOUNT_123";
        when(discountRepository.findByCode(discountCode)).thenReturn(new Discount());

        boolean result = discountService.isValidDiscountCode(discountCode);

        assertTrue(result);
    }

    @Test
    void testApplyInvalidDiscountCode() {
        String discountCode = "INVALID_CODE";
        when(discountRepository.findByCode(discountCode)).thenReturn(null);

        boolean result = discountService.isValidDiscountCode(discountCode);

        assertFalse(result);
    }

}
