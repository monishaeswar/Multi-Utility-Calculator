package com.calculator.controller;

import com.calculator.model.AgeRequest;
import com.calculator.model.Response;
import com.calculator.service.AgeService;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/age")
@CrossOrigin(origins = "*")
@Tag(name = "Age Calculator", description = "Calculate exact age from date of birth")
public class AgeController {

    @Autowired
    private AgeService ageService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate age in years, months, and days")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody AgeRequest request) {
        Map<String, Object> result = ageService.calculate(request);

        historyService.save("AGE",
                String.format("{\"dob\":\"%s\"}", request.getDob()),
                result.toString());

        return Response.ok(result);
    }
}
