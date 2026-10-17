package com.challenge.ToolShare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.ToolShare.entity.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long> {

}
