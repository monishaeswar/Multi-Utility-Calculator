package com.calculator.controller;

import com.calculator.model.DiscountRequest;
import com.calculator.model.Response;
import com.calculator.service.DiscountService;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/discount")
@CrossOrigin(origins = "*")
@Tag(name = "Discount Calculator", description = "Final price and savings after a discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Calculate final price after a discount")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody DiscountRequest request) {
        Map<String, Object> result = discountService.calculate(request);

        historyService.save("DISCOUNT",
                String.format("{\"price\":%s,\"discountPercent\":%s}", request.getPrice(), request.getDiscountPercent()),
                result.toString());

        return Response.ok(result);
    }
}
