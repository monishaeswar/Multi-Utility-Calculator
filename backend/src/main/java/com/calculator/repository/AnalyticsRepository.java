package com.calculator.repository;

import com.calculator.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnalyticsRepository extends JpaRepository<Calculation, Long> {

    @Query("""
        SELECT c.calculatorType, COUNT(c)
        FROM Calculation c
        GROUP BY c.calculatorType
        ORDER BY COUNT(c) DESC
    """)
    List<Object[]> countByCalculatorType();

    @Query("""
        SELECT COUNT(c)
        FROM Calculation c
    """)
    long countTotalCalculations();
}