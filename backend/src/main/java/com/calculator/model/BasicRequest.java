package com.calculator.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BasicRequest {

    @NotNull(message = "First operand 'a' is required")
    private Double a;

    @NotNull(message = "Second operand 'b' is required")
    private Double b;

    @NotBlank(message = "Operation is required (ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULUS, POWER)")
    private String operation;

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
