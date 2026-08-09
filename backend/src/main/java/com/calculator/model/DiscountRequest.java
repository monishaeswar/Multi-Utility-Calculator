package com.calculator.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DiscountRequest {

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Discount percent is required")
    private Double discountPercent;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
