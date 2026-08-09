package com.calculator.service;

import com.calculator.model.AgeRequest;
import com.calculator.util.DateUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AgeService {

    public Map<String, Object> calculate(AgeRequest request) {
        LocalDate dob = request.getDob();
        LocalDate asOf = request.getAsOf() != null ? request.getAsOf() : LocalDate.now();

        if (dob.isAfter(asOf)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }

        Period period = DateUtil.diff(dob, asOf);
        long totalDays = DateUtil.totalDays(dob, asOf);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("years", period.getYears());
        result.put("months", period.getMonths());
        result.put("days", period.getDays());
        result.put("totalDays", totalDays);
        return result;
    }
}
