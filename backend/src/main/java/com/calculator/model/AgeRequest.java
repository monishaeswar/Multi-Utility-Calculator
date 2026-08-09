package com.calculator.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AgeRequest {

    @NotNull(message = "Date of birth is required (format: yyyy-MM-dd)")
    private LocalDate dob;

    /** Optional: calculate age as of this date instead of today. */
    private LocalDate asOf;

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getAsOf() {
        return asOf;
    }

    public void setAsOf(LocalDate asOf) {
        this.asOf = asOf;
    }
}
