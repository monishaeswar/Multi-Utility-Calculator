package com.calculator.service;

import com.calculator.model.DiscountRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DiscountService {

    public Map<String, Object> calculate(DiscountRequest request) {
        double price = request.getPrice();
        double discountPercent = request.getDiscountPercent();

        double discountAmount = price * discountPercent / 100;
        double finalPrice = price - discountAmount;

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("discountAmount", round(discountAmount));
        result.put("finalPrice", round(finalPrice));
        return result;
    }

    private double round(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
