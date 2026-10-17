package com.challenge.ToolShare.service;

import org.springframework.stereotype.Service;

import com.challenge.ToolShare.dto.ToolRequest;
import com.challenge.ToolShare.dto.ToolResponse;
import com.challenge.ToolShare.entity.Tool;
import com.challenge.ToolShare.repository.ToolRepository;

import java.util.List;
import java.util.stream.Collectors;

import com.challenge.ToolShare.dto.ToolResponse;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public ToolResponse createTool(ToolRequest request){
        Tool tool = new Tool();
        
        tool.setName(request.getName());
        tool.setDescription(request.getDescription());
        tool.setCategory(request.getCategory());
        tool.setDailyRate(request.getDailyRate());
        tool.setOwner(request.getOwner());
        tool.setAvailable(request.getAvailable());

        Tool savedTool = toolRepository.save(tool);
        return mapToResponse(savedTool);
    }

    public List<ToolResponse> getAllTools() {
        List<Tool> tools = toolRepository.findAll();
        return tools.stream().map(this::mapToResponse).collect(Collectors.toList());                    
    }

    public ToolResponse getToolById(Long id) {
        Tool tool = toolRepository.findById(id).orElseThrow(() -> new RuntimeException("Tool not found with id:" +id));

        return mapToResponse(tool);
    }

    public ToolResponse updateTool(Long id, ToolRequest request) {
        Tool existingTool = toolRepository.findById(id).orElseThrow(() -> new RuntimeException("Tool not found with id:" +id));

        existingTool.setName(request.getName());
        existingTool.setDescription(request.getDescription());
        existingTool.setCategory(request.getCategory());
        existingTool.setDailyRate(request.getDailyRate());
        existingTool.setOwner(request.getOwner());
        existingTool.setAvailable(request.getAvailable());

        Tool updatedTool = toolRepository.save(existingTool);

        return mapToResponse(updatedTool);

    }

    public void deleteById(Long id) {
        if (!toolRepository.existsById(id)) {
            throw new RuntimeException("Tool not found with id:" +id);
        }

        toolRepository.deleteById(id);
    }

    public ToolResponse mapToResponse(Tool tool) {
        ToolResponse response = new ToolResponse();

        response.setId(tool.getId());
        response.setName(tool.getName());
        response.setDescription(tool.getDescription());
        response.setCategory(tool.getCategory());
        response.setDailyRate(tool.getDailyRate());
        response.setOwner(tool.getOwner());
        response.setAvailable(tool.getAvailable());

        return response;

    }

}
