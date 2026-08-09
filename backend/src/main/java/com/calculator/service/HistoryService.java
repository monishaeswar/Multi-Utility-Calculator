package com.calculator.service;

import com.calculator.model.Calculation;
import com.calculator.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoryService {

    private final CalculationRepository repository;

    @Autowired
    public HistoryService(CalculationRepository repository) {
        this.repository = repository;
    }

    public Calculation save(String calculatorType, String inputData, String resultData) {
        Calculation calculation = new Calculation(calculatorType, inputData, resultData);
        return repository.save(calculation);
    }

    public List<Calculation> getAll() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    public List<Calculation> getByType(String calculatorType) {
        return repository.findByCalculatorTypeOrderByCreatedAtDesc(calculatorType.toUpperCase());
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("History entry not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Transactional
    public void clearAll() {
        repository.deleteAll();
    }
}
