package com.calculator.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PercentageRequest {

    @NotNull(message = "Value is required")
    private Double value;

    @NotNull(message = "Percent is required")
    private Double percent;

    /** OF (x% of value), CHANGE (percentage change from value to percent-as-newValue), IS_WHAT_PERCENT */
    @NotBlank(message = "Mode is required")
    private String mode;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
