package com.calculator.controller;

import com.calculator.model.GSTRequest;
import com.calculator.model.Response;
import com.calculator.service.GSTService;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/gst")
@CrossOrigin(origins = "*")
@Tag(name = "GST Calculator", description = "Add or remove GST from an amount")
public class GSTController {

    @Autowired
    private GSTService gstService;

    @Autowired
    private HistoryService historyService;

    @PostMapping("/calculate")
    @Operation(summary = "Add or remove GST at a given rate")
    public Response<Map<String, Object>> calculate(@Valid @RequestBody GSTRequest request) {
        Map<String, Object> result = gstService.calculate(request);

        historyService.save("GST",
                String.format("{\"amount\":%s,\"rate\":%s,\"mode\":\"%s\"}",
                        request.getAmount(), request.getRate(), request.getMode()),
                result.toString());

        return Response.ok(result);
    }
}
