package com.calculator.controller;

import com.calculator.model.BasicRequest;
import com.calculator.model.Response;
import com.calculator.service.BasicService;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/basic")
@Tag(name = "Basic Calculator", description = "Basic arithmetic operations")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Perform a basic arithmetic operation")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody BasicRequest request) {
        double result = basicService.calculate(request);
        Map<String, Object> resultMap = Map.of("result", result);

        historyService.save("BASIC",
                String.format("{\"a\":%s,\"b\":%s,\"operation\":\"%s\"}", request.getA(), request.getB(), request.getOperation()),
                String.format("{\"result\":%s}", result));

        return Response.ok(resultMap);
    }
}
