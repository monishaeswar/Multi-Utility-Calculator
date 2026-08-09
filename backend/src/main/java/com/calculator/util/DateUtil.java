package com.calculator.util;

import java.time.LocalDate;
import java.time.Period;

public final class DateUtil {

    private DateUtil() {
    }

    /**
     * Returns the exact difference between two dates as a Period
     * (years, months, and days).
     */
    public static Period diff(LocalDate from, LocalDate to) {
        if (from.isAfter(to)) {
            return Period.between(to, from);
        }
        return Period.between(from, to);
    }

    public static long totalDays(LocalDate from, LocalDate to) {
        return java.time.temporal.ChronoUnit.DAYS.between(from, to);
    }
}
