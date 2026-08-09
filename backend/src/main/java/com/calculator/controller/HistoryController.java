package com.calculator.controller;

import com.calculator.model.Calculation;
import com.calculator.model.Response;
import com.calculator.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@Tag(name = "History", description = "View and manage calculation history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    @Operation(summary = "Get all calculation history, optionally filtered by type")
    public Response<List<Calculation>> getHistory(
            @RequestParam(required = false) String type) {
        List<Calculation> history = (type == null || type.isBlank())
                ? historyService.getAll()
                : historyService.getByType(type);
        return Response.ok(history);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a single history entry")
    public Response<Void> deleteEntry(@PathVariable Long id) {
        historyService.deleteById(id);
        return Response.ok(null);
    }

    @DeleteMapping
    @Operation(summary = "Clear all calculation history")
    public Response<Void> clearHistory() {
        historyService.clearAll();
        return Response.ok(null);
    }
}
