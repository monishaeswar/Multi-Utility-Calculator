package com.calculator.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EMIRequest {

    @NotNull(message = "Principal amount is required")
    @Positive(message = "Principal must be positive")
    private Double principal;

    @NotNull(message = "Annual interest rate is required")
    @Positive(message = "Rate must be positive")
    private Double rateAnnual;

    @NotNull(message = "Tenure (months) is required")
    @Positive(message = "Tenure must be positive")
    private Integer tenureMonths;

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getRateAnnual() {
        return rateAnnual;
    }

    public void setRateAnnual(Double rateAnnual) {
        this.rateAnnual = rateAnnual;
    }

    public Integer getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths) {
        this.tenureMonths = tenureMonths;
    }
}
