package com.challenge.ToolShare.entity;

import com.challenge.ToolShare.entity.Tool;
import com.challenge.ToolShare.entity.User;
import com.challenge.ToolShare.enums.BorrowStatus;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "borrow_requests")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = tool_id, nullable = false)
    private Tool tool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = borrower_id, nullable = false)
    private User borrower;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BorrowStatus status;

    public Borrow() {}

    public Borrow(Long id, Tool tool, User borrower, LocalDate startDate, LocalDate endDate, BorrowStatus status) {
        this.id = id;
        this.tool = tool;
        this.borrower = borrower;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId(){
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

    public User getBorrower(){
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

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }
}
