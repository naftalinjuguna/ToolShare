package com.challenge.ToolShare.service;

import org.springframework.stereotype.Service;
import com.challenge.ToolShare.dto.BorrowResponse;
import com.challenge.ToolShare.dto.BorrowRequest;
import com.challenge.ToolShare.entity.Borrow;
import com.challenge.ToolShare.repository.BorrowRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public BorrowResponse createRequest(BorrowRequest rquest) {
        Borrow borrow = new Borrow();

        borrow.setTool(request.getTool());
        borrow.setBorrower(request.getBorrower());
        borrow.setStartDate(request.getStartDate());
        borrow.setEndDate(request.getEndDate());
        borrow.setStatus(request.getStatus());

        Borrow savedRequest = borrowRepository.save(borrow);

        return mapToResponse(savedRequest);
    }

    public List<BorrowRequest> getAllRequests() {
        List<BorrowRequest> requests = borrowRepository.findAll();
        return requests.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public BorrowResponse getRequestById(Long id) {
        Borrow request = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Request not found with id:" +id));

        return mapToReponse(request);
    }

    public BorrowResponse updateRequest(Long id, BorrowRequest request) {
        Borrow existingRequest = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Rquest not found with id:" +id));

        existingRequest.setTool(request.getTool());
        existingRequest.setBorrower(request.getBorrower());
        existingRequest.setStartDate(request.getStartDate());
        existingRequest.setEndDate(request.getEndDate());
        existingRequest.setStatus(request.getStatus());

        Borrow updatedRequest = borrowRepository.save(existingRequest);

        return mapToResponse(updatedRequest);
    }

    public void deleteById(Long id) {
        if (!borrowRepository.existsById(id)) {
            throw new RuntimeException("Borrow request not found with id:" +id);
        }

        return borrowRepository.deleteById(id);
    }

    public BorrowResponse mapToResponse(Borrow borrow) {
        BorrrowResponse response = new BorrowResponse();

        response.setId(borrow.getId());
        response.setTool(borrow.getTool());
        response.setBorrower(borrow.getBorrower());
        response.setStartDate(borrow.getStartDate());
        response.setEndDate(borrow.getEndDate());
        response.setStatus(borrow.getStatus());

        return response;
    }

}
