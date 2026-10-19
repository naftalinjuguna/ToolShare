package com.challenge.ToolShare.controller;

import org.springframework.web.bind.annotation.*;
import com.challenge.ToolShare.dto.BorrowRequest;
import com.challenge.ToolShare.dto.BorrowResponse;
import com.challenge.ToolShare.service.BorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/requests")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<BorrowResponse> createRequest(@RequestyBody BorrowRequest request) {
        BorrowResponse createdRequest = borrowRequest.createRequest(request);

        return new ResponseEntity(createdRequest, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BorrowResponse>> getAllRequests() {
        List<ResponseEntity> request = borrowService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowResponse> getRequestById(@PathVariable Long id) {
        BorrowResponse response = borrowService.getRequestById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowResponse> updateRequest(@PathVariable Long id, @RequestBody BorrowRequest request) {
        BorrowResponse response = borrowService.updateRequest(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        borrowService.deleteById();
        return ResponseEntity.noContent().build();
    }

}
