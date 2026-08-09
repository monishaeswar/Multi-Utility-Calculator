package com.calculator.service;

import com.calculator.model.BasicRequest;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BasicService {

    public double calculate(BasicRequest request) {
        double a = request.getA();
        double b = request.getB();
        String op = request.getOperation() == null ? "" : request.getOperation().toUpperCase(Locale.ROOT);

        return switch (op) {
            case "ADD" -> a + b;
            case "SUBTRACT" -> a - b;
            case "MULTIPLY" -> a * b;
            case "DIVIDE" -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield a / b;
            }
            case "MODULUS" -> {
                if (b == 0) {
                    throw new ArithmeticException("Modulus by zero is not allowed");
                }
                yield a % b;
            }
            case "POWER" -> Math.pow(a, b);
            default -> throw new IllegalArgumentException(
                    "Unsupported operation: " + request.getOperation() +
                    ". Supported: ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULUS, POWER");
        };
    }
}
