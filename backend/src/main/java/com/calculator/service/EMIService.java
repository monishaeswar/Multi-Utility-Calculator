package com.calculator.service;

import com.calculator.model.EMIRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class EMIService {

    public Map<String, Object> calculate(EMIRequest request) {
        double principal = request.getPrincipal();
        double annualRate = request.getRateAnnual();
        int tenureMonths = request.getTenureMonths();

        double monthlyRate = annualRate / 12 / 100;

        double emi;
        if (monthlyRate == 0) {
            emi = principal / tenureMonths;
        } else {
            double factor = Math.pow(1 + monthlyRate, tenureMonths);
            emi = (principal * monthlyRate * factor) / (factor - 1);
        }

        double totalPayment = emi * tenureMonths;
        double totalInterest = totalPayment - principal;

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("emi", round(emi));
        result.put("totalInterest", round(totalInterest));
        result.put("totalPayment", round(totalPayment));
        return result;
    }

    private double round(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
