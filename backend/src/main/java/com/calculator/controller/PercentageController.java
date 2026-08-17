package com.calculator.controller;

import com.calculator.model.PercentageRequest;
import com.calculator.model.Response;
import com.calculator.service.HistoryService;
import com.calculator.service.PercentageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/percentage")
@CrossOrigin(origins = "*")
@Tag(name = "Percentage Calculator", description = "Percentage of value, percentage change, and reverse percentage")
public class PercentageController {

    @Autowired
    private PercentageService percentageService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Perform a percentage calculation")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody PercentageRequest request) {
        Map<String, Object> result = percentageService.calculate(request);

        historyService.save("PERCENTAGE",
                String.format("{\"value\":%s,\"percent\":%s,\"mode\":\"%s\"}",
                        request.getValue(), request.getPercent(), request.getMode()),
                result.toString());

        return Response.ok(result);
    }
}
