package com.challenge.ToolShare.dto;

import java.time.LocalDate;
import com.challenge.ToolShare.entity.Tool;
import com.challenge.ToolShare.entity.User;
import com.challenge.ToolShare.enums.BorrowStatus;

public class BorrowResponse {

    private Long id;
    private Tool tool;
    private User borrower;
    private LocalDate startDate;
    private LocalDate endDate;
    private BorrowStatus status;

    public BorrowRequest() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(LocalDate status) {
        this.status = status;
    }

}
