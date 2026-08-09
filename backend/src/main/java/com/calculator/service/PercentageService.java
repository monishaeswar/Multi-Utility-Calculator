package com.calculator.service;

import com.calculator.model.PercentageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class PercentageService {

    public Map<String, Object> calculate(PercentageRequest request) {
        double value = request.getValue();
        double percent = request.getPercent();
        String mode = request.getMode() == null ? "" : request.getMode().toUpperCase(Locale.ROOT);

        Map<String, Object> result = new LinkedHashMap<>();

        switch (mode) {
            case "OF" -> {
                // percent% of value
                double res = (percent / 100.0) * value;
                result.put("result", round(res));
            }
            case "CHANGE" -> {
                // percentage change from value -> percent (treated as new value)
                if (value == 0) {
                    throw new ArithmeticException("Cannot calculate percentage change from zero");
                }
                double change = ((percent - value) / value) * 100;
                result.put("percentageChange", round(change));
            }
            case "IS_WHAT_PERCENT" -> {
                // value is what percent of percent(field used as 'of' amount)
                if (percent == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                double res = (value / percent) * 100;
                result.put("result", round(res));
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported mode: " + request.getMode() + ". Supported: OF, CHANGE, IS_WHAT_PERCENT");
        }
        return result;
    }

    private double round(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
