package com.challenge.ToolShare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.ToolShare.entity.Borrow; 

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
