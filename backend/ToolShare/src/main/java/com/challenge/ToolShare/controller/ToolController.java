package com.challenge.ToolShare.controller;

import org.springframework.web.bind.annotation.*;
import com.challenge.ToolShare.dto.ToolRequest;
import com.challenge.ToolShare.dto.ToolResponse;
import com.challenge.ToolShare.service.ToolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    public ResponseEntity<ToolResponse> createTool(@RequestBody ToolRequest request) {
        ToolResponse createdTool = toolService.createTool(request);
        return new ResponseEntity(createdTool, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToolResponse>> getAllTools() {
        List<ToolResponse> tools = toolService.getAllTools();
        return ResponseEntity.ok(tools);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolResponse> getToolById(@PathVariable Long id) {
        ToolResponse tool = toolService.getToolById(id);
        return ResponseEntity.ok(tool);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToolResponse> updateTool(@PathVariable Long id, @RequestBody ToolRequest request) {
        ToolResponse updatedTool = toolService.updateTool(id, request);
        return ResponseEntity.ok(updatedTool);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        toolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
