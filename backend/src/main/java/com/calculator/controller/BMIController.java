package com.calculator.controller;

import com.calculator.model.BMIRequest;
import com.calculator.model.Response;
import com.calculator.service.BMIService;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/bmi")
@Tag(name = "BMI Calculator", description = "Body Mass Index calculation")
public class BMIController {

    @Autowired
    private BMIService bmiService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate BMI and category from height and weight")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody BMIRequest request) {
        Map<String, Object> result = bmiService.calculate(request);

        historyService.save("BMI",
                String.format("{\"heightCm\":%s,\"weightKg\":%s}", request.getHeightCm(), request.getWeightKg()),
                result.toString());

        return Response.ok(result);
    }
}
