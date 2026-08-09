package com.calculator.service;

import com.calculator.model.BMIRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BMIService {

    public Map<String, Object> calculate(BMIRequest request) {
        double heightM = request.getHeightCm() / 100.0;
        double rawBmi = request.getWeightKg() / (heightM * heightM);
        double bmi = BigDecimal.valueOf(rawBmi).setScale(2, RoundingMode.HALF_UP).doubleValue();

        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("bmi", bmi);
        result.put("category", category);
        return result;
    }
}
