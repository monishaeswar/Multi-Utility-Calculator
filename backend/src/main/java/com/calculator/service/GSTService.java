package com.calculator.service;

import com.calculator.model.GSTRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class GSTService {

    public Map<String, Object> calculate(GSTRequest request) {
        double amount = request.getAmount();
        double rate = request.getRate();
        String mode = request.getMode() == null ? "" : request.getMode().toUpperCase(Locale.ROOT);

        double gstAmount;
        double totalAmount;
        double baseAmount;

        Map<String, Object> result = new LinkedHashMap<>();

        switch (mode) {
            case "ADD" -> {
                gstAmount = amount * rate / 100;
                totalAmount = amount + gstAmount;
                result.put("gstAmount", round(gstAmount));
                result.put("totalAmount", round(totalAmount));
            }
            case "REMOVE" -> {
                baseAmount = amount / (1 + rate / 100);
                gstAmount = amount - baseAmount;
                result.put("baseAmount", round(baseAmount));
                result.put("gstAmount", round(gstAmount));
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported mode: " + request.getMode() + ". Supported: ADD, REMOVE");
        }
        return result;
    }

    private double round(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
