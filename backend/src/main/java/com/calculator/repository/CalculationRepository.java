package com.calculator.repository;

import com.calculator.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {

    List<Calculation> findByCalculatorTypeOrderByCreatedAtDesc(String calculatorType);

    List<Calculation> findAllByOrderByCreatedAtDesc();

    void deleteByCalculatorType(@Param("calculatorType") String calculatorType);
}
