package com.calculator.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BMIRequest {

    @NotNull(message = "Height (cm) is required")
    @Positive(message = "Height must be positive")
    private Double heightCm;

    @NotNull(message = "Weight (kg) is required")
    @Positive(message = "Weight must be positive")
    private Double weightKg;

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }
}
