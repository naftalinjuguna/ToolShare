package com.challenge.ToolShare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.ToolShare.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
