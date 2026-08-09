package com.calculator.service;

import com.calculator.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    @Autowired
    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public Map<String, Object> getSummary() {

        Map<String, Object> summary = new LinkedHashMap<>();

        long total = analyticsRepository.countTotalCalculations();

        summary.put("totalCalculations", total);

        List<Object[]> rows = analyticsRepository.countByCalculatorType();

        Map<String, Long> byType = new LinkedHashMap<>();

        for (Object[] row : rows) {
            String type = (String) row[0];
            Long count = (Long) row[1];

            byType.put(type, count);
        }

        summary.put("byType", byType);

        return summary;
    }
}