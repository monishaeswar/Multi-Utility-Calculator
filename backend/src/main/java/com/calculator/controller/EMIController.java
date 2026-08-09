package com.calculator.controller;

import com.calculator.model.EMIRequest;
import com.calculator.model.Response;
import com.calculator.service.EMIService;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/emi")
@Tag(name = "EMI Calculator", description = "Loan EMI calculation")
public class EMIController {

    @Autowired
    private EMIService emiService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate loan EMI, total interest, and total payment")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody EMIRequest request) {
        Map<String, Object> result = emiService.calculate(request);

        historyService.save("EMI",
                String.format("{\"principal\":%s,\"rateAnnual\":%s,\"tenureMonths\":%s}",
                        request.getPrincipal(), request.getRateAnnual(), request.getTenureMonths()),
                result.toString());

        return Response.ok(result);
    }
}
